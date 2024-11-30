package com.darkmattrmaestro;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Langs {
  private static final String LOCALES_LOCATION = "src/main/ressources/locales/";

  public enum Locales {
    en,
    fr
  }

  private JSONObject chosenLocaleObject;

  Langs(Locales locale) throws IOException {
    this.chosenLocaleObject = parse(locale);
  }

  private static JSONObject parse(Locales locale) throws IOException {
    File localeFile = new File(LOCALES_LOCATION + locale.toString() + ".json");
    FileReader reader = new FileReader(localeFile, StandardCharsets.UTF_8);
    
    JSONObject langObject = new JSONObject(new JSONTokener(reader));

    return langObject;
  }

  /**
   * @see See {@link Langs#getLocalizedTexts(String)} for multiple lines
   * 
   * @param key The localization key, found in the JSON
   * @return The Translation in the chosen locale
   */
  public String getLocalizedText(String key) {
    return chosenLocaleObject.getString(key);
  }

  /**
   * 
   * @see See {@link Langs#getLocalizedText(String)} for an individual line
   * 
   * @param key The localization key, found in the JSON
   * @return The Translations in the chosen locale
   */
  public String[] getLocalizedTexts(String key) {
    JSONArray msgs = chosenLocaleObject.getJSONArray(key);

    List<String> tempList = new ArrayList<String>();
    for (int i=0; i < msgs.length(); i++) {
      tempList.add(msgs.getString(i));
    }

    return tempList.toArray(new String[msgs.length()]);
  }
}
