package eve.usecases.custom;

import base.servlets.DataHandler;
import base.servlets.Securitycheck;
import static base.servlets.Securitycheck.decode;
import static base.servlets.Securitycheck.filterPassword;
import static base.servlets.Securitycheck.filterUsername;
import general.exception.DatahandlerException;
import java.io.IOException;

/**
 * @author Franky Laseure
 */
public class Security_usecases {
//Metacoder: NO AUTHOMATIC UPDATE

    public Security_usecases() {}
    
    public String getUsername(String encryptedstring) throws IOException {
        String decoded = decode(encryptedstring);
        return filterUsername(decoded);
    }
    
    public String getEncryptedpassword(String encryptedstring) throws IOException {
        String decoded = decode(encryptedstring);
        return filterPassword(decoded);
    }
    
    public boolean check_authorization(String authorisationstring) throws IOException, DatahandlerException {
        DataHandler.SERVER = "http://localhost:8080/";
        return Securitycheck.checkLoginstring(authorisationstring);        
    }
    
    public boolean register(String authorisationstring, String username, String password) throws DatahandlerException {
        DataHandler.SERVER = "http://localhost:8080/";
        return Securitycheck.register(authorisationstring, username, password);
    }
    
    public boolean reset(String authorisationstring, String username) throws DatahandlerException {
        DataHandler.SERVER = "http://localhost:8080/";
        return Securitycheck.reset(authorisationstring, username);
    }

    public boolean isadmin(String authorisationstring) throws DatahandlerException {
        DataHandler.SERVER = "http://localhost:8080/";
        return Securitycheck.isadmin(authorisationstring);
    }

    public boolean updatepass(String authorisationstring1, String authorisationstring2) throws DatahandlerException {
        DataHandler.SERVER = "http://localhost:8080/";
        return Securitycheck.updatepass(authorisationstring1, authorisationstring2);
    }
}
