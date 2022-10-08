package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppPanel05_Order06Pay extends JPanel {
	
	private AppPanel05_Order07Save appPanel05_Order07Save = new AppPanel05_Order07Save();
	
	private JLabel lblNewLabel_01;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JPanel pnPayComplete;
	private JLabel lblPn1Background;
	private JLabel lblPayResult;
	private JPanel pnPayFailed;
	private JLabel lblPn2Background;
	private JLabel lblBtnSaveGo;

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
	public AppPanel05_Order06Pay() {
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		add(getLblBtnSidebar());
		add(getLblBtnBack());
		
		add(getLblNewLabel_01());
		add(getLblProfilePhoto());
		add(getLblBtnTabHome());
		add(getLblBtnTabOrder());
		add(getLblBtnTabGift());
		add(getLblBtnTabMypage());
		add(getLblHomeIndicator());
		add(getPnPayComplete());
		add(getPnPayFailed());
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
			lblNewLabel_01 = new JLabel("결제");
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
			lblBtnTabHome.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_home.png"));
			lblBtnTabHome.setBounds(1, 729, 94, 50);
		}
		return lblBtnTabHome;
	}
	private JLabel getLblBtnTabOrder() {
		if (lblBtnTabOrder == null) {
			lblBtnTabOrder = new JLabel("");
			lblBtnTabOrder.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_order.png"));
			lblBtnTabOrder.setBounds(95, 729, 94, 50);
		}
		return lblBtnTabOrder;
	}
	private JLabel getLblBtnTabGift() {
		if (lblBtnTabGift == null) {
			lblBtnTabGift = new JLabel("");
			lblBtnTabGift.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/tabbar_gift.png"));
			lblBtnTabGift.setBounds(187, 729, 94, 50);
		}
		return lblBtnTabGift;
	}
	private JLabel getLblBtnTabMypage() {
		if (lblBtnTabMypage == null) {
			lblBtnTabMypage = new JLabel("");
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
	private JPanel getPnPayComplete() {
		if (pnPayComplete == null) {
			pnPayComplete = new JPanel() {
				
			// 판넬 모서리 둥글게 하기 ----------------------------------------------------------------------------------------
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setColor(getBackground()); 							  // paint background
					g2.fillRoundRect(0, 0, getWidth() , getHeight(), 40, 40); // paint background
//					g2.setColor(getForeground());													  // paint border
//					g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcs.width, arcs.height); // paint border
					super.paintComponent(g); 
				}
			};
			pnPayComplete.setOpaque(false);
			// -----------------------------------------------------------------------------------------------------------

			pnPayComplete.setBounds(15, 270, 345, 208);
			pnPayComplete.setLayout(null);
			pnPayComplete.add(getLblPayResult());
			pnPayComplete.add(getLblBtnSaveGo());
			pnPayComplete.add(getLblPn1Background());
		}
		return pnPayComplete;
	}
	private JLabel getLblPn1Background() {
		if (lblPn1Background == null) {
			lblPn1Background = new JLabel("");
			lblPn1Background.setHorizontalAlignment(SwingConstants.CENTER);
			lblPn1Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_paycomplete_background.png"));
			lblPn1Background.setBounds(0, 0, 345, 208);
		}
		return lblPn1Background;
	}
	private JLabel getLblPayResult() {
		if (lblPayResult == null) {
			lblPayResult = new JLabel("");
			lblPayResult.setFont(new Font("SansSerif", Font.PLAIN, 17));
			lblPayResult.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPayResult.setBounds(155, 87, 67, 31);
		}
		return lblPayResult;
	}
	private JLabel getLblBtnSaveGo() {
		if (lblBtnSaveGo == null) {
			lblBtnSaveGo = new JLabel("");
			lblBtnSaveGo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					AppMain.frame.getContentPane().add(appPanel05_Order07Save);
				}
			});
			lblBtnSaveGo.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/btn_save_go.png"));
			lblBtnSaveGo.setBounds(107, 143, 134, 43);
		}
		return lblBtnSaveGo;
	}

	private JPanel getPnPayFailed() {
		if (pnPayFailed == null) {
			pnPayFailed = new JPanel() {
				
			// 판넬 모서리 둥글게 하기 ----------------------------------------------------------------------------------------
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setColor(getBackground()); 							  // paint background
					g2.fillRoundRect(0, 0, getWidth() , getHeight(), 40, 40); // paint background
//					g2.setColor(getForeground());													  // paint border
//					g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcs.width, arcs.height); // paint border
					super.paintComponent(g); 
				}
			};
			pnPayFailed.setOpaque(false);
			// -----------------------------------------------------------------------------------------------------------
			
			pnPayFailed.setBounds(15, 288, 345, 172);
			pnPayFailed.setLayout(null);
			pnPayFailed.add(getLblPn2Background());
			pnPayFailed.setVisible(false);
			
		}
		return pnPayFailed;
	}
	private JLabel getLblPn2Background() {
		if (lblPn2Background == null) {
			lblPn2Background = new JLabel("");
			lblPn2Background.setHorizontalAlignment(SwingConstants.CENTER);
			lblPn2Background.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/src/com/noon/app/pn_payfailed_background.png"));
			lblPn2Background.setBounds(0, 0, 345, 172);
		}
		return lblPn2Background;
	}
	
	
	
} // End