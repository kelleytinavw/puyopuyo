
import java.util.Scanner;

public class puyopuyoMethods{
   private final int SIZE = 20;
   private final int BOARD_SIZE
   private int [][] boardStack = new int [BOARD_SIZE][BOARD_SIZE];
   private int [] stack = new int [SIZE];
   private int [] queue = new int [SIZE];
   private int stack_top = 0;
   private int frontQ = 0;
   private int rearQ = 0;
   private int count = 0;
   Scanner kb = new Scanner(System.in);

   public void storeNum(){
      int num = 0;
      System.out.println("Enter 20 numbers ranging from 1-9:");
      for(int i = 0; i < SIZE; i++){
         num = kb.nextInt();
         if((num < 1) || (num > 9)){
            System.out.println("Enter a number ranging from 1-9:");
            num = kb.nextInt();
         }
         stack[i] = num;
         stack_top++;
      }
   }

//    public void createBoard(){
//
//    }

   public void moveToBoard(){
      int positionX = 0;
      int positionY = 0;
       for(int i = stack_top -1; i >= 0; i--){
          for(int j = stack_top -1; j >= 0; j++){
               boardStack[positionX][positionY] = stack[i];
               boardStack[positionY][positionX] = stack[j-2];
               if(boardStack[positionX][positionY] == boardStack[positionY][positionX]){
                  
               }
               positionX++;
               positionY++;      
               stack_top-= 2;
          }
       }
   }


}
