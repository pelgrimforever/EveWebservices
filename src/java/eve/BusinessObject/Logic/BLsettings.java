/*
 * BLsettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 14:40
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.ISettings;
import eve.logicentity.Settings;
import eve.BusinessObject.table.Bsettings;
import eve.entity.pk.SettingsPK;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsettings
 *
 * Class for manipulating data- and database objects
 * for Entity Settings and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsettings extends Bsettings {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Settings as default Entity
     */
    public BLsettings() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Settings as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsettings(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }
    
    /**
     * get default settings from database,
     * if they are not in database, create these with default values from ISettings
     * @return default settings
     * @throws DBException
     * @throws DataException 
     */
    public ArrayList<Settings> getDefaultSettings() throws DBException, DataException {
        ArrayList<Settings> settings = new ArrayList<>();
        Settings setting;
        SettingsPK settingsPK;
        for(Object[] defaultsetting: ISettings.DEFAULTS) {
            settingsPK = new SettingsPK((String)defaultsetting[0]);
            setting = this.getSettings(settingsPK);
            if(setting==null) {
                setting = new Settings(settingsPK);
                setting.setValue((Double)defaultsetting[1]);
                this.insertSettings(setting);
            }
            settings.add(setting);
        }
        this.Commit2DB();
        return settings;
    }
    
    /**
     * try to insert Settings object in database
     * commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSettings(ISettings settings) throws DBException, DataException {
        trans_insertSettings(settings);
        super.Commit2DB();
    }
    
    /**
     * try to insert Settings object in database
     * an alternative to insertSettings, which can be made an empty function
     * commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSettings(ISettings settings) throws DBException, DataException {
        trans_insertSettings(settings);
        super.Commit2DB();
    }
    
    /**
     * try to update Settings object in database
     * commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSettings(ISettings settings) throws DBException, DataException {
        trans_updateSettings(settings);
        super.Commit2DB();
    }
    
    /**
     * try to update Settings object in database
     * an alternative to updateSettings, which can be made an empty function
     * commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSettings(ISettings settings) throws DBException, DataException {
        trans_updateSettings(settings);
        super.Commit2DB();
    }
    
    /**
     * try to delete Settings object in database
     * commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSettings(ISettings settings) throws DBException {
        trans_deleteSettings(settings);
        super.Commit2DB();
    }

    /**
     * try to delete Settings object in database
     * an alternative to deleteSettings, which can be made an empty function
     * commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSettings(ISettings settings) throws DBException {
        trans_deleteSettings(settings);
        super.Commit2DB();
    }

    /**
     * try to insert Settings object in database
     * do not commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSettings(ISettings settings) throws DBException, DataException {
        super.checkDATA(settings);
        super.insertSettings((Settings)settings);
    }
    
    /**
     * try to update Settings object in database
     * do not commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSettings(ISettings settings) throws DBException, DataException {
        super.checkDATA(settings);
        super.updateSettings((Settings)settings);
    }
    
    /**
     * try to delete Settings object in database
     * do not commit transaction
     * @param settings: Settings Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSettings(ISettings settings) throws DBException {
        super.deleteSettings((Settings)settings);
    }
}
