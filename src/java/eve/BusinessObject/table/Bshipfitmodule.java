/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMshipfitmodule;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.logicentity.Shipfitmodule;

/**
 * @author Franky Laseure
 */
public abstract class Bshipfitmodule extends TableBusinessrules {

    public Bshipfitmodule(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMshipfitmodule()));
    }

    public Bshipfitmodule(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMshipfitmodule()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IShipfitmodule newShipfitmodule() {
    	return new Shipfitmodule();
    }
    
    public IShipfitmodule newShipfitmodule(java.lang.String username, java.lang.String shipname, long moduletype) {
        return new Shipfitmodule(username, shipname, moduletype);
    }

    public IShipfitmodule newShipfitmodule(IShipfitmodulePK shipfitmodulePK) {
        return new Shipfitmodule((ShipfitmodulePK)shipfitmodulePK);
    }

    public IShipfitmodulePK newShipfitmodulePK() {
        return new ShipfitmodulePK();
    }

    public IShipfitmodulePK newShipfitmodulePK(java.lang.String username, java.lang.String shipname, long moduletype) {
        return new ShipfitmodulePK(username, shipname, moduletype);
    }

    public ArrayList<Shipfitmodule> getShipfitmodules() throws DBException {
        return (ArrayList<Shipfitmodule>)tableio.getEntities(EMshipfitmodule.SQLSelectAll);
    }

    public Shipfitmodule getShipfitmodule(IShipfitmodulePK shipfitmodulePK) throws DBException {
        return (Shipfitmodule)tableio.getEntity((ShipfitmodulePK)shipfitmodulePK);
    }

    public ArrayList<Shipfitmodule> searchshipfitmodules(IShipfitmodulesearch search) throws DBException {
        return (ArrayList<Shipfitmodule>)tableio.search(search);
    }

    public ArrayList<Shipfitmodule> searchshipfitmodules(IShipfitmodulesearch search, String orderby) throws DBException {
        return (ArrayList<Shipfitmodule>)tableio.search(search, orderby);
    }

    public boolean getShipfitmoduleExists(IShipfitmodulePK shipfitmodulePK) throws DBException {
        return tableio.getEntityExists((ShipfitmodulePK)shipfitmodulePK);
    }

    public Shipfitmodule getEntity(String sql) throws DBException {
        return (Shipfitmodule)tableio.getEntity(sql);
    }
    
    public Shipfitmodule getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Shipfitmodule)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Shipfitmodule> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Shipfitmodule> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Shipfitmodule> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Shipfitmodule> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertShipfitmodule(SQLTqueue transactionqueue, IShipfitmodule shipfitmodule) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, shipfitmodule);
    }

    public void insertupdateShipfitmodule(SQLTqueue transactionqueue, IShipfitmodule shipfitmodule) throws DBException, DataException {
    	checkDATA(shipfitmodule);
        if(this.getShipfitmoduleExists(shipfitmodule.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, shipfitmodule);
        } else {
            tableio.insertEntity(transactionqueue, shipfitmodule);
        }
    }

    public void updateShipfitmodule(SQLTqueue transactionqueue, IShipfitmodule shipfitmodule) throws DBException, DataException {
    	checkDATA(shipfitmodule);
        tableio.updateEntity(transactionqueue, shipfitmodule);
    }

    public void deleteShipfitmodule(SQLTqueue transactionqueue, IShipfitmodule shipfitmodule) throws DBException {
        cascadedeleteShipfitmodule(transactionqueue, shipfitmodule.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, shipfitmodule);
    }

    private void checkDATA(IShipfitmodule shipfitmodule) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Shipfitmodule.Username - Shipfit.Username
        //foreign key Shipfitmodule.Shipname - Shipfit.Shipname
        //foreign key Shipfitmodule.Moduletype - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where shipfitmodulePK is used in a primary key
     * @param shipfitmodulePK: Shipfitmodule primary key
     */
    public void cascadedeleteShipfitmodule(SQLTqueue transactionqueue, IShipfitmodulePK shipfitmodulePK) {
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMshipfitmodule.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Shipfitmodule> getShipfitmodules4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMshipfitmodule.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public void delete4shipfit(SQLTqueue transactionqueue, IShipfitPK shipfitPK) {
        tableio.addStatement(transactionqueue, EMshipfitmodule.SQLDelete4shipfit, shipfitPK.getSQLprimarykey());
    }

    public ArrayList<Shipfitmodule> getShipfitmodules4shipfit(IShipfitPK shipfitPK) throws CustomException {
        return tableio.getEntities(EMshipfitmodule.SQLSelect4shipfit, shipfitPK.getSQLprimarykey());
    }

    public ArrayList<Shipfitmodule> getShipfitmodules(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfitmodule.SQLSelect);
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
        return (ArrayList<Shipfitmodule>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delShipfitmodule(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfitmodule.table);
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
