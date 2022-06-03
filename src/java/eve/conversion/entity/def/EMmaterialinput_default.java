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
import eve.logicentity.Materialinput;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMmaterialinput_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMmaterialinput_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :materialinput.username: and evetype = :materialinput.evetype: and addtimestamp = :materialinput.addtimestamp:";
    public static final String SQLSelect1 = "select materialinput.* from materialinput where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from materialinput where " + SQLWhere1;
    public static final String SQLSelectAll = "select materialinput.* from materialinput";

    public static final String SQLSelect = "select materialinput.* from materialinput";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, evetype, timestamp";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from materialinput where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from materialinput where " + SQLWhereevetype;

    /**
     * 
     * @return SQL where clause for one Materialinput (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Materialinput (=Primarykey)
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
     * @return SQL select statement for all Materialinputs
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Materialinput
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        MaterialinputPK materialinputPK = null;
        Materialinput materialinput;
        if(dbresult==null) {
            materialinput = new Materialinput(materialinputPK);
        } else {
            try {
                materialinputPK = new MaterialinputPK(dbresult.getString("username"), dbresult.getLong("evetype"), dbresult.getTimestamp("addtimestamp"));
                materialinput = new Materialinput(materialinputPK);
                materialinput.initAmount(dbresult.getLong("amount"));
                materialinput.initUnitprice(dbresult.getDouble("unitprice"));
                materialinput.initUsedamount(dbresult.getLong("usedamount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return materialinput;
    }

}

