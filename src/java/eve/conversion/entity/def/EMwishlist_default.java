/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 22.1.2022 10:54
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Wishlist;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMwishlist_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMwishlist_default implements TableMapper {
    
    public static final String SQLWhere1 = "evetype = :wishlist.evetype: and username = :wishlist.username:";
    public static final String SQLSelect1 = "select wishlist.* from wishlist where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from wishlist where " + SQLWhere1;
    public static final String SQLSelectAll = "select wishlist.* from wishlist";

    public static final String SQLSelect = "select wishlist.* from wishlist";
    public static final String SQLWhereevetype = "evetype = :evetype.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by evetype";
//Custom code, do not change this line

    public static final String SQLSelect4evetype = "select * from wishlist where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from wishlist where " + SQLWhereevetype;

    /**
     * 
     * @return SQL where clause for one Wishlist (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Wishlist (=Primarykey)
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
     * @return SQL select statement for all Wishlists
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Wishlist
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        WishlistPK wishlistPK = null;
        Wishlist wishlist;
        if(dbresult==null) {
            wishlist = new Wishlist(wishlistPK);
        } else {
            try {
                wishlistPK = new WishlistPK(dbresult.getLong("evetype"), dbresult.getString("username"));
                wishlist = new Wishlist(wishlistPK);
                wishlist.initMaxprice(dbresult.getDouble("maxprice"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return wishlist;
    }

}

