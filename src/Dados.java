import java.util.Arrays;
import java.util.LinkedList;

import utilitarios.Estado;
import utilitarios.Mapa;
import utilitarios.Transicao;

class Dados {
    private Estado[] estados = new Estado[20];
    private Mapa mapa = new Mapa();

    public Dados() {
    }

    public Estado[] makeEstado() {
        this.estados[0]  = new Estado("Oradea");
        this.estados[1]  = new Estado("Zerind");
        this.estados[2]  = new Estado("Arad");
        this.estados[3]  = new Estado("Sibiu");
        this.estados[4]  = new Estado("Fagaras");
        this.estados[5]  = new Estado("Timisoara");
        this.estados[6]  = new Estado("Rimnicu Vilcea");
        this.estados[7]  = new Estado("Lugoj");
        this.estados[8]  = new Estado("Mehadia");
        this.estados[9]  = new Estado("Pitesti");
        this.estados[10] = new Estado("Drobeta");
        this.estados[11] = new Estado("Craiova");
        this.estados[12] = new Estado("Giurgiu");
        this.estados[13] = new Estado("Bucharest");
        this.estados[14] = new Estado("Urziceni");
        this.estados[15] = new Estado("Hirsova");
        this.estados[16] = new Estado("Eforie");
        this.estados[17] = new Estado("Vaslui");
        this.estados[18] = new Estado("Iasi");
        this.estados[19] = new Estado("Neamt");

        return this.estados;
    }

    public Mapa makeMapa() {
        this.mapa.getTransicoes().put(estados[0], new LinkedList<Transicao>(
                Arrays.asList(
                    new Transicao(71, estados[1]), 
                    new Transicao(151, estados[3])
                ) 
        ));

        this.mapa.getTransicoes().put(estados[1], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(71, estados[0]),
                new Transicao(75, estados[2])
            )
        ));

        this.mapa.getTransicoes().put(estados[2], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(140, estados[3]),
                new Transicao(75, estados[1]),
                new Transicao(118, estados[5])
            )
        ));

        this.mapa.getTransicoes().put(estados[3], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(140, estados[2]),
                new Transicao(99, estados[4]),
                new Transicao(80, estados[6]),
                new Transicao(151, estados[0])
            )
        ));

        this.mapa.getTransicoes().put(estados[4], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(99, estados[3]),
                new Transicao(211, estados[13])
            )
        ));

        this.mapa.getTransicoes().put(estados[5], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(111, estados[7]),
                new Transicao(118, estados[2])
            )
        ));

        this.mapa.getTransicoes().put(estados[6], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(80, estados[3]),
                new Transicao(97, estados[9]),
                new Transicao(146, estados[11])
            )
        ));

        this.mapa.getTransicoes().put(estados[7], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(70, estados[8]),
                new Transicao(111, estados[5])
            )
        ));
        
        this.mapa.getTransicoes().put(estados[8], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(75, estados[10]),
                new Transicao(70, estados[7])
            )
        ));

        this.mapa.getTransicoes().put(estados[9], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(97, estados[6]),
                new Transicao(138, estados[11]),
                new Transicao(101, estados[13])
            )
        ));
        
        this.mapa.getTransicoes().put(estados[10], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(75, estados[8]),
                new Transicao(120, estados[11])
            )
        ));

        this.mapa.getTransicoes().put(estados[11], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(120, estados[10]),
                new Transicao(138, estados[9]),
                new Transicao(146, estados[6])
            )
        ));
        
        this.mapa.getTransicoes().put(estados[12], new LinkedList<Transicao>(
            Arrays.asList(new Transicao(90, estados[13]))
        ));

        this.mapa.getTransicoes().put(estados[13], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(85, estados[14]),
                new Transicao(90, estados[12]),
                new Transicao(211, estados[4]),
                new Transicao(101, estados[9])
            )
        ));
  
        this.mapa.getTransicoes().put(estados[14], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(98, estados[15]),
                new Transicao(85, estados[13]),
                new Transicao(142, estados[17])
            )
        ));

        this.mapa.getTransicoes().put(estados[15], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(98, estados[14]),
                new Transicao(86, estados[16])
            )
        ));

        this.mapa.getTransicoes().put(estados[16], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(86, estados[15])
            )
        ));

        this.mapa.getTransicoes().put(estados[17], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(92, estados[18]),
                new Transicao(142, estados[14])
            )
        ));

        this.mapa.getTransicoes().put(estados[18], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(92, estados[17]),
                new Transicao(87, estados[19])
            )
        ));

        this.mapa.getTransicoes().put(estados[19], new LinkedList<Transicao>(
            Arrays.asList(
                new Transicao(87, estados[18])
            )
        ));

        return this.mapa;
    }
}