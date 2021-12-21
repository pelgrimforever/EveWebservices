/*
 * Bwishlist.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 17:36
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
import eve.conversion.json.JSONWishlist;
import eve.conversion.entity.EMwishlist;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IWishlistsearch;
import eve.logicentity.Wishlist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bwishlist
 *
 * Superclass for manipulating data- and database objects
 * for Entity Wishlist and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bwishlist extends BLtable {

    /**
     * Constructor, sets Wishlist as default Entity
     */
    public Bwishlist() {
        super(new Wishlist(), new EMwishlist());
    }

    /**
     * Constructor, sets Wishlist as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bwishlist(BLtable transactionobject) {
        super(transactionobject, new Wishlist(), new EMwishlist());
    }

    /**
     * create new empty Wishlist object
     * @return empty IWishlist
     */
    public IWishlist newWishlist() {
    	return new Wishlist();
    }
    
    /**
     * create new empty Wishlist object
     * create new primary key with given parameters
     * @param evetype primary key field
     * @param username primary key field
     * @return IWishlist with primary key
     */
    public IWishlist newWishlist(long evetype, java.lang.String username) {
        return new Wishlist(evetype, username);
    }

    /**
     * create new empty Wishlist object with given primary key
     * @param wishlistPK: primary key for Wishlist
     * @return IWishlist with primary key
     */
    public IWishlist newWishlist(IWishlistPK wishlistPK) {
        return new Wishlist((WishlistPK)wishlistPK);
    }

    /**
     * create new empty primary key
     * @return empty WishlistPK
     */
    public IWishlistPK newWishlistPK() {
        return new WishlistPK();
    }

    /**
     * create new primary key with given parameters
     * @param evetype primary key field
     * @param username primary key field
     * @return new IWishlistPK
     */
    public IWishlistPK newWishlistPK(long evetype, java.lang.String username) {
        return new WishlistPK(evetype, username);
    }

    /**
     * get all Wishlist objects from database
     * @return ArrayList of Wishlist objects
     * @throws DBException
     */
    public ArrayList<Wishlist> getWishlists() throws DBException {
        return (ArrayList<Wishlist>)super.getEntities(EMwishlist.SQLSelectAll);
    }

    /**
     * search Wishlist for primary key
     * @param wishlistPK: Wishlist primary key
     * @return Wishlist object
     * @throws DBException
     */
    public Wishlist getWishlist(IWishlistPK wishlistPK) throws DBException {
        return (Wishlist)super.getEntity((WishlistPK)wishlistPK);
    }

    /**
     * search wishlist with IWishlistsearch parameters
     * @param search IWishlistsearch
     * @return ArrayList of Wishlist
     * @throws DBException 
     */
    public ArrayList<Wishlist> searchwishlists(IWishlistsearch search) throws DBException {
        return (ArrayList<Wishlist>)this.search(search);
    }

    /**
     * search wishlist with IWishlistsearch parameters, order by orderby sql clause
     * @param search IWishlistsearch
     * @param orderby sql order by string
     * @return ArrayList of Wishlist
     * @throws DBException 
     */
    public ArrayList<Wishlist> searchwishlists(IWishlistsearch search, String orderby) throws DBException {
        return (ArrayList<Wishlist>)this.search(search, orderby);
    }

    /**
     * Search wishlist in database for wishlistPK:
     * @param wishlistPK: Wishlist Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getWishlistExists(IWishlistPK wishlistPK) throws DBException {
        return super.getEntityExists((WishlistPK)wishlistPK);
    }

    /**
     * try to insert Wishlist in database
     * @param wishlist Wishlist object
     * @throws DBException
     * @throws DataException
     */
    public void insertWishlist(IWishlist wishlist) throws DBException, DataException {
        super.insertEntity(wishlist);
    }

    /**
     * check if WishlistPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param wishlist Wishlist object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateWishlist(IWishlist wishlist) throws DBException, DataException {
        if(this.getWishlistExists(wishlist.getPrimaryKey())) {
            super.updateEntity(wishlist);
        } else {
            super.insertEntity(wishlist);
        }
    }

    /**
     * try to update Wishlist in database
     * @param wishlist Wishlist object
     * @throws DBException
     * @throws DataException
     */
    public void updateWishlist(IWishlist wishlist) throws DBException, DataException {
        super.updateEntity(wishlist);
    }

    /**
     * try to delete Wishlist in database
     * @param wishlist Wishlist object
     * @throws DBException
     */
    public void deleteWishlist(IWishlist wishlist) throws DBException {
        cascadedeleteWishlist(wishlist.getPrimaryKey());
        super.deleteEntity(wishlist);
    }

    /**
     * check data rules in Wishlist, throw DataException with customized message if rules do not apply
     * @param wishlist Wishlist object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IWishlist wishlist) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Wishlist.Evetype - Evetype.Id
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where wishlistPK is used in a primary key
     * @param wishlistPK: Wishlist primary key
     */
    public void cascadedeleteWishlist(IWishlistPK wishlistPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Wishlist Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMwishlist.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Wishlist Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Wishlist> getWishlists4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMwishlist.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * get all Wishlist objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Wishlist objects
     * @throws DBException
     */
    public ArrayList<Wishlist> getWishlists(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMwishlist.SQLSelect);
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
        return (ArrayList<Wishlist>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Wishlist objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delWishlist(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Wishlist.table);
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
