package listo.textprocessor.model;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class RegexObject {
    private SimpleStringProperty title;
    private SimpleStringProperty inputText;
    private SimpleStringProperty regexPattern;
    private SimpleStringProperty replaceText;

    public RegexObject(String title, String inputText, String regexPattern, String replaceText) {
        this.title = new SimpleStringProperty(title);
        this.inputText = new SimpleStringProperty(inputText);
        this.regexPattern = new SimpleStringProperty(regexPattern);
        this.replaceText = new SimpleStringProperty(replaceText);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getInputText() {
        return inputText.get();
    }

    public void setInputText(String inputText) {
        this.inputText.set(inputText);
    }

    public String getRegexPattern() {
        return regexPattern.get();
    }

    public void setRegexPattern(String regexPattern) {
        this.regexPattern.set(regexPattern);
    }

    public String getReplaceText() {
        return replaceText.get();
    }

    public void setReplaceText(String replaceText) {
        this.replaceText.set(replaceText);
    }

    @Override
    public String toString() {
        return getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegexObject that = (RegexObject) o;

        return Objects.equals(regexPattern, that.regexPattern) &&
                Objects.equals(inputText, that.inputText) &&
                Objects.equals(replaceText, that.replaceText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regexPattern, inputText, replaceText);
    }

    public int getKey(){
        return hashCode();
    }

    public void update(SimpleStringProperty newPattern, SimpleStringProperty newInput, SimpleStringProperty newReplaceText){
        this.regexPattern = newPattern;
        this.inputText = newInput;
        this.replaceText = newReplaceText;
    }

}

//public class RegexObject{
//    String regPattern;
//    String inputText;
//    String replacementText;
//
//    public RegexObject(String regPattern, String inputText, String replacementText){
//        this.regPattern = regPattern;
//        this.inputText = inputText;
//        this.replacementText = replacementText;
//    }
//
//    public String getRegexPattern () {
//        return regPattern;
//    }
//
//    public String getInputText () {
//        return inputText;
//    }
//
//    public String getReplaceText () {
//        return replacementText;
//    }
//
//
//}
