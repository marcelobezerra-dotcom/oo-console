package missao;

public enum Dificuldade {
    FACIL(30, 1, 1),
    MEDIO(20, 2, 2),
    DIFICIL(15, 3, 3);

    private final int combustivelInicial;
    private final int qtdAsteroides;
    private final int qtdInimigos;

    Dificuldade(int combustivelInicial, int qtdAsteroides, int qtdInimigos) {
        this.combustivelInicial = combustivelInicial;
        this.qtdAsteroides = qtdAsteroides;
        this.qtdInimigos = qtdInimigos;
    }

    public int getCombustivelInicial() {
        return combustivelInicial;
    }

    public int getPontuacaoInicial() {
        return combustivelInicial;
    }

    public int getQtdAsteroides() {
        return qtdAsteroides;
    }

    public int getQtdInimigos() {
        return qtdInimigos;
    }

    public static Dificuldade deString(String s) {
        if (s == null) {
            return MEDIO;
        }
        switch (s.trim().toLowerCase()) {
            case "facil":
            case "fácil":
            case "1":
                return FACIL;
            case "dificil":
            case "difícil":
            case "3":
                return DIFICIL;
            case "medio":
            case "médio":
            case "2":
            default:
                return MEDIO;
        }
    }

    public static Dificuldade fromString(String s) {
        return deString(s);
    }

    @Override
    public String toString() {
        switch (this) {
            case FACIL:
                return "Fácil";
            case DIFICIL:
                return "Difícil";
            default:
                return "Médio";
        }
    }
}
