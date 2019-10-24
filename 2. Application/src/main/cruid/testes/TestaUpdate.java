package main.cruid.testes;

import main.cruid.dao.ClienteDAO;
import main.cruid.model.Cliente;

public class TestaUpdate {
	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente("Nome Atualizado", 40);
		cliente.setId(2);
		clienteDAO.atualiza(cliente);
	}
}
