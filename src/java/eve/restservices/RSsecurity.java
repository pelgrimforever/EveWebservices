/*
 * RSsecurity.java
 *
 * Generated on 14.0.2022 16:56
 *
 */

package eve.restservices;

import base.servlets.DataHandler;
import base.servlets.Securitycheck;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.simple.JSONObject;

/**
 *
 * @author Franky Laseure
 */
public class RSsecurity {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static boolean check(JSONObject json) throws DatahandlerException {
//Custom code, do not change this line   
//Change security check to your own needs
        try {
            String auth = (String)json.get("auth");
            if(auth!=null) {
                DataHandler.SERVER = "http://localhost:8080/";
                return Securitycheck.checkLoginstring(auth);
            } else return false;
        } 
        catch(IOException e) {
            return false;
        }        
/*
//This code can replace the above code for custom security check 
//if the project has a custom user table eveuser
        BLeveuser bleveuser = new BLeveuser();
        String authstring = null;
        String username = "";
        String password = "";
        try {
            authstring = Securitycheck.decode((String)json.get("auth"));
        }
        catch(IOException ioe) {
        }
        catch(NullPointerException ioe) {
        }
        finally {
            username = Securitycheck.filterUsername(authstring);
            password = Securitycheck.filterPassword(authstring);
        }
        if(authstring!=null) {
            Eveuser founduser = bleveuser.authenticate(username, password);
            return founduser!=null;
        } else return false;
*/
//Custom code, do not change this line   
    }

    public static boolean register(String auth1, String username) throws DatahandlerException {
        if(username!=null) {
            DataHandler.SERVER = "http://localhost:8080/";
            return Securitycheck.register(auth1, username, username);
        } else return false;
    }

    public static boolean reset(String auth1, String username) throws DatahandlerException {
        if(username!=null) {
            DataHandler.SERVER = "http://localhost:8080/";
            return Securitycheck.reset(auth1, username);
        } else return false;
    }

    public static boolean isadmin(String auth1) throws DatahandlerException {
        DataHandler.SERVER = "http://localhost:8080/";
        return Securitycheck.isadmin(auth1);
    }

    public static boolean updatepass(String auth1, String auth2) throws DatahandlerException {
        if(auth1!=null && auth2!=null) {
            DataHandler.SERVER = "http://localhost:8080/";
            return Securitycheck.updatepass(auth1, auth2);
        } else return false;
    }

}
