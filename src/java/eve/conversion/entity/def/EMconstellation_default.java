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
import eve.logicentity.Constellation;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMconstellation_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMconstellation_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :constellation.id:";
    public static final String SQLSelect1 = "select constellation.* from constellation where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from constellation where " + SQLWhere1;
    public static final String SQLSelectAll = "select constellation.* from constellation";

    public static final String SQLSelect = "select constellation.* from constellation";
    public static final String SQLWhereregion = "region = :region.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4region = "select * from constellation where " + SQLWhereregion + OrderBy;
    public static final String SQLDelete4region = "delete from constellation where " + SQLWhereregion;

    /**
     * 
     * @return SQL where clause for one Constellation (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Constellation (=Primarykey)
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
     * @return SQL select statement for all Constellations
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Constellation
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ConstellationPK constellationPK = null;
        Constellation constellation;
        if(dbresult==null) {
            constellation = new Constellation(constellationPK);
        } else {
            try {
                constellationPK = new ConstellationPK(dbresult.getLong("id"));
                constellation = new Constellation(constellationPK);
                constellation.initRegionPK(new RegionPK(dbresult.getLong("region")));
                if(dbresult.wasNull()) constellation.setRegionPK(null);                
                constellation.initName(dbresult.getString("name"));
                constellation.initNoaccess(dbresult.getBoolean("noaccess"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return constellation;
    }

}

