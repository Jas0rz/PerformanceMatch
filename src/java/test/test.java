package test;

/*
 *
 * This is simply to test the servlet functionality, but could be re-used as a template.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Chris Wallace <chris at devocean.com>
 */
public class test extends HttpServlet {
	
	public String doQuery() {

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

	/**
	 * Processes requests for both HTTP
	 * <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet test</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet test at " + request.getContextPath() + "</h1>");
			String result = doQuery();
			out.println(result);
			out.println("</body>");
			out.println("</html>");
		} finally {			
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
