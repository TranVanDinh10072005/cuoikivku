package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DangNhapController;
import dao.DAOnguoidung;
import model.DangNhapModel;

public class Dangkiview extends JFrame {
	private JTextField jTextField_dn;
	private JTextField jTextField_mk;

	public Dangkiview() {
	this.setTitle("Đăng kí");
	this.setSize(400, 200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	
	
	JPanel jPanel_dangNhap = new JPanel();
	jPanel_dangNhap.setLayout(new BorderLayout());


	JPanel jp_center = new JPanel();
	JPanel jp_hienthi = new JPanel();
	Font f = new Font("Arial",Font.BOLD,40);
	Font f1 = new Font("Arial",Font.PLAIN,10);
	JLabel jlb = new JLabel("Đăng kí");
	jlb.setFont(f);
	jlb.setForeground(Color.RED);
	jp_hienthi.add(jlb);

	JPanel jp_null1 = new JPanel();
	JPanel jp_null2 = new JPanel();
	JPanel jp_ten = new JPanel();
	jp_ten.setLayout(new FlowLayout());;
	JPanel jp_mk = new JPanel();
	jp_mk.setLayout(new FlowLayout());
	jp_center.setLayout(new GridLayout(2, 1));
	JLabel jLabel_dangnhap = new JLabel("Tên đăng nhập");
	      JLabel jLabel_mk = new JLabel("    Mật khẩu       ");
	jTextField_dn = new JTextField(20);
	jTextField_mk = new JTextField(20);
	jp_ten.add(jLabel_dangnhap);
	jp_ten.add(jTextField_dn);
	jp_mk.add(jLabel_mk);
	jp_mk.add(jTextField_mk);
	
	jp_center.add(jp_ten);
	jp_center.add(jp_mk);
	
    JPanel jp_soth = new JPanel();
    jp_soth.setLayout(new GridLayout(1,3,10,10));
	JButton jButton_xn = new JButton("Xác Nhận");
	jButton_xn.setFont(f1);
	jButton_xn.addActionListener(new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			String ten =jTextField_dn.getText();
			String mk =jTextField_mk.getText();
			DangNhapModel md = new DangNhapModel(ten, mk);
			DAOnguoidung.getinstance().insert(md);
			dispose();
			
		}
	});
	jp_soth.add(jp_null1);
	jp_soth.add(jButton_xn);
	jp_soth.add(jp_null2);
		

	jPanel_dangNhap.add(jp_center, BorderLayout.CENTER);
	jPanel_dangNhap.add(jp_soth, BorderLayout.SOUTH);
	jPanel_dangNhap.add(jp_hienthi, BorderLayout.NORTH);
	


	
    this.add(jPanel_dangNhap);
	this.setVisible(true);


}
	public static void main(String[] args) {
		new Dangkiview();
	}
	}
