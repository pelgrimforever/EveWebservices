/*
 * Bcorporation.java
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
import eve.conversion.json.JSONCorporation;
import eve.conversion.entity.EMcorporation;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ICorporationsearch;
import eve.logicentity.Corporation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bcorporation
 *
 * Superclass for manipulating data- and database objects
 * for Entity Corporation and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bcorporation extends BLtable {

    /**
     * Constructor, sets Corporation as default Entity
     */
    public Bcorporation() {
        super(new Corporation(), new EMcorporation());
    }

    /**
     * Constructor, sets Corporation as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcorporation(BLtable transactionobject) {
        super(transactionobject, new Corporation(), new EMcorporation());
    }

    /**
     * create new empty Corporation object
     * @return empty ICorporation
     */
    public ICorporation newCorporation() {
    	return new Corporation();
    }
    
    /**
     * create new empty Corporation object
     * create new primary key with given parameters
     * @param id primary key field
     * @return ICorporation with primary key
     */
    public ICorporation newCorporation(long id) {
        return new Corporation(id);
    }

    /**
     * create new empty Corporation object with given primary key
     * @param corporationPK: primary key for Corporation
     * @return ICorporation with primary key
     */
    public ICorporation newCorporation(ICorporationPK corporationPK) {
        return new Corporation((CorporationPK)corporationPK);
    }

    /**
     * create new empty primary key
     * @return empty CorporationPK
     */
    public ICorporationPK newCorporationPK() {
        return new CorporationPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new ICorporationPK
     */
    public ICorporationPK newCorporationPK(long id) {
        return new CorporationPK(id);
    }

    /**
     * get all Corporation objects from database
     * @return ArrayList of Corporation objects
     * @throws DBException
     */
    public ArrayList<Corporation> getCorporations() throws DBException {
        return (ArrayList<Corporation>)super.getEntities(EMcorporation.SQLSelectAll);
    }

    /**
     * search Corporation for primary key
     * @param corporationPK: Corporation primary key
     * @return Corporation object
     * @throws DBException
     */
    public Corporation getCorporation(ICorporationPK corporationPK) throws DBException {
        return (Corporation)super.getEntity((CorporationPK)corporationPK);
    }

    /**
     * search corporation with ICorporationsearch parameters
     * @param search ICorporationsearch
     * @return ArrayList of Corporation
     * @throws DBException 
     */
    public ArrayList<Corporation> searchcorporations(ICorporationsearch search) throws DBException {
        return (ArrayList<Corporation>)this.search(search);
    }

    /**
     * search corporation with ICorporationsearch parameters, order by orderby sql clause
     * @param search ICorporationsearch
     * @param orderby sql order by string
     * @return ArrayList of Corporation
     * @throws DBException 
     */
    public ArrayList<Corporation> searchcorporations(ICorporationsearch search, String orderby) throws DBException {
        return (ArrayList<Corporation>)this.search(search, orderby);
    }

    /**
     * Search corporation in database for corporationPK:
     * @param corporationPK: Corporation Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCorporationExists(ICorporationPK corporationPK) throws DBException {
        return super.getEntityExists((CorporationPK)corporationPK);
    }

    /**
     * try to insert Corporation in database
     * @param corporation Corporation object
     * @throws DBException
     * @throws DataException
     */
    public void insertCorporation(ICorporation corporation) throws DBException, DataException {
        super.insertEntity(corporation);
    }

    /**
     * check if CorporationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param corporation Corporation object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateCorporation(ICorporation corporation) throws DBException, DataException {
        if(this.getCorporationExists(corporation.getPrimaryKey())) {
            super.updateEntity(corporation);
        } else {
            super.insertEntity(corporation);
        }
    }

    /**
     * try to update Corporation in database
     * @param corporation Corporation object
     * @throws DBException
     * @throws DataException
     */
    public void updateCorporation(ICorporation corporation) throws DBException, DataException {
        super.updateEntity(corporation);
    }

    /**
     * try to delete Corporation in database
     * @param corporation Corporation object
     * @throws DBException
     */
    public void deleteCorporation(ICorporation corporation) throws DBException {
        cascadedeleteCorporation(corporation.getPrimaryKey());
        super.deleteEntity(corporation);
    }

    /**
     * check data rules in Corporation, throw DataException with customized message if rules do not apply
     * @param corporation Corporation object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICorporation corporation) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(corporation.getName()!=null && corporation.getName().length()>ICorporation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_NAME).append("\n");
        }
        if(corporation.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(corporation.getTicker()!=null && corporation.getTicker().length()>ICorporation.SIZE_TICKER) {
            message.append("Ticker is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_TICKER).append("\n");
        }
        if(corporation.getTicker()==null) {
            message.append("Ticker mag niet leeg zijn.\n");
        }
        if(corporation.getDescription()!=null && corporation.getDescription().length()>ICorporation.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_DESCRIPTION).append("\n");
        }
        if(corporation.getUrl()!=null && corporation.getUrl().length()>ICorporation.SIZE_URL) {
            message.append("Url is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_URL).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where corporationPK is used in a primary key
     * @param corporationPK: Corporation primary key
     */
    public void cascadedeleteCorporation(ICorporationPK corporationPK) {
    }

    /**
     * @param stationPK: foreign key for Station
     * @delete all Corporation Entity objects for Station in database
     */
    public void delete4station(IStationPK stationPK) {
        super.addStatement(EMcorporation.SQLDelete4station, stationPK.getSQLprimarykey());
    }

    /**
     * @param stationPK: foreign key for Station
     * @return all Corporation Entity objects for Station
     * @throws CustomException
     */
    public ArrayList<Corporation> getCorporations4station(IStationPK stationPK) throws CustomException {
        return super.getEntities(EMcorporation.SQLSelect4station, stationPK.getSQLprimarykey());
    }
    /**
     * @param factionPK: foreign key for Faction
     * @delete all Corporation Entity objects for Faction in database
     */
    public void delete4faction(IFactionPK factionPK) {
        super.addStatement(EMcorporation.SQLDelete4faction, factionPK.getSQLprimarykey());
    }

    /**
     * @param factionPK: foreign key for Faction
     * @return all Corporation Entity objects for Faction
     * @throws CustomException
     */
    public ArrayList<Corporation> getCorporations4faction(IFactionPK factionPK) throws CustomException {
        return super.getEntities(EMcorporation.SQLSelect4faction, factionPK.getSQLprimarykey());
    }
    /**
     * @param alliancePK: foreign key for Alliance
     * @delete all Corporation Entity objects for Alliance in database
     */
    public void delete4alliance(IAlliancePK alliancePK) {
        super.addStatement(EMcorporation.SQLDelete4alliance, alliancePK.getSQLprimarykey());
    }

    /**
     * @param alliancePK: foreign key for Alliance
     * @return all Corporation Entity objects for Alliance
     * @throws CustomException
     */
    public ArrayList<Corporation> getCorporations4alliance(IAlliancePK alliancePK) throws CustomException {
        return super.getEntities(EMcorporation.SQLSelect4alliance, alliancePK.getSQLprimarykey());
    }

    /**
     * get all Corporation objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Corporation objects
     * @throws DBException
     */
    public ArrayList<Corporation> getCorporations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcorporation.SQLSelect);
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
        return (ArrayList<Corporation>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Corporation objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delCorporation(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Corporation.table);
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
