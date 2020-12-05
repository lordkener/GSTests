import React from 'react'
import PhoneImage from './PhoneImage'
import {Link} from 'react-router-dom'

class PhoneRow extends React.Component {

  constructor(props) {
    super(props)
  }

  render() {
    return(
      <div className="media">
        <PhoneImage imageSrc={'http://localhost:8443/api/phones/' + this.props.id + '/image'} />
        <div className="media-body">
          <h4>{this.props.name}</h4>
          <p>
            {this.props.price} € &nbsp;
          </p>
          <Link to={`/phones/${this.props.id}`}>+ More info.</Link>
        </div>
        <hr width='50%'/>
      </div>
    )
  }
}

export default PhoneRow;