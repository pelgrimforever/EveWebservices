/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Eveuser;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Eveuser_usecases {

    private boolean loggedin = false;
    private BLeveuser bleveuser = new BLeveuser();
    
    public Eveuser_usecases() {
        this(false);
    }
    
    public Eveuser_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bleveuser.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public String create_new_user(IEveuser eveuser, String authorisationstring) throws DBException, DataException, DatahandlerException {
        String returnmessage = "OK";
        if(bleveuser.getEveuserExists(eveuser.getPrimaryKey())) {
            returnmessage = "User exists";
        } else {
            String registerusername = eveuser.getPrimaryKey().getUsername();
            String registerpassword = eveuser.getPrimaryKey().getUsername();
            boolean isregistered = Security_usecases.register(authorisationstring, registerusername, registerpassword);
            if(isregistered)
                bleveuser.secureinsertEveuser(eveuser);
            else
                returnmessage = "Registration failed";
        }
        return returnmessage;
    }
    
    public String update_password(String authorisationstring, String newauthorisationstring) throws DatahandlerException, DBException, IOException {
        String result;
        String username = Security_usecases.getUsername(authorisationstring);
        IEveuserPK eveuserPK = new EveuserPK(username);
        if(getEveuserExists(eveuserPK))
            result = update_password_in_database(authorisationstring, newauthorisationstring);
        else
            result = "User not found";
        return result;
    }

    private String update_password_in_database(String authorisationstring, String newauthorisationstring) throws DatahandlerException {
        String result;
        boolean isupdated = Security_usecases.updatepass(authorisationstring, newauthorisationstring);
        if(isupdated)
            result = "OK";
        else
            result = "Password update failed";
        return result;
    }

    public String reset(String authorisationstring, IEveuser eveuser) throws DatahandlerException, DBException, IOException {
        String result;
        if(getEveuserExists(eveuser.getPrimaryKey()))
            result = reset_eveuser_in_database(authorisationstring, eveuser);
        else
            result = "User not found";
        return result;
    }

    private String reset_eveuser_in_database(String authorisationstring, IEveuser eveuser) throws DatahandlerException {
        String result;
        boolean isreset = Security_usecases.reset(authorisationstring, eveuser.getPrimaryKey().getUsername());
        if(isreset)
            result = "OK";
        else
            result = "Reset failed";
        return result;
    }

    public String delete_registration(String authorisationstring, IEveuser eveuser) throws DBException, DataException, DatahandlerException {
        String resultmessage = "Not authorized";
        boolean isadmin = Security_usecases.isadmin(authorisationstring);
        if(isadmin) {
            bleveuser.securedeleteEveuser(eveuser);
            resultmessage = "OK";
        }
        return resultmessage;
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bleveuser.count();
    }
    
    public ArrayList<Eveuser> get_all() throws DBException {
        return bleveuser.getEveusers();
    }
    
    public boolean getEveuserExists(IEveuserPK eveuserPK) throws DBException {
        return bleveuser.getEntityExists(eveuserPK);
    }
    
    public Eveuser get_eveuser_by_primarykey(IEveuserPK eveuserPK) throws DBException {
        return bleveuser.getEveuser(eveuserPK);
    }

    public Eveuser get_eveuser_with_externalforeignkey_frontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws CustomException {
        return bleveuser.getFrontendpage_auth(frontendpage_authPK);
    }
    
    public ArrayList<Eveuser> search_eveuser(IEveusersearch eveusersearch) throws CustomException {
        return bleveuser.search(eveusersearch);
    }
    
    public long search_eveuser_count(IEveusersearch eveusersearch) throws CustomException {
        return bleveuser.searchcount(eveusersearch);
    }

    public void secureinsertEveuser(IEveuser eveuser) throws DBException, DataException {
        bleveuser.secureinsertEveuser(eveuser);
    }

    public void secureupdateEveuser(IEveuser eveuser) throws DBException, DataException {
        bleveuser.secureupdateEveuser(eveuser);
    }

    public void securedeleteEveuser(IEveuser eveuser) throws DBException, DataException {
        bleveuser.securedeleteEveuser(eveuser);
    }
}

