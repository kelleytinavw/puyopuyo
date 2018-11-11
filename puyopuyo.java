public class puyopuyo{
   public static void main(String [] args){
      puyopuyoMethods test = new puyopuyoMethods();
      
      test.storeNum();
      for(int i = 0; i < 30; i++){
         test.whichColumn();
         test.moveToBoard();
      }
//       test.score();
    //  test.printBoard();
   }
}