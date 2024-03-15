import { useState } from 'react'
import axios from 'axios'

function MerchantSignUp(){
    let[name,setname]=useState("")
    let[gst_num,setgst_num]=useState("")
    let[email,setemail]=useState("")
    let[phone,setphone]=useState(0)
    let[password,setpassword]=useState("")

    
    let addMerchant=(e)=>{
        e.preventDefault();
        let data={
            "name":name,
            "email":email,
            "gst_number":gst_num,
             "phone":phone,
            "password":password
        }
        console.log(data);
        axios.post('http://localhost:8080/merchants',data)
        .then((res)=>{
            console.log(res)
            alert("Login Successfull")
        })
        .catch((err)=>{
            console.log(err)
            alert("Data Not found")
        })
    }

    return(
        <div className="merchantsingup">
            <form  action="">
               <label htmlFor="">Name</label>
               <input required value={name} onChange={(e)=>{setname(e.target.value)}} type="text" placeholder="Enter the Name"/>
               <label htmlFor="">GST_number</label>
               <input required value={gst_num} onChange={(e)=>{setgst_num(e.target.value)}} type="text" placeholder="Enter the GST_number"/>
               <label htmlFor="">Email</label>
               <input required value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder="Enter the Email"/>
               <label htmlFor="">Phone no</label>
               <input required value={phone} onChange={(e)=>{setphone(e.target.value)}} type="tel" placeholder="Enter the Phone no"/>
               <label htmlFor="">Password</label>
               <input required value={password} onChange={(e)=>{setpassword(e.target.value)}} type="password" placeholder="Enter the Password"/>

               <button onClick={addMerchant} className="btn btn-outline-warning">Submit</button>
            </form>
        </div>
    )
}
export default MerchantSignUp
