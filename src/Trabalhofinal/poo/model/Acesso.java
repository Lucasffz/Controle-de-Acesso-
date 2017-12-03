package Trabalhofinal.poo.model;
public class Acesso {
	private String id;
	private String senha;
	private String status;
	private String data;
	private String hora;
	
	public Acesso(String id, String senha, String status, String data, String hora) {
		this.id = id;
		this.senha = senha;
		this.status = status;
		this.data = data;
		this.hora = hora;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	
	
	

}
