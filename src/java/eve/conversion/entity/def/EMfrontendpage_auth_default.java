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
import eve.logicentity.Frontendpage_auth;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMfrontendpage_auth_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMfrontendpage_auth_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :frontendpage_auth.username: and frontendpage = :frontendpage_auth.frontendpage:";
    public static final String SQLSelect1 = "select frontendpage_auth.* from frontendpage_auth where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from frontendpage_auth where " + SQLWhere1;
    public static final String SQLSelectAll = "select frontendpage_auth.* from frontendpage_auth";

    public static final String SQLSelect = "select frontendpage_auth.* from frontendpage_auth";
    public static final String SQLWherefrontendpage = "frontendpage = :frontendpage.name:";
    public static final String SQLWhereeveuser = "username = :eveuser.username:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, frontendpage";
//Custom code, do not change this line

    public static final String SQLSelect4frontendpage = "select * from frontendpage_auth where " + SQLWherefrontendpage + OrderBy;
    public static final String SQLDelete4frontendpage = "delete from frontendpage_auth where " + SQLWherefrontendpage;
    public static final String SQLSelect4eveuser = "select * from frontendpage_auth where " + SQLWhereeveuser + OrderBy;
    public static final String SQLDelete4eveuser = "delete from frontendpage_auth where " + SQLWhereeveuser;

    /**
     * 
     * @return SQL where clause for one Frontendpage_auth (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Frontendpage_auth (=Primarykey)
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
     * @return SQL select statement for all Frontendpage_auths
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Frontendpage_auth
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Frontendpage_authPK frontendpage_authPK = null;
        Frontendpage_auth frontendpage_auth;
        if(dbresult==null) {
            frontendpage_auth = new Frontendpage_auth(frontendpage_authPK);
        } else {
            try {
                frontendpage_authPK = new Frontendpage_authPK(dbresult.getString("username"), dbresult.getString("frontendpage"));
                frontendpage_auth = new Frontendpage_auth(frontendpage_authPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return frontendpage_auth;
    }

}

