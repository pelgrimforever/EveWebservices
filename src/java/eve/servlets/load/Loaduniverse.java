/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.servlets.load;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLrace;
import eve.BusinessObject.Logic.BLstation;
import eve.BusinessObject.Logic.BLstation_service;
import eve.BusinessObject.Logic.BLsystem;
import eve.data.Swagger;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.RacePK;
import eve.entity.pk.StationPK;
import eve.entity.pk.SystemPK;
import eve.logicentity.Race;
import general.exception.DBException;
import general.exception.DataException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author pelgrim
 */
@WebServlet(name = "Loaduniverse", urlPatterns = {"/loaduniverse"})
public class Loaduniverse extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String outputstring = "";
        int run = 0;
        
        try {
            int jsonlength;
            JSONObject json;
            JSONArray jsonarray;

//activate
/*
            //add graphics
            BLgraphic blgraphic = new BLgraphic();
            JSONArray jsongraphics = Swagger.getGraphics();
            Iterator<Long> jsongraphicsI = jsongraphics.iterator();
            Long graphicid;
            JSONObject jsontypegraphicdetails;
            run = 0;
            do {
                int graphicscounter = 0;
                while(jsongraphicsI.hasNext()) {
                    graphicid = (Long)jsongraphicsI.next();
                    if(run==0 || !blgraphic.getGraphicExists(new GraphicPK(graphicid))) {
                        jsontypegraphicdetails = Swagger.getGraphic(graphicid);
                        blgraphic.updateGraphic(jsontypegraphicdetails);
                        graphicscounter++;
                        if(graphicscounter==1000) {
                            graphicscounter = 0;
                            blgraphic.Commit2DB();
                        }
                    }
                }
                blgraphic.Commit2DB();
                run++;
            } while(blgraphic.count()<jsongraphics.size());
/**/

//activate
/*
            //add categories
            BLcategory blcategory = new BLcategory();
            JSONArray jsoncategories = Swagger.getCategories();
            Iterator<Long> jsoncategoriesI = jsoncategories.iterator();
            Long categoryid;
            JSONObject jsoncategorydetails;
            run = 0;
            do {
                while(jsoncategoriesI.hasNext()) {
                    categoryid = (Long)jsoncategoriesI.next();
                    if(run==0 || !blcategory.getCategoryExists(new CategoryPK(categoryid))) {
                        jsoncategorydetails = Swagger.getCategory(categoryid);
                        blcategory.updateCategory(jsoncategorydetails);
                    }
                }
                blcategory.Commit2DB();
                run++;
            } while(blcategory.count()<jsoncategories.size());
/**/

//activate
/*
            //add groups
            BLtypegroup bltypegroup = new BLtypegroup();
            JSONArray jsontypegroups = Swagger.getGroups();
            Iterator<Long> jsontypegroupsI;
            Long typegroupid;
            JSONObject jsontypegroupdetails;

            //hard coded, in Swagger, group 86 is not listed in the groups REST call
            long[] typegroupshardcoded = { 86, 1730 };
            int l = typegroupshardcoded.length;
            for(int i=0; i<l; i++) {
                jsontypegroupdetails = Swagger.getGroup(typegroupshardcoded[i]);
                bltypegroup.updateTypegroup(jsontypegroupdetails);
            }
            bltypegroup.Commit2DB();

            run = 0;
            do {
                jsontypegroupsI = jsontypegroups.iterator();
                while(jsontypegroupsI.hasNext()) {
                    typegroupid = (Long)jsontypegroupsI.next();
                    if(run==0 || !bltypegroup.getTypegroupExists(new TypegroupPK(typegroupid))) {
                        jsontypegroupdetails = Swagger.getGroup(typegroupid);
                        bltypegroup.updateTypegroup(jsontypegroupdetails);
                    }
                }
                bltypegroup.Commit2DB();
                run++;
            } while(bltypegroup.count()<jsontypegroups.size());
/**/

//activate
/*
            //add types (marketgroups)
            BLmarket_group blmarketgroup = new BLmarket_group();
            JSONArray jsonmarketgroup = Swagger.getMarketgroups();
            Iterator<Long> jsonmarketgroupI = jsonmarketgroup.iterator();
            Long marketgroupid;
            JSONObject jsonmarketgroupdetails;
            int marketgroupcounter = 0;
            ArrayList<Market_group> parentupdates = new ArrayList<>();
            Market_group marketgroup;
            run = 0;
            do {
                while(jsonmarketgroupI.hasNext()) {
                    marketgroupid = (Long)jsonmarketgroupI.next();
                    if(run==0 || !blmarketgroup.getMarket_groupExists(new Market_groupPK(marketgroupid))) {
                        jsonmarketgroupdetails = Swagger.getMarketgroup(marketgroupid);
                        marketgroup = blmarketgroup.updateMarket_group(jsonmarketgroupdetails);
                        if(run==0 && jsonmarketgroupdetails.containsKey("parent_group_id")) {
                            parentupdates.add(blmarketgroup.updateParent(marketgroup, jsonmarketgroupdetails));
                        }                
                        marketgroupcounter++;
                        if(marketgroupcounter==1000) {
                            marketgroupcounter = 0;
                            blmarketgroup.Commit2DB();
                        }
                    }
                }
                blmarketgroup.Commit2DB();
                run++;
            } while(blmarketgroup.count()<jsonmarketgroup.size());
            
            Iterator<Market_group> marketgroupI = parentupdates.iterator();
            while(marketgroupI.hasNext()) {
                blmarketgroup.trans_updateMarket_group(marketgroupI.next());
            }
            blmarketgroup.Commit2DB();
/**/

//activate
/*
            //add types (evetypes)
            BLevetype blevetype = new BLevetype();
            JSONArray jsonevetype = Swagger.getTypes();
            Iterator<Long> jsonevetypeI = jsonevetype.iterator();
            Long evetypeid;
            JSONObject jsonevetypedetails;
            run = 0;
            do {
                int evetypescounter = 0;
                while(jsonevetypeI.hasNext()) {
                    evetypeid = (Long)jsonevetypeI.next();
                    if(run==0 || !blevetype.getEvetypeExists(new EvetypePK(evetypeid))) {
                        jsonevetypedetails = Swagger.getType(evetypeid);
                        blevetype.updateEvetype(jsonevetypedetails);
                        evetypescounter++;
                        if(evetypescounter==100) {
                            evetypescounter = 0;
                            blevetype.Commit2DB();
                        }
                    }
                }
                blevetype.Commit2DB();
                run++;
            } while(blevetype.count()<jsonevetype.size());
                
/**/

//activate
/*
            //add races
            BLrace blrace = new BLrace();
            JSONArray jsonrace = Swagger.getRaces();
            Iterator<JSONObject> jsonraceI = jsonrace.iterator();
            Long raceid;
            JSONObject jsonracedetails;
            while(jsonraceI.hasNext()) {
                jsonracedetails = (JSONObject)jsonraceI.next();
                blrace.updateRace(jsonracedetails);
            }
            blrace.Commit2DB();
/**/

//activate            
/*
            //add/update regions
            JSONArray jsonregions = Swagger.getRegions();
            JSONArray jsonregionnames = Swagger.getNames(jsonregions.toJSONString());
            BLregion blregion = new BLregion();
            blregion.updateRegions(jsonregionnames);
/**/

            //do not activate
            /*
            //updates Constellation names only
            JSONArray jsonconstellations = Swagger.getConstellations();
            JSONArray jsonconstellationnames;
            Iterator<JSONObject> jsonI = jsonconstellations.iterator();
            jsonarray = new JSONArray();
            jsonlength = 0;
            while(jsonI.hasNext()) {
                jsonarray.add(jsonI.next());
                jsonlength++;
                if(jsonlength==1000 || !jsonI.hasNext()) {
                    jsonconstellationnames = Swagger.getNames(jsonarray.toJSONString());
                    BLconstellation blconstellation = new BLconstellation();
                    blconstellation.updateConstellations(jsonconstellationnames);
                    jsonarray = new JSONArray();
                    jsonlength = 0;
                }
            }
            */
            
//activate
/*
            //adds/updates Constellation names and references
            BLconstellation blconstellation = new BLconstellation();
            JSONArray jsonconstellations = Swagger.getConstellations();
            JSONArray jsonconstellationnames;
            Iterator<Long> jsonconstellationsI = jsonconstellations.iterator();
            Long constellationid;
            JSONObject jsonconstellationdetails;
            run = 0;
            do {
                while(jsonconstellationsI.hasNext()) {
                    constellationid = (Long)jsonconstellationsI.next();
                    if(run==0 || !blconstellation.getConstellationExists(new ConstellationPK(constellationid))) {
                        jsonconstellationdetails = Swagger.getConstellation(constellationid);
                        blconstellation.updateConstellation(jsonconstellationdetails);
                    }
                }
                blconstellation.Commit2DB();
                run++;
            } while(blconstellation.count()<jsonconstellations.size());
/**/

//activate            
/**/
            //adds/updates System names and references
            //add station services
            BLsystem blsystem = new BLsystem();
            BLstation blstation = new BLstation(blsystem);
            BLstation_service blstationservice = new BLstation_service(blsystem);
            BLevetype blevetype_check = new BLevetype();
            BLrace blrace_check = new BLrace();
            JSONArray jsonsystems = Swagger.getSystems();
            JSONArray jsonstations;
            JSONArray jsonservices;
            Iterator<Long> jsonsystemsI = jsonsystems.iterator();
            Iterator<Long> jsonstationsI;
            Iterator<String> jsonservicesI;            
            Long systemid;
            Long stationid;
            Long evetypeid_check;
            Long raceid_check;
            String servicename;
            JSONObject jsonsystemdetails;
            JSONObject jsonstationdetails;
            int dataoperatios = 0;
            run = 0;
            do {
                while(jsonsystemsI.hasNext()) {
                    systemid = (Long)jsonsystemsI.next();
                    if(run==0 || !blsystem.getSystemExists(new SystemPK(systemid))) {
                        jsonsystemdetails = Swagger.getSystem(systemid);
                        blsystem.updateSystem(jsonsystemdetails);
                        jsonstations = (JSONArray)jsonsystemdetails.get("stations");
                        if(jsonstations!=null) {
                            jsonstationsI = jsonstations.iterator();
                            int runstations = 0;
                            do {
                                while(jsonstationsI.hasNext()) {
                                    stationid = (Long)jsonstationsI.next();
                                    if(run==0 || !blstation.getStationExists(new StationPK(stationid))) {
                                        jsonstationdetails = Swagger.getStation(stationid);
                                        
                                        //check if type is loaded, a lot are missing in Swagger types
                                        evetypeid_check = JSONConversion.getLong(jsonstationdetails, "type_id");
                                        if(!blevetype_check.getEvetypeExists(new EvetypePK(evetypeid_check))) {
                                            blevetype_check.updateEvetype(Swagger.getType(evetypeid_check));
                                            blevetype_check.Commit2DB();
                                        }
                                        //race 16 is not listed in Swagger races
                                        raceid_check = JSONConversion.getLong(jsonstationdetails, "race_id");
                                        if(!blrace_check.getRaceExists(new RacePK(raceid_check))) {
                                            Race race = new Race(raceid_check);
                                            race.setName("Unknown");
                                            race.setDescription("Not listed in Swagger");
                                            race.setAlliance(-1);
                                            blrace_check.insertRace(race);
                                            blrace_check.Commit2DB();
                                        }
                                        
                                        blstation.updateStation(jsonstationdetails);
                                        dataoperatios++;
                                        jsonservices = (JSONArray)jsonstationdetails.get("services");
                                        jsonservicesI = jsonservices.iterator();
                                        while(jsonservicesI.hasNext()) {
                                            blstationservice.updateStation_service(new StationPK(stationid), jsonservicesI.next());
                                        }
                                    }
                                }
                                blsystem.Commit2DB();
                                runstations++;
                            } while(blstation.getStations4systemcount(new SystemPK(systemid))<jsonstations.size());
                        }
                    }
                }
                blsystem.Commit2DB();
                run++;
            } while(blsystem.count()<jsonsystems.size());
/**/            

        }
        catch(DataException e) {
            outputstring = e.getMessage();
        }
        catch(DBException e) {
            outputstring = e.getMessage();
        }
        catch(Exception e) {
            outputstring = e.getMessage();
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loadregions</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>DONE</h1>");
            out.println("<p>" + outputstring + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
