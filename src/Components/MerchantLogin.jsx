import { useState } from 'react';
import Form from 'react-bootstrap/Form';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';


const MerchantLogin =()=>{
   let [email,setemail]=useState("")
   let [password,setpassword]=useState("")
   
   let navigate=useNavigate()

   function verifyMerchant (e){
    e.preventDefault();
    axios.post(`http://localhost:8080/merchants/verify-by-email?email=${email}&password=${password}`)
    .then((res)=>{
      console.log(res.data.data);
      localStorage.setItem("Merchant",JSON.stringify(res.data.data))
      navigate('/merchanthomepage')
      alert("Login Successfull")
    })
    .catch((err)=>{
      console.log(err);
      alert("Invalid Credentials")
    })
   }

    return (
        <div className="MerchantLogin">
            <h1>MerchantLogin</h1>

    <Form>

      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder="Enter email" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control value={password} onChange={(e)=>{setpassword(e.target.value)}} type="password" placeholder="Password" />
      </Form.Group>
      <Form.Group>
        <button onClick={verifyMerchant} className='btn btn-success mx-5'>Sign In</button>
        <button className='btn btn-danger mx-3'><Link to="/merchantsignup">Sign Up</Link></button>
      </Form.Group>
    </Form>
        </div>
        
    )
}
export default MerchantLogin