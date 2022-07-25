import React from "react";
import './navbar.css';

export function Navbar() {
    return (
        <>      
            <nav className="navbar navbar-dark">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/">Linguagens</a>                    
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav md-auto mb-2 mb-lg-0">
                          {/*   <li className="nav-item">
                                <a className="nav-link" href="adicionar-linguagem">Cadastrar Linguagem</a>
                            </li> 
                            <li className="nav-item">
                                <a className="nav-link" href="">Atualizar Linguagem</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="">Excluir Linguagem</a>
                            </li>                             */}
                        </ul>                      
                    </div>
                </div>
            </nav>
        </>
    )
}