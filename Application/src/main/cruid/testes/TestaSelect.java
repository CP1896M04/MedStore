package main.cruid.testes;

import java.util.List;

import main.cruid.dao.ClienteDAO;
import main.cruid.model.Cliente;

public class TestaSelect {
	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> lista = clienteDAO.getLista();
		
		lista.forEach(cliente -> System.out.println(cliente));
		
	}
}
