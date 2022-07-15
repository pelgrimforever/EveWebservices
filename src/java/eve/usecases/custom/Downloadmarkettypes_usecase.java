package eve.usecases.custom;

import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.CategoryService;
import eve.BusinessObject.service.Market_groupService;
import eve.data.Staticdata;

/**
 * @author Franky Laseure
 */
public class Downloadmarkettypes_usecase {

    private Thread market_group_service_thread = null;
    private Market_groupService market_group_service = null;
    private Thread category_service_thread = null;
    private CategoryService category_service = null;
    private boolean keeprunning = false;
    private int count = 0;

    public Downloadmarkettypes_usecase() {
        market_group_service_thread = Staticdata.getMarket_group_service_thread();
        market_group_service = Staticdata.getMarket_group_service();
        category_service_thread = Staticdata.getCategory_service_thread();
        category_service = Staticdata.getCategory_service();
    }
    
    public void processRequest(boolean isadmin, boolean start_requested, boolean stop_requested) {
        boolean ismarketgroupservice_running = isMarketgroupDownloaderRunning();
        boolean ismarketgroupservice_done = ismarketgroupservice_running && getMarketgroupStatus().isDone();
        boolean ismarketgroupdownloader_not_running = !isMarketgroupDownloaderRunning();
        boolean iscategoryservice_running = isCategoryDownloaderRunning();
        boolean iscategoryservice_done = iscategoryservice_running && getCategoryStatus().isDone();
        boolean iscategorydownloader_not_running = !isCategoryServiceRunning();
        if(isadmin && start_requested)
            start_reset_services();
        if(isadmin && stop_requested && ismarketgroupservice_running)
            stop_services();
    }
    
    public boolean isMarketgroupServiceRunning() {
        return market_group_service!=null;
    }
    
    public Market_groupService.Market_groupStatus getMarketgroupStatus() {
        return market_group_service.getStatus();
    }
    
    private boolean isMarketgroupDownloaderRunning() {
        return market_group_service_thread!=null;
    }

    public boolean isCategoryServiceRunning() {
        return category_service!=null;
    }
    
    public CategoryService.CategoryStatus getCategoryStatus() {
        return category_service.getStatus();
    }
    
    private boolean isCategoryDownloaderRunning() {
        return category_service_thread!=null;
    }

    private void start_reset_services() {
        keeprunning = true;
        boolean ismarketgroupservice_running = market_group_service!=null;
        boolean ismarketgroupservice_done = ismarketgroupservice_running && market_group_service.getStatus().isDone();
        boolean iscategoryservice_running = category_service!=null;
        boolean iscategoryservice_done = iscategoryservice_running && category_service.getStatus().isDone();
        if(ismarketgroupservice_done && iscategoryservice_done)
            resetMarkettypes();
        boolean marketgroupdownloader_running = market_group_service_thread==null;
        if(marketgroupdownloader_running)
            start_marketgroup_service();
        boolean categorydownloader_running = category_service_thread==null;
        if(categorydownloader_running)
            start_categoryservice();
    }

    private void start_marketgroup_service() {
        SQLreader sqlreader = new SQLreader();
        SQLTwriter sqlwriter = new SQLTwriter();
        market_group_service = new Market_groupService(sqlreader, sqlwriter);
        market_group_service_thread = new Thread(market_group_service);
        market_group_service_thread.setPriority(Thread.MIN_PRIORITY);
        market_group_service_thread.start();
        storeStaticdata();
    }

    private void start_categoryservice() {
        SQLreader sqlreader = new SQLreader();
        SQLTwriter sqlwriter = new SQLTwriter();
        category_service = new CategoryService(sqlreader, sqlwriter);
        category_service_thread = new Thread(category_service);
        category_service_thread.setPriority(Thread.MIN_PRIORITY);
        category_service_thread.start();
        storeStaticdata();
    }

    private void stop_services() {
        market_group_service.stoprunning();
        category_service.stoprunning();
        keeprunning = false;
        market_group_service_thread.interrupt();
        market_group_service_thread = null;
        category_service_thread.interrupt();
        category_service_thread = null;
        market_group_service = null;
        category_service = null;
        storeStaticdata();
    }

    public void resetMarkettypes() {
        market_group_service_thread = null;
        market_group_service = null;
        category_service_thread = null;
        category_service = null;
        storeStaticdata();
    }

    private void storeStaticdata() {
        Staticdata.setMarket_group_service_thread(market_group_service_thread);
        Staticdata.setMarket_group_service(market_group_service);
        Staticdata.setCategory_service_thread(category_service_thread);
        Staticdata.setCategory_service(category_service);
    }
}
