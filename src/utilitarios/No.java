package utilitarios;
public class No implements Comparable<No>{
    private Estado estado;
    private No pai;
    private int custo;
    
    public No() {
        super();
    }

    public No(Estado estado, No pai, int custo) {
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

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    @Override
    public int compareTo(No o) {
        if(this.custo > o.getCusto()) 
            return 1;
        else if(this.custo < o.getCusto()) 
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
        if(obj==this) {
            return true;
        }

        if(!(obj instanceof No)) {
            return false;
        }

        No no = (No) obj;

        return this.getEstado().equals(no.getEstado());
    }
}
