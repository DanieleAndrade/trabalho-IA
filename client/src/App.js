import React, { Component } from 'react';
import { Grid } from 'react-bootstrap';
import AppNav from './AppNav';

import grailsLogo from './images/grails-cupsonly-logo-white.svg';
import reactLogo from './images/logo.svg';
import { SERVER_URL, CLIENT_VERSION, REACT_VERSION } from './config';
import 'whatwg-fetch';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            nos: [],
            ddf: "fgf",
            estado: "",
            objetivo: ""
        }
        this.buscaAmplitude=this.buscaAmplitude.bind(this);
        this.buscaProfundidade=this.buscaProfundidade.bind(this);
    }

    handleChangeEstado = (event) => {
        console.log(this.state);
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

    buscaAmplitude() {
        fetch(SERVER_URL + '/chamaBuscaAmplitude/buscando/item?objetivo=' +this.state.objetivo+ '&estado=' +this.state.estado)
            .then(r => r.json())
            .then(json => {this.setState({nos: json.model.nosFinais});
            })
            .catch(error => console.error('Error connecting to server: ' + error));
    }

    render() {
        console.log(this.state);
        return (
            <div>
                <label>Informe o estado atual:
                    <input type="text" name="estado" id="estado" maxlength="9" value={this.state.value} onChange={this.handleChangeEstado} /><br/>
                </label>
                <br/>
                <label>Informe o objetivo:
                    <input type="text" name="objetivo" id="objetivo" maxlength="9" value={this.state.value} onChange={this.handleChangeObjetivo} /><br/>
                </label>

                <button onClick={this.buscaProfundidade}>DSF</button>
                <button onClick={this.buscaAmplitude}>BFS</button>

                {this.state.nos.map((no) => {
                    return (
                        <div key={no}>
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

                <p>Sucesso</p>

            </div>

    );
    }
}

export default App;
