import java.util.Scanner;


public class View {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		UsuarioPadrao padrao = new UsuarioPadrao ();
		
		System.out.println("Criar usu�rio padr�o: ");
		System.out.println("Digite o nome do usu�rio padr�o: ");
		String namep = input.next();
		padrao.setNome(namep);
		System.out.println("Digite a senha do usu�rio pad�o: ");
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
			while(!acesso) {
				System.out.println("Digite a senha de usu�rio padr�o: ");
				String senha = input.next();
				acesso = controle.verificarChave(senha);
				
				if(acesso)
					System.out.println("Acesso liberado.");
				else {
					System.out.println("senha incorreta.");
					System.out.println("Acesso negado.");
				}
			}
			
			
			String nome;
			System.out.println("Digite o nome do laborat�rio: ");
			nome = input.nextLine();
			System.out.println("Digite o Coordenador do labor�torio.");
			
			
			
			
			Laboratorio lab;
			lab = controle.cadastrarLaboratorio(nome, null);
		}
		
		
		
		
		
		
		
	}
	
	
	
	static void menu() {
		System.out.println("Digite sua opera��o.");
		System.out.println("1 - Cadastrar um laborat�rio. ");
		System.out.println("2 - Cadastrar Usu�rio em um laborat�rio. ");
		System.out.println("3 - listar usu�rios de um laborat�rio.  ");
		
	}
	
	static void space() {
		System.out.println("--------------------------");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
