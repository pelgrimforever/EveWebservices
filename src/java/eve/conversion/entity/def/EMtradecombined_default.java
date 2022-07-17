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
import eve.logicentity.Tradecombined;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMtradecombined_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "tradecombined"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

