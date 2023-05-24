import java.util.Random;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        ListaDuplamenteEncadeada listaSequencia = new ListaDuplamenteEncadeada();
        int[] sequencia = {1,15,16,25,32,36};
        KMPAlgoritmo kmp = new KMPAlgoritmo();

        for(int i = 0; i < 51000000; i++) {
         int numeroAleatorio =    r.nextInt(59) + 1;
         lista.Adiciona(numeroAleatorio);
        }
        System.out.println(lista.tamanho());
    

        listaSequencia.Adiciona(1);
        listaSequencia.Adiciona(15);
        listaSequencia.Adiciona(16);
        listaSequencia.Adiciona(25);
        listaSequencia.Adiciona(32);
        listaSequencia.Adiciona(36);
  
        lista.Adiciona(1);
        lista.Adiciona(15);
        lista.Adiciona(16);
        lista.Adiciona(25);
        lista.Adiciona(32);
        lista.Adiciona(36);
 
 
        System.out.println(kmp.countSequenceOccurrences(lista, listaSequencia));
        
        
        // System.out.println(lista.Imprimir());
    }
}
