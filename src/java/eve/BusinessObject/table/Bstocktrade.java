/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMstocktrade;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStocktradesearch;
import eve.logicentity.Stocktrade;

/**
 * @author Franky Laseure
 */
public abstract class Bstocktrade extends TableBusinessrules {

    public Bstocktrade(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMstocktrade()));
    }

    public Bstocktrade(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMstocktrade()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IStocktrade newStocktrade() {
    	return new Stocktrade();
    }
    
    public IStocktrade newStocktrade(java.lang.String username, long evetype, long orderid) {
        return new Stocktrade(username, evetype, orderid);
    }

    public IStocktrade newStocktrade(IStocktradePK stocktradePK) {
        return new Stocktrade((StocktradePK)stocktradePK);
    }

    public IStocktradePK newStocktradePK() {
        return new StocktradePK();
    }

    public IStocktradePK newStocktradePK(java.lang.String username, long evetype, long orderid) {
        return new StocktradePK(username, evetype, orderid);
    }

    public ArrayList<Stocktrade> getStocktrades() throws DBException {
        return (ArrayList<Stocktrade>)tableio.getEntities(EMstocktrade.SQLSelectAll);
    }

    public Stocktrade getStocktrade(IStocktradePK stocktradePK) throws DBException {
        return (Stocktrade)tableio.getEntity((StocktradePK)stocktradePK);
    }

    public ArrayList<Stocktrade> searchstocktrades(IStocktradesearch search) throws DBException {
        return (ArrayList<Stocktrade>)tableio.search(search);
    }

    public ArrayList<Stocktrade> searchstocktrades(IStocktradesearch search, String orderby) throws DBException {
        return (ArrayList<Stocktrade>)tableio.search(search, orderby);
    }

    public boolean getStocktradeExists(IStocktradePK stocktradePK) throws DBException {
        return tableio.getEntityExists((StocktradePK)stocktradePK);
    }

    public Stocktrade getEntity(String sql) throws DBException {
        return (Stocktrade)tableio.getEntity(sql);
    }
    
    public Stocktrade getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Stocktrade)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Stocktrade> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Stocktrade> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Stocktrade> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Stocktrade> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertStocktrade(SQLTqueue transactionqueue, IStocktrade stocktrade) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, stocktrade);
    }

    public void insertupdateStocktrade(SQLTqueue transactionqueue, IStocktrade stocktrade) throws DBException, DataException {
    	checkDATA(stocktrade);
        if(this.getStocktradeExists(stocktrade.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, stocktrade);
        } else {
            tableio.insertEntity(transactionqueue, stocktrade);
        }
    }

    public void updateStocktrade(SQLTqueue transactionqueue, IStocktrade stocktrade) throws DBException, DataException {
    	checkDATA(stocktrade);
        tableio.updateEntity(transactionqueue, stocktrade);
    }

    public void deleteStocktrade(SQLTqueue transactionqueue, IStocktrade stocktrade) throws DBException {
        cascadedeleteStocktrade(transactionqueue, stocktrade.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, stocktrade);
    }

    private void checkDATA(IStocktrade stocktrade) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Stocktrade.Username - Stock.Username
        //foreign key Stocktrade.Evetype - Stock.Evetype
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where stocktradePK is used in a primary key
     * @param stocktradePK: Stocktrade primary key
     */
    public void cascadedeleteStocktrade(SQLTqueue transactionqueue, IStocktradePK stocktradePK) {
    }

    public void delete4stock(SQLTqueue transactionqueue, IStockPK stockPK) {
        tableio.addStatement(transactionqueue, EMstocktrade.SQLDelete4stock, stockPK.getSQLprimarykey());
    }

    public ArrayList<Stocktrade> getStocktrades4stock(IStockPK stockPK) throws CustomException {
        return tableio.getEntities(EMstocktrade.SQLSelect4stock, stockPK.getSQLprimarykey());
    }

    public ArrayList<Stocktrade> getStocktrades(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstocktrade.SQLSelect);
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
        return (ArrayList<Stocktrade>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delStocktrade(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Stocktrade.table);
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
