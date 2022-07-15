/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.materialinput;

import general.exception.*;
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
@WebServlet(name="Materialinput_select", urlPatterns={"/eve.Materialinput_select"})
public class Materialinput_select extends SecurityDataServlet {
   
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
                case IMaterialinputOperation.SELECT_ALL:
                    dataobject = materialinputusecases.get_all();
                    break;
                case IMaterialinputOperation.SELECT_MATERIALINPUT:
                    dataobject = get_materialinput_with_primarykey(materialinputusecases);
                    break;
                case IMaterialinputOperation.SELECT_Evetype:
                    dataobject = get_materialinput_with_foreignkey_evetype(materialinputusecases);
                    break;
                case IMaterialinputOperation.SELECT_SEARCH:
                    dataobject = search_materialinput(materialinputusecases);
                    break;
                case IMaterialinputOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_materialinput_count(materialinputusecases);
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

    private Object get_materialinput_with_primarykey(Materialinput_usecases materialinputusecases) throws DBException {
        IMaterialinputPK materialinputPK = (IMaterialinputPK)parser.getJavaObject("materialinputpk");
        return materialinputusecases.get_materialinput_by_primarykey(materialinputPK);
    }

    private Object get_materialinput_with_foreignkey_evetype(Materialinput_usecases materialinputusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return materialinputusecases.get_materialinput_with_foreignkey_evetype(evetypePK);
    }
    
    private Object search_materialinput(Materialinput_usecases materialinputusecases) throws CustomException {
        IMaterialinputsearch search = (IMaterialinputsearch)parser.getJavaObject("search");
        return materialinputusecases.search_materialinput(search);
    }
    
    private Object search_materialinput_count(Materialinput_usecases materialinputusecases) throws CustomException {
        IMaterialinputsearch materialinputsearch = (IMaterialinputsearch)parser.getJavaObject("search");
        return materialinputusecases.search_materialinput_count(materialinputsearch);
    }

    @Override
    public String getServletInfo() {
        return "materialinput_select";
    }

}

