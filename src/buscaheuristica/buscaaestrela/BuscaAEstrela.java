package buscaheuristica.buscaaestrela;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import utilitarios.Transicao;
import utilitarios.Estado;
import utilitarios.Mapa;

public class BuscaAEstrela {
    private Queue<NoAEstrela> borda;
    private Stack<Estado> explorados;
    private NoAEstrela objetivo;

    public BuscaAEstrela() {
        this.borda = new PriorityQueue<NoAEstrela>();
        this.explorados = new Stack<Estado>();
    }

    public void setObjetivo(NoAEstrela objetivo) {
        this.objetivo = objetivo;
    }

    public Queue<NoAEstrela> getBorda() {
        return borda;
    }

    public void setBorda(Queue<NoAEstrela> borda) {
        this.borda = borda;
    }

    public Stack<Estado> getExplorados() {
        return explorados;
    }

    public void setExplorados(Stack<Estado> explorados) {
        this.explorados = explorados;
    }

    public NoAEstrela getObjetivo() {
        return objetivo;
    }

    public NoAEstrela busca(Mapa m, NoAEstrela n) {
        this.borda.add(n);
        
        do {
            NoAEstrela pai = borda.remove();

            if (pai.equals(this.objetivo)) {
                return pai;
            }

            this.explorados.add(pai.getEstado());

            for (Transicao t : m.getTransicoes().get(pai.getEstado())) {
                NoAEstrela filho = new NoAEstrela(t.getDestino(), pai, t.getPeso() + pai.getCusto());

                if (!explorados.contains(filho.getEstado()) || !borda.contains(filho)) {
                    borda.add(filho);
                } else if (borda.contains(filho)) {
                    for (NoAEstrela node : borda) {
                        if (node.getEstado().getNome() == filho.getEstado().getNome() && node.getCusto() > filho.getCusto()) {
                            this.borda.add(filho);
                            this.borda.remove(node);
                            break;
                        }
                    }
                }
            }
        } while(!this.borda.isEmpty());

        return null;
    }
}
