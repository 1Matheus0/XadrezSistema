public class PartidaXadrez{
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
        inicarPartida();
    }
    public XadrezPeca[][] getPecas(){
        XadrezPeca[][] mat = new XadrezPeca[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for(int i=0; i<tabuleiro.getLinhas(); i++){
            for(int j=0; j<tabuleiro.getColunas(); j++){
            mat[i][j] = (XadrezPeca) tabuleiro.peca(i, j);
            }
        }  
        return mat;
    }

    public void novoLugarPeca(char coluna, int linha, XadrezPeca peca){
        tabuleiro.pecalugar(peca, new XadrezPosicao(coluna, linha).toPosicao());
    }

    private void inicarPartida(){
        novoLugarPeca('b',6, new Torre(tabuleiro, Color.BRANCO));
        novoLugarPeca('e', 8, new Rei(tabuleiro, Color.PRETO));
        novoLugarPeca('e', 1, new Rei(tabuleiro, Color.BRANCO));

    }

}