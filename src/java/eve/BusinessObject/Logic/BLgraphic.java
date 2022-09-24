/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2021 15:56
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IGraphic;
import eve.logicentity.Graphic;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Bgraphic;
import general.exception.DataException;
import org.json.simple.JSONObject;

public class BLgraphic extends Bgraphic {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLgraphic(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLgraphic(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Graphic updateGraphic(SQLTqueue transactionqueue, JSONObject jsongraphicdetails) throws DBException, DataException {
        Graphic graphic = new Graphic(JSONConversion.getLong(jsongraphicdetails, "graphic_id"));
        if(jsongraphicdetails.containsKey("collision_file")) graphic.setCollision_file(JSONConversion.getString(jsongraphicdetails, "collision_file"));
        if(jsongraphicdetails.containsKey("graphic_file")) graphic.setGraphic_file(JSONConversion.getString(jsongraphicdetails, "graphic_file"));
        if(jsongraphicdetails.containsKey("icon_folder")) graphic.setIcon_folder(JSONConversion.getString(jsongraphicdetails, "icon_folder"));
        if(jsongraphicdetails.containsKey("sof_dna")) graphic.setSof_dna(JSONConversion.getString(jsongraphicdetails, "sof_dna"));
        if(jsongraphicdetails.containsKey("sof_fation_name")) graphic.setSof_fation_name(JSONConversion.getString(jsongraphicdetails, "sof_fation_name"));
        if(jsongraphicdetails.containsKey("sof_hull_name")) graphic.setSof_hull_name(JSONConversion.getString(jsongraphicdetails, "sof_hull_name"));
        if(jsongraphicdetails.containsKey("sof_race_name")) graphic.setSof_race_name(JSONConversion.getString(jsongraphicdetails, "sof_race_name"));
        insertupdateGraphic(transactionqueue, graphic);
        return graphic;
    }

}
