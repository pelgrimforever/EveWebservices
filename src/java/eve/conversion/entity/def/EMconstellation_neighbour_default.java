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
import eve.logicentity.Constellation_neighbour;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMconstellation_neighbour_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMconstellation_neighbour_default implements TableMapper {
    
    public static final String SQLWhere1 = "constellation = :constellation_neighbour.constellation: and neighbour = :constellation_neighbour.neighbour:";
    public static final String SQLSelect1 = "select constellation_neighbour.* from constellation_neighbour where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from constellation_neighbour where " + SQLWhere1;
    public static final String SQLSelectAll = "select constellation_neighbour.* from constellation_neighbour";

    public static final String SQLSelect = "select constellation_neighbour.* from constellation_neighbour";
    public static final String SQLWhereconstellationNeighbour = "neighbour = :constellation.id:";
    public static final String SQLWhereconstellationConstellation = "constellation = :constellation.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by constellation, neighbour";
//Custom code, do not change this line

    public static final String SQLSelect4constellationNeighbour = "select * from constellation_neighbour where " + SQLWhereconstellationNeighbour + OrderBy;
    public static final String SQLDelete4constellationNeighbour = "delete from constellation_neighbour where " + SQLWhereconstellationNeighbour;
    public static final String SQLSelect4constellationConstellation = "select * from constellation_neighbour where " + SQLWhereconstellationConstellation + OrderBy;
    public static final String SQLDelete4constellationConstellation = "delete from constellation_neighbour where " + SQLWhereconstellationConstellation;

    /**
     * 
     * @return SQL where clause for one Constellation_neighbour (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Constellation_neighbour (=Primarykey)
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
     * @return SQL select statement for all Constellation_neighbours
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Constellation_neighbour
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Constellation_neighbourPK constellation_neighbourPK = null;
        Constellation_neighbour constellation_neighbour;
        if(dbresult==null) {
            constellation_neighbour = new Constellation_neighbour(constellation_neighbourPK);
        } else {
            try {
                constellation_neighbourPK = new Constellation_neighbourPK(dbresult.getLong("constellation"), dbresult.getLong("neighbour"));
                constellation_neighbour = new Constellation_neighbour(constellation_neighbourPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return constellation_neighbour;
    }

}

