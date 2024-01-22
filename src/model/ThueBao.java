package model;

import java.util.Objects;

public class ThueBao {
	private int soDienThoai;
	private String nhaMang;
	private String Ten;
	private String ngaySinh;
	private boolean gioiTinh;
	private String queQuan;
	public ThueBao(int soDienThoai, String nhaMang, String ten, String ngaySinh, boolean gioiTinh, String queQuan) {
		this.soDienThoai = soDienThoai;
		this.nhaMang = nhaMang;
		this.Ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.queQuan = queQuan;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getNhaMang() {
		return nhaMang;
	}
	public void setNhaMang(String nhaMang) {
		this.nhaMang = nhaMang;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	@Override
	public String toString() {
		return "ThueBao [soDienThoai=" + soDienThoai + ", nhaMang=" + nhaMang + ", Ten=" + Ten + ", ngaySinh="
				+ ngaySinh + ", gioiTinh=" + gioiTinh + ", queQuan=" + queQuan + "]";
	}
	
	
	
}
