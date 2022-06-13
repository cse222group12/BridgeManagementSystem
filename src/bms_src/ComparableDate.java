package bms_src;

import java.util.Date;

public class ComparableDate implements Comparable<ComparableDate> {

    private Date date;

    public ComparableDate(Date date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(ComparableDate o) {
        return date.compareTo(o.date);
    }

    public static ComparableDate from(Date date) {
        return new ComparableDate(date);
    }
}