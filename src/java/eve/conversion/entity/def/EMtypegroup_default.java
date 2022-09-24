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
import eve.logicentity.Typegroup;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMtypegroup_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "typegroup"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

