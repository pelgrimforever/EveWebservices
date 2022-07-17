/*
 * Created on Okt 8, 2021
 * Generated on 17.6.2022 13:4
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Settings;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMsettings_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "name = :settings.name:";
    public static final String SQLSelect1 = "select settings.* from settings where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from settings where " + SQLWhere1;
    public static final String SQLSelectAll = "select settings.* from settings";

    public static final String SQLSelect = "select settings.* from settings";

//Custom code, do not change this line
    public static final String OrderBy = " order by name";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "settings"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

