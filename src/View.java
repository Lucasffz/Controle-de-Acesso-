import java.util.Scanner;


public class View {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Controle c = new Controle();
		UsuarioPadrao padrao = new UsuarioPadrao ();
		
		System.out.println("Criar usu�rio padr�o: ");
		System.out.println("Digite o nome do usu�rio padr�o: ");
		String namep = input.next();
		padrao.setNome(namep);
		System.out.println("Digite a senha do usu�rio pad�o: ");
		String keyp = input.next();
		padrao.setSenha(keyp);
		
		
		
		
		
		
		
		
		
		
		
		menu();
		int op;
		op = input.nextInt();
		switch(op) {
		case 1:
			String nome;
			System.out.println("Digite o nome do laborat�rio: ");
			nome = input.nextLine();
			System.out.println("Digite o Coordenador do labor�torio.");
			
			
			
			
			Laboratorio lab;
			lab = c.cadastrarLaboratorio(nome, null);
		}
		
		
		
		
		
		
		
	}
	
	
	
	static void menu() {
		System.out.println("Digite sua opera��o.");
		System.out.println("1 - Cadastrar um laborat�rio. ");
		System.out.println("2 - Cadastrar Usu�rio em um laborat�rio. ");
		System.out.println("3 - listar usu�rios de um laborat�rio.  ");
		
	}
	
	static void primeiroUsuario() {
		System.out.println("Criar usu�rio padr�o: ");
		UsuarioPadrao padrao = new UsuarioPadrao ();
		System.out.println("Digite o nome do usu�rio padr�o: ");
		String namep = input.next();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
