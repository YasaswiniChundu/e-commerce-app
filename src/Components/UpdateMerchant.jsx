import axios from "axios";
import { useEffect, useState } from "react";


function UpdateMerchant(){
    let [name,setname]=useState("")
    let [email,setemail]=useState("")
    let [gst_num,setgst_num]=useState("")
    let [phone,setphone]=useState("")
    let [password,setpassword]=useState("")
    let [id,setid]=useState("")

     let data={"name":name,
     "email":email,
     "gst_number":gst_num,
     "phone":phone,
     "password":password,
     "id":id}
     let merchant=JSON.parse(localStorage.getItem("Merchant"))

     useEffect(()=>{
        setname(merchant.name)
        setemail(merchant.email)
        setgst_num(merchant.gst_num)
        setphone(merchant.phone)
        setpassword(merchant.password)
        setid(merchant.id)
     },{})

     let Update=(e)=>{
        e.preventDefault();
        console.log(data);
        axios.put(`http://localhost:8080/merchants`,data)
        .then((res)=>{
            console.log(res);
            alert("Data Edited Successfull")
          })
          .catch((err)=>{
            console.log(err);
            alert("Data Not Found")
          })
         }
      
       return (
        <div className="updatemerchant">
            {/* <h1>UpdateMerchant</h1> */}
            <form action="">
            <label htmlFor="">Id</label>
               <input required value={id} onChange={(e)=>{setid(e.target.value)}} type="text" placeholder="Enter the Id"/>
               <label htmlFor="">Name</label>
               <input required value={name} onChange={(e)=>{setname(e.target.value)}} type="text" placeholder="Enter the Name"/>
               <label htmlFor="">GST_number</label>
               <input required value={gst_num} onChange={(e)=>{setgst_num(e.target.value)}} type="text" placeholder="Enter the GST_number"/>
               <label htmlFor="">Email</label>
               <input required value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder="Enter the Email"/>
               <label htmlFor="">Phone no</label>
               <input required value={phone} onChange={(e)=>{setphone(e.target.value)}} type="tel" placeholder="Enter the Phone no"/>
               <label htmlFor="">Password</label>
               <input required value={password} onChange={(e)=>{setpassword(e.target.value)}} type="text" placeholder="Enter the Password"/>

               <button onClick={Update} className="btn btn-outline-warning">Submit</button>
            </form>
        </div>
        
    )
    }
export default UpdateMerchant
