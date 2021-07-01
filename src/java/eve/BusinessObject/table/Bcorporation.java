/*
 * Bcorporation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.5.2021 15:39
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
import eve.conversion.json.JSONCorporation;
import eve.data.ProjectConstants;
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
public abstract class Bcorporation extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Corporation as default Entity
     */
    public Bcorporation() {
        super(new SQLMapper_pgsql(connectionpool, "Corporation"), new Corporation());
    }

    /**
     * Constructor, sets Corporation as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcorporation(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Corporation());
    }

    /**
     * Map ResultSet Field values to Corporation
     * @param dbresult: Database ResultSet
     */
    public Corporation mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CorporationPK corporationPK = null;
        Corporation corporation;
        if(dbresult==null) {
            corporation = new Corporation(corporationPK);
        } else {
            try {
                corporationPK = new CorporationPK(dbresult.getLong("id"));
                corporation = new Corporation(corporationPK);
                corporation.initStationPK(new StationPK(dbresult.getLong("home_station")));
                if(dbresult.wasNull()) corporation.setStationPK(null);                
                corporation.initFactionPK(new FactionPK(dbresult.getLong("faction")));
                if(dbresult.wasNull()) corporation.setFactionPK(null);                
                corporation.initAlliancePK(new AlliancePK(dbresult.getLong("alliance")));
                if(dbresult.wasNull()) corporation.setAlliancePK(null);                
                corporation.initName(dbresult.getString("name"));
                corporation.initCeo(dbresult.getLong("ceo"));
                corporation.initCreator(dbresult.getLong("creator"));
                corporation.initMember_count(dbresult.getInt("member_count"));
                corporation.initTax_rate(dbresult.getDouble("tax_rate"));
                corporation.initTicker(dbresult.getString("ticker"));
                corporation.initDate_founded(dbresult.getTimestamp("date_founded"));
                corporation.initDescription(dbresult.getString("description"));
                corporation.initShares(dbresult.getInt("shares"));
                corporation.initUrl(dbresult.getString("url"));
                corporation.initWar_eligible(dbresult.getBoolean("war_eligible"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, corporation);
        return corporation;
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
    public ArrayList getCorporations() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Corporation.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Corporation for primary key
     * @param corporationPK: Corporation primary key
     * @return Corporation object
     * @throws DBException
     */
    public Corporation getCorporation(ICorporationPK corporationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Corporation)super.getEntity((CorporationPK)corporationPK);
        } else return null;
    }

    public ArrayList searchcorporations(ICorporationsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchcorporations(ICorporationsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search corporation in database for corporationPK:
     * @param corporationPK: Corporation Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCorporationExists(ICorporationPK corporationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((CorporationPK)corporationPK);
        } else return false;
    }

    /**
     * try to insert Corporation in database
     * @param film: Corporation object
     * @throws DBException
     */
    public void insertCorporation(ICorporation corporation) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(corporation);
        }
    }

    /**
     * check if CorporationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Corporation object
     * @throws DBException
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
     * @param film: Corporation object
     * @throws DBException
     */
    public void updateCorporation(ICorporation corporation) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(corporation);
        }
    }

    /**
     * try to delete Corporation in database
     * @param film: Corporation object
     * @throws DBException
     */
    public void deleteCorporation(ICorporation corporation) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteCorporation(corporation.getOwnerobject(), corporation.getPrimaryKey());
            super.deleteEntity(corporation);
        }
    }

    /**
     * check data rules in Corporation, throw DataException with customized message if rules do not apply
     * @param film: Corporation object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICorporation corporation) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key



        if(corporation.getName()!=null && corporation.getName().length()>ICorporation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ICorporation.SIZE_NAME + "\n");
        }
        if(corporation.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(corporation.getTicker()!=null && corporation.getTicker().length()>ICorporation.SIZE_TICKER) {
            message.append("Ticker is langer dan toegestaan. Max aantal karakters: " + ICorporation.SIZE_TICKER + "\n");
        }
        if(corporation.getTicker()==null) {
            message.append("Ticker mag niet leeg zijn.\n");
        }
        if(corporation.getDescription()!=null && corporation.getDescription().length()>ICorporation.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + ICorporation.SIZE_DESCRIPTION + "\n");
        }
        if(corporation.getUrl()!=null && corporation.getUrl().length()>ICorporation.SIZE_URL) {
            message.append("Url is langer dan toegestaan. Max aantal karakters: " + ICorporation.SIZE_URL + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where corporationPK is used in a primary key
     * @param corporationPK: Corporation primary key
     */
    public void cascadedeleteCorporation(String senderobject, ICorporationPK corporationPK) {
    }

    /**
     * @param stationPK: foreign key for Station
     * @delete all Corporation Entity objects for Station in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4station(String senderobject, IStationPK stationPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Corporation.SQLDelete4station, stationPK.getKeyFields());
        }
    }

    /**
     * @param stationPK: foreign key for Station
     * @return all Corporation Entity objects for Station
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getCorporations4station(IStationPK stationPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Corporation.SQLSelect4station, stationPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param factionPK: foreign key for Faction
     * @delete all Corporation Entity objects for Faction in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4faction(String senderobject, IFactionPK factionPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Corporation.SQLDelete4faction, factionPK.getKeyFields());
        }
    }

    /**
     * @param factionPK: foreign key for Faction
     * @return all Corporation Entity objects for Faction
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getCorporations4faction(IFactionPK factionPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Corporation.SQLSelect4faction, factionPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param alliancePK: foreign key for Alliance
     * @delete all Corporation Entity objects for Alliance in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4alliance(String senderobject, IAlliancePK alliancePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Corporation.SQLDelete4alliance, alliancePK.getKeyFields());
        }
    }

    /**
     * @param alliancePK: foreign key for Alliance
     * @return all Corporation Entity objects for Alliance
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getCorporations4alliance(IAlliancePK alliancePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Corporation.SQLSelect4alliance, alliancePK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Corporation objects for sqlparameters
     * @return ArrayList of Corporation objects
     * @throws DBException
     */
    public ArrayList getCorporations(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Corporation.SQLSelect;
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
     * delete all Corporation objects for sqlparameters
     * @throws DBException
     */
    public void delCorporation(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Corporation.table;
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
