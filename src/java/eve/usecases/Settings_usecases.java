/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Settings;
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
    private BLsettings blsettings = new BLsettings();
    
    public Settings_usecases() {
        this(false);
    }
    
    public Settings_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsettings.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsettings.count();
    }
    
    public ArrayList<Settings> get_all() throws DBException {
        return blsettings.getSettingss();
    }
    
    public boolean getSettingsExists(ISettingsPK settingsPK) throws DBException {
        return blsettings.getEntityExists(settingsPK);
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

    public void secureinsertSettings(ISettings settings) throws DBException, DataException {
        blsettings.secureinsertSettings(settings);
    }

    public void secureupdateSettings(ISettings settings) throws DBException, DataException {
        blsettings.secureupdateSettings(settings);
    }

    public void securedeleteSettings(ISettings settings) throws DBException, DataException {
        blsettings.securedeleteSettings(settings);
    }
}

