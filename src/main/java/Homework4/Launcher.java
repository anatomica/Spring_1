package Homework4;

import Homework3.PrepareStoreApp;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import java.net.URL;
import java.security.ProtectionDomain;

public class Launcher {

    // products: http://localhost:8189/store/products

    public static void main(String[] args) throws Exception {
        PrepareStoreApp.forcePrepareData();
        PrepareProductsDB.forcePrepareData();

        Server server = new Server(8189);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/store");
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}