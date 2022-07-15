package eve.data;

import eve.BusinessObject.service.CategoryService;
import eve.BusinessObject.service.ContractService;
import eve.BusinessObject.service.MarketService;
import eve.BusinessObject.service.Market_groupService;
import eve.BusinessObject.service.Markethistory;
import eve.BusinessObject.service.RouteService;
import eve.BusinessObject.service.SystemjumpsService;
import eve.BusinessObject.service.UniverseService;

/**
 * @author Franky Laseure
 */
public class Staticdata {

    private static Thread marketservice_thread = null;
    private static MarketService marketservice = null;
    private static RouteService routeservice = null;
    private static Thread systemjumpsservice_thread = null;
    private static SystemjumpsService systemjumpsservice = null;
    private static Thread contractservice_thread = null;
    private static ContractService contractservice = null;
    private static Thread historyservice_thread = null;
    private static Markethistory historyservice = null;
    private static Thread market_group_service_thread = null;
    private static Market_groupService market_group_service = null;
    private static Thread category_service_thread = null;
    private static CategoryService category_service = null;
    private static Thread universeservice_thread = null;
    private static UniverseService universeservice = null;

    public static Thread getMarketservice_thread() {
        return marketservice_thread;
    }

    public static void setMarketservice_thread(Thread marketservice_thread) {
        Staticdata.marketservice_thread = marketservice_thread;
    }

    public static MarketService getMarketservice() {
        return marketservice;
    }

    public static void setMarketservice(MarketService marketservice) {
        Staticdata.marketservice = marketservice;
    }

    
    
    public static RouteService getRouteservice() {
        return routeservice;
    }

    public static void setRouteservice(RouteService routeservice) {
        Staticdata.routeservice = routeservice;
    }
    
    public static SystemjumpsService getSystemjumpsservice() {
        return systemjumpsservice;
    }
    
    public static void setSystemjumpsservice(SystemjumpsService systemjumpsservice) {
        Staticdata.systemjumpsservice = systemjumpsservice;
    }
    
    public static Thread getSystemjumpsservice_thread() {
        return systemjumpsservice_thread;
    }
    
    public static void setSystemjumpsservice_thread(Thread systemjumpsservice_thread) {
        Staticdata.systemjumpsservice_thread = systemjumpsservice_thread;
    }

    public static Thread getContractservice_thread() {
        return contractservice_thread;
    }

    public static void setContractservice_thread(Thread swaggerdownloader) {
        Staticdata.contractservice_thread = swaggerdownloader;
    }

    public static ContractService getContractservice() {
        return contractservice;
    }

    public static void setContractservice(ContractService contractservice) {
        Staticdata.contractservice = contractservice;
    }

    public static Thread getHistoryservice_thread() {
        return historyservice_thread;
    }

    public static void setHistoryservice_thread(Thread historyservice_thread) {
        Staticdata.historyservice_thread = historyservice_thread;
    }

    public static Markethistory getHistoryservice() {
        return historyservice;
    }

    public static void setHistoryservice(Markethistory historyservice) {
        Staticdata.historyservice = historyservice;
    }

    public static Thread getMarket_group_service_thread() {
        return market_group_service_thread;
    }

    public static void setMarket_group_service_thread(Thread market_group_service_thread) {
        Staticdata.market_group_service_thread = market_group_service_thread;
    }

    public static Market_groupService getMarket_group_service() {
        return market_group_service;
    }

    public static void setMarket_group_service(Market_groupService market_group_service) {
        Staticdata.market_group_service = market_group_service;
    }

    public static Thread getCategory_service_thread() {
        return category_service_thread;
    }

    public static void setCategory_service_thread(Thread category_service_thread) {
        Staticdata.category_service_thread = category_service_thread;
    }

    public static CategoryService getCategory_service() {
        return category_service;
    }

    public static void setCategory_service(CategoryService category_service) {
        Staticdata.category_service = category_service;
    }

    public static Thread getUniverseservice_thread() {
        return universeservice_thread;
    }

    public static void setUniverseservice_thread(Thread universeservice_thread) {
        Staticdata.universeservice_thread = universeservice_thread;
    }

    public static UniverseService getUniverseservice() {
        return universeservice;
    }

    public static void setUniverseservice(UniverseService universeservice) {
        Staticdata.universeservice = universeservice;
    }
    
    
}
