public class puyopuyoMethods{
   private int SIZE = 10;
   private int [][] boardStack = new int [SIZE][SIZE];
   private int [] stack = new int [SIZE];
   private int [] queue = new int [SIZE];
   private int stack_top = 0;
   private int frontQ = 0;
   private int rearQ = 0;
   private int count = 0;
   
   public void storeNum(){
      for(int i = 0; i < SIZE; i++){
         stack[i] = i+2;
         stack[i+1] = stack[i];
         stack_top++;  
      }
   }
   
   public void createBoard(){
      
   }
}