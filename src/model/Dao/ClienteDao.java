package model.Dao;

import java.util.Map;

import model.entidades.Cliente;

public interface ClienteDao {

	void LeituraCliente(Map<Integer, Cliente> map);
	void gravacaoCLiente(Map<Integer, Cliente>map);
	void inserirCliente(Cliente c);
	String caminhoClientes();
	String caminhoFuncionarios();
}
