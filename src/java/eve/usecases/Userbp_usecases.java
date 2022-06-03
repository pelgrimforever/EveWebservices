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
import eve.logicentity.Userbp;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Userbp_usecases {

    private boolean loggedin = false;
    private BLuserbp bluserbp = new BLuserbp();
    
    public Userbp_usecases() {
        this(false);
    }
    
    public Userbp_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bluserbp.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void add_blueprint(IUserbp userbp) throws DBException, DataException {
        bluserbp.insertNewbp(userbp);
    }

    public void updateProperties(IUserbp userbp) throws DBException, DataException {
        bluserbp.updateProperties(userbp);
    }

    public void run_blueprint(UserbpPK userbpPK_torun, int amount) throws DBException, CustomException {
        bluserbp.runbp(userbpPK_torun, amount);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bluserbp.count();
    }
    
    public ArrayList<Userbp> get_all() throws DBException {
        return bluserbp.getUserbps();
    }
    
    public boolean getUserbpExists(IUserbpPK userbpPK) throws DBException {
        return bluserbp.getEntityExists(userbpPK);
    }
    
    public Userbp get_userbp_by_primarykey(IUserbpPK userbpPK) throws DBException {
        return bluserbp.getUserbp(userbpPK);
    }

    public ArrayList<Userbp> get_userbp_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return bluserbp.getUserbps4evetype(evetypePK);
    }
    
    public ArrayList<Userbp> search_userbp(IUserbpsearch userbpsearch) throws CustomException {
        return bluserbp.search(userbpsearch);
    }
    
    public long search_userbp_count(IUserbpsearch userbpsearch) throws CustomException {
        return bluserbp.searchcount(userbpsearch);
    }

    public void secureinsertUserbp(IUserbp userbp) throws DBException, DataException {
        bluserbp.secureinsertUserbp(userbp);
    }

    public void secureupdateUserbp(IUserbp userbp) throws DBException, DataException {
        bluserbp.secureupdateUserbp(userbp);
    }

    public void securedeleteUserbp(IUserbp userbp) throws DBException, DataException {
        bluserbp.securedeleteUserbp(userbp);
    }
}

