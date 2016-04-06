package com.br.lp3.command;

import com.br.lp3.entities.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class UsuarioCommand implements Command{
    
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
               String nome_usuario = request.getParameter("nome_usuario");
               long id_autor = 0 ;
               //Criar Usuário 
               Usuario usuario = new Usuario();
               usuario.setNomeUsuario(nome_usuario);

                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
    
}
