/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 31.0.2022 17:49
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Graphic;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMgraphic_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMgraphic_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :graphic.id:";
    public static final String SQLSelect1 = "select graphic.* from graphic where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from graphic where " + SQLWhere1;
    public static final String SQLSelectAll = "select graphic.* from graphic";

    public static final String SQLSelect = "select graphic.* from graphic";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Graphic (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Graphic (=Primarykey)
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
     * @return SQL select statement for all Graphics
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Graphic
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        GraphicPK graphicPK = null;
        Graphic graphic;
        if(dbresult==null) {
            graphic = new Graphic(graphicPK);
        } else {
            try {
                graphicPK = new GraphicPK(dbresult.getLong("id"));
                graphic = new Graphic(graphicPK);
                graphic.initCollision_file(dbresult.getString("collision_file"));
                graphic.initGraphic_file(dbresult.getString("graphic_file"));
                graphic.initIcon_folder(dbresult.getString("icon_folder"));
                graphic.initSof_dna(dbresult.getString("sof_dna"));
                graphic.initSof_fation_name(dbresult.getString("sof_fation_name"));
                graphic.initSof_hull_name(dbresult.getString("sof_hull_name"));
                graphic.initSof_race_name(dbresult.getString("sof_race_name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return graphic;
    }

}

