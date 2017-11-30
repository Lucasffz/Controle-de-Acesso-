import java.util.ArrayList;

public class Controle {

		private ArrayList<Laboratorio> laboratorios =  new ArrayList<Laboratorio>();
		private Adm padrao;
		
		Controle(Adm padrao){
			this.padrao = padrao;
		}
		
		
	public boolean acessar(String matricula, String chave, Laboratorio lab) {
		boolean saida = false;
		
		
	for (int i = 0; i < lab.getUsuarios().size(); i++) {
		if(matricula.equals(lab.getUsuarios().get(i).getMatricula()) && chave.equals(lab.getUsuarios().get(i).getSenha()) ) {
			saida = true;	
			}	
		}
		
		return saida;
	}
	
	public Usuario criarUsuarioAluno(String nome,String matricula,String curso, Laboratorio laboratorio,String senha) {
		Usuario usuario = new Aluno(nome,matricula,curso,laboratorio,senha);
		return usuario;
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
	
	public void adicionarCoordenadordeLaboratorio(Usuario coordenador,Laboratorio lab) {
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
	
	public boolean verificarChave(String senha) {
		if(senha.equals(padrao.getSenha()) ){
			return true;
		}
				
		return false;
	}
	
	public void adicionarLaboratorio(Laboratorio lab) {
		laboratorios.add(lab);
	}
	
	public ArrayList<Laboratorio> retornarLaboratorios(){
		return laboratorios;
	}
}
