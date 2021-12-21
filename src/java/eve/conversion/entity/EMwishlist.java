/*
 * EMwishlist.java
 *
 * Created on Okt 8, 2021
 * Generated on 16.11.2021 15:46
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMwishlist_default;
import eve.logicentity.Wishlist;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMwishlist
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMwishlist extends EMwishlist_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Wishlist
     * @param dbresult: Database ResultSet
     * @return Wishlist
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Wishlist wishlist = (Wishlist)super.mapResultSet2Entity(dbresult);
        return wishlist;
    }    
    
}

