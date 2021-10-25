/*
 * Bsystemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
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
import eve.conversion.json.JSONSystemtrade;
import eve.conversion.entity.EMsystemtrade;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISystemtradesearch;
import eve.logicentity.Systemtrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsystemtrade
 *
 * Superclass for manipulating data- and database objects
 * for Entity Systemtrade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsystemtrade extends BLtable {

    /**
     * Constructor, sets Systemtrade as default Entity
     */
    public Bsystemtrade() {
        super(new Systemtrade(), new EMsystemtrade());
    }

    /**
     * Constructor, sets Systemtrade as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystemtrade(BLtable transactionobject) {
        super(transactionobject, new Systemtrade(), new EMsystemtrade());
    }

    /**
     * create new empty Systemtrade object
     * @return empty ISystemtrade
     */
    public ISystemtrade newSystemtrade() {
    	return new Systemtrade();
    }
    
    /**
     * create new empty Systemtrade object
     * create new primary key with given parameters
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @return ISystemtrade with primary key
     */
    public ISystemtrade newSystemtrade(long sell_system, long buy_system) {
        return new Systemtrade(sell_system, buy_system);
    }

    /**
     * create new empty Systemtrade object with given primary key
     * @param systemtradePK: primary key for Systemtrade
     * @return ISystemtrade with primary key
     */
    public ISystemtrade newSystemtrade(ISystemtradePK systemtradePK) {
        return new Systemtrade((SystemtradePK)systemtradePK);
    }

    /**
     * create new empty primary key
     * @return empty SystemtradePK
     */
    public ISystemtradePK newSystemtradePK() {
        return new SystemtradePK();
    }

    /**
     * create new primary key with given parameters
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @return new ISystemtradePK
     */
    public ISystemtradePK newSystemtradePK(long sell_system, long buy_system) {
        return new SystemtradePK(sell_system, buy_system);
    }

    /**
     * get all Systemtrade objects from database
     * @return ArrayList of Systemtrade objects
     * @throws DBException
     */
    public ArrayList<Systemtrade> getSystemtrades() throws DBException {
        return (ArrayList<Systemtrade>)super.getEntities(EMsystemtrade.SQLSelectAll);
    }

    /**
     * search Systemtrade for primary key
     * @param systemtradePK: Systemtrade primary key
     * @return Systemtrade object
     * @throws DBException
     */
    public Systemtrade getSystemtrade(ISystemtradePK systemtradePK) throws DBException {
        return (Systemtrade)super.getEntity((SystemtradePK)systemtradePK);
    }

    /**
     * search systemtrade with ISystemtradesearch parameters
     * @param search ISystemtradesearch
     * @return ArrayList of Systemtrade
     * @throws DBException 
     */
    public ArrayList<Systemtrade> searchsystemtrades(ISystemtradesearch search) throws DBException {
        return (ArrayList<Systemtrade>)this.search(search);
    }

    /**
     * search systemtrade with ISystemtradesearch parameters, order by orderby sql clause
     * @param search ISystemtradesearch
     * @param orderby sql order by string
     * @return ArrayList of Systemtrade
     * @throws DBException 
     */
    public ArrayList<Systemtrade> searchsystemtrades(ISystemtradesearch search, String orderby) throws DBException {
        return (ArrayList<Systemtrade>)this.search(search, orderby);
    }

    /**
     * Search systemtrade in database for systemtradePK:
     * @param systemtradePK: Systemtrade Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemtradeExists(ISystemtradePK systemtradePK) throws DBException {
        return super.getEntityExists((SystemtradePK)systemtradePK);
    }

    /**
     * try to insert Systemtrade in database
     * @param systemtrade Systemtrade object
     * @throws DBException
     * @throws DataException
     */
    public void insertSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        super.insertEntity(systemtrade);
    }

    /**
     * check if SystemtradePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param systemtrade Systemtrade object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        if(this.getSystemtradeExists(systemtrade.getPrimaryKey())) {
            super.updateEntity(systemtrade);
        } else {
            super.insertEntity(systemtrade);
        }
    }

    /**
     * try to update Systemtrade in database
     * @param systemtrade Systemtrade object
     * @throws DBException
     * @throws DataException
     */
    public void updateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        super.updateEntity(systemtrade);
    }

    /**
     * try to delete Systemtrade in database
     * @param systemtrade Systemtrade object
     * @throws DBException
     */
    public void deleteSystemtrade(ISystemtrade systemtrade) throws DBException {
        cascadedeleteSystemtrade(systemtrade.getPrimaryKey());
        super.deleteEntity(systemtrade);
    }

    /**
     * check data rules in Systemtrade, throw DataException with customized message if rules do not apply
     * @param systemtrade Systemtrade object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISystemtrade systemtrade) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Systemtrade.Sell_system - System.Id
        //foreign key Systemtrade.Buy_system - System.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where systemtradePK is used in a primary key
     * @param systemtradePK: Systemtrade primary key
     */
    public void cascadedeleteSystemtrade(ISystemtradePK systemtradePK) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order(this);
        blsystemtrade_order.delete4systemtrade(systemtradePK);
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Systemtrade Entity objects for System in database
     */
    public void delete4systemSell_system(ISystemPK systemPK) {
        super.addStatement(EMsystemtrade.SQLDelete4systemSell_system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemtrade Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Systemtrade> getSystemtrades4systemSell_system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMsystemtrade.SQLSelect4systemSell_system, systemPK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Systemtrade Entity objects for System in database
     */
    public void delete4systemBuy_system(ISystemPK systemPK) {
        super.addStatement(EMsystemtrade.SQLDelete4systemBuy_system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemtrade Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Systemtrade> getSystemtrades4systemBuy_system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMsystemtrade.SQLSelect4systemBuy_system, systemPK.getSQLprimarykey());
    }
    /**
     * @param systemtrade_orderPK: parent Systemtrade_order for child object Systemtrade Entity
     * @return child Systemtrade Entity object
     * @throws CustomException
     */
    public Systemtrade getSystemtrade_order(ISystemtrade_orderPK systemtrade_orderPK) throws CustomException {
        SystemtradePK systemtradePK = new SystemtradePK(systemtrade_orderPK.getBuy_system(), systemtrade_orderPK.getSell_system());
        return this.getSystemtrade(systemtradePK);
    }


    /**
     * get all Systemtrade objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Systemtrade objects
     * @throws DBException
     */
    public ArrayList<Systemtrade> getSystemtrades(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsystemtrade.SQLSelect);
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
        return (ArrayList<Systemtrade>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Systemtrade objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSystemtrade(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Systemtrade.table);
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
