/*
 * Bsystemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2021 13:57
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONSystemtrade;
import eve.data.ProjectConstants;
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
public abstract class Bsystemtrade extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Systemtrade as default Entity
     */
    public Bsystemtrade() {
        super(new SQLMapper_pgsql(connectionpool, "Systemtrade"), new Systemtrade());
    }

    /**
     * Constructor, sets Systemtrade as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystemtrade(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Systemtrade());
    }

    /**
     * Map ResultSet Field values to Systemtrade
     * @param dbresult: Database ResultSet
     */
    public Systemtrade mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SystemtradePK systemtradePK = null;
        Systemtrade systemtrade;
        if(dbresult==null) {
            systemtrade = new Systemtrade(systemtradePK);
        } else {
            try {
                systemtradePK = new SystemtradePK(dbresult.getLong("sell_system"), dbresult.getLong("buy_system"));
                systemtrade = new Systemtrade(systemtradePK);
                systemtrade.initProfit(dbresult.getDouble("profit"));
                systemtrade.initTotal_cargo_volume(dbresult.getDouble("total_cargo_volume"));
                systemtrade.initJumps(dbresult.getInt("jumps"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, systemtrade);
        return systemtrade;
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
    public ArrayList getSystemtrades() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemtrade.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Systemtrade for primary key
     * @param systemtradePK: Systemtrade primary key
     * @return Systemtrade object
     * @throws DBException
     */
    public Systemtrade getSystemtrade(ISystemtradePK systemtradePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Systemtrade)super.getEntity((SystemtradePK)systemtradePK);
        } else return null;
    }

    public ArrayList searchsystemtrades(ISystemtradesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsystemtrades(ISystemtradesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search systemtrade in database for systemtradePK:
     * @param systemtradePK: Systemtrade Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemtradeExists(ISystemtradePK systemtradePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SystemtradePK)systemtradePK);
        } else return false;
    }

    /**
     * try to insert Systemtrade in database
     * @param film: Systemtrade object
     * @throws DBException
     */
    public void insertSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(systemtrade);
        }
    }

    /**
     * check if SystemtradePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Systemtrade object
     * @throws DBException
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
     * @param film: Systemtrade object
     * @throws DBException
     */
    public void updateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(systemtrade);
        }
    }

    /**
     * try to delete Systemtrade in database
     * @param film: Systemtrade object
     * @throws DBException
     */
    public void deleteSystemtrade(ISystemtrade systemtrade) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSystemtrade(systemtrade.getOwnerobject(), systemtrade.getPrimaryKey());
            super.deleteEntity(systemtrade);
        }
    }

    /**
     * check data rules in Systemtrade, throw DataException with customized message if rules do not apply
     * @param film: Systemtrade object
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
    public void cascadedeleteSystemtrade(String senderobject, ISystemtradePK systemtradePK) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order(this);
        blsystemtrade_order.delete4systemtrade(senderobject, systemtradePK);
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Systemtrade Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4systemSell_system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Systemtrade.SQLDelete4systemSell_system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemtrade Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystemtrades4systemSell_system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemtrade.SQLSelect4systemSell_system, systemPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Systemtrade Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4systemBuy_system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Systemtrade.SQLDelete4systemBuy_system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemtrade Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystemtrades4systemBuy_system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemtrade.SQLSelect4systemBuy_system, systemPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemtrade_orderPK: parent Systemtrade_order for child object Systemtrade Entity
     * @return child Systemtrade Entity object
     * @throws eve.general.exception.CustomException
     */
    public ISystemtrade getSystemtrade_order(ISystemtrade_orderPK systemtrade_orderPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SystemtradePK systemtradePK = new SystemtradePK(systemtrade_orderPK.getSell_system(), systemtrade_orderPK.getBuy_system());
            return this.getSystemtrade(systemtradePK);
        } else return null;
    }


    /**
     * get all Systemtrade objects for sqlparameters
     * @return ArrayList of Systemtrade objects
     * @throws DBException
     */
    public ArrayList getSystemtrades(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Systemtrade.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Systemtrade objects for sqlparameters
     * @throws DBException
     */
    public void delSystemtrade(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Systemtrade.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
