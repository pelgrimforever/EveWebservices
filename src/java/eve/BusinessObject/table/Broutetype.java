/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMroutetype;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.logicentity.Routetype;

/**
 * @author Franky Laseure
 */
public abstract class Broutetype extends TableBusinessrules {

    public Broutetype(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMroutetype()));
    }

    public Broutetype(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMroutetype()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IRoutetype newRoutetype() {
    	return new Routetype();
    }
    
    public IRoutetype newRoutetype(long id) {
        return new Routetype(id);
    }

    public IRoutetype newRoutetype(IRoutetypePK routetypePK) {
        return new Routetype((RoutetypePK)routetypePK);
    }

    public IRoutetypePK newRoutetypePK() {
        return new RoutetypePK();
    }

    public IRoutetypePK newRoutetypePK(long id) {
        return new RoutetypePK(id);
    }

    public ArrayList<Routetype> getRoutetypes() throws DBException {
        return (ArrayList<Routetype>)tableio.getEntities(EMroutetype.SQLSelectAll);
    }

    public Routetype getRoutetype(IRoutetypePK routetypePK) throws DBException {
        return (Routetype)tableio.getEntity((RoutetypePK)routetypePK);
    }

    public ArrayList<Routetype> searchroutetypes(IRoutetypesearch search) throws DBException {
        return (ArrayList<Routetype>)tableio.search(search);
    }

    public ArrayList<Routetype> searchroutetypes(IRoutetypesearch search, String orderby) throws DBException {
        return (ArrayList<Routetype>)tableio.search(search, orderby);
    }

    public boolean getRoutetypeExists(IRoutetypePK routetypePK) throws DBException {
        return tableio.getEntityExists((RoutetypePK)routetypePK);
    }

    public Routetype getEntity(String sql) throws DBException {
        return (Routetype)tableio.getEntity(sql);
    }
    
    public Routetype getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Routetype)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Routetype> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Routetype> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Routetype> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Routetype> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertRoutetype(SQLTqueue transactionqueue, IRoutetype routetype) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, routetype);
    }

    public void insertupdateRoutetype(SQLTqueue transactionqueue, IRoutetype routetype) throws DBException, DataException {
    	checkDATA(routetype);
        if(this.getRoutetypeExists(routetype.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, routetype);
        } else {
            tableio.insertEntity(transactionqueue, routetype);
        }
    }

    public void updateRoutetype(SQLTqueue transactionqueue, IRoutetype routetype) throws DBException, DataException {
    	checkDATA(routetype);
        tableio.updateEntity(transactionqueue, routetype);
    }

    public void deleteRoutetype(SQLTqueue transactionqueue, IRoutetype routetype) throws DBException {
        cascadedeleteRoutetype(transactionqueue, routetype.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, routetype);
    }

    private void checkDATA(IRoutetype routetype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(routetype.getName()!=null && routetype.getName().length()>IRoutetype.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IRoutetype.SIZE_NAME).append("\n");
        }
        if(routetype.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where routetypePK is used in a primary key
     * @param routetypePK: Routetype primary key
     */
    public void cascadedeleteRoutetype(SQLTqueue transactionqueue, IRoutetypePK routetypePK) {
    }

    public void delete4security_island(SQLTqueue transactionqueue, ISecurity_islandPK security_islandPK) {
        tableio.addStatement(transactionqueue, EMroutetype.SQLDelete4security_island, security_islandPK.getSQLprimarykey());
    }

    public ArrayList<Routetype> getRoutetypes4security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        return tableio.getEntities(EMroutetype.SQLSelect4security_island, security_islandPK.getSQLprimarykey());
    }

    public ArrayList<Routetype> getRoutetypes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMroutetype.SQLSelect);
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
        return (ArrayList<Routetype>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delRoutetype(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Routetype.table);
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
