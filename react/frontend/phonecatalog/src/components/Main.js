import React, {Component} from 'react';
import {BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'

import PhoneList from './PhoneList'
import PhoneDetails from './PhoneDetails'
import Home from './Home'

const navStyle = {
  color: 'white'
}
class Main extends Component{
  
    constructor(props) {
        super(props)
    }

    render(){
      return (
        <Router>
          <div className="container-fluid">
          <nav>
              <h3>Phone catalog</h3>
              <ul className="nav-links">
                <Link to='/' style={navStyle}>
                  <li>Home</li>
                </Link>
                <Link to='/phones' style={navStyle}>
                  <li>Catalog</li>
                </Link>
              </ul>
          </nav>
            <Switch>
              <Route path="/" exact component={Home} />
              <Route path="/phones" exact component={PhoneList} />
              <Route path="/phones/:id" component={PhoneDetails} />
            </Switch>
          </div>
        </Router>
      )
          
    }
}
export default Main;