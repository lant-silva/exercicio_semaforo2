package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCorredor;

public class Main {

	static Semaphore porta;
	
	public static void main(String[] args) {
		
		int pessoa = 4;
		int corredor = pessoa;
		porta = new Semaphore(1);
		
		for(int i=1;i<=pessoa;i++) {
			Thread caminhar = new ThreadCorredor(i, porta);
			caminhar.start();
		}
		
	}
	
}
