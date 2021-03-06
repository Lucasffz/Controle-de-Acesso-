package Trabalhofinal.poo.view;
import java.util.ArrayList;
import java.util.Scanner;
import Trabalhofinal.poo.model.*;
import Trabalhofinal.poo.controler.*;

public class Main {

	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		
		Adm padrao = new Adm();
		
		System.out.println("Programa rodando pela primeira vez...");
		System.out.println("� necess�rio criar o usu�rio administrador.");
		System.out.println("Digite o nome do usu�rio: ");
		String namep = input.nextLine();
		padrao.setNome(namep);
		String nova_senha ="";
		while(true) {
			System.out.println("Digite a nova senha:");
			nova_senha = input.nextLine();
			System.out.println("Confirme a senha digitada:");
			String confirmar = input.nextLine();
			if(nova_senha.equalsIgnoreCase(confirmar)) {
				break;
			}
			else
				System.out.println("Senhas digitadas n�o coincidem.");
		}
		
		
		
		padrao.setSenha(nova_senha);
		System.out.println("Adiministrador adicionado.");
		
		
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
					System.out.println("Digite a senha de usuario padr�o: ");
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
					
					String[] acoordenador;
					acoordenador = cadastroUsuario();
					
					Coordenador coordenador = controle.criarUsuarioCoordenador(acoordenador[0], acoordenador[1], acoordenador[2], lab, acoordenador[3]);
					controle.adicionarCoordenadordeLaboratorio(coordenador, lab);
					
					
					System.out.println("Coordenador adicionado ao laborat�rio com sucesso.");
					System.out.println();
					
				}
				break;
				
			case 2:
				
				if(controle.retornarLaboratorios().isEmpty()) {
					System.out.println("Ainda n�o h� laborat�rios cadastrados nesse sistema.");	
				}
				else {
				System.out.println("LABORAT�RIOS:");
				for (int k = 0; k < controle.retornarLaboratorios().size(); k++) {
					
					System.out.println(controle.retornarLaboratorios().get(k).getNome());
					System.out.println("-----------------");
				}
				
				}
				space();
				break;
				
			
				
				
			case 3:
				
				if(controle.retornarLaboratorios().isEmpty()) {
					System.out.println("Ainda n�o h� laborat�rios cadastrados nesse sistema.");
					space();
					continue;
					
				}
				
				
				
				
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
				else
					System.out.println("Laborat�rio n�o encontrado.");
				}
				
				System.out.println("1 - Para usu�rio Professor.");
				System.out.println("2 - Para usu�rio Aluno.");
				System.out.print(">>");
				int op3 = input.nextInt();
				
				if(op3 == 1) {
					
					boolean acesso2 = false;
					int chances2 = 0;
					while(!acesso2) {
						System.out.println("Digite a senha de usuario padr�o: ");
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
							System.out.println("Voc� chegou ao limite de tentativa de acessos.");
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
					
					boolean acesso2 = false;
					int chances2 = 0;
					while(!acesso2) {
						System.out.println("Digite a senha do usuario padr�o ou do Coordenador do Laborat�rio: ");
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
							System.out.println("Voc� chegou ao limite de tentativa de acessos.");
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
			
			case 5:
				acesso = false;
				chances = 0;
				while(!acesso) {
					System.out.println("Digite a senha de usuario padr�o: ");
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
						System.out.println("Voc� chegou ao limite de tentativa de acessos.");
						break;
					}
				}
				if(chances == 3) {
					break;
				}
			
				if(controle.retornarAcessos().isEmpty())
					System.out.println("N�o h� acessos nesse sistema...");
				else {
					System.out.println("ACESSOS: ");
					for (int i = 0; i < controle.retornarAcessos().size(); i++) {
						
						if(controle.retornarAcessos().get(i).getStatus().equalsIgnoreCase("Negativo")) {
						
						
						System.out.println("Laborat�rio: " + controle.retornarAcessos().get(i).getLaboratorio().getNome());
						System.out.println("Identifica��o: " + controle.retornarAcessos().get(i).getId());
						System.out.println("Senha: " + controle.retornarAcessos().get(i).getSenha());
						System.out.println("Status: " + controle.retornarAcessos().get(i).getStatus());
						System.out.println("Data: " + controle.retornarAcessos().get(i).getData());
						System.out.println("Hora: " + controle.retornarAcessos().get(i).getHora());
						System.out.println(" --------------------------------------------------------");
						}
						
						
						else {
							System.out.println("Laborat�rio: " + controle.retornarAcessos().get(i).getLaboratorio().getNome());
							System.out.println("Identifica��o: " + controle.retornarAcessos().get(i).getId());
							System.out.println("Senha: " + "********");
							System.out.println("Status: " + controle.retornarAcessos().get(i).getStatus());
							System.out.println("Data: " + controle.retornarAcessos().get(i).getData());
							System.out.println("Hora: " + controle.retornarAcessos().get(i).getHora());
							System.out.println(" --------------------------------------------------------");
							
						}
						
					}
				}
				
				
				break;
				
			case 6:
				
				boolean acesso6 = false;
				int chances6 = 0;
				while(!acesso6) {
					System.out.println("Digite a senha de usuario padr�o: ");
					String senha = input.next();
					acesso6 = controle.verificarChaveDoAdministrador(senha);
					
					if(acesso6)
						System.out.println("Acesso liberado.");
					else {
						chances6++;
						System.out.println("senha incorreta.");
						System.out.println("Acesso negado.");
					}
					if(chances6 == 3) {
						System.out.println("Voc� chegou ao limite de tentativa de acessos.");
						break;
					}
				}
				if(chances6 == 3) 
					break;
				
				
				System.out.println("Laborat�rio:");
				String la = input.next();
				System.out.println("Matr�cula do usu�rio:");
				String ma = input.next();
				
				int saida = controle.excluirUsuario(la, ma);
				if(saida == 0) {
					System.out.println("Usu�rio exclu�do com sucesso.");
				}
				else if(saida == 1) {
					System.out.println("Laborat�rio n�o encontrado.");
				}
				else
					System.out.println("Usu�rio n�o encontrado no laborat�rio " + la + ".");
				
				break;
				
				
			case 7:
				boolean acesso7 = false;
				int chances7 = 0;
				while(!acesso7) {
					System.out.println("Digite a senha de usuario padr�o: ");
					String senha = input.next();
					acesso7 = controle.verificarChaveDoAdministrador(senha);
					
					if(acesso7)
						System.out.println("Acesso liberado.");
					else {
						chances7++;
						System.out.println("senha incorreta.");
						System.out.println("Acesso negado.");
					}
					if(chances7 == 3) {
						System.out.println("Voc� chegou ao limite de tentativa de acessos.");
						break;
					}
				}
				if(chances7 == 3) 
					break;
				
				System.out.print("Laborat�rio:");
				String lab7 = input.next();
				int resultado = controle.excluirLaboratorio(lab7);
				if(resultado == 1) 
					System.out.println("Laborat�rio exclu�do com sucesso.");
				else
					System.out.println("Laborat�rio n�o encontrado.");
		
				break;			
			case 0:
				break;
				
			default:
				System.out.println("Op��o inv�lida. ");
				}
			
			}
		}
		else if(e == 1) {
			if(controle.retornarLaboratorios().isEmpty()) {
				System.out.println("Ainda n�o h� laborat�rios cadastrados nesse sistema.");
				space();
				continue;
				
			}
			Laboratorio laboratorio = null;
			while(true) {
			System.out.println("Laborat�rio: ");
			String labo = input.next();
			
			
			boolean encontrou = false;
			for (int i = 0; i < controle.retornarLaboratorios().size(); i++) {
				if(controle.retornarLaboratorios().get(i).getNome().equalsIgnoreCase(labo)) {
					laboratorio = controle.retornarLaboratorios().get(i);
					encontrou = true;
				}
			}
			
			if(encontrou)
				break;
			else
				System.out.println("Laborat�rio n�o encontrado.");
			}
			System.out.println();
				
			System.out.print("Digite a matr�cula: ");
			String matri = input.next();
			System.out.print("Digite a senha: ");
			String senha = input.next();
			boolean acesso = controle.acessar(matri, senha, laboratorio);
			if(acesso) {
				System.out.println("Acesso liberado.");
				controle.adcionarAcesso(matri, senha, "Positivo", laboratorio);
			}
			else {
				System.out.println("Acesso negado.");
				controle.adcionarAcesso(matri, senha, "Negativo", laboratorio);
			}
			
			
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
		System.out.println("5 - Listar Acessos. ");
		System.out.println("6 - Excluir Usu�rio de um laborat�rio. ");
		System.out.println("7 - Excluir laborat�rio.");
		
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
		String nova_senha = "";
		while(true) {
			System.out.println("Digite a nova senha:");
			nova_senha = input.nextLine();
			System.out.println("Confirme a senha digitada:");
			String confirmar = input.nextLine();
			if(nova_senha.equalsIgnoreCase(confirmar)) {
				break;
			}
			else
				System.out.println("Senhas digitadas n�o coincidem.");
		}
		cadastro[3] = nova_senha;
		
		return cadastro;
	 
	}
	
	
	
	
	
}
