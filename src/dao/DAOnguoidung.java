package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc;
import model.DangNhapModel;
import model.ThueBao;

public class DAOnguoidung implements DAOinterface<DangNhapModel>{
	public static DAOnguoidung getinstance() {
		return new DAOnguoidung();
	}

	@Override
	public int insert(DangNhapModel t) {
		try {
			Connection con = jdbc.getConnection();
			
			Statement st =con.createStatement();
			
			String sql ="INSERT INTO nguoidung(tenDangnhap,matKhau)"
					+ "VALUES('"+t.getTen()+"','"+t.getMatKhau()+"')";
			int kq = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi:"+sql);
			System.out.println("có:"+kq);
			
			jdbc.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int update(DangNhapModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DangNhapModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<DangNhapModel> selectAll() {
		ArrayList<DangNhapModel> list = new ArrayList<DangNhapModel>();
		try {
			Connection con = jdbc.getConnection();
			
			Statement st =con.createStatement();
			
			String sql ="SELECT * FROM nguoidung";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
				String ten = rs.getString("tenDangnhap");
				String mk =rs.getString("matKhau");
				
				DangNhapModel tb = new DangNhapModel(ten, mk);
				list.add(tb);
			}
			
			
			jdbc.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		

	       
	}

	@Override
	public DangNhapModel byselectBySdt(DangNhapModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DangNhapModel> selectBycondision(String condision) {
		// TODO Auto-generated method stub
		return null;
	}
	

}