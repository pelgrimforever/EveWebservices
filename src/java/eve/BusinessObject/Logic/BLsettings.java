/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 14:40
 */

package eve.BusinessObject.Logic;

import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.ISettings;
import eve.logicentity.Settings;
import eve.BusinessObject.table.Bsettings;
import eve.entity.pk.SettingsPK;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLsettings extends Bsettings {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLsettings(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLsettings(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
    
    public ArrayList<Settings> getDefaultSettings(SQLTqueue transactionqueue) throws DBException, DataException {
        ArrayList<Settings> settings = new ArrayList<>();
        Settings setting;
        SettingsPK settingsPK;
        for(Object[] defaultsetting: ISettings.DEFAULTS) {
            settingsPK = new SettingsPK((String)defaultsetting[0]);
            setting = this.getSettings(settingsPK);
            if(setting==null) {
                setting = new Settings(settingsPK);
                setting.setValue((String)defaultsetting[1]);
                this.insertSettings(transactionqueue, setting);
            }
            settings.add(setting);
        }
        return settings;
    }
    
}
