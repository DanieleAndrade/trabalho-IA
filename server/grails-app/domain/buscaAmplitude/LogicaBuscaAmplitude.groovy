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
        BuscaAmplitudeController buscaController = new BuscaAmplitudeController()
        No noRaiz = new No(no.estado)
        int totalDeNosVisitados = 0
        Queue<String> fechados = new LinkedList<>()
        Queue<No> abertos = new LinkedList<>()

        abertos.add(noRaiz)

        buscaController.printNo(noRaiz.estado)
        nosFinais.add(noRaiz.estado)

        while (!abertos.isEmpty()) {
            totalDeNosVisitados++
            No x = abertos.remove()

            if (x.estado == objetivo) {
                System.out.println("Sucesso")
                System.out.println(totalDeNosVisitados)
                nosFinais.add(x.estado)
                break
            } else {
                List<String> nosFilhos = buscaController.gerarFilhos(x.estado)
                fechados.add(x.estado)

                try {
                    for (String filho : nosFilhos) {
                        if (fechados.contains(filho) || abertos.contains(filho))
                            continue
                        fechados.add(filho)
                        No noFilho = new No(filho)
                        x.addFilhos(noFilho)
                        noFilho.noPai = x
                        abertos.add(noFilho)
                        nosFinais.add(noFilho.estado)
                        buscaController.printNo(noFilho.estado)
                        String teste = "ads"
                    }
                    String helo = "avcd"
                }catch (Exception e) {
                    print(e)
                }

            }
        }

        return "0"
    }
}
