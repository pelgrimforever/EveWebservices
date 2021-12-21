/*
 * Bfaction.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
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
import eve.conversion.json.JSONFaction;
import eve.conversion.entity.EMfaction;
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
public abstract class Bfaction extends BLtable {

    /**
     * Constructor, sets Faction as default Entity
     */
    public Bfaction() {
        super(new Faction(), new EMfaction());
    }

    /**
     * Constructor, sets Faction as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfaction(BLtable transactionobject) {
        super(transactionobject, new Faction(), new EMfaction());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Faction> getFactions() throws DBException {
        return (ArrayList<Faction>)super.getEntities(EMfaction.SQLSelectAll);
    }

    /**
     * search Faction for primary key
     * @param factionPK: Faction primary key
     * @return Faction object
     * @throws DBException
     */
    public Faction getFaction(IFactionPK factionPK) throws DBException {
        return (Faction)super.getEntity((FactionPK)factionPK);
    }

    /**
     * search faction with IFactionsearch parameters
     * @param search IFactionsearch
     * @return ArrayList of Faction
     * @throws DBException 
     */
    public ArrayList<Faction> searchfactions(IFactionsearch search) throws DBException {
        return (ArrayList<Faction>)this.search(search);
    }

    /**
     * search faction with IFactionsearch parameters, order by orderby sql clause
     * @param search IFactionsearch
     * @param orderby sql order by string
     * @return ArrayList of Faction
     * @throws DBException 
     */
    public ArrayList<Faction> searchfactions(IFactionsearch search, String orderby) throws DBException {
        return (ArrayList<Faction>)this.search(search, orderby);
    }

    /**
     * Search faction in database for factionPK:
     * @param factionPK: Faction Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFactionExists(IFactionPK factionPK) throws DBException {
        return super.getEntityExists((FactionPK)factionPK);
    }

    /**
     * try to insert Faction in database
     * @param faction Faction object
     * @throws DBException
     * @throws DataException
     */
    public void insertFaction(IFaction faction) throws DBException, DataException {
        super.insertEntity(faction);
    }

    /**
     * check if FactionPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param faction Faction object
     * @throws DBException
     * @throws DataException
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
     * @param faction Faction object
     * @throws DBException
     * @throws DataException
     */
    public void updateFaction(IFaction faction) throws DBException, DataException {
        super.updateEntity(faction);
    }

    /**
     * try to delete Faction in database
     * @param faction Faction object
     * @throws DBException
     */
    public void deleteFaction(IFaction faction) throws DBException {
        cascadedeleteFaction(faction.getPrimaryKey());
        super.deleteEntity(faction);
    }

    /**
     * check data rules in Faction, throw DataException with customized message if rules do not apply
     * @param faction Faction object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFaction faction) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(faction.getName()!=null && faction.getName().length()>IFaction.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IFaction.SIZE_NAME).append("\n");
        }
        if(faction.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(faction.getDescription()!=null && faction.getDescription().length()>IFaction.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IFaction.SIZE_DESCRIPTION).append("\n");
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
    public void cascadedeleteFaction(IFactionPK factionPK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Faction Entity objects for System in database
     */
    public void delete4system(ISystemPK systemPK) {
        super.addStatement(EMfaction.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Faction Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Faction> getFactions4system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMfaction.SQLSelect4system, systemPK.getSQLprimarykey());
    }

    /**
     * get all Faction objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Faction objects
     * @throws DBException
     */
    public ArrayList<Faction> getFactions(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfaction.SQLSelect);
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
        return (ArrayList<Faction>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Faction objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delFaction(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Faction.table);
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
