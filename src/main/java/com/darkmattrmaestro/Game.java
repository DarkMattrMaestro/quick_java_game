package com.darkmattrmaestro;

import com.darkmattrmaestro.Langs.Locales;

public class Game {
  Player player;
  Langs langs;
  int turn;

  /**
   * Initialize properties for a valid initial game state.
   */
  Game() {
    this.player = new Player();
    this.turn = 1;
  }

  /**
   * Start the game.
   * 
   * @return 0: regular termination; -1: error prompted premature termination; 9: player death
   * @throws Exception 
   */
  public int start() throws Exception {
    int localeRes = localeSelection();
    if (localeRes != 0) { return localeRes; }

    for (; player.health > 0 && turn < Integer.MAX_VALUE - 64; turn++) {
      int res = loop();

      if (res == -1) { return -1; }
    }

    if (player.health <= 0) {
      Display.infoScreen(langs.getLocalizedTexts("DeathMSG"));

      return 9;
    }

    return 0;
  }

  private int localeSelection() throws Exception {
    int res = Display.prompt("Chose your language | Choisissez votre langue", "English", "Français");

    if (res == 0) {
      langs = new Langs(Locales.en);
      return 0;
    }

    if (res == 1) {
      langs = new Langs(Locales.fr);
      return 0;
    }

    return -1;
  }

  public int loop() throws Exception {
    Display.infoScreen(langs.getLocalizedText("CurrentStats"), "", langs.getLocalizedText("Turn:") + " " + turn, langs.getLocalizedText("Health:") + " " + player.health);

    int res = Display.prompt(langs.getLocalizedText("DoWhat"), langs.getLocalizedTexts("DoWhatPrompts"));

    if (res == 0) { return 0; }

    if (res == 1) {
      player.health -= player.recoil;
      return 0;
    }

    return -1;
  }
}
