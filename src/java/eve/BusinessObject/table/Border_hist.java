/*
 * Border_hist.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.5.2021 13:35
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
import eve.conversion.json.JSONOrder_hist;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrder_histsearch;
import eve.logicentity.Order_hist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Border_hist
 *
 * Superclass for manipulating data- and database objects
 * for Entity Order_hist and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Border_hist extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Order_hist as default Entity
     */
    public Border_hist() {
        super(new SQLMapper_pgsql(connectionpool, "Order_hist"), new Order_hist());
    }

    /**
     * Constructor, sets Order_hist as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Border_hist(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Order_hist());
    }

    /**
     * Map ResultSet Field values to Order_hist
     * @param dbresult: Database ResultSet
     */
    public Order_hist mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_histPK order_histPK = null;
        Order_hist order_hist;
        if(dbresult==null) {
            order_hist = new Order_hist(order_histPK);
        } else {
            try {
                order_histPK = new Order_histPK(dbresult.getLong("id"));
                order_hist = new Order_hist(order_histPK);
                order_hist.initEvetypePK(new EvetypePK(dbresult.getLong("evetype")));
                if(dbresult.wasNull()) order_hist.setEvetypePK(null);                
                order_hist.initSystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) order_hist.setSystemPK(null);                
                order_hist.initIsopen(dbresult.getBoolean("isopen"));
                order_hist.initVolume_total(dbresult.getInt("volume_total"));
                order_hist.initVolume_remain(dbresult.getInt("volume_remain"));
                order_hist.initRange(dbresult.getString("range"));
                order_hist.initRange_number(dbresult.getInt("range_number"));
                order_hist.initPrice(dbresult.getDouble("price"));
                order_hist.initMin_volume(dbresult.getInt("min_volume"));
                order_hist.initLocation(dbresult.getLong("location"));
                order_hist.initIs_buy_order(dbresult.getBoolean("is_buy_order"));
                order_hist.initIssued(dbresult.getTimestamp("issued"));
                order_hist.initDuration(dbresult.getInt("duration"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, order_hist);
        return order_hist;
    }

    /**
     * create new empty Order_hist object
     * @return empty IOrder_hist
     */
    public IOrder_hist newOrder_hist() {
    	return new Order_hist();
    }
    
    /**
     * create new empty Order_hist object
     * create new primary key with given parameters
     * @return IOrder_hist with primary key
     */
    public IOrder_hist newOrder_hist(long id) {
        return new Order_hist(id);
    }

    /**
     * create new empty Order_hist object with given primary key
     * @param order_histPK: primary key for Order_hist
     * @return IOrder_hist with primary key
     */
    public IOrder_hist newOrder_hist(IOrder_histPK order_histPK) {
        return new Order_hist((Order_histPK)order_histPK);
    }

    /**
     * create new empty primary key
     * @return empty Order_histPK
     */
    public IOrder_histPK newOrder_histPK() {
        return new Order_histPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IOrder_histPK
     */
    public IOrder_histPK newOrder_histPK(long id) {
        return new Order_histPK(id);
    }

    /**
     * get all Order_hist objects from database
     * @return ArrayList of Order_hist objects
     * @throws DBException
     */
    public ArrayList getOrder_hists() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Order_hist.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Order_hist for primary key
     * @param order_histPK: Order_hist primary key
     * @return Order_hist object
     * @throws DBException
     */
    public Order_hist getOrder_hist(IOrder_histPK order_histPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Order_hist)super.getEntity((Order_histPK)order_histPK);
        } else return null;
    }

    public ArrayList searchorder_hists(IOrder_histsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchorder_hists(IOrder_histsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search order_hist in database for order_histPK:
     * @param order_histPK: Order_hist Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getOrder_histExists(IOrder_histPK order_histPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Order_histPK)order_histPK);
        } else return false;
    }

    /**
     * try to insert Order_hist in database
     * @param film: Order_hist object
     * @throws DBException
     */
    public void insertOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(order_hist);
        }
    }

    /**
     * check if Order_histPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Order_hist object
     * @throws DBException
     */
    public void insertupdateOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        if(this.getOrder_histExists(order_hist.getPrimaryKey())) {
            super.updateEntity(order_hist);
        } else {
            super.insertEntity(order_hist);
        }
    }

    /**
     * try to update Order_hist in database
     * @param film: Order_hist object
     * @throws DBException
     */
    public void updateOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(order_hist);
        }
    }

    /**
     * try to delete Order_hist in database
     * @param film: Order_hist object
     * @throws DBException
     */
    public void deleteOrder_hist(IOrder_hist order_hist) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteOrder_hist(order_hist.getOwnerobject(), order_hist.getPrimaryKey());
            super.deleteEntity(order_hist);
        }
    }

    /**
     * check data rules in Order_hist, throw DataException with customized message if rules do not apply
     * @param film: Order_hist object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IOrder_hist order_hist) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key


        if(order_hist.getRange()!=null && order_hist.getRange().length()>IOrder_hist.SIZE_RANGE) {
            message.append("Range is langer dan toegestaan. Max aantal karakters: " + IOrder_hist.SIZE_RANGE + "\n");
        }
        if(order_hist.getRange()==null) {
            message.append("Range mag niet leeg zijn.\n");
        }
        if(order_hist.getIssued()==null) {
            message.append("Issued mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where order_histPK is used in a primary key
     * @param order_histPK: Order_hist primary key
     */
    public void cascadedeleteOrder_hist(String senderobject, IOrder_histPK order_histPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Order_hist Entity objects for Evetype in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4evetype(String senderobject, IEvetypePK evetypePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Order_hist.SQLDelete4evetype, evetypePK.getKeyFields());
        }
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Order_hist Entity objects for Evetype
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getOrder_hists4evetype(IEvetypePK evetypePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Order_hist.SQLSelect4evetype, evetypePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Order_hist Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Order_hist.SQLDelete4system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Order_hist Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getOrder_hists4system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Order_hist.SQLSelect4system, systemPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Order_hist objects for sqlparameters
     * @return ArrayList of Order_hist objects
     * @throws DBException
     */
    public ArrayList getOrder_hists(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Order_hist.SQLSelect;
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
     * delete all Order_hist objects for sqlparameters
     * @throws DBException
     */
    public void delOrder_hist(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Order_hist.table;
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
