/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2021 17:46
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ICategory;
import eve.logicentity.Category;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Bcategory;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class BLcategory extends Bcategory {
//Metacoder: NO AUTHOMATIC UPDATE

    //categories
    public static final long MATERIAL = 4;
    public static final long SHIP = 6;
    public static final long MODULE = 7;
    public static final long CHARGE = 8;
    public static final long BLUEPRINT = 9;
    public static final long COMMODITY = 17;
    public static final long DRONE = 18;
    public static final long DEPLOYABLE = 22;
    public static final long PLANETARYCOMMODITY = 43;
	
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLcategory(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLcategory(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Category updateCategory(SQLTqueue transactionqueue, JSONObject jsoncategorydetails) throws DBException, DataException {
        Category category = new Category(JSONConversion.getLong(jsoncategorydetails, "category_id"));
        category.setName(JSONConversion.getString(jsoncategorydetails, "name"));
        category.setPublished(JSONConversion.getboolean(jsoncategorydetails, "published"));
        insertupdateCategory(transactionqueue, category);
        return category;
    }

}
