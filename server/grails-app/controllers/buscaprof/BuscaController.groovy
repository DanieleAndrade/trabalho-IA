package buscaprof

import grails.rest.RestfulController

class BuscaController {

    def index() {
        LogicaEntidade item = new LogicaEntidade(new No(params.estado.toLowerCase()), params.objetivo.toLowerCase())
        item.busca()

        respond(model: item)
    }


    List<String> gerarFilhos(String estadoAtual) {
        List<String> filhos = new ArrayList<>()

        switch (estadoAtual.indexOf("x")) {
            case 0:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(0), '*' as char).replace(estadoAtual.charAt(1), estadoAtual.charAt(0)).replace('*' as char, estadoAtual.charAt(1)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(0), '*' as char).replace(estadoAtual.charAt(3), estadoAtual.charAt(0)).replace('*' as char, estadoAtual.charAt(3)))
                break

            case 1:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(1), '*' as char).replace(estadoAtual.charAt(0), estadoAtual.charAt(1)).replace('*' as char, estadoAtual.charAt(0)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(1), '*' as char).replace(estadoAtual.charAt(2), estadoAtual.charAt(1)).replace('*' as char, estadoAtual.charAt(2)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(1), '*' as char).replace(estadoAtual.charAt(4), estadoAtual.charAt(1)).replace('*' as char, estadoAtual.charAt(4)))
                break

            case 2:

                filhos.add(estadoAtual.replace(estadoAtual.charAt(2), '*' as char).replace(estadoAtual.charAt(1), estadoAtual.charAt(2)).replace('*' as char, estadoAtual.charAt(1)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(2), '*' as char).replace(estadoAtual.charAt(5), estadoAtual.charAt(2)).replace('*' as char, estadoAtual.charAt(5)))
                break

            case 3:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(3), '*' as char).replace(estadoAtual.charAt(0), estadoAtual.charAt(3)).replace('*' as char, estadoAtual.charAt(0)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(3), '*' as char).replace(estadoAtual.charAt(4), estadoAtual.charAt(3)).replace('*' as char, estadoAtual.charAt(4)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(3), '*' as char).replace(estadoAtual.charAt(6), estadoAtual.charAt(3)).replace('*' as char, estadoAtual.charAt(6)))
                break

            case 4:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(4), '*' as char).replace(estadoAtual.charAt(1), estadoAtual.charAt(4)).replace('*' as char, estadoAtual.charAt(1)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(4), '*' as char).replace(estadoAtual.charAt(3), estadoAtual.charAt(4)).replace('*' as char, estadoAtual.charAt(3)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(4), '*' as char).replace(estadoAtual.charAt(5), estadoAtual.charAt(4)).replace('*' as char, estadoAtual.charAt(5)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(4), '*' as char).replace(estadoAtual.charAt(7), estadoAtual.charAt(4)).replace('*' as char, estadoAtual.charAt(7)))
                break

            case 5:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(5), '*' as char).replace(estadoAtual.charAt(2), estadoAtual.charAt(5)).replace('*' as char, estadoAtual.charAt(2)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(5), '*' as char).replace(estadoAtual.charAt(4), estadoAtual.charAt(5)).replace('*' as char, estadoAtual.charAt(4)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(5), '*' as char).replace(estadoAtual.charAt(8), estadoAtual.charAt(5)).replace('*' as char, estadoAtual.charAt(8)))
                break

            case 6:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(6), '*' as char).replace(estadoAtual.charAt(3), estadoAtual.charAt(6)).replace('*' as char, estadoAtual.charAt(3)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(6), '*' as char).replace(estadoAtual.charAt(7), estadoAtual.charAt(6)).replace('*' as char, estadoAtual.charAt(7)))
                break


            case 7:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(7), '*' as char).replace(estadoAtual.charAt(4), estadoAtual.charAt(7)).replace('*' as char, estadoAtual.charAt(4)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(7), '*' as char).replace(estadoAtual.charAt(6), estadoAtual.charAt(7)).replace('*' as char, estadoAtual.charAt(6)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(7), '*' as char).replace(estadoAtual.charAt(8), estadoAtual.charAt(7)).replace('*' as char, estadoAtual.charAt(8)))
                break

            case 8:
                filhos.add(estadoAtual.replace(estadoAtual.charAt(8), '*' as char).replace(estadoAtual.charAt(5), estadoAtual.charAt(8)).replace('*' as char, estadoAtual.charAt(5)))
                filhos.add(estadoAtual.replace(estadoAtual.charAt(8), '*' as char).replace(estadoAtual.charAt(7), estadoAtual.charAt(8)).replace('*' as char, estadoAtual.charAt(7)))
                break

        }
        return filhos
    }
}
