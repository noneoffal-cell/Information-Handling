package org.noneoffal.app.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Paragraph implements TextComponent {

    private final List<Sentence> sentences;

    public Paragraph(List<Sentence> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException(
                    "Paragraph must not be тull or empty"
            );
        }

        this.sentences = new ArrayList<>(sentences);
    }

    public List<Sentence> getSentences() {
        return List.copyOf(sentences);
    }

    @Override
    public String getContent() {
        StringJoiner content = new StringJoiner(" ");

        for (Sentence sentence : sentences) {
            content.add(sentence.getContent());
        }

        return content.toString();
    }
}
