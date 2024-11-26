package listo.textprocessor.controller;

import listo.textprocessor.model.RegexObject;
import java.util.HashMap;

public class DataManager {
    private final HashMap<Integer, RegexObject> collectionsMap = new HashMap<>();

    public void addCollection(String title, String regexPattern, String inputText, String replaceText) {
        RegexObject value = new RegexObject(title,inputText, regexPattern, replaceText);
        int key = value.hashCode();
        collectionsMap.put(key, value);
    }

    public void deleteCollection(int key) {
        collectionsMap.remove(key);
    }

    public RegexObject getCollection(int key) {
        return collectionsMap.get(key);
    }

    public HashMap<Integer, RegexObject> getAllCollections() {
        return new HashMap<>(collectionsMap);
    }
}

