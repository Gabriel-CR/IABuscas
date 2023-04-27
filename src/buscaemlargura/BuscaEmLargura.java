package buscaemlargura;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import utilitarios.Estado;
import utilitarios.Mapa;
import utilitarios.No;
import utilitarios.Transicao;

public class BuscaEmLargura {
    private Queue<No> borda;
    private Stack<Estado> explorados;
    private No objetivo;

    public BuscaEmLargura() {
        this.borda = new LinkedList<No>();
        this.explorados = new Stack<Estado>();
    }
    
    public void setObjetivo(No objetivo) {
        this.objetivo = objetivo;
    }

    public No buscar(Mapa m, No no) {
        borda.add(no);

        do {
            No pai = this.borda.remove();
            this.explorados.add(pai.getEstado());

            for (Transicao t : m.getTransicoes().get(pai.getEstado())) {
                // Para que o filho tenha a ditancia total percorrida até ele usar
                No filho = new No(t.getDestino(), pai, t.getPeso() + pai.getCusto());
                
                if (!this.explorados.contains(filho.getEstado()) || !this.borda.contains(filho)) {
                    if(filho.equals(objetivo)) {
                        return filho;
                    }
                    this.borda.add(filho);
                }
            }
        } while (!this.borda.isEmpty());
        
        return null;
    }
}
