/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.graphic;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IGraphic;
import eve.interfaces.servlet.IGraphicOperation;
import eve.interfaces.searchentity.IGraphicsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Graphic_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Graphic_select", urlPatterns={"/eve.Graphic_select"})
public class Graphic_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Graphic_usecases graphicusecases = new Graphic_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IGraphicOperation.SELECT_ALL:
                    dataobject = graphicusecases.get_all();
                    break;
                case IGraphicOperation.SELECT_GRAPHIC:
                    dataobject = get_graphic_with_primarykey(graphicusecases);
                    break;
                case IGraphicOperation.SELECT_SEARCH:
                    dataobject = search_graphic(graphicusecases);
                    break;
                case IGraphicOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_graphic_count(graphicusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_graphic_with_primarykey(Graphic_usecases graphicusecases) throws DBException {
        IGraphicPK graphicPK = (IGraphicPK)parser.getJavaObject("graphicpk");
        return graphicusecases.get_graphic_by_primarykey(graphicPK);
    }

    private Object search_graphic(Graphic_usecases graphicusecases) throws CustomException {
        IGraphicsearch search = (IGraphicsearch)parser.getJavaObject("search");
        return graphicusecases.search_graphic(search);
    }
    
    private Object search_graphic_count(Graphic_usecases graphicusecases) throws CustomException {
        IGraphicsearch graphicsearch = (IGraphicsearch)parser.getJavaObject("search");
        return graphicusecases.search_graphic_count(graphicsearch);
    }

    @Override
    public String getServletInfo() {
        return "graphic_select";
    }

}

