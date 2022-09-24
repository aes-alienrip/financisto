package ru.orangesoftware.financisto.datetime;

/**
* Created by IntelliJ IDEA.
* User: denis.solonenko
* Date: 12/17/12 9:07 PM
*/
public class Period {

    public PeriodType type;
    public long start;
    public long end;

    public Period(PeriodType type, long start, long end) {
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public boolean isSame(long start, long end) {
        return this.start == start && this.end == end;
    }

    public boolean isCustom() {
        return type == PeriodType.CUSTOM;
    }

}
