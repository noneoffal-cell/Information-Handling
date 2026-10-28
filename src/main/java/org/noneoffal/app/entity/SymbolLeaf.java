package org.noneoffal.app.entity;

public class SymbolLeaf implements TextComponent {

    private final char symbol;
    private final ComponentType type;

    public SymbolLeaf(char symbol) {
        if (Character.isWhitespace(symbol) || Character.isSpaceChar(symbol)) {
            throw new IllegalArgumentException("" +
                    "Whitespace characters cannot be represented as symbol leaves");
        }

        this.symbol = symbol;
        this.type = ComponentType.determineSymbolType(symbol);
    }

    @Override
    public String getContent() {
        return Character.toString(symbol);
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public int countLetters() {
        return type == ComponentType.LETTER ? 1 : 0;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

}
