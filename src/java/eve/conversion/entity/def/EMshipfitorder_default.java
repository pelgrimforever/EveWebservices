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
import eve.logicentity.Shipfitorder;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMshipfitorder_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMshipfitorder_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :shipfitorder.username: and shipname = :shipfitorder.shipname: and evetype = :shipfitorder.evetype:";
    public static final String SQLSelect1 = "select shipfitorder.* from shipfitorder where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from shipfitorder where " + SQLWhere1;
    public static final String SQLSelectAll = "select shipfitorder.* from shipfitorder";

    public static final String SQLSelect = "select shipfitorder.* from shipfitorder";
    public static final String SQLWhereshipfit = "username = :shipfit.username: and shipname = :shipfit.shipname:";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, shipname, evetype";
//Custom code, do not change this line

    public static final String SQLSelect4shipfit = "select * from shipfitorder where " + SQLWhereshipfit + OrderBy;
    public static final String SQLDelete4shipfit = "delete from shipfitorder where " + SQLWhereshipfit;
    public static final String SQLSelect4evetype = "select * from shipfitorder where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from shipfitorder where " + SQLWhereevetype;

    /**
     * 
     * @return SQL where clause for one Shipfitorder (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Shipfitorder (=Primarykey)
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
     * @return SQL select statement for all Shipfitorders
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Shipfitorder
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ShipfitorderPK shipfitorderPK = null;
        Shipfitorder shipfitorder;
        if(dbresult==null) {
            shipfitorder = new Shipfitorder(shipfitorderPK);
        } else {
            try {
                shipfitorderPK = new ShipfitorderPK(dbresult.getString("username"), dbresult.getString("shipname"), dbresult.getLong("evetype"));
                shipfitorder = new Shipfitorder(shipfitorderPK);
                shipfitorder.initAmountwanted(dbresult.getInt("amountwanted"));
                shipfitorder.initAmountinstock(dbresult.getInt("amountinstock"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return shipfitorder;
    }

}

