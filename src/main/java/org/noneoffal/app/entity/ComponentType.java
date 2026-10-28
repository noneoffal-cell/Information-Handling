package org.noneoffal.app.entity;

public enum ComponentType {

    TEXT,
    PARAGRAPH,
    SENTENCE,
    LEXEME,
    WORD,
    LETTER,
    DIGIT,
    PUNCTUATION;

    public String getDelimiter() {
        return switch (this) {
            case TEXT -> "\n\n";
            case PARAGRAPH, SENTENCE -> " ";
            case LEXEME, WORD -> "";
            default -> throw new IllegalStateException(
                    "A leaf component has no delimiter"
            );
        };
    }

    public boolean isCompositeType() {
        return switch (this) {
            case TEXT, PARAGRAPH, SENTENCE, LEXEME, WORD -> true;
            case LETTER, DIGIT, PUNCTUATION -> false;
        };
    }

    public boolean acceptsChild(ComponentType childType) {
        if (childType == null) {
            return false;
        }

        return switch (this) {
            case TEXT -> childType == PARAGRAPH;
            case PARAGRAPH -> childType == SENTENCE;
            case SENTENCE -> childType == LEXEME;
            case LEXEME ->
                    childType == WORD || childType == PUNCTUATION;
            case WORD ->
                    childType == LETTER || childType == DIGIT;
            default -> false;
        };
    }

    public static ComponentType determineSymbolType(char symbol) {
        if (Character.isLetter(symbol)) {
            return LETTER;
        }

        if (Character.isDigit(symbol)) {
            return DIGIT;
        }

        return PUNCTUATION;
    }
}