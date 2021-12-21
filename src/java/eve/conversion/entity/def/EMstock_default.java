/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 16.11.2021 15:46
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Stock;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMstock_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMstock_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :stock.username: and evetype = :stock.evetype:";
    public static final String SQLSelect1 = "select stock.* from stock where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from stock where " + SQLWhere1;
    public static final String SQLSelectAll = "select stock.* from stock";

    public static final String SQLSelect = "select stock.* from stock";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, evetype";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from stock where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from stock where " + SQLWhereevetype;

    /**
     * 
     * @return SQL where clause for one Stock (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Stock (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Stocks
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Stock
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StockPK stockPK = null;
        Stock stock;
        if(dbresult==null) {
            stock = new Stock(stockPK);
        } else {
            try {
                stockPK = new StockPK(dbresult.getString("username"), dbresult.getLong("evetype"));
                stock = new Stock(stockPK);
                stock.initAmount(dbresult.getLong("amount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return stock;
    }

}

