/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMregion_neighbour;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRegion_neighboursearch;
import eve.logicentity.Region_neighbour;

/**
 * @author Franky Laseure
 */
public abstract class Bregion_neighbour extends TableBusinessrules {

    public Bregion_neighbour(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMregion_neighbour()));
    }

    public Bregion_neighbour(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMregion_neighbour()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IRegion_neighbour newRegion_neighbour() {
    	return new Region_neighbour();
    }
    
    public IRegion_neighbour newRegion_neighbour(long region, long neighbour) {
        return new Region_neighbour(region, neighbour);
    }

    public IRegion_neighbour newRegion_neighbour(IRegion_neighbourPK region_neighbourPK) {
        return new Region_neighbour((Region_neighbourPK)region_neighbourPK);
    }

    public IRegion_neighbourPK newRegion_neighbourPK() {
        return new Region_neighbourPK();
    }

    public IRegion_neighbourPK newRegion_neighbourPK(long region, long neighbour) {
        return new Region_neighbourPK(region, neighbour);
    }

    public ArrayList<Region_neighbour> getRegion_neighbours() throws DBException {
        return (ArrayList<Region_neighbour>)tableio.getEntities(EMregion_neighbour.SQLSelectAll);
    }

    public Region_neighbour getRegion_neighbour(IRegion_neighbourPK region_neighbourPK) throws DBException {
        return (Region_neighbour)tableio.getEntity((Region_neighbourPK)region_neighbourPK);
    }

    public ArrayList<Region_neighbour> searchregion_neighbours(IRegion_neighboursearch search) throws DBException {
        return (ArrayList<Region_neighbour>)tableio.search(search);
    }

    public ArrayList<Region_neighbour> searchregion_neighbours(IRegion_neighboursearch search, String orderby) throws DBException {
        return (ArrayList<Region_neighbour>)tableio.search(search, orderby);
    }

    public boolean getRegion_neighbourExists(IRegion_neighbourPK region_neighbourPK) throws DBException {
        return tableio.getEntityExists((Region_neighbourPK)region_neighbourPK);
    }

    public Region_neighbour getEntity(String sql) throws DBException {
        return (Region_neighbour)tableio.getEntity(sql);
    }
    
    public Region_neighbour getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Region_neighbour)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Region_neighbour> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Region_neighbour> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Region_neighbour> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Region_neighbour> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertRegion_neighbour(SQLTqueue transactionqueue, IRegion_neighbour region_neighbour) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, region_neighbour);
    }

    public void insertupdateRegion_neighbour(SQLTqueue transactionqueue, IRegion_neighbour region_neighbour) throws DBException, DataException {
    	checkDATA(region_neighbour);
        if(this.getRegion_neighbourExists(region_neighbour.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, region_neighbour);
        } else {
            tableio.insertEntity(transactionqueue, region_neighbour);
        }
    }

    public void updateRegion_neighbour(SQLTqueue transactionqueue, IRegion_neighbour region_neighbour) throws DBException, DataException {
    	checkDATA(region_neighbour);
        tableio.updateEntity(transactionqueue, region_neighbour);
    }

    public void deleteRegion_neighbour(SQLTqueue transactionqueue, IRegion_neighbour region_neighbour) throws DBException {
        cascadedeleteRegion_neighbour(transactionqueue, region_neighbour.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, region_neighbour);
    }

    private void checkDATA(IRegion_neighbour region_neighbour) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Region_neighbour.Region - Region.Id
        //foreign key Region_neighbour.Neighbour - Region.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where region_neighbourPK is used in a primary key
     * @param region_neighbourPK: Region_neighbour primary key
     */
    public void cascadedeleteRegion_neighbour(SQLTqueue transactionqueue, IRegion_neighbourPK region_neighbourPK) {
    }

    public void delete4regionRegion(SQLTqueue transactionqueue, IRegionPK regionPK) {
        tableio.addStatement(transactionqueue, EMregion_neighbour.SQLDelete4regionRegion, regionPK.getSQLprimarykey());
    }

    public ArrayList<Region_neighbour> getRegion_neighbours4regionRegion(IRegionPK regionPK) throws CustomException {
        return tableio.getEntities(EMregion_neighbour.SQLSelect4regionRegion, regionPK.getSQLprimarykey());
    }
    public void delete4regionNeighbour(SQLTqueue transactionqueue, IRegionPK regionPK) {
        tableio.addStatement(transactionqueue, EMregion_neighbour.SQLDelete4regionNeighbour, regionPK.getSQLprimarykey());
    }

    public ArrayList<Region_neighbour> getRegion_neighbours4regionNeighbour(IRegionPK regionPK) throws CustomException {
        return tableio.getEntities(EMregion_neighbour.SQLSelect4regionNeighbour, regionPK.getSQLprimarykey());
    }

    public ArrayList<Region_neighbour> getRegion_neighbours(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMregion_neighbour.SQLSelect);
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
        return (ArrayList<Region_neighbour>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delRegion_neighbour(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Region_neighbour.table);
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
