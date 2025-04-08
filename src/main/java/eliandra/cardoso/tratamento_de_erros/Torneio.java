package eliandra.cardoso.tratamento_de_erros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Torneio {
    private static final Logger logger = LoggerFactory.getLogger(Torneio.class);
    private List<Time> times = new ArrayList<>();
    private List<Partida> partidas = new ArrayList<>();

    public void adicionarTime(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty())
                throw new IllegalArgumentException("Nome inválido");

            boolean existe = times.stream().anyMatch(time -> time.getNome().equalsIgnoreCase(nome));
            if (existe)
                throw new IllegalArgumentException("Time já existe");

            times.add(new Time(nome));
            System.out.println("Time \"" + nome + "\" adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            logger.error("Erro ao adicionar time: {}", nome, e);
        }
    }

    private Time encontrarTime(String nome) {
        return times.stream()
                .filter(t -> t.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Time não existe"));
    }

    public void criarPartida(String nomeA, String nomeB, int golsA, int golsB) {
        try {
            Time timeA = encontrarTime(nomeA);
            Time timeB = encontrarTime(nomeB);

            if (golsA < 0 || golsB < 0)
                throw new IllegalArgumentException("Número inválido de gols");

            partidas.add(new Partida(nomeA, nomeB, golsA, golsB));

            if (golsA > golsB) {
                timeA.adicionarPontos(3);
            } else if (golsB > golsA) {
                timeB.adicionarPontos(3);
            } else {
                timeA.adicionarPontos(1);
                timeB.adicionarPontos(1);
            }

            System.out.println("Partida entre \"" + nomeA + "\" e \"" + nomeB + "\" criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            logger.error("Erro ao criar partida entre {} e {}: {}x{}", nomeA, nomeB, golsA, golsB, e);
        }
    }

    public ResultadoTorneio jogar() {
        return new ResultadoTorneio(times, partidas);
    }
}
