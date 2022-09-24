/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Shipfit;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMshipfit_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "username = :shipfit.username: and shipname = :shipfit.shipname:";
    public static final String SQLSelect1 = "select shipfit.* from shipfit where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from shipfit where " + SQLWhere1;
    public static final String SQLSelectAll = "select shipfit.* from shipfit";

    public static final String SQLSelect = "select shipfit.* from shipfit";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by shipname";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from shipfit where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from shipfit where " + SQLWhereevetype;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "shipfit"; }

    /**
     * 
     * @return SQL where clause for one Shipfit (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Shipfit (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ShipfitPK shipfitPK = null;
        Shipfit shipfit;
        if(dbresult==null) {
            shipfit = new Shipfit(shipfitPK);
        } else {
            try {
                shipfitPK = new ShipfitPK(dbresult.getString("username"), dbresult.getString("shipname"));
                shipfit = new Shipfit(shipfitPK);
                shipfit.initEvetypePK(new EvetypePK(dbresult.getLong("evetype")));
                if(dbresult.wasNull()) shipfit.setEvetypePK(null);                
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return shipfit;
    }

}

