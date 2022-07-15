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
import eve.logicentity.Region;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMregion_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :region.id:";
    public static final String SQLSelect1 = "select region.* from region where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from region where " + SQLWhere1;
    public static final String SQLSelectAll = "select region.* from region";

    public static final String SQLSelect = "select region.* from region";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "region"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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
                region.initContractpages(dbresult.getInt("contractpages"));
                region.initContracterrors(dbresult.getInt("contracterrors"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return region;
    }

}

