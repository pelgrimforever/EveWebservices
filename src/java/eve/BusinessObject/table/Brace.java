/*
 * Brace.java
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
import eve.conversion.json.JSONRace;
import eve.conversion.entity.EMrace;
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
public abstract class Brace extends BLtable {

    /**
     * Constructor, sets Race as default Entity
     */
    public Brace() {
        super(new Race(), new EMrace());
    }

    /**
     * Constructor, sets Race as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Brace(BLtable transactionobject) {
        super(transactionobject, new Race(), new EMrace());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Race> getRaces() throws DBException {
        return (ArrayList<Race>)super.getEntities(EMrace.SQLSelectAll);
    }

    /**
     * search Race for primary key
     * @param racePK: Race primary key
     * @return Race object
     * @throws DBException
     */
    public Race getRace(IRacePK racePK) throws DBException {
        return (Race)super.getEntity((RacePK)racePK);
    }

    /**
     * search race with IRacesearch parameters
     * @param search IRacesearch
     * @return ArrayList of Race
     * @throws DBException 
     */
    public ArrayList<Race> searchraces(IRacesearch search) throws DBException {
        return (ArrayList<Race>)this.search(search);
    }

    /**
     * search race with IRacesearch parameters, order by orderby sql clause
     * @param search IRacesearch
     * @param orderby sql order by string
     * @return ArrayList of Race
     * @throws DBException 
     */
    public ArrayList<Race> searchraces(IRacesearch search, String orderby) throws DBException {
        return (ArrayList<Race>)this.search(search, orderby);
    }

    /**
     * Search race in database for racePK:
     * @param racePK: Race Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRaceExists(IRacePK racePK) throws DBException {
        return super.getEntityExists((RacePK)racePK);
    }

    /**
     * try to insert Race in database
     * @param race Race object
     * @throws DBException
     * @throws DataException
     */
    public void insertRace(IRace race) throws DBException, DataException {
        super.insertEntity(race);
    }

    /**
     * check if RacePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param race Race object
     * @throws DBException
     * @throws DataException
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
     * @param race Race object
     * @throws DBException
     * @throws DataException
     */
    public void updateRace(IRace race) throws DBException, DataException {
        super.updateEntity(race);
    }

    /**
     * try to delete Race in database
     * @param race Race object
     * @throws DBException
     */
    public void deleteRace(IRace race) throws DBException {
        cascadedeleteRace(race.getPrimaryKey());
        super.deleteEntity(race);
    }

    /**
     * check data rules in Race, throw DataException with customized message if rules do not apply
     * @param race Race object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRace race) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(race.getName()!=null && race.getName().length()>IRace.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IRace.SIZE_NAME).append("\n");
        }
        if(race.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(race.getDescription()!=null && race.getDescription().length()>IRace.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IRace.SIZE_DESCRIPTION).append("\n");
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
    public void cascadedeleteRace(IRacePK racePK) {
    }

    /**
     * @param factionPK: foreign key for Faction
     * @delete all Race Entity objects for Faction in database
     */
    public void delete4faction(IFactionPK factionPK) {
        super.addStatement(EMrace.SQLDelete4faction, factionPK.getSQLprimarykey());
    }

    /**
     * @param factionPK: foreign key for Faction
     * @return all Race Entity objects for Faction
     * @throws CustomException
     */
    public ArrayList<Race> getRaces4faction(IFactionPK factionPK) throws CustomException {
        return super.getEntities(EMrace.SQLSelect4faction, factionPK.getSQLprimarykey());
    }

    /**
     * get all Race objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Race objects
     * @throws DBException
     */
    public ArrayList<Race> getRaces(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMrace.SQLSelect);
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
        return (ArrayList<Race>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Race objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delRace(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Race.table);
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
