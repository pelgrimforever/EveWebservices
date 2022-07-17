/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.graphic;

import general.exception.CustomException;
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Graphic_insert", urlPatterns={"/eve.Graphic_insert"})
public class Graphic_insert extends SecurityDataServlet {
   
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
                case IGraphicOperation.INSERT_GRAPHIC:
                    insert_graphic(graphicusecases);
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

    private void insert_graphic(Graphic_usecases graphicusecases) throws CustomException {
        IGraphic graphic = (IGraphic)parser.getJavaObject("graphic");
        graphicusecases.insertGraphic(graphic);
    }
    
    @Override
    public String getServletInfo() {
        return "graphic_insert";
    }

}

