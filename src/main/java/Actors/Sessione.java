package Actors;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.session.Session;
import org.eclipse.jetty.server.session.SessionData;
import org.eclipse.jetty.server.session.SessionHandler;

public class Sessione extends Session{

	public Sessione(SessionHandler handler, HttpServletRequest request, SessionData data) {
		super(handler, request, data);

	}

}
