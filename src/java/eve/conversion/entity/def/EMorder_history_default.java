/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.11.2021 14:30
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Order_history;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMorder_history_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMorder_history_default implements TableMapper {
    
    public static final String SQLWhere1 = "region = :order_history.region: and evetype = :order_history.evetype: and date = :order_history.date:";
    public static final String SQLSelect1 = "select order_history.* from order_history where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from order_history where " + SQLWhere1;
    public static final String SQLSelectAll = "select order_history.* from order_history";

    public static final String SQLSelect = "select order_history.* from order_history";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";
    public static final String SQLWhereregion = "region = :region.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by region, evetype, date";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from order_history where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from order_history where " + SQLWhereevetype;
    public static final String SQLSelect4region = "select * from order_history where " + SQLWhereregion + OrderBy;
    public static final String SQLDelete4region = "delete from order_history where " + SQLWhereregion;

    /**
     * 
     * @return SQL where clause for one Order_history (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Order_history (=Primarykey)
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
     * @return SQL select statement for all Order_historys
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Order_history
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_historyPK order_historyPK = null;
        Order_history order_history;
        if(dbresult==null) {
            order_history = new Order_history(order_historyPK);
        } else {
            try {
                order_historyPK = new Order_historyPK(dbresult.getLong("region"), dbresult.getLong("evetype"), dbresult.getDate("date"));
                order_history = new Order_history(order_historyPK);
                order_history.initAverage(dbresult.getDouble("average"));
                order_history.initHighest(dbresult.getDouble("highest"));
                order_history.initLowest(dbresult.getDouble("lowest"));
                order_history.initVolume(dbresult.getInt("volume"));
                order_history.initOrder_count(dbresult.getInt("order_count"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return order_history;
    }

}

