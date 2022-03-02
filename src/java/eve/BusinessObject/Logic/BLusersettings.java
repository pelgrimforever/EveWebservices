/*
 * BLusersettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 14:57
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IUsersettings;
import eve.logicentity.Usersettings;
import eve.BusinessObject.table.Busersettings;
import eve.entity.pk.UsersettingsPK;
import eve.logicentity.Settings;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLusersettings
 *
 * Class for manipulating data- and database objects
 * for Entity Usersettings and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLusersettings extends Busersettings {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Usersettings as default Entity
     */
    public BLusersettings() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Usersettings as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLusersettings(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * get default settings
     * check if all settings are defined for username, if not create them
     * @param username
     * @return ArrayList of Usersettings
     * @throws DBException
     * @throws DataException 
     */
    public ArrayList<Usersettings> getUsersettings(String username) throws DBException, DataException {
        BLsettings blsettings = new BLsettings();
        ArrayList<Settings> defaultsettings = blsettings.getDefaultSettings();
        ArrayList<Usersettings> usersettings = new ArrayList<>();
        UsersettingsPK usersettingsPK;
        Usersettings usersetting;
        for(Settings defaultsetting: defaultsettings) {
            usersettingsPK = new UsersettingsPK(username, defaultsetting.getPrimaryKey().getName());
            usersetting = this.getUsersettings(usersettingsPK);
            if(usersetting==null) {
                usersetting = new Usersettings(usersettingsPK);
                usersetting.setValue(defaultsetting.getValue());
                this.insertUsersettings(usersetting);
            }
            usersettings.add(usersetting);
        }
        this.Commit2DB();
        return usersettings;
    }
    
    /**
     * find usersetting in List of loaded usersettings for 1 user
     * @param usersettings ArrayList of usersettings
     * @param settingsconstant ISettings name constant
     * @return Usersettings
     */
    public Usersettings getUsersetting(ArrayList<Usersettings> usersettings, String settingsconstant) {
        Usersettings setting = null;
        for(Usersettings usersetting: usersettings) {
            if(usersetting.getPrimaryKey().getSettingsPK().getName().equals(settingsconstant)) {
                setting = usersetting;
            }
        }
        return setting;
    }
    
    /**
     * try to insert Usersettings object in database
     * commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertUsersettings(IUsersettings usersettings) throws DBException, DataException {
        trans_insertUsersettings(usersettings);
        super.Commit2DB();
    }
    
    /**
     * try to insert Usersettings object in database
     * an alternative to insertUsersettings, which can be made an empty function
     * commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertUsersettings(IUsersettings usersettings) throws DBException, DataException {
        trans_insertUsersettings(usersettings);
        super.Commit2DB();
    }
    
    /**
     * try to update Usersettings object in database
     * commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateUsersettings(IUsersettings usersettings) throws DBException, DataException {
        //make sure all usersettings are present
        getUsersettings(usersettings.getPrimaryKey().getUsername());
        //update setting
        trans_updateUsersettings(usersettings);
        super.Commit2DB();
    }
    
    /**
     * try to update Usersettings object in database
     * an alternative to updateUsersettings, which can be made an empty function
     * commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateUsersettings(IUsersettings usersettings) throws DBException, DataException {
        trans_updateUsersettings(usersettings);
        super.Commit2DB();
    }
    
    /**
     * try to delete Usersettings object in database
     * commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteUsersettings(IUsersettings usersettings) throws DBException {
        trans_deleteUsersettings(usersettings);
        super.Commit2DB();
    }

    /**
     * try to delete Usersettings object in database
     * an alternative to deleteUsersettings, which can be made an empty function
     * commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteUsersettings(IUsersettings usersettings) throws DBException {
        trans_deleteUsersettings(usersettings);
        super.Commit2DB();
    }

    /**
     * try to insert Usersettings object in database
     * do not commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertUsersettings(IUsersettings usersettings) throws DBException, DataException {
        super.checkDATA(usersettings);
        super.insertUsersettings((Usersettings)usersettings);
    }
    
    /**
     * try to update Usersettings object in database
     * do not commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateUsersettings(IUsersettings usersettings) throws DBException, DataException {
        super.checkDATA(usersettings);
        super.updateUsersettings((Usersettings)usersettings);
    }
    
    /**
     * try to delete Usersettings object in database
     * do not commit transaction
     * @param usersettings: Usersettings Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteUsersettings(IUsersettings usersettings) throws DBException {
        super.deleteUsersettings((Usersettings)usersettings);
    }
}
