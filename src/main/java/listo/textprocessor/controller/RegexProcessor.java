package listo.textprocessor.controller;

import java.util.regex.*;

public class RegexProcessor {
    private int numMatches = 0;
    public String findMatches(String text, String regex) {
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            StringBuilder result = new StringBuilder();

            while (matcher.find()) {
                numMatches++;
                result.append("Match found: ").append(matcher.group()).append("\n");
            }
            return result.toString();
        } catch (PatternSyntaxException e) {
            return "Invalid regex pattern: " + e.getDescription();
        }
    }

    public String getNumMatches(){
        int tmp = numMatches;
        numMatches = 0;
        return "" + tmp;
    };

    public String replaceText(String text, String regex, String replacement) {
        try {
            return text.replaceAll(regex, replacement);
        } catch (PatternSyntaxException e) {
            return "Invalid regex pattern: " + e.getDescription();
        }
    }
}


