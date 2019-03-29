package buscaAmplitude

class LogicaBuscaAmplitude {
    No no
    String objetivo
    ArrayList<String> nosFinais = new ArrayList<>()

    LogicaBuscaAmplitude(No no, String objetivo) {
        this.no = no
        this.objetivo = objetivo
    }

    String busca() {
        //Cria instancia do controller, para acessar o gerarFilhos
        BuscaAmplitudeController buscaController = new BuscaAmplitudeController()
        No noRaiz = new No(no.estado)
        Queue<String> fechados = new LinkedList<>()
        Queue<No> abertos = new LinkedList<>()

        abertos.add(noRaiz)
        fechados.removeAll(fechados)
        nosFinais.add(noRaiz.estado)

        while (!abertos.isEmpty()) {
            //X é o item do aberto que está sendo verificado
            No x = abertos.remove()

            if (x.estado == objetivo) {
                nosFinais.add(x.estado)
                return "Sucesso"
            } else {
                //Cria uma lista de nós filhos
                List<String> nosFilhos = buscaController.gerarFilhos(x.estado)
                fechados.add(x.estado)

                for (String filho : nosFilhos) {
                    if (fechados.contains(filho) || abertos.contains(filho))
                        continue
                    //fechados.add(filho)
                    No noFilho = new No(filho)
                    x.addFilhos(noFilho)
                    noFilho.noPai = x
                    abertos.add(noFilho)
                    nosFinais.add(noFilho.estado)

                }
            }
        }

        return "Falha"
    }
}
