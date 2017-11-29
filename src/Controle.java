import java.util.ArrayList;

public class Controle {
		private Administrador padrao;
		private ArrayList<Laboratorio> laboratorios =  new ArrayList<Laboratorio>();
		
		
		Controle(Administrador padrao){
			this.padrao = padrao;
		}
		
		
	boolean acessar(String matricula, String chave, Laboratorio lab) {
		boolean saida = false;
		
		
	for (int i = 0; i < lab.getUsuarios().size(); i++) {
		if(matricula.equals(lab.getUsuarios().get(i).getMatricula()) && chave.equals(lab.getUsuarios().get(i).getSenha()) ) {
			saida = true;	
			}	
		}
		
		return saida;
	}
	
	Usuario criarUsuarioAluno(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		Usuario usuario = new Aluno(nome,matricula,curso,laboratorio,senha);
		
		
		return usuario;
	}
	
	
	
	Usuario criarUsuarioProfessor(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		Usuario usuario = new Professor(nome,matricula,curso,laboratorio,senha);
		
		
		
		return usuario;
	}
	
	boolean cadastrarUsuario(Usuario usuario,Laboratorio lab) {
		for(int i =0;i<lab.getUsuarios().size();i++) {
			if(lab.getUsuarios().get(i) == usuario)
				return false;
		}
		
		
		lab.adicionarUsuario(usuario);
		
		return true;
	}
	
	void adicionarCoordenadordeLaboratorio(Professor coordenador,Laboratorio lab) {
		lab.setCoordenador(coordenador);
	}
	
	
	
	boolean verficarCoordenador(Usuario coordenador,Laboratorio lab) {
		if(lab.getCoordenador() == coordenador) 
			return true;
		
		
	return false;
	}
	
	Laboratorio cadastrarLaboratorio(String nome, Usuario coordenador) {
		Laboratorio lab = new Laboratorio(nome,coordenador);
		return lab;
		
	}
	
	boolean verificarChave(String senha) {
		if(senha.equals(padrao.getSenha()) ){
			return true;
		}
				
		return false;
	}
	
	void adicionarLaboratorio(Laboratorio lab) {
		laboratorios.add(lab);
	}
	
	
	
	 ArrayList<Laboratorio> retornarLaboratorios(){
		return laboratorios;
	}
	
	
	
	
	
	
	
	
	
	
	
}
