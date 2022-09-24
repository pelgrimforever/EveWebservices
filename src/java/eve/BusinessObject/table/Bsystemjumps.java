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
import eve.conversion.entity.EMsystemjumps;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISystemjumpssearch;
import eve.logicentity.Systemjumps;

public abstract class Bsystemjumps extends TableBusinessrules {

    public Bsystemjumps(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsystemjumps()));
    }

    public Bsystemjumps(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsystemjumps()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISystemjumps newSystemjumps() {
    	return new Systemjumps();
    }
    
    public ISystemjumps newSystemjumps(long system_start, long system_end) {
        return new Systemjumps(system_start, system_end);
    }

    public ISystemjumps newSystemjumps(ISystemjumpsPK systemjumpsPK) {
        return new Systemjumps((SystemjumpsPK)systemjumpsPK);
    }

    public ISystemjumpsPK newSystemjumpsPK() {
        return new SystemjumpsPK();
    }

    public ISystemjumpsPK newSystemjumpsPK(long system_start, long system_end) {
        return new SystemjumpsPK(system_start, system_end);
    }

    public ArrayList<Systemjumps> getSystemjumpss() throws DBException {
        return (ArrayList<Systemjumps>)tableio.getEntities(EMsystemjumps.SQLSelectAll);
    }

    public Systemjumps getSystemjumps(ISystemjumpsPK systemjumpsPK) throws DBException {
        return (Systemjumps)tableio.getEntity((SystemjumpsPK)systemjumpsPK);
    }

    public ArrayList<Systemjumps> searchsystemjumpss(ISystemjumpssearch search) throws DBException {
        return (ArrayList<Systemjumps>)tableio.search(search);
    }

    public ArrayList<Systemjumps> searchsystemjumpss(ISystemjumpssearch search, String orderby) throws DBException {
        return (ArrayList<Systemjumps>)tableio.search(search, orderby);
    }

    public boolean getSystemjumpsExists(ISystemjumpsPK systemjumpsPK) throws DBException {
        return tableio.getEntityExists((SystemjumpsPK)systemjumpsPK);
    }

    public Systemjumps getEntity(String sql) throws DBException {
        return (Systemjumps)tableio.getEntity(sql);
    }
    
    public Systemjumps getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Systemjumps)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Systemjumps> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Systemjumps> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Systemjumps> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Systemjumps> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSystemjumps(SQLTqueue transactionqueue, ISystemjumps systemjumps) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, systemjumps);
    }

    public void insertupdateSystemjumps(SQLTqueue transactionqueue, ISystemjumps systemjumps) throws DBException, DataException {
    	checkDATA(systemjumps);
        if(this.getSystemjumpsExists(systemjumps.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, systemjumps);
        } else {
            tableio.insertEntity(transactionqueue, systemjumps);
        }
    }

    public void updateSystemjumps(SQLTqueue transactionqueue, ISystemjumps systemjumps) throws DBException, DataException {
    	checkDATA(systemjumps);
        tableio.updateEntity(transactionqueue, systemjumps);
    }

    public void deleteSystemjumps(SQLTqueue transactionqueue, ISystemjumps systemjumps) throws DBException {
        cascadedeleteSystemjumps(transactionqueue, systemjumps.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, systemjumps);
    }

    private void checkDATA(ISystemjumps systemjumps) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Systemjumps.System_start - System.Id
        //foreign key Systemjumps.System_end - System.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteSystemjumps(SQLTqueue transactionqueue, ISystemjumpsPK systemjumpsPK) {
    }

    public void delete4systemSystem_end(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMsystemjumps.SQLDelete4systemSystem_end, systemPK.getSQLprimarykey());
    }

    public ArrayList<Systemjumps> getSystemjumpss4systemSystem_end(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMsystemjumps.SQLSelect4systemSystem_end, systemPK.getSQLprimarykey());
    }
    public void delete4systemSystem_start(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMsystemjumps.SQLDelete4systemSystem_start, systemPK.getSQLprimarykey());
    }

    public ArrayList<Systemjumps> getSystemjumpss4systemSystem_start(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMsystemjumps.SQLSelect4systemSystem_start, systemPK.getSQLprimarykey());
    }

    public ArrayList<Systemjumps> getSystemjumpss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsystemjumps.SQLSelect);
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
        return (ArrayList<Systemjumps>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSystemjumps(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Systemjumps.table);
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
