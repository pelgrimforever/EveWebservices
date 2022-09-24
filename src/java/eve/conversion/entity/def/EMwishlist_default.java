/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Wishlist;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMwishlist_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "wishlist"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

