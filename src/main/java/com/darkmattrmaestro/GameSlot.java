package com.darkmattrmaestro;
public class GameSlot {
  static Game currentGame;

  public static Game getCurrentGame() {
    return currentGame;
  }

  public static boolean hasGame() {
    return currentGame != null;
  }

  /**
   * Initialize a new game and assing it to the primary slot.
   */
  public static void initGame() {
    currentGame = new Game();
  }

  /**
   * Start the game in the primary slot. This is a proxy for the primary game's start method.
   * 
   * @return See {@link Game#start()} for return values.
      * @throws Exception 
      */
     public static int start() throws Exception {
    return currentGame.start();
  }
}
