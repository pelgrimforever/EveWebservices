/*
 * ApplicationConfig.java
 *
 * Generated on 13.11.2021 18:23
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
        resources.add(eve.restservices.RSAlliance.class);
        resources.add(eve.restservices.RSAllnodes_stargate.class);
        resources.add(eve.restservices.RSAllnodes_system.class);
        resources.add(eve.restservices.RSBpmaterial.class);
        resources.add(eve.restservices.RSCategory.class);
        resources.add(eve.restservices.RSConstellation.class);
        resources.add(eve.restservices.RSConstellation_neighbour.class);
        resources.add(eve.restservices.RSContract.class);
        resources.add(eve.restservices.RSContractitem.class);
        resources.add(eve.restservices.RSCorporation.class);
        resources.add(eve.restservices.RSEvetype.class);
        resources.add(eve.restservices.RSEveuser.class);
        resources.add(eve.restservices.RSFaction.class);
        resources.add(eve.restservices.RSFrontendpage.class);
        resources.add(eve.restservices.RSFrontendpage_auth.class);
        resources.add(eve.restservices.RSGraphic.class);
        resources.add(eve.restservices.RSJson_orders.class);
        resources.add(eve.restservices.RSLoadorderupdate.class);
        resources.add(eve.restservices.RSLoadroute.class);
        resources.add(eve.restservices.RSLocation.class);
        resources.add(eve.restservices.RSMarket_group.class);
        resources.add(eve.restservices.RSMaterialinput.class);
        resources.add(eve.restservices.RSOrder_history.class);
        resources.add(eve.restservices.RSOrder_history_maxdate.class);
        resources.add(eve.restservices.RSOrder_history_month.class);
        resources.add(eve.restservices.RSOrders.class);
        resources.add(eve.restservices.RSRace.class);
        resources.add(eve.restservices.RSRegion.class);
        resources.add(eve.restservices.RSRegion_neighbour.class);
        resources.add(eve.restservices.RSRoutetype.class);
        resources.add(eve.restservices.RSSecurity_island.class);
        resources.add(eve.restservices.RSSettings.class);
        resources.add(eve.restservices.RSShipfit.class);
        resources.add(eve.restservices.RSShipfitmodule.class);
        resources.add(eve.restservices.RSShipfitorder.class);
        resources.add(eve.restservices.RSShipfitorderselected.class);
        resources.add(eve.restservices.RSStargate.class);
        resources.add(eve.restservices.RSStation.class);
        resources.add(eve.restservices.RSStation_service.class);
        resources.add(eve.restservices.RSStock.class);
        resources.add(eve.restservices.RSStocktrade.class);
        resources.add(eve.restservices.RSSyssettings.class);
        resources.add(eve.restservices.RSSystem.class);
        resources.add(eve.restservices.RSSystemjumps.class);
        resources.add(eve.restservices.RSTrade.class);
        resources.add(eve.restservices.RSTradecombined.class);
        resources.add(eve.restservices.RSTradecombined_sell.class);
        resources.add(eve.restservices.RSTypegroup.class);
        resources.add(eve.restservices.RSUserbp.class);
        resources.add(eve.restservices.RSUsersettings.class);
        resources.add(eve.restservices.RSView_activemodules.class);
        resources.add(eve.restservices.RSView_bp_profitperregion.class);
        resources.add(eve.restservices.RSView_bpmaterial.class);
        resources.add(eve.restservices.RSView_contractitem.class);
        resources.add(eve.restservices.RSView_contractswithprofit.class);
        resources.add(eve.restservices.RSView_evetype_order_history.class);
        resources.add(eve.restservices.RSView_evetype_order_history_month.class);
        resources.add(eve.restservices.RSView_evetype_order_history_region_month.class);
        resources.add(eve.restservices.RSView_evetypes.class);
        resources.add(eve.restservices.RSView_materialinput.class);
        resources.add(eve.restservices.RSView_materialinputavg.class);
        resources.add(eve.restservices.RSView_order.class);
        resources.add(eve.restservices.RSView_order_region_evetype.class);
        resources.add(eve.restservices.RSView_security_island_systemcount.class);
        resources.add(eve.restservices.RSView_shipfit.class);
        resources.add(eve.restservices.RSView_shipfitmodule.class);
        resources.add(eve.restservices.RSView_shipfitorder.class);
        resources.add(eve.restservices.RSView_shipfitorderselected.class);
        resources.add(eve.restservices.RSView_stock.class);
        resources.add(eve.restservices.RSView_stocktrade_orders.class);
        resources.add(eve.restservices.RSView_stocktrade_system.class);
        resources.add(eve.restservices.RSView_system.class);
        resources.add(eve.restservices.RSView_trade.class);
        resources.add(eve.restservices.RSView_trade_systemsevetype.class);
        resources.add(eve.restservices.RSView_tradecombined.class);
        resources.add(eve.restservices.RSView_tradecombined_sell.class);
        resources.add(eve.restservices.RSView_tradeorders.class);
        resources.add(eve.restservices.RSView_tradeorders_lowsec.class);
        resources.add(eve.restservices.RSView_tradesystem.class);
        resources.add(eve.restservices.RSView_userbp.class);
        resources.add(eve.restservices.RSView_userbpmaterial.class);
        resources.add(eve.restservices.RSView_wishlist.class);
        resources.add(eve.restservices.RSWishlist.class);
        resources.add(eve.restservices.RSbpproduction.class);
        resources.add(eve.restservices.RSbpsimulatemarket.class);
        resources.add(eve.restservices.RScalculatesystemjumps.class);
        resources.add(eve.restservices.RScreatenodes.class);
        resources.add(eve.restservices.RScreateroutes.class);
        resources.add(eve.restservices.RScreateshipfitroute.class);
        resources.add(eve.restservices.RSdownloadcontracts.class);
        resources.add(eve.restservices.RSdownloadmarkethistory.class);
        resources.add(eve.restservices.RSdownloadmarkettypes.class);
        resources.add(eve.restservices.RSdownloadswagger.class);
        resources.add(eve.restservices.RSdownloaduniverse.class);
        resources.add(eve.restservices.RStest.class);
        return resources;
    }
}
//needs customization by programmer ?
