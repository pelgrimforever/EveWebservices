/*
 * Bmarket_group.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.4.2021 13:20
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONMarket_group;
import eve.data.ProjectConstants;
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
public abstract class Bmarket_group extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Market_group as default Entity
     */
    public Bmarket_group() {
        super(new SQLMapper_pgsql(connectionpool, "Market_group"), new Market_group());
    }

    /**
     * Constructor, sets Market_group as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmarket_group(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Market_group());
    }

    /**
     * Map ResultSet Field values to Market_group
     * @param dbresult: Database ResultSet
     */
    public Market_group mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Market_groupPK market_groupPK = null;
        Market_group market_group;
        if(dbresult==null) {
            market_group = new Market_group(market_groupPK);
        } else {
            try {
                market_groupPK = new Market_groupPK(dbresult.getLong("id"));
                market_group = new Market_group(market_groupPK);
                market_group.initMarket_groupparent_idPK(new Market_groupPK(dbresult.getLong("parent_id")));
                if(dbresult.wasNull()) market_group.setMarket_groupparent_idPK(null);                
                market_group.initName(dbresult.getString("name"));
                market_group.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, market_group);
        return market_group;
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
    public ArrayList getMarket_groups() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Market_group.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Market_group for primary key
     * @param market_groupPK: Market_group primary key
     * @return Market_group object
     * @throws DBException
     */
    public Market_group getMarket_group(IMarket_groupPK market_groupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Market_group)super.getEntity((Market_groupPK)market_groupPK);
        } else return null;
    }

    public ArrayList searchmarket_groups(IMarket_groupsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchmarket_groups(IMarket_groupsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search market_group in database for market_groupPK:
     * @param market_groupPK: Market_group Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMarket_groupExists(IMarket_groupPK market_groupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Market_groupPK)market_groupPK);
        } else return false;
    }

    /**
     * try to insert Market_group in database
     * @param film: Market_group object
     * @throws DBException
     */
    public void insertMarket_group(IMarket_group market_group) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(market_group);
        }
    }

    /**
     * check if Market_groupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Market_group object
     * @throws DBException
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
     * @param film: Market_group object
     * @throws DBException
     */
    public void updateMarket_group(IMarket_group market_group) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(market_group);
        }
    }

    /**
     * try to delete Market_group in database
     * @param film: Market_group object
     * @throws DBException
     */
    public void deleteMarket_group(IMarket_group market_group) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteMarket_group(market_group.getOwnerobject(), market_group.getPrimaryKey());
            super.deleteEntity(market_group);
        }
    }

    /**
     * check data rules in Market_group, throw DataException with customized message if rules do not apply
     * @param film: Market_group object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMarket_group market_group) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(market_group.getName()!=null && market_group.getName().length()>IMarket_group.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IMarket_group.SIZE_NAME + "\n");
        }
        if(market_group.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(market_group.getDescription()!=null && market_group.getDescription().length()>IMarket_group.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + IMarket_group.SIZE_DESCRIPTION + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where market_groupPK is used in a primary key
     * @param market_groupPK: Market_group primary key
     */
    public void cascadedeleteMarket_group(String senderobject, IMarket_groupPK market_groupPK) {
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @delete all Market_group Entity objects for Market_group in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4market_groupParent_id(String senderobject, IMarket_groupPK market_groupPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Market_group.SQLDelete4market_groupParent_id, market_groupPK.getKeyFields());
        }
    }

    /**
     * @param market_groupPK: foreign key for Market_group
     * @return all Market_group Entity objects for Market_group
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getMarket_groups4market_groupParent_id(IMarket_groupPK market_groupPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Market_group.SQLSelect4market_groupParent_id, market_groupPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Market_group objects for sqlparameters
     * @return ArrayList of Market_group objects
     * @throws DBException
     */
    public ArrayList getMarket_groups(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Market_group.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Market_group objects for sqlparameters
     * @throws DBException
     */
    public void delMarket_group(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Market_group.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
