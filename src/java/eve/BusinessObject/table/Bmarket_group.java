/*
 * Bmarket_group.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.4.2022 9:13
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
import eve.conversion.json.JSONMarket_group;
import eve.conversion.entity.EMmarket_group;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IMarket_groupsearch;
import eve.logicentity.Market_group;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bmarket_group
 *
 * Superclass for manipulating data- and database objects
 * for Entity Market_group and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bmarket_group extends BLtable {

    /**
     * Constructor, sets Market_group as default Entity
     */
    public Bmarket_group() {
        super(new Market_group(), new EMmarket_group());
    }

    /**
     * Constructor, sets Market_group as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmarket_group(BLtable transactionobject) {
        super(transactionobject, new Market_group(), new EMmarket_group());
    }

    /**
     * create new empty Market_group object
     * @return empty IMarket_group
     */
    public IMarket_group newMarket_group() {
    	return new Market_group();
    }
    
    /**
     * create new empty Market_group object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IMarket_group with primary key
     */
    public IMarket_group newMarket_group(long id) {
        return new Market_group(id);
    }

    /**
     * create new empty Market_group object with given primary key
     * @param market_groupPK: primary key for Market_group
     * @return IMarket_group with primary key
     */
    public IMarket_group newMarket_group(IMarket_groupPK market_groupPK) {
        return new Market_group((Market_groupPK)market_groupPK);
    }

    /**
     * create new empty primary key
     * @return empty Market_groupPK
     */
    public IMarket_groupPK newMarket_groupPK() {
        return new Market_groupPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IMarket_groupPK
     */
    public IMarket_groupPK newMarket_groupPK(long id) {
        return new Market_groupPK(id);
    }

    /**
     * get all Market_group objects from database
     * @return ArrayList of Market_group objects
     * @throws DBException
     */
    public ArrayList<Market_group> getMarket_groups() throws DBException {
        return (ArrayList<Market_group>)super.getEntities(EMmarket_group.SQLSelectAll);
    }

    /**
     * search Market_group for primary key
     * @param market_groupPK: Market_group primary key
     * @return Market_group object
     * @throws DBException
     */
    public Market_group getMarket_group(IMarket_groupPK market_groupPK) throws DBException {
        return (Market_group)super.getEntity((Market_groupPK)market_groupPK);
    }

    /**
     * search market_group with IMarket_groupsearch parameters
     * @param search IMarket_groupsearch
     * @return ArrayList of Market_group
     * @throws DBException 
     */
    public ArrayList<Market_group> searchmarket_groups(IMarket_groupsearch search) throws DBException {
        return (ArrayList<Market_group>)this.search(search);
    }

    /**
     * search market_group with IMarket_groupsearch parameters, order by orderby sql clause
     * @param search IMarket_groupsearch
     * @param orderby sql order by string
     * @return ArrayList of Market_group
     * @throws DBException 
     */
    public ArrayList<Market_group> searchmarket_groups(IMarket_groupsearch search, String orderby) throws DBException {
        return (ArrayList<Market_group>)this.search(search, orderby);
    }

    /**
     * Search market_group in database for market_groupPK:
     * @param market_groupPK: Market_group Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMarket_groupExists(IMarket_groupPK market_groupPK) throws DBException {
        return super.getEntityExists((Market_groupPK)market_groupPK);
    }

    /**
     * try to insert Market_group in database
     * @param market_group Market_group object
     * @throws DBException
     * @throws DataException
     */
    public void insertMarket_group(IMarket_group market_group) throws DBException, DataException {
        super.insertEntity(market_group);
    }

    /**
     * check if Market_groupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param market_group Market_group object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateMarket_group(IMarket_group market_group) throws DBException, DataException {
        if(this.getMarket_groupExists(market_group.getPrimaryKey())) {
            super.updateEntity(market_group);
        } else {
            super.insertEntity(market_group);
        }
    }

    /**
     * try to update Market_group in database
     * @param market_group Market_group object
     * @throws DBException
     * @throws DataException
     */
    public void updateMarket_group(IMarket_group market_group) throws DBException, DataException {
        super.updateEntity(market_group);
    }

    /**
     * try to delete Market_group in database
     * @param market_group Market_group object
     * @throws DBException
     */
    public void deleteMarket_group(IMarket_group market_group) throws DBException {
        cascadedeleteMarket_group(market_group.getPrimaryKey());
        super.deleteEntity(market_group);
    }

    /**
     * check data rules in Market_group, throw DataException with customized message if rules do not apply
     * @param market_group Market_group object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMarket_group market_group) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(market_group.getName()!=null && market_group.getName().length()>IMarket_group.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IMarket_group.SIZE_NAME).append("\n");
        }
        if(market_group.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(market_group.getDescription()!=null && market_group.getDescription().length()>IMarket_group.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IMarket_group.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where market_groupPK is used in a primary key
     * @param market_groupPK: Market_group primary key
     */
    public void cascadedeleteMarket_group(IMarket_groupPK market_groupPK) {
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @delete all Market_group Entity objects for Market_group in database
     */
    public void delete4market_groupParent_id(IMarket_groupPK market_groupPK) {
        super.addStatement(EMmarket_group.SQLDelete4market_groupParent_id, market_groupPK.getSQLprimarykey());
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @return all Market_group Entity objects for Market_group
     * @throws CustomException
     */
    public ArrayList<Market_group> getMarket_groups4market_groupParent_id(IMarket_groupPK market_groupPK) throws CustomException {
        return super.getEntities(EMmarket_group.SQLSelect4market_groupParent_id, market_groupPK.getSQLprimarykey());
    }

    /**
     * get all Market_group objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Market_group objects
     * @throws DBException
     */
    public ArrayList<Market_group> getMarket_groups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmarket_group.SQLSelect);
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
        return (ArrayList<Market_group>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Market_group objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delMarket_group(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Market_group.table);
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
