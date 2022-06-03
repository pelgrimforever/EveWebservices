/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.4.2022 10:3
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Region_neighbour;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMregion_neighbour_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMregion_neighbour_default implements TableMapper {
    
    public static final String SQLWhere1 = "region = :region_neighbour.region: and neighbour = :region_neighbour.neighbour:";
    public static final String SQLSelect1 = "select region_neighbour.* from region_neighbour where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from region_neighbour where " + SQLWhere1;
    public static final String SQLSelectAll = "select region_neighbour.* from region_neighbour";

    public static final String SQLSelect = "select region_neighbour.* from region_neighbour";
    public static final String SQLWhereregionRegion = "region = :region.id:";
    public static final String SQLWhereregionNeighbour = "neighbour = :region.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by region, neighbour";
//Custom code, do not change this line

    public static final String SQLSelect4regionRegion = "select * from region_neighbour where " + SQLWhereregionRegion + OrderBy;
    public static final String SQLDelete4regionRegion = "delete from region_neighbour where " + SQLWhereregionRegion;
    public static final String SQLSelect4regionNeighbour = "select * from region_neighbour where " + SQLWhereregionNeighbour + OrderBy;
    public static final String SQLDelete4regionNeighbour = "delete from region_neighbour where " + SQLWhereregionNeighbour;

    /**
     * 
     * @return SQL where clause for one Region_neighbour (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Region_neighbour (=Primarykey)
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
     * @return SQL select statement for all Region_neighbours
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Region_neighbour
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Region_neighbourPK region_neighbourPK = null;
        Region_neighbour region_neighbour;
        if(dbresult==null) {
            region_neighbour = new Region_neighbour(region_neighbourPK);
        } else {
            try {
                region_neighbourPK = new Region_neighbourPK(dbresult.getLong("region"), dbresult.getLong("neighbour"));
                region_neighbour = new Region_neighbour(region_neighbourPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return region_neighbour;
    }

}

