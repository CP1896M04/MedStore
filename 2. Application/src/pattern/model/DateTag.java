package pattern.model;

import java.sql.Date;

public class DateTag {
   private Integer  DateKey ;
   private Date FullDateAlternateKey;
   private Integer DayNumberOfWeek ;
   private String EnglishDayNameOfWeek ;
   private Integer DayNumberOfMonth ;
   private Integer DayNumberOfYear ;
   private Integer WeekNumberOfYear ;
   private String EnglishMonthName ;
   private Integer MonthNumberOfYear ;
   private Integer CalendarQuarter;
   private Integer CalendarYear ;
   private Integer CalendarSemester;

    public DateTag(Integer dateKey, Date fullDateAlternateKey, Integer dayNumberOfWeek, String englishDayNameOfWeek, Integer dayNumberOfMonth, Integer dayNumberOfYear, Integer weekNumberOfYear, String englishMonthName, Integer monthNumberOfYear, Integer calendarQuarter, Integer calendarYear, Integer calendarSemester) {
        DateKey = dateKey;
        FullDateAlternateKey = fullDateAlternateKey;
        DayNumberOfWeek = dayNumberOfWeek;
        EnglishDayNameOfWeek = englishDayNameOfWeek;
        DayNumberOfMonth = dayNumberOfMonth;
        DayNumberOfYear = dayNumberOfYear;
        WeekNumberOfYear = weekNumberOfYear;
        EnglishMonthName = englishMonthName;
        MonthNumberOfYear = monthNumberOfYear;
        CalendarQuarter = calendarQuarter;
        CalendarYear = calendarYear;
        CalendarSemester = calendarSemester;
    }

    public Integer getDateKey() {
        return DateKey;
    }

    public void setDateKey(Integer dateKey) {
        DateKey = dateKey;
    }

    public Date getFullDateAlternateKey() {
        return FullDateAlternateKey;
    }

    public void setFullDateAlternateKey(Date fullDateAlternateKey) {
        FullDateAlternateKey = fullDateAlternateKey;
    }

    public Integer getDayNumberOfWeek() {
        return DayNumberOfWeek;
    }

    public void setDayNumberOfWeek(Integer dayNumberOfWeek) {
        DayNumberOfWeek = dayNumberOfWeek;
    }

    public String getEnglishDayNameOfWeek() {
        return EnglishDayNameOfWeek;
    }

    public void setEnglishDayNameOfWeek(String englishDayNameOfWeek) {
        EnglishDayNameOfWeek = englishDayNameOfWeek;
    }

    public Integer getDayNumberOfMonth() {
        return DayNumberOfMonth;
    }

    public void setDayNumberOfMonth(Integer dayNumberOfMonth) {
        DayNumberOfMonth = dayNumberOfMonth;
    }

    public Integer getDayNumberOfYear() {
        return DayNumberOfYear;
    }

    public void setDayNumberOfYear(Integer dayNumberOfYear) {
        DayNumberOfYear = dayNumberOfYear;
    }

    public Integer getWeekNumberOfYear() {
        return WeekNumberOfYear;
    }

    public void setWeekNumberOfYear(Integer weekNumberOfYear) {
        WeekNumberOfYear = weekNumberOfYear;
    }

    public String getEnglishMonthName() {
        return EnglishMonthName;
    }

    public void setEnglishMonthName(String englishMonthName) {
        EnglishMonthName = englishMonthName;
    }

    public Integer getMonthNumberOfYear() {
        return MonthNumberOfYear;
    }

    public void setMonthNumberOfYear(Integer monthNumberOfYear) {
        MonthNumberOfYear = monthNumberOfYear;
    }

    public Integer getCalendarQuarter() {
        return CalendarQuarter;
    }

    public void setCalendarQuarter(Integer calendarQuarter) {
        CalendarQuarter = calendarQuarter;
    }

    public Integer getCalendarYear() {
        return CalendarYear;
    }

    public void setCalendarYear(Integer calendarYear) {
        CalendarYear = calendarYear;
    }

    public Integer getCalendarSemester() {
        return CalendarSemester;
    }

    public void setCalendarSemester(Integer calendarSemester) {
        CalendarSemester = calendarSemester;
    }
}
