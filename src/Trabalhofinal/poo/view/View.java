package Trabalhofinal.poo.view;
import java.util.ArrayList;
import java.util.Scanner;
import Trabalhofinal.poo.model.*;
import Trabalhofinal.poo.controler.*;

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
		// professor.setNome("PlÃ¡cido");

		// professores.add(professor);
		// alunos.add(aluno);
		// laboratorios.add(laboratorio);

		// laboratorios.get(0).setUsuario(alunos.get(0));

		// System.out.println(laboratorios.get(0).getUsuario(alunos.get(0)));

		Scanner input = new Scanner(System.in);
		
		
		Adm padrao = new Adm();
		
		
		System.out.println("Criar usuario padrão: ");
		System.out.println("Digite o nome do usuário: ");
		String namep = input.nextLine();
		padrao.setNome(namep);
		System.out.println("Digite a senha do usuário padrão: ");
		String chavep = input.nextLine();
		padrao.setSenha(chavep);
		
		Controle controle = new Controle(padrao);
		
		while(true) {
		entrada();
		System.out.print(">>");
		int e = input.nextInt();
		
		if(e == 2) {
		
		
			int op = -1;
			while(op!=0) {
			menu();
			space();
			System.out.print(">>");
			op = input.nextInt();
			switch(op) {
			case 1:
				boolean acesso = false;
				int chances = 0;
				while(!acesso) {
					System.out.println("Digite a senha de usuario padrão: ");
					String senha = input.next();
					acesso = controle.verificarChaveDoAdministrador(senha);
					
					if(acesso)
						System.out.println("Acesso liberado.");
					else {
						chances++;
						System.out.println("senha incorreta.");
						System.out.println("Acesso negado.");
					}
					if(chances == 3) {
						System.out.println("Você chegou ao limite de tentativa de acessos.");
						break;
					}
				}
				if(chances == 3) {
					break;
				}
			
				String nome;
				System.out.println("Digite o nome do laboratório: ");
				nome = input.next();
				
				Laboratorio lab;
				lab = controle.cadastrarLaboratorio(nome);
				controle.adicionarLaboratorio(lab);
				System.out.println("Laboratório cadastrado com sucesso.");
				
				space();
				
				System.out.println("1 - Deseja cadastrar novo usuário coordenador.");
				System.out.println("2 - Adicionar a coordenanação a um usuário existente?");
				
				int op2 = input.nextInt();
				space();
				if(op2 == 1) {
					
					String[] acoordenador;
					acoordenador = cadastroUsuario();
					
					Coordenador coordenador = controle.criarUsuarioCoordenador(acoordenador[0], acoordenador[1], acoordenador[2], lab, acoordenador[3]);
					controle.adicionarCoordenadordeLaboratorio(coordenador, lab);
				}
				break;
				
			case 2:
				
				if(controle.retornarLaboratorios().isEmpty()) {
					System.out.println("Ainda não há laboratórios cadastrados nesse sistema.");	
				}
				else {
				System.out.println("LABORATÓRIOS:");
				for (int k = 0; k < controle.retornarLaboratorios().size(); k++) {
					
					System.out.println(controle.retornarLaboratorios().get(k).getNome());
					System.out.println("-----------------");
				}
				
				}
				space();
				break;
				
			
				
				
			case 3:
				
				if(controle.retornarLaboratorios().isEmpty()) {
					System.out.println("Ainda não há laboratórios cadastrados nesse sistema.");
					space();
					continue;
					
				}
				
				
				
				
				Laboratorio novo_laboratorio = null;
				while(true) {
				System.out.println("Digite o nome do laboratório que deseja adicionar o novo Usuário: ");
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
				else
					System.out.println("Laboratório não encontrado.");
				}
				
				System.out.println("1 - Para usuário Professor.");
				System.out.println("2 - Para usuário Aluno.");
				System.out.print(">>");
				int op3 = input.nextInt();
				
				if(op3 == 1) {
					
					boolean acesso2 = false;
					int chances2 = 0;
					while(!acesso2) {
						System.out.println("Digite a senha de usuario padrão: ");
						String senha = input.next();
						acesso2 = controle.verificarChaveDoAdministrador(senha);
						
						if(acesso2)
							System.out.println("Acesso liberado.");
						else {
							chances2++;
							System.out.println("senha incorreta.");
							System.out.println("Acesso negado.");
						}
						if(chances2 == 3) {
							System.out.println("Você chegou ao limite de tentativa de acessos.");
							break;
						}
					}
					if(chances2 == 3) 
						break;
					
					
					String[] novo_usuario;
					novo_usuario = cadastroUsuario();
					
					
					Professor novo_professor = new Professor(novo_usuario[0],novo_usuario[1],novo_usuario[2],novo_laboratorio,novo_usuario[3]);
					boolean cadastrou = controle.cadastrarUsuario(novo_professor, novo_laboratorio);
					if(cadastrou) {
						System.out.println("Cadastro feito com sucesso.");
					}
					else {
						System.out.println("O usuário já existe.");
					}
					
					space();
					System.out.println("Usuário dentro do laboratório");
					for (int i = 0; i < novo_laboratorio.getUsuarios().size(); i++) {
						System.out.println(novo_laboratorio.getUsuarios().get(i).getNome());
						System.out.println("-----");
						
					}
				}	
				else if(op3 == 2) {
					
					boolean acesso2 = false;
					int chances2 = 0;
					while(!acesso2) {
						System.out.println("Digite a senha do usuario padrão ou do Coordenador do Laboratório: ");
						String senha = input.next();
						acesso2 = controle.verificarChaveDoAdministrador(senha) || controle.verificarChaveDoCoordenador(senha,novo_laboratorio.getCoordenador());
						
						if(acesso2)
							System.out.println("Acesso liberado.");
						else {
							chances2++;
							System.out.println("senha incorreta.");
							System.out.println("Acesso negado.");
						}
						if(chances2 == 3) {
							System.out.println("Você chegou ao limite de tentativa de acessos.");
							break;
						}
					}
					if(chances2 == 3) 
						break;
					
					
					
					
					String[] novo_usuario2;
					novo_usuario2 = cadastroUsuario();
					
					Aluno novo_aluno = new Aluno(novo_usuario2[0],novo_usuario2[1],novo_usuario2[2],novo_laboratorio,novo_usuario2[3]);
					boolean cadastrou2 = controle.cadastrarUsuario(novo_aluno, novo_laboratorio);
					if(cadastrou2) {
						System.out.println("Cadastro feito com sucesso.");
						
					}
					else
						System.out.println("Usuário já existe.");
					
				}
				break;
				
			case 4:
				System.out.print("Laboratório: ");
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
					System.out.println("Laboratório não encontrado...");
					System.out.println("tente novamente....");
				}
				break;
			
			case 5:
				
				if(controle.retornarAcessos().isEmpty())
					System.out.println("Não há acessos nesse sistema...");
				else {
				System.out.println("ACESSOS: ");
				for (int i = 0; i < controle.retornarAcessos().size(); i++) {
					System.out.println("Identificação: " + controle.retornarAcessos().get(i).getId());
					System.out.println("Senha: " + controle.retornarAcessos().get(i).getSenha());
					System.out.println("Status: " + controle.retornarAcessos().get(i).getStatus());
					System.out.println("Data: " + controle.retornarAcessos().get(i).getData());
					System.out.println("Hora: " + controle.retornarAcessos().get(i).getHora());
					System.out.println(" --------------------------------------------------------");
				}
				}
				
				
				
				
				
				
				
			case 0:
				break;
			
				
				
			default:
				System.out.println("Opção inválida. ");
				}
			
			}
		}
		else if(e == 1) {
			if(controle.retornarLaboratorios().isEmpty()) {
				System.out.println("Ainda não há laboratórios cadastrados nesse sistema.");
				space();
				continue;
				
			}
			Laboratorio laboratorio3 = null;
			while(true) {
			System.out.println("Laboratório: ");
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
				System.out.println("Laboratório não encontrado.");
			}
				
			System.out.print("Digite a matrícula: ");
			String matri = input.next();
			System.out.print("Digite a senha: ");
			String senha = input.next();
			boolean acesso = controle.acessar(matri, senha, laboratorio3);
			if(acesso) {
				System.out.println("Acesso liberado.");
				controle.adcionarAcesso(matri, senha, "Positivo");
			}
			else {
				controle.adcionarAcesso(matri, senha, "Negativo");
				System.out.println("Acesso negado.");
			}
			
			
		}
		
		else if(e == 0) {
			System.out.println("Tchau.");
			break;
		}
		
		
		}
		
		
}
		
	
		
		
		
	
	
	
	
	static void entrada() {
		System.out.println("1 - Entrar no laboratório. ");
		System.out.println("2 - Menu admistrador");
		System.out.println("0 - Sair.");
	}
	
	static void menu() {
		System.out.println("Digite sua operação.");
		System.out.println("1 - Cadastrar um laboratorio. ");
		System.out.println("2 - Mostrar laboratórios. ");
		System.out.println("3 - Adicionar membros a um laborátorio.");
		System.out.println("4 - listar usuários de um laboratório.  ");
		System.out.println("5 - Listar Acessos. ");
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
		System.out.println("Matrícula do usuário: ");
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
