package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class UsuarioDAO {
	Connection cnx = null;
	
	public Produto buscaPorId(int id) {
		Produto produto = null;
		ResultSet rs = null;
		
		cnx = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_lista WHERE id=?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return produto;
	}
	
////////////////////////////////////////////////////////////////////////////
	public boolean alterarProduto(Produto produto) {
		boolean resultado = true;
		int retornoQuery;
		
		cnx = DAO.createConnection();
		
		String sql = "UPDATE tb_lista SET nome=?, quantidade=?, preco=? WHERE id=?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setInt(2, produto.getQuantidade());
			ps.setInt(3, produto.getId());
			ps.setDouble(4, produto.getPreco());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <=0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resultado;
	}
	
////////////////////////////////////////////////////////////////////////////
	public boolean excluirProduto(int id) {
		boolean resultado = true;
		int retornoQuery;
		
		cnx = DAO.createConnection();
		
		String sql = "DELETE FROM tb_lista WHERE id=?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setInt(1, id);
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <=0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	////////////////////////////////////////////////////////////////////////////
	public boolean incluirProduto(Produto produto) {
		boolean resultado = true;
		int retornoQuery;
		
		cnx = DAO.createConnection();
		
		String sql = "INSERT INTO tb_lista (nome, quantidade, preco) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setInt(2, produto.getQuantidade());
			ps.setDouble(3, produto.getPreco());
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <=0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	////////////////////////////////////////////////////////////////////////////
	public Produto consultarProduto(String nome, int quantidade, Double preco) {
		Produto produto = null;
		ResultSet rs = null;
		
		cnx= DAO.createConnection();
		
		String sql = "SELECT * FROM tb_lista WHERE nome = ? AND quantidade = ? AND preco = ?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setString(1, nome);
			ps.setInt(2, quantidade);
			ps.setDouble(3, preco);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produto;
	}
	////////////////////////////////////////////////////////////////////////////
	public List<Produto> listar(){
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		ResultSet rs = null;
		Produto produto = null;
		
		cnx = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_lista";
		
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				
				
				listaDeProdutos.add(produto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listaDeProdutos;
	}
	////////////////////////////////////////////////////
	public List<Produto> listarPreco(){
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		ResultSet rs = null;
		Produto produto = null;
		
		cnx = DAO.createConnection();
		
		String sql = "SELECT preco FROM tb_lista";
		
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				produto = new Produto();
				
				produto.setPreco(rs.getDouble("preco"));
				
				
				listaDeProdutos.add(produto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listaDeProdutos;
	}
	

	
}
