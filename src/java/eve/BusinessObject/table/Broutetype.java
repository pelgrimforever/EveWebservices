/*
 * Broutetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 11:31
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONRoutetype;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.logicentity.Routetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Broutetype
 *
 * Superclass for manipulating data- and database objects
 * for Entity Routetype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Broutetype extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Routetype as default Entity
     */
    public Broutetype() {
        super(new SQLMapper_pgsql(connectionpool, "Routetype"), new Routetype());
    }

    /**
     * Constructor, sets Routetype as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Broutetype(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Routetype());
    }

    /**
     * Map ResultSet Field values to Routetype
     * @param dbresult: Database ResultSet
     */
    public Routetype mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RoutetypePK routetypePK = null;
        Routetype routetype;
        if(dbresult==null) {
            routetype = new Routetype(routetypePK);
        } else {
            try {
                routetypePK = new RoutetypePK(dbresult.getLong("id"));
                routetype = new Routetype(routetypePK);
                routetype.initSecurity_islandPK(new Security_islandPK(dbresult.getLong("security_island")));
                if(dbresult.wasNull()) routetype.setSecurity_islandPK(null);                
                routetype.initName(dbresult.getString("name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, routetype);
        return routetype;
    }

    /**
     * create new empty Routetype object
     * @return empty IRoutetype
     */
    public IRoutetype newRoutetype() {
    	return new Routetype();
    }
    
    /**
     * create new empty Routetype object
     * create new primary key with given parameters
     * @return IRoutetype with primary key
     */
    public IRoutetype newRoutetype(long id) {
        return new Routetype(id);
    }

    /**
     * create new empty Routetype object with given primary key
     * @param routetypePK: primary key for Routetype
     * @return IRoutetype with primary key
     */
    public IRoutetype newRoutetype(IRoutetypePK routetypePK) {
        return new Routetype((RoutetypePK)routetypePK);
    }

    /**
     * create new empty primary key
     * @return empty RoutetypePK
     */
    public IRoutetypePK newRoutetypePK() {
        return new RoutetypePK();
    }

    /**
     * create new primary key with given parameters
     * @return new IRoutetypePK
     */
    public IRoutetypePK newRoutetypePK(long id) {
        return new RoutetypePK(id);
    }

    /**
     * get all Routetype objects from database
     * @return ArrayList of Routetype objects
     * @throws DBException
     */
    public ArrayList getRoutetypes() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Routetype.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Routetype for primary key
     * @param routetypePK: Routetype primary key
     * @return Routetype object
     * @throws DBException
     */
    public Routetype getRoutetype(IRoutetypePK routetypePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Routetype)super.getEntity((RoutetypePK)routetypePK);
        } else return null;
    }

    public ArrayList searchroutetypes(IRoutetypesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchroutetypes(IRoutetypesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search routetype in database for routetypePK:
     * @param routetypePK: Routetype Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRoutetypeExists(IRoutetypePK routetypePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((RoutetypePK)routetypePK);
        } else return false;
    }

    /**
     * try to insert Routetype in database
     * @param film: Routetype object
     * @throws DBException
     */
    public void insertRoutetype(IRoutetype routetype) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(routetype);
        }
    }

    /**
     * check if RoutetypePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Routetype object
     * @throws DBException
     */
    public void insertupdateRoutetype(IRoutetype routetype) throws DBException, DataException {
        if(this.getRoutetypeExists(routetype.getPrimaryKey())) {
            super.updateEntity(routetype);
        } else {
            super.insertEntity(routetype);
        }
    }

    /**
     * try to update Routetype in database
     * @param film: Routetype object
     * @throws DBException
     */
    public void updateRoutetype(IRoutetype routetype) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(routetype);
        }
    }

    /**
     * try to delete Routetype in database
     * @param film: Routetype object
     * @throws DBException
     */
    public void deleteRoutetype(IRoutetype routetype) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteRoutetype(routetype.getOwnerobject(), routetype.getPrimaryKey());
            super.deleteEntity(routetype);
        }
    }

    /**
     * check data rules in Routetype, throw DataException with customized message if rules do not apply
     * @param film: Routetype object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRoutetype routetype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(routetype.getName()!=null && routetype.getName().length()>IRoutetype.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IRoutetype.SIZE_NAME + "\n");
        }
        if(routetype.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where routetypePK is used in a primary key
     * @param routetypePK: Routetype primary key
     */
    public void cascadedeleteRoutetype(String senderobject, IRoutetypePK routetypePK) {
        BLroute blroute = new BLroute(this);
        blroute.delete4routetype(senderobject, routetypePK);
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @delete all Routetype Entity objects for Security_island in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4security_island(String senderobject, ISecurity_islandPK security_islandPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Routetype.SQLDelete4security_island, security_islandPK.getKeyFields());
        }
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @return all Routetype Entity objects for Security_island
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getRoutetypes4security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Routetype.SQLSelect4security_island, security_islandPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param routePK: parent Route for child object Routetype Entity
     * @return child Routetype Entity object
     * @throws eve.general.exception.CustomException
     */
    public IRoutetype getRoute(IRoutePK routePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            RoutetypePK routetypePK = new RoutetypePK(routePK.getRoutetype());
            return this.getRoutetype(routetypePK);
        } else return null;
    }


    /**
     * get all Routetype objects for sqlparameters
     * @return ArrayList of Routetype objects
     * @throws DBException
     */
    public ArrayList getRoutetypes(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Routetype.SQLSelect;
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
     * delete all Routetype objects for sqlparameters
     * @throws DBException
     */
    public void delRoutetype(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Routetype.table;
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
