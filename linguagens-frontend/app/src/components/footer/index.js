import React from "react";

import './footer.css';

export function Footer(){
    return(
        <>
            <div className="container-footer">
                <div className="elaboradoPor">
                <p >Elaborado por Fernando Lopes</p> 
                </div>
                
                
                <div className="redes-sociais">
                    <img className="logoRedesSociais" src="https://logosmarcas.net/wp-content/uploads/2020/12/GitHub-Logo.png"></img>            
                    <img className="logoRedesSociais" src="https://cdn-icons-png.flaticon.com/512/145/145807.png"></img>
                </div>                
            </div>

        </>
    )
}