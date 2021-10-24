/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 24.9.2021 14:40
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Market_group;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMmarket_group_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMmarket_group_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :market_group.id:";
    public static final String SQLSelect1 = "select market_group.* from market_group where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from market_group where " + SQLWhere1;
    public static final String SQLSelectAll = "select market_group.* from market_group";

    public static final String SQLSelect = "select market_group.* from market_group";
    public static final String SQLWheremarket_groupParent_id = "parent_id = :market_group.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4market_groupParent_id = "select * from market_group where " + SQLWheremarket_groupParent_id + OrderBy;
    public static final String SQLDelete4market_groupParent_id = "delete from market_group where " + SQLWheremarket_groupParent_id;

    /**
     * 
     * @return SQL where clause for one Market_group (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Market_group (=Primarykey)
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
     * @return SQL select statement for all Market_groups
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Market_group
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Market_groupPK market_groupPK = null;
        Market_group market_group;
        if(dbresult==null) {
            market_group = new Market_group(market_groupPK);
        } else {
            try {
                market_groupPK = new Market_groupPK(dbresult.getLong("id"));
                market_group = new Market_group(market_groupPK);
                market_group.initMarket_groupparent_idPK(new Market_groupPK(dbresult.getLong("parent_id")));
                if(dbresult.wasNull()) market_group.setMarket_groupparent_idPK(null);                
                market_group.initName(dbresult.getString("name"));
                market_group.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return market_group;
    }

}

