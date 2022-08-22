<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="dao.UsuarioDAO" %>
<%@page import="modelo.Produto" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista de compras</title>
	<link rel="stylesheet" href="style.css">
	<link rel="shortcut icon" href="imgage/logo.png">
		<script>
			
			function confirmarExclusao(id){
				var resposta = confirm("deseja mesmo escluir este item?");
				
				if(resposta == true){
					window.location.href = "ExcluirServlet?id="+ id;
				}
			}
		
		</script>
</head>
<body>
	
	
    
	 <div id="btn-dark">
        <input type="checkbox" class="checkbox" id="chk"/>
        <label class="label" for="chk">
            <i class="fas fa-moon"></i>
            <i class="fas fa-sun"></i>
            <div class="ball"></div>
        </label>
    </div>
    
     
    
		<div id="tudo">
		<div id="titulo">
		<img src="image/pc.svg" width="110px" id="pc">
			<h2>Lista de compras</h2>
		</div>
		
	<div id="formulario">
	
	<form action="IncluirServlet" method="post">
		<input type="text" placeholder="produto" name="nome" id="nome" maxlength="25" class="preencher" required/><br>
		<input type="number" min="1"  placeholder="quantidade" name="quantidade" id="quantidade" class="preencher" required/><br>
		<input type="number" min="1"  placeholder="preço" name="preço" id="preço" class="preencher" required/><br>
		<input type="submit" value="Adicionar item" id="botao" class="botao"/><br>
	</form><br>
	
		<table border=1>
			<tr>
				<th>PRODUTO&ensp;&ensp;</th>
				<th>QUANTIDADE&ensp;&ensp;</th>
				<th>PREÇO&ensp;&ensp;</th>
				<th colspan=2></th>
			</tr>
			
			<%
			UsuarioDAO dao = new UsuarioDAO();
			List<Produto> lista = new ArrayList<Produto>();
			List<Produto> listaPreco = new ArrayList<Produto>();

			listaPreco = dao.listarPreco();
			lista = dao.listar();
			
			for(Produto produto: lista){%>
			
				<tr>
					<td>
						<%=produto.getNome()%>
					</td>
					<td>
						<%=produto.getQuantidade()%>
					</td>
					<td>
						<%=produto.getPreco()%>
					</td>
					<td>
						 <a href="AlteracaoProduto?id=<%=produto.getId()%>"><img src="image/editar.webp" width="24px"/></a>
					</td>
					<td>
						<img src="image/deletar.png" id="excluir" width="24px" onclick="confirmarExclusao(<%=produto.getId()%>)"/>
					</td>
				</tr>
					</div>
				</div>
				
			
			<%
			}
			%>
		
			<%
				Double var = sueint.doubleValue() ;
				double calculo = 0;
			
				for(Produto produto: listaPreco ){
					calculo = calculo + produto.getPreco();
					
				}
			
			%>
			
			<span><%=calculo%></span>
			
			<script src="script.js"></script>
    <script src="https://kit.fontawesome.com/998c60ef77.js" crossorigin="anonymous"></script>
    
   
	
</body>
</html>