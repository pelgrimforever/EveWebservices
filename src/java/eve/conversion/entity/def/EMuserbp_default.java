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
import eve.logicentity.Userbp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMuserbp_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMuserbp_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :userbp.username: and bp = :userbp.bp: and serialnumber = :userbp.serialnumber:";
    public static final String SQLSelect1 = "select userbp.* from userbp where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from userbp where " + SQLWhere1;
    public static final String SQLSelectAll = "select userbp.* from userbp";

    public static final String SQLSelect = "select userbp.* from userbp";
    public static final String SQLWhereevetype = "bp = :evetype.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, bp, serialnumber";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from userbp where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from userbp where " + SQLWhereevetype;

    /**
     * 
     * @return SQL where clause for one Userbp (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Userbp (=Primarykey)
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
     * @return SQL select statement for all Userbps
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Userbp
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        UserbpPK userbpPK = null;
        Userbp userbp;
        if(dbresult==null) {
            userbp = new Userbp(userbpPK);
        } else {
            try {
                userbpPK = new UserbpPK(dbresult.getString("username"), dbresult.getLong("bp"), dbresult.getInt("serialnumber"));
                userbp = new Userbp(userbpPK);
                userbp.initOriginal(dbresult.getBoolean("original"));
                userbp.initMaterialefficiency(dbresult.getInt("materialefficiency"));
                userbp.initAmountproduced(dbresult.getInt("amountproduced"));
                userbp.initTotalamount(dbresult.getInt("totalamount"));
                userbp.initBpprice(dbresult.getDouble("bpprice"));
                userbp.initResearchcost(dbresult.getDouble("researchcost"));
                userbp.initStationfee(dbresult.getDouble("stationfee"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return userbp;
    }

}

