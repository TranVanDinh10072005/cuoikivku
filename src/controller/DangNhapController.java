package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DangNhapView;
import view.Dangkiview;

public class DangNhapController implements ActionListener {
	private DangNhapView dangNhapView;

	public DangNhapController(DangNhapView dangNhapView) {
		this.dangNhapView = dangNhapView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Đăng Nhập")) {
			this.dangNhapView.dang();
		}
		if (src.equals("Đăng kí")) {
			new Dangkiview();
		}

	}
}


