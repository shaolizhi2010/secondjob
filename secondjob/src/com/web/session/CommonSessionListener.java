package com.web.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CommonSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		arg0.getSession().setAttribute("test", "ttt");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		
	}

}
