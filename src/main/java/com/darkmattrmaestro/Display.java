package com.darkmattrmaestro;
import java.util.Scanner;

public class Display {
  private static Scanner scanner = new Scanner(System.in);

  private static void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }

  /**
   * 
   * @param prompts 
   * @return -1: error prompted premature termination; -5: improperly ordered code execution caused logical skips
   * @throws Exception 
   */
  public static int prompt(String message, String... prompts) throws Exception {
    if (prompts.length < 1) { throw new Exception("No prompts were provided when prompting the player."); } // Ensure the program fails if the player would be soft-locked
    if (message.length() < 1) { throw new Exception("An empty prompt message was provided."); } // Ensure the program fails if the player would be utterly confused by lack of explanation

    // Attempt to get an answer from the player
    int resInt = -5;
    for (int attempts = 1; attempts < Integer.MAX_VALUE && resInt < 0; attempts++) {
      clearScreen();

      System.out.println(message.length() > 0 ? message : "Type the index of the prompt to be chosen"); // Print message or redandantly resolve to using a default message

      int i = -1;
      for (String prompt : prompts) {
        i++;
        
        System.out.println(i + ": " + prompt);
      }

      String res = scanner.nextLine();
      resInt = Utils.firstInt(res);
    }

    return resInt;
  }

  /**
   * 
   * @param prompts 
   * @return 0: intended termination
   * @throws Exception 
   */
  public static int infoScreen(String... messages) throws Exception {
    clearScreen();

    int maxLen = 0;
    for (String message : messages) {
      if (message.length() > maxLen) { maxLen = message.length(); }
    }

    for (String message : messages) {
      int totalPadding = maxLen - message.length();
      int leftPadding = totalPadding / 2;

      System.out.println(" ".repeat(leftPadding) + message + " ".repeat(maxLen - leftPadding));
    }

    scanner.nextLine();

    return 0;
  }
}