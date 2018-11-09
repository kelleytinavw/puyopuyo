
import java.util.Scanner;

public class puyopuyoMethods{
   private final int SIZE = 20;
   private final int BOARD_SIZE = 10;
   private int [][] boardStack = new int [BOARD_SIZE][BOARD_SIZE];
   private int [] stack = new int [SIZE];
   private int [] queue = new int [SIZE];
   private int stack_top = 0;
   private int frontQ = 0;
   private int rearQ = 0;
   private int count = 0;
   Scanner kb = new Scanner(System.in);

   public puyopuyoMethods(){}

   public void storeNum(){
      int num = 0;
      System.out.println("Enter 20 numbers ranging from 1-9:");
      for(int i = 0; i < SIZE; i++){
         stack[i] = i+2;
         stack[i+1] = stack[i] + 1;
         stack_top++;
      }
   }

   public void moveToBoard(){
      int positionX = 0;
      int positionY = 0;
       for(int i = stack_top -1; i >= 0; i--){
          for(int j = stack_top -1; j >= 0; j++){
               boardStack[positionX][positionY] = stack[i];
               boardStack[positionY][positionX] = stack[j-1];
               //having error message here trying to assign the values into the board
              //arrayIndexOutOfBoundsExeception: 10
              //at puyopuyoMethods.moveToBoard(puyopuyoMethods.java:41)
              //at puyopuyo.main(puyopuyo.java:6)
               if(boardStack[positionX][positionY] == boardStack[positionY][positionX]){
                  queue[rearQ] = boardStack[positionX][positionY];
                  rearQ++;
                  queue[rearQ] = boardStack[positionY][positionX];
                  rearQ++;

                  positionX++;
                  positionY++;
                  if(stack_top != 1){
                     stack_top -= 2;
                  }
               }else{
                  positionX++;
                  positionY++;
                  stack_top-= 2;
               }

          }
       }

   }


}
