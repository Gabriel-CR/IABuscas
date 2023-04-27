package utilitarios;
public class Estado {
    private String nome;
    
    public Estado() {
        super();
    }

    public Estado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estado [nome=" + nome + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this) {
            return true;
        }

        if(!(obj instanceof Estado)) {
            return false;
        }
        
        Estado e = (Estado) obj;

        return this.nome.equals(e);
    }
}