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
import eve.conversion.entity.EMshipfit;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IShipfitsearch;
import eve.logicentity.Shipfit;

public abstract class Bshipfit extends TableBusinessrules {

    public Bshipfit(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMshipfit()));
    }

    public Bshipfit(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMshipfit()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IShipfit newShipfit() {
    	return new Shipfit();
    }
    
    public IShipfit newShipfit(java.lang.String username, java.lang.String shipname) {
        return new Shipfit(username, shipname);
    }

    public IShipfit newShipfit(IShipfitPK shipfitPK) {
        return new Shipfit((ShipfitPK)shipfitPK);
    }

    public IShipfitPK newShipfitPK() {
        return new ShipfitPK();
    }

    public IShipfitPK newShipfitPK(java.lang.String username, java.lang.String shipname) {
        return new ShipfitPK(username, shipname);
    }

    public ArrayList<Shipfit> getShipfits() throws DBException {
        return (ArrayList<Shipfit>)tableio.getEntities(EMshipfit.SQLSelectAll);
    }

    public Shipfit getShipfit(IShipfitPK shipfitPK) throws DBException {
        return (Shipfit)tableio.getEntity((ShipfitPK)shipfitPK);
    }

    public ArrayList<Shipfit> searchshipfits(IShipfitsearch search) throws DBException {
        return (ArrayList<Shipfit>)tableio.search(search);
    }

    public ArrayList<Shipfit> searchshipfits(IShipfitsearch search, String orderby) throws DBException {
        return (ArrayList<Shipfit>)tableio.search(search, orderby);
    }

    public boolean getShipfitExists(IShipfitPK shipfitPK) throws DBException {
        return tableio.getEntityExists((ShipfitPK)shipfitPK);
    }

    public Shipfit getEntity(String sql) throws DBException {
        return (Shipfit)tableio.getEntity(sql);
    }
    
    public Shipfit getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Shipfit)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Shipfit> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Shipfit> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Shipfit> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Shipfit> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertShipfit(SQLTqueue transactionqueue, IShipfit shipfit) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, shipfit);
    }

    public void insertupdateShipfit(SQLTqueue transactionqueue, IShipfit shipfit) throws DBException, DataException {
    	checkDATA(shipfit);
        if(this.getShipfitExists(shipfit.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, shipfit);
        } else {
            tableio.insertEntity(transactionqueue, shipfit);
        }
    }

    public void updateShipfit(SQLTqueue transactionqueue, IShipfit shipfit) throws DBException, DataException {
    	checkDATA(shipfit);
        tableio.updateEntity(transactionqueue, shipfit);
    }

    public void deleteShipfit(SQLTqueue transactionqueue, IShipfit shipfit) throws DBException {
        cascadedeleteShipfit(transactionqueue, shipfit.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, shipfit);
    }

    private void checkDATA(IShipfit shipfit) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteShipfit(SQLTqueue transactionqueue, IShipfitPK shipfitPK) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule(this);
        blshipfitmodule.setAuthenticated(isAuthenticated());
        blshipfitmodule.delete4shipfit(transactionqueue, shipfitPK);
        BLshipfitorder blshipfitorder = new BLshipfitorder(this);
        blshipfitorder.setAuthenticated(isAuthenticated());
        blshipfitorder.delete4shipfit(transactionqueue, shipfitPK);
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMshipfit.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Shipfit> getShipfits4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMshipfit.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public Shipfit getShipfitmodule(IShipfitmodulePK shipfitmodulePK) throws CustomException {
        ShipfitPK shipfitPK = new ShipfitPK(shipfitmodulePK.getUsername(), shipfitmodulePK.getShipname());
        return this.getShipfit(shipfitPK);
    }

    public Shipfit getShipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        ShipfitPK shipfitPK = new ShipfitPK(shipfitorderPK.getUsername(), shipfitorderPK.getShipname());
        return this.getShipfit(shipfitPK);
    }


    public ArrayList<Shipfit> getShipfits(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMshipfit.SQLSelect);
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
        return (ArrayList<Shipfit>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delShipfit(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Shipfit.table);
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
