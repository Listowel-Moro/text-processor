package listo.textprocessor.controller;

import listo.textprocessor.model.RegexObject;
import java.util.HashMap;

public class DataManager {
    private final HashMap<Integer, RegexObject> dataMap = new HashMap<>();

    public void addEntry(String regexPattern, String inputText, String replaceText) {
        RegexObject value = new RegexObject(regexPattern, inputText, replaceText);
        int key = value.hashCode();
        dataMap.put(key, value);
    }

    public void updateEntry(int key, String newRegexPattern, String newInputText, String newReplaceText) {
        RegexObject regexObject = dataMap.get(key);
        regexObject.update(newRegexPattern, newInputText, newReplaceText);
        dataMap.replace(key, regexObject);
    }

    public void deleteEntry(int key) {
        dataMap.remove(key);
    }

    public RegexObject getEntry(int key) {
        return dataMap.get(key);
    }

    public HashMap<Integer, RegexObject> getAllEntries() {
        return new HashMap<>(dataMap);
    }
}

