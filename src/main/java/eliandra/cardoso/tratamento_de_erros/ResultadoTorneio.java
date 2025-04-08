package eliandra.cardoso.tratamento_de_erros;

import java.util.List;

public class ResultadoTorneio {
    private List<Time> times;
    private List<Partida> partidas;

    public ResultadoTorneio(List<Time> times, List<Partida> partidas) {
        this.times = times;
        this.partidas = partidas;
    }

    public void imprimirClassificacao(){
        System.out.println("\nClassificação Final:");
        times.stream()
                .sorted((timeA, timeB) -> timeB.getPontos() - timeA.getPontos())
                .forEach(time -> System.out.println(time.getNome() + " (" + time.getPontos() + " pontos)"));
    }

    public void imprimirResultados() {
        System.out.println("\nResultados:");
        partidas.forEach(p -> System.out.println(p.getResultado()));
    }
}
