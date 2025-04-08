package eliandra.cardoso.tratamento_de_erros;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Torneio torneio = new Torneio();

        // Criando times a partir do nome
        torneio.adicionarTime("Brasil");
        torneio.adicionarTime(""); // Erro: nome inválido
        torneio.adicionarTime("Canadá");
        torneio.adicionarTime("Argentina");
        torneio.adicionarTime("Angola");

        // Criando partidas
        torneio.criarPartida("Brasil", "Canadá", 1, 0);
        torneio.criarPartida("Argentina", "Angola", 2, 0);
        torneio.criarPartida("Brasil", "Argentina", -10, -2); // Erro: número inválido de gols
        torneio.criarPartida("Brasil", "Argentina", 0, 2);
        torneio.criarPartida("Angola", "Canadá", 1, 1);
        torneio.criarPartida("Brasil", "Angola", 3, 2);
        torneio.criarPartida("Argentina", "Nigéria", 3, 3); // Erro: time não existe
        torneio.criarPartida("Argentina", "Canadá", 2, 4);

        // Exibe a classificação final e o resultado de cada partida
        ResultadoTorneio resultados = torneio.jogar();
        resultados.imprimirClassificacao();
        resultados.imprimirResultados();
    }

}
