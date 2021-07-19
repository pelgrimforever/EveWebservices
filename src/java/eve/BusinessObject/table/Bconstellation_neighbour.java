/*
 * Bconstellation_neighbour.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.6.2021 14:35
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
import eve.conversion.json.JSONConstellation_neighbour;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.logicentity.Constellation_neighbour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bconstellation_neighbour
 *
 * Superclass for manipulating data- and database objects
 * for Entity Constellation_neighbour and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bconstellation_neighbour extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Constellation_neighbour as default Entity
     */
    public Bconstellation_neighbour() {
        super(new SQLMapper_pgsql(connectionpool, "Constellation_neighbour"), new Constellation_neighbour());
    }

    /**
     * Constructor, sets Constellation_neighbour as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bconstellation_neighbour(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Constellation_neighbour());
    }

    /**
     * Map ResultSet Field values to Constellation_neighbour
     * @param dbresult: Database ResultSet
     */
    public Constellation_neighbour mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Constellation_neighbourPK constellation_neighbourPK = null;
        Constellation_neighbour constellation_neighbour;
        if(dbresult==null) {
            constellation_neighbour = new Constellation_neighbour(constellation_neighbourPK);
        } else {
            try {
                constellation_neighbourPK = new Constellation_neighbourPK(dbresult.getLong("constellation"), dbresult.getLong("neighbour"));
                constellation_neighbour = new Constellation_neighbour(constellation_neighbourPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, constellation_neighbour);
        return constellation_neighbour;
    }

    /**
     * create new empty Constellation_neighbour object
     * @return empty IConstellation_neighbour
     */
    public IConstellation_neighbour newConstellation_neighbour() {
    	return new Constellation_neighbour();
    }
    
    /**
     * create new empty Constellation_neighbour object
     * create new primary key with given parameters
     * @return IConstellation_neighbour with primary key
     */
    public IConstellation_neighbour newConstellation_neighbour(long constellation, long neighbour) {
        return new Constellation_neighbour(constellation, neighbour);
    }

    /**
     * create new empty Constellation_neighbour object with given primary key
     * @param constellation_neighbourPK: primary key for Constellation_neighbour
     * @return IConstellation_neighbour with primary key
     */
    public IConstellation_neighbour newConstellation_neighbour(IConstellation_neighbourPK constellation_neighbourPK) {
        return new Constellation_neighbour((Constellation_neighbourPK)constellation_neighbourPK);
    }

    /**
     * create new empty primary key
     * @return empty Constellation_neighbourPK
     */
    public IConstellation_neighbourPK newConstellation_neighbourPK() {
        return new Constellation_neighbourPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IConstellation_neighbourPK
     */
    public IConstellation_neighbourPK newConstellation_neighbourPK(long constellation, long neighbour) {
        return new Constellation_neighbourPK(constellation, neighbour);
    }

    /**
     * get all Constellation_neighbour objects from database
     * @return ArrayList of Constellation_neighbour objects
     * @throws DBException
     */
    public ArrayList getConstellation_neighbours() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Constellation_neighbour.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Constellation_neighbour for primary key
     * @param constellation_neighbourPK: Constellation_neighbour primary key
     * @return Constellation_neighbour object
     * @throws DBException
     */
    public Constellation_neighbour getConstellation_neighbour(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Constellation_neighbour)super.getEntity((Constellation_neighbourPK)constellation_neighbourPK);
        } else return null;
    }

    public ArrayList searchconstellation_neighbours(IConstellation_neighboursearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchconstellation_neighbours(IConstellation_neighboursearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search constellation_neighbour in database for constellation_neighbourPK:
     * @param constellation_neighbourPK: Constellation_neighbour Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getConstellation_neighbourExists(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Constellation_neighbourPK)constellation_neighbourPK);
        } else return false;
    }

    /**
     * try to insert Constellation_neighbour in database
     * @param film: Constellation_neighbour object
     * @throws DBException
     */
    public void insertConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(constellation_neighbour);
        }
    }

    /**
     * check if Constellation_neighbourPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Constellation_neighbour object
     * @throws DBException
     */
    public void insertupdateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        if(this.getConstellation_neighbourExists(constellation_neighbour.getPrimaryKey())) {
            super.updateEntity(constellation_neighbour);
        } else {
            super.insertEntity(constellation_neighbour);
        }
    }

    /**
     * try to update Constellation_neighbour in database
     * @param film: Constellation_neighbour object
     * @throws DBException
     */
    public void updateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(constellation_neighbour);
        }
    }

    /**
     * try to delete Constellation_neighbour in database
     * @param film: Constellation_neighbour object
     * @throws DBException
     */
    public void deleteConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteConstellation_neighbour(constellation_neighbour.getOwnerobject(), constellation_neighbour.getPrimaryKey());
            super.deleteEntity(constellation_neighbour);
        }
    }

    /**
     * check data rules in Constellation_neighbour, throw DataException with customized message if rules do not apply
     * @param film: Constellation_neighbour object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IConstellation_neighbour constellation_neighbour) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Constellation_neighbour.Constellation - Constellation.Id
        //foreign key Constellation_neighbour.Neighbour - Constellation.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where constellation_neighbourPK is used in a primary key
     * @param constellation_neighbourPK: Constellation_neighbour primary key
     */
    public void cascadedeleteConstellation_neighbour(String senderobject, IConstellation_neighbourPK constellation_neighbourPK) {
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @delete all Constellation_neighbour Entity objects for Constellation in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4constellationNeighbour(String senderobject, IConstellationPK constellationPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Constellation_neighbour.SQLDelete4constellationNeighbour, constellationPK.getKeyFields());
        }
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @return all Constellation_neighbour Entity objects for Constellation
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getConstellation_neighbours4constellationNeighbour(IConstellationPK constellationPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Constellation_neighbour.SQLSelect4constellationNeighbour, constellationPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param constellationPK: foreign key for Constellation
     * @delete all Constellation_neighbour Entity objects for Constellation in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4constellationConstellation(String senderobject, IConstellationPK constellationPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Constellation_neighbour.SQLDelete4constellationConstellation, constellationPK.getKeyFields());
        }
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @return all Constellation_neighbour Entity objects for Constellation
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getConstellation_neighbours4constellationConstellation(IConstellationPK constellationPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Constellation_neighbour.SQLSelect4constellationConstellation, constellationPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Constellation_neighbour objects for sqlparameters
     * @return ArrayList of Constellation_neighbour objects
     * @throws DBException
     */
    public ArrayList getConstellation_neighbours(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Constellation_neighbour.SQLSelect;
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
     * delete all Constellation_neighbour objects for sqlparameters
     * @throws DBException
     */
    public void delConstellation_neighbour(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Constellation_neighbour.table;
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
