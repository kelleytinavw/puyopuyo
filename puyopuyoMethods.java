public class puyopuyoMethods{
   private int [][] board = new int [SIZE][SIZE];
   private final int SIZE = 10;
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

//    public void createBoard(){
//
//    }

   public void moveToBoard(){
      int positionX = 0;
      int positionY = 0;
       for(int i = stack_top -1; i >= 0; i--){
          for(int j = stack_top -1; j >= 0; j++){
               boardStack[positionX][positionY] = ;
                positionX++;      
                positionY++;
               stack_top-= 2;

          }
       }
   }


}
