package ru.orangesoftware.financisto.model;

/**
 * Created by IntelliJ IDEA.
 * User: Denis Solonenko
 * Date: 11/27/11 7:24 PM
 */
public enum SymbolFormat {

    RS {
        @Override
        public void appendSymbol(StringBuilder sb, String symbol) {
            sb.append(" ").append(symbol);
        }
    },
    R {
        @Override
        public void appendSymbol(StringBuilder sb, String symbol) {
            sb.append(symbol);
        }
    },
    LS {
        @Override
        public void appendSymbol(StringBuilder sb, String symbol) {
            int offset = getInsertIndex(sb);
            sb.insert(offset, " ").insert(offset, symbol);
        }
    },
    L {
        @Override
        public void appendSymbol(StringBuilder sb, String symbol) {
            sb.insert(getInsertIndex(sb), symbol);
        }
    };

    private static int getInsertIndex(StringBuilder sb) {
        if (sb.length() > 0) {
            char c = sb.charAt(0);
            return c == '+' || c == '-' ? 1 : 0;
        }
        return 0;
    }

    public abstract void appendSymbol(StringBuilder sb, String symbol);

}
