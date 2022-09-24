/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Frontendpage;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Frontendpage_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLfrontendpage blfrontendpage = new BLfrontendpage(sqlreader);
    
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
        return blfrontendpage.getFrontendpageExists(frontendpagePK);
    }
    
    public Frontendpage get_frontendpage_by_primarykey(IFrontendpagePK frontendpagePK) throws DBException {
        return blfrontendpage.getFrontendpage(frontendpagePK);
    }

    public Frontendpage get_frontendpage_with_externalforeignkey_frontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws CustomException {
        return blfrontendpage.getFrontendpage_auth(frontendpage_authPK);
    }
    
    public ArrayList<Frontendpage> search_frontendpage(IFrontendpagesearch frontendpagesearch) throws CustomException {
        return blfrontendpage.search(frontendpagesearch);
    }
    
    public long search_frontendpage_count(IFrontendpagesearch frontendpagesearch) throws CustomException {
        return blfrontendpage.searchcount(frontendpagesearch);
    }

    public void insertFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfrontendpage.insertFrontendpage(tq, frontendpage);
        sqlwriter.Commit2DB(tq);
    }

    public void updateFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfrontendpage.updateFrontendpage(tq, frontendpage);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfrontendpage.deleteFrontendpage(tq, frontendpage);
        sqlwriter.Commit2DB(tq);
    }

}

