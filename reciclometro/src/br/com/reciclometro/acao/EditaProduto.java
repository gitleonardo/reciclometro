package br.com.reciclometro.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.ProdutoDAO;
import br.com.reciclometro.model.Produto;

public class EditaProduto implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		ProdutoDAO produtoDao = new ProdutoDAO();
		Produto produto = produtoDao.obterProduto(req.getParameter("id"));
		
		if(produto != null) {
			req.setAttribute("editaProduto", produto);
			return "forward:formProduto.jsp";
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<p>Erro ao editar produto</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			return "";
		}
	}

}
