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
import eve.logicentity.Materialinput;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Materialinput_usecases {

    private boolean loggedin = false;
    private BLmaterialinput blmaterialinput = new BLmaterialinput();
    
    public Materialinput_usecases() {
        this(false);
    }
    
    public Materialinput_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blmaterialinput.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void update_materialusage(String username, long amount, IEvetypePK evetypePK) throws DBException, DataException {
        blmaterialinput.useMaterial(username, evetypePK, amount);
        blmaterialinput.Commit2DB();
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blmaterialinput.count();
    }
    
    public ArrayList<Materialinput> get_all() throws DBException {
        return blmaterialinput.getMaterialinputs();
    }
    
    public boolean getMaterialinputExists(IMaterialinputPK materialinputPK) throws DBException {
        return blmaterialinput.getEntityExists(materialinputPK);
    }
    
    public Materialinput get_materialinput_by_primarykey(IMaterialinputPK materialinputPK) throws DBException {
        return blmaterialinput.getMaterialinput(materialinputPK);
    }

    public ArrayList<Materialinput> get_materialinput_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blmaterialinput.getMaterialinputs4evetype(evetypePK);
    }
    
    public ArrayList<Materialinput> search_materialinput(IMaterialinputsearch materialinputsearch) throws CustomException {
        return blmaterialinput.search(materialinputsearch);
    }
    
    public long search_materialinput_count(IMaterialinputsearch materialinputsearch) throws CustomException {
        return blmaterialinput.searchcount(materialinputsearch);
    }

    public void secureinsertMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        blmaterialinput.secureinsertMaterialinput(materialinput);
    }

    public void secureupdateMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        blmaterialinput.secureupdateMaterialinput(materialinput);
    }

    public void securedeleteMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        blmaterialinput.securedeleteMaterialinput(materialinput);
    }
}

