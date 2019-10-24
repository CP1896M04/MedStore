package main.cruid.testes;
import main.cruid.dao.ClienteDAO;
import main.cruid.model.Cliente;

public class TestaInsert {
	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente("Mateus", 22);
		clienteDAO.adiciona(cliente);		
	}
}
