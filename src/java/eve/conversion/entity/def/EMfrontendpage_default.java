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
import eve.logicentity.Frontendpage;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMfrontendpage_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMfrontendpage_default implements TableMapper {
    
    public static final String SQLWhere1 = "name = :frontendpage.name:";
    public static final String SQLSelect1 = "select frontendpage.* from frontendpage where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from frontendpage where " + SQLWhere1;
    public static final String SQLSelectAll = "select frontendpage.* from frontendpage";

    public static final String SQLSelect = "select frontendpage.* from frontendpage";

//Custom code, do not change this line
    public static final String OrderBy = " order by name";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Frontendpage (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Frontendpage (=Primarykey)
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
     * @return SQL select statement for all Frontendpages
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Frontendpage
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FrontendpagePK frontendpagePK = null;
        Frontendpage frontendpage;
        if(dbresult==null) {
            frontendpage = new Frontendpage(frontendpagePK);
        } else {
            try {
                frontendpagePK = new FrontendpagePK(dbresult.getString("name"));
                frontendpage = new Frontendpage(frontendpagePK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return frontendpage;
    }

}

