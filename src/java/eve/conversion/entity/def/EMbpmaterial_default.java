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
import eve.logicentity.Bpmaterial;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMbpmaterial_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "bp = :bpmaterial.bp: and material = :bpmaterial.material:";
    public static final String SQLSelect1 = "select bpmaterial.* from bpmaterial where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from bpmaterial where " + SQLWhere1;
    public static final String SQLSelectAll = "select bpmaterial.* from bpmaterial";

    public static final String SQLSelect = "select bpmaterial.* from bpmaterial";
    public static final String SQLWhereevetypeBp = "bp = :evetype.id:";
    public static final String SQLWhereevetypeMaterial = "material = :evetype.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by bp, material";
//Custom code, do not change this line

    public static final String SQLSelect4evetypeBp = "select * from bpmaterial where " + SQLWhereevetypeBp + OrderBy;
    public static final String SQLDelete4evetypeBp = "delete from bpmaterial where " + SQLWhereevetypeBp;
    public static final String SQLSelect4evetypeMaterial = "select * from bpmaterial where " + SQLWhereevetypeMaterial + OrderBy;
    public static final String SQLDelete4evetypeMaterial = "delete from bpmaterial where " + SQLWhereevetypeMaterial;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "bpmaterial"; }

    /**
     * 
     * @return SQL where clause for one Bpmaterial (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Bpmaterial (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        BpmaterialPK bpmaterialPK = null;
        Bpmaterial bpmaterial;
        if(dbresult==null) {
            bpmaterial = new Bpmaterial(bpmaterialPK);
        } else {
            try {
                bpmaterialPK = new BpmaterialPK(dbresult.getLong("bp"), dbresult.getLong("material"));
                bpmaterial = new Bpmaterial(bpmaterialPK);
                bpmaterial.initAmount(dbresult.getLong("amount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return bpmaterial;
    }

}

