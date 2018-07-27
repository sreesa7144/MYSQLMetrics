package com.mysql.adapter;

import java.sql.*;

import com.mysql.adapter.annotation.Metric;

public class MysqlMetrics {
	@Metric(name = "mysql.db.slowqueries")
	public void getSlowQueries() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rayalam", "root", "root");
			Statement st = con.createStatement();
			String s = "set global slow_query_log='ON'";
			st.executeQuery(s);

			String s1 = "show global status like '%slow%'";
			ResultSet rs1 = st.executeQuery(s1);
			System.out.printf("\n ");
			while (rs1.next()) {
				System.out.println(
						"VArable name    " + rs1.getString("Variable_name") + "Value       " + rs1.getString("Value"));
			}

		} catch (Exception e) {
			System.out.println();
		}
	}

	@Metric(name = "mysql.db.slavestatus")
	public void SlaveStatus() {
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");

			String query = "SHOW SLAVE STATUS";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("Slave_IO_State                : " + rs.getString("Slave_IO_State"));
				System.out.println("Master_Host                   : " + rs.getString("Master_Host"));
				System.out.println("Master_User                   : " + rs.getString("Master_User"));
				System.out.println("Master_Port                   : " + rs.getInt("Master_Port"));
				System.out.println("Connect_Retry                 : " + rs.getInt("Connect_Retry"));
				System.out.println("Master_Log_File               : " + rs.getString("Master_Log_File"));
				System.out.println("Read_Master_Log_Pos           : " + rs.getInt("Read_Master_Log_Pos"));
				System.out.println("Relay_Log_File                : " + rs.getString("Relay_Log_File"));
				System.out.println("Slave_IO_Running              : " + rs.getString("Slave_IO_Running"));
				System.out.println("Slave_SQL_Running             : " + rs.getString("Slave_SQL_Running"));
				System.out.println("Replicate_Do_DB               : " + rs.getString("Replicate_Do_DB"));
				System.out.println("Replicate_Ignore_DB           : " + rs.getString("Replicate_Ignore_DB"));
				System.out.println("Replicate_Do_Table            : " + rs.getString("Replicate_Do_Table"));
				System.out.println("Replicate_Ignore_Table        : " + rs.getString("Replicate_Ignore_Table"));
				System.out.println("Replicate_Wild_Do_Table       : " + rs.getString("Replicate_Wild_Do_Table"));
				System.out.println("Replicate_Wild_Ignore_Table   : " + rs.getString("Replicate_Wild_Ignore_Table"));
				System.out.println("Last_Errno                    : " + rs.getInt("Last_Errno"));
				System.out.println("Last_Error                    : " + rs.getString("Last_Error"));
				System.out.println("Skip_Counter                  : " + rs.getInt("Skip_Counter"));
				System.out.println("Exec_Master_Log_Pos           : " + rs.getInt("Exec_Master_Log_Pos"));
				System.out.println("Relay_Log_Space               : " + rs.getInt("Relay_Log_Space"));
				System.out.println("Until_Condition               : " + rs.getString("Until_Condition"));
				System.out.println("Until_Log_File                : " + rs.getString("Until_Log_File"));
				System.out.println("Until_Log_Pos                 : " + rs.getInt("Until_Log_Pos"));
				System.out.println("Master_SSL_Allowed            : " + rs.getString("Master_SSL_Allowed"));
				System.out.println("Master_SSL_CA_File            : " + rs.getString("Master_SSL_CA_File"));
				System.out.println("Master_SSL_CA_Path            : " + rs.getString("Master_SSL_CA_Path"));
				System.out.println("Master_SSL_Cert               : " + rs.getString("Master_SSL_Cert"));
				System.out.println("Master_SSL_Cipher             : " + rs.getString("Master_SSL_Cipher"));
				System.out.println("Master_SSL_Key                : " + rs.getString("Master_SSL_Key"));
				System.out.println("Seconds_Behind_Master         : " + rs.getInt("Seconds_Behind_Master"));
				System.out.println("Master_SSL_Verify_Server_Cert : " + rs.getString("Master_SSL_Verify_Server_Cert"));
				System.out.println("Last_IO_Errno                 : " + rs.getInt("Last_IO_Errno"));
				System.out.println("Last_IO_Error                 : " + rs.getString("Last_IO_Error"));
				System.out.println("Last_SQL_Errno                : " + rs.getInt("Last_SQL_Errno"));
				System.out.println("Last_SQL_Error                : " + rs.getString("Last_SQL_Error"));
				System.out.println("Replicate_Ignore_Server_Ids   : " + rs.getString("Replicate_Ignore_Server_Ids"));
				System.out.println("Master_Server_Id              : " + rs.getInt("Master_Server_Id"));
				System.out.println("Master_UUID                   : " + rs.getString("Master_UUID"));
				System.out.println("Master_Info_File              : " + rs.getString("Master_Info_File"));
				System.out.println("SQL_Delay                     : " + rs.getInt("SQL_Delay"));
				System.out.println("SQL_Remaining_Delay           : " + rs.getString("SQL_Remaining_Delay"));
				System.out.println("Slave_SQL_Running_State       : " + rs.getString("Slave_SQL_Running_State"));
				System.out.println("Master_Retry_Count            : " + rs.getInt("Master_Retry_Count"));
				System.out.println("Master_Bind                   : " + rs.getString("Master_Bind"));
				System.out.println("Last_IO_Error_Timestamp       : " + rs.getString("Last_IO_Error_Timestamp"));
				System.out.println("Last_SQL_Error_Timestamp      : " + rs.getString("Last_SQL_Error_Timestamp"));
				System.out.println("Master_SSL_Crl                : " + rs.getString("Master_SSL_Crl"));
				System.out.println("Master_SSL_Crlpath            : " + rs.getString("Master_SSL_Crlpath"));
				System.out.println("Retrieved_Gtid_Set            : " + rs.getString("Retrieved_Gtid_Set"));
				System.out.println("Executed_Gtid_Set             : " + rs.getString("Executed_Gtid_Set"));
				System.out.println("Auto_Position                 : " + rs.getInt("Auto_Position"));
				System.out.println("Replicate_Rewrite_DB          : " + rs.getString("Replicate_Rewrite_DB"));
				System.out.println("Channel_name                  : " + rs.getString("Channel_name"));
				System.out.println("Master_TLS_Version            : " + rs.getString("Master_TLS_Version"));
				System.out.println("Master_public_key_path        : " + rs.getString("Master_public_key_path"));
				System.out.println("Get_master_public_key         : " + rs.getInt("Get_master_public_key"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Metric(name = "mysql.db.catchedthreads")
	public void Cahched_threads() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			Statement st = con.createStatement();
			String s = "show status  where variable_name like 'threads_cached';";
			ResultSet rs = st.executeQuery(s);
			while (rs.next()) {
				System.out.println("VArable name" + "   " + rs.getString("Variable_name") + "Value  " + "  "
						+ rs.getString("Value"));
			}

		} catch (Exception e) {
			System.out.println();
		}
	}

	@Metric(name = "mysql.db.connectedthreads")
	public void Connected_threads() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			Statement st = con.createStatement();
			String s = "show status  where variable_name like 'threads_cached';";
			ResultSet rs = st.executeQuery(s);
			while (rs.next()) {
				System.out.println("VArable name" + "   " + rs.getString("Variable_name") + "Value  " + "  "
						+ rs.getString("Value"));
			}

		} catch (Exception e) {
			System.out.println();
		}
	}

	@Metric(name = "mysql.db.systemuptime")
	public void System_uptime() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			Statement st = con.createStatement();
			String s = "show status like 'uptime';";
			ResultSet rs = st.executeQuery(s);
			while (rs.next()) {
				System.out.println("VArable name" + "   " + rs.getString("Variable_name") + "Value  " + "  "
						+ rs.getString("Value"));
			}

		} catch (Exception e) {
			System.out.println();
		}
	}

	@Metric(name = "mysql.db.openfileutil")
	public void Open_file_util() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			Statement st = con.createStatement();
			String s = "show status like 'Opened_files';";
			ResultSet rs = st.executeQuery(s);
			while (rs.next()) {
				System.out.println("VArable name" + "   " + rs.getString("Variable_name") + "Value  " + "  "
						+ rs.getString("Value"));
			}

		} catch (Exception e) {
			System.out.println();
		}
	}

	@Metric(name = "mysql.db.fullscanutilization")
	public void FullTableScanUtilization() {

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");

			String query = "show global status like 'handler_read%'";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int sum = 0, sum1 = 0, count = 0;
			String s1;
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getInt(2));
				// s1=rs.getString(1);
				count++;
				if (count == 6 || count == 7)
					sum1 += rs.getInt(2);
				sum += rs.getInt(2);

			}
			int k = (sum1 * 100) / sum;
			System.out.println(sum);
			System.out.println(sum1);
			System.out.println(k);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
