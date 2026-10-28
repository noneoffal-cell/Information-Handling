package org.noneoffal.app.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.noneoffal.app.entity.TextComponent;
import org.noneoffal.app.exception.TextParsingException;
import org.noneoffal.app.parser.TextParser;

public abstract class AbstractTextParser<T extends TextComponent>
        implements TextParser<T> {

    private static final Logger LOGGER =
            LogManager.getLogger(AbstractTextParser.class);

    private final TextParser<? extends TextComponent> nextParser;

    protected AbstractTextParser(
            TextParser<? extends TextComponent> nextParser) {
        this.nextParser = nextParser;
    }

    protected final void validateInput(String data) {
        if (data == null || data.isBlank()) {
            throw new TextParsingException(
                    "Text to parse must not be null or blank"
            );
        }
    }

    protected final TextComponent parseNext(String data) {
        if (nextParser == null) {
            throw new IllegalStateException(
                    "Next parser is not configured for "
                            + getClass().getSimpleName()
            );
        }

        return nextParser.parse(data);
    }
}