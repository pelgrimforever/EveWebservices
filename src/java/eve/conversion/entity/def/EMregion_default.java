/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 8.10.2021 7:21
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Region;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMregion_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMregion_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :region.id:";
    public static final String SQLSelect1 = "select region.* from region where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from region where " + SQLWhere1;
    public static final String SQLSelectAll = "select region.* from region";

    public static final String SQLSelect = "select region.* from region";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Region (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Region (=Primarykey)
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
     * @return SQL select statement for all Regions
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Region
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RegionPK regionPK = null;
        Region region;
        if(dbresult==null) {
            region = new Region(regionPK);
        } else {
            try {
                regionPK = new RegionPK(dbresult.getLong("id"));
                region = new Region(regionPK);
                region.initName(dbresult.getString("name"));
                region.initNoaccess(dbresult.getBoolean("noaccess"));
                region.initOrderpages(dbresult.getInt("orderpages"));
                region.initOrdererrors(dbresult.getInt("ordererrors"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return region;
    }

}

