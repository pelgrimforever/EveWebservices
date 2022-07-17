/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
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
@WebServlet(name="Materialinput_delete", urlPatterns={"/eve.Materialinput_delete"})
public class Materialinput_delete extends SecurityDataServlet {
   
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
                case IMaterialinputOperation.DELETE_MATERIALINPUT:
                    delete_materialinput(materialinputusecases);
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

    private void delete_materialinput(Materialinput_usecases materialinputusecases) throws CustomException {
        IMaterialinput materialinput = (IMaterialinput)parser.getJavaObject("materialinput");
        materialinputusecases.deleteMaterialinput(materialinput);
    }
    
    @Override
    public String getServletInfo() {
        return "materialinput_insert";
    }

}

