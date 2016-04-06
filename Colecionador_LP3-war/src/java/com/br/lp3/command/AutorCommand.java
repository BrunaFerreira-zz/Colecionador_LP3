/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import com.br.lp3.dao.GenericDAO;
import com.br.lp3.entities.Autor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class AutorCommand implements Command{
    
    private String returnPage = "index.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        switch(action){
            case "register":
               String nomeAutor = request.getParameter("nome_Autor");
                
                Autor autor = new Autor();
                autor.setNomeAutor(nomeAutor);
                
             break;   
        } 
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }
}
    
    