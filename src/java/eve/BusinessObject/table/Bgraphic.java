/*
 * Bgraphic.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.5.2021 19:33
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONGraphic;
import eve.data.ProjectConstants;
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
public abstract class Bgraphic extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Graphic as default Entity
     */
    public Bgraphic() {
        super(new SQLMapper_pgsql(connectionpool, "Graphic"), new Graphic());
    }

    /**
     * Constructor, sets Graphic as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bgraphic(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Graphic());
    }

    /**
     * Map ResultSet Field values to Graphic
     * @param dbresult: Database ResultSet
     */
    public Graphic mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        GraphicPK graphicPK = null;
        Graphic graphic;
        if(dbresult==null) {
            graphic = new Graphic(graphicPK);
        } else {
            try {
                graphicPK = new GraphicPK(dbresult.getLong("id"));
                graphic = new Graphic(graphicPK);
                graphic.initCollision_file(dbresult.getString("collision_file"));
                graphic.initGraphic_file(dbresult.getString("graphic_file"));
                graphic.initIcon_folder(dbresult.getString("icon_folder"));
                graphic.initSof_dna(dbresult.getString("sof_dna"));
                graphic.initSof_fation_name(dbresult.getString("sof_fation_name"));
                graphic.initSof_hull_name(dbresult.getString("sof_hull_name"));
                graphic.initSof_race_name(dbresult.getString("sof_race_name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, graphic);
        return graphic;
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
    public ArrayList getGraphics() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Graphic.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Graphic for primary key
     * @param graphicPK: Graphic primary key
     * @return Graphic object
     * @throws DBException
     */
    public Graphic getGraphic(IGraphicPK graphicPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Graphic)super.getEntity((GraphicPK)graphicPK);
        } else return null;
    }

    public ArrayList searchgraphics(IGraphicsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchgraphics(IGraphicsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search graphic in database for graphicPK:
     * @param graphicPK: Graphic Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getGraphicExists(IGraphicPK graphicPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((GraphicPK)graphicPK);
        } else return false;
    }

    /**
     * try to insert Graphic in database
     * @param film: Graphic object
     * @throws DBException
     */
    public void insertGraphic(IGraphic graphic) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(graphic);
        }
    }

    /**
     * check if GraphicPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Graphic object
     * @throws DBException
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
     * @param film: Graphic object
     * @throws DBException
     */
    public void updateGraphic(IGraphic graphic) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(graphic);
        }
    }

    /**
     * try to delete Graphic in database
     * @param film: Graphic object
     * @throws DBException
     */
    public void deleteGraphic(IGraphic graphic) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteGraphic(graphic.getOwnerobject(), graphic.getPrimaryKey());
            super.deleteEntity(graphic);
        }
    }

    /**
     * check data rules in Graphic, throw DataException with customized message if rules do not apply
     * @param film: Graphic object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IGraphic graphic) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(graphic.getCollision_file()!=null && graphic.getCollision_file().length()>IGraphic.SIZE_COLLISION_FILE) {
            message.append("Collision_file is langer dan toegestaan. Max aantal karakters: " + IGraphic.SIZE_COLLISION_FILE + "\n");
        }
        if(graphic.getGraphic_file()!=null && graphic.getGraphic_file().length()>IGraphic.SIZE_GRAPHIC_FILE) {
            message.append("Graphic_file is langer dan toegestaan. Max aantal karakters: " + IGraphic.SIZE_GRAPHIC_FILE + "\n");
        }
        if(graphic.getIcon_folder()!=null && graphic.getIcon_folder().length()>IGraphic.SIZE_ICON_FOLDER) {
            message.append("Icon_folder is langer dan toegestaan. Max aantal karakters: " + IGraphic.SIZE_ICON_FOLDER + "\n");
        }
        if(graphic.getSof_dna()!=null && graphic.getSof_dna().length()>IGraphic.SIZE_SOF_DNA) {
            message.append("Sof_dna is langer dan toegestaan. Max aantal karakters: " + IGraphic.SIZE_SOF_DNA + "\n");
        }
        if(graphic.getSof_fation_name()!=null && graphic.getSof_fation_name().length()>IGraphic.SIZE_SOF_FATION_NAME) {
            message.append("Sof_fation_name is langer dan toegestaan. Max aantal karakters: " + IGraphic.SIZE_SOF_FATION_NAME + "\n");
        }
        if(graphic.getSof_hull_name()!=null && graphic.getSof_hull_name().length()>IGraphic.SIZE_SOF_HULL_NAME) {
            message.append("Sof_hull_name is langer dan toegestaan. Max aantal karakters: " + IGraphic.SIZE_SOF_HULL_NAME + "\n");
        }
        if(graphic.getSof_race_name()!=null && graphic.getSof_race_name().length()>IGraphic.SIZE_SOF_RACE_NAME) {
            message.append("Sof_race_name is langer dan toegestaan. Max aantal karakters: " + IGraphic.SIZE_SOF_RACE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where graphicPK is used in a primary key
     * @param graphicPK: Graphic primary key
     */
    public void cascadedeleteGraphic(String senderobject, IGraphicPK graphicPK) {
    }


    /**
     * get all Graphic objects for sqlparameters
     * @return ArrayList of Graphic objects
     * @throws DBException
     */
    public ArrayList getGraphics(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Graphic.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Graphic objects for sqlparameters
     * @throws DBException
     */
    public void delGraphic(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Graphic.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
