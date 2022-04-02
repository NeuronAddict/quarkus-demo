import React from 'react';
import './App.css';
import Fruits from "./components/fruits";
import {Fruit} from "./components/fruit";


interface Props {}

class App extends React.Component<Props, { fruits: Fruit[]}> {

    constructor(props: Props) {
        super(props);
        this.state = { fruits: []};
    }


  componentDidMount() {
    fetch('/fruits')
        .then(res => res.json())
        .then((data) => {
          this.setState({ fruits: data })
        })
        .catch(console.log);
  }

  render () {
    return (
        <Fruits fruits={this.state.fruits} />
    );
  }
}

export default App;
