package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankDao {

	List<People> people = new ArrayList<>();
	List<Account> account = new ArrayList<>();

	public List<People> LogIn(){
		PreparedStatement ps = null;
		People a = null;
		
		try(Connection conn = DataConn.getConnection()){
			String sql = "SELECT * FROM People WHERE UserName = ?, PassWord = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Method.UserName);
			ps.setString(2, Method.PassWord);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		}catch(SQLException ex) {
			ex.getMessage();
		}catch(IOException ex) {
			ex.getMessage();
		}
		return people;
	}
	
	public List<People> GetPeople() {

		PreparedStatement ps = null;
		People a = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "SELECT * FROM People";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int UserId = rs.getInt("UserId");
				int AccountId = rs.getInt("AccountId");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String eMail = rs.getString("eMail");
				String UserName = rs.getString("UserName");
				String PassWord = rs.getString("PassWord");

				a = new People(UserId, AccountId, FirstName, LastName, eMail, UserName, PassWord);
				people.add(a);
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		return people;
	}

	public List<Account> GetAccount() {

		PreparedStatement ps = null;
		Account a = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "SELECT * FROM Account";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int AccountId = rs.getInt("AccountId");
				int UserId = rs.getInt("UserId");
				String AccountType = rs.getString("AccountType");
				double Balance = rs.getDouble("Balance");

				a = new Account(AccountId, UserId, AccountType, Balance);
				account.add(a);
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}

		return account;
	}

	public List<People> ViewAll() {

		PreparedStatement ps = null;
		People a = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "SELECT * FROM People INEER JOIN Account ON People.UserId = Account.UserId";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int AdminId = rs.getInt("AdminId");
				int EmpId = rs.getInt("EmpId");
				int UserId = rs.getInt("UserId");
				int AccountId = rs.getInt("AccountId");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String eMail = rs.getString("eMail");
				String UserName = rs.getString("UserName");
				String PassWord = rs.getString("PassWord");
				String AccountType = rs.getString("AccountType");
				double Balance = rs.getDouble("Balance");

				a = new People(AdminId, EmpId, UserId, AccountId, FirstName, LastName, eMail, UserName, PassWord,
						AccountType, Balance);
				people.add(a);
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		return people;
	}

	public List<People> DeletePeople() {

		PreparedStatement ps = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "DELETE * FROM People WHERE UserId = " + Method.input;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			rs.close();
			ps.close();

		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		return people;
	}

	public List<Account> DeleteAccount() {

		PreparedStatement ps = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "DELETE * FROM Account WHERE UserId = " + Method.input;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}

		return account;
	}

	public List<Account> Withdraw() {

		PreparedStatement ps = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "UPDATE TABLE Account SET Balance = ? WHERE UserId = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, Method.Balance);
			ps.setInt(2, Account.UserId);
			
			ResultSet rs = ps.executeQuery();

			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		return account;
	}

	public List<Account> Deposite() {

		PreparedStatement ps = null;
		List<Account> account = new ArrayList<>();

		try (Connection conn = DataConn.getConnection()) {
			String sql = "UPDATE TABLE Account SET Balance = ? WHERE UserId = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, Method.Balance);
			ps.setInt(2, Account.UserId);
			ResultSet rs = ps.executeQuery();

			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		return account;
	}

	/*public List<Account> Transfer() {

		PreparedStatement ps = null;

		try (Connection conn = DataConn.getConnection()) {
			// String sql = "UPDATE TABLE Account SET Balance = " + Method.Balance + " WHERE
			// AccountId = " + Method.;
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		return account;
	}*/

	public List<People> NewPeople() {

		PreparedStatement ps = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "INSERT INTO People(UserId, AccountId, FirstName, LastName, eMail, UserName, PassWord) VALUES(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Method.UserId);
			ps.setInt(2, Method.AccountId);
			ps.setString(3, Method.FirstName);
			ps.setString(4, Method.LastName);
			ps.setString(5,  Method.eMail);
			ps.setString(6, Method.UserName);
			ps.setString(7, Method.PassWord);
			
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();

		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}

		return people;
	}

	public List<Account> NewAccount() {

		PreparedStatement ps = null;

		try (Connection conn = DataConn.getConnection()) {
			String sql = "INSERT INTO Account(AccountId, UserId, AccountType, Balance VALUES(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Method.AccountId);
			ps.setInt(2, Method.UserId);
			ps.setString(3, Method.AccountType);
			ps.setDouble(4, Method.Balance);
			
			
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		
		return account;
	}
}
