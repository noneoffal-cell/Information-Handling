package org.noneoffal.app.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TextComposite implements TextComponent {

    private final List<TextComponent> components = new ArrayList<>();
    private final ComponentType type;

    public TextComposite(ComponentType type) {
        if (type == null || !type.isCompositeType()) {
            throw new IllegalArgumentException(
                    "A composite must have a valid composite type"
            );
        }

        this.type = type;
    }

    public boolean add(TextComponent component) {
        validateChild(component);
        return components.add(component);
    }

    public boolean remove(TextComponent component) {
        if (component == null) {
            throw new IllegalArgumentException(
                    "Component must not be null"
            );
        }

        return components.remove(component);
    }

    public List<TextComponent> getComponents() {
        return List.copyOf(components);
    }

    public void replaceComponent(int index, TextComponent component) {
        validateChild(component);
        components.set(index, component);
    }

    @Override
    public String getContent() {
        StringJoiner content = new StringJoiner(type.getDelimiter());

        for (TextComponent component : components) {
            content.add(component.getContent());
        }

        return content.toString();
    }

    @Override
    public int count() {
        int count = 0;

        for (TextComponent component : components) {
            count += component.count();
        }

        if (components.size() > 1) {
            count += (components.size() - 1)
                    * type.getDelimiter().length();
        }

        return count;
    }

    @Override
    public int countLetters() {
        int count = 0;

        for (TextComponent component : components) {
            count += component.countLetters();
        }

        return count;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    private void validateChild(TextComponent component) {
        if (component == null) {
            throw new IllegalArgumentException(
                    "Component must not be null"
            );
        }

        if (!type.acceptsChild(component.getType())) {
            throw new IllegalArgumentException(
                    "Component of type " + component.getType()
                            + " cannot be added to " + type
            );
        }
    }
}