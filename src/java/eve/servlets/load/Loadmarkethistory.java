/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.servlets.load;

import data.conversion.JSONConversion;
import db.AbstractSQLMapper;
import eve.BusinessObject.Logic.BLorder_history;
import eve.BusinessObject.Logic.BLview_order_region_evetype;
import eve.data.Swagger;
import eve.logicentity.Region;
import eve.logicview.View_order_region_evetype;
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
@WebServlet(name = "Loadmarkethistory", urlPatterns = {"/loadmarkethistory"})
public class Loadmarkethistory extends HttpServlet {

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
            JSONArray jsonhistory;
            Iterator<JSONObject> jsonhistoryI;
            JSONObject jsonline;
            
            BLorder_history blorderhistory = new BLorder_history();
            BLview_order_region_evetype blview_order_region_evetype = new BLview_order_region_evetype();

            //delete order history
            blorderhistory.deleteorders();
            
            //add market history per region / type
            int pagenr;
            Iterator<View_order_region_evetype> view_order_region_evetypesI = blview_order_region_evetype.getAll().iterator();
            View_order_region_evetype region_evetype;
            int historycounter = 0;
            StringBuilder sqlb = new StringBuilder();
            
            while(view_order_region_evetypesI.hasNext()) {
                region_evetype = view_order_region_evetypesI.next();
                System.out.println("Region/type " + region_evetype.getRegion() + " " + region_evetype.getEvetype());
                jsonhistory = Swagger.getMarket_history(region_evetype.getRegion(), region_evetype.getEvetype());
                jsonhistoryI = jsonhistory.iterator();
                while(jsonhistoryI.hasNext()) {
                    jsonline = jsonhistoryI.next();
                    //blorderhistory.updateOrder_history(region_evetype.getRegion(), region_evetype.getEvetype(), jsonline);
                    sqlb.delete(0, 200);
                    sqlb.append("insert into order_history values (");
                    sqlb.append(region_evetype.getRegion()).append(",");
                    sqlb.append(region_evetype.getEvetype()).append(",");
                    sqlb.append("'").append(Swagger.datestring2Date(JSONConversion.getString(jsonline, "date"))).append("',");
                    sqlb.append(JSONConversion.getDouble(jsonline, "average")).append(",");
                    sqlb.append(JSONConversion.getDouble(jsonline, "highest")).append(",");
                    sqlb.append(JSONConversion.getDouble(jsonline, "lowest")).append(",");
                    sqlb.append(JSONConversion.getint(jsonline, "volume")).append(",");
                    sqlb.append(JSONConversion.getint(jsonline, "order_count"));
                    sqlb.append(")");

                    blorderhistory.addStatement(sqlb.toString(), null);
                    
                    historycounter++;
                    if(historycounter==100) {
                        historycounter = 0;
                        blorderhistory.Commit2DB();
                    }
                }
                blorderhistory.Commit2DB();
            }
            System.out.println("Download done");
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
            out.println("<title>Servlet Loadmarkethistory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Loadmarkethistory at " + request.getContextPath() + "</h1>");
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
