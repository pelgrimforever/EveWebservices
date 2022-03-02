/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import eve.BusinessObject.Logic.BLcategory;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLtypegroup;
import eve.data.Swagger;
import eve.entity.pk.CategoryPK;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.TypegroupPK;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Market loader service
 * @author pelgrim
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
            try {
                totalcategories = (new BLcategory()).count();
                totaltypegroups = (new BLtypegroup()).count();
                totaltypes = (new BLevetype()).count();
            }
            catch(DBException e) {
                
            }
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
    
    public CategoryService() {
        categorystatus = new CategoryStatus();
    }
    
    @Override
    public void run() {
        categorystatus.addMessage("Download Categories/Type groups/Types");
        BLcategory blcategory = new BLcategory();
        blcategory.setAuthenticated(true);
        BLtypegroup bltypegroup = new BLtypegroup(blcategory);
        bltypegroup.setAuthenticated(true);
        BLevetype blevetype = new BLevetype(bltypegroup);
        blevetype.setAuthenticated(true);

        long start = System.currentTimeMillis();

        try {
            int run = 0;
            //add categories
            JSONArray jsoncategories = Swagger.getCategories();
            JSONArray jsontypegroups;
            JSONArray jsonevetypes;
            Iterator<Long> jsoncategoriesI = jsoncategories.iterator();
            Iterator<Long> jsontypegroupsI;
            Iterator<Long> jsonevetypesI;
            Long categoryid;
            Long typegroupid;
            Long evetypeid;
            JSONObject jsoncategorydetails;
            JSONObject jsontypegroupdetails;
            JSONObject jsonevetypedetails;
            int typegrouprun;
            int evetyperun;
            int evetypecounter;

            do {
                while(keeprunning && jsoncategoriesI.hasNext()) {
                    categoryid = (Long)jsoncategoriesI.next();
                    jsoncategorydetails = Swagger.getCategory(categoryid);
                    //get typegroups
                    jsontypegroups = (JSONArray)jsoncategorydetails.get("groups");
                    typegrouprun = 0;
                    //do {
                        if(run==0 || !blcategory.getCategoryExists(new CategoryPK(categoryid))) {
                            blcategory.updateCategory(jsoncategorydetails);
                            blcategory.Commit2DB();
                        }
                        jsontypegroupsI = jsontypegroups.iterator();
                        while(keeprunning && jsontypegroupsI.hasNext()) {
                            typegroupid = (Long)jsontypegroupsI.next();
                            jsontypegroupdetails = Swagger.getGroup(typegroupid);
                            jsonevetypes = (JSONArray)jsontypegroupdetails.get("types");
                            evetyperun = 0;
                            //do {
                                if(typegrouprun==0 || !bltypegroup.getTypegroupExists(new TypegroupPK(typegroupid))) {
                                    bltypegroup.updateTypegroup(jsontypegroupdetails);
                                    bltypegroup.Commit2DB();
                                }
                                jsonevetypesI = jsonevetypes.iterator();
                                evetypecounter = 0;
                                while(keeprunning && jsonevetypesI.hasNext()) {
                                    evetypeid = (Long)jsonevetypesI.next();
                                    if(evetyperun==0 || !blevetype.getEvetypeExists(new EvetypePK(evetypeid))) {
                                        jsonevetypedetails = Swagger.getType(evetypeid);
                                        blevetype.updateEvetype(jsonevetypedetails);
                                        evetypecounter++;
                                        if(evetypecounter==100) {
                                            blevetype.Commit2DB();
                                            evetypecounter = 0;
                                        }
                                    }
                                    categorystatus.incTypes();
                                }
                                blevetype.Commit2DB();
                                evetyperun++;
                            //} while(keeprunning && blevetype.getEvetypes4typegroupcount(new TypegroupPK(typegroupid))<jsonevetypes.size());
                            categorystatus.incTypegroups();
                        }
                        typegrouprun++;
                    //} while(keeprunning && bltypegroup.getTypegroup4categorycount(new CategoryPK(categoryid))<jsontypegroups.size());
                    categorystatus.incCategories();
                }
                run++;
            } while(keeprunning && blcategory.count()<jsoncategories.size());
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

}
