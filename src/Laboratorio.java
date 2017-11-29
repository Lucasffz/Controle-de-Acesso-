import java.util.ArrayList;

public class Laboratorio {
	private String nome;
	private Usuario[] usuarios;
	private Usuario coordenador;
	
	Laboratorio(String nome,Usuario coordenador){
		this.nome = nome;
		this.coordenador = coordenador;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	public Usuario getCoordenador() {
		return coordenador;
	}
	
	public void setCoordenador(Usuario coordenador) {
		this.coordenador = coordenador;
	}
	 

}
