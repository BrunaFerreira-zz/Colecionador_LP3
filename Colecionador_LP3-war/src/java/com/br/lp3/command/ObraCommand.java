package com.br.lp3.command;

import com.br.lp3.entities.Autor;
import com.br.lp3.entities.Obra;
import static com.sun.faces.config.WebConfiguration.DisableUnicodeEscaping.Auto;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class ObraCommand implements Command{
    
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
               String nome_obra = request.getParameter("nome_obra");
               long id_autor = 0 ;
               //Criar autor 
               Autor autor = new Autor();
               autor.setIdAutor(id_autor);
               //Criar Obra
                Obra obra = new Obra();
                obra.setIdAutor(autor);
                obra.setNomeObra(nome_obra);
                break;
        }
        
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
    
}
