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
        resources.add(eve.restservices.RSLoadorderupdate.class);
        resources.add(eve.restservices.RSLoadroute.class);
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
        resources.add(eve.restservices.alliance.RSAlliance_delete.class);
        resources.add(eve.restservices.alliance.RSAlliance_insert.class);
        resources.add(eve.restservices.alliance.RSAlliance_select.class);
        resources.add(eve.restservices.alliance.RSAlliance_update.class);
        resources.add(eve.restservices.allnodes_stargate.RSAllnodes_stargate_delete.class);
        resources.add(eve.restservices.allnodes_stargate.RSAllnodes_stargate_insert.class);
        resources.add(eve.restservices.allnodes_stargate.RSAllnodes_stargate_select.class);
        resources.add(eve.restservices.allnodes_stargate.RSAllnodes_stargate_update.class);
        resources.add(eve.restservices.allnodes_system.RSAllnodes_system_delete.class);
        resources.add(eve.restservices.allnodes_system.RSAllnodes_system_insert.class);
        resources.add(eve.restservices.allnodes_system.RSAllnodes_system_select.class);
        resources.add(eve.restservices.allnodes_system.RSAllnodes_system_update.class);
        resources.add(eve.restservices.bpmaterial.RSBpmaterial_delete.class);
        resources.add(eve.restservices.bpmaterial.RSBpmaterial_insert.class);
        resources.add(eve.restservices.bpmaterial.RSBpmaterial_select.class);
        resources.add(eve.restservices.bpmaterial.RSBpmaterial_update.class);
        resources.add(eve.restservices.category.RSCategory_delete.class);
        resources.add(eve.restservices.category.RSCategory_insert.class);
        resources.add(eve.restservices.category.RSCategory_select.class);
        resources.add(eve.restservices.category.RSCategory_update.class);
        resources.add(eve.restservices.constellation.RSConstellation_delete.class);
        resources.add(eve.restservices.constellation.RSConstellation_insert.class);
        resources.add(eve.restservices.constellation.RSConstellation_select.class);
        resources.add(eve.restservices.constellation.RSConstellation_update.class);
        resources.add(eve.restservices.constellation_neighbour.RSConstellation_neighbour_delete.class);
        resources.add(eve.restservices.constellation_neighbour.RSConstellation_neighbour_insert.class);
        resources.add(eve.restservices.constellation_neighbour.RSConstellation_neighbour_select.class);
        resources.add(eve.restservices.constellation_neighbour.RSConstellation_neighbour_update.class);
        resources.add(eve.restservices.contract.RSContract_delete.class);
        resources.add(eve.restservices.contract.RSContract_insert.class);
        resources.add(eve.restservices.contract.RSContract_select.class);
        resources.add(eve.restservices.contract.RSContract_update.class);
        resources.add(eve.restservices.contractitem.RSContractitem_delete.class);
        resources.add(eve.restservices.contractitem.RSContractitem_insert.class);
        resources.add(eve.restservices.contractitem.RSContractitem_select.class);
        resources.add(eve.restservices.contractitem.RSContractitem_update.class);
        resources.add(eve.restservices.corporation.RSCorporation_delete.class);
        resources.add(eve.restservices.corporation.RSCorporation_insert.class);
        resources.add(eve.restservices.corporation.RSCorporation_select.class);
        resources.add(eve.restservices.corporation.RSCorporation_update.class);
        resources.add(eve.restservices.evetype.RSEvetype_delete.class);
        resources.add(eve.restservices.evetype.RSEvetype_insert.class);
        resources.add(eve.restservices.evetype.RSEvetype_select.class);
        resources.add(eve.restservices.evetype.RSEvetype_update.class);
        resources.add(eve.restservices.eveuser.RSEveuser_delete.class);
        resources.add(eve.restservices.eveuser.RSEveuser_insert.class);
        resources.add(eve.restservices.eveuser.RSEveuser_select.class);
        resources.add(eve.restservices.eveuser.RSEveuser_update.class);
        resources.add(eve.restservices.faction.RSFaction_delete.class);
        resources.add(eve.restservices.faction.RSFaction_insert.class);
        resources.add(eve.restservices.faction.RSFaction_select.class);
        resources.add(eve.restservices.faction.RSFaction_update.class);
        resources.add(eve.restservices.frontendpage.RSFrontendpage_delete.class);
        resources.add(eve.restservices.frontendpage.RSFrontendpage_insert.class);
        resources.add(eve.restservices.frontendpage.RSFrontendpage_select.class);
        resources.add(eve.restservices.frontendpage.RSFrontendpage_update.class);
        resources.add(eve.restservices.frontendpage_auth.RSFrontendpage_auth_delete.class);
        resources.add(eve.restservices.frontendpage_auth.RSFrontendpage_auth_insert.class);
        resources.add(eve.restservices.frontendpage_auth.RSFrontendpage_auth_select.class);
        resources.add(eve.restservices.frontendpage_auth.RSFrontendpage_auth_update.class);
        resources.add(eve.restservices.graphic.RSGraphic_delete.class);
        resources.add(eve.restservices.graphic.RSGraphic_insert.class);
        resources.add(eve.restservices.graphic.RSGraphic_select.class);
        resources.add(eve.restservices.graphic.RSGraphic_update.class);
        resources.add(eve.restservices.json_orders.RSJson_orders_delete.class);
        resources.add(eve.restservices.json_orders.RSJson_orders_insert.class);
        resources.add(eve.restservices.json_orders.RSJson_orders_select.class);
        resources.add(eve.restservices.json_orders.RSJson_orders_update.class);
        resources.add(eve.restservices.location.RSLocation_delete.class);
        resources.add(eve.restservices.location.RSLocation_insert.class);
        resources.add(eve.restservices.location.RSLocation_select.class);
        resources.add(eve.restservices.location.RSLocation_update.class);
        resources.add(eve.restservices.market_group.RSMarket_group_delete.class);
        resources.add(eve.restservices.market_group.RSMarket_group_insert.class);
        resources.add(eve.restservices.market_group.RSMarket_group_select.class);
        resources.add(eve.restservices.market_group.RSMarket_group_update.class);
        resources.add(eve.restservices.materialinput.RSMaterialinput_delete.class);
        resources.add(eve.restservices.materialinput.RSMaterialinput_insert.class);
        resources.add(eve.restservices.materialinput.RSMaterialinput_select.class);
        resources.add(eve.restservices.materialinput.RSMaterialinput_update.class);
        resources.add(eve.restservices.order_history.RSOrder_history_delete.class);
        resources.add(eve.restservices.order_history.RSOrder_history_insert.class);
        resources.add(eve.restservices.order_history.RSOrder_history_select.class);
        resources.add(eve.restservices.order_history.RSOrder_history_update.class);
        resources.add(eve.restservices.order_history_maxdate.RSOrder_history_maxdate_select.class);
        resources.add(eve.restservices.order_history_month.RSOrder_history_month_delete.class);
        resources.add(eve.restservices.order_history_month.RSOrder_history_month_insert.class);
        resources.add(eve.restservices.order_history_month.RSOrder_history_month_select.class);
        resources.add(eve.restservices.order_history_month.RSOrder_history_month_update.class);
        resources.add(eve.restservices.orders.RSOrders_delete.class);
        resources.add(eve.restservices.orders.RSOrders_insert.class);
        resources.add(eve.restservices.orders.RSOrders_select.class);
        resources.add(eve.restservices.orders.RSOrders_update.class);
        resources.add(eve.restservices.race.RSRace_delete.class);
        resources.add(eve.restservices.race.RSRace_insert.class);
        resources.add(eve.restservices.race.RSRace_select.class);
        resources.add(eve.restservices.race.RSRace_update.class);
        resources.add(eve.restservices.region.RSRegion_delete.class);
        resources.add(eve.restservices.region.RSRegion_insert.class);
        resources.add(eve.restservices.region.RSRegion_select.class);
        resources.add(eve.restservices.region.RSRegion_update.class);
        resources.add(eve.restservices.region_neighbour.RSRegion_neighbour_delete.class);
        resources.add(eve.restservices.region_neighbour.RSRegion_neighbour_insert.class);
        resources.add(eve.restservices.region_neighbour.RSRegion_neighbour_select.class);
        resources.add(eve.restservices.region_neighbour.RSRegion_neighbour_update.class);
        resources.add(eve.restservices.routetype.RSRoutetype_delete.class);
        resources.add(eve.restservices.routetype.RSRoutetype_insert.class);
        resources.add(eve.restservices.routetype.RSRoutetype_select.class);
        resources.add(eve.restservices.routetype.RSRoutetype_update.class);
        resources.add(eve.restservices.security_island.RSSecurity_island_delete.class);
        resources.add(eve.restservices.security_island.RSSecurity_island_insert.class);
        resources.add(eve.restservices.security_island.RSSecurity_island_select.class);
        resources.add(eve.restservices.security_island.RSSecurity_island_update.class);
        resources.add(eve.restservices.settings.RSSettings_delete.class);
        resources.add(eve.restservices.settings.RSSettings_insert.class);
        resources.add(eve.restservices.settings.RSSettings_select.class);
        resources.add(eve.restservices.settings.RSSettings_update.class);
        resources.add(eve.restservices.shipfit.RSShipfit_delete.class);
        resources.add(eve.restservices.shipfit.RSShipfit_insert.class);
        resources.add(eve.restservices.shipfit.RSShipfit_select.class);
        resources.add(eve.restservices.shipfit.RSShipfit_update.class);
        resources.add(eve.restservices.shipfitmodule.RSShipfitmodule_delete.class);
        resources.add(eve.restservices.shipfitmodule.RSShipfitmodule_insert.class);
        resources.add(eve.restservices.shipfitmodule.RSShipfitmodule_select.class);
        resources.add(eve.restservices.shipfitmodule.RSShipfitmodule_update.class);
        resources.add(eve.restservices.shipfitorder.RSShipfitorder_delete.class);
        resources.add(eve.restservices.shipfitorder.RSShipfitorder_insert.class);
        resources.add(eve.restservices.shipfitorder.RSShipfitorder_select.class);
        resources.add(eve.restservices.shipfitorder.RSShipfitorder_update.class);
        resources.add(eve.restservices.shipfitorderselected.RSShipfitorderselected_delete.class);
        resources.add(eve.restservices.shipfitorderselected.RSShipfitorderselected_insert.class);
        resources.add(eve.restservices.shipfitorderselected.RSShipfitorderselected_select.class);
        resources.add(eve.restservices.shipfitorderselected.RSShipfitorderselected_update.class);
        resources.add(eve.restservices.stargate.RSStargate_delete.class);
        resources.add(eve.restservices.stargate.RSStargate_insert.class);
        resources.add(eve.restservices.stargate.RSStargate_select.class);
        resources.add(eve.restservices.stargate.RSStargate_update.class);
        resources.add(eve.restservices.station.RSStation_delete.class);
        resources.add(eve.restservices.station.RSStation_insert.class);
        resources.add(eve.restservices.station.RSStation_select.class);
        resources.add(eve.restservices.station.RSStation_update.class);
        resources.add(eve.restservices.station_service.RSStation_service_delete.class);
        resources.add(eve.restservices.station_service.RSStation_service_insert.class);
        resources.add(eve.restservices.station_service.RSStation_service_select.class);
        resources.add(eve.restservices.station_service.RSStation_service_update.class);
        resources.add(eve.restservices.stock.RSStock_delete.class);
        resources.add(eve.restservices.stock.RSStock_insert.class);
        resources.add(eve.restservices.stock.RSStock_select.class);
        resources.add(eve.restservices.stock.RSStock_update.class);
        resources.add(eve.restservices.stocktrade.RSStocktrade_delete.class);
        resources.add(eve.restservices.stocktrade.RSStocktrade_insert.class);
        resources.add(eve.restservices.stocktrade.RSStocktrade_select.class);
        resources.add(eve.restservices.stocktrade.RSStocktrade_update.class);
        resources.add(eve.restservices.syssettings.RSSyssettings_delete.class);
        resources.add(eve.restservices.syssettings.RSSyssettings_insert.class);
        resources.add(eve.restservices.syssettings.RSSyssettings_select.class);
        resources.add(eve.restservices.syssettings.RSSyssettings_update.class);
        resources.add(eve.restservices.system.RSSystem_delete.class);
        resources.add(eve.restservices.system.RSSystem_insert.class);
        resources.add(eve.restservices.system.RSSystem_select.class);
        resources.add(eve.restservices.system.RSSystem_update.class);
        resources.add(eve.restservices.systemjumps.RSSystemjumps_delete.class);
        resources.add(eve.restservices.systemjumps.RSSystemjumps_insert.class);
        resources.add(eve.restservices.systemjumps.RSSystemjumps_select.class);
        resources.add(eve.restservices.systemjumps.RSSystemjumps_update.class);
        resources.add(eve.restservices.trade.RSTrade_delete.class);
        resources.add(eve.restservices.trade.RSTrade_insert.class);
        resources.add(eve.restservices.trade.RSTrade_select.class);
        resources.add(eve.restservices.trade.RSTrade_update.class);
        resources.add(eve.restservices.tradecombined.RSTradecombined_delete.class);
        resources.add(eve.restservices.tradecombined.RSTradecombined_insert.class);
        resources.add(eve.restservices.tradecombined.RSTradecombined_select.class);
        resources.add(eve.restservices.tradecombined.RSTradecombined_update.class);
        resources.add(eve.restservices.tradecombined_sell.RSTradecombined_sell_delete.class);
        resources.add(eve.restservices.tradecombined_sell.RSTradecombined_sell_insert.class);
        resources.add(eve.restservices.tradecombined_sell.RSTradecombined_sell_select.class);
        resources.add(eve.restservices.tradecombined_sell.RSTradecombined_sell_update.class);
        resources.add(eve.restservices.typegroup.RSTypegroup_delete.class);
        resources.add(eve.restservices.typegroup.RSTypegroup_insert.class);
        resources.add(eve.restservices.typegroup.RSTypegroup_select.class);
        resources.add(eve.restservices.typegroup.RSTypegroup_update.class);
        resources.add(eve.restservices.userbp.RSUserbp_delete.class);
        resources.add(eve.restservices.userbp.RSUserbp_insert.class);
        resources.add(eve.restservices.userbp.RSUserbp_select.class);
        resources.add(eve.restservices.userbp.RSUserbp_update.class);
        resources.add(eve.restservices.usersettings.RSUsersettings_delete.class);
        resources.add(eve.restservices.usersettings.RSUsersettings_insert.class);
        resources.add(eve.restservices.usersettings.RSUsersettings_select.class);
        resources.add(eve.restservices.usersettings.RSUsersettings_update.class);
        resources.add(eve.restservices.view_activemodules.RSView_activemodules_select.class);
        resources.add(eve.restservices.view_bp_profitperregion.RSView_bp_profitperregion_select.class);
        resources.add(eve.restservices.view_bpmaterial.RSView_bpmaterial_select.class);
        resources.add(eve.restservices.view_contractitem.RSView_contractitem_select.class);
        resources.add(eve.restservices.view_contractswithprofit.RSView_contractswithprofit_select.class);
        resources.add(eve.restservices.view_evetype_order_history.RSView_evetype_order_history_select.class);
        resources.add(eve.restservices.view_evetype_order_history_month.RSView_evetype_order_history_month_select.class);
        resources.add(eve.restservices.view_evetype_order_history_region_month.RSView_evetype_order_history_region_month_select.class);
        resources.add(eve.restservices.view_evetypes.RSView_evetypes_select.class);
        resources.add(eve.restservices.view_materialinput.RSView_materialinput_select.class);
        resources.add(eve.restservices.view_materialinputavg.RSView_materialinputavg_select.class);
        resources.add(eve.restservices.view_order.RSView_order_select.class);
        resources.add(eve.restservices.view_order_region_evetype.RSView_order_region_evetype_select.class);
        resources.add(eve.restservices.view_security_island_systemcount.RSView_security_island_systemcount_select.class);
        resources.add(eve.restservices.view_shipfit.RSView_shipfit_select.class);
        resources.add(eve.restservices.view_shipfitmodule.RSView_shipfitmodule_select.class);
        resources.add(eve.restservices.view_shipfitorder.RSView_shipfitorder_select.class);
        resources.add(eve.restservices.view_shipfitorderselected.RSView_shipfitorderselected_select.class);
        resources.add(eve.restservices.view_stock.RSView_stock_select.class);
        resources.add(eve.restservices.view_stocktrade_orders.RSView_stocktrade_orders_select.class);
        resources.add(eve.restservices.view_stocktrade_system.RSView_stocktrade_system_select.class);
        resources.add(eve.restservices.view_system.RSView_system_select.class);
        resources.add(eve.restservices.view_trade.RSView_trade_select.class);
        resources.add(eve.restservices.view_trade_systemsevetype.RSView_trade_systemsevetype_select.class);
        resources.add(eve.restservices.view_tradecombined.RSView_tradecombined_select.class);
        resources.add(eve.restservices.view_tradecombined_sell.RSView_tradecombined_sell_select.class);
        resources.add(eve.restservices.view_tradeorders.RSView_tradeorders_select.class);
        resources.add(eve.restservices.view_tradeorders_lowsec.RSView_tradeorders_lowsec_select.class);
        resources.add(eve.restservices.view_tradesystem.RSView_tradesystem_select.class);
        resources.add(eve.restservices.view_userbp.RSView_userbp_select.class);
        resources.add(eve.restservices.view_userbpmaterial.RSView_userbpmaterial_select.class);
        resources.add(eve.restservices.view_wishlist.RSView_wishlist_select.class);
        resources.add(eve.restservices.wishlist.RSWishlist_delete.class);
        resources.add(eve.restservices.wishlist.RSWishlist_insert.class);
        resources.add(eve.restservices.wishlist.RSWishlist_select.class);
        resources.add(eve.restservices.wishlist.RSWishlist_update.class);
        return resources;
    }
}
//needs customization by programmer ?
