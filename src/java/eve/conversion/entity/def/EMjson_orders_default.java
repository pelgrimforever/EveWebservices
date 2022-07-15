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
import eve.logicentity.Json_orders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMjson_orders_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :json_orders.id:";
    public static final String SQLSelect1 = "select json_orders.* from json_orders where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from json_orders where " + SQLWhere1;
    public static final String SQLSelectAll = "select json_orders.* from json_orders";

    public static final String SQLSelect = "select json_orders.* from json_orders";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "json_orders"; }

    /**
     * 
     * @return SQL where clause for one Json_orders (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Json_orders (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Json_ordersPK json_ordersPK = null;
        Json_orders json_orders;
        if(dbresult==null) {
            json_orders = new Json_orders(json_ordersPK);
        } else {
            try {
                json_ordersPK = new Json_ordersPK(dbresult.getInt("id"));
                json_orders = new Json_orders(json_ordersPK);
                String o_json = dbresult.getString("json");
                if(o_json!=null) {
                    try {
                        Object json_o_a = (new JSONParser()).parse(o_json);
                        json_orders.initJson(piJson.parse(json_o_a));
                    }
                    catch(ParseException e) {
                    }                    
                }
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return json_orders;
    }

}

