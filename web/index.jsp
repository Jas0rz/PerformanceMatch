<%-- 
    Document   : index
    Created on : 27-May-2013, 11:54:28 AM
    Author     : Jas0rz
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOUSE OF LIES</title>
    </head>
    <body>
        <h1>Chris has built one.</h1>
        <%= test() %>
    </body>
</html>
<%! public String test() {

        
    
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/PerformanceMatch199";
        String user = "pmadmin";
        String password = "yoloswag420";
        
        String result = "";
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException e) {
            result += e + "<br>\n";
            
        }

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SHOW TABLES");

            while (rs.next()) {
                result += rs.next() + "<br>\n";
            }

        } catch (SQLException ex) {
            result += "Nope: " + ex;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                result += "Nope: " + ex;
            }
        }
        
        return result;
    }

%>