
public class Controle {
		private UsuarioPadrao padrao;
	
		Controle(UsuarioPadrao padrao){
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
	
	User cadastrarUsuario(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		User usuario = new Aluno(nome,matricula,curso,laboratorio,senha);
		
		
		return usuario;
	}
	
	
	boolean verficarCoordenador(User coordenador,Laboratorio lab) {
		if(lab.getCoordenador() == coordenador) 
			return true;
		
		
	return false;
	}
	
	Laboratorio cadastrarLaboratorio(String nome, User coordenador) {
		Laboratorio lab = new Laboratorio(nome,coordenador);
		return lab;
		
	}
	
	boolean verificarChave(String senha) {
		if(senha.equals(padrao.getSenha()) ){
			return true;
		}
				
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
