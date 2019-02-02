package br.com.projetofinal.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetofinal.dao.CategoriaDao;
import br.com.projetofinal.dao.LoginDao;
import br.com.projetofinal.dao.ProdutoDao;
import br.com.projetofinal.dao.TamanhoDao;
import br.com.projetofinal.model.Categoria;
import br.com.projetofinal.model.Produto;
import br.com.projetofinal.model.Tamanho;
import br.com.projetofinal.util.Upload;

@WebServlet({ "/add", "/pizza/salgadas", "/pizza/doces", "/bebidas", "/crepes", "/buscarProduto", "/espaguetes", "/sobremesas", "/checkLogin"})
@MultipartConfig
public class ControllerProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerProduto() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			execute(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Upload up = new Upload();

		if (request.getServletPath().equals("/add")) { // Método para ADICIONAR produtos
			up.setFolderUpload("fotos");
			
			
			//Produto produto  = new Gson().fromJson(request.getReader(), Produto.class);
			Produto produto = new Produto();
			CategoriaDao daocat = new CategoriaDao();
			TamanhoDao tamanhodao = new TamanhoDao();
			
					
			if (up.formProcess(getServletContext(), request)) {
				int id = Integer.parseInt(up.getForm().get("categoria").toString());
				Categoria categoria = daocat.searchById(id);
				
				int idtamanho =  Integer.parseInt(up.getForm().get("tamanho").toString());
				Tamanho tamanho = tamanhodao.searchById(idtamanho);
				
				produto.setNome(up.getForm().get("nome").toString());
				produto.setPreco(Double.parseDouble(up.getForm().get("preco").toString()));
				produto.setImagem(up.getFiles().get(0));
				produto.setCategoria(categoria);
				produto.setDescricao(up.getForm().get("descricao").toString());
				produto.setTamanho(tamanho);

				ProdutoDao dao = new ProdutoDao();

				try {
					dao.add(produto);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

				response.sendRedirect("cadastroproduto.jsp");
			}
			
		} else if (request.getServletPath().equals("/pizza/salgadas")) {      // Method for list all items 	
			response.getWriter().append(Produto.arrayToJSON(new ProdutoDao().listPizza()));
		}else if(request.getServletPath().equals("/pizza/doces")) {
			response.getWriter().append(Produto.arrayToJSON(new ProdutoDao().listSweetPizza()));
		}else if(request.getServletPath().equals("/bebidas")) {
			response.getWriter().append(Produto.arrayToJSON(new ProdutoDao().listDriks()));
		}else if(request.getServletPath().equals("/buscarProduto")) {
			response.getWriter().append(new ProdutoDao().searchById(Integer.parseInt(request.getParameter("id"))).toJSON());
		}else if(request.getServletPath().equals("/crepes")) {
			response.getWriter().append(Produto.arrayToJSON(new ProdutoDao().listCrepe()));
		}else if(request.getServletPath().equals("/espaguetes")) {
			response.getWriter().append(Produto.arrayToJSON(new ProdutoDao().listPasta()));
		}else if(request.getServletPath().equals("/sobremesas")) {
			response.getWriter().append(Produto.arrayToJSON(new ProdutoDao().listSobreMesa()));
		}else if(request.getServletPath().equals("/checkLogin")) {
			HttpSession session = request.getSession();
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			LoginDao logindao = new LoginDao();
			
			
			if(logindao.autenticacao(login, senha)!=true) {
				response.sendRedirect("login.jsp");	
			}else {
				
				response.sendRedirect("adm.jsp");
				
			}
		}

	}
	
	
	
	

}
