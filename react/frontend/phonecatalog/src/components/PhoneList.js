import React from 'react'

import PhoneRow from './PhoneRow'

class PhoneList extends React.Component {

  render() {
    return (
      <div className="container-fluid">
        <div className="media-list">
          {
            this.props.catalog.map((phone) => {
              return <PhoneRow key={ phone.id }
                                  id={ phone.id }
                                  name={ phone.name }
                                  price={ phone.price }
                                  image={ phone.imageFileName } />
            })
          }
        </div>
      </div>
    )
  }
}

export default PhoneList;
