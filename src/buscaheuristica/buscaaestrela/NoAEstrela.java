package buscaheuristica.buscaaestrela;

import buscaheuristica.TabelaHeuristica;
import utilitarios.Estado;

public class NoAEstrela implements Comparable<NoAEstrela> {
    private Estado estado;
    private NoAEstrela pai;
    private int custo;
    
    public NoAEstrela() {
        super();
    }

    public NoAEstrela(Estado estado, NoAEstrela pai, int custo) {
        this.estado = estado;
        this.pai = pai;
        this.custo = custo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public NoAEstrela getPai() {
        return pai;
    }

    public void setPai(NoAEstrela pai) {
        this.pai = pai;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    @Override
    public int compareTo(NoAEstrela o) {
        if(this.custo + TabelaHeuristica.VALORES.get(this.estado.getNome()) > o.getCusto() + TabelaHeuristica.VALORES.get(o.getEstado().getNome())) 
            return 1;
        else if(this.custo + TabelaHeuristica.VALORES.get(this.estado.getNome()) < o.getCusto() + TabelaHeuristica.VALORES.get(o.getEstado().getNome())) 
            return -1;
        else 
            return 0;
    }

    @Override
    public String toString() {
        return "No [estado=" + estado.getNome() + ", custo=" + custo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof NoAEstrela)) {
            return false;
        }

        NoAEstrela no = (NoAEstrela) obj;

        return this.getEstado().equals(no.getEstado());
    }
}
