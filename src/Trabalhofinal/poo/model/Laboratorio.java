package Trabalhofinal.poo.model;
import java.util.ArrayList;

public class Laboratorio {
	private String nome;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Coordenador coordenador;
	
	public Laboratorio(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public Usuario getCoordenador() {
		return coordenador;
	}
	
	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	} 
}
