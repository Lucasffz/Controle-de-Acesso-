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
		
		
		Adm padrao = new Adm();
		
		
		System.out.println("Criar usuario padr�o: ");
		System.out.println("Digite o nome do usu�rio: ");
		String namep = input.nextLine();
		padrao.setNome(namep);
		System.out.println("Digite a senha do usu�rio padr�o: ");
		String chavep = input.nextLine();
		padrao.setSenha(chavep);
		
		Controle controle = new Controle(padrao);
		
		while(true) {
		entrada();
		int e = input.nextInt();
		
		if(e == 2) {
		
		
			int op = -1;
			while(op!=0) {
			menu();
			space();
			
			op = input.nextInt();
			switch(op) {
			case 1:
				boolean acesso = false;
				int chances = 0;
				while(!acesso) {
					System.out.println("Digite a senha de usuario padr�o: ");
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
				System.out.println("2 - Adicionar a coordenana��o a um usu�rio existente?");
				
				int op2 = input.nextInt();
				space();
				if(op2 == 1) {
					
					String[] coordenador;
					coordenador = cadastroUsuario();
					
					Usuario prof = controle.criarUsuarioProfessor(coordenador[0], coordenador[1], coordenador[2], lab, coordenador[3]);
					controle.adicionarCoordenadordeLaboratorio(prof, lab);
				}
				
				/* eu criei um ArrayList do tipo Usuario, as classes Professor e Aluno extend de Usuario, quando eu crio um ArrayList do tipo Usuario
					 e depois intancio um classe 'Usuario p = new Professor()' os m�todos espec�ficos da classe professor n�o s�o visiveis, 
					 sabe como eu posso contar isso, pra ter um �nico ArrayList com alunos e professores e usar seus m�todos espc�ficos???
				
				/*System.out.println(lab.getNome());
				System.out.println(lab.getCoordenador().getNome());
				System.out.println(lab.);*/
				
				
				break;
				
			case 2:
				
				if(controle.retornarLaboratorios().isEmpty()) {
					System.out.println("Ainda n�o h� laborat�rios cadastrados nesse sistema.");
					
				}
				
				
				for (int k = 0; k < controle.retornarLaboratorios().size(); k++) {
					System.out.println("nome do laborat�rio" + controle.retornarLaboratorios().get(k).getNome());
					System.out.println("-----------------");
				}
				
				
				space();
				break;
				
			
				
				
			case 3:
				
				
				Laboratorio novo_laboratorio = null;
				while(true) {
				System.out.println("Digite o nome do laborat�rio que deseja adicionar o novo Usu�rio: ");
				String quallab = input.next();
				
				boolean encontrou = false;
				for (int i = 0; i < controle.retornarLaboratorios().size(); i++) {
					if(controle.retornarLaboratorios().get(i).getNome().equalsIgnoreCase(quallab)) {
						novo_laboratorio = controle.retornarLaboratorios().get(i);
						encontrou = true;
					}
				}
				
				if(encontrou) 
					break;
					
				}
				
				System.out.println("1 - Para usu�rio Professor.");
				System.out.println("2 - Para usu�rio Aluno.");
				System.out.print(">>");
				int op3 = input.nextInt();
				
				if(op3 == 1) {
					String[] novo_usuario;
					novo_usuario = cadastroUsuario();
					
					
					Professor novo_professor = new Professor(novo_usuario[0],novo_usuario[1],novo_usuario[2],novo_laboratorio,novo_usuario[3]);
					boolean cadastrou = controle.cadastrarUsuario(novo_professor, novo_laboratorio);
					if(cadastrou) {
						System.out.println("Cadastro feito com sucesso.");
					}
					else {
						System.out.println("O usu�rio j� existe.");
					}
					
					space();
					System.out.println("Usu�rio dentro do laborat�rio");
					for (int i = 0; i < novo_laboratorio.getUsuarios().size(); i++) {
						System.out.println(novo_laboratorio.getUsuarios().get(i).getNome());
						System.out.println("-----");
						
					}
				}	
				else if(op3 == 2) {
					
					String[] novo_usuario2;
					novo_usuario2 = cadastroUsuario();
					
					Aluno novo_aluno = new Aluno(novo_usuario2[0],novo_usuario2[1],novo_usuario2[2],novo_laboratorio,novo_usuario2[3]);
					boolean cadastrou2 = controle.cadastrarUsuario(novo_aluno, novo_laboratorio);
					if(cadastrou2) {
						System.out.println("Cadastro feito com sucesso.");
						
					}
					else
						System.out.println("Usu�rio j� existe.");
					
				}
				break;
				
			case 4:
				System.out.print("Laborat�rio: ");
				String labo = input.next();
				boolean encontrou = false;
				for (int i = 0; i < controle.retornarLaboratorios().size(); i++) {
					if(controle.retornarLaboratorios().get(i).getNome().equalsIgnoreCase(labo)) {
						encontrou = true;
						System.out.println(controle.retornarLaboratorios().get(i).getCoordenador().getNome());
						
						System.out.println("--------------------------------");
						for (int j = 0; j < controle.retornarLaboratorios().get(i).getUsuarios().size(); j++) {
							System.out.println(controle.retornarLaboratorios().get(i).getUsuarios().get(j).getNome());
							System.out.println("----------------------------");	
						}
					}
				}
				
				if(!encontrou) {
					System.out.println("Laborat�rio n�o encontrado...");
					System.out.println("tente novamente....");
				}
				break;
				
			case 0:
				break;
				}
			}
		}
		else if(e == 1) {
			
			Laboratorio laboratorio3 = null;
			while(true) {
			System.out.println("Laborat�rio: ");
			String labo = input.next();
			
			
			boolean encontrou = false;
			for (int i = 0; i < controle.retornarLaboratorios().size(); i++) {
				if(controle.retornarLaboratorios().get(i).getNome().equalsIgnoreCase(labo)) {
					laboratorio3 = controle.retornarLaboratorios().get(i);
					encontrou = true;
				}
			}
			
			if(encontrou)
				break;
			else
				System.out.println("Laborat�rio n�o encontrado.");
			}
				
			System.out.print("Digite a matr�cula: ");
			String matri = input.next();
			System.out.print("Digite a senha: ");
			String senha = input.next();
			boolean acesso = controle.acessar(matri, senha, laboratorio3);
			if(acesso) {
				System.out.println("Acesso liberado.");
			}
			else
				System.out.println("Acesso negado.");
			
			
			
		}
		
		else if(e == 0) {
			System.out.println("Tchau.");
			break;
		}
		
		
		}
		
		
}
		
	
		
		
		
	
	
	
	
	static void entrada() {
		System.out.println("1 - Entrar no laborat�rio. ");
		System.out.println("2 - Menu admistrador");
		System.out.println("0 - Sair.");
	}
	
	static void menu() {
		System.out.println("Digite sua opera��o.");
		System.out.println("1 - Cadastrar um laboratorio. ");
		System.out.println("2 - Mostrar laborat�rios. ");
		System.out.println("3 - Adicionar membros a um labor�torio.");
		System.out.println("4 - listar usu�rios de um laborat�rio.  ");
		System.out.println("0 - voltar.");
	}
	
	static void space() {
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
	}
	
	static String[] cadastroUsuario(){
		String[] cadastro = new String[4];
		Scanner input = new Scanner(System.in);
		System.out.println("Nome: ");
		String novo_nome = input.nextLine();
		cadastro[0] = novo_nome;
		System.out.println("Matr�cula do usu�rio: ");
		String nova_matricula = input.nextLine();
		cadastro[1] = nova_matricula;
		System.out.println("Curso:");
		String novo_curso = input.nextLine();
		cadastro[2] = novo_curso;
		System.out.println("Digite a nova senha:");
		String nova_senha = input.nextLine();
		cadastro[3] = nova_senha;

		
		return cadastro;
	 
	}
	
}
