package user.dao;

import user.connection.ConnectionFactory;
import user.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements DAO<User> {
    private Connection connection;

    public UserDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }

    @Override
    public void add(User o) {
        String sql = "insert into users (username, password) values (? ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getUserName());
            preparedStatement.setString(2, o.getPassWord());
            preparedStatement.execute();
        } catch (SQLException e) {
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
    public void remove(User o) {
        String sql = "insert into user (username, password) values (? ,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getUserName());
            preparedStatement.setString(2, o.getPassWord());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*public void remove(Cliente cliente) {
		String sql = "delete from clientes where id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, cliente.getId());

			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
    }

    @Override
    public void update(User o) {
        String sql = "insert into user (username, password) values (? ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getUserName());
            preparedStatement.setString(2, o.getPassWord());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public List<User> getList() {
        return null;
        /*public List<Cliente> getLista() {
		List<Cliente> clientes = new ArrayList<>();

		String sql = "select * from clientes";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				Integer idade = resultSet.getInt("idade");
				Cliente cliente = new Cliente(nome, idade);
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return clientes;
	}*/
    }
}
