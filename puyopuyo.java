public class puyopuyo{
   public static void main(String [] args){
      puyopuyoMethods game = new puyopuyoMethods();

      System.out.println("In PuyoPuyo, try to match as many row values as possible (the ones nearest to the left!) to score points.\nBut be sure not to try and fill a row that already has 10 values! You will lose a turn trying to add to it!\n\n");
      game.storeNum();
      //test.moveToBoard();
      int numTurns = 30;
      for(int i = 0; i < 30; i++) {
        System.out.println("Turns left: " + numTurns);
        numTurns--;
        game.moveToBoard();
        if(i > 0)
          game.score();
        game.print();
        System.out.println("\n");
      }

      System.out.println("Final Score: " + game.getScore());
      if(game.getScore() >= 30)
        System.out.println("You're a PuyoPuyo pro!");
      else if(game.getScore() >= 20 && game.getScore() < 30)
        System.out.println("You're pretty good.");
      else if(game.getScore() >= 10 && game.getScore() < 20)
        System.out.println("You're not too bad.");
      else
        System.out.println("Pretty low score, get better.");

   }
}
