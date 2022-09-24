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
import eve.conversion.entity.EMalliance;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IAlliancesearch;
import eve.logicentity.Alliance;

public abstract class Balliance extends TableBusinessrules {

    public Balliance(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMalliance()));
    }

    public Balliance(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMalliance()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IAlliance newAlliance() {
    	return new Alliance();
    }
    
    public IAlliance newAlliance(long id) {
        return new Alliance(id);
    }

    public IAlliance newAlliance(IAlliancePK alliancePK) {
        return new Alliance((AlliancePK)alliancePK);
    }

    public IAlliancePK newAlliancePK() {
        return new AlliancePK();
    }

    public IAlliancePK newAlliancePK(long id) {
        return new AlliancePK(id);
    }

    public ArrayList<Alliance> getAlliances() throws DBException {
        return (ArrayList<Alliance>)tableio.getEntities(EMalliance.SQLSelectAll);
    }

    public Alliance getAlliance(IAlliancePK alliancePK) throws DBException {
        return (Alliance)tableio.getEntity((AlliancePK)alliancePK);
    }

    public ArrayList<Alliance> searchalliances(IAlliancesearch search) throws DBException {
        return (ArrayList<Alliance>)tableio.search(search);
    }

    public ArrayList<Alliance> searchalliances(IAlliancesearch search, String orderby) throws DBException {
        return (ArrayList<Alliance>)tableio.search(search, orderby);
    }

    public boolean getAllianceExists(IAlliancePK alliancePK) throws DBException {
        return tableio.getEntityExists((AlliancePK)alliancePK);
    }

    public Alliance getEntity(String sql) throws DBException {
        return (Alliance)tableio.getEntity(sql);
    }
    
    public Alliance getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Alliance)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Alliance> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Alliance> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Alliance> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Alliance> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertAlliance(SQLTqueue transactionqueue, IAlliance alliance) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, alliance);
    }

    public void insertupdateAlliance(SQLTqueue transactionqueue, IAlliance alliance) throws DBException, DataException {
    	checkDATA(alliance);
        if(this.getAllianceExists(alliance.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, alliance);
        } else {
            tableio.insertEntity(transactionqueue, alliance);
        }
    }

    public void updateAlliance(SQLTqueue transactionqueue, IAlliance alliance) throws DBException, DataException {
    	checkDATA(alliance);
        tableio.updateEntity(transactionqueue, alliance);
    }

    public void deleteAlliance(SQLTqueue transactionqueue, IAlliance alliance) throws DBException {
        cascadedeleteAlliance(transactionqueue, alliance.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, alliance);
    }

    private void checkDATA(IAlliance alliance) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(alliance.getName()!=null && alliance.getName().length()>IAlliance.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IAlliance.SIZE_NAME).append("\n");
        }
        if(alliance.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(alliance.getDate_founded()==null) {
            message.append("Date_founded mag niet leeg zijn.\n");
        }
        if(alliance.getTicker()!=null && alliance.getTicker().length()>IAlliance.SIZE_TICKER) {
            message.append("Ticker is langer dan toegestaan. Max aantal karakters: ").append(IAlliance.SIZE_TICKER).append("\n");
        }
        if(alliance.getTicker()==null) {
            message.append("Ticker mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteAlliance(SQLTqueue transactionqueue, IAlliancePK alliancePK) {
    }

    public void delete4corporationCreator_corporation(SQLTqueue transactionqueue, ICorporationPK corporationPK) {
        tableio.addStatement(transactionqueue, EMalliance.SQLDelete4corporationCreator_corporation, corporationPK.getSQLprimarykey());
    }

    public ArrayList<Alliance> getAlliances4corporationCreator_corporation(ICorporationPK corporationPK) throws CustomException {
        return tableio.getEntities(EMalliance.SQLSelect4corporationCreator_corporation, corporationPK.getSQLprimarykey());
    }
    public void delete4corporationExecutor_corporation(SQLTqueue transactionqueue, ICorporationPK corporationPK) {
        tableio.addStatement(transactionqueue, EMalliance.SQLDelete4corporationExecutor_corporation, corporationPK.getSQLprimarykey());
    }

    public ArrayList<Alliance> getAlliances4corporationExecutor_corporation(ICorporationPK corporationPK) throws CustomException {
        return tableio.getEntities(EMalliance.SQLSelect4corporationExecutor_corporation, corporationPK.getSQLprimarykey());
    }

    public ArrayList<Alliance> getAlliances(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMalliance.SQLSelect);
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
        return (ArrayList<Alliance>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delAlliance(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Alliance.table);
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
