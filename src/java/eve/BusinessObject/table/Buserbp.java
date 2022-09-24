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
import eve.conversion.entity.EMuserbp;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IUserbpsearch;
import eve.logicentity.Userbp;

public abstract class Buserbp extends TableBusinessrules {

    public Buserbp(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMuserbp()));
    }

    public Buserbp(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMuserbp()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IUserbp newUserbp() {
    	return new Userbp();
    }
    
    public IUserbp newUserbp(java.lang.String username, long bp, int serialnumber) {
        return new Userbp(username, bp, serialnumber);
    }

    public IUserbp newUserbp(IUserbpPK userbpPK) {
        return new Userbp((UserbpPK)userbpPK);
    }

    public IUserbpPK newUserbpPK() {
        return new UserbpPK();
    }

    public IUserbpPK newUserbpPK(java.lang.String username, long bp, int serialnumber) {
        return new UserbpPK(username, bp, serialnumber);
    }

    public ArrayList<Userbp> getUserbps() throws DBException {
        return (ArrayList<Userbp>)tableio.getEntities(EMuserbp.SQLSelectAll);
    }

    public Userbp getUserbp(IUserbpPK userbpPK) throws DBException {
        return (Userbp)tableio.getEntity((UserbpPK)userbpPK);
    }

    public ArrayList<Userbp> searchuserbps(IUserbpsearch search) throws DBException {
        return (ArrayList<Userbp>)tableio.search(search);
    }

    public ArrayList<Userbp> searchuserbps(IUserbpsearch search, String orderby) throws DBException {
        return (ArrayList<Userbp>)tableio.search(search, orderby);
    }

    public boolean getUserbpExists(IUserbpPK userbpPK) throws DBException {
        return tableio.getEntityExists((UserbpPK)userbpPK);
    }

    public Userbp getEntity(String sql) throws DBException {
        return (Userbp)tableio.getEntity(sql);
    }
    
    public Userbp getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Userbp)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Userbp> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Userbp> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Userbp> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Userbp> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertUserbp(SQLTqueue transactionqueue, IUserbp userbp) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, userbp);
    }

    public void insertupdateUserbp(SQLTqueue transactionqueue, IUserbp userbp) throws DBException, DataException {
    	checkDATA(userbp);
        if(this.getUserbpExists(userbp.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, userbp);
        } else {
            tableio.insertEntity(transactionqueue, userbp);
        }
    }

    public void updateUserbp(SQLTqueue transactionqueue, IUserbp userbp) throws DBException, DataException {
    	checkDATA(userbp);
        tableio.updateEntity(transactionqueue, userbp);
    }

    public void deleteUserbp(SQLTqueue transactionqueue, IUserbp userbp) throws DBException {
        cascadedeleteUserbp(transactionqueue, userbp.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, userbp);
    }

    private void checkDATA(IUserbp userbp) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Userbp.Bp - Evetype.Id
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteUserbp(SQLTqueue transactionqueue, IUserbpPK userbpPK) {
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMuserbp.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Userbp> getUserbps4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMuserbp.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Userbp> getUserbps(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMuserbp.SQLSelect);
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
        return (ArrayList<Userbp>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delUserbp(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Userbp.table);
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
