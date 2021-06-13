package model.entidades;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import model.Dao.InstanciaDao;
import model.Dao.impl.Acess;

public class Cliente {

	private String nome;
	private Integer cpf;
	private Conta conta;

	Acess acess = InstanciaDao.instanciaCliente();
	Map<Integer, Cliente> agencia = new LinkedHashMap<Integer, Cliente>();

	public Cliente() {
		super();
	}

	public Cliente(String nome, Integer cpf, Conta conta) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.conta = conta;
	}

	public Map<Integer, Cliente> getAgencia() {
		return agencia;
	}

	public Conta getConta() {
		return conta;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public boolean verificacao(Integer senha, Integer ag, Integer conta) {
		if (agencia.containsKey(senha) && agencia.get(senha).getConta().getAgenciaBancaria().equals(ag)
				&& agencia.get(senha).getConta().getNumeroDaConta().equals(conta))

			return true;
		else
			return false;

	}

	public Cliente CadastrarCliente(String nome, Integer cpf, Integer senha) {

		Random random = new Random();
		Integer numConta = random.nextInt(4000) + 1000;
		Integer Agencia = 4842;
		double saldo = 0;

		return new Cliente(nome, cpf, new Conta(Agencia, numConta, senha, saldo));

	

	

	}

	public void impressaoDeDados(Integer num) {
		System.out.println("------------------------------------");
		System.out.println("Agencia: " + agencia.get(num).getConta().getAgenciaBancaria());
		System.out.println("Conta: " + agencia.get(num).getConta().getNumeroDaConta());
		System.out.println("Nome: " + agencia.get(num).getNome());
		System.out.println("Saldo: " + String.format("%.2f", agencia.get(num).getConta().getSaldo()));
		System.out.println("------------------------------------");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome + "," + conta.getAgenciaBancaria() + "," + conta.getNumeroDaConta() + "," + cpf + ","
				+ conta.getSenha() + "," + conta.getSaldo();
	}

}
