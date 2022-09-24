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
import eve.logicentity.Userbp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMuserbp_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "userbp"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

