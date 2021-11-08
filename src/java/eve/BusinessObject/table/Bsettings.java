/*
 * Bsettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
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
import eve.conversion.json.JSONSettings;
import eve.conversion.entity.EMsettings;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISettingssearch;
import eve.logicentity.Settings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsettings
 *
 * Superclass for manipulating data- and database objects
 * for Entity Settings and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsettings extends BLtable {

    /**
     * Constructor, sets Settings as default Entity
     */
    public Bsettings() {
        super(new Settings(), new EMsettings());
    }

    /**
     * Constructor, sets Settings as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsettings(BLtable transactionobject) {
        super(transactionobject, new Settings(), new EMsettings());
    }

    /**
     * create new empty Settings object
     * @return empty ISettings
     */
    public ISettings newSettings() {
    	return new Settings();
    }
    
    /**
     * create new empty Settings object
     * create new primary key with given parameters
     * @param name primary key field
     * @return ISettings with primary key
     */
    public ISettings newSettings(java.lang.String name) {
        return new Settings(name);
    }

    /**
     * create new empty Settings object with given primary key
     * @param settingsPK: primary key for Settings
     * @return ISettings with primary key
     */
    public ISettings newSettings(ISettingsPK settingsPK) {
        return new Settings((SettingsPK)settingsPK);
    }

    /**
     * create new empty primary key
     * @return empty SettingsPK
     */
    public ISettingsPK newSettingsPK() {
        return new SettingsPK();
    }

    /**
     * create new primary key with given parameters
     * @param name primary key field
     * @return new ISettingsPK
     */
    public ISettingsPK newSettingsPK(java.lang.String name) {
        return new SettingsPK(name);
    }

    /**
     * get all Settings objects from database
     * @return ArrayList of Settings objects
     * @throws DBException
     */
    public ArrayList<Settings> getSettingss() throws DBException {
        return (ArrayList<Settings>)super.getEntities(EMsettings.SQLSelectAll);
    }

    /**
     * search Settings for primary key
     * @param settingsPK: Settings primary key
     * @return Settings object
     * @throws DBException
     */
    public Settings getSettings(ISettingsPK settingsPK) throws DBException {
        return (Settings)super.getEntity((SettingsPK)settingsPK);
    }

    /**
     * search settings with ISettingssearch parameters
     * @param search ISettingssearch
     * @return ArrayList of Settings
     * @throws DBException 
     */
    public ArrayList<Settings> searchsettingss(ISettingssearch search) throws DBException {
        return (ArrayList<Settings>)this.search(search);
    }

    /**
     * search settings with ISettingssearch parameters, order by orderby sql clause
     * @param search ISettingssearch
     * @param orderby sql order by string
     * @return ArrayList of Settings
     * @throws DBException 
     */
    public ArrayList<Settings> searchsettingss(ISettingssearch search, String orderby) throws DBException {
        return (ArrayList<Settings>)this.search(search, orderby);
    }

    /**
     * Search settings in database for settingsPK:
     * @param settingsPK: Settings Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSettingsExists(ISettingsPK settingsPK) throws DBException {
        return super.getEntityExists((SettingsPK)settingsPK);
    }

    /**
     * try to insert Settings in database
     * @param settings Settings object
     * @throws DBException
     * @throws DataException
     */
    public void insertSettings(ISettings settings) throws DBException, DataException {
        super.insertEntity(settings);
    }

    /**
     * check if SettingsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param settings Settings object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSettings(ISettings settings) throws DBException, DataException {
        if(this.getSettingsExists(settings.getPrimaryKey())) {
            super.updateEntity(settings);
        } else {
            super.insertEntity(settings);
        }
    }

    /**
     * try to update Settings in database
     * @param settings Settings object
     * @throws DBException
     * @throws DataException
     */
    public void updateSettings(ISettings settings) throws DBException, DataException {
        super.updateEntity(settings);
    }

    /**
     * try to delete Settings in database
     * @param settings Settings object
     * @throws DBException
     */
    public void deleteSettings(ISettings settings) throws DBException {
        cascadedeleteSettings(settings.getPrimaryKey());
        super.deleteEntity(settings);
    }

    /**
     * check data rules in Settings, throw DataException with customized message if rules do not apply
     * @param settings Settings object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISettings settings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where settingsPK is used in a primary key
     * @param settingsPK: Settings primary key
     */
    public void cascadedeleteSettings(ISettingsPK settingsPK) {
        BLusersettings blusersettings = new BLusersettings(this);
        blusersettings.delete4settings(settingsPK);
    }

    /**
     * @param usersettingsPK: parent Usersettings for child object Settings Entity
     * @return child Settings Entity object
     * @throws CustomException
     */
    public Settings getUsersettings(IUsersettingsPK usersettingsPK) throws CustomException {
        SettingsPK settingsPK = new SettingsPK(usersettingsPK.getName());
        return this.getSettings(settingsPK);
    }


    /**
     * get all Settings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Settings objects
     * @throws DBException
     */
    public ArrayList<Settings> getSettingss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsettings.SQLSelect);
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
        return (ArrayList<Settings>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Settings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSettings(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Settings.table);
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
