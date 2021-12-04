/*
 * Bjson_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
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
import eve.conversion.json.JSONJson_orders;
import eve.conversion.entity.EMjson_orders;
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
public abstract class Bjson_orders extends BLtable {

    /**
     * Constructor, sets Json_orders as default Entity
     */
    public Bjson_orders() {
        super(new Json_orders(), new EMjson_orders());
    }

    /**
     * Constructor, sets Json_orders as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bjson_orders(BLtable transactionobject) {
        super(transactionobject, new Json_orders(), new EMjson_orders());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Json_orders> getJson_orderss() throws DBException {
        return (ArrayList<Json_orders>)super.getEntities(EMjson_orders.SQLSelectAll);
    }

    /**
     * search Json_orders for primary key
     * @param json_ordersPK: Json_orders primary key
     * @return Json_orders object
     * @throws DBException
     */
    public Json_orders getJson_orders(IJson_ordersPK json_ordersPK) throws DBException {
        return (Json_orders)super.getEntity((Json_ordersPK)json_ordersPK);
    }

    /**
     * search json_orders with IJson_orderssearch parameters
     * @param search IJson_orderssearch
     * @return ArrayList of Json_orders
     * @throws DBException 
     */
    public ArrayList<Json_orders> searchjson_orderss(IJson_orderssearch search) throws DBException {
        return (ArrayList<Json_orders>)this.search(search);
    }

    /**
     * search json_orders with IJson_orderssearch parameters, order by orderby sql clause
     * @param search IJson_orderssearch
     * @param orderby sql order by string
     * @return ArrayList of Json_orders
     * @throws DBException 
     */
    public ArrayList<Json_orders> searchjson_orderss(IJson_orderssearch search, String orderby) throws DBException {
        return (ArrayList<Json_orders>)this.search(search, orderby);
    }

    /**
     * Search json_orders in database for json_ordersPK:
     * @param json_ordersPK: Json_orders Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getJson_ordersExists(IJson_ordersPK json_ordersPK) throws DBException {
        return super.getEntityExists((Json_ordersPK)json_ordersPK);
    }

    /**
     * try to insert Json_orders in database
     * @param json_orders Json_orders object
     * @throws DBException
     * @throws DataException
     */
    public void insertJson_orders(IJson_orders json_orders) throws DBException, DataException {
        super.insertEntity(json_orders);
    }

    /**
     * check if Json_ordersPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param json_orders Json_orders object
     * @throws DBException
     * @throws DataException
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
     * @param json_orders Json_orders object
     * @throws DBException
     * @throws DataException
     */
    public void updateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        super.updateEntity(json_orders);
    }

    /**
     * try to delete Json_orders in database
     * @param json_orders Json_orders object
     * @throws DBException
     */
    public void deleteJson_orders(IJson_orders json_orders) throws DBException {
        cascadedeleteJson_orders(json_orders.getPrimaryKey());
        super.deleteEntity(json_orders);
    }

    /**
     * check data rules in Json_orders, throw DataException with customized message if rules do not apply
     * @param json_orders Json_orders object
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
    public void cascadedeleteJson_orders(IJson_ordersPK json_ordersPK) {
    }


    /**
     * get all Json_orders objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Json_orders objects
     * @throws DBException
     */
    public ArrayList<Json_orders> getJson_orderss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMjson_orders.SQLSelect);
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
        return (ArrayList<Json_orders>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Json_orders objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delJson_orders(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Json_orders.table);
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
