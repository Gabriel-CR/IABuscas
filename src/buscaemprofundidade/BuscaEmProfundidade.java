package buscaemprofundidade;

import java.util.Stack;

import utilitarios.Estado;
import utilitarios.Mapa;
import utilitarios.No;
import utilitarios.Transicao;

public class BuscaEmProfundidade {
    private Stack<No> borda;
    private Stack<Estado> explorados;
    private No objetivo;

    public No getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(No objetivo) {
        this.objetivo = objetivo;
    }

    public BuscaEmProfundidade() {
        borda = new Stack<No>();
        explorados = new Stack<Estado>();
    }

    public Stack<No> getBorda() {
        return borda;
    }

    public void setBorda(Stack<No> borda) {
        this.borda = borda;
    }

    public Stack<Estado> getExplorados() {
        return explorados;
    }
    
    public void setExplorados(Stack<Estado> explorados) {
        this.explorados = explorados;
    }
    
    public No buscar(Mapa m, No n) {
        borda.add(n);
        
        do {
            No no = this.borda.pop();
            this.explorados.add(no.getEstado());
            
            for (Transicao t : m.getTransicoes().get(no.getEstado())) {
                No filho = new No(t.getDestino(), no, t.getPeso() + no.getCusto());
                
                if(!explorados.contains(filho.getEstado()) && !borda.contains(filho)) {
                    if(filho.equals(objetivo)) {
                        return filho;
                    }
                    this.borda.add(filho);
                }
            }
        } while (!this.borda.empty());

        return null;
    }
}
