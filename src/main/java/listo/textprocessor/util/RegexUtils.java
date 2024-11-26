package listo.textprocessor.util;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexUtils {
    public static boolean isValidRegex(String regexPattern) {
        try {
            Pattern.compile(regexPattern);
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
