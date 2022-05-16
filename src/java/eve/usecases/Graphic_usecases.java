/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Graphic;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Graphic_usecases {

    private boolean loggedin = false;
    private BLgraphic blgraphic = new BLgraphic();
    
    public Graphic_usecases() {
        this(false);
    }
    
    public Graphic_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blgraphic.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blgraphic.count();
    }
    
    public ArrayList<Graphic> get_all() throws DBException {
        return blgraphic.getGraphics();
    }
    
    public boolean getGraphicExists(IGraphicPK graphicPK) throws DBException {
        return blgraphic.getEntityExists(graphicPK);
    }
    
    public Graphic get_graphic_by_primarykey(IGraphicPK graphicPK) throws DBException {
        return blgraphic.getGraphic(graphicPK);
    }

    public ArrayList<Graphic> search_graphic(IGraphicsearch graphicsearch) throws ParseException, CustomException {
        return blgraphic.search(graphicsearch);
    }
    
    public long search_graphic_count(IGraphicsearch graphicsearch) throws ParseException, CustomException {
        return blgraphic.searchcount(graphicsearch);
    }

    public void secureinsertGraphic(IGraphic graphic) throws DBException, DataException {
        blgraphic.secureinsertGraphic(graphic);
    }

    public void secureupdateGraphic(IGraphic graphic) throws DBException, DataException {
        blgraphic.secureupdateGraphic(graphic);
    }

    public void securedeleteGraphic(IGraphic graphic) throws DBException, DataException {
        blgraphic.securedeleteGraphic(graphic);
    }
}

