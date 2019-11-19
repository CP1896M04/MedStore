package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.DateTag;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateTagDAO implements DAO<DateTag> {
    private Connection connection;
    public  DateTagDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    public int procInsert(DateTag dateTag){
        int id= checkExist(dateTag.getDate());
        if(id ==0){
            CallableStatement cs = null;
            try {
                cs = connection.prepareCall("{call insertDateTag(?,?,?,?,?,?)}");
                cs.registerOutParameter(6, Types.INTEGER);
                cs.setString(1, dateTag.getDate());
                cs.setString(2,dateTag.getMonth());
                cs.setInt(3,dateTag.getMonthNumber());
                cs.setInt(4,dateTag.getYear());
                cs.setInt(5,dateTag.getQuarter());
                cs.execute();
                Integer str = cs.getInt(6);
                id=str;
            } catch (SQLException e) {
                System.err.println("SQLException: " + e.getMessage());
            }
        }
        return id;
    }
    @Override
    public void add(DateTag o) {
    }

    @Override
    public void remove(String dateKey) throws SQLException {
    }

    @Override
    public void update(DateTag o) {
    }

    @Override
    public List<DateTag> getList() {
        List<DateTag> dateTags = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[DateTag]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int dateKey= resultSet.getInt("DateKey");
                String date=resultSet.getString("Date");
                String month=resultSet.getString("Month");
                int monthNumber=resultSet.getInt("MonthNumber");
                int year=resultSet.getInt("Year");
                int quarter=resultSet.getInt("Quarter");
                DateTag dateTag= new DateTag(dateKey,date,month,monthNumber,year,quarter);
                dateTags.add(dateTag);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dateTags;

    }
    public int checkExist(String d) {
        List<DateTag> dateTags = new ArrayList<>();
        int dateKey=0;
        String sql = "SELECT [DateKey] FROM [dbo].[DateTag] WHERE [Date]=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,d);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dateKey= resultSet.getInt("DateKey");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dateKey;

    }
}
