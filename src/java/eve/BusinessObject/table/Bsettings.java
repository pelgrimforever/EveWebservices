/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMsettings;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISettingssearch;
import eve.logicentity.Settings;

/**
 * @author Franky Laseure
 */
public abstract class Bsettings extends TableBusinessrules {

    public Bsettings(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsettings()));
    }

    public Bsettings(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsettings()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISettings newSettings() {
    	return new Settings();
    }
    
    public ISettings newSettings(java.lang.String name) {
        return new Settings(name);
    }

    public ISettings newSettings(ISettingsPK settingsPK) {
        return new Settings((SettingsPK)settingsPK);
    }

    public ISettingsPK newSettingsPK() {
        return new SettingsPK();
    }

    public ISettingsPK newSettingsPK(java.lang.String name) {
        return new SettingsPK(name);
    }

    public ArrayList<Settings> getSettingss() throws DBException {
        return (ArrayList<Settings>)tableio.getEntities(EMsettings.SQLSelectAll);
    }

    public Settings getSettings(ISettingsPK settingsPK) throws DBException {
        return (Settings)tableio.getEntity((SettingsPK)settingsPK);
    }

    public ArrayList<Settings> searchsettingss(ISettingssearch search) throws DBException {
        return (ArrayList<Settings>)tableio.search(search);
    }

    public ArrayList<Settings> searchsettingss(ISettingssearch search, String orderby) throws DBException {
        return (ArrayList<Settings>)tableio.search(search, orderby);
    }

    public boolean getSettingsExists(ISettingsPK settingsPK) throws DBException {
        return tableio.getEntityExists((SettingsPK)settingsPK);
    }

    public Settings getEntity(String sql) throws DBException {
        return (Settings)tableio.getEntity(sql);
    }
    
    public Settings getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Settings)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Settings> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Settings> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Settings> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Settings> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSettings(SQLTqueue transactionqueue, ISettings settings) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, settings);
    }

    public void insertupdateSettings(SQLTqueue transactionqueue, ISettings settings) throws DBException, DataException {
    	checkDATA(settings);
        if(this.getSettingsExists(settings.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, settings);
        } else {
            tableio.insertEntity(transactionqueue, settings);
        }
    }

    public void updateSettings(SQLTqueue transactionqueue, ISettings settings) throws DBException, DataException {
    	checkDATA(settings);
        tableio.updateEntity(transactionqueue, settings);
    }

    public void deleteSettings(SQLTqueue transactionqueue, ISettings settings) throws DBException {
        cascadedeleteSettings(transactionqueue, settings.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, settings);
    }

    private void checkDATA(ISettings settings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(settings.getValue()!=null && settings.getValue().length()>ISettings.SIZE_VALUE) {
            message.append("Value is langer dan toegestaan. Max aantal karakters: ").append(ISettings.SIZE_VALUE).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where settingsPK is used in a primary key
     * @param settingsPK: Settings primary key
     */
    public void cascadedeleteSettings(SQLTqueue transactionqueue, ISettingsPK settingsPK) {
        BLusersettings blusersettings = new BLusersettings(this);
        blusersettings.delete4settings(transactionqueue, settingsPK);
    }

    public Settings getUsersettings(IUsersettingsPK usersettingsPK) throws CustomException {
        SettingsPK settingsPK = new SettingsPK(usersettingsPK.getName());
        return this.getSettings(settingsPK);
    }


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
        return (ArrayList<Settings>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSettings(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
