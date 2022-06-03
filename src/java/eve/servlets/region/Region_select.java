/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.region;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRegion;
import eve.interfaces.servlet.IRegionOperation;
import eve.interfaces.searchentity.IRegionsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Region_usecases;
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
@WebServlet(name="Region_select", urlPatterns={"/eve.Region_select"})
public class Region_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Region_usecases regionusecases = new Region_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IRegionOperation.SELECT_ALL:
                    dataobject = regionusecases.get_all();
                    break;
                case IRegionOperation.SELECT_REGION:
                    dataobject = get_region_with_primarykey(regionusecases);
                    break;
                case IRegionOperation.SELECT_Order_history_month:
                    dataobject = get_region_with_externalforeignkey_order_history_month(regionusecases);
                    break;
                case IRegionOperation.SELECT_Order_history:
                    dataobject = get_region_with_externalforeignkey_order_history(regionusecases);
                    break;
                case IRegionOperation.SELECT_Region_neighbourregion:
                    dataobject = get_region_with_externalforeignkey_region_neighbourRegion(regionusecases);
                    break;
                case IRegionOperation.SELECT_Region_neighbourneighbour:
                    dataobject = get_region_with_externalforeignkey_region_neighbourNeighbour(regionusecases);
                    break;
                case IRegionOperation.SELECT_SEARCH:
                    dataobject = search_region(regionusecases);
                    break;
                case IRegionOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_region_count(regionusecases);
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

    private Object get_region_with_primarykey(Region_usecases regionusecases) throws DBException {
        IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
        return regionusecases.get_region_by_primarykey(regionPK);
    }

    private Object get_region_with_externalforeignkey_order_history_month(Region_usecases regionusecases) throws CustomException {
        IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)parser.getJavaObject("order_history_monthpk");
        return regionusecases.get_region_with_externalforeignkey_order_history_month(order_history_monthPK);
    }
    
    private Object get_region_with_externalforeignkey_order_history(Region_usecases regionusecases) throws CustomException {
        IOrder_historyPK order_historyPK = (IOrder_historyPK)parser.getJavaObject("order_historypk");
        return regionusecases.get_region_with_externalforeignkey_order_history(order_historyPK);
    }
    
    private Object get_region_with_externalforeignkey_region_neighbourRegion(Region_usecases regionusecases) throws CustomException {
        IRegion_neighbourPK region_neighbourRegionPK = (IRegion_neighbourPK)parser.getJavaObject("region_neighbourpk");
        return regionusecases.get_region_with_externalforeignkey_region_neighbourRegion(region_neighbourRegionPK);
    }
    
    private Object get_region_with_externalforeignkey_region_neighbourNeighbour(Region_usecases regionusecases) throws CustomException {
        IRegion_neighbourPK region_neighbourNeighbourPK = (IRegion_neighbourPK)parser.getJavaObject("region_neighbourpk");
        return regionusecases.get_region_with_externalforeignkey_region_neighbourNeighbour(region_neighbourNeighbourPK);
    }
    
    private Object search_region(Region_usecases regionusecases) throws CustomException {
        IRegionsearch search = (IRegionsearch)parser.getJavaObject("search");
        return regionusecases.search_region(search);
    }
    
    private Object search_region_count(Region_usecases regionusecases) throws CustomException {
        IRegionsearch regionsearch = (IRegionsearch)parser.getJavaObject("search");
        return regionusecases.search_region_count(regionsearch);
    }

    @Override
    public String getServletInfo() {
        return "region_select";
    }

}

