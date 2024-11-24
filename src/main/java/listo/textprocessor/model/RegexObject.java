package listo.textprocessor.model;

import java.util.Objects;

public class RegexObject{
    String regPattern;
    String inputText;
    String replacementText;

    public RegexObject(String regPattern, String inputText, String replacementText){
        this.regPattern = regPattern;
        this.inputText = inputText;
        this.replacementText = replacementText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegexObject that = (RegexObject) o;

        return Objects.equals(regPattern, that.regPattern) &&
                Objects.equals(inputText, that.inputText) &&
                Objects.equals(replacementText, that.replacementText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regPattern, inputText, replacementText);
    }

    public void update(String newPattern, String newInput, String newReplaceText){
        this.regPattern = newPattern;
        this.inputText = newInput;
        this.replacementText = newReplaceText;
    }
}
