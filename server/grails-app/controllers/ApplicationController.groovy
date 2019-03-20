package buscaprof

import grails.core.GrailsApplication
import grails.util.Environment
import grails.plugins.*

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager
    BuscaController buscaController

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    def buscarItem() {
        buscaController = new BuscaController()
        params
        buscaController.index()
    }
}


