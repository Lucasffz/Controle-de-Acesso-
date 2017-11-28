import java.util.Scanner;


public class View {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Controle c = new Controle();
		menu();
		int op;
		op = input.nextInt();
		switch(op) {
		case 1:
			String nome;
			System.out.println("Digite o nome do laboratório: ");
			nome = input.nextLine();
			System.out.println("Digite o Coordenador do laborátorio.");
			
			
			
			
			Laboratorio lab;
			lab = c.cadastrarLaboratorio(nome, null);
		}
		
		
		
		
		
		
		
	}
	
	
	
	static void menu() {
		System.out.println("Digite sua operação.");
		System.out.println("1 - Cadastrar um laboratório. ");
		System.out.println("2 - Cadastrar Usuário em um laboratório. ");
		System.out.println("3 - listar usuários de um laboratório.  ");
		
	}
	
	static void primeiroUsuario() {
		System.out.println("Criar usuário padrão.");
		User padrao = new User();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
