/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 14:57
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.IUsersettings;
import eve.logicentity.Usersettings;
import eve.BusinessObject.table.Busersettings;
import eve.entity.pk.UsersettingsPK;
import eve.logicentity.Settings;
import eve.usecases.Settings_usecases;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLusersettings extends Busersettings {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLusersettings(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLusersettings(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }


    public ArrayList<Usersettings> get_or_initialize_Usersettings(SQLTqueue transactionqueue, String username) throws DBException, DataException {
        Settings_usecases settings_usecases = new Settings_usecases();
        ArrayList<Settings> defaultsettings = settings_usecases.getDefaultSettings();
        ArrayList<Usersettings> usersettings = new ArrayList<>();
        UsersettingsPK usersettingsPK;
        Usersettings usersetting;
        for(Settings defaultsetting: defaultsettings) {
            usersettingsPK = new UsersettingsPK(username, defaultsetting.getPrimaryKey().getName());
            usersetting = this.getUsersettings(usersettingsPK);
            if(usersetting==null) {
                usersetting = new Usersettings(usersettingsPK);
                usersetting.setValue(defaultsetting.getValue());
                this.insertUsersettings(transactionqueue, usersetting);
            }
            usersettings.add(usersetting);
        }
        return usersettings;
    }
    
    public Usersettings getUsersetting(ArrayList<Usersettings> usersettings, String settingsconstant) {
        Usersettings setting = null;
        for(Usersettings usersetting: usersettings) {
            if(usersetting.getPrimaryKey().getSettingsPK().getName().equals(settingsconstant)) {
                setting = usersetting;
            }
        }
        return setting;
    }
    
    @Override
    public void updateUsersettings(SQLTqueue transactionqueue, IUsersettings usersettings) throws DBException, DataException {
        super.insertupdateUsersettings(transactionqueue, usersettings);
    }
    
}
