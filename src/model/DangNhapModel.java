package model;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

import view.DangNhapView;
import view.QuanliView;

public class DangNhapModel {
	private String Ten;
	private String matKhau;
	
	
	public DangNhapModel(String ten, String matKhau) {
		Ten = ten;
		this.matKhau = matKhau;
	}
	
	

	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}



	@Override
	public int hashCode() {
		return Objects.hash(Ten, matKhau);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DangNhapModel other = (DangNhapModel) obj;
		return Objects.equals(Ten, other.Ten) && Objects.equals(matKhau, other.matKhau);
	}
	
	}

	


