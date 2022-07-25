import axios from "axios";
import { useEffect, useState } from "react";
import { Navbar } from "../../components/navbar";
import { Link } from 'react-router-dom';

import "./adicionar-linguagem.css"

export default function AdicionarLinguagem(){

    const[nomeLinguagem, setNome] = useState('')
    const[logoLinguagem,setImagem] = useState('')
    const[rankingLinguagem,setRanking] = useState ('')

let linguagem = {
    title: nomeLinguagem,
    image: logoLinguagem,
    ranking: rankingLinguagem
}

function validation() {
    'use strict'
  
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')
  
    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
      .forEach(function (form) {
        form.addEventListener('click', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
          }
  
          form.classList.add('was-validated')
        }, false)
      })
  }

    function PostLinguagens(){
        validation();

        axios.post("http://localhost:8080/adicionar-linguagens")
        .then((response) => {
            console.log(response.data)
        }).catch((error) =>{
            console.log(error)
        })
    }

    useEffect(() =>{
        PostLinguagens()
    },[])

    return(
        <>
        <Navbar />
       
            <form className="container needs-validation" >
                <p className="txtAdicionarLinguagem">Adicionar Linguagem</p>
                
                <input className="form-control" placeholder = "Nome da Linguagem" type="text" /*onChange={((e) => setNome(e.target.value))}*/  required/>
                <div className="invalid-feedback">
                    Por favor inserir o nome da linguagem.
                </div>

                <input className="form-control" placeholder = "Logo Linguagem - url- imagem 32 x 32" type="text" /*onChange={((e) => setImagem(e.target.value))}*/ required/>
                <div className="invalid-feedback">
                    Por favor inserir a url da imagem.
                </div>
                
                <input className="form-control" placeholder = "Ranking" type= "number" /*onChange={((e) => setRanking(e.target.value))}*/ required/>
                <div className="invalid-feedback">
                    Por favor inserir o valor do ranking
                </div>
                
                <Link className="buttonLink" to="/" onClick={() => PostLinguagens()}> Adicionar Linguagem</Link>
            </form>
        </>

    )
}

