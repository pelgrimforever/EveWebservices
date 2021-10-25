/*
 * Balliance.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
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
import eve.conversion.json.JSONAlliance;
import eve.conversion.entity.EMalliance;
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
public abstract class Balliance extends BLtable {

    /**
     * Constructor, sets Alliance as default Entity
     */
    public Balliance() {
        super(new Alliance(), new EMalliance());
    }

    /**
     * Constructor, sets Alliance as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Balliance(BLtable transactionobject) {
        super(transactionobject, new Alliance(), new EMalliance());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Alliance> getAlliances() throws DBException {
        return (ArrayList<Alliance>)super.getEntities(EMalliance.SQLSelectAll);
    }

    /**
     * search Alliance for primary key
     * @param alliancePK: Alliance primary key
     * @return Alliance object
     * @throws DBException
     */
    public Alliance getAlliance(IAlliancePK alliancePK) throws DBException {
        return (Alliance)super.getEntity((AlliancePK)alliancePK);
    }

    /**
     * search alliance with IAlliancesearch parameters
     * @param search IAlliancesearch
     * @return ArrayList of Alliance
     * @throws DBException 
     */
    public ArrayList<Alliance> searchalliances(IAlliancesearch search) throws DBException {
        return (ArrayList<Alliance>)this.search(search);
    }

    /**
     * search alliance with IAlliancesearch parameters, order by orderby sql clause
     * @param search IAlliancesearch
     * @param orderby sql order by string
     * @return ArrayList of Alliance
     * @throws DBException 
     */
    public ArrayList<Alliance> searchalliances(IAlliancesearch search, String orderby) throws DBException {
        return (ArrayList<Alliance>)this.search(search, orderby);
    }

    /**
     * Search alliance in database for alliancePK:
     * @param alliancePK: Alliance Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getAllianceExists(IAlliancePK alliancePK) throws DBException {
        return super.getEntityExists((AlliancePK)alliancePK);
    }

    /**
     * try to insert Alliance in database
     * @param alliance Alliance object
     * @throws DBException
     * @throws DataException
     */
    public void insertAlliance(IAlliance alliance) throws DBException, DataException {
        super.insertEntity(alliance);
    }

    /**
     * check if AlliancePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param alliance Alliance object
     * @throws DBException
     * @throws DataException
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
     * @param alliance Alliance object
     * @throws DBException
     * @throws DataException
     */
    public void updateAlliance(IAlliance alliance) throws DBException, DataException {
        super.updateEntity(alliance);
    }

    /**
     * try to delete Alliance in database
     * @param alliance Alliance object
     * @throws DBException
     */
    public void deleteAlliance(IAlliance alliance) throws DBException {
        cascadedeleteAlliance(alliance.getPrimaryKey());
        super.deleteEntity(alliance);
    }

    /**
     * check data rules in Alliance, throw DataException with customized message if rules do not apply
     * @param alliance Alliance object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IAlliance alliance) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(alliance.getName()!=null && alliance.getName().length()>IAlliance.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IAlliance.SIZE_NAME).append("\n");
        }
        if(alliance.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(alliance.getDate_founded()==null) {
            message.append("Date_founded mag niet leeg zijn.\n");
        }
        if(alliance.getTicker()!=null && alliance.getTicker().length()>IAlliance.SIZE_TICKER) {
            message.append("Ticker is langer dan toegestaan. Max aantal karakters: ").append(IAlliance.SIZE_TICKER).append("\n");
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
    public void cascadedeleteAlliance(IAlliancePK alliancePK) {
    }

    /**
     * @param corporationPK: foreign key for Corporation
     * @delete all Alliance Entity objects for Corporation in database
     */
    public void delete4corporationCreator_corporation(ICorporationPK corporationPK) {
        super.addStatement(EMalliance.SQLDelete4corporationCreator_corporation, corporationPK.getSQLprimarykey());
    }

    /**
     * @param corporationPK: foreign key for Corporation
     * @return all Alliance Entity objects for Corporation
     * @throws CustomException
     */
    public ArrayList<Alliance> getAlliances4corporationCreator_corporation(ICorporationPK corporationPK) throws CustomException {
        return super.getEntities(EMalliance.SQLSelect4corporationCreator_corporation, corporationPK.getSQLprimarykey());
    }
    /**
     * @param corporationPK: foreign key for Corporation
     * @delete all Alliance Entity objects for Corporation in database
     */
    public void delete4corporationExecutor_corporation(ICorporationPK corporationPK) {
        super.addStatement(EMalliance.SQLDelete4corporationExecutor_corporation, corporationPK.getSQLprimarykey());
    }

    /**
     * @param corporationPK: foreign key for Corporation
     * @return all Alliance Entity objects for Corporation
     * @throws CustomException
     */
    public ArrayList<Alliance> getAlliances4corporationExecutor_corporation(ICorporationPK corporationPK) throws CustomException {
        return super.getEntities(EMalliance.SQLSelect4corporationExecutor_corporation, corporationPK.getSQLprimarykey());
    }

    /**
     * get all Alliance objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Alliance objects
     * @throws DBException
     */
    public ArrayList<Alliance> getAlliances(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMalliance.SQLSelect);
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
        return (ArrayList<Alliance>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Alliance objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delAlliance(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Alliance.table);
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
