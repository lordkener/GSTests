import React from 'react';

class Home extends React.Component {

  render() {   
    return (
      <div className="media">
        <div className="media-body">
            <h1>
                Welcome to Phone Catalog
            </h1>
            <div className="header">
              <p className="right-side" style={{"width":"100%"}}>This is one of the tests that you sent it to me. <br/>
                To get started for recieve the phone catalog, press <strong>Catalog</strong> in the menu. 
                This will make an api rest request to the backend server and will show you the first information of some phones.<br/><br/>
                - Load more phones pressing the arrow icon at the bottom<br/><br/>
                - Press <strong>+ More info.</strong> to make another request to the server for recieve more information about the phone.<br/><br/>
                - Once you're in phone details, you could go back to the catalog.
              </p>
              <br/>
            </div>
            <h3>And that's all !</h3>
        </div>
      </div>
    )
  }
}

export default Home;