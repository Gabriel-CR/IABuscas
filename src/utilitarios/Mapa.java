package utilitarios;
import java.util.HashMap;
import java.util.LinkedList;

public class Mapa {
    private HashMap<Estado, LinkedList<Transicao>> transicoes;

    public HashMap<Estado, LinkedList<Transicao>> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(HashMap<Estado, LinkedList<Transicao>> transicoes) {
        this.transicoes = transicoes;
    }

    public Mapa() {
        transicoes = new HashMap<Estado, LinkedList<Transicao>>();
    }

    @Override
    public String toString() {
        return transicoes.toString();
    }
}