/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMgraphic;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IGraphicsearch;
import eve.logicentity.Graphic;

/**
 * @author Franky Laseure
 */
public abstract class Bgraphic extends TableBusinessrules {

    public Bgraphic(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMgraphic()));
    }

    public Bgraphic(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMgraphic()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IGraphic newGraphic() {
    	return new Graphic();
    }
    
    public IGraphic newGraphic(long id) {
        return new Graphic(id);
    }

    public IGraphic newGraphic(IGraphicPK graphicPK) {
        return new Graphic((GraphicPK)graphicPK);
    }

    public IGraphicPK newGraphicPK() {
        return new GraphicPK();
    }

    public IGraphicPK newGraphicPK(long id) {
        return new GraphicPK(id);
    }

    public ArrayList<Graphic> getGraphics() throws DBException {
        return (ArrayList<Graphic>)tableio.getEntities(EMgraphic.SQLSelectAll);
    }

    public Graphic getGraphic(IGraphicPK graphicPK) throws DBException {
        return (Graphic)tableio.getEntity((GraphicPK)graphicPK);
    }

    public ArrayList<Graphic> searchgraphics(IGraphicsearch search) throws DBException {
        return (ArrayList<Graphic>)tableio.search(search);
    }

    public ArrayList<Graphic> searchgraphics(IGraphicsearch search, String orderby) throws DBException {
        return (ArrayList<Graphic>)tableio.search(search, orderby);
    }

    public boolean getGraphicExists(IGraphicPK graphicPK) throws DBException {
        return tableio.getEntityExists((GraphicPK)graphicPK);
    }

    public Graphic getEntity(String sql) throws DBException {
        return (Graphic)tableio.getEntity(sql);
    }
    
    public Graphic getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Graphic)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Graphic> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Graphic> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Graphic> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Graphic> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertGraphic(SQLTqueue transactionqueue, IGraphic graphic) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, graphic);
    }

    public void insertupdateGraphic(SQLTqueue transactionqueue, IGraphic graphic) throws DBException, DataException {
    	checkDATA(graphic);
        if(this.getGraphicExists(graphic.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, graphic);
        } else {
            tableio.insertEntity(transactionqueue, graphic);
        }
    }

    public void updateGraphic(SQLTqueue transactionqueue, IGraphic graphic) throws DBException, DataException {
    	checkDATA(graphic);
        tableio.updateEntity(transactionqueue, graphic);
    }

    public void deleteGraphic(SQLTqueue transactionqueue, IGraphic graphic) throws DBException {
        cascadedeleteGraphic(transactionqueue, graphic.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, graphic);
    }

    private void checkDATA(IGraphic graphic) throws DataException, DBException {
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
    public void cascadedeleteGraphic(SQLTqueue transactionqueue, IGraphicPK graphicPK) {
    }


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
        return (ArrayList<Graphic>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delGraphic(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
