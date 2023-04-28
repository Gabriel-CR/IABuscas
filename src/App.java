import buscaemlargura.BuscaEmLargura;
import buscaemprofundidade.BuscaEmProfundidade;
import buscacustouniforme.BuscaCustoUniforme;
import buscaheuristica.buscagulosa.BuscaGulosa;
import buscaheuristica.buscaaestrela.BuscaAEstrela;
import buscaheuristica.buscagulosa.NoGuloso;
import buscaheuristica.buscaaestrela.NoAEstrela;

import utilitarios.*;

/*
 * INSTRUÇÕES:
 * 
 * Rode o código com o comando /usr/bin/env java -cp ./bin App [busca] [origem] [destino]
 * Exemplo: /usr/bin/env java -cp ./bin App bae Arad Bucharest
 * 
 * [busca] pode ser: 
 *      bsl = busca em largura,         
 *      bcu = busca de custo uniforme,  
 *      bcp = busca em profundidade,    
 *      bgl = busca gulosa, 
 *      bae = busca a estrela
 * 
 * [origem] pode ser:
 *     Nome da cidade de origem (ex: Arad) sempre com a primeira letra maiúscula
 *     OBS: Para a cidade Rimnicu Vilcea passe o nome unido por um "-" (ex: Rimnicu-Vilcea)
 * 
 * [destino] pode ser:
 *      Nome da cidade de destino (ex: Bucharest) sempre com a primeira letra maiúscula
 *      Obs: para as buscas heurísticas, o destino deve ser sempre Bucharest
 *      OBS: Para a cidade Rimnicu Vilcea passe o nome unido por um "-" (ex: Rimnicu-Vilcea)
 */

public class App {
    public static void main(String[] args) throws Exception {
        Dados dados = new Dados();
        Estado[] estados = dados.makeEstado();
        Mapa m = dados.makeMapa();
        App app = new App();

        int origem = app.converterNomeParaNumero(args[1]);
        int chegada = app.converterNomeParaNumero(args[2]);

        if (origem == -1 || chegada == -1) {
            System.out.println("ERRO: Estado não encontrado");
            return;
        } else if (origem == chegada) {
            if (args[0].equals("bsl")) {
                System.out.println("BUSCA EM LARGURA");
                No no = new No(estados[origem], null, 0);
                System.out.println(no + "\n\ncusto total = 0");
                return;
            } else if (args[0].equals("bcp")) {
                System.out.println("BUSCA EM PROFUNDIDADE");
                No no = new No(estados[origem], null, 0);
                System.out.println(no + "\n\ncusto total = 0");
                return;
            }
        }

        if (args[0].equals("bsl")) {
            System.out.println("BUSCA EM LARGURA");
            BuscaEmLargura bel = new BuscaEmLargura();
            bel.setObjetivo(new No(estados[chegada], null, 0));

            No n = new No(estados[origem], null, 0);
            No sol = bel.buscar(m, n);
            
            System.out.println(app.printCaminho(sol));
        } else if (args[0].equals("bcp")) {
            System.out.println("BUSCA EM PROFUNDIDADE");
            BuscaEmProfundidade bcp = new BuscaEmProfundidade();
            bcp.setObjetivo(new No(estados[chegada], null, 0));

            No n = new No(estados[origem], null, 0);
            No sol = bcp.buscar(m, n);

            System.out.println(app.printCaminho(sol));
        } else if (args[0].equals("bcu")) {
            System.out.println("BUSCA DE CUSTO UNIFORME");
            BuscaCustoUniforme bcu = new BuscaCustoUniforme();
            bcu.setObjetivo(new No(estados[chegada], null, 0));

            No n = new No(estados[origem], null, 0);
            No sol = bcu.buscar(m, n);

            System.out.println(app.printCaminho(sol));
        } else if (args[0].equals("bgl")) {
            System.out.println("BUSCA GULOSA - HEURISTICA 1");

            BuscaGulosa bg = new BuscaGulosa();
            bg.setObjetivo(new NoGuloso(estados[13], null, 0));
            NoGuloso n4 = new NoGuloso(estados[origem], null, 0);
            NoGuloso sol4 = bg.busca(m, n4);

            System.out.println(app.printCaminho(sol4));
        } else if (args[0].equals("bae")) {
            System.out.println("BUSCA A* - HEURISTICA 2");

            BuscaAEstrela ba = new BuscaAEstrela();
            ba.setObjetivo(new NoAEstrela(estados[13], null, 0));
            NoAEstrela n = new NoAEstrela(estados[origem], null, 0);
            NoAEstrela sol = ba.busca(m, n);

            System.out.println(app.printCaminho(sol));
        } else {
            System.out.println("Nenhuma busca foi selecionada");
        }
    }

    public String printCaminho(NoAEstrela no) {
        String caminho = "\ncusto total = " + no.getCusto();
        while (no.getPai() != null) {
            caminho = no.toString() + "\n" + caminho;
            no = no.getPai();
        }
        caminho = no.toString() + "\n" + caminho;
        return caminho;
    }

    public String printCaminho(NoGuloso no) {
        String caminho = "\ncusto total = " + no.getCusto();
        while (no.getPai() != null) {
            caminho = no.toString() + "\n" + caminho;
            no = no.getPai();
        }
        caminho = no.toString() + "\n" + caminho;
        return caminho;
    }

    public String printCaminho(No no) {
        String caminho = "\ncusto total = " + no.getCusto();
        while (no.getPai() != null) {
            caminho = no.toString() + "\n" + caminho;
            no = no.getPai();
        }
        caminho = no.toString() + "\n" + caminho;
        return caminho;
    }

    public int converterNomeParaNumero(String estadoNome) {
        /* ESTADOS
            0  = "Oradea"
            1  = "Zerind"
            2  = "Arad"
            3  = "Sibiu"
            4  = "Fagaras"
            5  = "Timisoara"
            6  = "Rimnicu-Vilcea"
            7  = "Lugoj"
            8  = "Mehadia"
            9  = "Pitesti"
            10 = "Drobeta"
            11 = "Craiova"
            12 = "Giurgiu"
            13 = "Bucharest"
            14 = "Urziceni"
            15 = "Hirsova"
            16 = "Eforie"
            17 = "Vaslui"
            18 = "Iasi"
            19 = "Neamt"
        */

        if (estadoNome.equals("Oradea")) {
            return 0;
        } else if (estadoNome.equals("Zerind")) {
            return 1;
        } else if (estadoNome.equals("Arad")) {
            return 2;
        } else if (estadoNome.equals("Sibiu")) {
            return 3;
        } else if (estadoNome.equals("Fagaras")) {
            return 4;
        } else if (estadoNome.equals("Timisoara")) {
            return 5;
        } else if (estadoNome.equals("Rimnicu-Vilcea")) {
            return 6;
        } else if (estadoNome.equals("Lugoj")) {
            return 7;
        } else if (estadoNome.equals("Mehadia")) {
            return 8;
        } else if (estadoNome.equals("Pitesti")) {
            return 9;
        } else if (estadoNome.equals("Drobeta")) {
            return 10;
        } else if (estadoNome.equals("Craiova")) {
            return 11;
        } else if (estadoNome.equals("Giurgiu")) {
            return 12;
        } else if (estadoNome.equals("Bucharest")) {
            return 13;
        } else if (estadoNome.equals("Urziceni")) {
            return 14;
        } else if (estadoNome.equals("Hirsova")) {
            return 15;
        } else if (estadoNome.equals("Eforie")) {
            return 16;
        } else if (estadoNome.equals("Vaslui")) {
            return 17;
        } else if (estadoNome.equals("Iasi")) {
            return 18;
        } else if (estadoNome.equals("Neamt")) {
            return 19;
        } else {
            return -1;
        }
    }
}
