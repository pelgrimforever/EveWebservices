/*
 * Generated on 17.6.2022 13:4
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
import eve.logicentity.Userbp;
import eve.logicview.*;
import eve.usecases.custom.*;
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
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLuserbp bluserbp = new BLuserbp(sqlreader);
    
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
        SQLTqueue transactionqueue = new SQLTqueue();
        bluserbp.insertNewbp(transactionqueue, userbp);
        sqlwriter.Commit2DB(transactionqueue);
    }

    public void updateProperties(IUserbp userbp) throws DBException, DataException {
        SQLTqueue transactionqueue = new SQLTqueue();
        bluserbp.updateProperties(transactionqueue, userbp);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private BLbpmaterial blbpmaterial;
    private BLmaterialinput blmaterialinput;
    
    public void run_blueprint(UserbpPK userbpPK_torun, int amount) throws DBException, CustomException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blbpmaterial = new BLbpmaterial(bluserbp);
        blmaterialinput = new BLmaterialinput(bluserbp);
        Userbp userbp = bluserbp.getUserbp(userbpPK_torun);
        ArrayList<Bpmaterial> bpmaterials = blbpmaterial.getBpmaterials4evetypeBp(userbpPK_torun.getEvetypePK());
        for(Bpmaterial bpmaterial: bpmaterials) {
            long totamount = Double.valueOf(Math.ceil(bpmaterial.getAmount() * amount * (100-userbp.getMaterialefficiency()) / 100)).longValue();
            blmaterialinput.useMaterial(transactionqueue, userbpPK_torun.getUsername(), (EvetypePK)bpmaterial.getPrimaryKey().getEvetypematerialPK(), totamount);
        }
        userbp.setAmountproduced(userbp.getAmountproduced() + amount);
        bluserbp.updateUserbp(transactionqueue, userbp);
        sqlwriter.Commit2DB(transactionqueue);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bluserbp.count();
    }
    
    public ArrayList<Userbp> get_all() throws DBException {
        return bluserbp.getUserbps();
    }
    
    public boolean getUserbpExists(IUserbpPK userbpPK) throws DBException {
        return bluserbp.getUserbpExists(userbpPK);
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

    public void insertUserbp(IUserbp userbp) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluserbp.insertUserbp(tq, userbp);
        sqlwriter.Commit2DB(tq);
    }

    public void updateUserbp(IUserbp userbp) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluserbp.updateUserbp(tq, userbp);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteUserbp(IUserbp userbp) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluserbp.deleteUserbp(tq, userbp);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bluserbp.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

