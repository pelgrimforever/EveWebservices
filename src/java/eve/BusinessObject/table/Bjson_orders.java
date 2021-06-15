/*
 * Bjson_orders.java
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
import eve.conversion.json.JSONJson_orders;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IJson_orderssearch;
import eve.logicentity.Json_orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bjson_orders
 *
 * Superclass for manipulating data- and database objects
 * for Entity Json_orders and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bjson_orders extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Json_orders as default Entity
     */
    public Bjson_orders() {
        super(new SQLMapper_pgsql(connectionpool, "Json_orders"), new Json_orders());
    }

    /**
     * Constructor, sets Json_orders as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bjson_orders(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Json_orders());
    }

    /**
     * Map ResultSet Field values to Json_orders
     * @param dbresult: Database ResultSet
     */
    public Json_orders mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Json_ordersPK json_ordersPK = null;
        Json_orders json_orders;
        if(dbresult==null) {
            json_orders = new Json_orders(json_ordersPK);
        } else {
            try {
                json_ordersPK = new Json_ordersPK(dbresult.getInt("id"));
                json_orders = new Json_orders(json_ordersPK);
                String o_json = dbresult.getString("json");
                if(o_json!=null) {
                    try {
                        Object json_o_a = (new JSONParser()).parse(o_json);
                        json_orders.initJson(piJson.parse(json_o_a));
                    }
                    catch(ParseException e) {
                    }                    
                }
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, json_orders);
        return json_orders;
    }

    /**
     * create new empty Json_orders object
     * @return empty IJson_orders
     */
    public IJson_orders newJson_orders() {
    	return new Json_orders();
    }
    
    /**
     * create new empty Json_orders object
     * create new primary key with given parameters
     * @return IJson_orders with primary key
     */
    public IJson_orders newJson_orders(int id) {
        return new Json_orders(id);
    }

    /**
     * create new empty Json_orders object with given primary key
     * @param json_ordersPK: primary key for Json_orders
     * @return IJson_orders with primary key
     */
    public IJson_orders newJson_orders(IJson_ordersPK json_ordersPK) {
        return new Json_orders((Json_ordersPK)json_ordersPK);
    }

    /**
     * create new empty primary key
     * @return empty Json_ordersPK
     */
    public IJson_ordersPK newJson_ordersPK() {
        return new Json_ordersPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IJson_ordersPK
     */
    public IJson_ordersPK newJson_ordersPK(int id) {
        return new Json_ordersPK(id);
    }

    /**
     * get all Json_orders objects from database
     * @return ArrayList of Json_orders objects
     * @throws DBException
     */
    public ArrayList getJson_orderss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Json_orders.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Json_orders for primary key
     * @param json_ordersPK: Json_orders primary key
     * @return Json_orders object
     * @throws DBException
     */
    public Json_orders getJson_orders(IJson_ordersPK json_ordersPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Json_orders)super.getEntity((Json_ordersPK)json_ordersPK);
        } else return null;
    }

    public ArrayList searchjson_orderss(IJson_orderssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchjson_orderss(IJson_orderssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search json_orders in database for json_ordersPK:
     * @param json_ordersPK: Json_orders Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getJson_ordersExists(IJson_ordersPK json_ordersPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Json_ordersPK)json_ordersPK);
        } else return false;
    }

    /**
     * try to insert Json_orders in database
     * @param film: Json_orders object
     * @throws DBException
     */
    public void insertJson_orders(IJson_orders json_orders) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(json_orders);
        }
    }

    /**
     * check if Json_ordersPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Json_orders object
     * @throws DBException
     */
    public void insertupdateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        if(this.getJson_ordersExists(json_orders.getPrimaryKey())) {
            super.updateEntity(json_orders);
        } else {
            super.insertEntity(json_orders);
        }
    }

    /**
     * try to update Json_orders in database
     * @param film: Json_orders object
     * @throws DBException
     */
    public void updateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(json_orders);
        }
    }

    /**
     * try to delete Json_orders in database
     * @param film: Json_orders object
     * @throws DBException
     */
    public void deleteJson_orders(IJson_orders json_orders) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteJson_orders(json_orders.getOwnerobject(), json_orders.getPrimaryKey());
            super.deleteEntity(json_orders);
        }
    }

    /**
     * check data rules in Json_orders, throw DataException with customized message if rules do not apply
     * @param film: Json_orders object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IJson_orders json_orders) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(json_orders.getJson()==null) {
            message.append("Json mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where json_ordersPK is used in a primary key
     * @param json_ordersPK: Json_orders primary key
     */
    public void cascadedeleteJson_orders(String senderobject, IJson_ordersPK json_ordersPK) {
    }


    /**
     * get all Json_orders objects for sqlparameters
     * @return ArrayList of Json_orders objects
     * @throws DBException
     */
    public ArrayList getJson_orderss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Json_orders.SQLSelect;
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
     * delete all Json_orders objects for sqlparameters
     * @throws DBException
     */
    public void delJson_orders(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Json_orders.table;
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
