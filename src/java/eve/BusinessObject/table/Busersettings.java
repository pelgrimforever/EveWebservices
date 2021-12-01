/*
 * Busersettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
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
import eve.conversion.json.JSONUsersettings;
import eve.conversion.entity.EMusersettings;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IUsersettingssearch;
import eve.logicentity.Usersettings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Busersettings
 *
 * Superclass for manipulating data- and database objects
 * for Entity Usersettings and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Busersettings extends BLtable {

    /**
     * Constructor, sets Usersettings as default Entity
     */
    public Busersettings() {
        super(new Usersettings(), new EMusersettings());
    }

    /**
     * Constructor, sets Usersettings as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Busersettings(BLtable transactionobject) {
        super(transactionobject, new Usersettings(), new EMusersettings());
    }

    /**
     * create new empty Usersettings object
     * @return empty IUsersettings
     */
    public IUsersettings newUsersettings() {
    	return new Usersettings();
    }
    
    /**
     * create new empty Usersettings object
     * create new primary key with given parameters
     * @param username primary key field
     * @param name primary key field
     * @return IUsersettings with primary key
     */
    public IUsersettings newUsersettings(java.lang.String username, java.lang.String name) {
        return new Usersettings(username, name);
    }

    /**
     * create new empty Usersettings object with given primary key
     * @param usersettingsPK: primary key for Usersettings
     * @return IUsersettings with primary key
     */
    public IUsersettings newUsersettings(IUsersettingsPK usersettingsPK) {
        return new Usersettings((UsersettingsPK)usersettingsPK);
    }

    /**
     * create new empty primary key
     * @return empty UsersettingsPK
     */
    public IUsersettingsPK newUsersettingsPK() {
        return new UsersettingsPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param name primary key field
     * @return new IUsersettingsPK
     */
    public IUsersettingsPK newUsersettingsPK(java.lang.String username, java.lang.String name) {
        return new UsersettingsPK(username, name);
    }

    /**
     * get all Usersettings objects from database
     * @return ArrayList of Usersettings objects
     * @throws DBException
     */
    public ArrayList<Usersettings> getUsersettingss() throws DBException {
        return (ArrayList<Usersettings>)super.getEntities(EMusersettings.SQLSelectAll);
    }

    /**
     * search Usersettings for primary key
     * @param usersettingsPK: Usersettings primary key
     * @return Usersettings object
     * @throws DBException
     */
    public Usersettings getUsersettings(IUsersettingsPK usersettingsPK) throws DBException {
        return (Usersettings)super.getEntity((UsersettingsPK)usersettingsPK);
    }

    /**
     * search usersettings with IUsersettingssearch parameters
     * @param search IUsersettingssearch
     * @return ArrayList of Usersettings
     * @throws DBException 
     */
    public ArrayList<Usersettings> searchusersettingss(IUsersettingssearch search) throws DBException {
        return (ArrayList<Usersettings>)this.search(search);
    }

    /**
     * search usersettings with IUsersettingssearch parameters, order by orderby sql clause
     * @param search IUsersettingssearch
     * @param orderby sql order by string
     * @return ArrayList of Usersettings
     * @throws DBException 
     */
    public ArrayList<Usersettings> searchusersettingss(IUsersettingssearch search, String orderby) throws DBException {
        return (ArrayList<Usersettings>)this.search(search, orderby);
    }

    /**
     * Search usersettings in database for usersettingsPK:
     * @param usersettingsPK: Usersettings Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getUsersettingsExists(IUsersettingsPK usersettingsPK) throws DBException {
        return super.getEntityExists((UsersettingsPK)usersettingsPK);
    }

    /**
     * try to insert Usersettings in database
     * @param usersettings Usersettings object
     * @throws DBException
     * @throws DataException
     */
    public void insertUsersettings(IUsersettings usersettings) throws DBException, DataException {
        super.insertEntity(usersettings);
    }

    /**
     * check if UsersettingsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param usersettings Usersettings object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateUsersettings(IUsersettings usersettings) throws DBException, DataException {
        if(this.getUsersettingsExists(usersettings.getPrimaryKey())) {
            super.updateEntity(usersettings);
        } else {
            super.insertEntity(usersettings);
        }
    }

    /**
     * try to update Usersettings in database
     * @param usersettings Usersettings object
     * @throws DBException
     * @throws DataException
     */
    public void updateUsersettings(IUsersettings usersettings) throws DBException, DataException {
        super.updateEntity(usersettings);
    }

    /**
     * try to delete Usersettings in database
     * @param usersettings Usersettings object
     * @throws DBException
     */
    public void deleteUsersettings(IUsersettings usersettings) throws DBException {
        cascadedeleteUsersettings(usersettings.getPrimaryKey());
        super.deleteEntity(usersettings);
    }

    /**
     * check data rules in Usersettings, throw DataException with customized message if rules do not apply
     * @param usersettings Usersettings object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IUsersettings usersettings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Usersettings.Name - Settings.Name
        //Primary key
        if(usersettings.getValue()!=null && usersettings.getValue().length()>IUsersettings.SIZE_VALUE) {
            message.append("Value is langer dan toegestaan. Max aantal karakters: ").append(IUsersettings.SIZE_VALUE).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where usersettingsPK is used in a primary key
     * @param usersettingsPK: Usersettings primary key
     */
    public void cascadedeleteUsersettings(IUsersettingsPK usersettingsPK) {
    }

    /**
     * @param settingsPK: foreign key for Settings
     * @delete all Usersettings Entity objects for Settings in database
     */
    public void delete4settings(ISettingsPK settingsPK) {
        super.addStatement(EMusersettings.SQLDelete4settings, settingsPK.getSQLprimarykey());
    }

    /**
     * @param settingsPK: foreign key for Settings
     * @return all Usersettings Entity objects for Settings
     * @throws CustomException
     */
    public ArrayList<Usersettings> getUsersettingss4settings(ISettingsPK settingsPK) throws CustomException {
        return super.getEntities(EMusersettings.SQLSelect4settings, settingsPK.getSQLprimarykey());
    }

    /**
     * get all Usersettings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Usersettings objects
     * @throws DBException
     */
    public ArrayList<Usersettings> getUsersettingss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMusersettings.SQLSelect);
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
        return (ArrayList<Usersettings>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Usersettings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delUsersettings(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Usersettings.table);
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
