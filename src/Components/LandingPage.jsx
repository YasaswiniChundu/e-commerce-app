import { Link } from "react-router-dom"
import '../styles/LandingPage.css'


const LandingPage=()=>{
    return(
        <div className="landingpage">
            <Link to="/merchant">
                <img src="https://tse3.mm.bing.net/th?id=OIP.F_oo-HIe743EBbgzBYyJ7gHaGN&pid=Api&P=0&h=180"></img>
                Merchant</Link>
            <Link to="/user">
                <img src="https://tse4.mm.bing.net/th?id=OIP.WpnGIPj1DKAGo-CP64znTwHaHa&pid=Api&P=0&h=180"></img>
             User</Link>
        </div>
    )
}
export default LandingPage