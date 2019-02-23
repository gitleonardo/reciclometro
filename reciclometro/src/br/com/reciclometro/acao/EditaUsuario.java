package br.com.reciclometro.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.UsuarioDAO;
import br.com.reciclometro.model.Usuario;

public class EditaUsuario implements Acao {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.obterUsuarioPorId(req.getParameter("id"));
		
		if(usuario != null) {
			req.setAttribute("editaUsuario", usuario);
			return "forward:formUsuario.jsp";
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<p>Erro ao editar usuário</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			return "";
		}
	}
}
