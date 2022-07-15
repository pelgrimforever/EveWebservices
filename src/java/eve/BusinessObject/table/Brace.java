/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMrace;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRacesearch;
import eve.logicentity.Race;

/**
 * @author Franky Laseure
 */
public abstract class Brace extends TableBusinessrules {

    public Brace(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMrace()));
    }

    public Brace(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMrace()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IRace newRace() {
    	return new Race();
    }
    
    public IRace newRace(long id) {
        return new Race(id);
    }

    public IRace newRace(IRacePK racePK) {
        return new Race((RacePK)racePK);
    }

    public IRacePK newRacePK() {
        return new RacePK();
    }

    public IRacePK newRacePK(long id) {
        return new RacePK(id);
    }

    public ArrayList<Race> getRaces() throws DBException {
        return (ArrayList<Race>)tableio.getEntities(EMrace.SQLSelectAll);
    }

    public Race getRace(IRacePK racePK) throws DBException {
        return (Race)tableio.getEntity((RacePK)racePK);
    }

    public ArrayList<Race> searchraces(IRacesearch search) throws DBException {
        return (ArrayList<Race>)tableio.search(search);
    }

    public ArrayList<Race> searchraces(IRacesearch search, String orderby) throws DBException {
        return (ArrayList<Race>)tableio.search(search, orderby);
    }

    public boolean getRaceExists(IRacePK racePK) throws DBException {
        return tableio.getEntityExists((RacePK)racePK);
    }

    public Race getEntity(String sql) throws DBException {
        return (Race)tableio.getEntity(sql);
    }
    
    public Race getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Race)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Race> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Race> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Race> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Race> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertRace(SQLTqueue transactionqueue, IRace race) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, race);
    }

    public void insertupdateRace(SQLTqueue transactionqueue, IRace race) throws DBException, DataException {
    	checkDATA(race);
        if(this.getRaceExists(race.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, race);
        } else {
            tableio.insertEntity(transactionqueue, race);
        }
    }

    public void updateRace(SQLTqueue transactionqueue, IRace race) throws DBException, DataException {
    	checkDATA(race);
        tableio.updateEntity(transactionqueue, race);
    }

    public void deleteRace(SQLTqueue transactionqueue, IRace race) throws DBException {
        cascadedeleteRace(transactionqueue, race.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, race);
    }

    private void checkDATA(IRace race) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(race.getName()!=null && race.getName().length()>IRace.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IRace.SIZE_NAME).append("\n");
        }
        if(race.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(race.getDescription()!=null && race.getDescription().length()>IRace.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IRace.SIZE_DESCRIPTION).append("\n");
        }
        if(race.getDescription()==null) {
            message.append("Description mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where racePK is used in a primary key
     * @param racePK: Race primary key
     */
    public void cascadedeleteRace(SQLTqueue transactionqueue, IRacePK racePK) {
    }

    public void delete4faction(SQLTqueue transactionqueue, IFactionPK factionPK) {
        tableio.addStatement(transactionqueue, EMrace.SQLDelete4faction, factionPK.getSQLprimarykey());
    }

    public ArrayList<Race> getRaces4faction(IFactionPK factionPK) throws CustomException {
        return tableio.getEntities(EMrace.SQLSelect4faction, factionPK.getSQLprimarykey());
    }

    public ArrayList<Race> getRaces(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMrace.SQLSelect);
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
        return (ArrayList<Race>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delRace(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Race.table);
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
