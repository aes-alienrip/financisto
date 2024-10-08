package ru.orangesoftware.financisto.export.qif;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Denis Solonenko
 * Date: 9/26/11 7:50 PM
 */
public class QifBufferedReader {

    private final BufferedReader r;

    public QifBufferedReader(BufferedReader r) {
        this.r = r;
    }

    public String readLine() throws IOException {
        while (true) {
            String line = r.readLine();
            if (line == null) {
                return null;
            }
            line = line.trim();
            if (line.length() > 0) {
                return line;
            }
        }
    }

    public String peekLine() throws IOException {
        r.mark(256);
        String peek = readLine();
        r.reset();
        return peek;
    }

    private String trim(String s) {
        return s != null ? s.trim() : null;
    }

}
