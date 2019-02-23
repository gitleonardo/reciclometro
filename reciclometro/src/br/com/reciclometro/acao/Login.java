package br.com.reciclometro.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.reciclometro.dao.UsuarioDAO;
import br.com.reciclometro.model.Usuario;

public class Login implements Acao {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Usuario usuario = new Usuario();
		usuario.setUsername(req.getParameter("inputUsuario"));
		usuario.setSenha(req.getParameter("inputSenha"));

		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.autenticar(usuario);

		if(usuario.isValid()) {
			HttpSession session=req.getSession();
			session.setAttribute("usuarioLogado",usuario);
			return "redirect:controlador?acao=Home";
		} else {
			return "forward:formErroLogin.jsp";
		}
	}

}
