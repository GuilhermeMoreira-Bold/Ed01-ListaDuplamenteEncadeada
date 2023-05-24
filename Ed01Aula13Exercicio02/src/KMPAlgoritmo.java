public class KMPAlgoritmo {
    public  String countSequenceOccurrences(ListaDuplamenteEncadeada list, ListaDuplamenteEncadeada sequence) {
        int count = 0;
        ListaDuplamenteEncadeada sequencias = new ListaDuplamenteEncadeada();
        int[] prefixTable = buildPrefixTable(sequence);

        int i = 0;  // Índice na lista
        int j = 0;  // Índice na sequência

        while (i < list.tamanho()) {            
            if (Integer.parseInt(list.pegaCelula(i).toString()) == Integer.parseInt(sequence.PegaCelula(j).toString())) {
                i++;
                j++;
                if (j == sequence.tamanho()) {    
                    count++;
                    sequencias.Adiciona("Vezes encontrada: " + count + " \nPosição do 1º elemento: " + (i -5) + " \nPosição do 2º elemento: " + (i -4) +  " \nPosição do 3º elemento: " + (i -3) + " \nPosição do 4º elemento: " + (i -2) + " \nPosição do 5º elemento: " + (i -1) + " \nPosição do 6º elemento: " + i);
                    // Reiniciar a busca a partir da próxima posição
                    j = prefixTable[j - 1];
                }
            } else {
                if (j != 0) {
                    j = prefixTable[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return sequencias.Imprimir();
    }

    private static int[] buildPrefixTable(ListaDuplamenteEncadeada sequence) {
        int[] prefixTable = new int[sequence.tamanho()];

        int length = 0;
        int i = 1;

        while (i < sequence.tamanho()) {
            if (Integer.parseInt(sequence.PegaCelula(i).toString())  == Integer.parseInt(sequence.PegaCelula(length).toString())) {
                length++;
                prefixTable[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = prefixTable[length - 1];
                } else {
                    prefixTable[i] = 0;
                    i++;
                }
            }
        }

        return prefixTable;
    }
}
