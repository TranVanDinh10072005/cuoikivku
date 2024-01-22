package dao;

import java.util.ArrayList;


public interface DAOinterface<T> {
	public int insert(T t);
	public int update (T t);
	public int delete(T t);
	public ArrayList<T> selectAll();
	public T byselectBySdt(T t);
	public ArrayList<T> selectBycondision(String condision);

}
