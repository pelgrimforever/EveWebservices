/*
 * EMview_order.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_order_default;
import eve.logicview.View_order;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_order
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_order extends EMview_order_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectOne = SQLSelectAll + " where view_order.id = :orders.id:";

    public static final String SQLorderbyprice_asc = " order by view_order.price asc";
    public static final String SQLorderbyprice_desc = " order by view_order.price desc";
    public static final String SQLSelect4Evetypebuy = SQLSelectAll + " where view_order.evetype = :evetype.id: and view_order.is_buy_order" + SQLorderbyprice_desc;
    public static final String SQLSelect4Evetypesell = SQLSelectAll + " where view_order.evetype = :evetype.id: and not view_order.is_buy_order" + SQLorderbyprice_asc;
    public static final String SQLSelect4Evetyperegionsell = SQLSelectAll + 
        " where view_order.evetype = :evetype.id: and view_order.region = :region.id: and not view_order.is_buy_order" + SQLorderbyprice_asc;
    public static final String SQLSelect4selllowprice = "select sj.jumpssafe AS startsystem_jumps, sj.jumpssafelowsec as startsystem_jumpslowsec, sj.jumpssafenullsec as startsystem_jumpsnullsec, view_order.* from view_order " + 
        "inner join evetype et on et.id = view_order.evetype join typegroup tg on tg.id = et.typegroup join category c on c.id = tg.category and c.name <> 'Blueprint' " +
        "inner join systemjumps sj on view_order.system = sj.system_end " +
        "and sj.system_start = :system.id: " +
        "where not view_order.is_buy_order and view_order.price < et.avg_buyorder/:pricefactor: and et.packaged_volume < :maxcargo:";
    public static final String SQLSelect4wishlist = "select view_order.* from view_order " +
        "inner join wishlist on wishlist.evetype = view_order.evetype and wishlist.maxprice >= view_order.price " +
        "where not view_order.is_buy_order and wishlist.username = :username: " +
        "order by view_order.evetypename, price";

    /**
     * Map ResultSet Field values to View_order
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_order view_order = (View_order)super.mapResultSet2Entity(dbresult);
        try {
            view_order.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
            view_order.setStart_system_jumpslowsec(dbresult.getInt("startsystem_jumpslowsec"));
            view_order.setStart_system_jumpsnullsec(dbresult.getInt("startsystem_jumpsnullsec"));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return view_order;
    }    
    
}

