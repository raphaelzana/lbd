package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import model.dao.DaoSorteio;
import model.dao.DaoSorteioUsuario;
import model.entidade.Sorteio;
import model.entidade.UsuarioSorteio;

@WebServlet("/ControllerSorteio")
public class ControllerSorteio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerSorteio() {
        super();   
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
			String botao = request.getParameter("botao");	
			
	if (botao.equals("Sortear")){	
		
		HttpSession sessao = request.getSession();
		String idSorteio = sessao.getAttribute("idSorteio").toString();
		String emailUser = sessao.getAttribute("email").toString();
		
		DaoSorteioUsuario dsu = new DaoSorteioUsuario();
		
		String ganhador = dsu.sorteia(emailUser, Integer.parseInt(idSorteio));
		
		
		request.getSession().setAttribute("ganhador", ganhador);
		response.sendRedirect("ganhador.jsp");
		
	}else if(botao.equals("Criar sorteio")) {
				
				String sorteio   = request.getParameter("sorteio");
				String descr   = request.getParameter("descr");
				String prem	    = request.getParameter("prem");
				//String email = (String) request.getAttribute("email");
				HttpSession sessao = request.getSession();
				String emailSessao = (String)sessao.getAttribute("email");
				
				System.out.println(emailSessao);
				
				Sorteio sor = new Sorteio(sorteio,emailSessao,"01-01-2001",descr,prem);
				
				DaoSorteio dao = new DaoSorteio();
				
				if(dao.criar(sor)) {
					request.getSession().setAttribute("email", emailSessao);
					response.sendRedirect("main.jsp");
				}			
			}else if (botao.equals("Ir")) {
				
				String hash   = request.getParameter("hash");
				
				DaoSorteio dao = new DaoSorteio();
				
				Sorteio sor = dao.procurar(Integer.parseInt(hash));
				
				request.getSession().setAttribute("idSorteio", sor.getId());
				request.getSession().setAttribute("nomeSorteio", sor.getNome());
				request.getSession().setAttribute("emailSorteio", sor.getEmail());
				request.getSession().setAttribute("dataSorteio", sor.getData_termino());
				request.getSession().setAttribute("descricao", sor.getDescricao());
				request.getSession().setAttribute("premiacao", sor.getPremiacao());
				
				response.sendRedirect("sorteio1.jsp");		
		}else if (botao.equals("Inscrever-se")) {
		
		HttpSession sessao = request.getSession();
		String idSorteio = sessao.getAttribute("idSorteio").toString();
		//String idSessao = (String) request.getSession().getAttribute("idSorteio");
		
		String idUser = sessao.getAttribute("idUser").toString();
		
		//cria entidade usuario sorteio
		UsuarioSorteio usuSor = new UsuarioSorteio(Integer.parseInt(idUser),Integer.parseInt(idSorteio));
		
		DaoSorteioUsuario dsu = new DaoSorteioUsuario();
		
		if(dsu.cadastra(usuSor)) {
			JOptionPane.showMessageDialog(null,"Inscrito!!!");
			response.sendRedirect("main.jsp");
		}
		
	
}
}
}