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
import eve.logicentity.Category;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMcategory_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :category.id:";
    public static final String SQLSelect1 = "select category.* from category where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from category where " + SQLWhere1;
    public static final String SQLSelectAll = "select category.* from category";

    public static final String SQLSelect = "select category.* from category";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "category"; }

    /**
     * 
     * @return SQL where clause for one Category (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Category (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CategoryPK categoryPK = null;
        Category category;
        if(dbresult==null) {
            category = new Category(categoryPK);
        } else {
            try {
                categoryPK = new CategoryPK(dbresult.getLong("id"));
                category = new Category(categoryPK);
                category.initName(dbresult.getString("name"));
                category.initPublished(dbresult.getBoolean("published"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return category;
    }

}

