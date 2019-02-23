package br.com.reciclometro.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.UsuarioDAO;
import br.com.reciclometro.model.Usuario;

public class NovoUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		String retorno = "";

		if(validaCamposObrigatorios(req, resp)) {
			if(usuarioJaExiste(req, resp)==false) {
				Usuario usuario = new Usuario();
				usuario.setUsername(req.getParameter("inputUsername"));
				usuario.setSenha(req.getParameter("inputSenha"));

				UsuarioDAO usuarioDao = new UsuarioDAO();		
				if(usuarioDao.inserir(usuario)) {
					retorno = "redirect:controlador?acao=Home";
				} else {
					retorno = "forward:formErroUsuario.jsp";
				}
			}
		}

		return retorno;
	}

	private boolean usuarioJaExiste(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		boolean retorno = true;

		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.obterUsuario(req.getParameter("inputUsername"));
		
		if(usuario!=null) {
			PrintWriter out = resp.getWriter();
			out.println("<p>O nome de usuário já existe. Favor escolher outro.</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
		} else {
			retorno = false;
		}

		return retorno;
	}

	public boolean validaCamposObrigatorios(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		boolean retorno = true;

		PrintWriter out = resp.getWriter();

		if(req.getParameter("inputUsername") == null || req.getParameter("inputUsername") == "") {
			out.println("<p>Favor prencher o campo Usuário.</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			retorno = false;
		} else if(req.getParameter("inputSenha") == null || req.getParameter("inputSenha") == "") {
			out.println("<p>Favor prencher o campo Senha.</p>");
			out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
			retorno = false;
		}

		return retorno;
	}

}
