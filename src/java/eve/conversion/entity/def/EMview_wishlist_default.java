/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 22.1.2022 10:55
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_wishlist;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_wishlist_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_wishlist_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_wishlist.* from view_wishlist";
	  
    /**
     * 
     * @return SQL select statement for all View_wishlists
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_wishlist
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_wishlist view_wishlist = new View_wishlist();
        if(dbresult!=null) {
            try {
                view_wishlist.setUsername(dbresult.getString("username"));
                view_wishlist.setMaxprice(dbresult.getDouble("maxprice"));
                view_wishlist.setId(dbresult.getLong("id"));
                view_wishlist.setName(dbresult.getString("name"));
                view_wishlist.setTypegroup(dbresult.getLong("typegroup"));
                view_wishlist.setPublished(dbresult.getBoolean("published"));
                view_wishlist.setDescription(dbresult.getString("description"));
                view_wishlist.setCapacity(dbresult.getDouble("capacity"));
                view_wishlist.setGraphic(dbresult.getLong("graphic"));
                view_wishlist.setIcon(dbresult.getLong("icon"));
                view_wishlist.setMarket_group(dbresult.getLong("market_group"));
                view_wishlist.setMass(dbresult.getDouble("mass"));
                view_wishlist.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_wishlist.setPortion_size(dbresult.getInt("portion_size"));
                view_wishlist.setRadius(dbresult.getDouble("radius"));
                view_wishlist.setVolume(dbresult.getDouble("volume"));
                view_wishlist.setAvg_buyorder(dbresult.getDouble("avg_buyorder"));
                view_wishlist.setAvg_sellorder(dbresult.getDouble("avg_sellorder"));
                view_wishlist.setMin_buyorder(dbresult.getDouble("min_buyorder"));
                view_wishlist.setMax_buyorder(dbresult.getDouble("max_buyorder"));
                view_wishlist.setMin_selorder(dbresult.getDouble("min_selorder"));
                view_wishlist.setMax_selorder(dbresult.getDouble("max_selorder"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_wishlist;
    }

}

