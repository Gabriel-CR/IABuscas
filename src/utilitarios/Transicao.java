package utilitarios;
public class Transicao {
    private int peso;
    private Estado destino;

    public Transicao() {
        super();
    }

    public Transicao(int peso, Estado destino) {
        this.peso = peso;
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Estado getDestino() {
        return destino;
    }

    public void setDestino(Estado destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Transicao [peso=" + peso + ", destino=" + destino + "]";
    }

    // public void getMap() {
    //     listaAdjacencias.entrySet().forEach(entry->{
	// 		System.out.println(entry.getKey().getNome() + " = " + Arrays.toString(entry.getValue()));
	// 	});
    // }
}
