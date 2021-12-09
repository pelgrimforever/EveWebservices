/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.11.2021 14:30
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Settings;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsettings_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMsettings_default implements TableMapper {
    
    public static final String SQLWhere1 = "name = :settings.name:";
    public static final String SQLSelect1 = "select settings.* from settings where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from settings where " + SQLWhere1;
    public static final String SQLSelectAll = "select settings.* from settings";

    public static final String SQLSelect = "select settings.* from settings";

//Custom code, do not change this line
    public static final String OrderBy = " order by name";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Settings (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Settings (=Primarykey)
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
     * @return SQL select statement for all Settingss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Settings
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SettingsPK settingsPK = null;
        Settings settings;
        if(dbresult==null) {
            settings = new Settings(settingsPK);
        } else {
            try {
                settingsPK = new SettingsPK(dbresult.getString("name"));
                settings = new Settings(settingsPK);
                settings.initValue(dbresult.getString("value"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return settings;
    }

}

