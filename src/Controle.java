import java.util.ArrayList;

public class Controle {
		private administrador padrao;
		private ArrayList<Laboratorio> laboratorios =  new ArrayList<Laboratorio>();
		
		
		Controle(administrador padrao){
			this.padrao = padrao;
		}
		
		
	boolean acessar(String matricula, String chave, Laboratorio lab) {
		boolean saida = false;
		
		
	for (int i = 0; i < lab.getUsuarios().length; i++) {
		if(matricula.equals(lab.getUsuarios()[i].getMatricula()) && chave.equals(lab.getUsuarios()[i]) ) {
			saida = true;	
			}	
		}
		
		return saida;
	}
	
	Usuario cadastrarUsuario(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		Usuario usuario = new Aluno(nome,matricula,curso,laboratorio,senha);
		
		
		return usuario;
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
