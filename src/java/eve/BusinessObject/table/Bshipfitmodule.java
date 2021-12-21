/*
 * Bshipfitmodule.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:34
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
import eve.conversion.json.JSONShipfitmodule;
import eve.conversion.entity.EMshipfitmodule;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.logicentity.Shipfitmodule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bshipfitmodule
 *
 * Superclass for manipulating data- and database objects
 * for Entity Shipfitmodule and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bshipfitmodule extends BLtable {

    /**
     * Constructor, sets Shipfitmodule as default Entity
     */
    public Bshipfitmodule() {
        super(new Shipfitmodule(), new EMshipfitmodule());
    }

    /**
     * Constructor, sets Shipfitmodule as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bshipfitmodule(BLtable transactionobject) {
        super(transactionobject, new Shipfitmodule(), new EMshipfitmodule());
    }

    /**
     * create new empty Shipfitmodule object
     * @return empty IShipfitmodule
     */
    public IShipfitmodule newShipfitmodule() {
    	return new Shipfitmodule();
    }
    
    /**
     * create new empty Shipfitmodule object
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @param moduletype primary key field
     * @return IShipfitmodule with primary key
     */
    public IShipfitmodule newShipfitmodule(java.lang.String username, java.lang.String shipname, long moduletype) {
        return new Shipfitmodule(username, shipname, moduletype);
    }

    /**
     * create new empty Shipfitmodule object with given primary key
     * @param shipfitmodulePK: primary key for Shipfitmodule
     * @return IShipfitmodule with primary key
     */
    public IShipfitmodule newShipfitmodule(IShipfitmodulePK shipfitmodulePK) {
        return new Shipfitmodule((ShipfitmodulePK)shipfitmodulePK);
    }

    /**
     * create new empty primary key
     * @return empty ShipfitmodulePK
     */
    public IShipfitmodulePK newShipfitmodulePK() {
        return new ShipfitmodulePK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @param moduletype primary key field
     * @return new IShipfitmodulePK
     */
    public IShipfitmodulePK newShipfitmodulePK(java.lang.String username, java.lang.String shipname, long moduletype) {
        return new ShipfitmodulePK(username, shipname, moduletype);
    }

    /**
     * get all Shipfitmodule objects from database
     * @return ArrayList of Shipfitmodule objects
     * @throws DBException
     */
    public ArrayList<Shipfitmodule> getShipfitmodules() throws DBException {
        return (ArrayList<Shipfitmodule>)super.getEntities(EMshipfitmodule.SQLSelectAll);
    }

    /**
     * search Shipfitmodule for primary key
     * @param shipfitmodulePK: Shipfitmodule primary key
     * @return Shipfitmodule object
     * @throws DBException
     */
    public Shipfitmodule getShipfitmodule(IShipfitmodulePK shipfitmodulePK) throws DBException {
        return (Shipfitmodule)super.getEntity((ShipfitmodulePK)shipfitmodulePK);
    }

    /**
     * search shipfitmodule with IShipfitmodulesearch parameters
     * @param search IShipfitmodulesearch
     * @return ArrayList of Shipfitmodule
     * @throws DBException 
     */
    public ArrayList<Shipfitmodule> searchshipfitmodules(IShipfitmodulesearch search) throws DBException {
        return (ArrayList<Shipfitmodule>)this.search(search);
    }

    /**
     * search shipfitmodule with IShipfitmodulesearch parameters, order by orderby sql clause
     * @param search IShipfitmodulesearch
     * @param orderby sql order by string
     * @return ArrayList of Shipfitmodule
     * @throws DBException 
     */
    public ArrayList<Shipfitmodule> searchshipfitmodules(IShipfitmodulesearch search, String orderby) throws DBException {
        return (ArrayList<Shipfitmodule>)this.search(search, orderby);
    }

    /**
     * Search shipfitmodule in database for shipfitmodulePK:
     * @param shipfitmodulePK: Shipfitmodule Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getShipfitmoduleExists(IShipfitmodulePK shipfitmodulePK) throws DBException {
        return super.getEntityExists((ShipfitmodulePK)shipfitmodulePK);
    }

    /**
     * try to insert Shipfitmodule in database
     * @param shipfitmodule Shipfitmodule object
     * @throws DBException
     * @throws DataException
     */
    public void insertShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        super.insertEntity(shipfitmodule);
    }

    /**
     * check if ShipfitmodulePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param shipfitmodule Shipfitmodule object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        if(this.getShipfitmoduleExists(shipfitmodule.getPrimaryKey())) {
            super.updateEntity(shipfitmodule);
        } else {
            super.insertEntity(shipfitmodule);
        }
    }

    /**
     * try to update Shipfitmodule in database
     * @param shipfitmodule Shipfitmodule object
     * @throws DBException
     * @throws DataException
     */
    public void updateShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        super.updateEntity(shipfitmodule);
    }

    /**
     * try to delete Shipfitmodule in database
     * @param shipfitmodule Shipfitmodule object
     * @throws DBException
     */
    public void deleteShipfitmodule(IShipfitmodule shipfitmodule) throws DBException {
        cascadedeleteShipfitmodule(shipfitmodule.getPrimaryKey());
        super.deleteEntity(shipfitmodule);
    }

    /**
     * check data rules in Shipfitmodule, throw DataException with customized message if rules do not apply
     * @param shipfitmodule Shipfitmodule object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IShipfitmodule shipfitmodule) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Shipfitmodule.Username - Shipfit.Username
        //foreign key Shipfitmodule.Shipname - Shipfit.Shipname
        //foreign key Shipfitmodule.Moduletype - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where shipfitmodulePK is used in a primary key
     * @param shipfitmodulePK: Shipfitmodule primary key
     */
    public void cascadedeleteShipfitmodule(IShipfitmodulePK shipfitmodulePK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Shipfitmodule Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMshipfitmodule.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Shipfitmodule Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Shipfitmodule> getShipfitmodules4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMshipfitmodule.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param shipfitPK: foreign key for Shipfit
     * @delete all Shipfitmodule Entity objects for Shipfit in database
     */
    public void delete4shipfit(IShipfitPK shipfitPK) {
        super.addStatement(EMshipfitmodule.SQLDelete4shipfit, shipfitPK.getSQLprimarykey());
    }

    /**
     * @param shipfitPK: foreign key for Shipfit
     * @return all Shipfitmodule Entity objects for Shipfit
     * @throws CustomException
     */
    public ArrayList<Shipfitmodule> getShipfitmodules4shipfit(IShipfitPK shipfitPK) throws CustomException {
        return super.getEntities(EMshipfitmodule.SQLSelect4shipfit, shipfitPK.getSQLprimarykey());
    }

    /**
     * get all Shipfitmodule objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Shipfitmodule objects
     * @throws DBException
     */
    public ArrayList<Shipfitmodule> getShipfitmodules(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfitmodule.SQLSelect);
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
        return (ArrayList<Shipfitmodule>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Shipfitmodule objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delShipfitmodule(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfitmodule.table);
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
