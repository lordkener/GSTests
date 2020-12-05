import React from 'react';
import PhoneImage from './PhoneImage'
import Table from 'react-bootstrap/Table'
import {Link} from 'react-router-dom'

class PhoneDetails extends React.Component {

  constructor(props) {
    super(props)
    this.state = { phone: {} }
  }

  componentDidMount() {
    fetch(`http://localhost:8443/api/phones/${this.props.match.params.id}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then((response) => {
        return response.json()
      })
      .then((data) => {
        this.setState({ phone: data })
        console.log(data);
      })
  }

  render() {   
    return (
      <div className="media">
        <Link to='/phones'>
                  <h6>
                    Back
                  </h6>
        </Link>
        <PhoneImage imageSrc={'http://localhost:8443/api/phones/' + this.state.phone.id + '/image'} />
        <div className="media-body">
          <h4>{this.state.phone.name}</h4>
          <p>
            {this.state.phone.price} € &nbsp;
          </p>
          <p>
            {this.state.phone.description}
          </p>
          <Table striped bordered hover>
            <tbody>
              <tr>
                <td>Screen size</td>
                <td>{this.state.phone.screen}</td>
              </tr>
              <tr>
                <td>Color</td>
                <td colSpan="2">{this.state.phone.color}</td>
              </tr>
              <tr>
                <td>RAM</td>
                <td>{this.state.phone.ram}</td>
              </tr>
              <tr>
                <td>Processor</td>
                <td>{this.state.phone.processor}</td>
              </tr>
              <tr>
                <td>Manufacturer</td>
                <td colSpan="2">{this.state.phone.manufacturer}</td>
              </tr>
            </tbody>
          </Table>
        </div>
      </div>
    )
  }
}

export default PhoneDetails;