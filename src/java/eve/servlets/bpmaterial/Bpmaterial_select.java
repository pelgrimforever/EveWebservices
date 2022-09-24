/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.bpmaterial;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IBpmaterial;
import eve.interfaces.servlet.IBpmaterialOperation;
import eve.interfaces.searchentity.IBpmaterialsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Bpmaterial_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Bpmaterial_select", urlPatterns={"/eve.Bpmaterial_select"})
public class Bpmaterial_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IBpmaterialOperation.SELECT_ALL:
                    dataobject = bpmaterialusecases.get_all();
                    break;
                case IBpmaterialOperation.SELECT_BPMATERIAL:
                    dataobject = get_bpmaterial_with_primarykey(bpmaterialusecases);
                    break;
                case IBpmaterialOperation.SELECT_Evetypebp:
                    dataobject = get_bpmaterial_with_foreignkey_evetypeBp(bpmaterialusecases);
                    break;
                case IBpmaterialOperation.SELECT_Evetypematerial:
                    dataobject = get_bpmaterial_with_foreignkey_evetypeMaterial(bpmaterialusecases);
                    break;
                case IBpmaterialOperation.SELECT_SEARCH:
                    dataobject = search_bpmaterial(bpmaterialusecases);
                    break;
                case IBpmaterialOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_bpmaterial_count(bpmaterialusecases);
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

    private Object get_bpmaterial_with_primarykey(Bpmaterial_usecases bpmaterialusecases) throws DBException {
        IBpmaterialPK bpmaterialPK = (IBpmaterialPK)parser.getJavaObject("bpmaterialpk");
        return bpmaterialusecases.get_bpmaterial_by_primarykey(bpmaterialPK);
    }

    private Object get_bpmaterial_with_foreignkey_evetypeBp(Bpmaterial_usecases bpmaterialusecases) throws CustomException {
        IEvetypePK evetypeBpPK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return bpmaterialusecases.get_bpmaterial_with_foreignkey_evetypeBp(evetypeBpPK);
    }
    
    private Object get_bpmaterial_with_foreignkey_evetypeMaterial(Bpmaterial_usecases bpmaterialusecases) throws CustomException {
        IEvetypePK evetypeMaterialPK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return bpmaterialusecases.get_bpmaterial_with_foreignkey_evetypeMaterial(evetypeMaterialPK);
    }
    
    private Object search_bpmaterial(Bpmaterial_usecases bpmaterialusecases) throws CustomException {
        IBpmaterialsearch search = (IBpmaterialsearch)parser.getJavaObject("search");
        return bpmaterialusecases.search_bpmaterial(search);
    }
    
    private Object search_bpmaterial_count(Bpmaterial_usecases bpmaterialusecases) throws CustomException {
        IBpmaterialsearch bpmaterialsearch = (IBpmaterialsearch)parser.getJavaObject("search");
        return bpmaterialusecases.search_bpmaterial_count(bpmaterialsearch);
    }

    @Override
    public String getServletInfo() {
        return "bpmaterial_select";
    }

}

