package eliandra.cardoso.tratamento_de_erros;

public class Time {
    private String nome;
    private int pontos;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int pontos){
        this.pontos += pontos;
    }
}
