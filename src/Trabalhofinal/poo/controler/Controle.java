package Trabalhofinal.poo.controler;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import Trabalhofinal.poo.model.*;

public class Controle {

	private ArrayList<Laboratorio> laboratorios =  new ArrayList<Laboratorio>();
	private ArrayList<Acesso> acessos = new ArrayList<Acesso>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private Adm padrao;
	
	Date data = new Date();
	SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatarHora = new SimpleDateFormat("HH:mm:ss");
	
	public Controle(Adm padrao){
		this.padrao = padrao;
	}
		
	public boolean acessar(String matricula, String chave, Laboratorio lab) {
		boolean saida = false;	
		for (int i = 0; i < lab.getUsuarios().size(); i++) {
			if(matricula.equals(lab.getUsuarios().get(i).getMatricula()) && chave.equals(lab.getUsuarios().get(i).getSenha()) ||
					lab.getCoordenador().getMatricula().equalsIgnoreCase(matricula) && 
					lab.getCoordenador().getSenha().equalsIgnoreCase(chave) ) {
				
					saida = true;	
				}	
			}
			
			return saida;
	}
	
	public Usuario criarUsuarioAluno(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		Usuario usuario = new Aluno(nome,matricula,curso,laboratorio,senha);
		return usuario;
	}
	
	public Coordenador criarUsuarioCoordenador(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		Coordenador coordenador = new Coordenador(nome,matricula,curso,laboratorio,senha);
		return coordenador;
	}
	
	public Usuario criarUsuarioProfessor(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		Usuario usuario = new Professor(nome,matricula,curso,laboratorio,senha);
		return usuario;
	}
	
	public boolean cadastrarUsuario(Usuario usuario,Laboratorio lab) {
		for(int i =0;i<lab.getUsuarios().size();i++) {
			if(lab.getUsuarios().get(i) == usuario)
				return false;
		}
		lab.adicionarUsuario(usuario);
		return true;
	}
	
	public void adicionarCoordenadordeLaboratorio(Coordenador coordenador,Laboratorio lab) {
		lab.setCoordenador(coordenador);
	}
	
	public boolean verficarCoordenador(Usuario coordenador,Laboratorio lab) {
		if(lab.getCoordenador() == coordenador) 
			return true;

		return false;
	}
	
	public Laboratorio cadastrarLaboratorio(String nome) {
		Laboratorio lab = new Laboratorio(nome);
		return lab;		
	}
	
	public boolean verificarChaveDoAdministrador(String senha) {
		if(senha.equals(padrao.getSenha()) ){
			return true;
		}
				
		return false;
	}
	
	
	public boolean verificarChaveDoCoordenador(String senha, Usuario coordenador) {
		if(senha.equalsIgnoreCase(coordenador.getSenha()))
				return true;
		return false;	
	}
	
	public void adicionarLaboratorio(Laboratorio lab) {
		laboratorios.add(lab);
	}
	
	public ArrayList<Laboratorio> retornarLaboratorios(){
		return laboratorios;
	}
	
	public void adcionarAcesso(String id,String senha,String status) {
		String dataAtual = formatarData.format(data);
		String hora = formatarHora.format(data);
		Acesso acesso = new Acesso(id,senha,status,dataAtual,hora);
		acessos.add(acesso);
	}
	
	public ArrayList<Acesso> retornarAcessos(){
		return acessos;
	}
	
	
	
	
}
