/*
 * Bshipfitorder.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.0.2022 16:56
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
import eve.conversion.json.JSONShipfitorder;
import eve.conversion.entity.EMshipfitorder;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.logicentity.Shipfitorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bshipfitorder
 *
 * Superclass for manipulating data- and database objects
 * for Entity Shipfitorder and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bshipfitorder extends BLtable {

    /**
     * Constructor, sets Shipfitorder as default Entity
     */
    public Bshipfitorder() {
        super(new Shipfitorder(), new EMshipfitorder());
    }

    /**
     * Constructor, sets Shipfitorder as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bshipfitorder(BLtable transactionobject) {
        super(transactionobject, new Shipfitorder(), new EMshipfitorder());
    }

    /**
     * create new empty Shipfitorder object
     * @return empty IShipfitorder
     */
    public IShipfitorder newShipfitorder() {
    	return new Shipfitorder();
    }
    
    /**
     * create new empty Shipfitorder object
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @param evetype primary key field
     * @return IShipfitorder with primary key
     */
    public IShipfitorder newShipfitorder(java.lang.String username, java.lang.String shipname, long evetype) {
        return new Shipfitorder(username, shipname, evetype);
    }

    /**
     * create new empty Shipfitorder object with given primary key
     * @param shipfitorderPK: primary key for Shipfitorder
     * @return IShipfitorder with primary key
     */
    public IShipfitorder newShipfitorder(IShipfitorderPK shipfitorderPK) {
        return new Shipfitorder((ShipfitorderPK)shipfitorderPK);
    }

    /**
     * create new empty primary key
     * @return empty ShipfitorderPK
     */
    public IShipfitorderPK newShipfitorderPK() {
        return new ShipfitorderPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @param evetype primary key field
     * @return new IShipfitorderPK
     */
    public IShipfitorderPK newShipfitorderPK(java.lang.String username, java.lang.String shipname, long evetype) {
        return new ShipfitorderPK(username, shipname, evetype);
    }

    /**
     * get all Shipfitorder objects from database
     * @return ArrayList of Shipfitorder objects
     * @throws DBException
     */
    public ArrayList<Shipfitorder> getShipfitorders() throws DBException {
        return (ArrayList<Shipfitorder>)super.getEntities(EMshipfitorder.SQLSelectAll);
    }

    /**
     * search Shipfitorder for primary key
     * @param shipfitorderPK: Shipfitorder primary key
     * @return Shipfitorder object
     * @throws DBException
     */
    public Shipfitorder getShipfitorder(IShipfitorderPK shipfitorderPK) throws DBException {
        return (Shipfitorder)super.getEntity((ShipfitorderPK)shipfitorderPK);
    }

    /**
     * search shipfitorder with IShipfitordersearch parameters
     * @param search IShipfitordersearch
     * @return ArrayList of Shipfitorder
     * @throws DBException 
     */
    public ArrayList<Shipfitorder> searchshipfitorders(IShipfitordersearch search) throws DBException {
        return (ArrayList<Shipfitorder>)this.search(search);
    }

    /**
     * search shipfitorder with IShipfitordersearch parameters, order by orderby sql clause
     * @param search IShipfitordersearch
     * @param orderby sql order by string
     * @return ArrayList of Shipfitorder
     * @throws DBException 
     */
    public ArrayList<Shipfitorder> searchshipfitorders(IShipfitordersearch search, String orderby) throws DBException {
        return (ArrayList<Shipfitorder>)this.search(search, orderby);
    }

    /**
     * Search shipfitorder in database for shipfitorderPK:
     * @param shipfitorderPK: Shipfitorder Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getShipfitorderExists(IShipfitorderPK shipfitorderPK) throws DBException {
        return super.getEntityExists((ShipfitorderPK)shipfitorderPK);
    }

    /**
     * try to insert Shipfitorder in database
     * @param shipfitorder Shipfitorder object
     * @throws DBException
     * @throws DataException
     */
    public void insertShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        super.insertEntity(shipfitorder);
    }

    /**
     * check if ShipfitorderPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param shipfitorder Shipfitorder object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        if(this.getShipfitorderExists(shipfitorder.getPrimaryKey())) {
            super.updateEntity(shipfitorder);
        } else {
            super.insertEntity(shipfitorder);
        }
    }

    /**
     * try to update Shipfitorder in database
     * @param shipfitorder Shipfitorder object
     * @throws DBException
     * @throws DataException
     */
    public void updateShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        super.updateEntity(shipfitorder);
    }

    /**
     * try to delete Shipfitorder in database
     * @param shipfitorder Shipfitorder object
     * @throws DBException
     */
    public void deleteShipfitorder(IShipfitorder shipfitorder) throws DBException {
        cascadedeleteShipfitorder(shipfitorder.getPrimaryKey());
        super.deleteEntity(shipfitorder);
    }

    /**
     * check data rules in Shipfitorder, throw DataException with customized message if rules do not apply
     * @param shipfitorder Shipfitorder object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IShipfitorder shipfitorder) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Shipfitorder.Username - Shipfit.Username
        //foreign key Shipfitorder.Shipname - Shipfit.Shipname
        //foreign key Shipfitorder.Evetype - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where shipfitorderPK is used in a primary key
     * @param shipfitorderPK: Shipfitorder primary key
     */
    public void cascadedeleteShipfitorder(IShipfitorderPK shipfitorderPK) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected(this);
        blshipfitorderselected.delete4shipfitorder(shipfitorderPK);
    }

    /**
     * @param shipfitPK: foreign key for Shipfit
     * @delete all Shipfitorder Entity objects for Shipfit in database
     */
    public void delete4shipfit(IShipfitPK shipfitPK) {
        super.addStatement(EMshipfitorder.SQLDelete4shipfit, shipfitPK.getSQLprimarykey());
    }

    /**
     * @param shipfitPK: foreign key for Shipfit
     * @return all Shipfitorder Entity objects for Shipfit
     * @throws CustomException
     */
    public ArrayList<Shipfitorder> getShipfitorders4shipfit(IShipfitPK shipfitPK) throws CustomException {
        return super.getEntities(EMshipfitorder.SQLSelect4shipfit, shipfitPK.getSQLprimarykey());
    }
    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Shipfitorder Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMshipfitorder.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Shipfitorder Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Shipfitorder> getShipfitorders4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMshipfitorder.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param shipfitorderselectedPK: parent Shipfitorderselected for child object Shipfitorder Entity
     * @return child Shipfitorder Entity object
     * @throws CustomException
     */
    public Shipfitorder getShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws CustomException {
        ShipfitorderPK shipfitorderPK = new ShipfitorderPK(shipfitorderselectedPK.getUsername(), shipfitorderselectedPK.getShipname(), shipfitorderselectedPK.getEvetype());
        return this.getShipfitorder(shipfitorderPK);
    }


    /**
     * get all Shipfitorder objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Shipfitorder objects
     * @throws DBException
     */
    public ArrayList<Shipfitorder> getShipfitorders(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfitorder.SQLSelect);
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
        return (ArrayList<Shipfitorder>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Shipfitorder objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delShipfitorder(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfitorder.table);
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
