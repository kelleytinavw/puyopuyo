import java.util.Scanner;
import java.util.Random;

public class puyopuyoMethods{
   private final int SIZE = 30;
   private final int BOARD_SIZE = 10;
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
         queue[i] = rand.nextInt(10)+1;
         rearQ++;
      }
   }
   
   public boolean checkFullA(){
      boolean isFull = false;
      if(stackA_top == BOARD_SIZE){
         System.out.println("Stack A is full choode another stack:");
         isFull = true;
         whichColumn();
      }
      return isFull;
   }
   
   public boolean checkFullB(){
      boolean isFull = false;
      if(stackB_top == BOARD_SIZE){
         System.out.println("Stack B is full choode another stack:");
         isFull = true;
         whichColumn();
      }
      return isFull;
   }

   public boolean checkFullC(){
      boolean isFull = false;
      if(stackC_top == BOARD_SIZE){
         System.out.println("Stack C is full choode another stack:");
         isFull = true;
         whichColumn();
      }
      return isFull;
   }
   
   public void moveToBoard(){
     switch(whichColumn()) {
       case "A": 
                 stackA[stackA_top] = queue[frontQ];
                 frontQ++;
                 stackA_top++;
                 break;
       case "B": 
                 stackB[stackB_top] = queue[frontQ];
                 frontQ++;
                 stackB_top++;
                 break;
       case "C": 
                 stackB[stackC_top] = queue[frontQ];
                 frontQ++;
                 stackC_top++;
                 break;
     }
   }

   public String whichColumn(){
     String n = "";
     System.out.println("The number " + queue[frontQ] + " is falling! What column will it land in? ('A', 'B', 'C')");
     n = kb.next();
     checkFullA();
     checkFullB();
     checkFullC();     
     if(!((n.equalsIgnoreCase("A")) || (n.equalsIgnoreCase("B")) || (n.equalsIgnoreCase("C")))){
       System.out.println("Invalid input, try again.");
       whichColumn();
     }
     frontQ++;
     return n;
   }

  public void score() {
    if(stackA[stackA_top-1] == stackB[stackA_top-1] && stackC[stackA_top-1] == stackB[stackA_top-1]){
      score+=10;
    }else if(stackA[stackA_top-1] == stackB[stackA_top-1] || stackC[stackC_top-1] == stackB[stackC_top-1]){
      score+= 5;
    }
    System.out.println("The score is: " + score);
  }
  
  public void printBoard(){
         if(whichColumn().equalsIgnoreCase("A")){ 
             int trackA = stackA_top;
             stackA[stackA_top] = queue[frontQ];
             for(int j = stackA_top -1; j >= 0; j--){
               System.out.println(stackA[stackA_top] + " " + stackB[stackB_top] + " " + stackC[stackC_top]);
               stackA_top--;
             }
             stackA_top = trackA;
          }
          if(whichColumn().equalsIgnoreCase("B")){
             int trackB = stackB_top;
             stackB[stackB_top] = queue[frontQ];
             for(int j = stackB_top -1; j >= 0; j--){
               System.out.println(stackA[stackA_top] + " " + stackB[stackB_top] + " " + stackC[stackC_top]);
               stackB_top--;
             }
             stackB_top = trackB;
           }
          if(whichColumn().equalsIgnoreCase("C")){ 
             int trackC = stackC_top;
             stackB[stackC_top] = queue[frontQ];
             for(int j = stackB_top -1; j >= 0; j--){
               System.out.println(stackA[stackA_top] + " " + stackB[stackB_top] + " " + stackC[stackC_top]);
               stackC_top--;
             }
             stackC_top = trackC;
         }   
  } 
  
}
