/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Stock;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMstock_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "stock"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

