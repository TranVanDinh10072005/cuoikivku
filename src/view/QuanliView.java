package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import controller.Quanlicontroller;
import dao.DAOthuebao;
import database.jdbc;
import model.QuanliModel;
import model.ThueBao;

public class QuanliView extends JFrame {
	public static QuanliModel quanliThueBao;
	private JComboBox<String> jComboBox_nhaMang;
	private JTextField jTextField_sdt;
	private JButton jButton_timKiem;
	private JTextField jTextField_ten;
	private JTextField jTextField_ngaySinh;
	private JTextField jTextField_sdtchucnang;
	private JRadioButton jRadioButton_Nam;
	private ButtonGroup jButtonGroup_gioitinh;
	private JRadioButton jRadioButton_Nu;
	private JTextField jTextField_queQuan;
	private JComboBox<String> jComboBox_nhaMangchucnang;
	private JTable jTable;
	private DefaultTableModel table;
	private ThueBao tb;
	private JComboBox<String> jComboBox_nhaMangthucuoc;

	public QuanliView() throws HeadlessException {
		this.quanliThueBao = new QuanliModel();

		this.init();
	}

	private void init() {
		this.setTitle("Quản lí");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);

		ActionListener actionListener = new Quanlicontroller(this);
		URL icon =QuanliView.class.getResource("Home.png");
		Image img = Toolkit.getDefaultToolkit().createImage(icon);
		this.setIconImage(img);
		

		JPanel JPanel_trangchu = new JPanel();
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("");
		jMenu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QuanliView.class.getResource("3gach.png"))));
		JMenuItem jMenuItem_open = new JMenuItem("Open");
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		jMenuItem_open.addActionListener(actionListener);
		JMenuItem jMenuItem_exit = new JMenuItem("Exit");
		jMenuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_DOWN_MASK));
		jMenuItem_exit.addActionListener(actionListener);
		jMenu.add(jMenuItem_open);
		jMenu.addSeparator();
		jMenu.add(jMenuItem_exit);
		jMenuBar.add(jMenu);

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);

		JPanel jPanel_timKiem = new JPanel();
		jPanel_timKiem.setLayout(new GridLayout(2, 1));
		JLabel jLabel_boLoc = new JLabel("Bộ lọc");
		jLabel_boLoc.setFont(font);
		JLabel jLabel_nhaMang = new JLabel("Nhà mạng:");
		jLabel_nhaMang.setFont(font2);
		JLabel jLabel_sdt = new JLabel("Số điện thoại:");
		jLabel_sdt.setFont(font2);
		String[] cacNhaMang = new String[] { "MobiFone", "Viettel", "Vinaphone", "Vietnamobile", "Gmobile" };
		jComboBox_nhaMang = new JComboBox<String>(cacNhaMang);
		jComboBox_nhaMang.setFont(font2);
		jTextField_sdt = new JTextField(10);
		jTextField_sdt.setFont(font2);
		jButton_timKiem = new JButton("Tìm kiếm");
		jButton_timKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QuanliView.class.getResource("Timkiem.png"))));
		jButton_timKiem.addActionListener(actionListener);
		JButton jButton_huy = new JButton("Hủy");
		jButton_huy.addActionListener(actionListener);
		JPanel jPanel_timKiem_val = new JPanel();
		jPanel_timKiem_val.setLayout(new GridLayout(1, 6, 10, 10));
		jPanel_timKiem_val.add(jLabel_nhaMang);
		jPanel_timKiem_val.add(jComboBox_nhaMang);
		jPanel_timKiem_val.add(jLabel_sdt);
		jPanel_timKiem_val.add(jTextField_sdt);
		jPanel_timKiem_val.add(jButton_timKiem);
		jPanel_timKiem_val.add(jButton_huy);
		jPanel_timKiem.add(jLabel_boLoc);
		jPanel_timKiem.add(jPanel_timKiem_val);

		JPanel jPanel_bang = new JPanel();
		jPanel_bang.setLayout(new GridLayout(2, 1));
		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(new GridLayout(2, 1));
		JLabel jLabel_danhSach = new JLabel("Danh sách");
		jLabel_danhSach.setFont(font);
		table = new DefaultTableModel();
		table.addColumn("Họ và tên");
		table.addColumn("Số điện thoại");
		table.addColumn("Nhà mạng");
		table.addColumn("Ngày sinh");
		table.addColumn("Quê quán");
		table.addColumn("Giới tính");
		jTable = new JTable(table);
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jPanel_center.add(jLabel_danhSach);
		jPanel_center.add(jScrollPane);
		jPanel_bang.add(jPanel_center);

		JPanel_trangchu.setLayout(new BorderLayout());
		JPanel_trangchu.add(jPanel_timKiem, BorderLayout.NORTH);



		JPanel jPanel_chucNang = new JPanel();
		jPanel_chucNang.setLayout(new GridLayout(1, 2, 80, 1));
		JPanel jPanel_ChucNang1 = new JPanel();
		jPanel_ChucNang1.setLayout(new GridLayout(3, 2, 1, 60));
		JPanel jPanel_ChucNang2 = new JPanel();
		jPanel_ChucNang2.setLayout(new GridLayout(3, 2, 1, 60));
		JLabel jLabel_ten = new JLabel("Họ và tên:");
		JLabel jLabel_ngaySinh = new JLabel("Ngày sinh:");
		JLabel jLabel_queQuan = new JLabel("Quê quán:");
		JLabel jLabel_sdtchucnang = new JLabel("Số điện thoại:");
		JLabel jLabel_gioiTinh = new JLabel("Giới tính:");
		JLabel jLabel_nhanMangChucnang = new JLabel("Nhà mạng:");
		jTextField_ten = new JTextField(20);
		jTextField_ngaySinh = new JTextField(20);
		jTextField_queQuan = new JTextField(20);
		jTextField_sdtchucnang = new JTextField(10);
		jRadioButton_Nam = new JRadioButton("Nam");
		jRadioButton_Nu = new JRadioButton("Nữ");
		jButtonGroup_gioitinh = new ButtonGroup();
		jButtonGroup_gioitinh.add(jRadioButton_Nu);
		jButtonGroup_gioitinh.add(jRadioButton_Nam);
		JPanel jPanel_Butongioitinh = new JPanel();
		jPanel_Butongioitinh.setLayout(new GridLayout(1, 2));
		jPanel_Butongioitinh.add(jRadioButton_Nam);
		jPanel_Butongioitinh.add(jRadioButton_Nu);
		jComboBox_nhaMangchucnang = new JComboBox<String>(cacNhaMang);
		jPanel_ChucNang1.add(jLabel_sdtchucnang);
		jPanel_ChucNang1.add(jTextField_sdtchucnang);
		jPanel_ChucNang1.add(jLabel_ten);
		jPanel_ChucNang1.add(jTextField_ten);
		jPanel_ChucNang1.add(jLabel_nhanMangChucnang);
		jPanel_ChucNang1.add(jComboBox_nhaMangchucnang);
		jPanel_ChucNang2.add(jLabel_ngaySinh);
		jPanel_ChucNang2.add(jTextField_ngaySinh);
		jPanel_ChucNang2.add(jLabel_queQuan);
		jPanel_ChucNang2.add(jTextField_queQuan);
		jPanel_ChucNang2.add(jLabel_gioiTinh);
		jPanel_ChucNang2.add(jPanel_Butongioitinh);
		jPanel_chucNang.add(jPanel_ChucNang1);
		jPanel_chucNang.add(jPanel_ChucNang2);

		JPanel jPanel_buttonchucnang = new JPanel();
		JPanel jPanel_null = new JPanel();
		JPanel jPanel_null2 = new JPanel();
		JPanel jPanel_south = new JPanel();
		jPanel_south.setLayout(new GridLayout(3, 1));
		jPanel_buttonchucnang.setLayout(new GridLayout(1, 5, 20, 20));
		JButton jButton_them = new JButton("Thêm");
		jButton_them.addActionListener(actionListener);
		JButton jButton_xoa = new JButton("Xóa");
		jButton_xoa.addActionListener(actionListener);
		JButton jButton_luu = new JButton("Lưu");
		jButton_luu.addActionListener(actionListener);
		JButton jButton_thucuoc = new JButton("Thu cước");
		jButton_thucuoc.addActionListener(actionListener);
		JButton jButton_capnhap = new JButton("Cập nhập");
		jButton_capnhap.addActionListener(actionListener);
		jPanel_buttonchucnang.add(jButton_them);
		jPanel_buttonchucnang.add(jButton_xoa);
		jPanel_buttonchucnang.add(jButton_capnhap);
		jPanel_buttonchucnang.add(jButton_luu);
		jPanel_buttonchucnang.add(jButton_thucuoc);
		jPanel_south.add(jPanel_null);
		jPanel_south.add(jPanel_buttonchucnang);
		jPanel_south.add(jPanel_null2);
		jPanel_bang.add(jPanel_chucNang);
		JPanel_trangchu.add(jPanel_south, BorderLayout.SOUTH);
		JPanel_trangchu.add(jPanel_bang, BorderLayout.CENTER);

		this.setJMenuBar(jMenuBar);
		this.add(JPanel_trangchu);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void xoaForm() {
		jTextField_ten.setText("");
		jTextField_ngaySinh.setText("");
		jTextField_sdtchucnang.setText("");
		jTextField_queQuan.setText("");
		jComboBox_nhaMangchucnang.setSelectedIndex(-1);
		jButtonGroup_gioitinh.clearSelection();

	}

	public void themthuebaovaoBang(ThueBao tb) {
		table = (DefaultTableModel) jTable.getModel();
		table.addRow(new Object[] { tb.getTen(), tb.getSoDienThoai() + "", tb.getNhaMang(), tb.getNgaySinh().toString(),
				tb.getQueQuan(), tb.isGioiTinh() ? "Nam" : "Nữ" });
	}

	public void themHpaccapnhapThuebao(ThueBao tb) {
		if (!this.quanliThueBao.kiemtratontai(tb)) {
			this.quanliThueBao.insert(tb);
			this.themthuebaovaoBang(tb);
			DAOthuebao.getinstance().insert(tb);

		} else {
			this.quanliThueBao.update(tb);
			DAOthuebao.getinstance().update(tb);
			int soLuongdong = table.getRowCount();
			for (int i = 0; i < soLuongdong; i++) {
				String id = table.getValueAt(i, 1) + "";
				if (id.equals(tb.getSoDienThoai() + "")) {
					table.setValueAt(tb.getTen(), i,0);
					table.setValueAt(tb.getSoDienThoai(), i, 1);
					table.setValueAt(tb.getNhaMang(), i, 2);
					table.setValueAt(tb.getNgaySinh().toString(), i, 3);
					table.setValueAt(tb.getQueQuan(), i, 4);
					table.setValueAt(tb.isGioiTinh() ? "Nam" : "Nữ", i, 5);
				}
			}

		}
	}

	public ThueBao getthuebaodachon() {
		table = (DefaultTableModel) jTable.getModel();
		int i_row = jTable.getSelectedRow();
		String Ten = table.getValueAt(i_row, 0) + "";
		int soDienThoai = Integer.valueOf(table.getValueAt(i_row, 1) + "");
		String nhaMang = (String) table.getValueAt(i_row, 2);
		String ngaySinh = table.getValueAt(i_row, 3) + "";
		String queQuan = table.getValueAt(i_row, 4) + "";
		String textgioitinh = table.getValueAt(i_row, 5) + "";
		boolean gioiTinh = textgioitinh.equals("Nam");

		ThueBao tb = new ThueBao(soDienThoai, nhaMang, Ten, ngaySinh, gioiTinh, queQuan);
		return tb;

	}

	public void hienthiThuebao() {
		ThueBao tb = getthuebaodachon();

		jTextField_ten.setText(tb.getTen());
		jTextField_ngaySinh.setText(tb.getNgaySinh() + "");
		jTextField_sdtchucnang.setText(tb.getSoDienThoai() + "");
		jTextField_queQuan.setText(tb.getQueQuan());
		jComboBox_nhaMangchucnang.setSelectedItem(tb.getNhaMang());
		if (tb.isGioiTinh()) {
			jRadioButton_Nam.setSelected(true);
		} else {
			jRadioButton_Nu.setSelected(true);
		}

	}

	public void thuchienThem() {
		int soDienThoai = Integer.valueOf(this.jTextField_sdtchucnang.getText() + "");
		String Ten = this.jTextField_ten.getText() + "";
		String ngaySinh = this.jTextField_ngaySinh.getText();
		boolean gioiTinh = true;
		if (this.jRadioButton_Nam.isSelected()) {
			gioiTinh = true;
		} else if (this.jRadioButton_Nu.isSelected()) {
			gioiTinh = false;
		}

		String queQuan = this.jTextField_queQuan.getText() + "";
		String nhaMang = (String) this.jComboBox_nhaMangchucnang.getSelectedItem();

		ThueBao tb = new ThueBao(soDienThoai, nhaMang, Ten, ngaySinh, gioiTinh, queQuan);
		this.themHpaccapnhapThuebao(tb);

	}

	public void thuchienXoa() {
		table = (DefaultTableModel) jTable.getModel();
		int i_row = jTable.getSelectedRow();
		int luachon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?");
		if (luachon == JOptionPane.YES_OPTION) {
			ThueBao tb = getthuebaodachon();
			this.quanliThueBao.delete(tb);
			table.removeRow(i_row);
			DAOthuebao.getinstance().delete(tb);
		}
	}

	public void thuchienTim() {
		this.thuchienHuytim();
		String nhaMang = (String) this.jComboBox_nhaMang.getSelectedItem();
		String soDienThoaiText = jTextField_sdt.getText().trim();
		Set<Integer> thuebaocanxoa = new TreeSet<Integer>();
		table = (DefaultTableModel) jTable.getModel();
		int soLuongdong = table.getRowCount();

		if (soDienThoaiText.isEmpty() && nhaMang.isEmpty()) {
			return;
		}

		if (!soDienThoaiText.isEmpty()) {
			try {
				int soDienThoai = Integer.parseInt(soDienThoaiText);
				for (int i = 0; i < soLuongdong; i++) {
					int sdttrongbang = Integer.parseInt(table.getValueAt(i, 1) + "");
					if (sdttrongbang != soDienThoai) {
						thuebaocanxoa.add(sdttrongbang);
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ cho Số Điện Thoại.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		if (!nhaMang.isEmpty()) {
			for (int i = 0; i < soLuongdong; i++) {
				String nhaMangtrongbang = table.getValueAt(i, 2) + "";
				if (!nhaMangtrongbang.equals(nhaMang)) {
					thuebaocanxoa.add(Integer.parseInt(table.getValueAt(i, 1) + ""));
				}
			}
		}

		for (Integer tbcanxoa : thuebaocanxoa) {
			soLuongdong = table.getRowCount();
			for (int i = 0; i < soLuongdong; i++) {
				String tbtrongbang = table.getValueAt(i, 1) + "";
				if (tbtrongbang.equals(tbcanxoa.toString())) {
					try {
						table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thuchienHuytim() {
		while (true) {
			table = (DefaultTableModel) jTable.getModel();
			int soluongdong = table.getRowCount();
			if (soluongdong == 0)
				break;
			else
				table.removeRow(0);
		}
		for (ThueBao tb : this.quanliThueBao.getThueBaolist()) {
			this.themthuebaovaoBang(tb);

		}

	}

	public void laydulieutucsdl() {
		table.setRowCount(0);
		this.quanliThueBao.xoasach(tb);
		

		ArrayList<ThueBao> list = DAOthuebao.getinstance().selectAll();
		for (ThueBao tb : list) {
			this.themthuebaovaoBang(tb);
			this.quanliThueBao.insert(tb);

		}

	}

}












