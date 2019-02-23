package br.com.reciclometro.acao;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
	String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException;
}
