package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.DateTag;
import pattern.model.InventoryLedger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateTagDAO implements DAO<DateTag> {
    private Connection connection;
    public  DateTagDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(DateTag o) {
        String sql ="INSERT INTO [dbo].[DateTag]\n" +
                "           ([DateKey]\n" +
                "           ,[FullDateAlternateKey]\n" +
                "           ,[DayNumberOfWeek]\n" +
                "           ,[EnglishDayNameOfWeek]\n" +
                "           ,[DayNumberOfMonth]\n" +
                "           ,[DayNumberOfYear]\n" +
                "           ,[WeekNumberOfYear]\n" +
                "           ,[EnglishMonthName]\n" +
                "           ,[MonthNumberOfYear]\n" +
                "           ,[CalendarQuarter]\n" +
                "           ,[CalendarYear]\n" +
                "           ,[CalendarSemester])\n" +
                "     VALUES\n" +
                "           (?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getDateKey());
            preparedStatement.setDate(2, o.getFullDateAlternateKey());
            preparedStatement.setInt(3, o.getDayNumberOfWeek());
            preparedStatement.setString(4, o.getEnglishDayNameOfWeek());
            preparedStatement.setInt(5, o.getDayNumberOfMonth());
            preparedStatement.setInt(6, o.getDayNumberOfYear());
            preparedStatement.setString(7, o.getEnglishMonthName());
            preparedStatement.setInt(8, o.getMonthNumberOfYear());
            preparedStatement.setInt(9, o.getCalendarQuarter());
            preparedStatement.setInt(10, o.getCalendarYear());
            preparedStatement.setInt(11, o.getCalendarSemester());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String dateKey) throws SQLException {
        String sql = "DELETE FROM [dbo].[InventoryLedger] WHERE [DateKey] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(dateKey));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(DateTag o) {
        String sql ="UPDATE [dbo].[DateTag]\n" +
                "   SET \n" +
                "      ,[FullDateAlternateKey] = ?\n" +
                "      ,[DayNumberOfWeek] = ?\n" +
                "      ,[EnglishDayNameOfWeek] = ?\n" +
                "      ,[DayNumberOfMonth] = ?\n" +
                "      ,[DayNumberOfYear] = ?\n" +
                "      ,[WeekNumberOfYear] = ?\n" +
                "      ,[EnglishMonthName] = ?\n" +
                "      ,[MonthNumberOfYear] = ?\n" +
                "      ,[CalendarQuarter] = ?\n" +
                "      ,[CalendarYear] = ?\n" +
                "      ,[CalendarSemester] = ?\n" +
                " WHERE [DateKey] = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDate(2, o.getFullDateAlternateKey());
            preparedStatement.setInt(3, o.getDayNumberOfWeek());
            preparedStatement.setString(4, o.getEnglishDayNameOfWeek());
            preparedStatement.setInt(5, o.getDayNumberOfMonth());
            preparedStatement.setInt(6, o.getDayNumberOfYear());
            preparedStatement.setString(7, o.getEnglishMonthName());
            preparedStatement.setInt(8, o.getMonthNumberOfYear());
            preparedStatement.setInt(9, o.getCalendarQuarter());
            preparedStatement.setInt(10, o.getCalendarYear());
            preparedStatement.setInt(11, o.getCalendarSemester());
            preparedStatement.setInt(1, o.getDateKey());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DateTag> getList() {
        List<DateTag> dateTags = new ArrayList<>();
        String sql = "SELECT [DateKey]\n" +
                "      ,[FullDateAlternateKey]\n" +
                "      ,[DayNumberOfWeek]\n" +
                "      ,[EnglishDayNameOfWeek]\n" +
                "      ,[DayNumberOfMonth]\n" +
                "      ,[DayNumberOfYear]\n" +
                "      ,[WeekNumberOfYear]\n" +
                "      ,[EnglishMonthName]\n" +
                "      ,[MonthNumberOfYear]\n" +
                "      ,[CalendarQuarter]\n" +
                "      ,[CalendarYear]\n" +
                "      ,[CalendarSemester]\n" +
                "  FROM [dbo].[DateTag]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int DateKey= resultSet.getInt("DateKey");
                Date FullDateAlternateKey = resultSet.getDate("FullDateAlternateKey");
                int DayNumberOfWeek = resultSet.getInt("DayNumberOfWeek");
                int DayNumberOfMonth = resultSet.getInt("DayNumberOfMonth");
                int DayNumberOfYear = resultSet.getInt("DayNumberOfYear");
                int WeekNumberOfYear = resultSet.getInt("WeekNumberOfYear");
                String EnglishMonthName = resultSet.getString("EnglishMonthName");
                int CalendarQuarter = resultSet.getInt("CalendarQuarter");
                int CalendarYear = resultSet.getInt("CalendarYear");
                int CalendarSemester = resultSet.getInt("CalendarSemester");

                DateTag dateTag= new DateTag(DateKey,FullDateAlternateKey,DayNumberOfWeek,DayNumberOfMonth,DayNumberOfYear,WeekNumberOfYear,EnglishMonthName,CalendarQuarter,CalendarYear,CalendarSemester);
                dateTags.add(dateTag);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dateTags;

    }
}
