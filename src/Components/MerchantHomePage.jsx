import React from "react"
import MerchantNavBar from "./MerchantNavBar"
import productView from "./ProductView"
import { Route, Routes } from "react-router-dom"
import UpdateMerchant from "./UpdateMerchant"

function MerchantHomePage(){
    return(
        <div className="mhp">
         <MerchantNavBar/>
         <Routes>
            <Route path="/productview" element={<productView/>}/>
            <Route path="/updatemerchant" element={<UpdateMerchant/>}/>
         </Routes>
        </div>
    )
}
export default MerchantHomePage