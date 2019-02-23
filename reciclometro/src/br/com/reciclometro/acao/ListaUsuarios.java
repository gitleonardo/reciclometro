package br.com.reciclometro.acao;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.UsuarioDAO;
import br.com.reciclometro.model.Usuario;

public class ListaUsuarios implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<Usuario> listaUsuarios = usuarioDao.obterTodosUsuarios();
		req.setAttribute("listaUsuarios", listaUsuarios);
		
		return "forward:listaDeUsuarios.jsp";

	}

}
