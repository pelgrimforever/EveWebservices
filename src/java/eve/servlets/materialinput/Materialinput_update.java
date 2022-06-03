/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.materialinput;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IMaterialinput;
import eve.interfaces.servlet.IMaterialinputOperation;
import eve.interfaces.searchentity.IMaterialinputsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Materialinput_usecases;
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
@WebServlet(name="Materialinput_update", urlPatterns={"/eve.Materialinput_update"})
public class Materialinput_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Materialinput_usecases materialinputusecases = new Materialinput_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IMaterialinputOperation.UPDATE_MATERIALINPUT:
                    update_materialinput(materialinputusecases);
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

    private void update_materialinput(Materialinput_usecases materialinputusecases) throws CustomException {
        IMaterialinput materialinput = (IMaterialinput)parser.getJavaObject("materialinput");
        materialinputusecases.secureupdateMaterialinput(materialinput);
    }
    
    @Override
    public String getServletInfo() {
        return "materialinput_insert";
    }

}

