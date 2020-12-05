import React from 'react'

import PhoneRow from './PhoneRow'

class PhoneList extends React.Component {

  constructor(props) {
    super(props)
    this.state = { phonesList: [] }
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
        this.setState({ phonesList: phones })
        console.log(phones);
      })
  }

  render() {
    if (this.state.phonesList.length > 0) {
      return (
        <div className="container-fluid">
          <div>
            {
              this.state.phonesList.map((phone) => {
                return <PhoneRow key={ phone.id }
                id={ phone.id }
                name={ phone.name }
                price={ phone.price }
                image={ phone.imageFileName } />
              })
            }
          </div>
        </div>)
      } else {
        return <p className="text-center">Loading catalog...</p>
      }
  }
}

export default PhoneList;
