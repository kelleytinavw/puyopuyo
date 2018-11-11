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
   private String keep = "";
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
      }
      return isFull;
   }
   
   public boolean checkFullB(){
      boolean isFull = false;
      if(stackB_top == BOARD_SIZE){
         System.out.println("Stack B is full choode another stack:");
         isFull = true;
      }
      return isFull;
   }

   public boolean checkFullC(){
      boolean isFull = false;
      if(stackC_top == BOARD_SIZE){
         System.out.println("Stack C is full choode another stack:");
         isFull = true;
      }
      return isFull;
   }
   
   public void moveToBoard(String x){
     switch(x){
       case "A": 
                 if(checkFullA() != false){
                     whichColumn();
                     break;
                 }
                 stackA[stackA_top] = queue[frontQ];
                 frontQ++;
                 stackA_top++;
                 break;
       case "B": 
                  if(checkFullB() != false){
                     whichColumn();
                     break;
                 }
                 stackB[stackB_top] = queue[frontQ];
                 frontQ++;
                 stackB_top++;
                 break;
       case "C": 
                 if(checkFullC() != false){
                     whichColumn();
                     break;
                 }
                 stackB[stackC_top] = queue[frontQ];
                 frontQ++;
                 stackC_top++;
                 break;
     }
   }

   public void whichColumn(){
     String n = "";
     System.out.println("The number " + queue[frontQ] + " is falling! What column will it land in? ('A', 'B', 'C')");
     n = kb.next();    
     if(!((n.equalsIgnoreCase("A")) || (n.equalsIgnoreCase("B")) || (n.equalsIgnoreCase("C")))){
       System.out.println("Invalid input, try again.");
       whichColumn();
     }
     frontQ++;
     moveToBoard(n);
     keep = n;
   }

//   public void score() {
//     if(stackA[stackA_top-1] == stackB[stackA_top-1] && stackC[stackA_top-1] == stackB[stackA_top-1]){
//       score+=10;
//     }else if(stackA[stackA_top-1] == stackB[stackA_top-1] || stackC[stackC_top-1] == stackB[stackC_top-1]){
//       score+= 5;
//     }
//     System.out.println("The score is: " + score);
//   }
  
  public void printBoard(){
     if(keep.equalsIgnoreCase("A")){
         System.out.println(stackA[stackA_top] + " " + stackB[stackA_top] + " " + stackC[stackA_top]);
         stackA_top--;
         whichColumn();
     }else if(keep.equalsIgnoreCase("B")){
         System.out.println(stackA[stackB_top] + " " + stackB[stackB_top] + " " + stackC[stackB_top]);
         stackB_top--;
         whichColumn();
     }else if(keep.equalsIgnoreCase("C")){
         System.out.println(stackA[stackC_top] + " " + stackB[stackC_top] + " " + stackC[stackC_top]);
         stackC_top--;
         whichColumn();
     }else{
         System.out.println(stackA[stackA_top] + " " + stackB[stackB_top] + " " + stackC[stackC_top]);
     }
  } 
  
}