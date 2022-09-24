/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMusersettings;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IUsersettingssearch;
import eve.logicentity.Usersettings;

public abstract class Busersettings extends TableBusinessrules {

    public Busersettings(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMusersettings()));
    }

    public Busersettings(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMusersettings()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IUsersettings newUsersettings() {
    	return new Usersettings();
    }
    
    public IUsersettings newUsersettings(java.lang.String username, java.lang.String name) {
        return new Usersettings(username, name);
    }

    public IUsersettings newUsersettings(IUsersettingsPK usersettingsPK) {
        return new Usersettings((UsersettingsPK)usersettingsPK);
    }

    public IUsersettingsPK newUsersettingsPK() {
        return new UsersettingsPK();
    }

    public IUsersettingsPK newUsersettingsPK(java.lang.String username, java.lang.String name) {
        return new UsersettingsPK(username, name);
    }

    public ArrayList<Usersettings> getUsersettingss() throws DBException {
        return (ArrayList<Usersettings>)tableio.getEntities(EMusersettings.SQLSelectAll);
    }

    public Usersettings getUsersettings(IUsersettingsPK usersettingsPK) throws DBException {
        return (Usersettings)tableio.getEntity((UsersettingsPK)usersettingsPK);
    }

    public ArrayList<Usersettings> searchusersettingss(IUsersettingssearch search) throws DBException {
        return (ArrayList<Usersettings>)tableio.search(search);
    }

    public ArrayList<Usersettings> searchusersettingss(IUsersettingssearch search, String orderby) throws DBException {
        return (ArrayList<Usersettings>)tableio.search(search, orderby);
    }

    public boolean getUsersettingsExists(IUsersettingsPK usersettingsPK) throws DBException {
        return tableio.getEntityExists((UsersettingsPK)usersettingsPK);
    }

    public Usersettings getEntity(String sql) throws DBException {
        return (Usersettings)tableio.getEntity(sql);
    }
    
    public Usersettings getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Usersettings)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Usersettings> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Usersettings> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Usersettings> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Usersettings> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertUsersettings(SQLTqueue transactionqueue, IUsersettings usersettings) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, usersettings);
    }

    public void insertupdateUsersettings(SQLTqueue transactionqueue, IUsersettings usersettings) throws DBException, DataException {
    	checkDATA(usersettings);
        if(this.getUsersettingsExists(usersettings.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, usersettings);
        } else {
            tableio.insertEntity(transactionqueue, usersettings);
        }
    }

    public void updateUsersettings(SQLTqueue transactionqueue, IUsersettings usersettings) throws DBException, DataException {
    	checkDATA(usersettings);
        tableio.updateEntity(transactionqueue, usersettings);
    }

    public void deleteUsersettings(SQLTqueue transactionqueue, IUsersettings usersettings) throws DBException {
        cascadedeleteUsersettings(transactionqueue, usersettings.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, usersettings);
    }

    private void checkDATA(IUsersettings usersettings) throws DataException, DBException {
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
        
    public void cascadedeleteUsersettings(SQLTqueue transactionqueue, IUsersettingsPK usersettingsPK) {
    }

    public void delete4settings(SQLTqueue transactionqueue, ISettingsPK settingsPK) {
        tableio.addStatement(transactionqueue, EMusersettings.SQLDelete4settings, settingsPK.getSQLprimarykey());
    }

    public ArrayList<Usersettings> getUsersettingss4settings(ISettingsPK settingsPK) throws CustomException {
        return tableio.getEntities(EMusersettings.SQLSelect4settings, settingsPK.getSQLprimarykey());
    }

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
        return (ArrayList<Usersettings>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delUsersettings(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
