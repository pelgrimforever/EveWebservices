/*
 * Bstargate.java
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
import eve.conversion.json.JSONStargate;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStargatesearch;
import eve.logicentity.Stargate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bstargate
 *
 * Superclass for manipulating data- and database objects
 * for Entity Stargate and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bstargate extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Stargate as default Entity
     */
    public Bstargate() {
        super(new SQLMapper_pgsql(connectionpool, "Stargate"), new Stargate());
    }

    /**
     * Constructor, sets Stargate as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstargate(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Stargate());
    }

    /**
     * Map ResultSet Field values to Stargate
     * @param dbresult: Database ResultSet
     */
    public Stargate mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StargatePK stargatePK = null;
        Stargate stargate;
        if(dbresult==null) {
            stargate = new Stargate(stargatePK);
        } else {
            try {
                stargatePK = new StargatePK(dbresult.getLong("id"));
                stargate = new Stargate(stargatePK);
                stargate.initSystemsystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) stargate.setSystemsystemPK(null);                
                stargate.initSystemto_systemPK(new SystemPK(dbresult.getLong("to_system")));
                if(dbresult.wasNull()) stargate.setSystemto_systemPK(null);                
                stargate.initTo_stargate(dbresult.getLong("to_stargate"));
                stargate.initName(dbresult.getString("name"));
                stargate.initX(dbresult.getDouble("x"));
                stargate.initY(dbresult.getDouble("y"));
                stargate.initZ(dbresult.getDouble("z"));
                stargate.initIsconstellationborder(dbresult.getBoolean("isconstellationborder"));
                stargate.initIsregionborder(dbresult.getBoolean("isregionborder"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, stargate);
        return stargate;
    }

    /**
     * create new empty Stargate object
     * @return empty IStargate
     */
    public IStargate newStargate() {
    	return new Stargate();
    }
    
    /**
     * create new empty Stargate object
     * create new primary key with given parameters
     * @return IStargate with primary key
     */
    public IStargate newStargate(long id) {
        return new Stargate(id);
    }

    /**
     * create new empty Stargate object with given primary key
     * @param stargatePK: primary key for Stargate
     * @return IStargate with primary key
     */
    public IStargate newStargate(IStargatePK stargatePK) {
        return new Stargate((StargatePK)stargatePK);
    }

    /**
     * create new empty primary key
     * @return empty StargatePK
     */
    public IStargatePK newStargatePK() {
        return new StargatePK();
    }

    /**
     * create new primary key with given parameters
     * @return new IStargatePK
     */
    public IStargatePK newStargatePK(long id) {
        return new StargatePK(id);
    }

    /**
     * get all Stargate objects from database
     * @return ArrayList of Stargate objects
     * @throws DBException
     */
    public ArrayList getStargates() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Stargate.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Stargate for primary key
     * @param stargatePK: Stargate primary key
     * @return Stargate object
     * @throws DBException
     */
    public Stargate getStargate(IStargatePK stargatePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Stargate)super.getEntity((StargatePK)stargatePK);
        } else return null;
    }

    public ArrayList searchstargates(IStargatesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchstargates(IStargatesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search stargate in database for stargatePK:
     * @param stargatePK: Stargate Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStargateExists(IStargatePK stargatePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((StargatePK)stargatePK);
        } else return false;
    }

    /**
     * try to insert Stargate in database
     * @param film: Stargate object
     * @throws DBException
     */
    public void insertStargate(IStargate stargate) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(stargate);
        }
    }

    /**
     * check if StargatePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Stargate object
     * @throws DBException
     */
    public void insertupdateStargate(IStargate stargate) throws DBException, DataException {
        if(this.getStargateExists(stargate.getPrimaryKey())) {
            super.updateEntity(stargate);
        } else {
            super.insertEntity(stargate);
        }
    }

    /**
     * try to update Stargate in database
     * @param film: Stargate object
     * @throws DBException
     */
    public void updateStargate(IStargate stargate) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(stargate);
        }
    }

    /**
     * try to delete Stargate in database
     * @param film: Stargate object
     * @throws DBException
     */
    public void deleteStargate(IStargate stargate) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteStargate(stargate.getOwnerobject(), stargate.getPrimaryKey());
            super.deleteEntity(stargate);
        }
    }

    /**
     * check data rules in Stargate, throw DataException with customized message if rules do not apply
     * @param film: Stargate object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IStargate stargate) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key


        if(stargate.getName()!=null && stargate.getName().length()>IStargate.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IStargate.SIZE_NAME + "\n");
        }
        if(stargate.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where stargatePK is used in a primary key
     * @param stargatePK: Stargate primary key
     */
    public void cascadedeleteStargate(String senderobject, IStargatePK stargatePK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Stargate Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4systemSystem(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Stargate.SQLDelete4systemSystem, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Stargate Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStargates4systemSystem(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Stargate.SQLSelect4systemSystem, systemPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Stargate Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4systemTo_system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Stargate.SQLDelete4systemTo_system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Stargate Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStargates4systemTo_system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Stargate.SQLSelect4systemTo_system, systemPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Stargate objects for sqlparameters
     * @return ArrayList of Stargate objects
     * @throws DBException
     */
    public ArrayList getStargates(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Stargate.SQLSelect;
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
     * delete all Stargate objects for sqlparameters
     * @throws DBException
     */
    public void delStargate(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Stargate.table;
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
