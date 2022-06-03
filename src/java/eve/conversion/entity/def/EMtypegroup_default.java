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
import eve.logicentity.Typegroup;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMtypegroup_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMtypegroup_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :typegroup.id:";
    public static final String SQLSelect1 = "select typegroup.* from typegroup where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from typegroup where " + SQLWhere1;
    public static final String SQLSelectAll = "select typegroup.* from typegroup";

    public static final String SQLSelect = "select typegroup.* from typegroup";
    public static final String SQLWherecategory = "category = :category.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4category = "select * from typegroup where " + SQLWherecategory + OrderBy;
    public static final String SQLDelete4category = "delete from typegroup where " + SQLWherecategory;

    /**
     * 
     * @return SQL where clause for one Typegroup (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Typegroup (=Primarykey)
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
     * @return SQL select statement for all Typegroups
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Typegroup
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        TypegroupPK typegroupPK = null;
        Typegroup typegroup;
        if(dbresult==null) {
            typegroup = new Typegroup(typegroupPK);
        } else {
            try {
                typegroupPK = new TypegroupPK(dbresult.getLong("id"));
                typegroup = new Typegroup(typegroupPK);
                typegroup.initCategoryPK(new CategoryPK(dbresult.getLong("category")));
                if(dbresult.wasNull()) typegroup.setCategoryPK(null);                
                typegroup.initName(dbresult.getString("name"));
                typegroup.initPublished(dbresult.getBoolean("published"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return typegroup;
    }

}

