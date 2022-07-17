/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMshipfitorder;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.logicentity.Shipfitorder;

/**
 * @author Franky Laseure
 */
public abstract class Bshipfitorder extends TableBusinessrules {

    public Bshipfitorder(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMshipfitorder()));
    }

    public Bshipfitorder(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMshipfitorder()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IShipfitorder newShipfitorder() {
    	return new Shipfitorder();
    }
    
    public IShipfitorder newShipfitorder(java.lang.String username, java.lang.String shipname, long evetype) {
        return new Shipfitorder(username, shipname, evetype);
    }

    public IShipfitorder newShipfitorder(IShipfitorderPK shipfitorderPK) {
        return new Shipfitorder((ShipfitorderPK)shipfitorderPK);
    }

    public IShipfitorderPK newShipfitorderPK() {
        return new ShipfitorderPK();
    }

    public IShipfitorderPK newShipfitorderPK(java.lang.String username, java.lang.String shipname, long evetype) {
        return new ShipfitorderPK(username, shipname, evetype);
    }

    public ArrayList<Shipfitorder> getShipfitorders() throws DBException {
        return (ArrayList<Shipfitorder>)tableio.getEntities(EMshipfitorder.SQLSelectAll);
    }

    public Shipfitorder getShipfitorder(IShipfitorderPK shipfitorderPK) throws DBException {
        return (Shipfitorder)tableio.getEntity((ShipfitorderPK)shipfitorderPK);
    }

    public ArrayList<Shipfitorder> searchshipfitorders(IShipfitordersearch search) throws DBException {
        return (ArrayList<Shipfitorder>)tableio.search(search);
    }

    public ArrayList<Shipfitorder> searchshipfitorders(IShipfitordersearch search, String orderby) throws DBException {
        return (ArrayList<Shipfitorder>)tableio.search(search, orderby);
    }

    public boolean getShipfitorderExists(IShipfitorderPK shipfitorderPK) throws DBException {
        return tableio.getEntityExists((ShipfitorderPK)shipfitorderPK);
    }

    public Shipfitorder getEntity(String sql) throws DBException {
        return (Shipfitorder)tableio.getEntity(sql);
    }
    
    public Shipfitorder getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Shipfitorder)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Shipfitorder> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Shipfitorder> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Shipfitorder> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Shipfitorder> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertShipfitorder(SQLTqueue transactionqueue, IShipfitorder shipfitorder) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, shipfitorder);
    }

    public void insertupdateShipfitorder(SQLTqueue transactionqueue, IShipfitorder shipfitorder) throws DBException, DataException {
    	checkDATA(shipfitorder);
        if(this.getShipfitorderExists(shipfitorder.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, shipfitorder);
        } else {
            tableio.insertEntity(transactionqueue, shipfitorder);
        }
    }

    public void updateShipfitorder(SQLTqueue transactionqueue, IShipfitorder shipfitorder) throws DBException, DataException {
    	checkDATA(shipfitorder);
        tableio.updateEntity(transactionqueue, shipfitorder);
    }

    public void deleteShipfitorder(SQLTqueue transactionqueue, IShipfitorder shipfitorder) throws DBException {
        cascadedeleteShipfitorder(transactionqueue, shipfitorder.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, shipfitorder);
    }

    private void checkDATA(IShipfitorder shipfitorder) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Shipfitorder.Username - Shipfit.Username
        //foreign key Shipfitorder.Shipname - Shipfit.Shipname
        //foreign key Shipfitorder.Evetype - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where shipfitorderPK is used in a primary key
     * @param shipfitorderPK: Shipfitorder primary key
     */
    public void cascadedeleteShipfitorder(SQLTqueue transactionqueue, IShipfitorderPK shipfitorderPK) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected(this);
        blshipfitorderselected.setAuthenticated(isAuthenticated());
        blshipfitorderselected.delete4shipfitorder(transactionqueue, shipfitorderPK);
    }

    public void delete4shipfit(SQLTqueue transactionqueue, IShipfitPK shipfitPK) {
        tableio.addStatement(transactionqueue, EMshipfitorder.SQLDelete4shipfit, shipfitPK.getSQLprimarykey());
    }

    public ArrayList<Shipfitorder> getShipfitorders4shipfit(IShipfitPK shipfitPK) throws CustomException {
        return tableio.getEntities(EMshipfitorder.SQLSelect4shipfit, shipfitPK.getSQLprimarykey());
    }
    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMshipfitorder.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Shipfitorder> getShipfitorders4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMshipfitorder.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public Shipfitorder getShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws CustomException {
        ShipfitorderPK shipfitorderPK = new ShipfitorderPK(shipfitorderselectedPK.getUsername(), shipfitorderselectedPK.getShipname(), shipfitorderselectedPK.getEvetype());
        return this.getShipfitorder(shipfitorderPK);
    }


    public ArrayList<Shipfitorder> getShipfitorders(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfitorder.SQLSelect);
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
        return (ArrayList<Shipfitorder>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delShipfitorder(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfitorder.table);
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
