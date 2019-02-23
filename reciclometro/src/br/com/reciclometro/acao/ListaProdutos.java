package br.com.reciclometro.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.ProdutoDAO;
import br.com.reciclometro.model.Produto;

public class ListaProdutos implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> listaProdutos = produtoDAO.obterTodosProdutos();
		req.setAttribute("listaProdutos", listaProdutos);
		
		return "forward:listaDeProdutos.jsp";
	}
}
