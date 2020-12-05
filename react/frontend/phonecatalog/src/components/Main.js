import React, {Component} from 'react';

import PhoneList from './PhoneList'

class Main extends Component{
    
    constructor(props) {
        super(props)
        this.state = { phones: [] }
      }

    componentDidMount() {
        fetch('http://localhost:8443/api/', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        })
          .then((response) => {
            return response.json()
          })
          .then((phones) => {
            this.setState({ phones: phones })
            console.log(phones);
          })
      }

    render(){
        if (this.state.phones.length > 0) {
            return (
              <div className="container-fluid">
                <PhoneList catalog={this.state.phones} />
              </div>
            )
          } else {
            return <p className="text-center">Loading catalog...</p>
          }
    }
}
export default Main;