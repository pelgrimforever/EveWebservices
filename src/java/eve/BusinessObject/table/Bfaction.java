/*
 * Bfaction.java
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
import eve.conversion.json.JSONFaction;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IFactionsearch;
import eve.logicentity.Faction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bfaction
 *
 * Superclass for manipulating data- and database objects
 * for Entity Faction and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bfaction extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Faction as default Entity
     */
    public Bfaction() {
        super(new SQLMapper_pgsql(connectionpool, "Faction"), new Faction());
    }

    /**
     * Constructor, sets Faction as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfaction(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Faction());
    }

    /**
     * Map ResultSet Field values to Faction
     * @param dbresult: Database ResultSet
     */
    public Faction mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FactionPK factionPK = null;
        Faction faction;
        if(dbresult==null) {
            faction = new Faction(factionPK);
        } else {
            try {
                factionPK = new FactionPK(dbresult.getLong("id"));
                faction = new Faction(factionPK);
                faction.initSystemPK(new SystemPK(dbresult.getLong("solar_system")));
                if(dbresult.wasNull()) faction.setSystemPK(null);                
                faction.initName(dbresult.getString("name"));
                faction.initDescription(dbresult.getString("description"));
                faction.initIs_unique(dbresult.getBoolean("is_unique"));
                faction.initSize_factor(dbresult.getDouble("size_factor"));
                faction.initStation_count(dbresult.getInt("station_count"));
                faction.initStation_system_count(dbresult.getInt("station_system_count"));
                faction.initCorporation(dbresult.getLong("corporation"));
                faction.initMilitia_corporation(dbresult.getLong("militia_corporation"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, faction);
        return faction;
    }

    /**
     * create new empty Faction object
     * @return empty IFaction
     */
    public IFaction newFaction() {
    	return new Faction();
    }
    
    /**
     * create new empty Faction object
     * create new primary key with given parameters
     * @return IFaction with primary key
     */
    public IFaction newFaction(long id) {
        return new Faction(id);
    }

    /**
     * create new empty Faction object with given primary key
     * @param factionPK: primary key for Faction
     * @return IFaction with primary key
     */
    public IFaction newFaction(IFactionPK factionPK) {
        return new Faction((FactionPK)factionPK);
    }

    /**
     * create new empty primary key
     * @return empty FactionPK
     */
    public IFactionPK newFactionPK() {
        return new FactionPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IFactionPK
     */
    public IFactionPK newFactionPK(long id) {
        return new FactionPK(id);
    }

    /**
     * get all Faction objects from database
     * @return ArrayList of Faction objects
     * @throws DBException
     */
    public ArrayList getFactions() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Faction.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Faction for primary key
     * @param factionPK: Faction primary key
     * @return Faction object
     * @throws DBException
     */
    public Faction getFaction(IFactionPK factionPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Faction)super.getEntity((FactionPK)factionPK);
        } else return null;
    }

    public ArrayList searchfactions(IFactionsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchfactions(IFactionsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search faction in database for factionPK:
     * @param factionPK: Faction Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFactionExists(IFactionPK factionPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((FactionPK)factionPK);
        } else return false;
    }

    /**
     * try to insert Faction in database
     * @param film: Faction object
     * @throws DBException
     */
    public void insertFaction(IFaction faction) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(faction);
        }
    }

    /**
     * check if FactionPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Faction object
     * @throws DBException
     */
    public void insertupdateFaction(IFaction faction) throws DBException, DataException {
        if(this.getFactionExists(faction.getPrimaryKey())) {
            super.updateEntity(faction);
        } else {
            super.insertEntity(faction);
        }
    }

    /**
     * try to update Faction in database
     * @param film: Faction object
     * @throws DBException
     */
    public void updateFaction(IFaction faction) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(faction);
        }
    }

    /**
     * try to delete Faction in database
     * @param film: Faction object
     * @throws DBException
     */
    public void deleteFaction(IFaction faction) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteFaction(faction.getOwnerobject(), faction.getPrimaryKey());
            super.deleteEntity(faction);
        }
    }

    /**
     * check data rules in Faction, throw DataException with customized message if rules do not apply
     * @param film: Faction object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFaction faction) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(faction.getName()!=null && faction.getName().length()>IFaction.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IFaction.SIZE_NAME + "\n");
        }
        if(faction.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(faction.getDescription()!=null && faction.getDescription().length()>IFaction.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + IFaction.SIZE_DESCRIPTION + "\n");
        }
        if(faction.getDescription()==null) {
            message.append("Description mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where factionPK is used in a primary key
     * @param factionPK: Faction primary key
     */
    public void cascadedeleteFaction(String senderobject, IFactionPK factionPK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Faction Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Faction.SQLDelete4system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Faction Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getFactions4system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Faction.SQLSelect4system, systemPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Faction objects for sqlparameters
     * @return ArrayList of Faction objects
     * @throws DBException
     */
    public ArrayList getFactions(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Faction.SQLSelect;
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
     * delete all Faction objects for sqlparameters
     * @throws DBException
     */
    public void delFaction(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Faction.table;
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
