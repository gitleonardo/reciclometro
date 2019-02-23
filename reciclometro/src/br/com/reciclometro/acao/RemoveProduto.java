package br.com.reciclometro.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.ProdutoDAO;

public class RemoveProduto implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		ProdutoDAO produtoDao = new ProdutoDAO();
		if(produtoDao.remover(req.getParameter("id"))) {
			return "redirect:controlador?acao=ListaProdutos";
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<p>Erro ao remover produto</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			return "";
		}
	}

}
