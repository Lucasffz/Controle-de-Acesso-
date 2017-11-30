import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private static ArrayList<Professor> professores = new ArrayList<Professor>();
	private static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private static ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();

	public static void main(String[] args) {

		// // Exemplo com novo fluxo de classes
		// Laboratorio laboratorio = new Laboratorio();
		// Professor professor = new Professor();
		// Aluno aluno = new Aluno();

		// aluno.setNome("Fulano");
		// professor.setNome("Plácido");

		// professores.add(professor);
		// alunos.add(aluno);
		// laboratorios.add(laboratorio);

		// laboratorios.get(0).setUsuario(alunos.get(0));

		// System.out.println(laboratorios.get(0).getUsuario(alunos.get(0)));

		Scanner input = new Scanner(System.in);
		
		Administrador padrao = new Administrador();
		
		System.out.println("Criar usu�rio padr�o: ");
		System.out.println("Digite o nome do usu�rio padr�o: ");
		String namep = input.next();
		padrao.setNome(namep);
		System.out.println("Digite a senha do usu�rio pad�o: ");
		String chavep = input.next();
		padrao.setSenha(chavep);
		
		Controle controle = new Controle(padrao);
		int op;
		
		while(true) {
		menu();
		space();
		
		op = input.nextInt();
		switch(op) {
		case 1:
			boolean acesso = false;
			int chances = 0;
			while(!acesso) {
				System.out.println("Digite a senha de usu�rio padr�o: ");
				String senha = input.next();
				acesso = controle.verificarChave(senha);
				
				if(acesso)
					System.out.println("Acesso liberado.");
				else {
					chances++;
					System.out.println("senha incorreta.");
					System.out.println("Acesso negado.");
				}
				if(chances == 3) {
					System.out.println("Voc� chegou ao limite de tentativa de acessos.");
					break;
				}
			}
			if(chances == 3) {
				break;
			}
			
			String nome;
			System.out.println("Digite o nome do laborat�rio: ");
			nome = input.next();
			
			Laboratorio lab;
			lab = controle.cadastrarLaboratorio(nome);
			controle.adicionarLaboratorio(lab);
			System.out.println("Laborat�rio cadastrado com sucesso.");
			
			space();
			
			System.out.println("1 - Deseja cadastrar novo usu�rio coordenador.");
			System.out.println("2 - Adicionar a coordena��o a um usu�rio existente?");
			
			int op2 = input.nextInt();
			if(op2 == 1) {
				System.out.println("Nome:");
				String nomeu = input.next();
				System.out.println("Matr�cula:");
				String matriculau = input.next();
				System.out.println("Curso:");
				String cursou = input.next();
				System.out.println("senha:");
				String senhau = input.next();
				Usuario prof = controle.criarUsuarioProfessor(nomeu, matriculau, cursou, lab, senhau);
				controle.adicionarCoordenadordeLaboratorio(prof, lab);
			}
			
			/* eu criei um ArrayList do tipo Usuario, as classes Professor e Aluno extend de Usuario, quando eu crio um ArrayList do tipo Usuario
				 e depois intancio um classe 'Usuario p = new Professor()' os m�todos espec�ficos da classe professor n�o s�o visiveis, 
				 sabe como eu posso contar isso, pra ter um �nico ArrayList com alunos e professores e usar seus m�todos espc�ficos???
				  */
			
			
			
			
			/*System.out.println(lab.getNome());
			System.out.println(lab.getCoordenador().getNome());
			System.out.println(lab.);*/
			
			
			break;
			
		case 2:
			for (int k = 0; k < controle.retornarLaboratorios().size(); k++) {
				System.out.println(controle.retornarLaboratorios().get(k).getNome());
				System.out.println("-----------------");
			}
			break;
		}
		
		
		
		}
		
		
		
	}
	
	
	
	static void menu() {
		System.out.println("Digite sua opera��o.");
		System.out.println("1 - Cadastrar um laborat�rio. ");
		System.out.println("2 - Mostrar laborat�rios. ");
		System.out.println("2 - Cadastrar Usu�rio em um laborat�rio. ");
		System.out.println("3 - listar usu�rios de um laborat�rio.  ");
		
	}
	
	static void space() {
		System.out.println("--------------------------");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
