package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import model.ThueBao;
import view.QuanliView;
import view.Thucuocview;

public class Quanlicontroller implements ActionListener {
	private QuanliView quanliView;

	public Quanlicontroller(QuanliView quanliView) {
		this.quanliView = quanliView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if (src.equals("Thêm")) {
			this.quanliView.xoaForm();
			this.quanliView.quanliThueBao.setLuaChon("Thêm");
		} else if (src.equals("Lưu")) {
			this.quanliView.thuchienThem();
		} else if (src.equals("Cập nhập")) {
		    this.quanliView.hienthiThuebao();
	    } else if (src.equals("Xóa")) {
         	this.quanliView.thuchienXoa();
        }else if (src.equals("Tìm kiếm")) {
	        this.quanliView.thuchienTim();
        }else if (src.equals("Hủy")) {
	        this.quanliView.thuchienHuytim();
        }else if (src.equals("Open")) {
         	this.quanliView.laydulieutucsdl();
        }else if (src.equals("Exit")) {
         	System.exit(0);
        }else if (src.equals("Thu cước")) {
         	new Thucuocview();
        }
}
}
