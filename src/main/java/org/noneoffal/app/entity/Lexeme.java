package org.noneoffal.app.entity;

public class Lexeme implements TextComponent {

    private final String content;

    public Lexeme(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException(
                    "Lexeme must not be null or empty"
            );
        }
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
