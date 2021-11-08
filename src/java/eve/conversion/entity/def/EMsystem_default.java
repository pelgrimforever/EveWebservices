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
import eve.logicentity.System;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsystem_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMsystem_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :system.id:";
    public static final String SQLSelect1 = "select system.* from system where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from system where " + SQLWhere1;
    public static final String SQLSelectAll = "select system.* from system";

    public static final String SQLSelect = "select system.* from system";
    public static final String SQLWheresecurity_island = "security_island = :security_island.id:";
    public static final String SQLWhereconstellation = "constellation = :constellation.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by name";
//Custom code, do not change this line

    public static final String SQLSelect4security_island = "select * from system where " + SQLWheresecurity_island + OrderBy;
    public static final String SQLDelete4security_island = "delete from system where " + SQLWheresecurity_island;
    public static final String SQLSelect4constellation = "select * from system where " + SQLWhereconstellation + OrderBy;
    public static final String SQLDelete4constellation = "delete from system where " + SQLWhereconstellation;

    /**
     * 
     * @return SQL where clause for one System (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one System (=Primarykey)
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
     * @return SQL select statement for all Systems
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to System
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SystemPK systemPK = null;
        System system;
        if(dbresult==null) {
            system = new System(systemPK);
        } else {
            try {
                systemPK = new SystemPK(dbresult.getLong("id"));
                system = new System(systemPK);
                system.initSecurity_islandPK(new Security_islandPK(dbresult.getLong("security_island")));
                if(dbresult.wasNull()) system.setSecurity_islandPK(null);                
                system.initConstellationPK(new ConstellationPK(dbresult.getLong("constellation")));
                if(dbresult.wasNull()) system.setConstellationPK(null);                
                system.initName(dbresult.getString("name"));
                system.initSecurity_class(dbresult.getString("security_class"));
                system.initSecurity_status(dbresult.getDouble("security_status"));
                system.initStar_id(dbresult.getLong("star_id"));
                system.initNoaccess(dbresult.getBoolean("noaccess"));
                system.initIsconstellationborder(dbresult.getBoolean("isconstellationborder"));
                system.initIsregionborder(dbresult.getBoolean("isregionborder"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return system;
    }

}

