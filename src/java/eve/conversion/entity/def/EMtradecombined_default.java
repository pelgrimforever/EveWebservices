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
import eve.logicentity.Tradecombined;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMtradecombined_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMtradecombined_default implements TableMapper {
    
    public static final String SQLWhere1 = "sell_system = :tradecombined.sell_system: and buy_system = :tradecombined.buy_system: and evetype = :tradecombined.evetype:";
    public static final String SQLSelect1 = "select tradecombined.* from tradecombined where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from tradecombined where " + SQLWhere1;
    public static final String SQLSelectAll = "select tradecombined.* from tradecombined";

    public static final String SQLSelect = "select tradecombined.* from tradecombined";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";
    public static final String SQLWheresystemBuy_system = "buy_system = :system.id:";
    public static final String SQLWheresystemSell_system = "sell_system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by buy_order_id, sell_system";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from tradecombined where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from tradecombined where " + SQLWhereevetype;
    public static final String SQLSelect4systemBuy_system = "select * from tradecombined where " + SQLWheresystemBuy_system + OrderBy;
    public static final String SQLDelete4systemBuy_system = "delete from tradecombined where " + SQLWheresystemBuy_system;
    public static final String SQLSelect4systemSell_system = "select * from tradecombined where " + SQLWheresystemSell_system + OrderBy;
    public static final String SQLDelete4systemSell_system = "delete from tradecombined where " + SQLWheresystemSell_system;

    /**
     * 
     * @return SQL where clause for one Tradecombined (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Tradecombined (=Primarykey)
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
     * @return SQL select statement for all Tradecombineds
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Tradecombined
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        TradecombinedPK tradecombinedPK = null;
        Tradecombined tradecombined;
        if(dbresult==null) {
            tradecombined = new Tradecombined(tradecombinedPK);
        } else {
            try {
                tradecombinedPK = new TradecombinedPK(dbresult.getLong("sell_system"), dbresult.getLong("buy_system"), dbresult.getLong("evetype"));
                tradecombined = new Tradecombined(tradecombinedPK);
                tradecombined.initJumps(dbresult.getInt("jumps"));
                tradecombined.initJumpslowsec(dbresult.getInt("jumpslowsec"));
                tradecombined.initJumpsnullsec(dbresult.getInt("jumpsnullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return tradecombined;
    }

}

