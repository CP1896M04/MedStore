package main.cruid.dao;

import java.util.List;

public interface DAO<T> {
	
	public void adiciona(T o);
	
	public void remove(T o);
	
	public void atualiza(T o);
	
	public List<T> getLista();
	
}
