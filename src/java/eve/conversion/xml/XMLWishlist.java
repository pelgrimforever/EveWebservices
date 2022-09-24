/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.xml;

import XML.XMLElement;
import java.io.IOException;
import object.Objectoperation;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import eve.entity.pk.WishlistPK;
import eve.interfaces.entity.pk.IWishlistPK;
import eve.logicentity.Wishlist;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLWishlist {
    
    public static void addXML(Element PK, IWishlistPK wishlistPK) {
        PK.addContent(XMLElement.newContent("evetype", wishlistPK.getEvetype()));
        PK.addContent(XMLElement.newContent("username", wishlistPK.getUsername()));
    }

    public static void addXML(Element WishlistXML, Wishlist wishlist) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, wishlist.getPrimaryKey());
        WishlistXML.addContent(PK);
        WishlistXML.addContent(XMLElement.newContent("maxprice", wishlist.getMaxprice()));
    }
}

