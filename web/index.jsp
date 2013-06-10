<%-- 
    Document   : index
    Created on : 2-Jun-2013, 5:08:39 PM
    Author     : Chris Wallace <chris at devocean.com>
--%>

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/></h1>

			<%= test()%>

		</body>
	</html>

	<%! public String test() {

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			String url = "jdbc:mysql://204.174.60.67:3306/PerformanceMatch199";
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
				rs = st.executeQuery("Select * from cpu");

				ResultSetMetaData rsmd = rs.getMetaData();
				int numColumns = rsmd.getColumnCount();

				while (rs.next()) {
					for (int i = 1; i <= numColumns; i++) {
						result += rs.getString(i) + "<br>\n";
					}
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

</f:view>
