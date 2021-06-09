/*
 * Brace.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.5.2021 19:33
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
import eve.conversion.json.JSONRace;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRacesearch;
import eve.logicentity.Race;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Brace
 *
 * Superclass for manipulating data- and database objects
 * for Entity Race and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Brace extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Race as default Entity
     */
    public Brace() {
        super(new SQLMapper_pgsql(connectionpool, "Race"), new Race());
    }

    /**
     * Constructor, sets Race as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Brace(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Race());
    }

    /**
     * Map ResultSet Field values to Race
     * @param dbresult: Database ResultSet
     */
    public Race mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RacePK racePK = null;
        Race race;
        if(dbresult==null) {
            race = new Race(racePK);
        } else {
            try {
                racePK = new RacePK(dbresult.getLong("id"));
                race = new Race(racePK);
                race.initFactionPK(new FactionPK(dbresult.getLong("faction")));
                if(dbresult.wasNull()) race.setFactionPK(null);                
                race.initName(dbresult.getString("name"));
                race.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, race);
        return race;
    }

    /**
     * create new empty Race object
     * @return empty IRace
     */
    public IRace newRace() {
    	return new Race();
    }
    
    /**
     * create new empty Race object
     * create new primary key with given parameters
     * @return IRace with primary key
     */
    public IRace newRace(long id) {
        return new Race(id);
    }

    /**
     * create new empty Race object with given primary key
     * @param racePK: primary key for Race
     * @return IRace with primary key
     */
    public IRace newRace(IRacePK racePK) {
        return new Race((RacePK)racePK);
    }

    /**
     * create new empty primary key
     * @return empty RacePK
     */
    public IRacePK newRacePK() {
        return new RacePK();
    }

    /**
     * create new primary key with given parameters
     * @return new IRacePK
     */
    public IRacePK newRacePK(long id) {
        return new RacePK(id);
    }

    /**
     * get all Race objects from database
     * @return ArrayList of Race objects
     * @throws DBException
     */
    public ArrayList getRaces() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Race.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Race for primary key
     * @param racePK: Race primary key
     * @return Race object
     * @throws DBException
     */
    public Race getRace(IRacePK racePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Race)super.getEntity((RacePK)racePK);
        } else return null;
    }

    public ArrayList searchraces(IRacesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchraces(IRacesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search race in database for racePK:
     * @param racePK: Race Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRaceExists(IRacePK racePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((RacePK)racePK);
        } else return false;
    }

    /**
     * try to insert Race in database
     * @param film: Race object
     * @throws DBException
     */
    public void insertRace(IRace race) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(race);
        }
    }

    /**
     * check if RacePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Race object
     * @throws DBException
     */
    public void insertupdateRace(IRace race) throws DBException, DataException {
        if(this.getRaceExists(race.getPrimaryKey())) {
            super.updateEntity(race);
        } else {
            super.insertEntity(race);
        }
    }

    /**
     * try to update Race in database
     * @param film: Race object
     * @throws DBException
     */
    public void updateRace(IRace race) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(race);
        }
    }

    /**
     * try to delete Race in database
     * @param film: Race object
     * @throws DBException
     */
    public void deleteRace(IRace race) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteRace(race.getOwnerobject(), race.getPrimaryKey());
            super.deleteEntity(race);
        }
    }

    /**
     * check data rules in Race, throw DataException with customized message if rules do not apply
     * @param film: Race object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRace race) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(race.getName()!=null && race.getName().length()>IRace.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IRace.SIZE_NAME + "\n");
        }
        if(race.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(race.getDescription()!=null && race.getDescription().length()>IRace.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + IRace.SIZE_DESCRIPTION + "\n");
        }
        if(race.getDescription()==null) {
            message.append("Description mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where racePK is used in a primary key
     * @param racePK: Race primary key
     */
    public void cascadedeleteRace(String senderobject, IRacePK racePK) {
    }

    /**
     * @param factionPK: foreign key for Faction
     * @delete all Race Entity objects for Faction in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4faction(String senderobject, IFactionPK factionPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Race.SQLDelete4faction, factionPK.getKeyFields());
        }
    }

    /**
     * @param factionPK: foreign key for Faction
     * @return all Race Entity objects for Faction
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getRaces4faction(IFactionPK factionPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Race.SQLSelect4faction, factionPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Race objects for sqlparameters
     * @return ArrayList of Race objects
     * @throws DBException
     */
    public ArrayList getRaces(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Race.SQLSelect;
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
     * delete all Race objects for sqlparameters
     * @throws DBException
     */
    public void delRace(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Race.table;
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
