package com.edubridge.tyre_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.edubridge.tyre_application.model.Tyre;
import com.edubridge.tyre_application.utils.DBUtilsForTyre;

public class TyreDaoImpl implements TyreDao {

	@Override
	public List<Tyre> getAllTyres() {
		// TODO Auto-generated method stub
		String SELECT = "select * from tyre";

		Connection con = DBUtilsForTyre.getConnection();

		List<Tyre> tyres = new ArrayList<Tyre>();

		try {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			System.out.println("Tyres List are : ");
			while (rs.next()) {
				Tyre t = new Tyre();
				t.setId(rs.getInt("id"));
				t.setBrand(rs.getString("brand"));
				t.setColor(rs.getString("color"));
				t.setPrice(rs.getInt("price"));
				tyres.add(t);
				// we have to add every possible retrived value to the Current List.
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tyres;
	}

	@Override
	public int addTyre(Tyre c) {
		// TODO Auto-generated method stub
		String INSERT = "insert into  tyre(id, brand, color, price) values(?,?,?,?)";

		Connection con = DBUtilsForTyre.getConnection();

		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getBrand());
			ps.setString(3, c.getColor());
			ps.setInt(4, c.getPrice());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block.
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateTyre(Tyre t) {
		// TODO Auto-generated method stub
		// Updating the Contact Record in table.
		String update = "update tyre set brand=?, color=?, price=? where id=?";
		Connection con = DBUtilsForTyre.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, t.getBrand());
			ps.setString(2, t.getColor());
			ps.setInt(3, t.getPrice());

			ps.setInt(4, t.getId());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int deleteTyre(Tyre c) {
		// TODO Auto-generated method stub
		String delete = "delete from tyre where id = ?";

		Connection con = DBUtilsForTyre.getConnection();

		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, c.getId());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block.
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteAllTyres() {
		// TODO Auto-generated method stub
		String delete_all = "delete from tyre";

		Connection con = DBUtilsForTyre.getConnection();

		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(delete_all);
//			ps.setInt(1, c.getId());			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block.
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int truncateTyre() {
		// TODO Auto-generated method stub
		String truncate = "truncate table tyre";

		Connection con = DBUtilsForTyre.getConnection();

		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(truncate);
//			ps.setInt(1, c.getId());			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block.
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Tyre> describeTyre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tyre searchTyre(String brand) {
		// TODO Auto-generated method stub
		// to search the Tyre details using NAME.
		Connection con = DBUtilsForTyre.getConnection();
		Tyre t = null;
		String select = "select * from tyre where brand = ?";

		try {
			PreparedStatement ps = con.prepareStatement(select);
			ps.setString(1, brand);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t = new Tyre();
				t.setId(rs.getInt("id"));
				t.setBrand(rs.getString("brand"));
				t.setColor(rs.getString("color"));
				t.setPrice(rs.getInt("price"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Tyre getTyre(int id) {
		// TODO Auto-generated method stub
		// to search the Tyre details using ID.
		Connection con = DBUtilsForTyre.getConnection();
		Tyre t = null;
		String select = "select * from tyre where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(select);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t = new Tyre();
				t.setId(rs.getInt("id"));
				t.setBrand(rs.getString("brand"));
				t.setColor(rs.getString("color"));
				t.setPrice(rs.getInt("price"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
