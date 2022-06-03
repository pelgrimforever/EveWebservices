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
import eve.logicentity.Alliance;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMalliance_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMalliance_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :alliance.id:";
    public static final String SQLSelect1 = "select alliance.* from alliance where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from alliance where " + SQLWhere1;
    public static final String SQLSelectAll = "select alliance.* from alliance";

    public static final String SQLSelect = "select alliance.* from alliance";
    public static final String SQLWherecorporationCreator_corporation = "creator_corporation = :corporation.id:";
    public static final String SQLWherecorporationExecutor_corporation = "executor_corporation = :corporation.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4corporationCreator_corporation = "select * from alliance where " + SQLWherecorporationCreator_corporation + OrderBy;
    public static final String SQLDelete4corporationCreator_corporation = "delete from alliance where " + SQLWherecorporationCreator_corporation;
    public static final String SQLSelect4corporationExecutor_corporation = "select * from alliance where " + SQLWherecorporationExecutor_corporation + OrderBy;
    public static final String SQLDelete4corporationExecutor_corporation = "delete from alliance where " + SQLWherecorporationExecutor_corporation;

    /**
     * 
     * @return SQL where clause for one Alliance (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Alliance (=Primarykey)
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
     * @return SQL select statement for all Alliances
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Alliance
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        AlliancePK alliancePK = null;
        Alliance alliance;
        if(dbresult==null) {
            alliance = new Alliance(alliancePK);
        } else {
            try {
                alliancePK = new AlliancePK(dbresult.getLong("id"));
                alliance = new Alliance(alliancePK);
                alliance.initCorporationcreator_corporationPK(new CorporationPK(dbresult.getLong("creator_corporation")));
                if(dbresult.wasNull()) alliance.setCorporationcreator_corporationPK(null);                
                alliance.initCorporationexecutor_corporationPK(new CorporationPK(dbresult.getLong("executor_corporation")));
                if(dbresult.wasNull()) alliance.setCorporationexecutor_corporationPK(null);                
                alliance.initName(dbresult.getString("name"));
                alliance.initCreator(dbresult.getLong("creator"));
                alliance.initDate_founded(dbresult.getTimestamp("date_founded"));
                alliance.initTicker(dbresult.getString("ticker"));
                alliance.initFaction_id(dbresult.getLong("faction_id"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return alliance;
    }

}

