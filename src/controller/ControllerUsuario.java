package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DaoUsuario;
import model.entidade.Usuario;

@WebServlet("/ControllerUsuario")
public class ControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerUsuario() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String botao = request.getParameter("botao");
		
		System.out.println(botao);
		
		if (botao.equals("Entrar")) {
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario user = new Usuario(email,senha);
			
			DaoUsuario dao = new DaoUsuario();
			user = dao.login(user);
			if(user != null) {
				request.getSession().setAttribute("email", user.getEmail());
				request.getSession().setAttribute("idUser", user.getId());
				response.sendRedirect("main.jsp");
			}
		}else if(botao.equals("CADASTRAR")) {
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario user = new Usuario(email,senha);
			
			DaoUsuario dao = new DaoUsuario();
			
			if(dao.cadastra(user)) {
				response.sendRedirect("index.html");
			}				
		}
	}

}