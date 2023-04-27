package buscacustouniforme;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import utilitarios.Estado;
import utilitarios.Mapa;
import utilitarios.No;
import utilitarios.Transicao;

public class BuscaCustoUniforme {
    private Queue<No> borda;
    private Stack<Estado> explorados;
    private No objetivo;

    public BuscaCustoUniforme() {
        borda = new PriorityQueue<No>();
        explorados = new Stack<Estado>();
    }

    public BuscaCustoUniforme(No n) {
        objetivo = n;
        borda = new PriorityQueue<No>();
        explorados = new Stack<Estado>();
    }

    public Queue<No> getBorda() {
        return borda;
    }

    public void setBorda(Queue<No> borda) {
        this.borda = borda;
    }

    public Stack<Estado> getExplorados() {
        return explorados;
    }

    public void setExplorados(Stack<Estado> explorados) {
        this.explorados = explorados;
    }

    public No getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(No objetivo) {
        this.objetivo = objetivo;
    }

    public No buscar(Mapa m, No n) {
        // borda com nó.estado inicial e 
        // explorados começa vazio no construtor
        this.borda.add(n);

        // faça enquanto borda não for vazia
        do {
            // no recebe elemento da borda
            No pai = borda.remove();

            // se no.estado é objetivo
            if (pai.equals(this.objetivo)) {
                // retorne solução
                return pai;
            }
            
            // adicionar no.estado a explorados
            explorados.add(pai.getEstado());

            // para cada ação aplicável em no.estado
            for (Transicao t : m.getTransicoes().get(pai.getEstado())) {
                // filho <- criar nó filho
                No filho = new No(t.getDestino(), pai, t.getPeso() + pai.getCusto());

                // se filho.estado não está em
                // explorados ou borda
                if (!explorados.contains(filho.getEstado()) && !borda.contains(filho)) {
                    // adicionar filho em borda
                    borda.add(filho);
                } else if (borda.contains(filho)) {
                    for (No node : borda) {
                        if (node.getEstado().getNome() == filho.getEstado().getNome() && node.getCusto() > filho.getCusto()) {
                            this.borda.add(filho);
                            this.borda.remove(node);
                            break;
                        }
                    }
                }
            }
        } while (!borda.isEmpty());
        
        return null;
    }
}
