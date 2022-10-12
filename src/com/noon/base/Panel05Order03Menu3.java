package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.ScrollPaneConstants;

public class Panel05Order03Menu3 extends JPanel {
	
	private JLabel lblNewLabel_01;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	
	// -- Table Definition
	private final DefaultTableModel OuterTable = new DefaultTableModel(); // ******* 테이블 세팅(1/2)
	private JScrollPane scrollPane;
	private JTable InnerTable;
	
	private DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성/ 테이블가운데정렬에 필요
	private JLabel lblBtnSelect;
	private JLabel lblBtnGoCart;
	private JLabel lblTotalPrice;
	private JLabel lblCategoryAllMenu;
	private JLabel lblCategoryTea;
	private JLabel lblCategoryBeverage;
	private JLabel lblCategoryCoffee;


	// 바탕화면 그라데이션 -------------------------------------------------------------------------------
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), 0, getHeight(), Color.decode("#FAF3E0"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintChildren(g);
	}
	// ----------------------------------------------------------------------------------------------
	
	/**
	 * Create the panel.
	 */
	public Panel05Order03Menu3() {
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit(); 			// <--***************************************************
				makeTableData(); 		// <--***************************************************
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		add(getLblBtnGoCart());
		add(getLblBtnSidebar());
		add(getLblBtnBack());
		
		add(getLblNewLabel_01());
		add(getLblProfilePhoto());
		add(getLblBtnTabHome());
		add(getLblBtnTabOrder());
		add(getLblBtnTabGift());
		add(getLblHomeIndicator());
		add(getLblBtnTabMypage());
		add(getScrollPane());
		add(getLblBtnSelect());
		add(getLblTotalPrice());
		add(getLblCategoryAllMenu());
		add(getLblCategoryTea());
		add(getLblCategoryBeverage());
		add(getLblCategoryCoffee());
	}
	
	// 상단바 =============================================================================================================
	private JLabel getLblBtnSidebar() {
		if (lblBtnSidebar == null) {
			lblBtnSidebar = new JLabel("");
			lblBtnSidebar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnSidebar.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/icon_sidebar.png"));
			lblBtnSidebar.setBounds(13, 26, 36, 32);
		}
		return lblBtnSidebar;
	}
	private JLabel getLblBtnBack() {
		if (lblBtnBack == null) {
			lblBtnBack = new JLabel("");
			lblBtnBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnBack.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}
	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("장바구니");
			lblNewLabel_01.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_01.setForeground(new Color(176, 108, 89));
			lblNewLabel_01.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_01.setBounds(131, 26, 115, 37);
		}
		return lblNewLabel_01;
	}
	private JLabel getLblProfilePhoto() {
		if (lblProfilePhoto == null) {
			lblProfilePhoto = new JLabel("");
			lblProfilePhoto.setHorizontalAlignment(SwingConstants.TRAILING);
			lblProfilePhoto.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/profile_photo.png"));
			lblProfilePhoto.setBounds(322, 26, 36, 36);
		}
		return lblProfilePhoto;
	}
	// ==================================================================================================================

	// Tabbar ===========================================================================================================
	private JLabel getLblBtnTabHome() {
		if (lblBtnTabHome == null) {
			lblBtnTabHome = new JLabel("");
			lblBtnTabHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel03Home());
				}
			});
			lblBtnTabHome.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_home.png"));
			lblBtnTabHome.setBounds(1, 729, 94, 50);
		}
		return lblBtnTabHome;
	}
	private JLabel getLblBtnTabOrder() {
		if (lblBtnTabOrder == null) {
			lblBtnTabOrder = new JLabel("");
			lblBtnTabOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order01Shop());
				}
			});
			lblBtnTabOrder.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_order.png"));
			lblBtnTabOrder.setBounds(95, 729, 94, 50);
		}
		return lblBtnTabOrder;
	}
	private JLabel getLblBtnTabGift() {
		if (lblBtnTabGift == null) {
			lblBtnTabGift = new JLabel("");
			lblBtnTabGift.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel06Gift());
				}
			});
			lblBtnTabGift.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_gift.png"));
			lblBtnTabGift.setBounds(187, 729, 94, 50);
		}
		return lblBtnTabGift;
	}
	private JLabel getLblBtnTabMypage() {
		if (lblBtnTabMypage == null) {
			lblBtnTabMypage = new JLabel("");
			lblBtnTabMypage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel04MyPage());
				}
			});
			lblBtnTabMypage.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_mypage.png"));
			lblBtnTabMypage.setBounds(281, 729, 94, 50);
		}
		return lblBtnTabMypage;
	}
	private JLabel getLblHomeIndicator() {
		if (lblHomeIndicator == null) {
			lblHomeIndicator = new JLabel("");
			lblHomeIndicator.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/homeindicator.png"));
			lblHomeIndicator.setBounds(1, 778, 375, 34);
		}
		return lblHomeIndicator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(12, 164, 350, 448);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (InnerTable == null) {
			InnerTable = new JTable() { 								// <--****************
				public Class getColumnClass(int column) { 				// <--****************
			        return (column == 0) ? Icon.class : Object.class; 	// <--****************
			      }
			};
			InnerTable.setBackground(Color.decode("#F4F4F4"));
//			InnerTable.getTableHeader().setFont(new Font("San serif", Font.PLAIN, 16));
			InnerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			InnerTable.setRowHeight(80); 		// <--***************************************************
			InnerTable.setModel(OuterTable); 	// <--***************************************************

			cellAlignCenter.setHorizontalAlignment(JLabel.CENTER); // Center 정렬
			InnerTable.getTableHeader().setDefaultRenderer(cellAlignCenter); // Center 정렬
//			InnerTable.getColumn("상품명").setCellRenderer(cellAlignCenter); // 에러남 / 삭제예정
			
		}
		return InnerTable;
	}
	
	// Function
	
	// InitTable / 테이블 세팅 및 정리
	private void tableInit() {
		OuterTable.addColumn("사진"); // 1234
		OuterTable.addColumn("상품명"); // 1234
		OuterTable.addColumn("단가");
		OuterTable.addColumn("추가");
		OuterTable.addColumn("수량");
		OuterTable.addColumn("합계");
	
		OuterTable.setColumnCount(6); // 		***************
	
		int i = OuterTable.getRowCount();
		for (int j = 0; j < i; j++) {
			OuterTable.removeRow(0);
		}
	
		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF); // 리사이즈 못하게 정의
	
		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex); // 0번부터
		int width = 80;
		col.setPreferredWidth(width);
	
		vColIndex = 1;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);
	
		vColIndex = 2;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
	
		vColIndex = 4;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 30;
		col.setPreferredWidth(width);
	
		vColIndex = 5;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

	}

	
	
	private void makeTableData() {
		String[] images = {"cafelatte.png", "cafelatte.png", "cow.png", "dog.png", "fox.png", "monkey.png", "pig.png", "wolf.png"};
		String[] names = {"Americano", "카페라떼", "카페모카", "카라멜 마끼아또", "", "", "", ""};
		String[] price = {"5500", "4500", "25000", "3000", "", "", "", ""};
		String[] option = {"1500", "4500", "2500", "카라멜 마끼아또", "Fox", "Monkey", "Pig", "Wolf"};
		String[] quantity = {"3", "5", "2", "1", "1", "1", "1", "1"};
		String[] sum = {"25000", "4500원", "25000원", "25000", "10000", "25000", "5000", "4000"};
		
		
		for (int index = 0; index < images.length; index++) {
			ImageIcon icon = new ImageIcon(Main.class.getResource("/com/noon/images/"+images[index]));
			Object[] tempData = {icon, names[index], price[index], option[index], quantity[index], sum[index]};
			OuterTable.addRow(tempData);
		}
	}
	private JLabel getLblBtnSelect() {
		if (lblBtnSelect == null) {
			lblBtnSelect = new JLabel("");
			lblBtnSelect.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order04Option());
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnSelect.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_select_C.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnSelect.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_select.png"));
					
				}
			});
			lblBtnSelect.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_select.png"));

			lblBtnSelect.setBounds(13, 644, 316, 61);
		}
		return lblBtnSelect;
	}
	private JLabel getLblBtnGoCart() {
		if (lblBtnGoCart == null) {
			lblBtnGoCart = new JLabel("GoCartBtn");
			lblBtnGoCart.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order05Cart());
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnGoCart.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_go_cart_C.png"));
					
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnGoCart.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_go_cart2.png"));
				}
			});
			lblBtnGoCart.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_go_cart2.png"));
			lblBtnGoCart.setBounds(297, 644, 61, 61);
		}
		return lblBtnGoCart;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("select \"Total : 24000원\"");
			lblTotalPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalPrice.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblTotalPrice.setBounds(145, 618, 211, 19);
		}
		return lblTotalPrice;
	}
	private JLabel getLblCategoryCoffee() {
		if (lblCategoryCoffee == null) {
			lblCategoryCoffee = new JLabel("");
			lblCategoryCoffee.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryCoffee.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_coffee.png"));
			lblCategoryCoffee.setBounds(23, 78, 63, 81);
		}
		return lblCategoryCoffee;
	}
	private JLabel getLblCategoryBeverage() {
		if (lblCategoryBeverage == null) {
			lblCategoryBeverage = new JLabel("");
			lblCategoryBeverage.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryBeverage.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_beverage.png"));
			lblCategoryBeverage.setBounds(111, 78, 63, 81);
		}
		return lblCategoryBeverage;
	}
	private JLabel getLblCategoryTea() {
		if (lblCategoryTea == null) {
			lblCategoryTea = new JLabel("");
			lblCategoryTea.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryTea.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_tea.png"));
			lblCategoryTea.setBounds(202, 78, 63, 81);
		}
		return lblCategoryTea;
	}
	private JLabel getLblCategoryAllMenu() {
		if (lblCategoryAllMenu == null) {
			lblCategoryAllMenu = new JLabel("");
			lblCategoryAllMenu.setVerticalAlignment(SwingConstants.TOP);
			lblCategoryAllMenu.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/category_all_menu.png"));
			lblCategoryAllMenu.setBounds(292, 78, 63, 81);
		}
		return lblCategoryAllMenu;
	}



} // End