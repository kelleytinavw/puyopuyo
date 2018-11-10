import java.util.Scanner;
import java.Math.Random;

public class puyopuyoMethods{
   private final int SIZE = 30;
   private final int BOARD_SIZE = 10;
   private int [][] boardStack = new int [BOARD_SIZE][BOARD_SIZE];
   private int [] stackA = new int [BOARD_SIZE];
   private int [] stackB = new int[BOARD_SIZE];
   private int [] stackC = new int[BOARD_SIZE];
   private int [] queue = new int [SIZE];
   private int stackA_top = 0;
   private int stackB_top = 0;
   private int stackC_top = 0;
   private int frontQ = 0;
   private int rearQ = 0;
   private int score = 0;
   private Scanner kb = new Scanner(System.in);

   public puyopuyoMethods(){}

   public void storeNum(){
     Random rand = new Random();
      for(int i = 0; i < SIZE; i++){
         queue[i] = rand.nextInt(10) + 1;
         rearQ++;
      }
   }

   public void moveToBoard(){
     switch(whichColumn.equalsIgnoreCase()) {
       case "A": stackA[stackA_top] = queue[frontQ];
                 frontQ++;
                 stackA_top++;
                 break;
       case "B": stackB[stackB_top] = queue[frontQ];
                 frontQ++;
                 stackB_top++;
                 break;
       case "C": stackB[stackC_top] = queue[frontQ];
                 frontQ++;
                 stackC_top++;
                 break;
     }
   }

   public String whichColumn() {
     System.out.println("The number" + queue[rearQ] + "is falling! What column will it land in? ('A', 'B', 'C')");
     String n = "";
     n = kb.next();
     if(n.equalsIgnoreCase("A") || ("B") || ("C"))
      return n;
     else {
       System.out.println("Invalid input, try again.");
       whichColumn();
     }
   }

  public void score() {
    if(stackA[stackA_top] == stackB[stackB_top] && stackC[stackC_top] == stackB[stackB_top])
      score+=10;
    else if(stackA[stackA_top] == stackB[stackB_top] || stackC[stackC_top] == stackB[stackB_top])
      score+= 5;

  }


}
