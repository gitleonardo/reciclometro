package br.com.reciclometro.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.UsuarioDAO;

public class RemoveUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		if(usuarioDao.remover(req.getParameter("id"))) {
			return "redirect:controlador?acao=ListaUsuarios";
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<p>Erro ao remover usuário</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			return "";
		}
	}

}
