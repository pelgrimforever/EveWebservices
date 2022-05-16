/*
 * Bmaterialinput.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONMaterialinput;
import eve.conversion.entity.EMmaterialinput;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IMaterialinputsearch;
import eve.logicentity.Materialinput;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bmaterialinput
 *
 * Superclass for manipulating data- and database objects
 * for Entity Materialinput and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bmaterialinput extends BLtable {

    /**
     * Constructor, sets Materialinput as default Entity
     */
    public Bmaterialinput() {
        super(new Materialinput(), new EMmaterialinput());
    }

    /**
     * Constructor, sets Materialinput as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmaterialinput(BLtable transactionobject) {
        super(transactionobject, new Materialinput(), new EMmaterialinput());
    }

    /**
     * create new empty Materialinput object
     * @return empty IMaterialinput
     */
    public IMaterialinput newMaterialinput() {
    	return new Materialinput();
    }
    
    /**
     * create new empty Materialinput object
     * create new primary key with given parameters
     * @param username primary key field
     * @param evetype primary key field
     * @param addtimestamp primary key field
     * @return IMaterialinput with primary key
     */
    public IMaterialinput newMaterialinput(java.lang.String username, long evetype, java.sql.Timestamp addtimestamp) {
        return new Materialinput(username, evetype, addtimestamp);
    }

    /**
     * create new empty Materialinput object with given primary key
     * @param materialinputPK: primary key for Materialinput
     * @return IMaterialinput with primary key
     */
    public IMaterialinput newMaterialinput(IMaterialinputPK materialinputPK) {
        return new Materialinput((MaterialinputPK)materialinputPK);
    }

    /**
     * create new empty primary key
     * @return empty MaterialinputPK
     */
    public IMaterialinputPK newMaterialinputPK() {
        return new MaterialinputPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param evetype primary key field
     * @param addtimestamp primary key field
     * @return new IMaterialinputPK
     */
    public IMaterialinputPK newMaterialinputPK(java.lang.String username, long evetype, java.sql.Timestamp addtimestamp) {
        return new MaterialinputPK(username, evetype, addtimestamp);
    }

    /**
     * get all Materialinput objects from database
     * @return ArrayList of Materialinput objects
     * @throws DBException
     */
    public ArrayList<Materialinput> getMaterialinputs() throws DBException {
        return (ArrayList<Materialinput>)super.getEntities(EMmaterialinput.SQLSelectAll);
    }

    /**
     * search Materialinput for primary key
     * @param materialinputPK: Materialinput primary key
     * @return Materialinput object
     * @throws DBException
     */
    public Materialinput getMaterialinput(IMaterialinputPK materialinputPK) throws DBException {
        return (Materialinput)super.getEntity((MaterialinputPK)materialinputPK);
    }

    /**
     * search materialinput with IMaterialinputsearch parameters
     * @param search IMaterialinputsearch
     * @return ArrayList of Materialinput
     * @throws DBException 
     */
    public ArrayList<Materialinput> searchmaterialinputs(IMaterialinputsearch search) throws DBException {
        return (ArrayList<Materialinput>)this.search(search);
    }

    /**
     * search materialinput with IMaterialinputsearch parameters, order by orderby sql clause
     * @param search IMaterialinputsearch
     * @param orderby sql order by string
     * @return ArrayList of Materialinput
     * @throws DBException 
     */
    public ArrayList<Materialinput> searchmaterialinputs(IMaterialinputsearch search, String orderby) throws DBException {
        return (ArrayList<Materialinput>)this.search(search, orderby);
    }

    /**
     * Search materialinput in database for materialinputPK:
     * @param materialinputPK: Materialinput Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMaterialinputExists(IMaterialinputPK materialinputPK) throws DBException {
        return super.getEntityExists((MaterialinputPK)materialinputPK);
    }

    /**
     * try to insert Materialinput in database
     * @param materialinput Materialinput object
     * @throws DBException
     * @throws DataException
     */
    public void insertMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        super.insertEntity(materialinput);
    }

    /**
     * check if MaterialinputPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param materialinput Materialinput object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        if(this.getMaterialinputExists(materialinput.getPrimaryKey())) {
            super.updateEntity(materialinput);
        } else {
            super.insertEntity(materialinput);
        }
    }

    /**
     * try to update Materialinput in database
     * @param materialinput Materialinput object
     * @throws DBException
     * @throws DataException
     */
    public void updateMaterialinput(IMaterialinput materialinput) throws DBException, DataException {
        super.updateEntity(materialinput);
    }

    /**
     * try to delete Materialinput in database
     * @param materialinput Materialinput object
     * @throws DBException
     */
    public void deleteMaterialinput(IMaterialinput materialinput) throws DBException {
        cascadedeleteMaterialinput(materialinput.getPrimaryKey());
        super.deleteEntity(materialinput);
    }

    /**
     * check data rules in Materialinput, throw DataException with customized message if rules do not apply
     * @param materialinput Materialinput object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMaterialinput materialinput) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Materialinput.Evetype - Evetype.Id
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where materialinputPK is used in a primary key
     * @param materialinputPK: Materialinput primary key
     */
    public void cascadedeleteMaterialinput(IMaterialinputPK materialinputPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Materialinput Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMmaterialinput.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Materialinput Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Materialinput> getMaterialinputs4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMmaterialinput.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * get all Materialinput objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Materialinput objects
     * @throws DBException
     */
    public ArrayList<Materialinput> getMaterialinputs(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmaterialinput.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Materialinput>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Materialinput objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delMaterialinput(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Materialinput.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
