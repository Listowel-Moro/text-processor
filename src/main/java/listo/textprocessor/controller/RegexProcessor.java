package listo.textprocessor.controller;

import java.util.regex.*;

public class RegexProcessor {
    public String findMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append("Match found: ").append(matcher.group()).append("\n");
        }
        return result.toString();
    }

    public String replaceText(String text, String regex, String replacement) {
        return text.replaceAll(regex, replacement);
    }
}

