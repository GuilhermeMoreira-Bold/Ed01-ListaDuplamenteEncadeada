public abstract class ListaDupla {
    Celula Primeira;
    Celula Ultima;
    Celula Atual;
    int TotaldeElementos = 0;

    boolean PosicaoOcupada(int pos){
        return((pos >= 0)&&(pos < this.TotaldeElementos));
    }
    Celula pegaCelula(int pos){
        if(!this.PosicaoOcupada(pos)){
        throw new IllegalArgumentException("Posicao nao existe");
    }else{
        if(pos == 0){
            this.Atual = this.Primeira;
        }else{
            Celula auxiliar = this.Atual;
            if(Atual.getProxima() != null){
                auxiliar = auxiliar.getProxima();
                this.Atual = auxiliar;
            // }else{
            //     Atual = PegaCelula(pos);
            }            
        }
        if(Atual != null){
            return (Atual);
        }else{
            throw new IllegalArgumentException("Celula nao existe na posição " + pos);	
        }
        
        } }

    Celula PegaCelula(int pos){
        if(!this.PosicaoOcupada(pos)){
        throw new IllegalArgumentException("Posicao nao existe");}else{
        Celula atual = this.Primeira; 
        for(int i=0; i < pos; i++){
        atual = atual.getProxima();
        } 
        return(atual);
        } }

    void AdicionaNoComeco(Object elemento){
        if(this.TotaldeElementos == 0){
        Celula nova = new Celula(elemento);
        this.Primeira = nova;
        this.Ultima = nova;
        }else {
            Celula nova = new Celula(this.Primeira, elemento);
            this.Primeira.setAnterior(nova);
            this.Primeira = nova;
        }
        this.TotaldeElementos++; }
        
    void Adiciona(Object elemento){
        if(this.TotaldeElementos == 0){
        this.AdicionaNoComeco(elemento);
        }else{
            Celula nova = new Celula(elemento);
            this.Ultima.setProxima(nova);
            nova.setAnterior(this.Ultima);
            this.Ultima = nova;
            this.TotaldeElementos++;
            } 
        }
    
    void Adiciona(int pos, Object elemento){
        if(pos == 0){
        this.AdicionaNoComeco(elemento);
        }else if(pos == this.TotaldeElementos){
        this.Adiciona(elemento);
        }else {
        Celula anterior = this.PegaCelula(pos-1);
        Celula proxima = anterior.getProxima(); 
        Celula nova = new Celula(anterior.getProxima(),elemento);
        nova.setAnterior(anterior);
        anterior.setProxima(nova);
        proxima.setAnterior(nova);
        this.TotaldeElementos++;
        } 
    }

    Celula RemovedoComeco(){
        Celula auxiliar = this.Primeira;
        if(!this.PosicaoOcupada(0)){
        throw new IllegalArgumentException("Posicao nao Existe");
        }else{
            this.Primeira = this.Primeira.getProxima();
            this.TotaldeElementos--;
        }
        if(this.TotaldeElementos == 0){
        this.Ultima = null; 
        }
        return auxiliar;
        }
            
    void RemovedoFim(){
            if(!this.PosicaoOcupada(TotaldeElementos-1)){
            throw new IllegalArgumentException("Posicao nao existe");
            }else{
            if(this.TotaldeElementos == 1){
            this.RemovedoComeco();
            }else{ 
            Celula penultima = this.Ultima.getAnterior();
            penultima.setProxima(null);
            this.Ultima = penultima;
            this.TotaldeElementos--;
        }
     }
    }    
    
    void Remove(int pos){
        if(!this.PosicaoOcupada(pos)){
        throw new IllegalArgumentException("Posicao nao  Existe");
        }else{
            if (pos == 0){
            this.RemovedoComeco();
            }else if(pos == this.TotaldeElementos -1){
            this.RemovedoFim();
            }else {
            Celula anterior = this.PegaCelula(pos -1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima(); 
            anterior.setProxima(proxima);                                        
            proxima.setAnterior(anterior);                                      
            this.TotaldeElementos--;                             
            } 
        }
    }
                                        
    boolean Contem(Object elemento){
                                            
        Celula atual = this.Primeira; 
                                           
        while(atual != null){
                                           
            if(atual.getElemento().equals(elemento)){
                                           
                return(true);
                                            
            }                                      
            atual = atual.getProxima();                                         
        }                                            
        return(false);                                          
    }
                                           
    int tamanho(){                                             
        return(this.TotaldeElementos);                                               
    }
                                                
    void EsvaziaLista(){                                                 
        this.Primeira = null;                                                 
        this.Ultima = null;                                                                                          
        this.TotaldeElementos = 0;                                                                
    }
                                                    
    String Imprimir(){
                                                        
        if(this.TotaldeElementos == 0){                                                       
            return("[]");                                                       
        }else{                                        
            StringBuilder builder = new StringBuilder("[");
                                                        
            Celula atual = this.Primeira;
                                                        
            for(int i=0; i < this.TotaldeElementos -1; i++){                                                           
                builder.append(atual.getElemento());                                                         
                builder.append(", ");                                                        
                atual = atual.getProxima();                                                            
            }                                                           
            builder.append(atual.getElemento());                                                          
            builder.append("]");                                                           
            return(builder.toString());                                                            
        } 
    }  
                                                            
    String imprimirDecrescente() {
        if (this.TotaldeElementos == 0) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder("[");
            Celula atual = this.Ultima;
    
            for (int i = TotaldeElementos; i > 0; i--) {
                if (atual != null) {
                    builder.append(atual.getElemento());
                    builder.append(", ");
                    atual = atual.getAnterior();
                }
            }
    
            if (atual != null) {
                builder.append(atual.getElemento());
            }
    
            builder.append("]");
            return builder.toString();
        }
    }
    
    
}
