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
import eve.logicentity.Typegroup;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Typegroup_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLtypegroup bltypegroup = new BLtypegroup(sqlreader);
    
    public Typegroup_usecases() {
        this(false);
    }
    
    public Typegroup_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bltypegroup.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return bltypegroup.count();
    }
    
    public ArrayList<Typegroup> get_all() throws DBException {
        return bltypegroup.getTypegroups();
    }
    
    public boolean getTypegroupExists(ITypegroupPK typegroupPK) throws DBException {
        return bltypegroup.getTypegroupExists(typegroupPK);
    }
    
    public Typegroup get_typegroup_by_primarykey(ITypegroupPK typegroupPK) throws DBException {
        return bltypegroup.getTypegroup(typegroupPK);
    }

    public ArrayList<Typegroup> get_typegroup_with_foreignkey_category(ICategoryPK categoryPK) throws CustomException {
        return bltypegroup.getTypegroups4category(categoryPK);
    }
    
    public ArrayList<Typegroup> search_typegroup(ITypegroupsearch typegroupsearch) throws CustomException {
        return bltypegroup.search(typegroupsearch);
    }
    
    public long search_typegroup_count(ITypegroupsearch typegroupsearch) throws CustomException {
        return bltypegroup.searchcount(typegroupsearch);
    }

    public void insertTypegroup(ITypegroup typegroup) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltypegroup.insertTypegroup(tq, typegroup);
        sqlwriter.Commit2DB(tq);
    }

    public void updateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltypegroup.updateTypegroup(tq, typegroup);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteTypegroup(ITypegroup typegroup) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltypegroup.deleteTypegroup(tq, typegroup);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Category(ICategoryPK categoryPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltypegroup.delete4category(tq, categoryPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

