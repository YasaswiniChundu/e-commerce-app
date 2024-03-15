import React from "react"
import { Link } from "react-router-dom"
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import Dropdown from 'react-bootstrap/Dropdown';

function MerchantNavBar(){
    return(
      <nav>
        <div className="logo"> 
           <h1>ShoppersCart</h1>
        </div>

        <div className="option">
            <Link to="/merchanthomepage/productview">View Product</Link>
        </div>

        <div className="account">
        <Dropdown>
      <Dropdown.Toggle variant="outline-dark" id="dropdown-basic">
       <AccountCircleIcon/>Account
      </Dropdown.Toggle>

      <Dropdown.Menu>
        <Dropdown.Item href="/merchanthomepage/updatemerchant">Edit Account</Dropdown.Item>
        <Dropdown.Item href="/">LogOut</Dropdown.Item>
        
      </Dropdown.Menu>
    </Dropdown>
        </div>
      </nav>
    )
}
export default MerchantNavBar