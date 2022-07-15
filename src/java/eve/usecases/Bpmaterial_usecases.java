/*
 * Generated on 13.6.2022 11:21
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
import eve.logicentity.Bpmaterial;
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
public class Bpmaterial_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLbpmaterial blbpmaterial = new BLbpmaterial(sqlreader);
    
    public Bpmaterial_usecases() {
        this(false);
    }
    
    public Bpmaterial_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blbpmaterial.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blbpmaterial.count();
    }
    
    public ArrayList<Bpmaterial> get_all() throws DBException {
        return blbpmaterial.getBpmaterials();
    }
    
    public boolean getBpmaterialExists(IBpmaterialPK bpmaterialPK) throws DBException {
        return blbpmaterial.getBpmaterialExists(bpmaterialPK);
    }
    
    public Bpmaterial get_bpmaterial_by_primarykey(IBpmaterialPK bpmaterialPK) throws DBException {
        return blbpmaterial.getBpmaterial(bpmaterialPK);
    }

    public ArrayList<Bpmaterial> get_bpmaterial_with_foreignkey_evetypeBp(IEvetypePK evetypeBpPK) throws CustomException {
        return blbpmaterial.getBpmaterials4evetypeBp(evetypeBpPK);
    }
    
    public ArrayList<Bpmaterial> get_bpmaterial_with_foreignkey_evetypeMaterial(IEvetypePK evetypeMaterialPK) throws CustomException {
        return blbpmaterial.getBpmaterials4evetypeMaterial(evetypeMaterialPK);
    }
    
    public ArrayList<Bpmaterial> search_bpmaterial(IBpmaterialsearch bpmaterialsearch) throws CustomException {
        return blbpmaterial.search(bpmaterialsearch);
    }
    
    public long search_bpmaterial_count(IBpmaterialsearch bpmaterialsearch) throws CustomException {
        return blbpmaterial.searchcount(bpmaterialsearch);
    }

    public void insertBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blbpmaterial.insertBpmaterial(tq, bpmaterial);
        sqlwriter.Commit2DB(tq);
    }

    public void updateBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blbpmaterial.updateBpmaterial(tq, bpmaterial);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blbpmaterial.deleteBpmaterial(tq, bpmaterial);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetypebp(IEvetypePK evetypeBpPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blbpmaterial.delete4evetypeBp(tq, evetypeBpPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Evetypematerial(IEvetypePK evetypeMaterialPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blbpmaterial.delete4evetypeMaterial(tq, evetypeMaterialPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

