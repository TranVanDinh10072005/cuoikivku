package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import database.jdbc;

import model.ThueBao;

public class DAOthuebao implements DAOinterface<ThueBao> {
	public static DAOthuebao getinstance() {
		return new DAOthuebao();
	}

	private DefaultTableModel table;

	@Override
	public int insert(ThueBao t) {
		try {
			Connection con = jdbc.getConnection();
			
			Statement st =con.createStatement();
			
			String sql ="INSERT INTO thuebao(hoVaten,soDienthoai,nhaMang,ngaySinh,queQuan,gioiTinh)"
					+ "VALUES('"+t.getTen()+"','"+t.getSoDienThoai()+"','"+t.getNhaMang()+"','"+t.getNgaySinh()+"','"+t.getQueQuan()+"','"+(t.isGioiTinh()? "Nam" : "Nữ")+"')";
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
	public int update(ThueBao t) {
		try {
			Connection con = jdbc.getConnection();
			
			Statement st =con.createStatement();
			
			String sql ="UPDATE thuebao "+
			" SET "+
					" hoVaten='"+t.getTen()+"'"+", soDienthoai='"+t.getSoDienThoai()+"'"+", nhaMang='"+t.getNhaMang()+"'"+", ngaySinh='"+t.getNgaySinh()+"'"+", queQuan='"+t.getQueQuan()+"'"+", gioiTinh='"+(t.isGioiTinh()? "Nam" : "Nữ")+"'"
					+" WHERE soDienthoai='"+t.getSoDienThoai()+"'";
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
	public int delete(ThueBao t) {
		try {
			Connection con = jdbc.getConnection();
			
			Statement st =con.createStatement();
			
			String sql ="DELETE from thuebao "+
			" WHERE soDienthoai='"+t.getSoDienThoai()+"'";
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
	public ArrayList<ThueBao> selectAll() {
		ArrayList<ThueBao> list = new ArrayList<ThueBao>();
		try {
			Connection con = jdbc.getConnection();
			
			Statement st =con.createStatement();
			
			String sql ="SELECT * FROM thuebao";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int soDienThoai = rs.getInt("soDienThoai");
				String hoVaten = rs.getString("hoVaten");
				String ngaySinh =rs.getString("ngaySinh");
				String gt =rs.getString("gioiTinh");
				boolean gioiTinh = true;
				if (gt.equals("Nam")) {
					gioiTinh = true;
				} else if (gt.equals("Nữ")) {
					gioiTinh = false;
				}

				String queQuan = rs.getString("queQuan");
				String nhaMang = rs.getString("nhaMang");
				ThueBao tb = new ThueBao(soDienThoai, nhaMang, hoVaten, ngaySinh, gioiTinh, queQuan);
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
	public ThueBao byselectBySdt(ThueBao t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ThueBao> selectBycondision(String condision) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
