/*
 * Bconstellation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.5.2021 16:2
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
import eve.conversion.json.JSONConstellation;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IConstellationsearch;
import eve.logicentity.Constellation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bconstellation
 *
 * Superclass for manipulating data- and database objects
 * for Entity Constellation and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bconstellation extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Constellation as default Entity
     */
    public Bconstellation() {
        super(new SQLMapper_pgsql(connectionpool, "Constellation"), new Constellation());
    }

    /**
     * Constructor, sets Constellation as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bconstellation(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Constellation());
    }

    /**
     * Map ResultSet Field values to Constellation
     * @param dbresult: Database ResultSet
     */
    public Constellation mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ConstellationPK constellationPK = null;
        Constellation constellation;
        if(dbresult==null) {
            constellation = new Constellation(constellationPK);
        } else {
            try {
                constellationPK = new ConstellationPK(dbresult.getLong("id"));
                constellation = new Constellation(constellationPK);
                constellation.initRegionPK(new RegionPK(dbresult.getLong("region")));
                if(dbresult.wasNull()) constellation.setRegionPK(null);                
                constellation.initName(dbresult.getString("name"));
                constellation.initNoaccess(dbresult.getBoolean("noaccess"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, constellation);
        return constellation;
    }

    /**
     * create new empty Constellation object
     * @return empty IConstellation
     */
    public IConstellation newConstellation() {
    	return new Constellation();
    }
    
    /**
     * create new empty Constellation object
     * create new primary key with given parameters
     * @return IConstellation with primary key
     */
    public IConstellation newConstellation(long id) {
        return new Constellation(id);
    }

    /**
     * create new empty Constellation object with given primary key
     * @param constellationPK: primary key for Constellation
     * @return IConstellation with primary key
     */
    public IConstellation newConstellation(IConstellationPK constellationPK) {
        return new Constellation((ConstellationPK)constellationPK);
    }

    /**
     * create new empty primary key
     * @return empty ConstellationPK
     */
    public IConstellationPK newConstellationPK() {
        return new ConstellationPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IConstellationPK
     */
    public IConstellationPK newConstellationPK(long id) {
        return new ConstellationPK(id);
    }

    /**
     * get all Constellation objects from database
     * @return ArrayList of Constellation objects
     * @throws DBException
     */
    public ArrayList getConstellations() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Constellation.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Constellation for primary key
     * @param constellationPK: Constellation primary key
     * @return Constellation object
     * @throws DBException
     */
    public Constellation getConstellation(IConstellationPK constellationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Constellation)super.getEntity((ConstellationPK)constellationPK);
        } else return null;
    }

    public ArrayList searchconstellations(IConstellationsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchconstellations(IConstellationsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search constellation in database for constellationPK:
     * @param constellationPK: Constellation Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getConstellationExists(IConstellationPK constellationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((ConstellationPK)constellationPK);
        } else return false;
    }

    /**
     * try to insert Constellation in database
     * @param film: Constellation object
     * @throws DBException
     */
    public void insertConstellation(IConstellation constellation) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(constellation);
        }
    }

    /**
     * check if ConstellationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Constellation object
     * @throws DBException
     */
    public void insertupdateConstellation(IConstellation constellation) throws DBException, DataException {
        if(this.getConstellationExists(constellation.getPrimaryKey())) {
            super.updateEntity(constellation);
        } else {
            super.insertEntity(constellation);
        }
    }

    /**
     * try to update Constellation in database
     * @param film: Constellation object
     * @throws DBException
     */
    public void updateConstellation(IConstellation constellation) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(constellation);
        }
    }

    /**
     * try to delete Constellation in database
     * @param film: Constellation object
     * @throws DBException
     */
    public void deleteConstellation(IConstellation constellation) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteConstellation(constellation.getOwnerobject(), constellation.getPrimaryKey());
            super.deleteEntity(constellation);
        }
    }

    /**
     * check data rules in Constellation, throw DataException with customized message if rules do not apply
     * @param film: Constellation object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IConstellation constellation) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(constellation.getName()!=null && constellation.getName().length()>IConstellation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IConstellation.SIZE_NAME + "\n");
        }
        if(constellation.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where constellationPK is used in a primary key
     * @param constellationPK: Constellation primary key
     */
    public void cascadedeleteConstellation(String senderobject, IConstellationPK constellationPK) {
        BLconstellation_neighbour blconstellation_neighbourNeighbour = new BLconstellation_neighbour(this);
        blconstellation_neighbourNeighbour.delete4constellationNeighbour(senderobject, constellationPK);
        BLconstellation_neighbour blconstellation_neighbourConstellation = new BLconstellation_neighbour(this);
        blconstellation_neighbourConstellation.delete4constellationConstellation(senderobject, constellationPK);
    }

    /**
     * @param regionPK: foreign key for Region
     * @delete all Constellation Entity objects for Region in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4region(String senderobject, IRegionPK regionPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Constellation.SQLDelete4region, regionPK.getKeyFields());
        }
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Constellation Entity objects for Region
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getConstellations4region(IRegionPK regionPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Constellation.SQLSelect4region, regionPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param constellation_neighbourPK: parent Constellation_neighbour for child object Constellation Entity
     * @return child Constellation Entity object
     * @throws eve.general.exception.CustomException
     */
    public IConstellation getConstellation_neighbourneighbour(IConstellation_neighbourPK constellation_neighbourPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            ConstellationPK constellationPK = new ConstellationPK(constellation_neighbourPK.getNeighbour());
            return this.getConstellation(constellationPK);
        } else return null;
    }

    /**
     * @param constellation_neighbourPK: parent Constellation_neighbour for child object Constellation Entity
     * @return child Constellation Entity object
     * @throws eve.general.exception.CustomException
     */
    public IConstellation getConstellation_neighbourconstellation(IConstellation_neighbourPK constellation_neighbourPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            ConstellationPK constellationPK = new ConstellationPK(constellation_neighbourPK.getConstellation());
            return this.getConstellation(constellationPK);
        } else return null;
    }


    /**
     * get all Constellation objects for sqlparameters
     * @return ArrayList of Constellation objects
     * @throws DBException
     */
    public ArrayList getConstellations(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Constellation.SQLSelect;
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
     * delete all Constellation objects for sqlparameters
     * @throws DBException
     */
    public void delConstellation(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Constellation.table;
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
