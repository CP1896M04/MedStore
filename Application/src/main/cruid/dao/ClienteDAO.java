package main.cruid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.cruid.conexao.ConnectionFactory;
import main.cruid.model.Cliente;

public class ClienteDAO implements main.cruid.dao.DAO<Cliente> {

	private Connection connection;

	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void adiciona(Cliente cliente) {
		String sql = "insert into clientes (nome, idade) values (? ,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setInt(2, cliente.getIdade());

			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove(Cliente cliente) {
		String sql = "delete from clientes where id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, cliente.getId());

			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualiza(Cliente cliente) {
		String sql = "update clientes set nome = ?, idade = ? where id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setInt(2, cliente.getIdade());
			preparedStatement.setInt(3, cliente.getId());

			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Cliente> getLista() {
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
	}

}
