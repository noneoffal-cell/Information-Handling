package org.noneoffal.app.parser;

public class ParserRegex {

    public static final String PARAGRAPH_DELIMITER =
            "(?:\\R[\\t ]*){2,}";

    public static final String SENTENCE_DELIMITER =
            "(?<=[.!?])\\s+|(?<=[.!?][\"'”’»)])\\s+";

    public static final String LEXEME_DELIMITER =
            "\\s+";

    public static final String WORD_PATTERN =
            "[\\p{L}\\p{N}]+(?:['’\\-][\\p{L}\\p{N}]+)*";

    public static final String LEXEME_PARTS =
            WORD_PATTERN + "|[^\\p{L}\\p{N}]+";

    private ParserRegex() {
    }
}
