/*
 * ApplicationConfig.java
 *
 * Generated on 2.11.2021 18:45
 *
 */

package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Franky Laseure
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    /**
     * Do not modify this method. It is automatically generated by NetBeans REST support.
     */
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
//Custom code, do not change this line
//add here custom operations
        resources.add(eve.restservices.RSAlliance.class);
        resources.add(eve.restservices.RSCategory.class);
        resources.add(eve.restservices.RSConstellation.class);
        resources.add(eve.restservices.RSConstellation_neighbour.class);
        resources.add(eve.restservices.RSCorporation.class);
        resources.add(eve.restservices.RSLoadorderupdate.class);
        resources.add(eve.restservices.RSLoadroute.class);
        resources.add(eve.restservices.RScreateroutes.class);
//Custom code, do not change this line   
        resources.add(eve.restservices.RSAlliance.class);
        resources.add(eve.restservices.RSCategory.class);
        resources.add(eve.restservices.RSConstellation.class);
        resources.add(eve.restservices.RSConstellation_neighbour.class);
        resources.add(eve.restservices.RSCorporation.class);
        resources.add(eve.restservices.RSEvetype.class);
        resources.add(eve.restservices.RSFaction.class);
        resources.add(eve.restservices.RSGraphic.class);
        resources.add(eve.restservices.RSJson_orders.class);
        resources.add(eve.restservices.RSLocation.class);
        resources.add(eve.restservices.RSMarket_group.class);
        resources.add(eve.restservices.RSOrder_hist.class);
        resources.add(eve.restservices.RSOrder_history.class);
        resources.add(eve.restservices.RSOrders.class);
        resources.add(eve.restservices.RSRace.class);
        resources.add(eve.restservices.RSRegion.class);
        resources.add(eve.restservices.RSRegion_neighbour.class);
        resources.add(eve.restservices.RSRoute.class);
        resources.add(eve.restservices.RSRoutetype.class);
        resources.add(eve.restservices.RSSecurity_island.class);
        resources.add(eve.restservices.RSSettings.class);
        resources.add(eve.restservices.RSStargate.class);
        resources.add(eve.restservices.RSStation.class);
        resources.add(eve.restservices.RSStation_service.class);
        resources.add(eve.restservices.RSStock.class);
        resources.add(eve.restservices.RSStocktrade.class);
        resources.add(eve.restservices.RSSystem.class);
        resources.add(eve.restservices.RSSystemjumps.class);
        resources.add(eve.restservices.RSTmp_system_jumps.class);
        resources.add(eve.restservices.RSTrade.class);
        resources.add(eve.restservices.RSTradecombined.class);
        resources.add(eve.restservices.RSTradecombined_sell.class);
        resources.add(eve.restservices.RSTypegroup.class);
        resources.add(eve.restservices.RSUsersettings.class);
        resources.add(eve.restservices.RSView_order.class);
        resources.add(eve.restservices.RSView_order_region_evetype.class);
        resources.add(eve.restservices.RSView_security_island_systemcount.class);
        resources.add(eve.restservices.RSView_stock.class);
        resources.add(eve.restservices.RSView_stocktrade_orders.class);
        resources.add(eve.restservices.RSView_stocktrade_system.class);
        resources.add(eve.restservices.RSView_trade.class);
        resources.add(eve.restservices.RSView_trade_systemsevetype.class);
        resources.add(eve.restservices.RSView_tradecombined.class);
        resources.add(eve.restservices.RSView_tradecombined_sell.class);
        resources.add(eve.restservices.RSView_tradeorders.class);
        return resources;
    }
}
//needs customization by programmer ?
