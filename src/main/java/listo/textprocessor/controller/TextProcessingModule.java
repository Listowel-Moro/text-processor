package listo.textprocessor.controller;


public class TextProcessingModule {
    private final RegexProcessor regexProcessor = new RegexProcessor();

    public String processText(String text, String regex, String replacement) {
        return regexProcessor.replaceText(text, regex, replacement);
    }

    public String searchText(String text, String regex) {
        return regexProcessor.findMatches(text, regex);
    }
}

