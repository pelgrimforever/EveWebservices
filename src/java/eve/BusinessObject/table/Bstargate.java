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
import eve.conversion.entity.EMstargate;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStargatesearch;
import eve.logicentity.Stargate;

public abstract class Bstargate extends TableBusinessrules {

    public Bstargate(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMstargate()));
    }

    public Bstargate(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMstargate()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IStargate newStargate() {
    	return new Stargate();
    }
    
    public IStargate newStargate(long id) {
        return new Stargate(id);
    }

    public IStargate newStargate(IStargatePK stargatePK) {
        return new Stargate((StargatePK)stargatePK);
    }

    public IStargatePK newStargatePK() {
        return new StargatePK();
    }

    public IStargatePK newStargatePK(long id) {
        return new StargatePK(id);
    }

    public ArrayList<Stargate> getStargates() throws DBException {
        return (ArrayList<Stargate>)tableio.getEntities(EMstargate.SQLSelectAll);
    }

    public Stargate getStargate(IStargatePK stargatePK) throws DBException {
        return (Stargate)tableio.getEntity((StargatePK)stargatePK);
    }

    public ArrayList<Stargate> searchstargates(IStargatesearch search) throws DBException {
        return (ArrayList<Stargate>)tableio.search(search);
    }

    public ArrayList<Stargate> searchstargates(IStargatesearch search, String orderby) throws DBException {
        return (ArrayList<Stargate>)tableio.search(search, orderby);
    }

    public boolean getStargateExists(IStargatePK stargatePK) throws DBException {
        return tableio.getEntityExists((StargatePK)stargatePK);
    }

    public Stargate getEntity(String sql) throws DBException {
        return (Stargate)tableio.getEntity(sql);
    }
    
    public Stargate getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Stargate)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Stargate> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Stargate> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Stargate> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Stargate> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertStargate(SQLTqueue transactionqueue, IStargate stargate) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, stargate);
    }

    public void insertupdateStargate(SQLTqueue transactionqueue, IStargate stargate) throws DBException, DataException {
    	checkDATA(stargate);
        if(this.getStargateExists(stargate.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, stargate);
        } else {
            tableio.insertEntity(transactionqueue, stargate);
        }
    }

    public void updateStargate(SQLTqueue transactionqueue, IStargate stargate) throws DBException, DataException {
    	checkDATA(stargate);
        tableio.updateEntity(transactionqueue, stargate);
    }

    public void deleteStargate(SQLTqueue transactionqueue, IStargate stargate) throws DBException {
        cascadedeleteStargate(transactionqueue, stargate.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, stargate);
    }

    private void checkDATA(IStargate stargate) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(stargate.getName()!=null && stargate.getName().length()>IStargate.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IStargate.SIZE_NAME).append("\n");
        }
        if(stargate.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(stargate.getDownloaddate()==null) {
            message.append("Downloaddate mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteStargate(SQLTqueue transactionqueue, IStargatePK stargatePK) {
    }

    public void delete4systemSystem(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMstargate.SQLDelete4systemSystem, systemPK.getSQLprimarykey());
    }

    public ArrayList<Stargate> getStargates4systemSystem(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMstargate.SQLSelect4systemSystem, systemPK.getSQLprimarykey());
    }
    public void delete4systemTo_system(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMstargate.SQLDelete4systemTo_system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Stargate> getStargates4systemTo_system(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMstargate.SQLSelect4systemTo_system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Stargate> getStargates(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstargate.SQLSelect);
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
        return (ArrayList<Stargate>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delStargate(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Stargate.table);
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
