/******************************************************************************
* Omar Ramirez
* CSC 103 Project 3
*
* The class Queen allows for the creation of a Queen object, determining
* whether Queen object is in conflict with other Queen objects, and printing
* out the location of the Queen.
******************************************************************************/

public class Queen{
   
   //Invariant of the Queen class:
   //   1. The row in which a given Queen will be in, is in the instance variable row.
   //   2. The column in which a given Queen will be in, is in the instance variable column.
   private int row;
   private int column;
   
   /**
   * Initialize a Queen object with initial
   * row and column values set to 0.
   * <dt><b>Param-none:</b><dd>
   * <dt><b>Postcondition:</b><dd>
   *   New Queen object has been created with row 
   *   and column values set to 0.
   **/  
   public Queen(){
      row = 0;
      column = 0;
   }

   
   /**
   * Initialize a Queen object with given inputted values for
   * the row and column variables.
   * <dt><b>Param-none:</b><dd>
   * <dt><b>Postcondition:</b><dd>
   *   New Queen object has been created with the row and column
   *   variables set to passed in values.
   **/  
   public Queen(int rows, int col){
      row = rows;
      column = col;
   }
   
   /**
   * Sets the values of the variables row and column
   * for the Queen object
   * <dt><b>Param- rows, col:</b><dd>
   *  The values that will be set for the Queen object
   * <dt><b>Postcondition:</b><dd>
   *   The row and column value for the Queen object has been
   *   set to the given values. 
   **/  
   public void setValues(int rows, int col){
      row = rows;
      column = col;
   }   
   
   /**
   * Sets the values of the variable column
   * for the Queen object
   * <dt><b>Param- rows, col:</b><dd>
   *  The column value that will be set for the Queen object
   * <dt><b>Postcondition:</b><dd>
   *   The column value for the Queen object has been
   *   set to the given value. 
   **/    
   public void setColumn(int col){
      column = col;
   }
   
   /**
   * Gets the value of the variable column
   * for the Queen object
   * <dt><b>Param- none:</b><dd>
   * <dt><b>Postcondition:</b><dd>
   *   The column value for the Queen object has been
   *   returned. 
   **/      
   public int getColumn(){
      return column;
   }
   
   /**
   * Determines if a Queen object is in conflict with a passed
   * in Queen object by returning a boolea. Objects are in conflict 
   * if they are on the same row, column, or diagonal.
   * <dt><b>Param- second:</b><dd>
   *  The Queen object being passed in.
   * <dt><b>Postcondition:</b><dd>
   *  Returned a boolean based on whether or not the passed in Queen
   *  object was conflicting   
   **/  

   public boolean conflict(Queen second){
      if(row == second.row || column == second.column){
         return true;
                          
      } else if ((row-second.row)/(column-second.column) == 1 || (row-second.row)/(column-second.column) == -1){
         return true;      
      
      } else {
         return false;
      }         
   }
   
   /**
   * Creates a string giving the location of a Queen based 
   * on the values of the row and column.
   * <dt><b>Param - none</b><dd>
   * <dt><b>Postcondition:</b><dd>
   *    The location of the Queen has been printed.
   * <dt><b>Exception IllegalStateException:</b><dd>
   *    Indicates Queen is not on the board.
   **/ 
   public String toString(){
      if(row == 0 || column == 0){
         throw new IllegalStateException("Queen is not on the board. ToString may not be called.");
      } 
         
      return "row = " + row + ", column = " + column;   
   }
   
} // end of class Queen
   
   
