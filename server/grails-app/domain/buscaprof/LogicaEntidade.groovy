package buscaprof

class LogicaEntidade {
    No no
    String objetivo
    ArrayList<String> nosFinais = new ArrayList<>()

    LogicaEntidade(No no, String objetivo) {
        this.no = no
        this.objetivo = objetivo
    }

    String busca() {
        BuscaController buscaController = new BuscaController()
        No noRaiz = new No(no.estado)
        int totalDeNosVisitados = 0
        Stack<String> fechados = new Stack<>()
        Stack<No> abertos = new Stack<>()

        abertos.add(noRaiz)
        nosFinais.add(noRaiz.estado)

        while (!abertos.isEmpty()) {
            totalDeNosVisitados++
            No x = abertos.pop()

            if (x.estado == objetivo) {
                System.out.println("Sucesso")
                System.out.println(totalDeNosVisitados)
                nosFinais.add(x.estado)
                break
            } else {
                List<String> nosFilhos = buscaController.gerarFilhos(x.estado)
                fechados.add(x.estado)

                for (String filho : nosFilhos) {
                    if (fechados.contains(filho) || abertos.contains(filho))
                        continue
                    fechados.add(filho)
                    No noFilho = new No(filho)
                    x.addFilhos(noFilho)
                    noFilho.noPai = x
                    abertos.add(noFilho)
                    nosFinais.add(noFilho.estado)
                }
            }
        }

        return "0"
    }
}
