package com.br.lp3.command;

import com.br.lp3.entities.InfoUsuario;
import com.br.lp3.entities.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class InfoUsuarioCommand implements Command{

    private String returnPage = "login.jsp";
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
               String nome_completo = request.getParameter("nome_completo");
               String acesso_Usuario = request.getParameter("acesso_Usuario");
               String senha = request.getParameter("senha");
            
               long id_usuario = 0 ;
               Usuario usuario = new Usuario();
               usuario.setIdUsuario(id_usuario);
               //Criar Usuário 
               InfoUsuario infoU = new InfoUsuario();
               infoU.setNomeCompleto(nome_completo);
               infoU.setAcessoUsuario(acesso_Usuario);
               infoU.setSenha(senha);
               infoU.setIdUsuario(usuario);
                break;
        }
    }
    

    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
}  

