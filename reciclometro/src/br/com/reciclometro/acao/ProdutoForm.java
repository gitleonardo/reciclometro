package br.com.reciclometro.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoForm implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		return "forward:formProduto.jsp";
	}
}
