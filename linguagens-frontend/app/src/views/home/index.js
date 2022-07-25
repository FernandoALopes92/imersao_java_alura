import axios from "axios";
import React, { useEffect, useState } from "react";
import { Navbar } from "../../components/navbar";
import { Footer } from "../../components/footer";


import './home.css'


export default function Home() {

    const [linguagens, setLinguagens] = useState([])

    function GetLinguagens() {
        axios.get('http://localhost:8080/linguagens')
            .then((response) => {
                setLinguagens(response.data)
            }).catch((error) => {
                console.log(error)
            })
    }

    useEffect(() => {
        GetLinguagens()
    }, [])


    return (
        <>
            <Navbar />
            
            <table className="table table-striped">
                <thead>
                    <tr>          
                        <th scope="col">Linguagem</th>
                        <th scope="col">Imagem</th>
                        <th scope="col">Ranking</th>                    
                    </tr>
                </thead>
                <tbody>
                     

                {                        
                    linguagens.map(linguagem => (
                    <tr key={linguagem.id}>  
                        <td>{linguagem.title}</td>
                        <td><img src={linguagem.image}></img></td>
                        <td>{linguagem.ranking}</td>                  
                    </tr>
                    ))                    
                }      
           
           
                
                </tbody>
             </table>

             <Footer/>
        </>
    )
}

