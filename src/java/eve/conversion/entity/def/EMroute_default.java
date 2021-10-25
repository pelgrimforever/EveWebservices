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
import eve.logicentity.Route;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMroute_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMroute_default implements TableMapper {
    
    public static final String SQLWhere1 = "routetype = :route.routetype: and system = :route.system:";
    public static final String SQLSelect1 = "select route.* from route where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from route where " + SQLWhere1;
    public static final String SQLSelectAll = "select route.* from route";

    public static final String SQLSelect = "select route.* from route";
    public static final String SQLWhereroutetype = "routetype = :routetype.id:";
    public static final String SQLWheresystem = "system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by routetype, system";
//Custom code, do not change this line

    public static final String SQLSelect4routetype = "select * from route where " + SQLWhereroutetype + OrderBy;
    public static final String SQLDelete4routetype = "delete from route where " + SQLWhereroutetype;
    public static final String SQLSelect4system = "select * from route where " + SQLWheresystem + OrderBy;
    public static final String SQLDelete4system = "delete from route where " + SQLWheresystem;

    /**
     * 
     * @return SQL where clause for one Route (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Route (=Primarykey)
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
     * @return SQL select statement for all Routes
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Route
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RoutePK routePK = null;
        Route route;
        if(dbresult==null) {
            route = new Route(routePK);
        } else {
            try {
                routePK = new RoutePK(dbresult.getLong("routetype"), dbresult.getLong("system"));
                route = new Route(routePK);
                String o_jsonroutes = dbresult.getString("jsonroutes");
                if(o_jsonroutes!=null) {
                    try {
                        Object jsonroutes_o_a = (new JSONParser()).parse(o_jsonroutes);
                        route.initJsonroutes(piJson.parse(jsonroutes_o_a));
                    }
                    catch(ParseException e) {
                    }                    
                }
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return route;
    }

}

