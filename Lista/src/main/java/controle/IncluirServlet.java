package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;
import servišo.ProdutoServišo;


@WebServlet("/IncluirServlet")
public class IncluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public IncluirServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto pdt = new Produto();
		ProdutoServišo servico = new ProdutoServišo();  
		
		pdt.setNome(request.getParameter("nome"));
		pdt.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		pdt.setPreco(Double.parseDouble(request.getParameter("prešo")));
		
		//Integer.parseInt(request.getParameter("quantidade"));
		
		if(servico.incluir(pdt)) {
			response.sendRedirect("index.jsp");
		
		}
	}
}
