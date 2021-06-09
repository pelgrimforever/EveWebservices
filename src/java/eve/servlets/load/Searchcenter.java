/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.servlets.load;

import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLtmp_system_jumps;
import eve.BusinessObject.Logic.BLview_security_island_systemcount;
import eve.entity.pk.Security_islandPK;
import eve.logicentity.Tmp_system_jumps;
import eve.logicview.View_security_island_systemcount;
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
@WebServlet(name = "Searchcenter", urlPatterns = {"/searchcenter"})
public class Searchcenter extends HttpServlet {

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

        try {
            int jsonlength;
            JSONObject json;
            JSONArray jsonarray;

            long securityidlandid = 1;
            BLview_security_island_systemcount blsystemcount = new BLview_security_island_systemcount();
            BLsystem blsystem = new BLsystem();
            BLtmp_system_jumps bltmpsystemjumps = new BLtmp_system_jumps();
            
            //get biggest security island
            View_security_island_systemcount view_security_island_systemcount = (View_security_island_systemcount)blsystemcount.getAll().get(0);
            //copy all system from security island in tmp_system_jumps
            bltmpsystemjumps.copySystems(new Security_islandPK(view_security_island_systemcount.getId()));
            //iterate throug all systems
            //determine min jumps needed to reach each other system
            //save that number in field maxjumps
            //the system with smallest maxjumps number can be concidered as centrum
            Iterator<Tmp_system_jumps> systemjumpsI = bltmpsystemjumps.getAll().iterator();
            Tmp_system_jumps systemjumps;
            while(systemjumpsI.hasNext()) {
                systemjumps = systemjumpsI.next();
                //clear jump counters
                bltmpsystemjumps.resetJumps(systemjumps.getPrimaryKey());
                int jump = -1;
                while(bltmpsystemjumps.countNojump()>0) {
                    jump++;
                    bltmpsystemjumps.updateNextjump(jump);
                }
                bltmpsystemjumps.setMaxjumps(systemjumps.getPrimaryKey(), jump);
            }
            
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
            out.println("<title>Servlet Searchcenter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Searchcenter at " + request.getContextPath() + "</h1>");
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
