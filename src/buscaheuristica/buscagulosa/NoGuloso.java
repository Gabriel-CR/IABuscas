package buscaheuristica.buscagulosa;

import utilitarios.Estado;
import buscaheuristica.TabelaHeuristica;

public class NoGuloso implements Comparable<NoGuloso> {
    private Estado estado;
    private NoGuloso pai;
    private int custo;

    public NoGuloso(Estado estado, NoGuloso pai, int custo) {
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

    public NoGuloso getPai() {
        return pai;
    }

    public void setPai(NoGuloso pai) {
        this.pai = pai;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof NoGuloso)) {
            return false;
        }

        NoGuloso no = (NoGuloso) obj;

        return this.getEstado().equals(no.getEstado());
    }

    @Override
    public int compareTo(NoGuloso o) {
        if (TabelaHeuristica.VALORES.get(this.estado.getNome()) > TabelaHeuristica.VALORES.get(o.getEstado().getNome())) 
            return 1;
        else if (TabelaHeuristica.VALORES.get(this.estado.getNome()) < TabelaHeuristica.VALORES.get(o.getEstado().getNome())) 
            return -1;
        else 
            return 0;
    }   

    @Override
    public String toString() {
        return "No [estado=" + estado.getNome() + ", custo=" + custo + "]";
    }  
}
