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
import eve.logicentity.Shipfitorder;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMshipfitorder_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "shipfitorder"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

