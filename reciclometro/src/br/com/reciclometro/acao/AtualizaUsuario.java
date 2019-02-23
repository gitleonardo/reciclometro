package br.com.reciclometro.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reciclometro.dao.UsuarioDAO;
import br.com.reciclometro.model.Usuario;

public class AtualizaUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {

		if(validaCamposObrigatorios(req, resp)) {
			if(usuarioJaExiste(req, resp)==false) {

				UsuarioDAO usuarioDao = new UsuarioDAO();
				Usuario usuario = usuarioDao.obterUsuarioPorId(req.getParameter("id"));

				if(usuario != null) {
					usuario.setUsername(req.getParameter("inputUsername"));
					usuario.setSenha(req.getParameter("inputSenha"));

					if(usuarioDao.atualizar(usuario)) {
						return "redirect:controlador?acao=ListaUsuarios";
					} else {
						PrintWriter out = resp.getWriter();
						out.println("<p>Erro ao atualizar usuário</p>");
						out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
						return "";
					}

				} else {
					PrintWriter out = resp.getWriter();
					out.println("<p>Erro ao atualizar usuário</p>");
					out.println("<p><a href=\"javascript:history.back()\">Voltar</a></p>");
					return "";
				}

			}} return "";
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
