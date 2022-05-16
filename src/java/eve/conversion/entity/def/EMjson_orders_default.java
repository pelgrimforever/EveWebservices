/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.4.2022 19:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Json_orders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMjson_orders_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMjson_orders_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :json_orders.id:";
    public static final String SQLSelect1 = "select json_orders.* from json_orders where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from json_orders where " + SQLWhere1;
    public static final String SQLSelectAll = "select json_orders.* from json_orders";

    public static final String SQLSelect = "select json_orders.* from json_orders";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Json_orderss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Json_orders
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

