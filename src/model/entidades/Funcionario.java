package model.entidades;

import java.util.LinkedHashMap;
import java.util.Map;

public class Funcionario {

	private String usuario;
	private Integer senha;
	

	Map<Integer, Funcionario> map = new LinkedHashMap<>();

	

	public Funcionario() {
		super();
	}

	public Funcionario(String usuario, Integer senha) {
		super();
		this.senha = senha;
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public Integer getSenha() {
		return senha;
	}

	public Map<Integer, Funcionario> getMap() {
		return map;
	}	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public boolean verFuncionario(String usuario, Integer senha, Map<Integer, Funcionario>map) {
	
		if (map.containsKey(senha) && map.get(senha).getUsuario().equals(usuario)) 
			return true;
		 else 
			return false;
		}

	@Override
	public String toString() {
		return  usuario + "," + senha;
	}
	
	

	
	}


