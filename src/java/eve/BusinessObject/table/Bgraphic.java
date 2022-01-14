/*
 * Bgraphic.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONGraphic;
import eve.conversion.entity.EMgraphic;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IGraphicsearch;
import eve.logicentity.Graphic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bgraphic
 *
 * Superclass for manipulating data- and database objects
 * for Entity Graphic and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bgraphic extends BLtable {

    /**
     * Constructor, sets Graphic as default Entity
     */
    public Bgraphic() {
        super(new Graphic(), new EMgraphic());
    }

    /**
     * Constructor, sets Graphic as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bgraphic(BLtable transactionobject) {
        super(transactionobject, new Graphic(), new EMgraphic());
    }

    /**
     * create new empty Graphic object
     * @return empty IGraphic
     */
    public IGraphic newGraphic() {
    	return new Graphic();
    }
    
    /**
     * create new empty Graphic object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IGraphic with primary key
     */
    public IGraphic newGraphic(long id) {
        return new Graphic(id);
    }

    /**
     * create new empty Graphic object with given primary key
     * @param graphicPK: primary key for Graphic
     * @return IGraphic with primary key
     */
    public IGraphic newGraphic(IGraphicPK graphicPK) {
        return new Graphic((GraphicPK)graphicPK);
    }

    /**
     * create new empty primary key
     * @return empty GraphicPK
     */
    public IGraphicPK newGraphicPK() {
        return new GraphicPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IGraphicPK
     */
    public IGraphicPK newGraphicPK(long id) {
        return new GraphicPK(id);
    }

    /**
     * get all Graphic objects from database
     * @return ArrayList of Graphic objects
     * @throws DBException
     */
    public ArrayList<Graphic> getGraphics() throws DBException {
        return (ArrayList<Graphic>)super.getEntities(EMgraphic.SQLSelectAll);
    }

    /**
     * search Graphic for primary key
     * @param graphicPK: Graphic primary key
     * @return Graphic object
     * @throws DBException
     */
    public Graphic getGraphic(IGraphicPK graphicPK) throws DBException {
        return (Graphic)super.getEntity((GraphicPK)graphicPK);
    }

    /**
     * search graphic with IGraphicsearch parameters
     * @param search IGraphicsearch
     * @return ArrayList of Graphic
     * @throws DBException 
     */
    public ArrayList<Graphic> searchgraphics(IGraphicsearch search) throws DBException {
        return (ArrayList<Graphic>)this.search(search);
    }

    /**
     * search graphic with IGraphicsearch parameters, order by orderby sql clause
     * @param search IGraphicsearch
     * @param orderby sql order by string
     * @return ArrayList of Graphic
     * @throws DBException 
     */
    public ArrayList<Graphic> searchgraphics(IGraphicsearch search, String orderby) throws DBException {
        return (ArrayList<Graphic>)this.search(search, orderby);
    }

    /**
     * Search graphic in database for graphicPK:
     * @param graphicPK: Graphic Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getGraphicExists(IGraphicPK graphicPK) throws DBException {
        return super.getEntityExists((GraphicPK)graphicPK);
    }

    /**
     * try to insert Graphic in database
     * @param graphic Graphic object
     * @throws DBException
     * @throws DataException
     */
    public void insertGraphic(IGraphic graphic) throws DBException, DataException {
        super.insertEntity(graphic);
    }

    /**
     * check if GraphicPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param graphic Graphic object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateGraphic(IGraphic graphic) throws DBException, DataException {
        if(this.getGraphicExists(graphic.getPrimaryKey())) {
            super.updateEntity(graphic);
        } else {
            super.insertEntity(graphic);
        }
    }

    /**
     * try to update Graphic in database
     * @param graphic Graphic object
     * @throws DBException
     * @throws DataException
     */
    public void updateGraphic(IGraphic graphic) throws DBException, DataException {
        super.updateEntity(graphic);
    }

    /**
     * try to delete Graphic in database
     * @param graphic Graphic object
     * @throws DBException
     */
    public void deleteGraphic(IGraphic graphic) throws DBException {
        cascadedeleteGraphic(graphic.getPrimaryKey());
        super.deleteEntity(graphic);
    }

    /**
     * check data rules in Graphic, throw DataException with customized message if rules do not apply
     * @param graphic Graphic object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IGraphic graphic) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(graphic.getCollision_file()!=null && graphic.getCollision_file().length()>IGraphic.SIZE_COLLISION_FILE) {
            message.append("Collision_file is langer dan toegestaan. Max aantal karakters: ").append(IGraphic.SIZE_COLLISION_FILE).append("\n");
        }
        if(graphic.getGraphic_file()!=null && graphic.getGraphic_file().length()>IGraphic.SIZE_GRAPHIC_FILE) {
            message.append("Graphic_file is langer dan toegestaan. Max aantal karakters: ").append(IGraphic.SIZE_GRAPHIC_FILE).append("\n");
        }
        if(graphic.getIcon_folder()!=null && graphic.getIcon_folder().length()>IGraphic.SIZE_ICON_FOLDER) {
            message.append("Icon_folder is langer dan toegestaan. Max aantal karakters: ").append(IGraphic.SIZE_ICON_FOLDER).append("\n");
        }
        if(graphic.getSof_dna()!=null && graphic.getSof_dna().length()>IGraphic.SIZE_SOF_DNA) {
            message.append("Sof_dna is langer dan toegestaan. Max aantal karakters: ").append(IGraphic.SIZE_SOF_DNA).append("\n");
        }
        if(graphic.getSof_fation_name()!=null && graphic.getSof_fation_name().length()>IGraphic.SIZE_SOF_FATION_NAME) {
            message.append("Sof_fation_name is langer dan toegestaan. Max aantal karakters: ").append(IGraphic.SIZE_SOF_FATION_NAME).append("\n");
        }
        if(graphic.getSof_hull_name()!=null && graphic.getSof_hull_name().length()>IGraphic.SIZE_SOF_HULL_NAME) {
            message.append("Sof_hull_name is langer dan toegestaan. Max aantal karakters: ").append(IGraphic.SIZE_SOF_HULL_NAME).append("\n");
        }
        if(graphic.getSof_race_name()!=null && graphic.getSof_race_name().length()>IGraphic.SIZE_SOF_RACE_NAME) {
            message.append("Sof_race_name is langer dan toegestaan. Max aantal karakters: ").append(IGraphic.SIZE_SOF_RACE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where graphicPK is used in a primary key
     * @param graphicPK: Graphic primary key
     */
    public void cascadedeleteGraphic(IGraphicPK graphicPK) {
    }


    /**
     * get all Graphic objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Graphic objects
     * @throws DBException
     */
    public ArrayList<Graphic> getGraphics(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMgraphic.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Graphic>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Graphic objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delGraphic(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Graphic.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
