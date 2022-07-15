/*
 * Created on Okt 8, 2021
 * Generated on 13.6.2022 11:21
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Orders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMorders_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :orders.id:";
    public static final String SQLSelect1 = "select orders.* from orders where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from orders where " + SQLWhere1;
    public static final String SQLSelectAll = "select orders.* from orders";

    public static final String SQLSelect = "select orders.* from orders";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";
    public static final String SQLWheresystem = "system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from orders where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from orders where " + SQLWhereevetype;
    public static final String SQLSelect4system = "select * from orders where " + SQLWheresystem + OrderBy;
    public static final String SQLDelete4system = "delete from orders where " + SQLWheresystem;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "orders"; }

    /**
     * 
     * @return SQL where clause for one Orders (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Orders (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        OrdersPK ordersPK = null;
        Orders orders;
        if(dbresult==null) {
            orders = new Orders(ordersPK);
        } else {
            try {
                ordersPK = new OrdersPK(dbresult.getLong("id"));
                orders = new Orders(ordersPK);
                orders.initEvetypePK(new EvetypePK(dbresult.getLong("evetype")));
                if(dbresult.wasNull()) orders.setEvetypePK(null);                
                orders.initSystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) orders.setSystemPK(null);                
                orders.initIsopen(dbresult.getBoolean("isopen"));
                orders.initVolume_total(dbresult.getLong("volume_total"));
                orders.initVolume_remain(dbresult.getLong("volume_remain"));
                orders.initRange(dbresult.getString("range"));
                orders.initRange_number(dbresult.getInt("range_number"));
                orders.initPrice(dbresult.getDouble("price"));
                orders.initMin_volume(dbresult.getInt("min_volume"));
                orders.initLocation(dbresult.getLong("location"));
                orders.initIs_buy_order(dbresult.getBoolean("is_buy_order"));
                orders.initIssued(dbresult.getTimestamp("issued"));
                orders.initDuration(dbresult.getInt("duration"));
                orders.initPage(dbresult.getInt("page"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return orders;
    }

}

