package br.com.reciclometro.acao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.ProdutoDAO;
import br.com.reciclometro.model.Material;
import br.com.reciclometro.model.Produto;

public class NovoProduto implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(validarCamposObrigatorios(req,resp)) {
			Material material = new Material();
			material.setTipo(req.getParameter("inputMaterial"));

			if(material.getTipo().equalsIgnoreCase("vidro")) {
				material.setFormulacao("Areia");
			} else if(material.getTipo().equalsIgnoreCase("papel")) {
				material.setFormulacao("Madeira");
			} else if(material.getTipo().equalsIgnoreCase("metal")) {
				material.setFormulacao("Ferro");
			} else if(material.getTipo().equalsIgnoreCase("plástico")) {
				material.setFormulacao("Petróleo");
			}

			Produto produto = new Produto();
			produto.setTipo(material.getTipo());
			produto.setFormulacao(material.getFormulacao());
			produto.setDescricao(req.getParameter("inputDescricao"));
			produto.setPeso(Double.valueOf(req.getParameter("inputPeso")));

			ProdutoDAO produtoDao = new ProdutoDAO();
			if(produtoDao.inserir(produto)) {
				return "redirect:controlador?acao=Home";
			} else {
				return "forward:formErroProduto.jsp";
			}
		} else {
			return "";
		}
	}

	private boolean validarCamposObrigatorios(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		boolean retorno = true;

		PrintWriter out = resp.getWriter();

		if(req.getParameter("inputMaterial") == null || req.getParameter("inputMaterial") == "") {
			out.println("<p>Favor prencher o campo Material.</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			retorno = false;
		} else if(req.getParameter("inputDescricao") == null || req.getParameter("inputDescricao") == "") {
			out.println("<p>Favor prencher o campo Descrição.</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			retorno = false;
		} else if(req.getParameter("inputPeso") == null || req.getParameter("inputPeso") == "") {
			out.println("<p>Favor prencher o campo Peso.</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			retorno = false;
		}

		return retorno;
	}
}
