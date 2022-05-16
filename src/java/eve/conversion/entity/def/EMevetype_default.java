/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.4.2022 19:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Evetype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMevetype_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMevetype_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :evetype.id:";
    public static final String SQLSelect1 = "select evetype.* from evetype where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from evetype where " + SQLWhere1;
    public static final String SQLSelectAll = "select evetype.* from evetype";

    public static final String SQLSelect = "select evetype.* from evetype";
    public static final String SQLWheremarket_group = "market_group = :market_group.id:";
    public static final String SQLWheretypegroup = "typegroup = :typegroup.id:";
    public static final String SQLWheregraphic = "graphic = :graphic.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4market_group = "select * from evetype where " + SQLWheremarket_group + OrderBy;
    public static final String SQLDelete4market_group = "delete from evetype where " + SQLWheremarket_group;
    public static final String SQLSelect4typegroup = "select * from evetype where " + SQLWheretypegroup + OrderBy;
    public static final String SQLDelete4typegroup = "delete from evetype where " + SQLWheretypegroup;
    public static final String SQLSelect4graphic = "select * from evetype where " + SQLWheregraphic + OrderBy;
    public static final String SQLDelete4graphic = "delete from evetype where " + SQLWheregraphic;

    /**
     * 
     * @return SQL where clause for one Evetype (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Evetype (=Primarykey)
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
     * @return SQL select statement for all Evetypes
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Evetype
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        EvetypePK evetypePK = null;
        Evetype evetype;
        if(dbresult==null) {
            evetype = new Evetype(evetypePK);
        } else {
            try {
                evetypePK = new EvetypePK(dbresult.getLong("id"));
                evetype = new Evetype(evetypePK);
                evetype.initMarket_groupPK(new Market_groupPK(dbresult.getLong("market_group")));
                if(dbresult.wasNull()) evetype.setMarket_groupPK(null);                
                evetype.initTypegroupPK(new TypegroupPK(dbresult.getLong("typegroup")));
                if(dbresult.wasNull()) evetype.setTypegroupPK(null);                
                evetype.initGraphicPK(new GraphicPK(dbresult.getLong("graphic")));
                if(dbresult.wasNull()) evetype.setGraphicPK(null);                
                evetype.initName(dbresult.getString("name"));
                evetype.initPublished(dbresult.getBoolean("published"));
                evetype.initDescription(dbresult.getString("description"));
                evetype.initCapacity(dbresult.getDouble("capacity"));
                evetype.initIcon(dbresult.getLong("icon"));
                evetype.initMass(dbresult.getDouble("mass"));
                evetype.initPackaged_volume(dbresult.getDouble("packaged_volume"));
                evetype.initPortion_size(dbresult.getInt("portion_size"));
                evetype.initRadius(dbresult.getDouble("radius"));
                evetype.initVolume(dbresult.getDouble("volume"));
                evetype.initAvg_buyorder(dbresult.getDouble("avg_buyorder"));
                evetype.initAvg_sellorder(dbresult.getDouble("avg_sellorder"));
                evetype.initMin_buyorder(dbresult.getDouble("min_buyorder"));
                evetype.initMax_buyorder(dbresult.getDouble("max_buyorder"));
                evetype.initMin_selorder(dbresult.getDouble("min_selorder"));
                evetype.initMax_selorder(dbresult.getDouble("max_selorder"));
                evetype.initAverage(dbresult.getDouble("average"));
                evetype.initHighest(dbresult.getDouble("highest"));
                evetype.initLowest(dbresult.getDouble("lowest"));
                evetype.initOrder_count(dbresult.getLong("order_count"));
                evetype.initConfiguredbp(dbresult.getBoolean("configuredbp"));
                evetype.initEstimatedproductioncost(dbresult.getDouble("estimatedproductioncost"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return evetype;
    }

}

