package buscaprof

class No {
    ArrayList<No> nosFilhos
    No noPai
    String estado

    No(String estado) {
        this.estado = estado
        nosFilhos = new ArrayList<>()
    }

    void adicionaFilhos(No noFilho) {
        this.nosFilhos.add(noFilho)
    }

    @Override
    String toString() {
        return estado
    }
}
