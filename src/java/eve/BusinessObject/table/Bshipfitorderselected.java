/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMshipfitorderselected;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.logicentity.Shipfitorderselected;

public abstract class Bshipfitorderselected extends TableBusinessrules {

    public Bshipfitorderselected(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMshipfitorderselected()));
    }

    public Bshipfitorderselected(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMshipfitorderselected()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IShipfitorderselected newShipfitorderselected() {
    	return new Shipfitorderselected();
    }
    
    public IShipfitorderselected newShipfitorderselected(java.lang.String username, java.lang.String shipname, long evetype, long orderid) {
        return new Shipfitorderselected(username, shipname, evetype, orderid);
    }

    public IShipfitorderselected newShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) {
        return new Shipfitorderselected((ShipfitorderselectedPK)shipfitorderselectedPK);
    }

    public IShipfitorderselectedPK newShipfitorderselectedPK() {
        return new ShipfitorderselectedPK();
    }

    public IShipfitorderselectedPK newShipfitorderselectedPK(java.lang.String username, java.lang.String shipname, long evetype, long orderid) {
        return new ShipfitorderselectedPK(username, shipname, evetype, orderid);
    }

    public ArrayList<Shipfitorderselected> getShipfitorderselecteds() throws DBException {
        return (ArrayList<Shipfitorderselected>)tableio.getEntities(EMshipfitorderselected.SQLSelectAll);
    }

    public Shipfitorderselected getShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws DBException {
        return (Shipfitorderselected)tableio.getEntity((ShipfitorderselectedPK)shipfitorderselectedPK);
    }

    public ArrayList<Shipfitorderselected> searchshipfitorderselecteds(IShipfitorderselectedsearch search) throws DBException {
        return (ArrayList<Shipfitorderselected>)tableio.search(search);
    }

    public ArrayList<Shipfitorderselected> searchshipfitorderselecteds(IShipfitorderselectedsearch search, String orderby) throws DBException {
        return (ArrayList<Shipfitorderselected>)tableio.search(search, orderby);
    }

    public boolean getShipfitorderselectedExists(IShipfitorderselectedPK shipfitorderselectedPK) throws DBException {
        return tableio.getEntityExists((ShipfitorderselectedPK)shipfitorderselectedPK);
    }

    public Shipfitorderselected getEntity(String sql) throws DBException {
        return (Shipfitorderselected)tableio.getEntity(sql);
    }
    
    public Shipfitorderselected getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Shipfitorderselected)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Shipfitorderselected> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Shipfitorderselected> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Shipfitorderselected> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Shipfitorderselected> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertShipfitorderselected(SQLTqueue transactionqueue, IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, shipfitorderselected);
    }

    public void insertupdateShipfitorderselected(SQLTqueue transactionqueue, IShipfitorderselected shipfitorderselected) throws DBException, DataException {
    	checkDATA(shipfitorderselected);
        if(this.getShipfitorderselectedExists(shipfitorderselected.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, shipfitorderselected);
        } else {
            tableio.insertEntity(transactionqueue, shipfitorderselected);
        }
    }

    public void updateShipfitorderselected(SQLTqueue transactionqueue, IShipfitorderselected shipfitorderselected) throws DBException, DataException {
    	checkDATA(shipfitorderselected);
        tableio.updateEntity(transactionqueue, shipfitorderselected);
    }

    public void deleteShipfitorderselected(SQLTqueue transactionqueue, IShipfitorderselected shipfitorderselected) throws DBException {
        cascadedeleteShipfitorderselected(transactionqueue, shipfitorderselected.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, shipfitorderselected);
    }

    private void checkDATA(IShipfitorderselected shipfitorderselected) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Shipfitorderselected.Username - Shipfitorder.Username
        //foreign key Shipfitorderselected.Shipname - Shipfitorder.Shipname
        //foreign key Shipfitorderselected.Evetype - Shipfitorder.Evetype
        //foreign key Shipfitorderselected.Orderid - Orders.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteShipfitorderselected(SQLTqueue transactionqueue, IShipfitorderselectedPK shipfitorderselectedPK) {
    }

    public void delete4orders(SQLTqueue transactionqueue, IOrdersPK ordersPK) {
        tableio.addStatement(transactionqueue, EMshipfitorderselected.SQLDelete4orders, ordersPK.getSQLprimarykey());
    }

    public ArrayList<Shipfitorderselected> getShipfitorderselecteds4orders(IOrdersPK ordersPK) throws CustomException {
        return tableio.getEntities(EMshipfitorderselected.SQLSelect4orders, ordersPK.getSQLprimarykey());
    }
    public void delete4shipfitorder(SQLTqueue transactionqueue, IShipfitorderPK shipfitorderPK) {
        tableio.addStatement(transactionqueue, EMshipfitorderselected.SQLDelete4shipfitorder, shipfitorderPK.getSQLprimarykey());
    }

    public ArrayList<Shipfitorderselected> getShipfitorderselecteds4shipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        return tableio.getEntities(EMshipfitorderselected.SQLSelect4shipfitorder, shipfitorderPK.getSQLprimarykey());
    }

    public ArrayList<Shipfitorderselected> getShipfitorderselecteds(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfitorderselected.SQLSelect);
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
        return (ArrayList<Shipfitorderselected>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delShipfitorderselected(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfitorderselected.table);
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
