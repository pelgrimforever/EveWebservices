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
import eve.logicentity.Frontendpage_auth;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Frontendpage_auth_usecases {

    private boolean loggedin = false;
    private BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
    
    public Frontendpage_auth_usecases() {
        this(false);
    }
    
    public Frontendpage_auth_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blfrontendpage_auth.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public boolean check_userauthorisation_for_page(String authorisationstring, String page) throws DBException, IOException {
        String username = Security_usecases.getUsername(authorisationstring);
        return blfrontendpage_auth.checkAuth(username, page);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blfrontendpage_auth.count();
    }
    
    public ArrayList<Frontendpage_auth> get_all() throws DBException {
        return blfrontendpage_auth.getFrontendpage_auths();
    }
    
    public boolean getFrontendpage_authExists(IFrontendpage_authPK frontendpage_authPK) throws DBException {
        return blfrontendpage_auth.getEntityExists(frontendpage_authPK);
    }
    
    public Frontendpage_auth get_frontendpage_auth_by_primarykey(IFrontendpage_authPK frontendpage_authPK) throws DBException {
        return blfrontendpage_auth.getFrontendpage_auth(frontendpage_authPK);
    }

    public ArrayList<Frontendpage_auth> get_frontendpage_auth_with_foreignkey_frontendpage(IFrontendpagePK frontendpagePK) throws CustomException {
        return blfrontendpage_auth.getFrontendpage_auths4frontendpage(frontendpagePK);
    }
    
    public ArrayList<Frontendpage_auth> get_frontendpage_auth_with_foreignkey_eveuser(IEveuserPK eveuserPK) throws CustomException {
        return blfrontendpage_auth.getFrontendpage_auths4eveuser(eveuserPK);
    }
    
    public ArrayList<Frontendpage_auth> search_frontendpage_auth(IFrontendpage_authsearch frontendpage_authsearch) throws CustomException {
        return blfrontendpage_auth.search(frontendpage_authsearch);
    }
    
    public long search_frontendpage_auth_count(IFrontendpage_authsearch frontendpage_authsearch) throws CustomException {
        return blfrontendpage_auth.searchcount(frontendpage_authsearch);
    }

    public void secureinsertFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        blfrontendpage_auth.secureinsertFrontendpage_auth(frontendpage_auth);
    }

    public void secureupdateFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        blfrontendpage_auth.secureupdateFrontendpage_auth(frontendpage_auth);
    }

    public void securedeleteFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        blfrontendpage_auth.securedeleteFrontendpage_auth(frontendpage_auth);
    }
}

