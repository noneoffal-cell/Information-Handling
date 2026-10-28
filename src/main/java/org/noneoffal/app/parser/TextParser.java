package org.noneoffal.app.parser;

import org.noneoffal.app.entity.TextComponent;

public interface TextParser<T extends TextComponent> {

    T parse(String data);
}
