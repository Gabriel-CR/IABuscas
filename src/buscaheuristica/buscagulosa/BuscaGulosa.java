package buscaheuristica.buscagulosa;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import utilitarios.Transicao;
import utilitarios.Estado;
import utilitarios.Mapa;

public class BuscaGulosa {
    private Queue<NoGuloso> borda;
    private Stack<Estado> explorados;
    private NoGuloso objetivo;

    public BuscaGulosa() {
        this.borda = new PriorityQueue<NoGuloso>();
        this.explorados = new Stack<Estado>();
    }

    public Queue<NoGuloso> getBorda() {
        return borda;
    }

    public void setBorda(Queue<NoGuloso> borda) {
        this.borda = borda;
    }

    public Stack<Estado> getExplorados() {
        return explorados;
    }

    public void setExplorados(Stack<Estado> explorados) {
        this.explorados = explorados;
    }

    public NoGuloso getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(NoGuloso objetivo) {
        this.objetivo = objetivo;
    }

    public NoGuloso busca(Mapa m, NoGuloso n) {
        this.borda.add(n);
        
        do {
            NoGuloso pai = borda.remove();

            if(pai.equals(this.objetivo)) {
                return pai;
            }

            this.explorados.add(pai.getEstado());

            for (Transicao t : m.getTransicoes().get(pai.getEstado())) { // EXPANDIR O MAIS PRÓXIMO DO OBJETIVO
                NoGuloso filho = new NoGuloso(t.getDestino(), pai, t.getPeso() + pai.getCusto());

                if (!explorados.contains(filho.getEstado()) || !borda.contains(filho)) {
                    this.borda.add(filho);
                } else if (borda.contains(filho)) {
                    for (NoGuloso node : borda) {
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
