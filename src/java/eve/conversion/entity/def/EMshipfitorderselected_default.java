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
import eve.logicentity.Shipfitorderselected;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMshipfitorderselected_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "shipfitorderselected"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

