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
import eve.logicentity.Order_history_month;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMorder_history_month_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "region = :order_history_month.region: and evetype = :order_history_month.evetype: and year = :order_history_month.year: and month = :order_history_month.month:";
    public static final String SQLSelect1 = "select order_history_month.* from order_history_month where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from order_history_month where " + SQLWhere1;
    public static final String SQLSelectAll = "select order_history_month.* from order_history_month";

    public static final String SQLSelect = "select order_history_month.* from order_history_month";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";
    public static final String SQLWhereregion = "region = :region.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by region, evetype, year, month";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from order_history_month where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from order_history_month where " + SQLWhereevetype;
    public static final String SQLSelect4region = "select * from order_history_month where " + SQLWhereregion + OrderBy;
    public static final String SQLDelete4region = "delete from order_history_month where " + SQLWhereregion;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "order_history_month"; }

    /**
     * 
     * @return SQL where clause for one Order_history_month (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Order_history_month (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_history_monthPK order_history_monthPK = null;
        Order_history_month order_history_month;
        if(dbresult==null) {
            order_history_month = new Order_history_month(order_history_monthPK);
        } else {
            try {
                order_history_monthPK = new Order_history_monthPK(dbresult.getLong("region"), dbresult.getLong("evetype"), dbresult.getInt("year"), dbresult.getInt("month"));
                order_history_month = new Order_history_month(order_history_monthPK);
                order_history_month.initAverage(dbresult.getDouble("average"));
                order_history_month.initHighest(dbresult.getDouble("highest"));
                order_history_month.initLowest(dbresult.getDouble("lowest"));
                order_history_month.initVolume(dbresult.getLong("volume"));
                order_history_month.initOrder_count(dbresult.getLong("order_count"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return order_history_month;
    }

}

