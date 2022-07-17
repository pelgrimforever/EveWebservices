/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMsystem;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISystemsearch;
import eve.logicentity.System;

/**
 * @author Franky Laseure
 */
public abstract class Bsystem extends TableBusinessrules {

    public Bsystem(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsystem()));
    }

    public Bsystem(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsystem()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISystem newSystem() {
    	return new System();
    }
    
    public ISystem newSystem(long id) {
        return new System(id);
    }

    public ISystem newSystem(ISystemPK systemPK) {
        return new System((SystemPK)systemPK);
    }

    public ISystemPK newSystemPK() {
        return new SystemPK();
    }

    public ISystemPK newSystemPK(long id) {
        return new SystemPK(id);
    }

    public ArrayList<System> getSystems() throws DBException {
        return (ArrayList<System>)tableio.getEntities(EMsystem.SQLSelectAll);
    }

    public System getSystem(ISystemPK systemPK) throws DBException {
        return (System)tableio.getEntity((SystemPK)systemPK);
    }

    public ArrayList<System> searchsystems(ISystemsearch search) throws DBException {
        return (ArrayList<System>)tableio.search(search);
    }

    public ArrayList<System> searchsystems(ISystemsearch search, String orderby) throws DBException {
        return (ArrayList<System>)tableio.search(search, orderby);
    }

    public boolean getSystemExists(ISystemPK systemPK) throws DBException {
        return tableio.getEntityExists((SystemPK)systemPK);
    }

    public System getEntity(String sql) throws DBException {
        return (System)tableio.getEntity(sql);
    }
    
    public System getEntity(String sql, SQLparameters parameters) throws DBException {
        return (System)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<System> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<System> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<System> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<System> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSystem(SQLTqueue transactionqueue, ISystem system) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, system);
    }

    public void insertupdateSystem(SQLTqueue transactionqueue, ISystem system) throws DBException, DataException {
    	checkDATA(system);
        if(this.getSystemExists(system.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, system);
        } else {
            tableio.insertEntity(transactionqueue, system);
        }
    }

    public void updateSystem(SQLTqueue transactionqueue, ISystem system) throws DBException, DataException {
    	checkDATA(system);
        tableio.updateEntity(transactionqueue, system);
    }

    public void deleteSystem(SQLTqueue transactionqueue, ISystem system) throws DBException {
        cascadedeleteSystem(transactionqueue, system.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, system);
    }

    private void checkDATA(ISystem system) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(system.getName()!=null && system.getName().length()>ISystem.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ISystem.SIZE_NAME).append("\n");
        }
        if(system.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(system.getSecurity_class()!=null && system.getSecurity_class().length()>ISystem.SIZE_SECURITY_CLASS) {
            message.append("Security_class is langer dan toegestaan. Max aantal karakters: ").append(ISystem.SIZE_SECURITY_CLASS).append("\n");
        }
        if(system.getDownloaddate()==null) {
            message.append("Downloaddate mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where systemPK is used in a primary key
     * @param systemPK: System primary key
     */
    public void cascadedeleteSystem(SQLTqueue transactionqueue, ISystemPK systemPK) {
        BLsystemjumps blsystemjumpsSystem_end = new BLsystemjumps(this);
        blsystemjumpsSystem_end.setAuthenticated(isAuthenticated());
        blsystemjumpsSystem_end.delete4systemSystem_end(transactionqueue, systemPK);
        BLsystemjumps blsystemjumpsSystem_start = new BLsystemjumps(this);
        blsystemjumpsSystem_start.setAuthenticated(isAuthenticated());
        blsystemjumpsSystem_start.delete4systemSystem_start(transactionqueue, systemPK);
        BLtradecombined bltradecombinedBuy_system = new BLtradecombined(this);
        bltradecombinedBuy_system.setAuthenticated(isAuthenticated());
        bltradecombinedBuy_system.delete4systemBuy_system(transactionqueue, systemPK);
        BLtradecombined bltradecombinedSell_system = new BLtradecombined(this);
        bltradecombinedSell_system.setAuthenticated(isAuthenticated());
        bltradecombinedSell_system.delete4systemSell_system(transactionqueue, systemPK);
    }

    public void delete4security_island(SQLTqueue transactionqueue, ISecurity_islandPK security_islandPK) {
        tableio.addStatement(transactionqueue, EMsystem.SQLDelete4security_island, security_islandPK.getSQLprimarykey());
    }

    public ArrayList<System> getSystems4security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        return tableio.getEntities(EMsystem.SQLSelect4security_island, security_islandPK.getSQLprimarykey());
    }
    public void delete4constellation(SQLTqueue transactionqueue, IConstellationPK constellationPK) {
        tableio.addStatement(transactionqueue, EMsystem.SQLDelete4constellation, constellationPK.getSQLprimarykey());
    }

    public ArrayList<System> getSystems4constellation(IConstellationPK constellationPK) throws CustomException {
        return tableio.getEntities(EMsystem.SQLSelect4constellation, constellationPK.getSQLprimarykey());
    }
    public System getSystemjumpssystem_end(ISystemjumpsPK systemjumpsPK) throws CustomException {
        SystemPK systemPK = new SystemPK(systemjumpsPK.getSystem_end());
        return this.getSystem(systemPK);
    }

    public System getSystemjumpssystem_start(ISystemjumpsPK systemjumpsPK) throws CustomException {
        SystemPK systemPK = new SystemPK(systemjumpsPK.getSystem_start());
        return this.getSystem(systemPK);
    }

    public System getTradecombinedbuy_system(ITradecombinedPK tradecombinedPK) throws CustomException {
        SystemPK systemPK = new SystemPK(tradecombinedPK.getBuy_system());
        return this.getSystem(systemPK);
    }

    public System getTradecombinedsell_system(ITradecombinedPK tradecombinedPK) throws CustomException {
        SystemPK systemPK = new SystemPK(tradecombinedPK.getSell_system());
        return this.getSystem(systemPK);
    }


    public ArrayList<System> getSystems(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsystem.SQLSelect);
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
        return (ArrayList<System>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSystem(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(System.table);
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
