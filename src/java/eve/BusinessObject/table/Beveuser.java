/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMeveuser;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IEveusersearch;
import eve.logicentity.Eveuser;

/**
 * @author Franky Laseure
 */
public abstract class Beveuser extends TableBusinessrules {

    public Beveuser(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMeveuser()));
    }

    public Beveuser(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMeveuser()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IEveuser newEveuser() {
    	return new Eveuser();
    }
    
    public IEveuser newEveuser(java.lang.String username) {
        return new Eveuser(username);
    }

    public IEveuser newEveuser(IEveuserPK eveuserPK) {
        return new Eveuser((EveuserPK)eveuserPK);
    }

    public IEveuserPK newEveuserPK() {
        return new EveuserPK();
    }

    public IEveuserPK newEveuserPK(java.lang.String username) {
        return new EveuserPK(username);
    }

    public ArrayList<Eveuser> getEveusers() throws DBException {
        return (ArrayList<Eveuser>)tableio.getEntities(EMeveuser.SQLSelectAll);
    }

    public Eveuser getEveuser(IEveuserPK eveuserPK) throws DBException {
        return (Eveuser)tableio.getEntity((EveuserPK)eveuserPK);
    }

    public ArrayList<Eveuser> searcheveusers(IEveusersearch search) throws DBException {
        return (ArrayList<Eveuser>)tableio.search(search);
    }

    public ArrayList<Eveuser> searcheveusers(IEveusersearch search, String orderby) throws DBException {
        return (ArrayList<Eveuser>)tableio.search(search, orderby);
    }

    public boolean getEveuserExists(IEveuserPK eveuserPK) throws DBException {
        return tableio.getEntityExists((EveuserPK)eveuserPK);
    }

    public Eveuser getEntity(String sql) throws DBException {
        return (Eveuser)tableio.getEntity(sql);
    }
    
    public Eveuser getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Eveuser)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Eveuser> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Eveuser> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Eveuser> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Eveuser> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertEveuser(SQLTqueue transactionqueue, IEveuser eveuser) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, eveuser);
    }

    public void insertupdateEveuser(SQLTqueue transactionqueue, IEveuser eveuser) throws DBException, DataException {
    	checkDATA(eveuser);
        if(this.getEveuserExists(eveuser.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, eveuser);
        } else {
            tableio.insertEntity(transactionqueue, eveuser);
        }
    }

    public void updateEveuser(SQLTqueue transactionqueue, IEveuser eveuser) throws DBException, DataException {
    	checkDATA(eveuser);
        tableio.updateEntity(transactionqueue, eveuser);
    }

    public void deleteEveuser(SQLTqueue transactionqueue, IEveuser eveuser) throws DBException {
        cascadedeleteEveuser(transactionqueue, eveuser.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, eveuser);
    }

    private void checkDATA(IEveuser eveuser) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(eveuser.getCreatedat()==null) {
            message.append("Createdat mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where eveuserPK is used in a primary key
     * @param eveuserPK: Eveuser primary key
     */
    public void cascadedeleteEveuser(SQLTqueue transactionqueue, IEveuserPK eveuserPK) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth(this);
        blfrontendpage_auth.setAuthenticated(isAuthenticated());
        blfrontendpage_auth.delete4eveuser(transactionqueue, eveuserPK);
    }

    public Eveuser getFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws CustomException {
        EveuserPK eveuserPK = new EveuserPK(frontendpage_authPK.getUsername());
        return this.getEveuser(eveuserPK);
    }


    public ArrayList<Eveuser> getEveusers(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMeveuser.SQLSelect);
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
        return (ArrayList<Eveuser>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delEveuser(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Eveuser.table);
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
