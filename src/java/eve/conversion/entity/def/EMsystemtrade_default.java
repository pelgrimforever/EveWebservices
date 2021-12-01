/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 30.10.2021 10:3
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Systemtrade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsystemtrade_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMsystemtrade_default implements TableMapper {
    
    public static final String SQLWhere1 = "sell_system = :systemtrade.sell_system: and buy_system = :systemtrade.buy_system:";
    public static final String SQLSelect1 = "select systemtrade.* from systemtrade where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from systemtrade where " + SQLWhere1;
    public static final String SQLSelectAll = "select systemtrade.* from systemtrade";

    public static final String SQLSelect = "select systemtrade.* from systemtrade";
    public static final String SQLWheresystemSell_system = "sell_system = :system.id:";
    public static final String SQLWheresystemBuy_system = "buy_system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by sell_system, buy_system";
//Custom code, do not change this line

    public static final String SQLSelect4systemSell_system = "select * from systemtrade where " + SQLWheresystemSell_system + OrderBy;
    public static final String SQLDelete4systemSell_system = "delete from systemtrade where " + SQLWheresystemSell_system;
    public static final String SQLSelect4systemBuy_system = "select * from systemtrade where " + SQLWheresystemBuy_system + OrderBy;
    public static final String SQLDelete4systemBuy_system = "delete from systemtrade where " + SQLWheresystemBuy_system;

    /**
     * 
     * @return SQL where clause for one Systemtrade (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Systemtrade (=Primarykey)
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
     * @return SQL select statement for all Systemtrades
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Systemtrade
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SystemtradePK systemtradePK = null;
        Systemtrade systemtrade;
        if(dbresult==null) {
            systemtrade = new Systemtrade(systemtradePK);
        } else {
            try {
                systemtradePK = new SystemtradePK(dbresult.getLong("sell_system"), dbresult.getLong("buy_system"));
                systemtrade = new Systemtrade(systemtradePK);
                systemtrade.initProfit(dbresult.getDouble("profit"));
                systemtrade.initTotal_cargo_volume(dbresult.getDouble("total_cargo_volume"));
                systemtrade.initJumps(dbresult.getInt("jumps"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return systemtrade;
    }

}

