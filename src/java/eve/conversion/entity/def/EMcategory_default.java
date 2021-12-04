/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 4.11.2021 14:51
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Category;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMcategory_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMcategory_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :category.id:";
    public static final String SQLSelect1 = "select category.* from category where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from category where " + SQLWhere1;
    public static final String SQLSelectAll = "select category.* from category";

    public static final String SQLSelect = "select category.* from category";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Categorys
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Category
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

