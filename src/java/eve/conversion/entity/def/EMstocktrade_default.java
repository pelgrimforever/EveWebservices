/*
 * Created on Okt 8, 2021
 * Generated on 17.6.2022 13:4
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Stocktrade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMstocktrade_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "username = :stocktrade.username: and evetype = :stocktrade.evetype: and orderid = :stocktrade.orderid:";
    public static final String SQLSelect1 = "select stocktrade.* from stocktrade where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from stocktrade where " + SQLWhere1;
    public static final String SQLSelectAll = "select stocktrade.* from stocktrade";

    public static final String SQLSelect = "select stocktrade.* from stocktrade";
    public static final String SQLWherestock = "username = :stock.username: and evetype = :stock.evetype:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, evetype, order";
//Custom code, do not change this line

    public static final String SQLSelect4stock = "select * from stocktrade where " + SQLWherestock + OrderBy;
    public static final String SQLDelete4stock = "delete from stocktrade where " + SQLWherestock;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "stocktrade"; }

    /**
     * 
     * @return SQL where clause for one Stocktrade (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Stocktrade (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StocktradePK stocktradePK = null;
        Stocktrade stocktrade;
        if(dbresult==null) {
            stocktrade = new Stocktrade(stocktradePK);
        } else {
            try {
                stocktradePK = new StocktradePK(dbresult.getString("username"), dbresult.getLong("evetype"), dbresult.getLong("orderid"));
                stocktrade = new Stocktrade(stocktradePK);
                stocktrade.initSellamount(dbresult.getLong("sellamount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return stocktrade;
    }

}

