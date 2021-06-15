/*
 * EveContextListener.java
 *
 * Created on Dec 23, 2012, 6:22 PM
 * Generated on 14.5.2021 13:35
 *
 */

package eve.listeners;

import eve.BusinessObject.security.Security;
import eve.servlets.Contextparameters;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Laseure Franky
 */
@WebListener()
public class EveContextListener implements ServletContextListener, Contextparameters {
   
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        Security security = new Security();
        context.setAttribute(SECURITY, security);
    }

    public void contextDestroyed(ServletContextEvent event) {

    }
}

