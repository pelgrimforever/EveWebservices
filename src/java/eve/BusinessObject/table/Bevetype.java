/*
 * Bevetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
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
import eve.conversion.json.JSONEvetype;
import eve.conversion.entity.EMevetype;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IEvetypesearch;
import eve.logicentity.Evetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bevetype
 *
 * Superclass for manipulating data- and database objects
 * for Entity Evetype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bevetype extends BLtable {

    /**
     * Constructor, sets Evetype as default Entity
     */
    public Bevetype() {
        super(new Evetype(), new EMevetype());
    }

    /**
     * Constructor, sets Evetype as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bevetype(BLtable transactionobject) {
        super(transactionobject, new Evetype(), new EMevetype());
    }

    /**
     * create new empty Evetype object
     * @return empty IEvetype
     */
    public IEvetype newEvetype() {
    	return new Evetype();
    }
    
    /**
     * create new empty Evetype object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IEvetype with primary key
     */
    public IEvetype newEvetype(long id) {
        return new Evetype(id);
    }

    /**
     * create new empty Evetype object with given primary key
     * @param evetypePK: primary key for Evetype
     * @return IEvetype with primary key
     */
    public IEvetype newEvetype(IEvetypePK evetypePK) {
        return new Evetype((EvetypePK)evetypePK);
    }

    /**
     * create new empty primary key
     * @return empty EvetypePK
     */
    public IEvetypePK newEvetypePK() {
        return new EvetypePK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IEvetypePK
     */
    public IEvetypePK newEvetypePK(long id) {
        return new EvetypePK(id);
    }

    /**
     * get all Evetype objects from database
     * @return ArrayList of Evetype objects
     * @throws DBException
     */
    public ArrayList<Evetype> getEvetypes() throws DBException {
        return (ArrayList<Evetype>)super.getEntities(EMevetype.SQLSelectAll);
    }

    /**
     * search Evetype for primary key
     * @param evetypePK: Evetype primary key
     * @return Evetype object
     * @throws DBException
     */
    public Evetype getEvetype(IEvetypePK evetypePK) throws DBException {
        return (Evetype)super.getEntity((EvetypePK)evetypePK);
    }

    /**
     * search evetype with IEvetypesearch parameters
     * @param search IEvetypesearch
     * @return ArrayList of Evetype
     * @throws DBException 
     */
    public ArrayList<Evetype> searchevetypes(IEvetypesearch search) throws DBException {
        return (ArrayList<Evetype>)this.search(search);
    }

    /**
     * search evetype with IEvetypesearch parameters, order by orderby sql clause
     * @param search IEvetypesearch
     * @param orderby sql order by string
     * @return ArrayList of Evetype
     * @throws DBException 
     */
    public ArrayList<Evetype> searchevetypes(IEvetypesearch search, String orderby) throws DBException {
        return (ArrayList<Evetype>)this.search(search, orderby);
    }

    /**
     * Search evetype in database for evetypePK:
     * @param evetypePK: Evetype Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getEvetypeExists(IEvetypePK evetypePK) throws DBException {
        return super.getEntityExists((EvetypePK)evetypePK);
    }

    /**
     * try to insert Evetype in database
     * @param evetype Evetype object
     * @throws DBException
     * @throws DataException
     */
    public void insertEvetype(IEvetype evetype) throws DBException, DataException {
        super.insertEntity(evetype);
    }

    /**
     * check if EvetypePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param evetype Evetype object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateEvetype(IEvetype evetype) throws DBException, DataException {
        if(this.getEvetypeExists(evetype.getPrimaryKey())) {
            super.updateEntity(evetype);
        } else {
            super.insertEntity(evetype);
        }
    }

    /**
     * try to update Evetype in database
     * @param evetype Evetype object
     * @throws DBException
     * @throws DataException
     */
    public void updateEvetype(IEvetype evetype) throws DBException, DataException {
        super.updateEntity(evetype);
    }

    /**
     * try to delete Evetype in database
     * @param evetype Evetype object
     * @throws DBException
     */
    public void deleteEvetype(IEvetype evetype) throws DBException {
        cascadedeleteEvetype(evetype.getPrimaryKey());
        super.deleteEntity(evetype);
    }

    /**
     * check data rules in Evetype, throw DataException with customized message if rules do not apply
     * @param evetype Evetype object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IEvetype evetype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(evetype.getName()!=null && evetype.getName().length()>IEvetype.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IEvetype.SIZE_NAME).append("\n");
        }
        if(evetype.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(evetype.getDescription()!=null && evetype.getDescription().length()>IEvetype.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IEvetype.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where evetypePK is used in a primary key
     * @param evetypePK: Evetype primary key
     */
    public void cascadedeleteEvetype(IEvetypePK evetypePK) {
        BLstock blstock = new BLstock(this);
        blstock.delete4evetype(evetypePK);
        BLorder_history blorder_history = new BLorder_history(this);
        blorder_history.delete4evetype(evetypePK);
        BLtradecombined bltradecombined = new BLtradecombined(this);
        bltradecombined.delete4evetype(evetypePK);
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @delete all Evetype Entity objects for Market_group in database
     */
    public void delete4market_group(IMarket_groupPK market_groupPK) {
        super.addStatement(EMevetype.SQLDelete4market_group, market_groupPK.getSQLprimarykey());
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @return all Evetype Entity objects for Market_group
     * @throws CustomException
     */
    public ArrayList<Evetype> getEvetypes4market_group(IMarket_groupPK market_groupPK) throws CustomException {
        return super.getEntities(EMevetype.SQLSelect4market_group, market_groupPK.getSQLprimarykey());
    }
    /**
     * @param typegroupPK: foreign key for Typegroup
     * @delete all Evetype Entity objects for Typegroup in database
     */
    public void delete4typegroup(ITypegroupPK typegroupPK) {
        super.addStatement(EMevetype.SQLDelete4typegroup, typegroupPK.getSQLprimarykey());
    }

    /**
     * @param typegroupPK: foreign key for Typegroup
     * @return all Evetype Entity objects for Typegroup
     * @throws CustomException
     */
    public ArrayList<Evetype> getEvetypes4typegroup(ITypegroupPK typegroupPK) throws CustomException {
        return super.getEntities(EMevetype.SQLSelect4typegroup, typegroupPK.getSQLprimarykey());
    }
    /**
     * @param graphicPK: foreign key for Graphic
     * @delete all Evetype Entity objects for Graphic in database
     */
    public void delete4graphic(IGraphicPK graphicPK) {
        super.addStatement(EMevetype.SQLDelete4graphic, graphicPK.getSQLprimarykey());
    }

    /**
     * @param graphicPK: foreign key for Graphic
     * @return all Evetype Entity objects for Graphic
     * @throws CustomException
     */
    public ArrayList<Evetype> getEvetypes4graphic(IGraphicPK graphicPK) throws CustomException {
        return super.getEntities(EMevetype.SQLSelect4graphic, graphicPK.getSQLprimarykey());
    }
    /**
     * @param stockPK: parent Stock for child object Evetype Entity
     * @return child Evetype Entity object
     * @throws CustomException
     */
    public Evetype getStock(IStockPK stockPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(stockPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    /**
     * @param order_historyPK: parent Order_history for child object Evetype Entity
     * @return child Evetype Entity object
     * @throws CustomException
     */
    public Evetype getOrder_history(IOrder_historyPK order_historyPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(order_historyPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    /**
     * @param tradecombinedPK: parent Tradecombined for child object Evetype Entity
     * @return child Evetype Entity object
     * @throws CustomException
     */
    public Evetype getTradecombined(ITradecombinedPK tradecombinedPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(tradecombinedPK.getEvetype());
        return this.getEvetype(evetypePK);
    }


    /**
     * get all Evetype objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Evetype objects
     * @throws DBException
     */
    public ArrayList<Evetype> getEvetypes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMevetype.SQLSelect);
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
        return (ArrayList<Evetype>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Evetype objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delEvetype(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Evetype.table);
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
