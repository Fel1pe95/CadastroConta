package model.Dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;
import model.Dao.ClienteDao;
import model.entidades.Cliente;
import model.entidades.Conta;
import model.entidades.Funcionario;

public class Acess implements ClienteDao {

	@Override
	public void LeituraCliente(Map<Integer, Cliente> map) {
		String caminho = "C:\\Banco\\Clientes\\Clientes.csv";
		try (BufferedReader brr = new BufferedReader(new FileReader(caminho))) {
			String linha = brr.readLine();
			while (linha != null) {

				String[] campos = linha.split(",");
				String nome = campos[0];
				Integer agencia = Integer.parseInt(campos[1]);
				Integer conta = Integer.parseInt(campos[2]);
				Integer cpf = Integer.parseInt(campos[3]);
				Integer senha = Integer.parseInt(campos[4]);
				Double saldo = Double.parseDouble(campos[5]);
				Cliente c = new Cliente(nome, cpf, new Conta(agencia, conta, senha, saldo));
				map.put(senha, c);
				linha = brr.readLine();
			}

		} catch (IOException e) {

			Alerts.showAlert("Erro de leitura!", null, e.getMessage(), AlertType.ERROR);

		}
	}

	@Override
	public void gravacaoCLiente(Map<Integer, Cliente> map) {
		String caminho = caminhoClientes();
		try (BufferedWriter br = new BufferedWriter(new FileWriter(caminho))) {
			for (Object obj : map.values()) {
				br.write(obj.toString());
				br.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public String caminhoClientes() {
		return "C:\\Banco\\Clientes\\Clientes.csv";
	}

	public String caminhoFuncionarios() {
		return "C:\\Banco\\Funcionarios\\Funcionarios.csv";
	}

	@Override
	public void inserirCliente(Cliente c) {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(caminhoClientes(), true))) {
			br.write(c.toString());
			br.newLine();
			Alerts.showAlert("Cadastro", null, "Conta cadastrada com sucesso!", AlertType.INFORMATION);
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public static boolean bancoDeDados() {
		
		String caminho = "C:\\Banco";
		File pasta = new File(caminho);

		boolean ver = pasta.exists();
		if (ver == false) {
			new File("C:\\Banco").mkdir();
			new File("C:\\Banco\\Funcionarios").mkdir();
			new File("C:\\Banco\\Clientes").mkdir();
			
			try (BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Banco\\Funcionarios\\Funcionarios.csv", true))) {
				Funcionario f = new Funcionario("admin", 0000);
				br.write(f.toString());
				br.newLine();
			} catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			
			return false;
		} else {
			return true;
		}	
	}
	
	public void acessoFuncionario(Map<Integer, Funcionario>map) {
		String caminho = caminhoFuncionarios();
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			
			String linha = br.readLine();
			while(linha != null) {
				
				String [] campos = linha.split(",");
				String usuario = campos[0];
				Integer senha = Integer.parseInt(campos[1]);
				
				map.put(senha,new Funcionario(usuario,senha));
				linha = br.readLine();
			}
			
			
		}catch(IOException e){
			Alerts.showAlert("Erro de acesso!", null, "Erro inesperado", AlertType.ERROR);
			
		}
		
		
	}
}
