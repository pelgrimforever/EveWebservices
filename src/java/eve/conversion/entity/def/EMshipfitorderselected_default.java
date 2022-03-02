/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 22.1.2022 10:54
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Shipfitorderselected;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMshipfitorderselected_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMshipfitorderselected_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :shipfitorderselected.username: and shipname = :shipfitorderselected.shipname: and evetype = :shipfitorderselected.evetype: and orderid = :shipfitorderselected.orderid:";
    public static final String SQLSelect1 = "select shipfitorderselected.* from shipfitorderselected where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from shipfitorderselected where " + SQLWhere1;
    public static final String SQLSelectAll = "select shipfitorderselected.* from shipfitorderselected";

    public static final String SQLSelect = "select shipfitorderselected.* from shipfitorderselected";
    public static final String SQLWhereorders = "orderid = :orders.id:";
    public static final String SQLWhereshipfitorder = "username = :shipfitorder.username: and shipname = :shipfitorder.shipname: and evetype = :shipfitorder.evetype:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, shipname, evetype, orderid";
//Custom code, do not change this line

    public static final String SQLSelect4orders = "select * from shipfitorderselected where " + SQLWhereorders + OrderBy;
    public static final String SQLDelete4orders = "delete from shipfitorderselected where " + SQLWhereorders;
    public static final String SQLSelect4shipfitorder = "select * from shipfitorderselected where " + SQLWhereshipfitorder + OrderBy;
    public static final String SQLDelete4shipfitorder = "delete from shipfitorderselected where " + SQLWhereshipfitorder;

    /**
     * 
     * @return SQL where clause for one Shipfitorderselected (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Shipfitorderselected (=Primarykey)
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
     * @return SQL select statement for all Shipfitorderselecteds
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Shipfitorderselected
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ShipfitorderselectedPK shipfitorderselectedPK = null;
        Shipfitorderselected shipfitorderselected;
        if(dbresult==null) {
            shipfitorderselected = new Shipfitorderselected(shipfitorderselectedPK);
        } else {
            try {
                shipfitorderselectedPK = new ShipfitorderselectedPK(dbresult.getString("username"), dbresult.getString("shipname"), dbresult.getLong("evetype"), dbresult.getLong("orderid"));
                shipfitorderselected = new Shipfitorderselected(shipfitorderselectedPK);
                shipfitorderselected.initAmount(dbresult.getInt("amount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return shipfitorderselected;
    }

}

