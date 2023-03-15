package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread{

	static final int distancia=200;
	int pessoa;
	Semaphore porta;
	int pessoaDistancia=0;
	
	public ThreadCorredor(int pessoa, Semaphore porta) {
		this.pessoa = pessoa;
		this.porta = porta;
	}
	
	@Override
	public void run() {
		
		while(pessoaDistancia<=distancia) {
			pessoaCaminhando();
		}
		
		try {
			porta.acquire();
			portaEntrar();
		} catch (Exception e) {
			
		} finally {
			porta.release();
		}
		
	}
	
	public void pessoaCaminhando(){

		int velocidade = (int) (Math.random()*2)+4;
		pessoaDistancia += velocidade;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Distancia pessoa "+pessoa+": "+pessoaDistancia);
	}
	
	public void portaEntrar() {
		System.out.println("Pessoa "+pessoa+" chegou na porta");
		portaEntrando();
		portaFechar();
	}
	
	public void portaEntrando() {
		System.out.println("Entrando");
		int entrando = (int) (Math.random()*2001)+1000;
		try {
			Thread.sleep(entrando);
		} catch (Exception e) {
		}
	}
	
	public void portaFechar() {
		System.out.println("Pessoa "+pessoa+" entrou");
		
	}
	
}
