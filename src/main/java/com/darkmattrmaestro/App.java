package com.darkmattrmaestro;
public class App {
    public static void main(String[] args) throws Exception {
        if (!GameSlot.hasGame()) {
            GameSlot.initGame();
        }

        int res = GameSlot.start();

        if (res == -1) {
            throw new Exception("The game ended abnormally.");
        }
    }
}
