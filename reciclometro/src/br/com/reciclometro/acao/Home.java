package br.com.reciclometro.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.reciclometro.dao.ProdutoDAO;

public class Home implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		HttpSession session=req.getSession();
		req.setAttribute("totalReciclagem", produtoDAO.obterTotalReciclagem());
		req.setAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
		
		return "forward:index.jsp";
	}
}
