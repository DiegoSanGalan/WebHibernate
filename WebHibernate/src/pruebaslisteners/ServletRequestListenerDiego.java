package pruebaslisteners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestListenerDiego implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("ServletRequestListenerDiego ************** método requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletRequestListenerDiego ************** método requestInitialized");
	}

}
