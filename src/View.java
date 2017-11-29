import java.util.ArrayList;
import java.util.Scanner;


public class View {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Administrador padrao = new Administrador();
		
		System.out.println("Criar usuário padrão: ");
		System.out.println("Digite o nome do usuário padrão: ");
		String namep = input.next();
		padrao.setNome(namep);
		System.out.println("Digite a senha do usuário padão: ");
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
				System.out.println("Digite a senha de usuário padrão: ");
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
			lab = controle.cadastrarLaboratorio(nome, null);
			controle.adicionarLaboratorio(lab);
			System.out.println("Laboratório cadastrado com sucesso.");
			
			space();			
			
			System.out.println("1 - Deseja cadastrar novo usuário coordenador.");
				System.out.println("2 -adicionar a coordenação a um usuário existente?");	
			String op2 = input.next();
			if(op ==1) {
				System.out.println("Nome:");
				String nomeu = input.next();
				System.out.println("Matrícula:");
				String matriculau = input.next();
				System.out.println("Curso:");
				String cursou = input.next();
				System.out.println("senha:");
				String senhau = input.next();
				Usuario prof = controle.criarUsuarioProfessor(nomeu, matriculau, cursou, lab, senhau);
				
				
			}
			
			break;
			
		case 2:
			System.out.println("gg izi");
			break;
		}
		
		
		
		}
		
		
		
	}
	
	
	
	static void menu() {
		System.out.println("Digite sua operação.");
		System.out.println("1 - Cadastrar um laboratório. ");
		System.out.println("2 - Mostra laboratórios. ");
		System.out.println("2 - Cadastrar Usuário em um laboratório. ");
		System.out.println("3 - listar usuários de um laboratório.  ");
		
	}
	
	static void space() {
		System.out.println("--------------------------");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
