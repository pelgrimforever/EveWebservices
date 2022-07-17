/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMfrontendpage_auth;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IFrontendpage_authsearch;
import eve.logicentity.Frontendpage_auth;

/**
 * @author Franky Laseure
 */
public abstract class Bfrontendpage_auth extends TableBusinessrules {

    public Bfrontendpage_auth(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMfrontendpage_auth()));
    }

    public Bfrontendpage_auth(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMfrontendpage_auth()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IFrontendpage_auth newFrontendpage_auth() {
    	return new Frontendpage_auth();
    }
    
    public IFrontendpage_auth newFrontendpage_auth(java.lang.String username, java.lang.String frontendpage) {
        return new Frontendpage_auth(username, frontendpage);
    }

    public IFrontendpage_auth newFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) {
        return new Frontendpage_auth((Frontendpage_authPK)frontendpage_authPK);
    }

    public IFrontendpage_authPK newFrontendpage_authPK() {
        return new Frontendpage_authPK();
    }

    public IFrontendpage_authPK newFrontendpage_authPK(java.lang.String username, java.lang.String frontendpage) {
        return new Frontendpage_authPK(username, frontendpage);
    }

    public ArrayList<Frontendpage_auth> getFrontendpage_auths() throws DBException {
        return (ArrayList<Frontendpage_auth>)tableio.getEntities(EMfrontendpage_auth.SQLSelectAll);
    }

    public Frontendpage_auth getFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws DBException {
        return (Frontendpage_auth)tableio.getEntity((Frontendpage_authPK)frontendpage_authPK);
    }

    public ArrayList<Frontendpage_auth> searchfrontendpage_auths(IFrontendpage_authsearch search) throws DBException {
        return (ArrayList<Frontendpage_auth>)tableio.search(search);
    }

    public ArrayList<Frontendpage_auth> searchfrontendpage_auths(IFrontendpage_authsearch search, String orderby) throws DBException {
        return (ArrayList<Frontendpage_auth>)tableio.search(search, orderby);
    }

    public boolean getFrontendpage_authExists(IFrontendpage_authPK frontendpage_authPK) throws DBException {
        return tableio.getEntityExists((Frontendpage_authPK)frontendpage_authPK);
    }

    public Frontendpage_auth getEntity(String sql) throws DBException {
        return (Frontendpage_auth)tableio.getEntity(sql);
    }
    
    public Frontendpage_auth getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Frontendpage_auth)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Frontendpage_auth> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Frontendpage_auth> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Frontendpage_auth> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Frontendpage_auth> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertFrontendpage_auth(SQLTqueue transactionqueue, IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, frontendpage_auth);
    }

    public void insertupdateFrontendpage_auth(SQLTqueue transactionqueue, IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
    	checkDATA(frontendpage_auth);
        if(this.getFrontendpage_authExists(frontendpage_auth.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, frontendpage_auth);
        } else {
            tableio.insertEntity(transactionqueue, frontendpage_auth);
        }
    }

    public void updateFrontendpage_auth(SQLTqueue transactionqueue, IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
    	checkDATA(frontendpage_auth);
        tableio.updateEntity(transactionqueue, frontendpage_auth);
    }

    public void deleteFrontendpage_auth(SQLTqueue transactionqueue, IFrontendpage_auth frontendpage_auth) throws DBException {
        cascadedeleteFrontendpage_auth(transactionqueue, frontendpage_auth.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, frontendpage_auth);
    }

    private void checkDATA(IFrontendpage_auth frontendpage_auth) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Frontendpage_auth.Username - Eveuser.Username
        //foreign key Frontendpage_auth.Frontendpage - Frontendpage.Name
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where frontendpage_authPK is used in a primary key
     * @param frontendpage_authPK: Frontendpage_auth primary key
     */
    public void cascadedeleteFrontendpage_auth(SQLTqueue transactionqueue, IFrontendpage_authPK frontendpage_authPK) {
    }

    public void delete4frontendpage(SQLTqueue transactionqueue, IFrontendpagePK frontendpagePK) {
        tableio.addStatement(transactionqueue, EMfrontendpage_auth.SQLDelete4frontendpage, frontendpagePK.getSQLprimarykey());
    }

    public ArrayList<Frontendpage_auth> getFrontendpage_auths4frontendpage(IFrontendpagePK frontendpagePK) throws CustomException {
        return tableio.getEntities(EMfrontendpage_auth.SQLSelect4frontendpage, frontendpagePK.getSQLprimarykey());
    }
    public void delete4eveuser(SQLTqueue transactionqueue, IEveuserPK eveuserPK) {
        tableio.addStatement(transactionqueue, EMfrontendpage_auth.SQLDelete4eveuser, eveuserPK.getSQLprimarykey());
    }

    public ArrayList<Frontendpage_auth> getFrontendpage_auths4eveuser(IEveuserPK eveuserPK) throws CustomException {
        return tableio.getEntities(EMfrontendpage_auth.SQLSelect4eveuser, eveuserPK.getSQLprimarykey());
    }

    public ArrayList<Frontendpage_auth> getFrontendpage_auths(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfrontendpage_auth.SQLSelect);
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
        return (ArrayList<Frontendpage_auth>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delFrontendpage_auth(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Frontendpage_auth.table);
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
