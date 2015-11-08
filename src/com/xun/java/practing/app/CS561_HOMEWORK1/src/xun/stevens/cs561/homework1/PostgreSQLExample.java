package xun.stevens.cs561.homework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostgreSQLExample {
	public static <E> void main(String[] args) {
		// set up the connection information
		String usernameString = "username";
		String passwordString = "password";
		String urlString = "jdbc:postgresql://155.246.89.29:5432/xcui3";
		ArrayList<Sales> salesList = new ArrayList<Sales>();
		ArrayList<Sales> salesList2 = new ArrayList<Sales>();
		State stateChose = new State();
		try {
			// load the server
			Class.forName("org.postgresql.Driver");
			System.out.println("Success loading server");
		} catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(urlString,
					usernameString, passwordString);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sales");
			//String stateChoseString = "yjt";
			// Question 1:
			while (rs.next()) {
				// create a new sales class to store data;
				Sales sales = new Sales();
				sales.customs.setNameString(rs.getString("cust"));
				sales.customs.setProductString(rs.getString("prod"));
				sales.day = Integer.parseInt(rs.getString("day"));
				sales.month = Integer.parseInt(rs.getString("month"));
				sales.year = Integer.parseInt(rs.getString("year"));
				sales.state = rs.getString("state");
				sales.quant = Integer.parseInt(rs.getString("quant"));
				// make an judgement of the data to decide whether the data need
				// to be processed
				// Question 1
				if (salesList.contains(sales)) {
					Sales oldSales = salesList.get(salesList.indexOf(sales));
					// oldSales.quant = (oldSales.quant + sales.quant) /
					// (oldSales.count + 1);
					switch (sales.state.charAt(1)) {
					case 'Y': // calculate NY average quantity
						oldSales.nyAverage = ((oldSales.nyAverage * oldSales.nyCount) + sales.quant)
								/ (oldSales.nyCount + 1);
						oldSales.nyCount++;
					case 'J': // calculate NJ average quantity
						oldSales.njAverage = ((oldSales.njAverage * oldSales.njCount) + sales.quant)
								/ (oldSales.njCount + 1);
						oldSales.njCount++;
					case 'T': // calculate CT average quantity
						oldSales.ctAverage = ((oldSales.ctAverage * oldSales.ctCount) + sales.quant)
								/ (oldSales.ctCount + 1);
						oldSales.ctCount++;
					}
				} else {
					switch (sales.state.charAt(1)) {
					case 'Y':
						sales.setNY();
					case 'J':
						sales.setNJ();
					case 'T':
						sales.setCT();
					}

					salesList.add(sales);

				}
			}
			// print the answer of Qusetion1
			System.out.println("CUSTOM" + "   " + "PRODUCT" + "   " + "NY_AVE"
					+ "   " + "NJ_AVE" + "CT_AVE");
			System.out.println("======================================"
					+ "===================================");
			for (int i = 0; i < salesList.size(); i++) {
				System.out.println(salesList.get(i).customs.getNameString()
						+ "    " + salesList.get(i).customs.getProductString()
						+ "    " + salesList.get(i).nyAverage + "    "
						+ salesList.get(i).njAverage + "    "
						+ salesList.get(i).ctAverage);
			}
			System.out.println();
			System.out.println();
			System.out.println("Next is the Question 2 and Question3: ");
			// Qusetion2 and Question3
			while (rs.next()) {
				// create a new sales class to store data;
				Sales sales = new Sales();
				sales.customs.setNameString(rs.getString("cust"));
				sales.customs.setProductString(rs.getString("prod"));
				sales.day = Integer.parseInt(rs.getString("day"));
				sales.month = Integer.parseInt(rs.getString("month"));
				sales.year = Integer.parseInt(rs.getString("year"));
				sales.state = rs.getString("state");
				sales.quant = Integer.parseInt(rs.getString("quant"));
				if (salesList2.contains(sales)) {
					// data processing
					Sales oldSales = salesList2.get(salesList2
							.lastIndexOf(sales));
					oldSales.setMaxAndMinInf(sales);

				} else {
					// initialize the question2 and question3 data
					sales.inilizeQ2();
					salesList2.add(sales);
				}

			}
			// print the result of question2 and question3
			System.out.println("CUSTOM" + "   " + "PRODUCT" + "   " + "MAX_Q"
					+ "   " + "DATE" + "STATE" + "MIN_Q" + "   " + "DATE"
					+ "STATE" + "AVE_Q");
			System.out.println("======================================"
					+ "=============================================================");
			for (int i = 0; i < salesList.size(); i++) {
				System.out.println(salesList.get(i).customs.getNameString()
						+ "    " + salesList.get(i).customs.getProductString()
						+ "    " + salesList.get(i).maxQuant + "    "
						+ salesList.get(i).maxDay + "/"
						+ salesList.get(i).maxMonth + "/"
						+ salesList.get(i).maxYear + "    "
						+ salesList.get(i).maxState + "    "
						+ salesList.get(i).maxQuant + "    "
						+ salesList.get(i).minDay + "/"
						+ salesList.get(i).minMonth + "/"
						+ salesList.get(i).minYear + "    "
						+ salesList.get(i).minState + "    "
						+ salesList.get(i).aveQuant);
			}

		}

		catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}
}
