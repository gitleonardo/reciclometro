package br.com.reciclometro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.acao.Acao;

@WebServlet("/controlador")
public class Controlador extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramAcao = req.getParameter("acao");
		String nome = null;

		String nomeDaClasse = "br.com.reciclometro.acao."+paramAcao;

		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(req, resp);
		} else if(tipoEEndereco[0].equals("redirect")) {
			resp.sendRedirect(req.getContextPath() +"/"+ tipoEEndereco[1]);
		}

	}
}
