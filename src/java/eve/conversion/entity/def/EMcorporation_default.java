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
import eve.logicentity.Corporation;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMcorporation_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :corporation.id:";
    public static final String SQLSelect1 = "select corporation.* from corporation where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from corporation where " + SQLWhere1;
    public static final String SQLSelectAll = "select corporation.* from corporation";

    public static final String SQLSelect = "select corporation.* from corporation";
    public static final String SQLWherestation = "home_station = :station.id:";
    public static final String SQLWherefaction = "faction = :faction.id:";
    public static final String SQLWherealliance = "alliance = :alliance.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4station = "select * from corporation where " + SQLWherestation + OrderBy;
    public static final String SQLDelete4station = "delete from corporation where " + SQLWherestation;
    public static final String SQLSelect4faction = "select * from corporation where " + SQLWherefaction + OrderBy;
    public static final String SQLDelete4faction = "delete from corporation where " + SQLWherefaction;
    public static final String SQLSelect4alliance = "select * from corporation where " + SQLWherealliance + OrderBy;
    public static final String SQLDelete4alliance = "delete from corporation where " + SQLWherealliance;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "corporation"; }

    /**
     * 
     * @return SQL where clause for one Corporation (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Corporation (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CorporationPK corporationPK = null;
        Corporation corporation;
        if(dbresult==null) {
            corporation = new Corporation(corporationPK);
        } else {
            try {
                corporationPK = new CorporationPK(dbresult.getLong("id"));
                corporation = new Corporation(corporationPK);
                corporation.initStationPK(new StationPK(dbresult.getLong("home_station")));
                if(dbresult.wasNull()) corporation.setStationPK(null);                
                corporation.initFactionPK(new FactionPK(dbresult.getLong("faction")));
                if(dbresult.wasNull()) corporation.setFactionPK(null);                
                corporation.initAlliancePK(new AlliancePK(dbresult.getLong("alliance")));
                if(dbresult.wasNull()) corporation.setAlliancePK(null);                
                corporation.initName(dbresult.getString("name"));
                corporation.initCeo(dbresult.getLong("ceo"));
                corporation.initCreator(dbresult.getLong("creator"));
                corporation.initMember_count(dbresult.getInt("member_count"));
                corporation.initTax_rate(dbresult.getDouble("tax_rate"));
                corporation.initTicker(dbresult.getString("ticker"));
                corporation.initDate_founded(dbresult.getTimestamp("date_founded"));
                corporation.initDescription(dbresult.getString("description"));
                corporation.initShares(dbresult.getInt("shares"));
                corporation.initUrl(dbresult.getString("url"));
                corporation.initWar_eligible(dbresult.getBoolean("war_eligible"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return corporation;
    }

}

