/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 31.0.2022 17:49
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Shipfitmodule;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMshipfitmodule_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMshipfitmodule_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :shipfitmodule.username: and shipname = :shipfitmodule.shipname: and moduletype = :shipfitmodule.moduletype:";
    public static final String SQLSelect1 = "select shipfitmodule.* from shipfitmodule where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from shipfitmodule where " + SQLWhere1;
    public static final String SQLSelectAll = "select shipfitmodule.* from shipfitmodule";

    public static final String SQLSelect = "select shipfitmodule.* from shipfitmodule";
    public static final String SQLWhereevetype = "moduletype = :evetype.id:";
    public static final String SQLWhereshipfit = "username = :shipfit.username: and shipname = :shipfit.shipname:";

//Custom code, do not change this line
    public static final String OrderBy = " order by shipname, moduletype";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from shipfitmodule where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from shipfitmodule where " + SQLWhereevetype;
    public static final String SQLSelect4shipfit = "select * from shipfitmodule where " + SQLWhereshipfit + OrderBy;
    public static final String SQLDelete4shipfit = "delete from shipfitmodule where " + SQLWhereshipfit;

    /**
     * 
     * @return SQL where clause for one Shipfitmodule (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Shipfitmodule (=Primarykey)
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
     * @return SQL select statement for all Shipfitmodules
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Shipfitmodule
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ShipfitmodulePK shipfitmodulePK = null;
        Shipfitmodule shipfitmodule;
        if(dbresult==null) {
            shipfitmodule = new Shipfitmodule(shipfitmodulePK);
        } else {
            try {
                shipfitmodulePK = new ShipfitmodulePK(dbresult.getString("username"), dbresult.getString("shipname"), dbresult.getLong("moduletype"));
                shipfitmodule = new Shipfitmodule(shipfitmodulePK);
                shipfitmodule.initAmount(dbresult.getInt("amount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return shipfitmodule;
    }

}

