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
    
    public XadrezPeca ExecutaMovimentoXadrez(XadrezPosicao sourcePosicao, XadrezPosicao targetPosicao){
        Posicao source = sourcePosicao.toPosicao();
        Posicao target = targetPosicao.toPosicao();
        validaPosicaoOrigem(source);
        Peca capturaPeca = makeMove(source, target);
        return (XadrezPeca)capturaPeca;
    }

    private Peca makeMove(Posicao source, Posicao target){
        Peca p  = tabuleiro.removePeca(source);
        Peca capturaPeca = tabuleiro.removePeca(target);
        tabuleiro.pecalugar(p, target);
        return capturaPeca;
    }

    public void validaPosicaoOrigem(Posicao posicao){
        if (!tabuleiro.temUmaPeca(posicao)){
            throw new XadrezExeceção("Nao exixte peca na posicao de origem");
        }
    }

    public void novoLugarPeca(char coluna, int linha, XadrezPeca peca){
        tabuleiro.pecalugar(peca, new XadrezPosicao(coluna, linha).toPosicao());
    }

    private void inicarPartida(){
       
		novoLugarPeca('d', 8, new Rei(tabuleiro, Color.PRETO));
		novoLugarPeca('d', 1, new Rei(tabuleiro, Color.BRANCO));
		novoLugarPeca('c', 1, new Torre(tabuleiro, Color.BRANCO));
        novoLugarPeca('c', 2, new Torre(tabuleiro, Color.BRANCO));
        novoLugarPeca('d', 2, new Torre(tabuleiro, Color.BRANCO));
        novoLugarPeca('e', 2, new Torre(tabuleiro, Color.BRANCO));
        novoLugarPeca('e', 1, new Torre(tabuleiro, Color.BRANCO));
    

       novoLugarPeca('c', 7, new Torre(tabuleiro, Color.PRETO));
       novoLugarPeca('c', 8, new Torre(tabuleiro, Color.PRETO));
       novoLugarPeca('d', 7, new Torre(tabuleiro, Color.PRETO));
       novoLugarPeca('e', 7, new Torre(tabuleiro, Color.PRETO));
       novoLugarPeca('e', 8, new Torre(tabuleiro, Color.PRETO));
       
    }

}