/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets;

import data.interfaces.db.Filedata;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class downloadfile extends javax.servlet.http.HttpServlet implements SingleThreadModel {

    public downloadfile() {
            super();
    }

    public void destroy() {
            super.destroy();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Filedata filedata = (Filedata)request.getAttribute("filedata");
        ServletOutputStream outputstream = response.getOutputStream();
        response.setContentType("");
        outputstream.write(filedata.getBinarydata(), 0, filedata.getBinarydata().length);
        outputstream.flush();
        outputstream.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
