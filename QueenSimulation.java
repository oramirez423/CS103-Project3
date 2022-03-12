/*******************************************************************************
* Omar Ramirez
* CSC 103 - Project 3
* QueenSimulation will be the main driver for project 3 as it will solve the 
* n-queens problem, which is figuring out where Queen objects can be placed 
* given a n X n board. 
*******************************************************************************/

import java.util.*;

class QueenSimulation{

   public static void main(String[] args){
      //intro statement and getting the board size from the user in an attempt to solve it 
      System.out.println("Welcome to the N-Queens Solver.");   
      int size = getBoardSize();
      int col = 1, col2 = 1;
      
      // creating an array of Queen objects, which will hold 
      // as many queens as the size of the board
      Queen queens[] = new Queen[size];
      
      // creating a LinkedStack composed of Queen objects as the items in the stack
      LinkedStack<Queen> stack = new LinkedStack<Queen>();
      
      // this for loop attempts to add a Queen into the queens[] array based on the 
      // value of i     
      for(int i = 0; i < size; i++){        
         
         // this if statement is for the first queen to be given values and pushed into stack.
         if(i == 0){
            queens[i] = new Queen(i+1, 1);
            stack.push(queens[i]);
            System.out.println("Place queen at " + queens[i].toString() + " - push into stack (no conflicts, stack is empty)");
         
         // for the remaining queens to determine whether or not they can be pushed into stack.  
         } else {
            
            // this if statement is to assign the values for a queen that has been popped from the stack
            if(col2 > 1 && col2 <= size){
               System.out.println(col2);
               queens[i] = new Queen(i+1, col2);
               System.out.println("Place queen at " + queens[i].toString());
            
            // if the value of column has exceed the size, will pop the previous queen from stack
            } else if(col2 > size){
               col2 = queens[i].getColumn();
               col2++;                    
               stack.pop();
               i--;
            
            //creating a new Queen objects if no queens have been popped.
            } else {
               queens[i] = new Queen(i+1, col2);
               System.out.println("Place queen at " + queens[i].toString());
            }
            
            //this for loop is made to determine whether the created queen object will conflict with any
            //of the other queen objects already placed in the stack.               
            for(int j = 0; j < stack.size(); j++){
               
               //while loop to repeat as long as the objects are in conflict
               while(queens[i].conflict(stack.itemAt(j)) == true){
                  System.out.println(" - conflict with " + stack.itemAt(j) + " - do not push to stack");
                  
                  col = queens[i].getColumn();
                  
                  //if the items are in conflict and the column value of the object is less than size, 
                  // increase then value of the column and set the value of the column variable to the queen
                  if(col < size){
                     col++;
                     queens[i].setColumn(col);
                  
                  //else statement will be used to pop the top queen in the stack if the created queen's column value cannot be increased. 
                  } else if (col == size){
                     System.out.println("No spots available for row " + (i+1) + ", pop " + stack.itemAt(0) + " from stack and continue on row " + i);
                     col2 = queens[i].getColumn();
                     col2++;                    
                     stack.pop();
                     i--;
                     break;
                  }
               }       
            }
            
            //pushing the queens onto the stack if they don't conflict with each other 
            if(i < 4){
               stack.push(queens[i]);
               System.out.println("Place Queen at " + queens[i].toString() + " - push into stack");  
            }      
         }     
      }          
   }// end of main method 
               
   //method that will be used to get the user to input the size of the board
   public static int getBoardSize(){
      Scanner input = new Scanner(System.in);
      int boardSize = -1;
      boolean repeat = true;
      
      //while loop to make sure user enter a correct value
      //user can only enter non-negative integers.
      while(repeat == true){    
         System.out.println("What value of N for an N by N board will we be solving?");
         try{
            boardSize = input.nextInt();
            if(boardSize < 1){
               throw new Exception("Impossible! Please enter a positive value.\n");
            }
            repeat = false; 
         //catching the exceptions to make sure user inputs value within range 
         } catch (InputMismatchException e){
            System.out.println("That is outrageous! The input must be a number.\n");
            input.nextLine();
         } catch (Exception e) { 
            System.out.println(e.getMessage());
         }
      }
      //returning the size of the board user wanted
      return boardSize;
   }
}
