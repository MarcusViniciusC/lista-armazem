package controle;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Produto;
import serviço.ProdutoServiço;


@WebServlet("/AlteracaoProduto")
public class AlteracaoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AlteracaoProduto() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ProdutoServiço servico = new  ProdutoServiço();
		Produto produto = new Produto();
		
		String idRequisicao = request.getParameter("id");
		
		produto = servico.buscaPorId(Integer.parseInt(idRequisicao));
		
		if(!Objects.isNull(produto)) {
			session.setAttribute("produtoSelecionado", produto);
			
			response.sendRedirect("alterar.jsp");
		}else {
			response.sendRedirect("erro.jsp");
		}
	}

}
