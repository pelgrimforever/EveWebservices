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
import eve.logicentity.Usersettings;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Usersettings_usecases {

    private boolean loggedin = false;
    private BLusersettings blusersettings = new BLusersettings();
    
    public Usersettings_usecases() {
        this(false);
    }
    
    public Usersettings_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blusersettings.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Usersettings> get_all_4user_usecase(String username) throws DataException, DBException {
        return blusersettings.getUsersettings(username);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blusersettings.count();
    }
    
    public ArrayList<Usersettings> get_all() throws DBException {
        return blusersettings.getUsersettingss();
    }
    
    public boolean getUsersettingsExists(IUsersettingsPK usersettingsPK) throws DBException {
        return blusersettings.getEntityExists(usersettingsPK);
    }
    
    public Usersettings get_usersettings_by_primarykey(IUsersettingsPK usersettingsPK) throws DBException {
        return blusersettings.getUsersettings(usersettingsPK);
    }

    public ArrayList<Usersettings> get_usersettings_with_foreignkey_settings(ISettingsPK settingsPK) throws CustomException {
        return blusersettings.getUsersettingss4settings(settingsPK);
    }
    
    public ArrayList<Usersettings> search_usersettings(IUsersettingssearch usersettingssearch) throws CustomException {
        return blusersettings.search(usersettingssearch);
    }
    
    public long search_usersettings_count(IUsersettingssearch usersettingssearch) throws CustomException {
        return blusersettings.searchcount(usersettingssearch);
    }

    public void secureinsertUsersettings(IUsersettings usersettings) throws DBException, DataException {
        blusersettings.secureinsertUsersettings(usersettings);
    }

    public void secureupdateUsersettings(IUsersettings usersettings) throws DBException, DataException {
        blusersettings.secureupdateUsersettings(usersettings);
    }

    public void securedeleteUsersettings(IUsersettings usersettings) throws DBException, DataException {
        blusersettings.securedeleteUsersettings(usersettings);
    }
}

