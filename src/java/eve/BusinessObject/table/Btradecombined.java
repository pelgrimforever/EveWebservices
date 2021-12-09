/*
 * Btradecombined.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
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
import eve.conversion.json.JSONTradecombined;
import eve.conversion.entity.EMtradecombined;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITradecombinedsearch;
import eve.logicentity.Tradecombined;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Btradecombined
 *
 * Superclass for manipulating data- and database objects
 * for Entity Tradecombined and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Btradecombined extends BLtable {

    /**
     * Constructor, sets Tradecombined as default Entity
     */
    public Btradecombined() {
        super(new Tradecombined(), new EMtradecombined());
    }

    /**
     * Constructor, sets Tradecombined as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btradecombined(BLtable transactionobject) {
        super(transactionobject, new Tradecombined(), new EMtradecombined());
    }

    /**
     * create new empty Tradecombined object
     * @return empty ITradecombined
     */
    public ITradecombined newTradecombined() {
    	return new Tradecombined();
    }
    
    /**
     * create new empty Tradecombined object
     * create new primary key with given parameters
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @param evetype primary key field
     * @return ITradecombined with primary key
     */
    public ITradecombined newTradecombined(long sell_system, long buy_system, long evetype) {
        return new Tradecombined(sell_system, buy_system, evetype);
    }

    /**
     * create new empty Tradecombined object with given primary key
     * @param tradecombinedPK: primary key for Tradecombined
     * @return ITradecombined with primary key
     */
    public ITradecombined newTradecombined(ITradecombinedPK tradecombinedPK) {
        return new Tradecombined((TradecombinedPK)tradecombinedPK);
    }

    /**
     * create new empty primary key
     * @return empty TradecombinedPK
     */
    public ITradecombinedPK newTradecombinedPK() {
        return new TradecombinedPK();
    }

    /**
     * create new primary key with given parameters
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @param evetype primary key field
     * @return new ITradecombinedPK
     */
    public ITradecombinedPK newTradecombinedPK(long sell_system, long buy_system, long evetype) {
        return new TradecombinedPK(sell_system, buy_system, evetype);
    }

    /**
     * get all Tradecombined objects from database
     * @return ArrayList of Tradecombined objects
     * @throws DBException
     */
    public ArrayList<Tradecombined> getTradecombineds() throws DBException {
        return (ArrayList<Tradecombined>)super.getEntities(EMtradecombined.SQLSelectAll);
    }

    /**
     * search Tradecombined for primary key
     * @param tradecombinedPK: Tradecombined primary key
     * @return Tradecombined object
     * @throws DBException
     */
    public Tradecombined getTradecombined(ITradecombinedPK tradecombinedPK) throws DBException {
        return (Tradecombined)super.getEntity((TradecombinedPK)tradecombinedPK);
    }

    /**
     * search tradecombined with ITradecombinedsearch parameters
     * @param search ITradecombinedsearch
     * @return ArrayList of Tradecombined
     * @throws DBException 
     */
    public ArrayList<Tradecombined> searchtradecombineds(ITradecombinedsearch search) throws DBException {
        return (ArrayList<Tradecombined>)this.search(search);
    }

    /**
     * search tradecombined with ITradecombinedsearch parameters, order by orderby sql clause
     * @param search ITradecombinedsearch
     * @param orderby sql order by string
     * @return ArrayList of Tradecombined
     * @throws DBException 
     */
    public ArrayList<Tradecombined> searchtradecombineds(ITradecombinedsearch search, String orderby) throws DBException {
        return (ArrayList<Tradecombined>)this.search(search, orderby);
    }

    /**
     * Search tradecombined in database for tradecombinedPK:
     * @param tradecombinedPK: Tradecombined Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTradecombinedExists(ITradecombinedPK tradecombinedPK) throws DBException {
        return super.getEntityExists((TradecombinedPK)tradecombinedPK);
    }

    /**
     * try to insert Tradecombined in database
     * @param tradecombined Tradecombined object
     * @throws DBException
     * @throws DataException
     */
    public void insertTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        super.insertEntity(tradecombined);
    }

    /**
     * check if TradecombinedPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param tradecombined Tradecombined object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        if(this.getTradecombinedExists(tradecombined.getPrimaryKey())) {
            super.updateEntity(tradecombined);
        } else {
            super.insertEntity(tradecombined);
        }
    }

    /**
     * try to update Tradecombined in database
     * @param tradecombined Tradecombined object
     * @throws DBException
     * @throws DataException
     */
    public void updateTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        super.updateEntity(tradecombined);
    }

    /**
     * try to delete Tradecombined in database
     * @param tradecombined Tradecombined object
     * @throws DBException
     */
    public void deleteTradecombined(ITradecombined tradecombined) throws DBException {
        cascadedeleteTradecombined(tradecombined.getPrimaryKey());
        super.deleteEntity(tradecombined);
    }

    /**
     * check data rules in Tradecombined, throw DataException with customized message if rules do not apply
     * @param tradecombined Tradecombined object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITradecombined tradecombined) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Tradecombined.Sell_system - System.Id
        //foreign key Tradecombined.Buy_system - System.Id
        //foreign key Tradecombined.Evetype - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where tradecombinedPK is used in a primary key
     * @param tradecombinedPK: Tradecombined primary key
     */
    public void cascadedeleteTradecombined(ITradecombinedPK tradecombinedPK) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell(this);
        bltradecombined_sell.delete4tradecombined(tradecombinedPK);
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Tradecombined Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMtradecombined.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Tradecombined Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Tradecombined> getTradecombineds4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMtradecombined.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Tradecombined Entity objects for System in database
     */
    public void delete4systemBuy_system(ISystemPK systemPK) {
        super.addStatement(EMtradecombined.SQLDelete4systemBuy_system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Tradecombined Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Tradecombined> getTradecombineds4systemBuy_system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMtradecombined.SQLSelect4systemBuy_system, systemPK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Tradecombined Entity objects for System in database
     */
    public void delete4systemSell_system(ISystemPK systemPK) {
        super.addStatement(EMtradecombined.SQLDelete4systemSell_system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Tradecombined Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Tradecombined> getTradecombineds4systemSell_system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMtradecombined.SQLSelect4systemSell_system, systemPK.getSQLprimarykey());
    }
    /**
     * @param tradecombined_sellPK: parent Tradecombined_sell for child object Tradecombined Entity
     * @return child Tradecombined Entity object
     * @throws CustomException
     */
    public Tradecombined getTradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) throws CustomException {
        TradecombinedPK tradecombinedPK = new TradecombinedPK(tradecombined_sellPK.getSell_system(), tradecombined_sellPK.getBuy_system(), tradecombined_sellPK.getEvetype());
        return this.getTradecombined(tradecombinedPK);
    }


    /**
     * get all Tradecombined objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Tradecombined objects
     * @throws DBException
     */
    public ArrayList<Tradecombined> getTradecombineds(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtradecombined.SQLSelect);
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
        return (ArrayList<Tradecombined>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Tradecombined objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delTradecombined(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Tradecombined.table);
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
