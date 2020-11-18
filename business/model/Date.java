package business.model;

import util.IncorrectDateFormatException;

import java.io.Serializable;
import java.util.IllegalFormatException;

public class Date implements Serializable {
    private static final long serialVersionUID = 1L;

    private int year;
    private int month;
    private int day;

    public Date() {
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // from dd/mm/yyyy
    static public Date fromString(String s) throws IncorrectDateFormatException {
        if (!s.matches("^(?:(?:31([/])(?:0?[13578]|1[02]))\\1|(?:(?:29|30)([/])(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29([/.])0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])([/])(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"))
            throw new IncorrectDateFormatException("A data não está no formato esperado");

        String[] x = s.split("/");
        int day = Integer.parseInt(x[0]);
        int month = Integer.parseInt(x[1]);
        int year = Integer.parseInt(x[2]);
        return new Date(year, month, day);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
