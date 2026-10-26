package org.noneoffal.app.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Text implements TextComponent {

    private final List<Paragraph> paragraphs;

    public Text(List<Paragraph> paragraphs) {
        if (paragraphs == null || paragraphs.isEmpty()) {
            throw new IllegalArgumentException(
                    "Text must not be null or empty"
            );
        }

        this.paragraphs = new ArrayList<>(paragraphs);
    }

    public List<Paragraph> getParagraphs() {
        return List.copyOf(paragraphs);
    }

    @Override
    public String getContent() {
        StringJoiner content = new StringJoiner("\n\n");

        for (Paragraph paragraph : paragraphs) {
            content.add(paragraph.getContent());
        }
        return content.toString();
    }
}
