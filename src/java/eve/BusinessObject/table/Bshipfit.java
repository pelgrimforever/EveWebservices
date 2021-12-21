/*
 * Bshipfit.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.11.2021 16:16
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
import eve.conversion.json.JSONShipfit;
import eve.conversion.entity.EMshipfit;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitsearch;
import eve.logicentity.Shipfit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bshipfit
 *
 * Superclass for manipulating data- and database objects
 * for Entity Shipfit and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bshipfit extends BLtable {

    /**
     * Constructor, sets Shipfit as default Entity
     */
    public Bshipfit() {
        super(new Shipfit(), new EMshipfit());
    }

    /**
     * Constructor, sets Shipfit as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bshipfit(BLtable transactionobject) {
        super(transactionobject, new Shipfit(), new EMshipfit());
    }

    /**
     * create new empty Shipfit object
     * @return empty IShipfit
     */
    public IShipfit newShipfit() {
    	return new Shipfit();
    }
    
    /**
     * create new empty Shipfit object
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @return IShipfit with primary key
     */
    public IShipfit newShipfit(java.lang.String username, java.lang.String shipname) {
        return new Shipfit(username, shipname);
    }

    /**
     * create new empty Shipfit object with given primary key
     * @param shipfitPK: primary key for Shipfit
     * @return IShipfit with primary key
     */
    public IShipfit newShipfit(IShipfitPK shipfitPK) {
        return new Shipfit((ShipfitPK)shipfitPK);
    }

    /**
     * create new empty primary key
     * @return empty ShipfitPK
     */
    public IShipfitPK newShipfitPK() {
        return new ShipfitPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param shipname primary key field
     * @return new IShipfitPK
     */
    public IShipfitPK newShipfitPK(java.lang.String username, java.lang.String shipname) {
        return new ShipfitPK(username, shipname);
    }

    /**
     * get all Shipfit objects from database
     * @return ArrayList of Shipfit objects
     * @throws DBException
     */
    public ArrayList<Shipfit> getShipfits() throws DBException {
        return (ArrayList<Shipfit>)super.getEntities(EMshipfit.SQLSelectAll);
    }

    /**
     * search Shipfit for primary key
     * @param shipfitPK: Shipfit primary key
     * @return Shipfit object
     * @throws DBException
     */
    public Shipfit getShipfit(IShipfitPK shipfitPK) throws DBException {
        return (Shipfit)super.getEntity((ShipfitPK)shipfitPK);
    }

    /**
     * search shipfit with IShipfitsearch parameters
     * @param search IShipfitsearch
     * @return ArrayList of Shipfit
     * @throws DBException 
     */
    public ArrayList<Shipfit> searchshipfits(IShipfitsearch search) throws DBException {
        return (ArrayList<Shipfit>)this.search(search);
    }

    /**
     * search shipfit with IShipfitsearch parameters, order by orderby sql clause
     * @param search IShipfitsearch
     * @param orderby sql order by string
     * @return ArrayList of Shipfit
     * @throws DBException 
     */
    public ArrayList<Shipfit> searchshipfits(IShipfitsearch search, String orderby) throws DBException {
        return (ArrayList<Shipfit>)this.search(search, orderby);
    }

    /**
     * Search shipfit in database for shipfitPK:
     * @param shipfitPK: Shipfit Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getShipfitExists(IShipfitPK shipfitPK) throws DBException {
        return super.getEntityExists((ShipfitPK)shipfitPK);
    }

    /**
     * try to insert Shipfit in database
     * @param shipfit Shipfit object
     * @throws DBException
     * @throws DataException
     */
    public void insertShipfit(IShipfit shipfit) throws DBException, DataException {
        super.insertEntity(shipfit);
    }

    /**
     * check if ShipfitPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param shipfit Shipfit object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateShipfit(IShipfit shipfit) throws DBException, DataException {
        if(this.getShipfitExists(shipfit.getPrimaryKey())) {
            super.updateEntity(shipfit);
        } else {
            super.insertEntity(shipfit);
        }
    }

    /**
     * try to update Shipfit in database
     * @param shipfit Shipfit object
     * @throws DBException
     * @throws DataException
     */
    public void updateShipfit(IShipfit shipfit) throws DBException, DataException {
        super.updateEntity(shipfit);
    }

    /**
     * try to delete Shipfit in database
     * @param shipfit Shipfit object
     * @throws DBException
     */
    public void deleteShipfit(IShipfit shipfit) throws DBException {
        cascadedeleteShipfit(shipfit.getPrimaryKey());
        super.deleteEntity(shipfit);
    }

    /**
     * check data rules in Shipfit, throw DataException with customized message if rules do not apply
     * @param shipfit Shipfit object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IShipfit shipfit) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where shipfitPK is used in a primary key
     * @param shipfitPK: Shipfit primary key
     */
    public void cascadedeleteShipfit(IShipfitPK shipfitPK) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule(this);
        blshipfitmodule.delete4shipfit(shipfitPK);
        BLshipfitorder blshipfitorder = new BLshipfitorder(this);
        blshipfitorder.delete4shipfit(shipfitPK);
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Shipfit Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMshipfit.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Shipfit Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Shipfit> getShipfits4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMshipfit.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param shipfitmodulePK: parent Shipfitmodule for child object Shipfit Entity
     * @return child Shipfit Entity object
     * @throws CustomException
     */
    public Shipfit getShipfitmodule(IShipfitmodulePK shipfitmodulePK) throws CustomException {
        ShipfitPK shipfitPK = new ShipfitPK(shipfitmodulePK.getUsername(), shipfitmodulePK.getShipname());
        return this.getShipfit(shipfitPK);
    }

    /**
     * @param shipfitorderPK: parent Shipfitorder for child object Shipfit Entity
     * @return child Shipfit Entity object
     * @throws CustomException
     */
    public Shipfit getShipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        ShipfitPK shipfitPK = new ShipfitPK(shipfitorderPK.getUsername(), shipfitorderPK.getShipname());
        return this.getShipfit(shipfitPK);
    }


    /**
     * get all Shipfit objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Shipfit objects
     * @throws DBException
     */
    public ArrayList<Shipfit> getShipfits(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfit.SQLSelect);
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
        return (ArrayList<Shipfit>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Shipfit objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delShipfit(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfit.table);
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
