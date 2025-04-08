import java.util.concurrent.Semaphore;

public class Procurador extends Thread{

    String palavra;
    Semaphore sem;

    public Procurador(String palavra, Semaphore sem) {
        this.palavra = palavra;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            System.out.println("Thread: "+ Thread.currentThread().getName() +"[+] Buscando palavra " + palavra);
            GerenciadorArquivos g = new GerenciadorArquivos();
            System.out.println(g.buscar(palavra).toString());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Thread: " + Thread.currentThread().getName() + "[-] Liberando Procurador");
            sem.release();
        }

    }

//    public void start(String nome){
//        Thread.currentThread().setName(nome);
//    }
}
