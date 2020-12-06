import React from 'react'

import PhoneRow from './PhoneRow'
import loadMore from '../icons/loadmore_unpressed.png'
import spinner from '../icons/spinner.gif'

class PhoneList extends React.Component {

  constructor(props) {
    super(props)
    this.state = { phonesList: [], page_size: 3, isLoaded: true }
  }

  componentDidMount() {
    this.loadMorePhones();
  }

  loadMorePhones() {
    this.setState({ isLoaded: false })
    fetch('http://localhost:8443/api/?page=0&size=' + this.state.page_size, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => response.json())
    .then((phones) => {
        this.setState({
          isLoaded: true,
          phonesList: phones
        });
      },
      (error) => {
        this.setState({
          isLoaded: true,
          error
        });
      }
    )
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
          <div className="loadmore-container">
            <div>
                <img className="loadmore-button" 
                  style={{ display: this.state.isLoaded ? "block" : "none" }} 
                  onClick={() => {this.state.page_size++; this.loadMorePhones()}} 
                  src={loadMore} alt="loadMore" />
                
                <img className="loadmore-button" 
                  style={{ display: !this.state.isLoaded ? "block" : "none" }} 
                  src={spinner} 
                  alt="spinner" />
            </div>
          </div>
        </div>)
      } else {
        return <p className="text-center">Loading catalog...</p>
      }
  }
}

export default PhoneList;
