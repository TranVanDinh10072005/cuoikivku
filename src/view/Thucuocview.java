package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.jdbc;
import model.ThueBao;

public class Thucuocview extends JFrame {
	private int sophut;
    private JComboBox<String> jComboBox_nhaMangthucuoc;

    public Thucuocview() {
        this.sophut = sophut;
        this.init();
    }

    private void init() {
        this.setTitle("Thu cước");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel jPanel_thuuoc = new JPanel();
        jPanel_thuuoc.setLayout(new GridLayout(1, 4,15,15));
        
        Font f = new Font("Arial", Font.BOLD,30);
        Font f2 = new Font("Arial", Font.BOLD,20);
        Font f3 = new Font("Arial", Font.PLAIN,10);
        

        JLabel jLabel_nhaMangthucuoc = new JLabel("Nhà Mạng:");
        String[] cacNhaMang = new String[] { "MobiFone", "Viettel", "Vinaphone", "Vietnamobile", "Gmobile" };
        jComboBox_nhaMangthucuoc = new JComboBox<String>(cacNhaMang);
        JLabel jLable_sdtthucuoc = new JLabel("Số diện thoại:");
        JTextField jTextField_thucuoc_sdt = new JTextField(10);
        JButton jButton_kiemtra = new JButton("Kiểm tra");
        jButton_kiemtra.setFont(f2);
        JButton jButton_exit = new JButton("Thoát");
        jButton_exit.setFont(f3);
        jButton_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
				
			}
		});
        JLabel jLabel = new JLabel("",JLabel.CENTER);
        jLabel.setFont(f);
        JLabel jLabel_null = new JLabel();
        JLabel jLabel_null1 = new JLabel();
        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());
        JTextField jTextField_soPhut = new JTextField();
        JLabel jLabel_soPhut = new JLabel("Số phút:");
        JPanel jPanel_sophut = new JPanel();
        jPanel_sophut.setLayout(new GridLayout(1,4));
        jPanel_sophut.add(jLabel_null1);
        jPanel_sophut.add(jLabel_soPhut);
        jPanel_sophut.add(jTextField_soPhut);
        jPanel_sophut.add(jLabel_null);
        jPanel_center.add(jPanel_sophut, BorderLayout.NORTH);
        JPanel jPanel_kq = new JPanel();
        jPanel_kq.setLayout(new GridLayout(2,1));
        JLabel jLabel2 = new JLabel("Phí ước tính là:",JLabel.CENTER);
        jLabel2.setFont(f);
        jPanel_kq.add(jLabel2);
        jPanel_kq.add(jLabel);
        
        JPanel jPanel_kt = new JPanel();
        JPanel jPanel_null2 = new JPanel();
        JPanel jPanel_null3 = new JPanel();
        jPanel_kt.setLayout(new GridLayout(1,3));
        jPanel_kt.add(jPanel_null2);
        jPanel_kt.add(jButton_kiemtra);
        JPanel jPanel_exit = new JPanel();
        jPanel_exit.setLayout(new GridLayout(1,2));
        jPanel_exit.add(jPanel_null3);
        jPanel_exit.add(jButton_exit);
        jPanel_kt.add(jPanel_exit);
        
        
        jPanel_center.add(jPanel_kq,BorderLayout.CENTER);
        
        

        jButton_kiemtra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                try {
                	
					String selectedNhaMang = jComboBox_nhaMangthucuoc.getSelectedItem()+"";
					
					int soPhut = Integer.valueOf(jTextField_soPhut.getText());
					if (selectedNhaMang.equals("MobiFone")) {
					    jLabel.setText(soPhut*1.18+"VNĐ");
					} else if (selectedNhaMang.equals("Viettel")) {
					    jLabel.setText(soPhut*1.19+"VNĐ");
					} else if (selectedNhaMang.equals("Vinaphone")) {
					    jLabel.setText(soPhut*1.18+"VNĐ");
					} else if (selectedNhaMang.equals("Vietnamobile")) {
					    jLabel.setText(soPhut*1.2+"VNĐ");
					} else if (selectedNhaMang.equals("Gmobile")) {
					    jLabel.setText(soPhut*1.3+"VNĐ");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(Thucuocview.this, "Vui lòng nhập số phút hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
            }
        });

        jPanel_thuuoc.add(jLabel_nhaMangthucuoc);
        jPanel_thuuoc.add(jComboBox_nhaMangthucuoc);
        jPanel_thuuoc.add(jLable_sdtthucuoc);
        jPanel_thuuoc.add(jTextField_thucuoc_sdt);

        this.add(jPanel_thuuoc, BorderLayout.NORTH);
        this.add(jPanel_center, BorderLayout.CENTER);
        this.add(jPanel_kt, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
