/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMwishlist;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IWishlistsearch;
import eve.logicentity.Wishlist;

public abstract class Bwishlist extends TableBusinessrules {

    public Bwishlist(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMwishlist()));
    }

    public Bwishlist(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMwishlist()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IWishlist newWishlist() {
    	return new Wishlist();
    }
    
    public IWishlist newWishlist(long evetype, java.lang.String username) {
        return new Wishlist(evetype, username);
    }

    public IWishlist newWishlist(IWishlistPK wishlistPK) {
        return new Wishlist((WishlistPK)wishlistPK);
    }

    public IWishlistPK newWishlistPK() {
        return new WishlistPK();
    }

    public IWishlistPK newWishlistPK(long evetype, java.lang.String username) {
        return new WishlistPK(evetype, username);
    }

    public ArrayList<Wishlist> getWishlists() throws DBException {
        return (ArrayList<Wishlist>)tableio.getEntities(EMwishlist.SQLSelectAll);
    }

    public Wishlist getWishlist(IWishlistPK wishlistPK) throws DBException {
        return (Wishlist)tableio.getEntity((WishlistPK)wishlistPK);
    }

    public ArrayList<Wishlist> searchwishlists(IWishlistsearch search) throws DBException {
        return (ArrayList<Wishlist>)tableio.search(search);
    }

    public ArrayList<Wishlist> searchwishlists(IWishlistsearch search, String orderby) throws DBException {
        return (ArrayList<Wishlist>)tableio.search(search, orderby);
    }

    public boolean getWishlistExists(IWishlistPK wishlistPK) throws DBException {
        return tableio.getEntityExists((WishlistPK)wishlistPK);
    }

    public Wishlist getEntity(String sql) throws DBException {
        return (Wishlist)tableio.getEntity(sql);
    }
    
    public Wishlist getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Wishlist)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Wishlist> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Wishlist> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Wishlist> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Wishlist> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertWishlist(SQLTqueue transactionqueue, IWishlist wishlist) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, wishlist);
    }

    public void insertupdateWishlist(SQLTqueue transactionqueue, IWishlist wishlist) throws DBException, DataException {
    	checkDATA(wishlist);
        if(this.getWishlistExists(wishlist.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, wishlist);
        } else {
            tableio.insertEntity(transactionqueue, wishlist);
        }
    }

    public void updateWishlist(SQLTqueue transactionqueue, IWishlist wishlist) throws DBException, DataException {
    	checkDATA(wishlist);
        tableio.updateEntity(transactionqueue, wishlist);
    }

    public void deleteWishlist(SQLTqueue transactionqueue, IWishlist wishlist) throws DBException {
        cascadedeleteWishlist(transactionqueue, wishlist.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, wishlist);
    }

    private void checkDATA(IWishlist wishlist) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Wishlist.Evetype - Evetype.Id
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteWishlist(SQLTqueue transactionqueue, IWishlistPK wishlistPK) {
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMwishlist.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Wishlist> getWishlists4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMwishlist.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }

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
        return (ArrayList<Wishlist>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delWishlist(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
