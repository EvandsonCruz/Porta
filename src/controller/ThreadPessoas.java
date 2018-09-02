package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread {

	private int idPessoa;
	private Semaphore semaforo;
	private int corredor = 200;
	private int passo;
	private int somaPasso;
	private static int posicaoSaida;

	Random random = new Random();

	public ThreadPessoas(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
		start();
	}

	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
			pessoaPassando();
			pessoaSaindo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	public void pessoaAndando() {
		while (somaPasso < corredor) {
			passo = random.nextInt(3) + 4;
			somaPasso += passo;
			System.out.println("Pessoa #" + idPessoa + " andou " + passo + "m");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pessoaPassando() {
		System.out.println("Pessoa #" + idPessoa + " passando pela porta");
		try {
			Thread.sleep(random.nextInt(1000)+1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pessoaSaindo() {
		posicaoSaida++;
		System.out.println("Pessoa #" + idPessoa + " foi a " + posicaoSaida+ "o. a passar pela porta");
		}
	}

