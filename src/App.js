import LandingPage  from "./Components/LandingPage"
import { BrowserRouter,Routes,Route } from "react-router-dom";
import MerchantLogin from "./Components/MerchantLogin"
import UserLogin from "./Components/UserLogin"
import 'bootstrap/dist/css/bootstrap.min.css';
import MerchantSignUp from "./Components/MerchantSignUp";
import MerchantHomePage from "./Components/MerchantHomePage"
import UserSignUp from "./Components/UserSignUp";
import Error from "./Components/Error"
import Protect from "./Components/Protect";

function App() {
  return (
    <div className="App">
     
            <BrowserRouter>
            <Routes>
                <Route path="/" element={<LandingPage/>}/>
                <Route path="/*" element={<Error/>}/>
                <Route path="/merchant" element={<MerchantLogin/>}/>
                <Route path="/user" element={<UserLogin/>}/>
                <Route path="/merchantsignup" element={<MerchantSignUp/>}/>
                <Route path="/merchanthomepage/*" element={<MerchantHomePage/>}/>
                <Route path="/usersignup" element={<UserSignUp/>}/>
                <Route path="/merchanthomepage" element={<Protect Child={MerchantHomePage}/>}/>
            </Routes>
            </BrowserRouter>

        </div>
    )
}
export default App
   