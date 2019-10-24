package user.dao;

import user.connection.ConnectionFactory;
import user.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements DAO<Staff> {
    private Connection connection;
    public  StaffDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Staff o) {
        String sql = "insert into Staff (staffID, roleID, FName,LName,DOB,address,sex,phoneNo,userName,passWord) values (? ,?,? ,?,? ,?,? ,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getStaffID());
            preparedStatement.setString(2, o.getRoleID());
            preparedStatement.setString(3, o.getFName());
            preparedStatement.setString(4, o.getLName());
            preparedStatement.setDate(5, java.sql.Date.valueOf("2013-09-04"));
            preparedStatement.setString(6, o.getAddress());
            preparedStatement.setString(7, o.getSex());
            preparedStatement.setString(8, o.getPhoneNo());
            preparedStatement.setString(9, o.getUserName());
            preparedStatement.setString(10, o.getPassWord());
            preparedStatement.execute();
        } catch ( SQLException e){

            throw new RuntimeException(e);
            /*public void adiciona(Cliente cliente) {
		String sql = "insert into clientes (nome, idade) values (? ,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setInt(2, cliente.getIdade());

			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
        }
        }


    @Override
    public void remove(Staff o) {
        String sql = "delete from users where username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, o.getStaffID());
            preparedStatement.setString(2, o.getRoleID());
            preparedStatement.setString(3, o.getFName());
            preparedStatement.setString(4, o.getLName());
            preparedStatement.setDate(5, java.sql.Date.valueOf("2013-09-04"));
            preparedStatement.setString(6, o.getAddress());
            preparedStatement.setString(7, o.getSex());
            preparedStatement.setString(8, o.getPhoneNo());
            preparedStatement.setString(9, o.getUserName());
            preparedStatement.setString(10, o.getPassWord());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Staff o) {
        String sql = "update users set username= ?, password = ? where username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, o.getStaffID());
            preparedStatement.setString(2, o.getRoleID());
            preparedStatement.setString(3, o.getFName());
            preparedStatement.setString(4, o.getLName());
            preparedStatement.setDate(5, (Date) o.getDOB());
            preparedStatement.setString(6, o.getAddress());
            preparedStatement.setString(7, o.getSex());
            preparedStatement.setString(8, o.getPhoneNo());
            preparedStatement.setString(9, o.getUserName());
            preparedStatement.setString(10, o.getPassWord());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         /*
        boolean success = true;
        UserDao userDao = new UserDao();
        List<User> users = new ArrayList<User>();
        users = userDao.getList();
        if(users.isEmpty()){
            success = false;
        }  else {

            String sql = "update users set username= ?, password = ? where username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, o.getUserName());
                preparedStatement.setString(2, o.getPassWord());
                preparedStatement.setString(3, o.getUserName());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
*/
        /*public void atualiza(Cliente cliente) {
		String sql = "update clientes set nome = ?, idade = ? where id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setInt(2, cliente.getIdade());
			preparedStatement.setInt(3, cliente.getId());

			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}*/
    }

    @Override
    public List<Staff> getList() {
                    List<Staff> users = new ArrayList<>();

          String sql = "select staffID, roleID, FName,LName,DOB,address,sex,phoneNo,userName,passWord from Staff";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
               ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                   int staffID = resultSet.getInt("staffID");
                    String roleID = resultSet.getString("roleID");
                    String Fname = resultSet.getString("Fname");
                    String Lname = resultSet.getString("Lname");
                    java.util.Date DOB = resultSet.getDate("DOB");
                    String Address = resultSet.getString("Address");
                    String Sex = resultSet.getString("Sex");
                    String phoneNo = resultSet.getString("phoneNo");
                    String username = resultSet.getString("username");
                   String password = resultSet.getString("password");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return null;
    }
}
