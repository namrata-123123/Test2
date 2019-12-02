package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {
	
	final static Logger logger = Logger.getLogger(FERServiceImpl.class);
	@Override
	public boolean registration(User user) {
boolean isRegister=false;
		Connection connection = null;
		PreparedStatement statement = null;
		logger.info("user:"+logger);

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"insert into user(firstname,middlename,lastname,username,password,email,mobile) values(?,?,?,?,?,?,?)");

			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getMiddlename());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getUsername());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getMobile());

			int noOfRecInserted = statement.executeUpdate();

			System.out.println("no of records inserted: " + noOfRecInserted);

		isRegister= (noOfRecInserted > 0);

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("SQLException:"+e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("isRegister:"+isRegister);
		return isRegister;
	}

	@Override
	public int login(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isRegister = false;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("select * from user where username=? and password=?;");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			System.out.println(username + " , " + password);

			while (resultSet.next()) {

				return resultSet.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return 0;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"insert into expense (expensetype,date,price,numberofitems,total,bywhom,userid) values(?,?,?,?,?,?,?)");

			statement.setString(1, expense.getType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberofitems());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getByWhom());
			statement.setInt(7, expense.getUserid());

			int noOfRecInserted = statement.executeUpdate();
			System.out.println("no of records inserted: " + noOfRecInserted);

			return noOfRecInserted > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return false;
	}

	@Override
	public boolean editExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"update expense set expensetype=?,date=?,price=?,numberofitems=?,total=?,bywhom=? where expenseid=?");

			statement.setString(1, expense.getType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberofitems());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getByWhom());
			statement.setInt(7, expense.getId());

			int noOfRecInserted = statement.executeUpdate();
			System.out.println("no of records inserted: " + noOfRecInserted);

			return noOfRecInserted > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return false;
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("delete  from expense where expenseid=?");

			statement.setInt(1, expenseId);

			int noOfRecDeleted = statement.executeUpdate();
			System.out.println("no of records deleted: " + noOfRecDeleted);

			return noOfRecDeleted > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return false;
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("update user set password=? where id=? and password=?");

			statement.setString(1, newPassword);
			statement.setInt(2, userId);
			statement.setString(3, currentPassword);

			int noOfRecUpdated = statement.executeUpdate();
			System.out.println("no of records inserted: " + noOfRecUpdated);

			return noOfRecUpdated > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	@Override
	public Expense getExpense(int expenseId) {
		Connection connection = null;
		PreparedStatement statement = null;
		Expense expense = null;

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("select * from expense where expenseid=?;");

			statement.setInt(1, expenseId);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();

				expense.setType(resultSet.getString("expensetype"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberofitems(resultSet.getInt("numberofitems"));
				expense.setTotal(resultSet.getFloat("total"));
				expense.setByWhom(resultSet.getString("bywhom"));
				expense.setUserid(resultSet.getInt("userid"));
				expense.setId(resultSet.getInt("expenseid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;
	}

	@Override
	public List<Expense> getExpenses(int userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Expense> expenses = new ArrayList<Expense>();
		Expense expense = null;

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("select * from expense where userid=?;");

			statement.setInt(1, userId);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();
				expense.setId(resultSet.getInt("expenseid"));
				expense.setType(resultSet.getString("expensetype"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberofitems(resultSet.getInt("numberofitems"));
				expense.setByWhom(resultSet.getString("bywhom"));
				expenses.add(expense);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;
	}

	@Override
	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {

		Connection connection = null;
		PreparedStatement statement = null;
		List<Expense> expenses = new ArrayList<Expense>();
		Expense expense = null;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"select * from expense where userid=? and expensetype=? and date between ? and ?;");
			statement.setInt(1, userId);
			statement.setString(2, expenseType);
			statement.setString(3, fromDate);
			statement.setString(4, toDate);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();
				expense.setId(resultSet.getInt("expenseid"));
				expense.setType(resultSet.getString("expensetype"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberofitems(resultSet.getInt("numberofitems"));
				expense.setByWhom(resultSet.getString("bywhom"));
				expense.setTotal(resultSet.getFloat("total"));
				expenses.add(expense);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;
	}

	@Override
	public User getPersonalInfo(int userId) {

		Connection connection = null;
		PreparedStatement statement = null;
		User user = new User();
		Address address = null;

		try {
			connection = DBUtil.getConnection();

			statement = connection
					.prepareStatement("select u.*,a.* from user u left join address a on u.id=a.userid where u.id=?");
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				address = new Address();

				System.out.println();
				user.setFirstname(resultSet.getString("firstname"));
				user.setMiddlename(resultSet.getString("middlename"));
				user.setLastname(resultSet.getString("lastname"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setMobile(resultSet.getString("mobile"));
				user.setEmail(resultSet.getString("email"));

				address.setLineOne(resultSet.getString("lineOne"));
				address.setLineTwo(resultSet.getString("lineTwo"));
				address.setCity(resultSet.getString("city"));
				address.setState(resultSet.getString("state"));
				address.setZip(resultSet.getString("zip"));
				address.setCountry(resultSet.getString("country"));
				address.setUserid(resultSet.getInt("userid"));
				user.setAddress(address);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return user;
	}

	@Override
	public boolean updatePersonalInfo(User user) {

		Connection connection = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		boolean isPersonalUpdated = false;

		try {
			connection = DBUtil.getConnection();

			statement1 = connection.prepareStatement(
					"update user set firstname=?,middlename=?,lastname=?,email=?,mobile=? where id=?");

			statement1.setString(1, user.getFirstname());
			statement1.setString(2, user.getMiddlename());
			statement1.setString(3, user.getLastname());
			statement1.setString(4, user.getMobile());
			statement1.setString(5, user.getEmail());
			statement1.setInt(6, user.getId());
			int userUpdated = statement1.executeUpdate();
			System.out.println("no of records inserted: " + userUpdated);

			String inputAddress = "";
			if (userUpdated > 0) {
				System.out.println("user info updated");
				if (user.getAddress().getId() == 0) {

					inputAddress = "insert into address(lineOne,lineTwo,city,state,zip,country,userid) values(?,?,?,?,?,?,?);";
					statement2 = connection.prepareStatement(inputAddress);

					statement2.setString(1, user.getAddress().getLineOne());
					statement2.setString(2, user.getAddress().getLineTwo());
					statement2.setString(3, user.getAddress().getCity());
					statement2.setString(4, user.getAddress().getState());
					statement2.setString(5, user.getAddress().getZip());
					statement2.setString(6, user.getAddress().getCountry());
					statement2.setInt(7, user.getAddress().getUserid());
					int noOfRecInserted = statement2.executeUpdate();
					System.out.println("address  records inserted " + noOfRecInserted);
					if (noOfRecInserted > 0) {
						isPersonalUpdated = true;
					}
				}

				else {
					inputAddress = "update address set addressline1=?,addressline2=?,city=?,state=?,pincode=? where userid=?;";
					statement2 = connection.prepareStatement(inputAddress);

					statement2.setString(1, user.getAddress().getLineOne());
					statement2.setString(2, user.getAddress().getLineTwo());
					statement2.setString(3, user.getAddress().getCity());
					statement2.setString(4, user.getAddress().getState());
					statement2.setString(5, user.getAddress().getZip());
					statement2.setInt(6, user.getId());
					int noOfRecUpdated = statement2.executeUpdate();
					System.out.println("address  records updated " + noOfRecUpdated);
					if (noOfRecUpdated > 0) {
						isPersonalUpdated = true;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isPersonalUpdated;
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("select * from user where username=? ");
			statement.setString(1, username);
		
			ResultSet resultSet = statement.executeQuery();
			

			while (resultSet.next()) {

				System.out.println("Match is found");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return true;
	}

	

}
