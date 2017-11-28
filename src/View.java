import java.util.Scanner;


public class View {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		UsuarioPadrao padrao = new UsuarioPadrao ();
		
		System.out.println("Criar usuário padrão: ");
		System.out.println("Digite o nome do usuário padrão: ");
		String namep = input.next();
		padrao.setNome(namep);
		System.out.println("Digite a senha do usuário padão: ");
		String keyp = input.next();
		padrao.setSenha(keyp);
		
		Controle controle = new Controle(padrao);
		
		space();
		menu();
		
		int op;
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
					System.out.println("Você chegou a limite de tentativa de acessos.");
					break;
				}
			}
			if(chances == 3) {
				break;
			}
			
			String nome;
			System.out.println("Digite o nome do laboratório: ");
			nome = input.nextLine();
			System.out.println("Digite o Coordenador do laborátorio.");
			
			
			
			
			Laboratorio lab;
			lab = controle.cadastrarLaboratorio(nome, null);
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	static void menu() {
		System.out.println("Digite sua operação.");
		System.out.println("1 - Cadastrar um laboratório. ");
		System.out.println("2 - Cadastrar Usuário em um laboratório. ");
		System.out.println("3 - listar usuários de um laboratório.  ");
		
	}
	
	static void space() {
		System.out.println("--------------------------");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
