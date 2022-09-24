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
import eve.logicentity.Materialinput;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Materialinput_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLmaterialinput blmaterialinput = new BLmaterialinput(sqlreader);
    
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
        SQLTqueue transactionqueue = new SQLTqueue();
        blmaterialinput.useMaterial(transactionqueue, username, evetypePK, amount);
        sqlwriter.Commit2DB(transactionqueue);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blmaterialinput.count();
    }
    
    public ArrayList<Materialinput> get_all() throws DBException {
        return blmaterialinput.getMaterialinputs();
    }
    
    public boolean getMaterialinputExists(IMaterialinputPK materialinputPK) throws DBException {
        return blmaterialinput.getMaterialinputExists(materialinputPK);
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

    public void insertMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmaterialinput.insertMaterialinput(tq, materialinput);
        sqlwriter.Commit2DB(tq);
    }

    public void updateMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmaterialinput.updateMaterialinput(tq, materialinput);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmaterialinput.deleteMaterialinput(tq, materialinput);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blmaterialinput.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

