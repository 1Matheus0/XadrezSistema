public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;
    
    public Tabuleiro(int linhas, int colunas) {
        if( linhas <1 || colunas < 1){
            throw new TabuleiroExceção("Erro ao Criar o tabuleiro: é necessario que tenha pelo menos uma linha e uma coluna.");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }


    public int getColunas() {
        return colunas;
    }

    public Peca peca (int linha, int coluna){
        if(!posicaoExiste(linha, coluna)){
            throw new TabuleiroExceção("Posição não existe");
        }
        return pecas[linha][coluna];
    }
    public Peca peca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroExceção("Posição não existe");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void pecalugar(Peca peca, Posicao posicao){
        if(temUmaPeca(posicao)){
            throw new TabuleiroExceção("já existe uma peça em posição "+ posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removePeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroExceção("já existe uma peça em posição "+ posicao);
        }
        if (peca(posicao) == null) {
            return  null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }

    private boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas ; 
    }
    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(),posicao.getColuna());

    }
    public boolean temUmaPeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroExceção("Posição não existe");
        }
       return peca(posicao) != null;
    }
}
