import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        int numeros [] =  new int[1000];
        Random gerar = new Random();
        ListaDupla lista = new ListaDupla();
        NumeroPrimo primo = new NumeroPrimo();


        for(int i = 0; i < 1000; i++){
            int numero  = gerar.nextInt(19999) - 9999;
            System.out.println("número: " + numero);
            numeros[i]= numero;
        }
        for(int i = 0; i < numeros.length; i++){
            lista.AdicionaOrdenado(numeros[i]);
        }
        System.out.println("Lista ordenada crescente" + lista.Imprimir());
        System.out.println("Lista ordenada decrescente" + lista.imprimirDecrescente());
        for(int i = 0; i < lista.TotaldeElementos; i++){
            if(primo.ehPrimo(Integer.parseInt(lista.PegaCelula(i).toString()))){
                lista.Remove(i);
            }
        }        
        System.out.println("Lista ordenada crescente sem números primos: " + lista.Imprimir());
        System.out.println("Lista ordenada decrescente sem números primos: " + lista.imprimirDecrescente());
    }
}
