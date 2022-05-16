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
import eve.logicentity.Bpmaterial;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Bpmaterial_usecases {

    private boolean loggedin = false;
    private BLbpmaterial blbpmaterial = new BLbpmaterial();
    
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
        return blbpmaterial.getEntityExists(bpmaterialPK);
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
    
    public ArrayList<Bpmaterial> search_bpmaterial(IBpmaterialsearch bpmaterialsearch) throws ParseException, CustomException {
        return blbpmaterial.search(bpmaterialsearch);
    }
    
    public long search_bpmaterial_count(IBpmaterialsearch bpmaterialsearch) throws ParseException, CustomException {
        return blbpmaterial.searchcount(bpmaterialsearch);
    }

    public void secureinsertBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        blbpmaterial.secureinsertBpmaterial(bpmaterial);
    }

    public void secureupdateBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        blbpmaterial.secureupdateBpmaterial(bpmaterial);
    }

    public void securedeleteBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        blbpmaterial.securedeleteBpmaterial(bpmaterial);
    }
}

