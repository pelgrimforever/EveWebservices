/*
 * Bregion_neighbour.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.0.2022 16:56
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
import eve.conversion.json.JSONRegion_neighbour;
import eve.conversion.entity.EMregion_neighbour;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRegion_neighboursearch;
import eve.logicentity.Region_neighbour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bregion_neighbour
 *
 * Superclass for manipulating data- and database objects
 * for Entity Region_neighbour and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bregion_neighbour extends BLtable {

    /**
     * Constructor, sets Region_neighbour as default Entity
     */
    public Bregion_neighbour() {
        super(new Region_neighbour(), new EMregion_neighbour());
    }

    /**
     * Constructor, sets Region_neighbour as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bregion_neighbour(BLtable transactionobject) {
        super(transactionobject, new Region_neighbour(), new EMregion_neighbour());
    }

    /**
     * create new empty Region_neighbour object
     * @return empty IRegion_neighbour
     */
    public IRegion_neighbour newRegion_neighbour() {
    	return new Region_neighbour();
    }
    
    /**
     * create new empty Region_neighbour object
     * create new primary key with given parameters
     * @param region primary key field
     * @param neighbour primary key field
     * @return IRegion_neighbour with primary key
     */
    public IRegion_neighbour newRegion_neighbour(long region, long neighbour) {
        return new Region_neighbour(region, neighbour);
    }

    /**
     * create new empty Region_neighbour object with given primary key
     * @param region_neighbourPK: primary key for Region_neighbour
     * @return IRegion_neighbour with primary key
     */
    public IRegion_neighbour newRegion_neighbour(IRegion_neighbourPK region_neighbourPK) {
        return new Region_neighbour((Region_neighbourPK)region_neighbourPK);
    }

    /**
     * create new empty primary key
     * @return empty Region_neighbourPK
     */
    public IRegion_neighbourPK newRegion_neighbourPK() {
        return new Region_neighbourPK();
    }

    /**
     * create new primary key with given parameters
     * @param region primary key field
     * @param neighbour primary key field
     * @return new IRegion_neighbourPK
     */
    public IRegion_neighbourPK newRegion_neighbourPK(long region, long neighbour) {
        return new Region_neighbourPK(region, neighbour);
    }

    /**
     * get all Region_neighbour objects from database
     * @return ArrayList of Region_neighbour objects
     * @throws DBException
     */
    public ArrayList<Region_neighbour> getRegion_neighbours() throws DBException {
        return (ArrayList<Region_neighbour>)super.getEntities(EMregion_neighbour.SQLSelectAll);
    }

    /**
     * search Region_neighbour for primary key
     * @param region_neighbourPK: Region_neighbour primary key
     * @return Region_neighbour object
     * @throws DBException
     */
    public Region_neighbour getRegion_neighbour(IRegion_neighbourPK region_neighbourPK) throws DBException {
        return (Region_neighbour)super.getEntity((Region_neighbourPK)region_neighbourPK);
    }

    /**
     * search region_neighbour with IRegion_neighboursearch parameters
     * @param search IRegion_neighboursearch
     * @return ArrayList of Region_neighbour
     * @throws DBException 
     */
    public ArrayList<Region_neighbour> searchregion_neighbours(IRegion_neighboursearch search) throws DBException {
        return (ArrayList<Region_neighbour>)this.search(search);
    }

    /**
     * search region_neighbour with IRegion_neighboursearch parameters, order by orderby sql clause
     * @param search IRegion_neighboursearch
     * @param orderby sql order by string
     * @return ArrayList of Region_neighbour
     * @throws DBException 
     */
    public ArrayList<Region_neighbour> searchregion_neighbours(IRegion_neighboursearch search, String orderby) throws DBException {
        return (ArrayList<Region_neighbour>)this.search(search, orderby);
    }

    /**
     * Search region_neighbour in database for region_neighbourPK:
     * @param region_neighbourPK: Region_neighbour Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRegion_neighbourExists(IRegion_neighbourPK region_neighbourPK) throws DBException {
        return super.getEntityExists((Region_neighbourPK)region_neighbourPK);
    }

    /**
     * try to insert Region_neighbour in database
     * @param region_neighbour Region_neighbour object
     * @throws DBException
     * @throws DataException
     */
    public void insertRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        super.insertEntity(region_neighbour);
    }

    /**
     * check if Region_neighbourPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param region_neighbour Region_neighbour object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        if(this.getRegion_neighbourExists(region_neighbour.getPrimaryKey())) {
            super.updateEntity(region_neighbour);
        } else {
            super.insertEntity(region_neighbour);
        }
    }

    /**
     * try to update Region_neighbour in database
     * @param region_neighbour Region_neighbour object
     * @throws DBException
     * @throws DataException
     */
    public void updateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        super.updateEntity(region_neighbour);
    }

    /**
     * try to delete Region_neighbour in database
     * @param region_neighbour Region_neighbour object
     * @throws DBException
     */
    public void deleteRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException {
        cascadedeleteRegion_neighbour(region_neighbour.getPrimaryKey());
        super.deleteEntity(region_neighbour);
    }

    /**
     * check data rules in Region_neighbour, throw DataException with customized message if rules do not apply
     * @param region_neighbour Region_neighbour object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRegion_neighbour region_neighbour) throws DataException, DBException {
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
    public void cascadedeleteRegion_neighbour(IRegion_neighbourPK region_neighbourPK) {
    }

    /**
     * @param regionPK: foreign key for Region
     * @delete all Region_neighbour Entity objects for Region in database
     */
    public void delete4regionRegion(IRegionPK regionPK) {
        super.addStatement(EMregion_neighbour.SQLDelete4regionRegion, regionPK.getSQLprimarykey());
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Region_neighbour Entity objects for Region
     * @throws CustomException
     */
    public ArrayList<Region_neighbour> getRegion_neighbours4regionRegion(IRegionPK regionPK) throws CustomException {
        return super.getEntities(EMregion_neighbour.SQLSelect4regionRegion, regionPK.getSQLprimarykey());
    }
    /**
     * @param regionPK: foreign key for Region
     * @delete all Region_neighbour Entity objects for Region in database
     */
    public void delete4regionNeighbour(IRegionPK regionPK) {
        super.addStatement(EMregion_neighbour.SQLDelete4regionNeighbour, regionPK.getSQLprimarykey());
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Region_neighbour Entity objects for Region
     * @throws CustomException
     */
    public ArrayList<Region_neighbour> getRegion_neighbours4regionNeighbour(IRegionPK regionPK) throws CustomException {
        return super.getEntities(EMregion_neighbour.SQLSelect4regionNeighbour, regionPK.getSQLprimarykey());
    }

    /**
     * get all Region_neighbour objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Region_neighbour objects
     * @throws DBException
     */
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
        return (ArrayList<Region_neighbour>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Region_neighbour objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delRegion_neighbour(SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        this.addStatement(sql.toString(), sqlparameters);
    }


}
