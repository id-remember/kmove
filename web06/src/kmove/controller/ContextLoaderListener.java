package kmove.controller;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import kmove.controller.ApplicationContext;
@WebListener
public class ContextLoaderListener implements ServletContextListener {
  static ApplicationContext applicationContext;
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext servletContext = event.getServletContext();
      String propertiesPath = servletContext.getRealPath(
          servletContext.getInitParameter("contextConfigLocation"));
      applicationContext = new ApplicationContext(propertiesPath);
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }
  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}
