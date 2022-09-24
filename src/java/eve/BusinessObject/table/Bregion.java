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
import eve.conversion.entity.EMregion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRegionsearch;
import eve.logicentity.Region;

public abstract class Bregion extends TableBusinessrules {

    public Bregion(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMregion()));
    }

    public Bregion(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMregion()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IRegion newRegion() {
    	return new Region();
    }
    
    public IRegion newRegion(long id) {
        return new Region(id);
    }

    public IRegion newRegion(IRegionPK regionPK) {
        return new Region((RegionPK)regionPK);
    }

    public IRegionPK newRegionPK() {
        return new RegionPK();
    }

    public IRegionPK newRegionPK(long id) {
        return new RegionPK(id);
    }

    public ArrayList<Region> getRegions() throws DBException {
        return (ArrayList<Region>)tableio.getEntities(EMregion.SQLSelectAll);
    }

    public Region getRegion(IRegionPK regionPK) throws DBException {
        return (Region)tableio.getEntity((RegionPK)regionPK);
    }

    public ArrayList<Region> searchregions(IRegionsearch search) throws DBException {
        return (ArrayList<Region>)tableio.search(search);
    }

    public ArrayList<Region> searchregions(IRegionsearch search, String orderby) throws DBException {
        return (ArrayList<Region>)tableio.search(search, orderby);
    }

    public boolean getRegionExists(IRegionPK regionPK) throws DBException {
        return tableio.getEntityExists((RegionPK)regionPK);
    }

    public Region getEntity(String sql) throws DBException {
        return (Region)tableio.getEntity(sql);
    }
    
    public Region getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Region)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Region> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Region> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Region> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Region> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertRegion(SQLTqueue transactionqueue, IRegion region) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, region);
    }

    public void insertupdateRegion(SQLTqueue transactionqueue, IRegion region) throws DBException, DataException {
    	checkDATA(region);
        if(this.getRegionExists(region.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, region);
        } else {
            tableio.insertEntity(transactionqueue, region);
        }
    }

    public void updateRegion(SQLTqueue transactionqueue, IRegion region) throws DBException, DataException {
    	checkDATA(region);
        tableio.updateEntity(transactionqueue, region);
    }

    public void deleteRegion(SQLTqueue transactionqueue, IRegion region) throws DBException {
        cascadedeleteRegion(transactionqueue, region.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, region);
    }

    private void checkDATA(IRegion region) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(region.getName()!=null && region.getName().length()>IRegion.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IRegion.SIZE_NAME).append("\n");
        }
        if(region.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteRegion(SQLTqueue transactionqueue, IRegionPK regionPK) {
        BLorder_history_month blorder_history_month = new BLorder_history_month(this);
        blorder_history_month.setAuthenticated(isAuthenticated());
        blorder_history_month.delete4region(transactionqueue, regionPK);
        BLorder_history blorder_history = new BLorder_history(this);
        blorder_history.setAuthenticated(isAuthenticated());
        blorder_history.delete4region(transactionqueue, regionPK);
        BLregion_neighbour blregion_neighbourRegion = new BLregion_neighbour(this);
        blregion_neighbourRegion.setAuthenticated(isAuthenticated());
        blregion_neighbourRegion.delete4regionRegion(transactionqueue, regionPK);
        BLregion_neighbour blregion_neighbourNeighbour = new BLregion_neighbour(this);
        blregion_neighbourNeighbour.setAuthenticated(isAuthenticated());
        blregion_neighbourNeighbour.delete4regionNeighbour(transactionqueue, regionPK);
    }

    public Region getOrder_history_month(IOrder_history_monthPK order_history_monthPK) throws CustomException {
        RegionPK regionPK = new RegionPK(order_history_monthPK.getRegion());
        return this.getRegion(regionPK);
    }

    public Region getOrder_history(IOrder_historyPK order_historyPK) throws CustomException {
        RegionPK regionPK = new RegionPK(order_historyPK.getRegion());
        return this.getRegion(regionPK);
    }

    public Region getRegion_neighbourregion(IRegion_neighbourPK region_neighbourPK) throws CustomException {
        RegionPK regionPK = new RegionPK(region_neighbourPK.getRegion());
        return this.getRegion(regionPK);
    }

    public Region getRegion_neighbourneighbour(IRegion_neighbourPK region_neighbourPK) throws CustomException {
        RegionPK regionPK = new RegionPK(region_neighbourPK.getNeighbour());
        return this.getRegion(regionPK);
    }


    public ArrayList<Region> getRegions(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMregion.SQLSelect);
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
        return (ArrayList<Region>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delRegion(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Region.table);
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
