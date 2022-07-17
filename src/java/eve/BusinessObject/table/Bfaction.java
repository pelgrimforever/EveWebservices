/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMfaction;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IFactionsearch;
import eve.logicentity.Faction;

/**
 * @author Franky Laseure
 */
public abstract class Bfaction extends TableBusinessrules {

    public Bfaction(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMfaction()));
    }

    public Bfaction(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMfaction()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IFaction newFaction() {
    	return new Faction();
    }
    
    public IFaction newFaction(long id) {
        return new Faction(id);
    }

    public IFaction newFaction(IFactionPK factionPK) {
        return new Faction((FactionPK)factionPK);
    }

    public IFactionPK newFactionPK() {
        return new FactionPK();
    }

    public IFactionPK newFactionPK(long id) {
        return new FactionPK(id);
    }

    public ArrayList<Faction> getFactions() throws DBException {
        return (ArrayList<Faction>)tableio.getEntities(EMfaction.SQLSelectAll);
    }

    public Faction getFaction(IFactionPK factionPK) throws DBException {
        return (Faction)tableio.getEntity((FactionPK)factionPK);
    }

    public ArrayList<Faction> searchfactions(IFactionsearch search) throws DBException {
        return (ArrayList<Faction>)tableio.search(search);
    }

    public ArrayList<Faction> searchfactions(IFactionsearch search, String orderby) throws DBException {
        return (ArrayList<Faction>)tableio.search(search, orderby);
    }

    public boolean getFactionExists(IFactionPK factionPK) throws DBException {
        return tableio.getEntityExists((FactionPK)factionPK);
    }

    public Faction getEntity(String sql) throws DBException {
        return (Faction)tableio.getEntity(sql);
    }
    
    public Faction getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Faction)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Faction> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Faction> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Faction> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Faction> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertFaction(SQLTqueue transactionqueue, IFaction faction) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, faction);
    }

    public void insertupdateFaction(SQLTqueue transactionqueue, IFaction faction) throws DBException, DataException {
    	checkDATA(faction);
        if(this.getFactionExists(faction.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, faction);
        } else {
            tableio.insertEntity(transactionqueue, faction);
        }
    }

    public void updateFaction(SQLTqueue transactionqueue, IFaction faction) throws DBException, DataException {
    	checkDATA(faction);
        tableio.updateEntity(transactionqueue, faction);
    }

    public void deleteFaction(SQLTqueue transactionqueue, IFaction faction) throws DBException {
        cascadedeleteFaction(transactionqueue, faction.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, faction);
    }

    private void checkDATA(IFaction faction) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(faction.getName()!=null && faction.getName().length()>IFaction.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IFaction.SIZE_NAME).append("\n");
        }
        if(faction.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(faction.getDescription()!=null && faction.getDescription().length()>IFaction.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IFaction.SIZE_DESCRIPTION).append("\n");
        }
        if(faction.getDescription()==null) {
            message.append("Description mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where factionPK is used in a primary key
     * @param factionPK: Faction primary key
     */
    public void cascadedeleteFaction(SQLTqueue transactionqueue, IFactionPK factionPK) {
    }

    public void delete4system(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMfaction.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Faction> getFactions4system(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMfaction.SQLSelect4system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Faction> getFactions(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfaction.SQLSelect);
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
        return (ArrayList<Faction>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delFaction(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Faction.table);
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
