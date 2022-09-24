/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Graphic;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Graphic_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLgraphic blgraphic = new BLgraphic(sqlreader);
    
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
        return blgraphic.getGraphicExists(graphicPK);
    }
    
    public Graphic get_graphic_by_primarykey(IGraphicPK graphicPK) throws DBException {
        return blgraphic.getGraphic(graphicPK);
    }

    public ArrayList<Graphic> search_graphic(IGraphicsearch graphicsearch) throws CustomException {
        return blgraphic.search(graphicsearch);
    }
    
    public long search_graphic_count(IGraphicsearch graphicsearch) throws CustomException {
        return blgraphic.searchcount(graphicsearch);
    }

    public void insertGraphic(IGraphic graphic) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blgraphic.insertGraphic(tq, graphic);
        sqlwriter.Commit2DB(tq);
    }

    public void updateGraphic(IGraphic graphic) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blgraphic.updateGraphic(tq, graphic);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteGraphic(IGraphic graphic) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blgraphic.deleteGraphic(tq, graphic);
        sqlwriter.Commit2DB(tq);
    }

}

