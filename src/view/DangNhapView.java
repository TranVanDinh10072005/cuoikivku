package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DangNhapController;
import dao.DAOnguoidung;
import dao.DAOthuebao;
import model.DangNhapModel;
import model.QuanliModel;
import model.ThueBao;

public class DangNhapView extends JFrame {
	public JTextField jTextField_dn;
	public JTextField jTextField_mk;

	public DangNhapView() throws HeadlessException {
		this.init();
	}

	private void init() {
		this.setTitle("Đăng Nhập");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
//		CardLayout cardLayout = new CardLayout();
//		JPanel card = new JPanel();
//		card.setLayout(cardLayout);
		
		JPanel jPanel_dangNhap = new JPanel();
		jPanel_dangNhap.setLayout(new BorderLayout());

		DangNhapController dangNhapController = new DangNhapController(this);

		JPanel jp_center = new JPanel();
		JPanel jp_hienthi = new JPanel();
		Font f = new Font("Arial",Font.BOLD,40);
		Font f1 = new Font("Arial",Font.PLAIN,10);
		JLabel jlb = new JLabel("Đăng Nhập");
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
        jp_soth.setLayout(new GridLayout(1,4,10,10));
		JButton jButton_dn = new JButton("Đăng Nhập");
		jButton_dn.setFont(f1);
		JButton jButton_dk = new JButton("Đăng kí");
		jButton_dk.setFont(f1);
		jp_soth.add(jp_null1);
		jp_soth.add(jButton_dn);
		jp_soth.add(jButton_dk);
		jp_soth.add(jp_null2);
		jButton_dn.addActionListener(dangNhapController);
		jButton_dk.addActionListener(dangNhapController);
		jPanel_dangNhap.add(jp_center, BorderLayout.CENTER);
		jPanel_dangNhap.add(jp_soth, BorderLayout.SOUTH);
		jPanel_dangNhap.add(jp_hienthi, BorderLayout.NORTH);
        this.add(jPanel_dangNhap);
		this.setVisible(true);

	}

	public void dang() {
		String ten =this.jTextField_dn.getText();
		String mk =this.jTextField_mk.getText();
		DangNhapModel md = new DangNhapModel(ten, mk);
		ArrayList<DangNhapModel> list= DAOnguoidung.getinstance().selectAll();
		boolean ktr = false;
		for (DangNhapModel tb : list) {
			if(tb.equals(md)) {
				 ktr = true;
			}
			
		}
		if(ktr==true) {
			JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
			this.dispose();
			new QuanliView();
		}else {
			JOptionPane.showMessageDialog(null, "Nhập sai");
		}
		}

	}



