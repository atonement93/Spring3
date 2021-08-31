package com.mhs.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mhs.s1.util.DBConnector;

public class BankBookDAO {
	
	private DBConnector dbConnector;
	
	public BankBookDAO() {
		dbConnector = new DBConnector();
	}
	
	
	
	public BankBookDTO getSelect (BankBookDTO bankBookDTO) {
		
		Connection con = dbConnector.getConnect();
		PreparedStatement st= null;
		ResultSet rs = null;
		BankBookDTO result = null;
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER=?";
		
		try {
			st=con.prepareStatement(sql);
			
			st.setLong(1, bankBookDTO.getBookNumber());
			
			rs = st.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				result = new BankBookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		return result;
		
		
	}

}
