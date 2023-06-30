package ordenacaomergesort;
// Programação: Manuel F. Paradela Ledón (implementação baseada no algoritmo de Mark Allen Weiss)

public class OrdenacaoMergeSort {
    public static void main(String[] args) {   new OrdenacaoMergeSort();   }
    
    public OrdenacaoMergeSort() {
        double vet[] = {71.2, 0.3, 6.3, -1.2, 5.4, 0.5, 0.2, 91.5, 33.3, 0.9};        
        System.out.println("Vetor desordenado:");
        visualizarVetor(vet);        
        MergeSort(vet); // Ordenamos        
        System.out.println("Vetor ordenado:");
        visualizarVetor(vet);
    }
    
    public void MergeSort(double vet[]) {
        double tempVet [] = new double[vet.length]; // Vetor adicional temporário
        MSort(vet, tempVet, 0, vet.length-1);  
    }
    
    public void MSort( double vet[], double tempVet[], int esq, int dir ){
        if (esq < dir) { // Caso contrário abandonamos este método (fim da recursão)
            int centro = (esq + dir)/2;
            MSort(vet, tempVet, esq, centro);
            MSort(vet, tempVet, centro+1, dir);
            Merge(vet, tempVet, esq, centro+1, dir);
        }
    }

    /*
        Este método fusiona em tempVet os elementos do vetor vet do trecho esq, centro, dir
        vet - é o vetor original que queremos ordenar
        tempVet - é o vetor temporário para colocar os elementos fusionados
        esq - é o índice mais à esquerda do trecho do vetor
        centro - é o índice onde começa a segunda metade
        dir  - é o índice mais à direita do trecho do vetor
     */
    public void Merge( double vet [], double tempVet [] , int esq, int centro, int dir ) {
        int fimTrechoEsquerdo = centro - 1;
        int i = esq;
        int qtdeElementos = dir - esq + 1;
        //------------ Mistura, fusão inicial de elementos:
        while( esq <= fimTrechoEsquerdo && centro <= dir )
            if( vet[ esq ] <= vet[ centro ] )
                tempVet[ i++ ] = vet[ esq++ ];
            else
                tempVet[ i++ ] = vet[centro++];
        //------------- Ciclo para copiar o resto da metade esquerda:
        while( esq <= fimTrechoEsquerdo )  
            tempVet[ i++ ] = vet[ esq++ ];
        //------------- Ciclo para copiar o resto da metade direita:
        while( centro <= dir )  
            tempVet[ i++ ] = vet[centro++];
        //-------- Finalmente, copiamos o trecho do vetor temporário para o vetor original:
        for( i = 0; i < qtdeElementos; i++, dir-- )
            vet[dir] = tempVet[dir];
    }
    
    public void visualizarVetor(double vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + "   ");
        }
        System.out.println();
    }    
}
