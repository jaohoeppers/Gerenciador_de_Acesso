import java.util.concurrent.Semaphore;

public class MainN {

    public static void main(String [] args) {
        Semaphore sem = new Semaphore(2);
        for (int x = 0; x < 5; x++) {
            Procurador pro = new Procurador("Zeus", sem);
            pro.setName("Thread "+x);
            pro.start();
        }

//        GerenciadorArquivos arq =  new GerenciadorArquivos();
//        arq.try_read("src\\arquivosNomes\\nomescompletos.txt");
    }
}