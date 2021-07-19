/*
 * Balliance.java
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
import eve.conversion.json.JSONAlliance;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IAlliancesearch;
import eve.logicentity.Alliance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Balliance
 *
 * Superclass for manipulating data- and database objects
 * for Entity Alliance and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Balliance extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Alliance as default Entity
     */
    public Balliance() {
        super(new SQLMapper_pgsql(connectionpool, "Alliance"), new Alliance());
    }

    /**
     * Constructor, sets Alliance as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Balliance(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Alliance());
    }

    /**
     * Map ResultSet Field values to Alliance
     * @param dbresult: Database ResultSet
     */
    public Alliance mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        AlliancePK alliancePK = null;
        Alliance alliance;
        if(dbresult==null) {
            alliance = new Alliance(alliancePK);
        } else {
            try {
                alliancePK = new AlliancePK(dbresult.getLong("id"));
                alliance = new Alliance(alliancePK);
                alliance.initCorporationcreator_corporationPK(new CorporationPK(dbresult.getLong("creator_corporation")));
                if(dbresult.wasNull()) alliance.setCorporationcreator_corporationPK(null);                
                alliance.initCorporationexecutor_corporationPK(new CorporationPK(dbresult.getLong("executor_corporation")));
                if(dbresult.wasNull()) alliance.setCorporationexecutor_corporationPK(null);                
                alliance.initName(dbresult.getString("name"));
                alliance.initCreator(dbresult.getLong("creator"));
                alliance.initDate_founded(dbresult.getTimestamp("date_founded"));
                alliance.initTicker(dbresult.getString("ticker"));
                alliance.initFaction_id(dbresult.getLong("faction_id"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, alliance);
        return alliance;
    }

    /**
     * create new empty Alliance object
     * @return empty IAlliance
     */
    public IAlliance newAlliance() {
    	return new Alliance();
    }
    
    /**
     * create new empty Alliance object
     * create new primary key with given parameters
     * @return IAlliance with primary key
     */
    public IAlliance newAlliance(long id) {
        return new Alliance(id);
    }

    /**
     * create new empty Alliance object with given primary key
     * @param alliancePK: primary key for Alliance
     * @return IAlliance with primary key
     */
    public IAlliance newAlliance(IAlliancePK alliancePK) {
        return new Alliance((AlliancePK)alliancePK);
    }

    /**
     * create new empty primary key
     * @return empty AlliancePK
     */
    public IAlliancePK newAlliancePK() {
        return new AlliancePK();
    }

    /**
     * create new primary key with given parameters
     * @return new IAlliancePK
     */
    public IAlliancePK newAlliancePK(long id) {
        return new AlliancePK(id);
    }

    /**
     * get all Alliance objects from database
     * @return ArrayList of Alliance objects
     * @throws DBException
     */
    public ArrayList getAlliances() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Alliance.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Alliance for primary key
     * @param alliancePK: Alliance primary key
     * @return Alliance object
     * @throws DBException
     */
    public Alliance getAlliance(IAlliancePK alliancePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Alliance)super.getEntity((AlliancePK)alliancePK);
        } else return null;
    }

    public ArrayList searchalliances(IAlliancesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchalliances(IAlliancesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search alliance in database for alliancePK:
     * @param alliancePK: Alliance Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getAllianceExists(IAlliancePK alliancePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((AlliancePK)alliancePK);
        } else return false;
    }

    /**
     * try to insert Alliance in database
     * @param film: Alliance object
     * @throws DBException
     */
    public void insertAlliance(IAlliance alliance) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(alliance);
        }
    }

    /**
     * check if AlliancePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Alliance object
     * @throws DBException
     */
    public void insertupdateAlliance(IAlliance alliance) throws DBException, DataException {
        if(this.getAllianceExists(alliance.getPrimaryKey())) {
            super.updateEntity(alliance);
        } else {
            super.insertEntity(alliance);
        }
    }

    /**
     * try to update Alliance in database
     * @param film: Alliance object
     * @throws DBException
     */
    public void updateAlliance(IAlliance alliance) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(alliance);
        }
    }

    /**
     * try to delete Alliance in database
     * @param film: Alliance object
     * @throws DBException
     */
    public void deleteAlliance(IAlliance alliance) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteAlliance(alliance.getOwnerobject(), alliance.getPrimaryKey());
            super.deleteEntity(alliance);
        }
    }

    /**
     * check data rules in Alliance, throw DataException with customized message if rules do not apply
     * @param film: Alliance object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IAlliance alliance) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key


        if(alliance.getName()!=null && alliance.getName().length()>IAlliance.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IAlliance.SIZE_NAME + "\n");
        }
        if(alliance.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(alliance.getDate_founded()==null) {
            message.append("Date_founded mag niet leeg zijn.\n");
        }
        if(alliance.getTicker()!=null && alliance.getTicker().length()>IAlliance.SIZE_TICKER) {
            message.append("Ticker is langer dan toegestaan. Max aantal karakters: " + IAlliance.SIZE_TICKER + "\n");
        }
        if(alliance.getTicker()==null) {
            message.append("Ticker mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where alliancePK is used in a primary key
     * @param alliancePK: Alliance primary key
     */
    public void cascadedeleteAlliance(String senderobject, IAlliancePK alliancePK) {
    }

    /**
     * @param corporationPK: foreign key for Corporation
     * @delete all Alliance Entity objects for Corporation in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4corporationCreator_corporation(String senderobject, ICorporationPK corporationPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Alliance.SQLDelete4corporationCreator_corporation, corporationPK.getKeyFields());
        }
    }

    /**
     * @param corporationPK: foreign key for Corporation
     * @return all Alliance Entity objects for Corporation
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getAlliances4corporationCreator_corporation(ICorporationPK corporationPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Alliance.SQLSelect4corporationCreator_corporation, corporationPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param corporationPK: foreign key for Corporation
     * @delete all Alliance Entity objects for Corporation in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4corporationExecutor_corporation(String senderobject, ICorporationPK corporationPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Alliance.SQLDelete4corporationExecutor_corporation, corporationPK.getKeyFields());
        }
    }

    /**
     * @param corporationPK: foreign key for Corporation
     * @return all Alliance Entity objects for Corporation
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getAlliances4corporationExecutor_corporation(ICorporationPK corporationPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Alliance.SQLSelect4corporationExecutor_corporation, corporationPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Alliance objects for sqlparameters
     * @return ArrayList of Alliance objects
     * @throws DBException
     */
    public ArrayList getAlliances(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Alliance.SQLSelect;
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
     * delete all Alliance objects for sqlparameters
     * @throws DBException
     */
    public void delAlliance(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Alliance.table;
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
