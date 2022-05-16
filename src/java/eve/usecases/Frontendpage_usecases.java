/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Frontendpage;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Frontendpage_usecases {

    private boolean loggedin = false;
    private BLfrontendpage blfrontendpage = new BLfrontendpage();
    
    public Frontendpage_usecases() {
        this(false);
    }
    
    public Frontendpage_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blfrontendpage.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blfrontendpage.count();
    }
    
    public ArrayList<Frontendpage> get_all() throws DBException {
        return blfrontendpage.getFrontendpages();
    }
    
    public boolean getFrontendpageExists(IFrontendpagePK frontendpagePK) throws DBException {
        return blfrontendpage.getEntityExists(frontendpagePK);
    }
    
    public Frontendpage get_frontendpage_by_primarykey(IFrontendpagePK frontendpagePK) throws DBException {
        return blfrontendpage.getFrontendpage(frontendpagePK);
    }

    public Frontendpage get_frontendpage_with_externalforeignkey_frontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws CustomException {
        return blfrontendpage.getFrontendpage_auth(frontendpage_authPK);
    }
    
    public ArrayList<Frontendpage> search_frontendpage(IFrontendpagesearch frontendpagesearch) throws ParseException, CustomException {
        return blfrontendpage.search(frontendpagesearch);
    }
    
    public long search_frontendpage_count(IFrontendpagesearch frontendpagesearch) throws ParseException, CustomException {
        return blfrontendpage.searchcount(frontendpagesearch);
    }

    public void secureinsertFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        blfrontendpage.secureinsertFrontendpage(frontendpage);
    }

    public void secureupdateFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        blfrontendpage.secureupdateFrontendpage(frontendpage);
    }

    public void securedeleteFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        blfrontendpage.securedeleteFrontendpage(frontendpage);
    }
}

