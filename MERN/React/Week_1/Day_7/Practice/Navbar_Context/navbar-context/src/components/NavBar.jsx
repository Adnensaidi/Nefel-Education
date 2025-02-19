import { useContext } from "react";
import { UserContext } from "../App";


const NavBar = ()=>{
    
    const { name } = useContext(UserContext);
    
    const style = {
        background: "purple",
        display: "flex",
        padding: "18px",
        alignItems: "center",
        justifyContent: "flex-end",
        color: "white",
        fontWeight: "bold"
    };


    return (
        <div style={style}>
            Hi {name}!
        </div>
    )
}

export default NavBar;
