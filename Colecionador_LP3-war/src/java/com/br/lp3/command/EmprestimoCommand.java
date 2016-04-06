package com.br.lp3.command;

import com.br.lp3.entities.Autor;
import com.br.lp3.entities.Emprestimo;
import static com.br.lp3.entities.Emprestimo_.dataEmprestimo;
import static com.br.lp3.entities.Emprestimo_.idObra;
import com.br.lp3.entities.InfoUsuario;
import com.br.lp3.entities.Obra;
import com.br.lp3.entities.Usuario;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class EmprestimoCommand implements Command{

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
               String datest = request.getParameter("data_emprestimo");
               //Cria Usuario
               long id_usuario = 0 ;
               Usuario usuario = new Usuario();
               usuario.setIdUsuario(id_usuario);
               //Criar Usuário 
               InfoUsuario infoU = new InfoUsuario();
               infoU.setIdInfousuario(id_usuario);
               
               //Cria autor
               long id_autor = 0 ; 
               Autor autor = new Autor();
               autor.setIdAutor(id_autor);
               //Criar Obra
                Obra obra = new Obra();
                obra.setIdAutor(autor);
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setDataEmprestimo((Date) dataEmprestimo);
                emprestimo.setIdObra((Obra) idObra);
                emprestimo.setIdUsuario(infoU); 
             break;   
        }
    }
        
        
    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
    
}
