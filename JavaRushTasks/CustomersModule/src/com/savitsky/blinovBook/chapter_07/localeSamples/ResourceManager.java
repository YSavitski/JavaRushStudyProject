package com.savitsky.blinovBook.chapter_07.localeSamples;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by esavitski on 18.04.2017.
 */
public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private final String resources = "property.text";
    private ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(resources, Locale.getDefault());
    }

    public void changeLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resources, locale);
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
