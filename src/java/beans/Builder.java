/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import components.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jas0rz
 */
public class Builder {
    public ArrayList<CPU>           cpuList          = new ArrayList<>();
    public ArrayList<GPU>           gpuList          = new ArrayList<>();
    public ArrayList<MotherBoard>   moboList         = new ArrayList<>();
    public ArrayList<OpticalDrive>  OpticalDriveList = new ArrayList<>();
    public ArrayList<Ram>           ramList          = new ArrayList<>();
    public ArrayList<StorageDevice> storageList      = new ArrayList<>();
    
    public String makeQuery() {

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
}
