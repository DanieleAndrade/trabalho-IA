import React, { Component } from 'react';
import { Grid } from 'react-bootstrap';
import AppNav from './AppNav';

import grailsLogo from './images/grails-cupsonly-logo-white.svg';
import reactLogo from './images/logo.svg';
import { SERVER_URL, CLIENT_VERSION, REACT_VERSION } from './config';
import 'whatwg-fetch';

class App extends Component {

//Objetos e variáveis utilizada no projeto
    constructor(props) {
        super(props);
        this.state = {
            nos: [],
            estado: "",
            objetivo: "",
            resultado: ""
        }
        
        //Permitindo acesso ao this ao chamar o método
        this.buscaAmplitude=this.buscaAmplitude.bind(this);
        this.buscaProfundidade=this.buscaProfundidade.bind(this);
    }

    //Pegar valor de inputs a cada digito
    handleChangeEstado = (event) => {
        this.setState({estado: event.target.value});
    }

    handleChangeObjetivo = (event) => {
        this.setState({objetivo: event.target.value});
    }


    buscaProfundidade() {
        fetch(SERVER_URL + '/chamaBusca/buscando/item?objetivo='  +this.state.objetivo+ '&estado=' +this.state.estado)
            .then(r => r.json())
            .then(json => {this.setState({nos: json.model.nosFinais});
            })
            .catch(error => console.error('Error connecting to server: ' + error));

    }
    //Chamada para o servidor, passando os parametros objetivo e estado atual
    buscaAmplitude() {
        fetch(SERVER_URL + '/chamaBuscaAmplitude/buscando/item?objetivo=' +this.state.objetivo+ '&estado=' +this.state.estado)
            .then(r => r.json())
            .then(json => {this.setState({nos: json.model.nosFinais, resultado: json.retorno}); //Seta o retorno nas variaveis
            })
            .catch(error => console.error('Error connecting to server: ' + error));
    }

    render() {
        return (
            <div>
                <label>Informe o estado atual:
                    <input type="text" name="estado" id="estado" maxlength="9" value={this.state.value} onChange={this.handleChangeEstado} /><br/>
                </label>
                <br/>
                <label>Informe o objetivo:
                    <input type="text" name="objetivo" id="objetivo" maxlength="9" value={this.state.value} onChange={this.handleChangeObjetivo} /><br/>
                </label>
                <br/><br/>
                {/* Chama o método*/}
                <button className="button" onClick={this.buscaProfundidade}>Busca Profundidade</button>
                <button className="button" onClick={this.buscaAmplitude}>Busca Amplitude</button>

                {/* Percorre a lista de nós retornados e cria divs para cada nó separados em quadrados */}
                {this.state.nos.map((no) => {
                    return (
                        <div className="tabuleiro" key={no}>
                            <div className="board-row">
                                <p className="square">{no.substring(0,1)}</p>
                                <p className="square">{no.substring(1,2)}</p>
                                <p className="square">{no.substring(2,3)}</p>
                            </div>

                            <div className="board-row">
                                <p className="square">{no.substring(3,4)}</p>
                                <p className="square">{no.substring(4,5)}</p>
                                <p className="square">{no.substring(5,6)}</p>
                            </div>

                            <div className="board-row">
                                <p className="square">{no.substring(6,7)}</p>
                                <p className="square">{no.substring(7,8)}</p>
                                <p className="square">{no.substring(8,9)}</p>
                            </div>
                            <br/>
                        </div>
                    )
                })}

               {this.state.resultado}

            </div>

    );
    }
}

export default App;
