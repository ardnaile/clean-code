package eliandra.cardoso.tratamento_de_erros;

public class Partida {
    private String nomeA;
    private String nomeB;
    private int golsA;
    private int golsB;

    public Partida(String timeA, String timeB, int golsA, int golsB) {
        this.nomeA = timeA;
        this.nomeB = timeB;
        this.golsA = golsA;
        this.golsB = golsB;
    }

    public String getTimeA() {
        return nomeA;
    }

    public String getTimeB() {
        return nomeB;
    }

    public int getGolsA() {
        return golsA;
    }

    public int getGolsB() {
        return golsB;
    }

    public String getResultado(){
        return nomeA + " " + golsA + "x" + golsB + " " + nomeB;
    }
}
