package buscaprof

class LogicaBuscaProfundidade {
    No no
    String objetivo
    ArrayList<String> nosFinais = new ArrayList<>() //nós que serão enviados para a view

    LogicaEntidade(No no, String objetivo) {
        this.no = no
        this.objetivo = objetivo
    }

    String busca() {
        BuscaProfundidadeController buscaController = new BuscaProfundidadeController()
        No noRaiz = new No(no.estado)
        Stack<String> fechados = new Stack<>()
        Stack<No> abertos = new Stack<>()

        abertos.add(noRaiz)
        nosFinais.add(noRaiz.estado) // mostra o nó com estado inicial

        while (!abertos.isEmpty()) {
            No x = abertos.pop()

            if (x.estado == objetivo) {
                nosFinais.add(x.estado) // mostra o nó com o estado objetivo
                return "Sucesso"
            } else {
                List<String> nosFilhos = buscaController.gerarFilhos(x.estado)
                fechados.add(x.estado)

                for (String filho : nosFilhos) {
                    if (fechados.contains(filho) || abertos.contains(filho))
                        continue
                    No noFilho = new No(filho)
                    x.adicionaFilhos(noFilho)
                    noFilho.noPai = x
                    abertos.add(noFilho)
                    nosFinais.add(noFilho.estado) // mostra o nó filho com estado atual
                }
            }
        }

        return "Falha"
    }
}
