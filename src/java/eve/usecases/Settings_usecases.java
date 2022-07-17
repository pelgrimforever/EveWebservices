/*
 * Generated on 17.6.2022 13:4
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Settings;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Settings_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsettings blsettings = new BLsettings(sqlreader);
    
    public Settings_usecases() {
        this(false);
    }
    
    public Settings_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsettings.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Settings> getDefaultSettings() throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        ArrayList<Settings> defaultsettings = blsettings.getDefaultSettings(tq);
        sqlwriter.Commit2DB(tq);
        return defaultsettings;
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsettings.count();
    }
    
    public ArrayList<Settings> get_all() throws DBException {
        return blsettings.getSettingss();
    }
    
    public boolean getSettingsExists(ISettingsPK settingsPK) throws DBException {
        return blsettings.getSettingsExists(settingsPK);
    }
    
    public Settings get_settings_by_primarykey(ISettingsPK settingsPK) throws DBException {
        return blsettings.getSettings(settingsPK);
    }

    public Settings get_settings_with_externalforeignkey_usersettings(IUsersettingsPK usersettingsPK) throws CustomException {
        return blsettings.getUsersettings(usersettingsPK);
    }
    
    public ArrayList<Settings> search_settings(ISettingssearch settingssearch) throws CustomException {
        return blsettings.search(settingssearch);
    }
    
    public long search_settings_count(ISettingssearch settingssearch) throws CustomException {
        return blsettings.searchcount(settingssearch);
    }

    public void insertSettings(ISettings settings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsettings.insertSettings(tq, settings);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSettings(ISettings settings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsettings.updateSettings(tq, settings);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSettings(ISettings settings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsettings.deleteSettings(tq, settings);
        sqlwriter.Commit2DB(tq);
    }

}

