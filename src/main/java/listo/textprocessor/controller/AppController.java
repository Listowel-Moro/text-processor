package listo.textprocessor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AppController {
    @FXML
    private TextArea textInputArea, resultArea;
    @FXML
    private TextField regexField, replaceField;
    @FXML
    private TextFlow highlightedTextFlow;
    @FXML
    private Label numMatches;

    private final RegexProcessor regexProcessor = new RegexProcessor();
    private final DataManager dataManager = new DataManager();

    /**
     * Handles the "Find Matches" button click.
     */
    @FXML
    private void handleFindMatches() {
        String inputText = textInputArea.getText();
        String regexPattern = regexField.getText();

        if (inputText.isEmpty() || regexPattern.isEmpty()) {
            resultArea.setText("Please provide input text and a regex pattern.");
            return;
        }

        try {
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(inputText);

            StringBuilder matches = new StringBuilder();
            int matchCount = 0;

            while (matcher.find()) {
                matchCount++;
                matches.append(matcher.group()).append(",  ");
            }

            numMatches.setText(String.valueOf(matchCount));
            highlightedTextFlow.getChildren().clear();
            Text listResult = new Text(matches.toString());
            highlightedTextFlow.getChildren().add(listResult);
        } catch (PatternSyntaxException e) {
            resultArea.setText("Invalid regex pattern: " + e.getMessage());
        }
    }

    /**
     * Handles the "Replace Text" button click.
     */
    @FXML
    private void handleReplaceText() {
        String inputText = textInputArea.getText();
        String regexPattern = regexField.getText();
        String replacementText = replaceField.getText();

        if (inputText.isEmpty() || regexPattern.isEmpty()) {
            resultArea.setText("Please provide input text and a regex pattern.");
            return;
        }

        try {
            String replacedText = regexProcessor.replaceText(inputText, regexPattern, replacementText);
            textInputArea.setText(replacedText); // Update input area with replaced text
            resultArea.setText("Text replaced successfully.");
        } catch (PatternSyntaxException e) {
            resultArea.setText("Invalid regex pattern: " + e.getMessage());
        }
    }

    /**
     * Handles the "Add Data" button click.
     */
    @FXML
    private void handleAddData() {
        String regexPattern = regexField.getText();
        String replaceText = replaceField.getText();
        String inputText = textInputArea.getText();

        if (regexPattern.isEmpty() || inputText.isEmpty()) {
            resultArea.setText("Please provide both a key (regex) and a value (replacement text).");
            return;
        }

        dataManager.addEntry(regexPattern, inputText, replaceText);
        //resultArea.setText("Entry added: " + key + " -> " + value);
    }


    @FXML
    private void initialize() {
        regexField.textProperty().addListener((observable, oldValue, newValue) -> {
            highlightMatches();
        });
        replaceField.textProperty().addListener((observable, oldValue, newValue) -> {
            highlightMatches();
        });
    }

    private void highlightMatches() {
        String inputText = textInputArea.getText();
        String regexPattern = regexField.getText();
        String replacementText = replaceField.getText();

        highlightedTextFlow.getChildren().clear();

        if (inputText.isEmpty() || regexPattern.isEmpty()) {
            numMatches.setText("0");
            return;
        }

        try {
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(inputText);

            int lastMatchEnd = 0;
            int matchCount = 0;

            while (matcher.find()) {
                matchCount++;

                // Add plain text before the match
                if (matcher.start() > lastMatchEnd) {
                    String beforeMatch = inputText.substring(lastMatchEnd, matcher.start());
                    Text beforeText = new Text(beforeMatch);
                    beforeText.setStyle("-fx-fill: black; -fx-font-size: 14px;");  // Normal text
                    highlightedTextFlow.getChildren().add(beforeText);
                }

                // Add the replacement text if any
                String matchedText = matcher.group();
                if (!replacementText.isEmpty()) {
                    matchedText = replacementText;  // Replace the matched text with the replacement text
                }

                // Add highlighted or replaced matched text
                Text displayedText = new Text(matchedText);
                if (replacementText.isEmpty()) {
                    displayedText.setStyle("-fx-fill: red; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-color: yellow;");  // Highlighted text
                } else {
                    displayedText.setStyle("-fx-fill: green; -fx-font-weight: bold; -fx-font-size: 14px;");  // Replaced text
                }
                highlightedTextFlow.getChildren().add(displayedText);

                lastMatchEnd = matcher.end();
            }

            // Add remaining plain text after the last match
            if (lastMatchEnd < inputText.length()) {
                String afterMatch = inputText.substring(lastMatchEnd);
                Text afterText = new Text(afterMatch);
                afterText.setStyle("-fx-fill: black; -fx-font-size: 14px;");  // Normal text
                highlightedTextFlow.getChildren().add(afterText);
            }

            // Update the match count
            numMatches.setText(String.valueOf(matchCount));
        } catch (PatternSyntaxException e) {
            numMatches.setText("0");
            highlightedTextFlow.getChildren().add(new Text(inputText));  // If regex is invalid, just show plain text
        }
    }
}

