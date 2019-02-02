package br.com.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.projetofinal.conexao.Conexao;
import br.com.projetofinal.model.ItemVenda;
import br.com.projetofinal.model.Venda;

public class VendaDao {
	
	
	public boolean add(Venda venda) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();  
		boolean success = false;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into venda (precoTotal_venda, data_venda, itemvenda_iditem_venda, numero_mesa) values (?,?,?,?)");
			stmt.setDouble(1, venda.getPrecoTotal());
		    stmt.setString(2, venda.getData_compra());
		    stmt.setInt(3, venda.getId_itemVenda());
			stmt.setString(4, venda.getNumeroMesa());
			stmt.execute();
			success = true;

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt);
		}
		return success;

	}

	public List<Venda> list() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Venda> venda = new ArrayList<Venda>();
		try {

			stmt = con.prepareStatement("select * from venda");
			rs = stmt.executeQuery();
			
			

			while (rs.next()) {
			Venda v = new Venda();
			ItemVenda itemvenda = new ItemVenda();
			
			    itemvenda.setId(rs.getInt("itemvenda_iditem_venda"));
				
				v.setId(rs.getInt("idvenda"));
				v.setPrecoTotal(rs.getDouble("precoTotal_venda"));
				v.setId_itemVenda(itemvenda.getId());
				v.setData_compra(rs.getString("data_venda"));
				v.setNumeroMesa(rs.getString("numero_mesa"));
				venda.add(v);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return venda;
	}
	
	
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
		stmt = con.prepareStatement("delete from venda where idvenda=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		}catch(SQLException ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		VendaDao dao = new VendaDao();
		
		for (Venda venda : dao.list()) {
			System.out.println("id:"+venda.getId());
			System.out.println("data:"+venda.getData_compra());
			System.out.println("id venda:"+venda.getId_itemVenda());
			System.out.println("numero da mesa:"+venda.getNumeroMesa());
			System.out.println("preço total:"+venda.getPrecoTotal());
			
		}
	}
	
	
}
