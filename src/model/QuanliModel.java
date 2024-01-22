package model;

import java.util.ArrayList;
import java.util.Objects;

public class QuanliModel {
	private ArrayList<ThueBao> thueBaolist ;
	private String luaChon;

	public QuanliModel() {
		this.thueBaolist= new ArrayList<ThueBao>();
		this.luaChon= "";
	}

	public QuanliModel(ArrayList<ThueBao> thueBaolist) {
		this.thueBaolist = thueBaolist;
	}

	
	public ArrayList<ThueBao> getThueBaolist() {
		return thueBaolist;
	}

	public void setThueBaolist(ArrayList<ThueBao> thueBaolist) {
		this.thueBaolist = thueBaolist;
	}
	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(thueBaolist);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuanliModel other = (QuanliModel) obj;
		return Objects.equals(thueBaolist, other.thueBaolist);
	}
	public void insert(ThueBao thueBao) {
		this.thueBaolist.add(thueBao);
	}
	public void delete(ThueBao thueBao) {
		this.thueBaolist.remove(thueBao);
	}
	public void update(ThueBao thueBao) {
		this.thueBaolist.remove(thueBao);
		this.thueBaolist.add(thueBao);
	}
	public void xoasach(ThueBao thueBao) {
		this.thueBaolist.clear();
	}
	
	public boolean kiemtratontai(ThueBao tb) {
		for(ThueBao tb1 : thueBaolist) {
			if(tb1.getSoDienThoai()==tb.getSoDienThoai()) {
				return true;
			}
			
		}return false;
		
	}
	
	

}
