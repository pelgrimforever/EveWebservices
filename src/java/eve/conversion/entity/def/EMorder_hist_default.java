/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 25.9.2021 15:16
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Order_hist;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMorder_hist_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMorder_hist_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :order_hist.id:";
    public static final String SQLSelect1 = "select order_hist.* from order_hist where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from order_hist where " + SQLWhere1;
    public static final String SQLSelectAll = "select order_hist.* from order_hist";

    public static final String SQLSelect = "select order_hist.* from order_hist";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";
    public static final String SQLWheresystem = "system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from order_hist where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from order_hist where " + SQLWhereevetype;
    public static final String SQLSelect4system = "select * from order_hist where " + SQLWheresystem + OrderBy;
    public static final String SQLDelete4system = "delete from order_hist where " + SQLWheresystem;

    /**
     * 
     * @return SQL where clause for one Order_hist (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Order_hist (=Primarykey)
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
     * @return SQL select statement for all Order_hists
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Order_hist
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_histPK order_histPK = null;
        Order_hist order_hist;
        if(dbresult==null) {
            order_hist = new Order_hist(order_histPK);
        } else {
            try {
                order_histPK = new Order_histPK(dbresult.getLong("id"));
                order_hist = new Order_hist(order_histPK);
                order_hist.initEvetypePK(new EvetypePK(dbresult.getLong("evetype")));
                if(dbresult.wasNull()) order_hist.setEvetypePK(null);                
                order_hist.initSystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) order_hist.setSystemPK(null);                
                order_hist.initIsopen(dbresult.getBoolean("isopen"));
                order_hist.initVolume_total(dbresult.getInt("volume_total"));
                order_hist.initVolume_remain(dbresult.getInt("volume_remain"));
                order_hist.initRange(dbresult.getString("range"));
                order_hist.initRange_number(dbresult.getInt("range_number"));
                order_hist.initPrice(dbresult.getDouble("price"));
                order_hist.initMin_volume(dbresult.getInt("min_volume"));
                order_hist.initLocation(dbresult.getLong("location"));
                order_hist.initIs_buy_order(dbresult.getBoolean("is_buy_order"));
                order_hist.initIssued(dbresult.getTimestamp("issued"));
                order_hist.initDuration(dbresult.getInt("duration"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return order_hist;
    }

}

