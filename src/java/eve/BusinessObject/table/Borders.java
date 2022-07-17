/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMorders;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrderssearch;
import eve.logicentity.Orders;

/**
 * @author Franky Laseure
 */
public abstract class Borders extends TableBusinessrules {

    public Borders(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMorders()));
    }

    public Borders(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMorders()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IOrders newOrders() {
    	return new Orders();
    }
    
    public IOrders newOrders(long id) {
        return new Orders(id);
    }

    public IOrders newOrders(IOrdersPK ordersPK) {
        return new Orders((OrdersPK)ordersPK);
    }

    public IOrdersPK newOrdersPK() {
        return new OrdersPK();
    }

    public IOrdersPK newOrdersPK(long id) {
        return new OrdersPK(id);
    }

    public ArrayList<Orders> getOrderss() throws DBException {
        return (ArrayList<Orders>)tableio.getEntities(EMorders.SQLSelectAll);
    }

    public Orders getOrders(IOrdersPK ordersPK) throws DBException {
        return (Orders)tableio.getEntity((OrdersPK)ordersPK);
    }

    public ArrayList<Orders> searchorderss(IOrderssearch search) throws DBException {
        return (ArrayList<Orders>)tableio.search(search);
    }

    public ArrayList<Orders> searchorderss(IOrderssearch search, String orderby) throws DBException {
        return (ArrayList<Orders>)tableio.search(search, orderby);
    }

    public boolean getOrdersExists(IOrdersPK ordersPK) throws DBException {
        return tableio.getEntityExists((OrdersPK)ordersPK);
    }

    public Orders getEntity(String sql) throws DBException {
        return (Orders)tableio.getEntity(sql);
    }
    
    public Orders getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Orders)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Orders> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Orders> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Orders> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Orders> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertOrders(SQLTqueue transactionqueue, IOrders orders) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, orders);
    }

    public void insertupdateOrders(SQLTqueue transactionqueue, IOrders orders) throws DBException, DataException {
    	checkDATA(orders);
        if(this.getOrdersExists(orders.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, orders);
        } else {
            tableio.insertEntity(transactionqueue, orders);
        }
    }

    public void updateOrders(SQLTqueue transactionqueue, IOrders orders) throws DBException, DataException {
    	checkDATA(orders);
        tableio.updateEntity(transactionqueue, orders);
    }

    public void deleteOrders(SQLTqueue transactionqueue, IOrders orders) throws DBException {
        cascadedeleteOrders(transactionqueue, orders.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, orders);
    }

    private void checkDATA(IOrders orders) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(orders.getRange()!=null && orders.getRange().length()>IOrders.SIZE_RANGE) {
            message.append("Range is langer dan toegestaan. Max aantal karakters: ").append(IOrders.SIZE_RANGE).append("\n");
        }
        if(orders.getRange()==null) {
            message.append("Range mag niet leeg zijn.\n");
        }
        if(orders.getIssued()==null) {
            message.append("Issued mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where ordersPK is used in a primary key
     * @param ordersPK: Orders primary key
     */
    public void cascadedeleteOrders(SQLTqueue transactionqueue, IOrdersPK ordersPK) {
        BLtradecombined_sell bltradecombined_sellBuy_order_id = new BLtradecombined_sell(this);
        bltradecombined_sellBuy_order_id.setAuthenticated(isAuthenticated());
        bltradecombined_sellBuy_order_id.delete4ordersBuy_order_id(transactionqueue, ordersPK);
        BLtradecombined_sell bltradecombined_sellSell_order_id = new BLtradecombined_sell(this);
        bltradecombined_sellSell_order_id.setAuthenticated(isAuthenticated());
        bltradecombined_sellSell_order_id.delete4ordersSell_order_id(transactionqueue, ordersPK);
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected(this);
        blshipfitorderselected.setAuthenticated(isAuthenticated());
        blshipfitorderselected.delete4orders(transactionqueue, ordersPK);
        BLtrade bltradeSell_order_id = new BLtrade(this);
        bltradeSell_order_id.setAuthenticated(isAuthenticated());
        bltradeSell_order_id.delete4ordersSell_order_id(transactionqueue, ordersPK);
        BLtrade bltradeBuy_order_id = new BLtrade(this);
        bltradeBuy_order_id.setAuthenticated(isAuthenticated());
        bltradeBuy_order_id.delete4ordersBuy_order_id(transactionqueue, ordersPK);
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMorders.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Orders> getOrderss4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMorders.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public void delete4system(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMorders.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Orders> getOrderss4system(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMorders.SQLSelect4system, systemPK.getSQLprimarykey());
    }
    public Orders getTradecombined_sellbuy_order_id(ITradecombined_sellPK tradecombined_sellPK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradecombined_sellPK.getBuy_order_id());
        return this.getOrders(ordersPK);
    }

    public Orders getTradecombined_sellsell_order_id(ITradecombined_sellPK tradecombined_sellPK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradecombined_sellPK.getSell_order_id());
        return this.getOrders(ordersPK);
    }

    public Orders getShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(shipfitorderselectedPK.getOrderid());
        return this.getOrders(ordersPK);
    }

    public Orders getTradesell_order_id(ITradePK tradePK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradePK.getSell_order_id());
        return this.getOrders(ordersPK);
    }

    public Orders getTradebuy_order_id(ITradePK tradePK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradePK.getBuy_order_id());
        return this.getOrders(ordersPK);
    }


    public ArrayList<Orders> getOrderss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMorders.SQLSelect);
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
        return (ArrayList<Orders>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delOrders(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Orders.table);
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
