/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 8.4.2021 13:20
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IGraphic;
import eve.interfaces.servlet.IGraphicOperation;
import eve.interfaces.searchentity.IGraphicsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Graphic", urlPatterns={"/eve.Graphic"})
public class Graphic extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLgraphic blgraphic = new BLgraphic();
        blgraphic.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IGraphicPK graphicPK;
                    IGraphic graphic;
                    switch(this.operation) {
                        case IGraphicOperation.SELECT_ALL:
                            dataobject = blgraphic.getGraphics();
                            break;
                        case IGraphicOperation.SELECT_GRAPHIC:
                            graphicPK = (IGraphicPK)parser.getJavaObject("graphicpk");
                            dataobject = blgraphic.getGraphic(graphicPK);
                            break;
                        case IGraphicOperation.SELECT_SEARCH:
                            IGraphicsearch search = (IGraphicsearch)parser.getJavaObject("search");
                            dataobject = blgraphic.search(search);
                            break;
                        case IGraphicOperation.SELECT_SEARCHCOUNT:
                            IGraphicsearch graphicsearch = (IGraphicsearch)parser.getJavaObject("search");
                            dataobject = blgraphic.searchcount(graphicsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IGraphicOperation.INSERT_GRAPHIC:
                            graphic = (IGraphic)parser.getJavaObject("graphic");
                            blgraphic.insertGraphic(graphic);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IGraphicOperation.UPDATE_GRAPHIC:
                            graphic = (IGraphic)parser.getJavaObject("graphic");
                            blgraphic.updateGraphic(graphic);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IGraphicOperation.DELETE_GRAPHIC:
                            graphic = (IGraphic)parser.getJavaObject("graphic");
                            blgraphic.deleteGraphic(graphic);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "graphic";
    }

}

