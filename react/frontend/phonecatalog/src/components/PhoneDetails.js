import React from 'react';
import PhoneImage from './PhoneImage'
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
      <div className="header">
        <div style={{"height":"fit-content", "width": "fit-content"}}>
          <Link to='/phones'>
            <h6 style={{"color": "black"}}>
              &#60;Back
            </h6>
          </Link>
        </div>
        <div className="media">
          <PhoneImage imageSrc={'http://localhost:8443/api/phones/' + this.state.phone.id + '/image'} imageSize={`186px`} />
          <div className="media-body">
            <h4>{this.state.phone.name}</h4>
            <p>
              {this.state.phone.price} € &nbsp;
            </p>
            <p>
              {this.state.phone.description}
            </p>
              <tbody>
                <tr>
                  <td className="bordered-right"><h4>Screen size</h4></td>
                  <td className="right-side">{this.state.phone.screen}</td>
                </tr>
                <tr>
                  <td className="bordered-right"><h4>Color</h4></td>
                  <td className="right-side">{this.state.phone.color}</td>
                </tr>
                <tr>
                  <td className="bordered-right"><h4>RAM</h4></td>
                  <td className="right-side">{this.state.phone.ram} GB</td>
                </tr>
                <tr>
                  <td className="bordered-right"><h4>Processor</h4></td>
                  <td className="right-side">{this.state.phone.processor}</td>
                </tr>
                <tr>
                  <td className="bordered-right"><h4>Manufacturer</h4></td>
                  <td className="right-side">{this.state.phone.manufacturer}</td>
                </tr>
              </tbody>
          </div>
        </div>
      </div>
    )
  }
}

export default PhoneDetails;