import React from 'react';
import logo from '../logo.svg';

class PhoneImage extends React.Component {
  render() {   
    return (
      <figure className="media-left">
        <img className="media-object" width={this.props.imageSize} src={this.props.imageSrc} alt={logo}/>
      </figure>
    )
  }
}

export default PhoneImage;