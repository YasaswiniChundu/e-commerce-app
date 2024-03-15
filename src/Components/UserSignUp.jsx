import { useState } from 'react'
import axios from 'axios'

function UserSignUp(){
    let[name,setname]=useState("")
    let[age,setage]=useState("")
    let[gender,setgender]=useState("")
    let[email,setemail]=useState("")
    let[phone,setphone]=useState(0)
    let[password,setpassword]=useState("")

    
    let addUser=(e)=>{
        e.preventDefault();
        let data={
            "name":name,
            "email":email,
            "age":age,
            "gender":gender,
            "phone":phone,
            "password":password
        }
        console.log(data);
        axios.post('http://localhost:8080/users',data)
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
        <div className="usersingup">
            <form  action="">
               <label htmlFor="">Name</label>
               <input required value={name} onChange={(e)=>{setname(e.target.value)}} type="text" placeholder="Enter the Name"/>
               <label htmlFor="">Age</label>
               <input required value={age} onChange={(e)=>{setage(e.target.value)}} type="text" placeholder="Enter the Age"/>
               <label htmlFor="">Gender</label>
               <input required value={gender} onChange={(e)=>{setgender(e.target.value)}} type="text" placeholder="Enter the Gender"/>
               <label htmlFor="">Email</label>
               <input required value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder="Enter the Email"/>
               <label htmlFor="">Phone no</label>
               <input required value={phone} onChange={(e)=>{setphone(e.target.value)}} type="tel" placeholder="Enter the Phone no"/>
               <label htmlFor="">Password</label>
               <input required value={password} onChange={(e)=>{setpassword(e.target.value)}} type="password" placeholder="Enter the Password"/>

               <button onClick={addUser} className="btn btn-outline-warning">Submit</button>
            </form>
        </div>
    )
}
export default UserSignUp
