package com.noon.form.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.noon.dao.DaoHire;
import com.noon.dao.DaoSignUp;
import com.noon.dao.DaoStaff;
import com.noon.swing.ImageAvatar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerForm2 extends JPanel {
	private JLabel lblNewLabel_1;
	private ImageAvatar imageAvatar;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfPhone;
	private JTextField tfDebitno;
	private JLabel lblCheckId;
	private String filepath ="";

	/**
	 * Create the panel.
	 */
	public ManagerForm2() {
		setBackground(new Color(250, 223, 187));
		setForeground(new Color(253, 235, 171));
		setOpaque(false);
		setLayout(null);
		add(getImageAvatar());

		JLabel lblNewLabel = new JLabel("알바 등록");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel.setBounds(44, 30, 132, 60);
		add(lblNewLabel);

		tfId = new JTextField();
		tfId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				checkId();
			}
		});
		tfId.setBackground(new Color(255, 255, 255));
		tfId.setBounds(118, 106, 300, 41);
		add(tfId);
		tfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(45, 108, 61, 30);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("이름");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(45, 177, 61, 30);
		add(lblNewLabel_2_1);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(118, 175, 300, 41);
		add(tfName);

		JLabel lblNewLabel_2_1_1 = new JLabel("전화번호");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(21, 246, 85, 30);
		add(lblNewLabel_2_1_1);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(118, 244, 300, 41);
		add(tfPhone);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("계좌번호");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(21, 313, 85, 30);
		add(lblNewLabel_2_1_1_1);

		tfDebitno = new JTextField();
		tfDebitno.setColumns(10);
		tfDebitno.setBounds(118, 311, 300, 41);
		add(tfDebitno);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkTf(); // 이거 true면 insertAction 실시
			}
		});
		ImageIcon icon = new ImageIcon((ManagerForm2.class.getResource("/com/noon/icon/register.png")));
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(150, 40, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(changeImg));
		lblNewLabel_3.setBounds(268, 430, 150, 40);
		add(lblNewLabel_3);

		JLabel lblRegisterImage = new JLabel("이미지 변경하기");
		lblRegisterImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FilePath();
			}
		});
		// 커서 클릭모양으로 바꾸기
		lblRegisterImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Font font = lblRegisterImage.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblRegisterImage.setFont(font.deriveFont(attributes));
		lblRegisterImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterImage.setBounds(550, 355, 113, 16);
		add(lblRegisterImage);
		
		lblCheckId = new JLabel("");
		lblCheckId.setBounds(118, 141, 300, 22);
		add(lblCheckId);
	}

	private void insertAction() {
		FileInputStream input = null;
		File file = null;

		if (!filepath.equals("")) {
			file = new File(filepath);
		} else {
			file = new File("./src/com/noon/icon/bigperson.png");
		}

		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// DaoStaff 의 insertStaff();
		DaoStaff dao = new DaoStaff(tfId.getText().trim(), tfName.getText().trim(), tfPhone.getText().trim(),
				tfDebitno.getText().trim(), input);
		int num = dao.insertStaff();
		// DaoHire 의 insertHire();
		if (num == 1) {
			DaoHire dao1 = new DaoHire(tfId.getText().trim());
			dao1.insertHire();
		}
	}

	private ImageAvatar getImageAvatar() {
		if (imageAvatar == null) {
			imageAvatar = new ImageAvatar();
			imageAvatar.setIcon(new ImageIcon(getClass().getResource("/com/noon/icon/bigperson.png")));
			imageAvatar.setBounds(476, 87, 256, 256);
		}
		return imageAvatar;
	}

	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "PNG", "BMP", "jpg", "png", "bmp");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		filepath = chooser.getSelectedFile().getPath();

		imageAvatar.setIcon(new ImageIcon(filepath));
		imageAvatar.repaint();
	}

	private void checkTf() {
		String empty = "";
		int i = 0;
		int tf = 0;
		try {
			if (tfPhone.getText().trim().length() != 0) {
				tf = 1;
				int check = Integer.parseInt(tfPhone.getText().trim());
			}
			if (tfDebitno.getText().trim().length() != 0) {
				tf = 2;
				int check = Integer.parseInt(tfDebitno.getText().trim());
			}

			if (tfId.getText().trim().length() == 0) {
				empty = "ID";
				i++;
			} else if (tfName.getText().trim().length() == 0) {
				empty = "이름";
				i++;
			} else if (tfPhone.getText().trim().length() == 0) {
				empty = "전화번호";
				i++;
			} else if (tfDebitno.getText().trim().length() == 0) {
				empty = "계좌번호";
				i++;
			}

			if (i == 0) {
				JOptionPane.showConfirmDialog(null, "등록완료되었습니다.");
				insertAction();
				clearTf();
			} else {
				JOptionPane.showConfirmDialog(null, empty + "를 입력해주세요.");
				return;
			}

		} catch (NumberFormatException e) {
			if(tf == 1) {
				tfPhone.setText("");
			}
			if(tf == 2) {
				tfDebitno.setText("");
			}
			JOptionPane.showConfirmDialog(null, "숫자만 입력해주세요.");
		}
	}
	
	public void clearTf() {
		tfDebitno.setText("");
		tfId.setText("");
		tfName.setText("");
		tfPhone.setText("");
	}
	
	private boolean checkId() {
		DaoStaff dao = new DaoStaff(tfId.getText().trim());
		boolean result = dao.checkId();

		if (result) {
			lblCheckId.setText("생성 가능한 아이디입니다.");
			lblCheckId.setForeground(new Color(0, 0, 255));
		} else {
			lblCheckId.setText("이미 존재하거나 탈퇴한 아이디입니다.");
			lblCheckId.setForeground(new Color(255, 0, 0));
		}

		return result;
	}
	
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(new Color(255, 255, 255, 100));

		super.paintChildren(g);
	}
}
