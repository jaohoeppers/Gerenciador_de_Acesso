import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



public class GerenciadorArquivos {

    String filePath;


    public List<String> buscar(String palavra){

        List<String> listaTotal = new ArrayList<String>();
        for (int x = 0; x <= 9; x++ ) {
            filePath = "src\\arquivosNomes\\nomescompletos-0"+x+".txt";
            listaTotal.add(procurar(palavra,filePath).toString());
        }
        return listaTotal;
    }

    public List<String> procurar (String palavra, String arquivo){
        List<String> lista = new ArrayList<String>();
        int linha = 1;

            System.out.println("Thread: " + Thread.currentThread().getName() + " Acessando arquivo " + arquivo);
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(palavra)) {
                        lista.add(String.valueOf(arquivo + " - " + linha + " - " + palavra));
                    }
                    linha++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        return lista;
    }
}