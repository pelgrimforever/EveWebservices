/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.routetype;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRoutetype;
import eve.interfaces.servlet.IRoutetypeOperation;
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Routetype_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Routetype_select", urlPatterns={"/eve.Routetype_select"})
public class Routetype_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Routetype_usecases routetypeusecases = new Routetype_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IRoutetypeOperation.SELECT_ALL:
                    dataobject = routetypeusecases.get_all();
                    break;
                case IRoutetypeOperation.SELECT_ROUTETYPE:
                    dataobject = get_routetype_with_primarykey(routetypeusecases);
                    break;
                case IRoutetypeOperation.SELECT_Security_island:
                    dataobject = get_routetype_with_foreignkey_security_island(routetypeusecases);
                    break;
                case IRoutetypeOperation.SELECT_SEARCH:
                    dataobject = search_routetype(routetypeusecases);
                    break;
                case IRoutetypeOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_routetype_count(routetypeusecases);
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

    private Object get_routetype_with_primarykey(Routetype_usecases routetypeusecases) throws DBException {
        IRoutetypePK routetypePK = (IRoutetypePK)parser.getJavaObject("routetypepk");
        return routetypeusecases.get_routetype_by_primarykey(routetypePK);
    }

    private Object get_routetype_with_foreignkey_security_island(Routetype_usecases routetypeusecases) throws CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
        return routetypeusecases.get_routetype_with_foreignkey_security_island(security_islandPK);
    }
    
    private Object search_routetype(Routetype_usecases routetypeusecases) throws CustomException {
        IRoutetypesearch search = (IRoutetypesearch)parser.getJavaObject("search");
        return routetypeusecases.search_routetype(search);
    }
    
    private Object search_routetype_count(Routetype_usecases routetypeusecases) throws CustomException {
        IRoutetypesearch routetypesearch = (IRoutetypesearch)parser.getJavaObject("search");
        return routetypeusecases.search_routetype_count(routetypesearch);
    }

    @Override
    public String getServletInfo() {
        return "routetype_select";
    }

}

