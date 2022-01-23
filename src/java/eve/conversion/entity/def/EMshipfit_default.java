/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 19.0.2022 22:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Shipfit;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMshipfit_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMshipfit_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Shipfits
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Shipfit
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

