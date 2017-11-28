
public class Laboratorio {
	private String nome;
	private User[] usuarios;
	private User coordenador;
	
	Laboratorio(String nome,User coordenador){
		this.nome = nome;
		this.coordenador = coordenador;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public User[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(User[] usuarios) {
		this.usuarios = usuarios;
	}
	public User getCoordenador() {
		return coordenador;
	}
	
	public void setCoordenador(User coordenador) {
		this.coordenador = coordenador;
	}
	

}
