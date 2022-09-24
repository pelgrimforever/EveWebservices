package eve.BusinessObject.service;

import db.SQLTwriter;
import db.SQLTqueue;
import db.SQLreader;
import eve.BusinessObject.Logic.BLcategory;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLtypegroup;
import eve.data.Swagger;
import eve.entity.pk.CategoryPK;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.TypegroupPK;
import eve.logicentity.Evetype;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class CategoryService implements Runnable {
    
    private CategoryStatus categorystatus;
    private boolean keeprunning = true;
    
    public void stoprunning() {
        this.keeprunning = false;
    }
    
    public CategoryStatus getStatus() {
        return categorystatus;
    }
    
    public class CategoryStatus {
        private long categories = 0;
        private long totalcategories = 1;
        private long typegroups = 0;
        private long totaltypegroups = 1;
        private long types = 0;
        private long totaltypes = 1;
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public CategoryStatus() {
        }
        
        public void setDone() {
            this.done = true;
        }

        public long getCategories() {
            return categories;
        }

        public void incCategories() {
            this.categories++;
        }

        public long getTypegroups() {
            return typegroups;
        }

        public void incTypegroups() {
            this.typegroups++;
        }

        public long getTypes() {
            return types;
        }

        public void incTypes() {
            this.types++;
        }

        public long getTotalcategories() {
            return totalcategories;
        }

        public long getTotaltypegroups() {
            return totaltypegroups;
        }

        public long getTotaltypes() {
            return totaltypes;
        }
        
        public void addMessage(String message) {
            messages.add(message);
        }

        public ArrayList getMessages() {
            return this.messages;
        }

        public boolean isDone() {
            return this.done;
        }
    }
    
    public CategoryService(SQLreader sqlreader, SQLTwriter sqlwriter) {
        this.sqlreader = sqlreader;
        categorystatus = new CategoryStatus();
    }
    
    private SQLreader sqlreader;
    private SQLTwriter sqlwriter;
    private SQLTqueue transactionqueue;
    private BLcategory blcategory;
    private BLtypegroup bltypegroup;
    private BLevetype blevetype;
    private int run;
    private JSONArray jsoncategories;
    private JSONArray jsontypegroups;
    private JSONArray jsonevetypes;
    private Iterator<Long> jsoncategoriesI;
    private Iterator<Long> jsontypegroupsI;
    private Iterator<Long> jsonevetypesI;
    private Long categoryid;
    private Long typegroupid;
    private Long evetypeid;
    private JSONObject jsoncategorydetails;
    private JSONObject jsontypegroupdetails;
    private JSONObject jsonevetypedetails;
    private int typegrouprun;
    private int evetyperun;
    private int evetypecounter;
    
    @Override
    public void run() {
        categorystatus.addMessage("Download Categories/Type groups/Types");
        long start = System.currentTimeMillis();
        try {
            initialize_businesslogic();
            run = 0;
            jsoncategories = Swagger.getCategories();
            jsoncategoriesI = jsoncategories.iterator();
            do
                update_categories();
            while(keeprunning && less_categories_in_database_then_loaded());
        }
        catch(DBException e) {
            categorystatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            categorystatus.addMessage(e.getMessage());
        }

        long end = System.currentTimeMillis();
        categorystatus.addMessage("Download time Categories/Type groups/Types " + ((end - start)/1000) + "sec.");
        categorystatus.setDone();
    }

    private boolean less_categories_in_database_then_loaded() throws DBException {
        return blcategory.count()<jsoncategories.size();
    }

    private void update_categories() throws DataException, DBException {
        while(keeprunning && jsoncategoriesI.hasNext())
            update_category();
        run++;
    }

    private void update_category() throws DataException, DBException {
        load_and_save_category_details();
        load_typegroups_for_category();
        while(keeprunning && jsontypegroupsI.hasNext())
            load_and_save_typegroup();
        typegrouprun++;
        categorystatus.incCategories();
    }

    private void load_and_save_typegroup() throws DBException, DataException {
        load_and_save_typegroup_details();
        load_evetypes_for_typegroup();
        while(keeprunning && jsonevetypesI.hasNext())
            load_and_save_evetype_details_if_not_in_database();
        sqlwriter.Commit2DB(transactionqueue);
        evetyperun++;
        categorystatus.incTypegroups();
    }

    private void load_and_save_evetype_details_if_not_in_database() throws DBException, DataException {
        evetypeid = (Long)jsonevetypesI.next();
        boolean evetype_not_in_database = !blevetype.getEvetypeExists(new EvetypePK(evetypeid));
        if(evetyperun==0 || evetype_not_in_database)
            load_and_save_evetype_details();
        categorystatus.incTypes();
    }

    private void load_and_save_evetype_details() throws DBException, DataException {
        jsonevetypedetails = Swagger.getType(evetypeid);
        Evetype evetype = blevetype.convert2Evetype(jsonevetypedetails);
        blevetype.insertupdateEvetype(transactionqueue, evetype);
        evetypecounter++;
        if(evetypecounter==100)
            save_evetype_buffer();
    }

    private void save_evetype_buffer() throws DBException {
        sqlwriter.Commit2DB(transactionqueue);
        evetypecounter = 0;
    }

    private void load_evetypes_for_typegroup() {
        jsonevetypes = (JSONArray)jsontypegroupdetails.get("types");
        evetyperun = 0;
        jsonevetypesI = jsonevetypes.iterator();
        evetypecounter = 0;
    }

    private void load_and_save_typegroup_details() throws DBException, DataException {
        typegroupid = (Long)jsontypegroupsI.next();
        jsontypegroupdetails = Swagger.getGroup(typegroupid);
        boolean typegroup_not_in_database = !bltypegroup.getTypegroupExists(new TypegroupPK(typegroupid));
        if(typegrouprun==0 || typegroup_not_in_database)
            save_typegroup();
    }

    private void save_typegroup() throws DBException, DataException {
        bltypegroup.updateTypegroup(transactionqueue, jsontypegroupdetails);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void load_typegroups_for_category() {
        jsontypegroups = (JSONArray)jsoncategorydetails.get("groups");
        jsontypegroupsI = jsontypegroups.iterator();
        typegrouprun = 0;
    }

    private void load_and_save_category_details() throws DBException, DataException {
        categoryid = (Long)jsoncategoriesI.next();
        jsoncategorydetails = Swagger.getCategory(categoryid);
        boolean category_not_in_database = !blcategory.getCategoryExists(new CategoryPK(categoryid));
        if(run==0 || category_not_in_database)
            save_category();
    }

    private void save_category() throws DBException, DataException {
        blcategory.updateCategory(transactionqueue, jsoncategorydetails);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void initialize_businesslogic() throws DBException {
        transactionqueue = new SQLTqueue();
        BLcategory blcategory = new BLcategory(sqlreader);
        blcategory.setAuthenticated(true);
        categorystatus.totalcategories = blcategory.count();
        BLtypegroup bltypegroup = new BLtypegroup(sqlreader);
        bltypegroup.setAuthenticated(true);
        categorystatus.totaltypegroups = bltypegroup.count();
        BLevetype blevetype = new BLevetype(sqlreader);
        blevetype.setAuthenticated(true);
        categorystatus.totaltypes = blevetype.count();
        blcategory = new BLcategory(sqlreader);
        blcategory.setAuthenticated(true);
        bltypegroup = new BLtypegroup(blcategory);
        bltypegroup.setAuthenticated(true);
        blevetype = new BLevetype(bltypegroup);
        blevetype.setAuthenticated(true);
    }

}
