package org.noneoffal.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {

    private final List<Lexeme> lexemes;

    public Sentence(List<Lexeme> lexemes) {
        if (lexemes == null || lexemes.isEmpty()) {
            throw new IllegalArgumentException(
                    "Sentence must not be null or empty"
            );
        }

        this.lexemes = new ArrayList<>(lexemes);
    }

    public List<Lexeme> getLexemes() {
        return List.copyOf(lexemes);
    }

    @Override
    public String getContent() {
        StringBuilder content = new StringBuilder();

        for (int i = 0; i < lexemes.size(); i++) {
            if (i > 0) {
                content.append(' ');
            }
            content.append(lexemes.get(i).getContent());

        }
        return content.toString();
    }
}
