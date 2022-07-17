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
import eve.logicentity.Usersettings;
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
public class Usersettings_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLusersettings blusersettings = new BLusersettings(sqlreader);
    
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
        SQLTqueue transactionqueue = new SQLTqueue();
        ArrayList<Usersettings> usersettings = blusersettings.get_or_initialize_Usersettings(transactionqueue, username);
        sqlwriter.Commit2DB(transactionqueue);
        return usersettings;
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blusersettings.count();
    }
    
    public ArrayList<Usersettings> get_all() throws DBException {
        return blusersettings.getUsersettingss();
    }
    
    public boolean getUsersettingsExists(IUsersettingsPK usersettingsPK) throws DBException {
        return blusersettings.getUsersettingsExists(usersettingsPK);
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

    public void insertUsersettings(IUsersettings usersettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blusersettings.insertUsersettings(tq, usersettings);
        sqlwriter.Commit2DB(tq);
    }

    public void updateUsersettings(IUsersettings usersettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blusersettings.updateUsersettings(tq, usersettings);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteUsersettings(IUsersettings usersettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blusersettings.deleteUsersettings(tq, usersettings);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Settings(ISettingsPK settingsPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blusersettings.delete4settings(tq, settingsPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

