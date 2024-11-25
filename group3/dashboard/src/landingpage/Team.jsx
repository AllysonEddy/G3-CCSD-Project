// import React from "react";
import React , {useEffect , useState} from "react";
import Landing from "./landing.jsx";
import axios from 'axios';

axios.defaults.withCredentials = true;

const API_BASE_URL = 'http://localhost:8082';

export const Team = () => {

  const token = localStorage.getItem('jwtToken');
  const username = localStorage.getItem('userName');
  const [users, setUsers] = useState([]);

///////////////////////////////

useEffect(() => {
  // Fetch all products from the API
  fetch(`${API_BASE_URL}/api/users`,

    {
      // request headers
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      }
    }) // Your backend API URL
    .then(response => response.json())
    .then(data => {
      setUsers(data);
    })
    .catch(error => console.error('Error fetching Team:', error));
}, []);


////////////////////////////////

  if (!users) {
    return <div>Loading...</div>;  // Loading state
  }

  return (
    <div id="team" className="text-center">
      <div className="container">
        <div className="col-md-8 col-md-offset-2 section-title">
          <h2>Meet the Team</h2>
          <p>
            
          </p>
        </div>
        <div id="row">


           {/* //GET DATA FROM DB */}
          {/* //original: props.data */}
          {users.length > 0
              //original: props.data
            ? users.map((user, i) => (
                <div key={`${user.firstName}-${i}`} className="col-md-3 col-sm-6 team">
                  <div className="thumbnail">
                    {""}
                    {users.userImage && (
                       <img 
                       src={`data:image/jpeg;base64,${users.userImage}`} // Displaying image
                       alt={users.firstName}
                       className="img-fluid"
                       
                       />
                    )}
                   
                    <div className="caption">
                      <h4>{users.firstName}</h4>
                     
                    </div>
                  </div>
                </div>
              ))
            : "loading"}
        </div>
      </div>
    </div>
  );
};