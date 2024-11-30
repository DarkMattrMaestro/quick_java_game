package com.darkmattrmaestro;
public class Utils {
  /**
   * 
   * @param str
   * @return First integer found or -1 if none are found
   */
  public static Integer firstInt(String str) {
    int i = 0;
    for (; i < str.length() && !Character.isDigit(str.charAt(i)); i++) {}

    if (str.length() <= i) { return -1; }

    int j = i;
    for (; j < str.length() && Character.isDigit(str.charAt(j)); j++) {}

    return Integer.parseInt(str.substring(i, j));
  }
}