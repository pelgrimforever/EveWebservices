/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMsyssettings;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISyssettingssearch;
import eve.logicentity.Syssettings;

/**
 * @author Franky Laseure
 */
public abstract class Bsyssettings extends TableBusinessrules {

    public Bsyssettings(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsyssettings()));
    }

    public Bsyssettings(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsyssettings()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISyssettings newSyssettings() {
    	return new Syssettings();
    }
    
    public ISyssettings newSyssettings(java.lang.String name) {
        return new Syssettings(name);
    }

    public ISyssettings newSyssettings(ISyssettingsPK syssettingsPK) {
        return new Syssettings((SyssettingsPK)syssettingsPK);
    }

    public ISyssettingsPK newSyssettingsPK() {
        return new SyssettingsPK();
    }

    public ISyssettingsPK newSyssettingsPK(java.lang.String name) {
        return new SyssettingsPK(name);
    }

    public ArrayList<Syssettings> getSyssettingss() throws DBException {
        return (ArrayList<Syssettings>)tableio.getEntities(EMsyssettings.SQLSelectAll);
    }

    public Syssettings getSyssettings(ISyssettingsPK syssettingsPK) throws DBException {
        return (Syssettings)tableio.getEntity((SyssettingsPK)syssettingsPK);
    }

    public ArrayList<Syssettings> searchsyssettingss(ISyssettingssearch search) throws DBException {
        return (ArrayList<Syssettings>)tableio.search(search);
    }

    public ArrayList<Syssettings> searchsyssettingss(ISyssettingssearch search, String orderby) throws DBException {
        return (ArrayList<Syssettings>)tableio.search(search, orderby);
    }

    public boolean getSyssettingsExists(ISyssettingsPK syssettingsPK) throws DBException {
        return tableio.getEntityExists((SyssettingsPK)syssettingsPK);
    }

    public Syssettings getEntity(String sql) throws DBException {
        return (Syssettings)tableio.getEntity(sql);
    }
    
    public Syssettings getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Syssettings)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Syssettings> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Syssettings> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Syssettings> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Syssettings> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSyssettings(SQLTqueue transactionqueue, ISyssettings syssettings) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, syssettings);
    }

    public void insertupdateSyssettings(SQLTqueue transactionqueue, ISyssettings syssettings) throws DBException, DataException {
    	checkDATA(syssettings);
        if(this.getSyssettingsExists(syssettings.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, syssettings);
        } else {
            tableio.insertEntity(transactionqueue, syssettings);
        }
    }

    public void updateSyssettings(SQLTqueue transactionqueue, ISyssettings syssettings) throws DBException, DataException {
    	checkDATA(syssettings);
        tableio.updateEntity(transactionqueue, syssettings);
    }

    public void deleteSyssettings(SQLTqueue transactionqueue, ISyssettings syssettings) throws DBException {
        cascadedeleteSyssettings(transactionqueue, syssettings.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, syssettings);
    }

    private void checkDATA(ISyssettings syssettings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(syssettings.getValue()!=null && syssettings.getValue().length()>ISyssettings.SIZE_VALUE) {
            message.append("Value is langer dan toegestaan. Max aantal karakters: ").append(ISyssettings.SIZE_VALUE).append("\n");
        }
        if(syssettings.getValue()==null) {
            message.append("Value mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where syssettingsPK is used in a primary key
     * @param syssettingsPK: Syssettings primary key
     */
    public void cascadedeleteSyssettings(SQLTqueue transactionqueue, ISyssettingsPK syssettingsPK) {
    }


    public ArrayList<Syssettings> getSyssettingss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsyssettings.SQLSelect);
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
        return (ArrayList<Syssettings>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSyssettings(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Syssettings.table);
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
