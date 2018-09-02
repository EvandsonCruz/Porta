package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoas;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int i = 1;i<=4;i++) {
			ThreadPessoas threadpessoas = new ThreadPessoas(i,semaforo);
		}

	}

}
