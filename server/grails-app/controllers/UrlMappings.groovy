package buscaprof

//Classe responsável pelos métodos http
class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "/buscaProfundidade/buscando/**"(controller: 'buscaProfundidade', action:'index')
        "/buscaAmplitude/buscando/**"(controller: 'buscaAmplitude', action:'index') //Ao chegar uma requisição com a url informada é chamado o método do controller
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
