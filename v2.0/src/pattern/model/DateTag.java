package pattern.model;

public class DateTag {
   private int dataKey;
   private String Date;
   private String month;
   private int monthNumber;
   private int year;
   private int quarter;

    public DateTag() {
    }

    public DateTag(int dataKey, String date, String month, int monthNumber, int year, int quarter) {
        this.dataKey = dataKey;
        Date = date;
        this.month = month;
        this.monthNumber = monthNumber;
        this.year = year;
        this.quarter = quarter;
    }

    public void setDataKey(int dataKey) {
        this.dataKey = dataKey;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getDataKey() {
        return dataKey;
    }

    public String getDate() {
        return Date;
    }

    public String getMonth() {
        return month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public int getYear() {
        return year;
    }

    public int getQuarter() {
        return quarter;
    }
}
