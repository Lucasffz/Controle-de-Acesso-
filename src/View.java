import java.util.ArrayList;
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
			lab = controle.cadastrarLaboratorio(nome, null);
			controle.adicionarLaboratorio(lab);
			System.out.println("Laborat�rio cadastrado com sucesso.");
			break;
			
		case 2:
			System.out.println("gg izi");
			break;
		}
		
		
		
		}
		
		
		
	}
	
	
	
	static void menu() {
		System.out.println("Digite sua opera��o.");
		System.out.println("1 - Cadastrar um laborat�rio. ");
		System.out.println("2 - Mostra laborat�rios. ");
		System.out.println("2 - Cadastrar Usu�rio em um laborat�rio. ");
		System.out.println("3 - listar usu�rios de um laborat�rio.  ");
		
	}
	
	static void space() {
		System.out.println("--------------------------");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
