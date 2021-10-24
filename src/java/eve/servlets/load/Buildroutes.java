/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.servlets.load;

import data.json.piJsonarray;
import eve.BusinessObject.Logic.BLcategory;
import eve.BusinessObject.Logic.BLconstellation;
import eve.BusinessObject.Logic.BLconstellation_neighbour;
import eve.BusinessObject.Logic.BLcorporation;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLfaction;
import eve.BusinessObject.Logic.BLgraphic;
import eve.BusinessObject.Logic.BLmarket_group;
import eve.BusinessObject.Logic.BLrace;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.Logic.BLregion_neighbour;
import eve.BusinessObject.Logic.BLroute;
import eve.BusinessObject.Logic.BLroutetype;
import eve.BusinessObject.Logic.BLsecurity_island;
import eve.BusinessObject.Logic.BLstargate;
import eve.BusinessObject.Logic.BLstation;
import eve.BusinessObject.Logic.BLstation_service;
import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLsystemjumps;
import eve.BusinessObject.Logic.BLtmp_system_jumps;
import eve.BusinessObject.Logic.BLtypegroup;
import eve.entity.pk.SystemPK;
import eve.logicentity.Route;
import eve.logicentity.Routetype;
import eve.logicentity.Security_island;
import eve.logicentity.Stargate;
import eve.logicentity.Systemjumps;
import eve.logicentity.Tmp_system_jumps;
import general.exception.DBException;
import general.exception.DataException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet(name = "Buildroutes", urlPatterns = {"/buildroutes"})
public class Buildroutes extends HttpServlet {

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

            BLgraphic blgraphic = new BLgraphic();
            BLmarket_group blmarketgroup = new BLmarket_group();
            BLcategory blcategory = new BLcategory();
            BLtypegroup bltypegroup = new BLtypegroup(blcategory);
            BLevetype blevetype = new BLevetype(bltypegroup);
            BLregion blregion = new BLregion();
            BLconstellation blconstellation = new BLconstellation();
            BLsystem blsystem = new BLsystem();
            BLstation blstation = new BLstation(blsystem);
            BLstargate blstargate = new BLstargate(blsystem);
            BLstation_service blstationservice = new BLstation_service(blsystem);
            BLevetype blevetype_check = new BLevetype();
            BLrace blrace_check = new BLrace();
            BLfaction blfaction = new BLfaction();
            BLrace blrace = new BLrace();
            BLcorporation blcorporation = new BLcorporation();
            BLconstellation_neighbour blconstellationneighbour = new BLconstellation_neighbour();
            BLregion_neighbour blregionneighbour = new BLregion_neighbour();
            BLsecurity_island blsecurityisland = new BLsecurity_island();
            BLtmp_system_jumps bltmpsystemjumps = new BLtmp_system_jumps();
            BLroutetype blroutetype = new BLroutetype();
            BLroute blroute = new BLroute();
            BLsystemjumps blsystemjumps = new BLsystemjumps();
            
            //create routes in a star pattern around each system
//activate
/**/
            blsystemjumps.deleteall();
            Iterator<Security_island> securityislandsI = blsecurityisland.getAll().iterator();
            Security_island securityisland;
            Routetype routetype;
            Iterator<System> systemsI;
            System system;
            Iterator<Tmp_system_jumps> alltmpsystemjumpsI = bltmpsystemjumps.getAll().iterator();
            Tmp_system_jumps alltmpsystemjumps;
            Iterator<Tmp_system_jumps> tmpsystemjumpsI;
            Tmp_system_jumps tmpsystemjumps;
            Iterator <Stargate> stargatesI;
            Stargate stargate;
            JSONArray jsonroute;
            JSONObject jsonroutenode;
            JSONObject jsonparentnode;
            JSONArray jsonchildren;
            HashMap<Long, JSONObject> routehash;
            Route route;
            Systemjumps systemjumps;
            //Systemjumps alltmpsystemjumps;
            while(securityislandsI.hasNext()) {
                securityisland = securityislandsI.next();
                routetype = new Routetype(securityisland.getPrimaryKey().getId());
                routetype.setName(String.valueOf(routetype.getPrimaryKey().getId()));
                routetype.setSecurity_islandPK(securityisland.getPrimaryKey());
                blroutetype.insertupdateRoutetype(routetype);
                blroutetype.Commit2DB();
                blroute.delete4routetype(routetype.getPrimaryKey());

                //construct star pattern for each system in security island
                
                //copy systems in tmp table
                bltmpsystemjumps.copySystems(securityisland.getPrimaryKey());
                //iterate throug all systems
                //determine min jumps needed to reach each other system
                //create json structure from result
                //save jsonroute in table
                alltmpsystemjumpsI = bltmpsystemjumps.getAll().iterator();

                while(alltmpsystemjumpsI.hasNext()) {
                    alltmpsystemjumps = alltmpsystemjumpsI.next();
/**/
                    //clear jump counters
                    bltmpsystemjumps.resetJumps(alltmpsystemjumps.getPrimaryKey());

                    //initiate jsonarray with first system, jump 0
                    routehash = new HashMap<>();
                    jsonroute = new JSONArray();
                    jsonroutenode = new JSONObject();
                    jsonroutenode.put("jumps", 0);
                    jsonroutenode.put("id", alltmpsystemjumps.getPrimaryKey().getSystem());
                    jsonroute.add(jsonroutenode);
                    routehash.put(alltmpsystemjumps.getPrimaryKey().getSystem(), jsonroutenode);

                    int jump = -1;
                    while(bltmpsystemjumps.countNojump()>0) {
                        jump++;
                        bltmpsystemjumps.updateNextjump(jump);
                        //update previoussystem
                        tmpsystemjumpsI = bltmpsystemjumps.getSystems4jump(jump+1).iterator();
                        while(tmpsystemjumpsI.hasNext()) {
                            tmpsystemjumps = tmpsystemjumpsI.next();
                            stargate = blstargate.getPreviousGate(new SystemPK(tmpsystemjumps.getPrimaryKey().getSystem()));
                            tmpsystemjumps.setPrevioussystem(stargate.getSystemsystemPK().getId());
                            bltmpsystemjumps.trans_updateTmp_system_jumps(tmpsystemjumps);
                            //add system in json tree
                            jsonparentnode = routehash.get(stargate.getSystemsystemPK().getId());
                            jsonroutenode = new JSONObject();
                            jsonroutenode.put("jumps", jump+1);
                            jsonroutenode.put("id", tmpsystemjumps.getPrimaryKey().getSystem());
                            routehash.put(tmpsystemjumps.getPrimaryKey().getSystem(), jsonroutenode);
                            //check if jsonchildren node exist, create if needed and add tmpsystemjumps.getPrimaryKey().getSystem()
                            if(jsonparentnode.containsKey("jsonchildren")) {
                                jsonchildren = (JSONArray)jsonparentnode.get("jsonchildren");
                            } else {
                                jsonchildren = new JSONArray();
                                jsonparentnode.put("jsonchildren", jsonchildren);
                            }
                            jsonchildren.add(jsonroutenode);
                        }
                        bltmpsystemjumps.Commit2DB();
                    }
                    //save tree in database
                    route = new Route(routetype.getPrimaryKey().getId(), alltmpsystemjumps.getPrimaryKey().getSystem());
                    route.setJsonroutes(new piJsonarray(jsonroute));
                    blroute.insertRoute(route);
                    
                    //save system jump count in alltmpsystemjumps
                    blsystemjumps.copy_Tmp_system_jumps(alltmpsystemjumps.getPrimaryKey().getSystem());
                }
            }
            blsystemjumps.set0jumpsto1();
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Buildroutes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Buildroutes at " + request.getContextPath() + "</h1>");
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
