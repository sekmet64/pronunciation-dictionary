package org.dikso.server;

import org.dikso.client.SqliteImportService;
import org.sqlite.SQLiteConfig;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.sql.*;
import java.util.logging.Logger;


/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SqliteImportServiceImpl extends RemoteServiceServlet implements
		SqliteImportService {
	
	private static final Logger log = Logger.getLogger(SqliteImportServiceImpl.class.getName());

	public void loadDatabase() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(Exception e) {}
		
		Connection connection = null;
		
		try {
			SQLiteConfig config = new SQLiteConfig();
			config.setReadOnly(true);
			connection = DriverManager.getConnection("jdbc:sqlite:WEB-INF/dict.sqlite", config.toProperties());
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from dict");
			while (rs.next()) {
				log.info(rs.getString("hu") + " - " + rs.getString("ipa"));
			}
		}
		catch (SQLException e) {
			log.warning(e.getMessage());
		}
		finally {
			try {
				if (connection != null)
					connection.close();
			}
			catch (SQLException e) {
				log.warning(e.getMessage());
			}
		}
	}
}
