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
import eve.conversion.entity.EMfrontendpage;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IFrontendpagesearch;
import eve.logicentity.Frontendpage;

public abstract class Bfrontendpage extends TableBusinessrules {

    public Bfrontendpage(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMfrontendpage()));
    }

    public Bfrontendpage(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMfrontendpage()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IFrontendpage newFrontendpage() {
    	return new Frontendpage();
    }
    
    public IFrontendpage newFrontendpage(java.lang.String name) {
        return new Frontendpage(name);
    }

    public IFrontendpage newFrontendpage(IFrontendpagePK frontendpagePK) {
        return new Frontendpage((FrontendpagePK)frontendpagePK);
    }

    public IFrontendpagePK newFrontendpagePK() {
        return new FrontendpagePK();
    }

    public IFrontendpagePK newFrontendpagePK(java.lang.String name) {
        return new FrontendpagePK(name);
    }

    public ArrayList<Frontendpage> getFrontendpages() throws DBException {
        return (ArrayList<Frontendpage>)tableio.getEntities(EMfrontendpage.SQLSelectAll);
    }

    public Frontendpage getFrontendpage(IFrontendpagePK frontendpagePK) throws DBException {
        return (Frontendpage)tableio.getEntity((FrontendpagePK)frontendpagePK);
    }

    public ArrayList<Frontendpage> searchfrontendpages(IFrontendpagesearch search) throws DBException {
        return (ArrayList<Frontendpage>)tableio.search(search);
    }

    public ArrayList<Frontendpage> searchfrontendpages(IFrontendpagesearch search, String orderby) throws DBException {
        return (ArrayList<Frontendpage>)tableio.search(search, orderby);
    }

    public boolean getFrontendpageExists(IFrontendpagePK frontendpagePK) throws DBException {
        return tableio.getEntityExists((FrontendpagePK)frontendpagePK);
    }

    public Frontendpage getEntity(String sql) throws DBException {
        return (Frontendpage)tableio.getEntity(sql);
    }
    
    public Frontendpage getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Frontendpage)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Frontendpage> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Frontendpage> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Frontendpage> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Frontendpage> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertFrontendpage(SQLTqueue transactionqueue, IFrontendpage frontendpage) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, frontendpage);
    }

    public void insertupdateFrontendpage(SQLTqueue transactionqueue, IFrontendpage frontendpage) throws DBException, DataException {
    	checkDATA(frontendpage);
        if(this.getFrontendpageExists(frontendpage.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, frontendpage);
        } else {
            tableio.insertEntity(transactionqueue, frontendpage);
        }
    }

    public void updateFrontendpage(SQLTqueue transactionqueue, IFrontendpage frontendpage) throws DBException, DataException {
    	checkDATA(frontendpage);
        tableio.updateEntity(transactionqueue, frontendpage);
    }

    public void deleteFrontendpage(SQLTqueue transactionqueue, IFrontendpage frontendpage) throws DBException {
        cascadedeleteFrontendpage(transactionqueue, frontendpage.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, frontendpage);
    }

    private void checkDATA(IFrontendpage frontendpage) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteFrontendpage(SQLTqueue transactionqueue, IFrontendpagePK frontendpagePK) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth(this);
        blfrontendpage_auth.setAuthenticated(isAuthenticated());
        blfrontendpage_auth.delete4frontendpage(transactionqueue, frontendpagePK);
    }

    public Frontendpage getFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws CustomException {
        FrontendpagePK frontendpagePK = new FrontendpagePK(frontendpage_authPK.getFrontendpage());
        return this.getFrontendpage(frontendpagePK);
    }


    public ArrayList<Frontendpage> getFrontendpages(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfrontendpage.SQLSelect);
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
        return (ArrayList<Frontendpage>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delFrontendpage(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Frontendpage.table);
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
