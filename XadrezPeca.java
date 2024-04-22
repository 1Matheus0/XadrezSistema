public class XadrezPeca extends Peca {
    private Color color;

    public XadrezPeca(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
