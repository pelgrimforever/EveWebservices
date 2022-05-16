/*
 * Bshipfitorderselected.java
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
import eve.conversion.json.JSONShipfitorderselected;
import eve.conversion.entity.EMshipfitorderselected;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.logicentity.Shipfitorderselected;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bshipfitorderselected
 *
 * Superclass for manipulating data- and database objects
 * for Entity Shipfitorderselected and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bshipfitorderselected extends BLtable {

    /**
     * Constructor, sets Shipfitorderselected as default Entity
     */
    public Bshipfitorderselected() {
        super(new Shipfitorderselected(), new EMshipfitorderselected());
    }

    /**
     * Constructor, sets Shipfitorderselected as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bshipfitorderselected(BLtable transactionobject) {
        super(transactionobject, new Shipfitorderselected(), new EMshipfitorderselected());
    }

    /**
     * create new empty Shipfitorderselected object
     * @return empty IShipfitorderselected
     */
    public IShipfitorderselected newShipfitorderselected() {
    	return new Shipfitorderselected();
    }
    
    /**
     * create new empty Shipfitorderselected object
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @param evetype primary key field
     * @param orderid primary key field
     * @return IShipfitorderselected with primary key
     */
    public IShipfitorderselected newShipfitorderselected(java.lang.String username, java.lang.String shipname, long evetype, long orderid) {
        return new Shipfitorderselected(username, shipname, evetype, orderid);
    }

    /**
     * create new empty Shipfitorderselected object with given primary key
     * @param shipfitorderselectedPK: primary key for Shipfitorderselected
     * @return IShipfitorderselected with primary key
     */
    public IShipfitorderselected newShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) {
        return new Shipfitorderselected((ShipfitorderselectedPK)shipfitorderselectedPK);
    }

    /**
     * create new empty primary key
     * @return empty ShipfitorderselectedPK
     */
    public IShipfitorderselectedPK newShipfitorderselectedPK() {
        return new ShipfitorderselectedPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @param evetype primary key field
     * @param orderid primary key field
     * @return new IShipfitorderselectedPK
     */
    public IShipfitorderselectedPK newShipfitorderselectedPK(java.lang.String username, java.lang.String shipname, long evetype, long orderid) {
        return new ShipfitorderselectedPK(username, shipname, evetype, orderid);
    }

    /**
     * get all Shipfitorderselected objects from database
     * @return ArrayList of Shipfitorderselected objects
     * @throws DBException
     */
    public ArrayList<Shipfitorderselected> getShipfitorderselecteds() throws DBException {
        return (ArrayList<Shipfitorderselected>)super.getEntities(EMshipfitorderselected.SQLSelectAll);
    }

    /**
     * search Shipfitorderselected for primary key
     * @param shipfitorderselectedPK: Shipfitorderselected primary key
     * @return Shipfitorderselected object
     * @throws DBException
     */
    public Shipfitorderselected getShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws DBException {
        return (Shipfitorderselected)super.getEntity((ShipfitorderselectedPK)shipfitorderselectedPK);
    }

    /**
     * search shipfitorderselected with IShipfitorderselectedsearch parameters
     * @param search IShipfitorderselectedsearch
     * @return ArrayList of Shipfitorderselected
     * @throws DBException 
     */
    public ArrayList<Shipfitorderselected> searchshipfitorderselecteds(IShipfitorderselectedsearch search) throws DBException {
        return (ArrayList<Shipfitorderselected>)this.search(search);
    }

    /**
     * search shipfitorderselected with IShipfitorderselectedsearch parameters, order by orderby sql clause
     * @param search IShipfitorderselectedsearch
     * @param orderby sql order by string
     * @return ArrayList of Shipfitorderselected
     * @throws DBException 
     */
    public ArrayList<Shipfitorderselected> searchshipfitorderselecteds(IShipfitorderselectedsearch search, String orderby) throws DBException {
        return (ArrayList<Shipfitorderselected>)this.search(search, orderby);
    }

    /**
     * Search shipfitorderselected in database for shipfitorderselectedPK:
     * @param shipfitorderselectedPK: Shipfitorderselected Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getShipfitorderselectedExists(IShipfitorderselectedPK shipfitorderselectedPK) throws DBException {
        return super.getEntityExists((ShipfitorderselectedPK)shipfitorderselectedPK);
    }

    /**
     * try to insert Shipfitorderselected in database
     * @param shipfitorderselected Shipfitorderselected object
     * @throws DBException
     * @throws DataException
     */
    public void insertShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        super.insertEntity(shipfitorderselected);
    }

    /**
     * check if ShipfitorderselectedPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param shipfitorderselected Shipfitorderselected object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        if(this.getShipfitorderselectedExists(shipfitorderselected.getPrimaryKey())) {
            super.updateEntity(shipfitorderselected);
        } else {
            super.insertEntity(shipfitorderselected);
        }
    }

    /**
     * try to update Shipfitorderselected in database
     * @param shipfitorderselected Shipfitorderselected object
     * @throws DBException
     * @throws DataException
     */
    public void updateShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        super.updateEntity(shipfitorderselected);
    }

    /**
     * try to delete Shipfitorderselected in database
     * @param shipfitorderselected Shipfitorderselected object
     * @throws DBException
     */
    public void deleteShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException {
        cascadedeleteShipfitorderselected(shipfitorderselected.getPrimaryKey());
        super.deleteEntity(shipfitorderselected);
    }

    /**
     * check data rules in Shipfitorderselected, throw DataException with customized message if rules do not apply
     * @param shipfitorderselected Shipfitorderselected object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IShipfitorderselected shipfitorderselected) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Shipfitorderselected.Username - Shipfitorder.Username
        //foreign key Shipfitorderselected.Shipname - Shipfitorder.Shipname
        //foreign key Shipfitorderselected.Evetype - Shipfitorder.Evetype
        //foreign key Shipfitorderselected.Orderid - Orders.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where shipfitorderselectedPK is used in a primary key
     * @param shipfitorderselectedPK: Shipfitorderselected primary key
     */
    public void cascadedeleteShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) {
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Shipfitorderselected Entity objects for Orders in database
     */
    public void delete4orders(IOrdersPK ordersPK) {
        super.addStatement(EMshipfitorderselected.SQLDelete4orders, ordersPK.getSQLprimarykey());
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Shipfitorderselected Entity objects for Orders
     * @throws CustomException
     */
    public ArrayList<Shipfitorderselected> getShipfitorderselecteds4orders(IOrdersPK ordersPK) throws CustomException {
        return super.getEntities(EMshipfitorderselected.SQLSelect4orders, ordersPK.getSQLprimarykey());
    }
    /**
     * @param shipfitorderPK: foreign key for Shipfitorder
     * @delete all Shipfitorderselected Entity objects for Shipfitorder in database
     */
    public void delete4shipfitorder(IShipfitorderPK shipfitorderPK) {
        super.addStatement(EMshipfitorderselected.SQLDelete4shipfitorder, shipfitorderPK.getSQLprimarykey());
    }

    /**
     * @param shipfitorderPK: foreign key for Shipfitorder
     * @return all Shipfitorderselected Entity objects for Shipfitorder
     * @throws CustomException
     */
    public ArrayList<Shipfitorderselected> getShipfitorderselecteds4shipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        return super.getEntities(EMshipfitorderselected.SQLSelect4shipfitorder, shipfitorderPK.getSQLprimarykey());
    }

    /**
     * get all Shipfitorderselected objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Shipfitorderselected objects
     * @throws DBException
     */
    public ArrayList<Shipfitorderselected> getShipfitorderselecteds(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfitorderselected.SQLSelect);
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
        return (ArrayList<Shipfitorderselected>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Shipfitorderselected objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delShipfitorderselected(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfitorderselected.table);
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
