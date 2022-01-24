/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 24.0.2022 16:47
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Bpmaterial;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMbpmaterial_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMbpmaterial_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Bpmaterials
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Bpmaterial
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

