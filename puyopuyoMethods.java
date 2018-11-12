import java.util.Scanner;
import java.util.Random;

public class puyopuyoMethods{
   private final int SIZE = 30;
   private final int BOARD_SIZE = 10;
   private int [] stackA = new int [BOARD_SIZE];
   private int [] temp_stackA = new int[BOARD_SIZE];
   private int [] stackB = new int[BOARD_SIZE];
   private int [] temp_stackB = new int[BOARD_SIZE];
   private int [] stackC = new int[BOARD_SIZE];
   private int [] temp_stackC = new int[BOARD_SIZE];
   private int [] queue = new int [SIZE];
   private int stackA_top = 0;
   private int temp_stackA_top = 0;
   private int stackB_top = 0;
   private int temp_stackB_top = 0;
   private int stackC_top = 0;
   private int temp_stackC_top = 0;
   private int frontQ = 0;
   private int rearQ = 0;
   private int score = 0;
   private Scanner kb = new Scanner(System.in);

   public puyopuyoMethods(){}

   public void storeNum(){
     Random rand = new Random();
      for(int i = 0; i < SIZE; i++){
         queue[i] = rand.nextInt(9) + 1;
         rearQ++;
      }
   }

   public void moveToBoard(){
     switch(whichColumn().toUpperCase()) {
       case "A": if(stackA_top < 10) {
                 stackA[stackA_top] = queue[frontQ];
                 //System.out.println(stackA[stackA_top]);
                 frontQ++;
                 stackA_top++;
               }
                 break;

       case "B": if(stackB_top < 10) {
                 stackB[stackB_top] = queue[frontQ];
                 //System.out.println(stackB[stackB_top]);
                 frontQ++;
                 stackB_top++;
               }
                 break;

       case "C":
                 if(stackC_top < 10) {
                 stackC[stackC_top] = queue[frontQ];
                 //System.out.println(stackC[stackC_top]);
                 frontQ++;
                 stackC_top++;
               }
                 break;

       default: System.out.println("Invalid");
     }
   }

   public String whichColumn() {
     System.out.println("The number " + queue[frontQ] + " is falling! What column will it land in? ('A', 'B', 'C')");
     String n = "";
     n = kb.nextLine();
     if(n.equalsIgnoreCase("A") || n.equalsIgnoreCase("B") || n.equalsIgnoreCase("C"))
      return n;
     else {
       System.out.println("Invalid input, try again.");
       return whichColumn();
     }
   }

  public void score() {
    if(stackA_top > 0 && stackB_top > 0 && stackC_top > 0) {
    if((stackA[stackA_top - 1] == stackB[stackB_top - 1] && stackC[stackC_top - 1] == stackB[stackB_top - 1]) && (stackA[stackA_top - 1] != 0 && stackC[stackC_top - 1] != 0 && stackB[stackB_top - 1] !=0)) {
      score+=10;
      System.out.println("All three rows match! +10");
    }
    else if((stackA[stackA_top - 1] == stackB[stackB_top - 1] || stackC[stackC_top - 1] == stackB[stackB_top - 1]) && (stackA[stackA_top - 1] != 0 && stackC[stackC_top - 1] != 0 && stackB[stackB_top - 1] !=0)) {
      score+= 5;
      System.out.println("Two rows match! +5");
    }
}
  }

  public void printStack(int[] perm, int[] temp, int pTop, int tTop, String row) {
    tTop = 0;
    System.out.print(row + "\t");
    for(int i = pTop - 1; i >= 0; i--) {
      temp[i] = perm[i];
      pTop--;
      tTop++;
      }
      //System.out.println(temp_stackA[temp_stackA_top - 1]);
      for(int j = tTop - 1; j >= 0; j--) {
         System.out.print(temp[j] + "\t");
         perm[j] = temp[j];
         tTop--;
         pTop++;
      }
      System.out.println();


/*
      if(stackB_top >= 0) {
        System.out.print(stackA[i] + "\t");
        temp_stackB[i] = stackB[i];
        stackB_top--;
        temp_stackB_top++;
      }

      if(stackC_top >= 0) {
        System.out.println(stackC[i]);
        temp_stackC[i] = stackC[i];
        stackC_top--;
        temp_stackC_top++;
      }

      System.out.println("Current Score: " + score);
    }
    */
  }

public void print() {
  printStack(stackA, temp_stackA, stackA_top, temp_stackA_top, "A");
  printStack(stackB, temp_stackB, stackB_top, temp_stackB_top, "B");
  printStack(stackC, temp_stackC, stackC_top, temp_stackC_top, "C");
  System.out.println("Current Score: " + score);


}

public int getScore() {
  return score;
}

}
