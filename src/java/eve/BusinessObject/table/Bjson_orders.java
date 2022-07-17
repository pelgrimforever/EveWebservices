/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMjson_orders;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IJson_orderssearch;
import eve.logicentity.Json_orders;

/**
 * @author Franky Laseure
 */
public abstract class Bjson_orders extends TableBusinessrules {

    public Bjson_orders(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMjson_orders()));
    }

    public Bjson_orders(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMjson_orders()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IJson_orders newJson_orders() {
    	return new Json_orders();
    }
    
    public IJson_orders newJson_orders(int id) {
        return new Json_orders(id);
    }

    public IJson_orders newJson_orders(IJson_ordersPK json_ordersPK) {
        return new Json_orders((Json_ordersPK)json_ordersPK);
    }

    public IJson_ordersPK newJson_ordersPK() {
        return new Json_ordersPK();
    }

    public IJson_ordersPK newJson_ordersPK(int id) {
        return new Json_ordersPK(id);
    }

    public ArrayList<Json_orders> getJson_orderss() throws DBException {
        return (ArrayList<Json_orders>)tableio.getEntities(EMjson_orders.SQLSelectAll);
    }

    public Json_orders getJson_orders(IJson_ordersPK json_ordersPK) throws DBException {
        return (Json_orders)tableio.getEntity((Json_ordersPK)json_ordersPK);
    }

    public ArrayList<Json_orders> searchjson_orderss(IJson_orderssearch search) throws DBException {
        return (ArrayList<Json_orders>)tableio.search(search);
    }

    public ArrayList<Json_orders> searchjson_orderss(IJson_orderssearch search, String orderby) throws DBException {
        return (ArrayList<Json_orders>)tableio.search(search, orderby);
    }

    public boolean getJson_ordersExists(IJson_ordersPK json_ordersPK) throws DBException {
        return tableio.getEntityExists((Json_ordersPK)json_ordersPK);
    }

    public Json_orders getEntity(String sql) throws DBException {
        return (Json_orders)tableio.getEntity(sql);
    }
    
    public Json_orders getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Json_orders)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Json_orders> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Json_orders> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Json_orders> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Json_orders> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertJson_orders(SQLTqueue transactionqueue, IJson_orders json_orders) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, json_orders);
    }

    public void insertupdateJson_orders(SQLTqueue transactionqueue, IJson_orders json_orders) throws DBException, DataException {
    	checkDATA(json_orders);
        if(this.getJson_ordersExists(json_orders.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, json_orders);
        } else {
            tableio.insertEntity(transactionqueue, json_orders);
        }
    }

    public void updateJson_orders(SQLTqueue transactionqueue, IJson_orders json_orders) throws DBException, DataException {
    	checkDATA(json_orders);
        tableio.updateEntity(transactionqueue, json_orders);
    }

    public void deleteJson_orders(SQLTqueue transactionqueue, IJson_orders json_orders) throws DBException {
        cascadedeleteJson_orders(transactionqueue, json_orders.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, json_orders);
    }

    private void checkDATA(IJson_orders json_orders) throws DataException, DBException {
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
    public void cascadedeleteJson_orders(SQLTqueue transactionqueue, IJson_ordersPK json_ordersPK) {
    }


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
        return (ArrayList<Json_orders>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delJson_orders(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
