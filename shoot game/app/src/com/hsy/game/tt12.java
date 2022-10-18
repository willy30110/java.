package com.hsy.game;

/*****************************************
UI程式設計範本
*************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

//想想還有沒有其他的東西要import
public class tt12 extends JFrame implements ActionListener, MouseMotionListener, MouseListener // 名稱改一改
{
	Container c;
	// 設定UI元件
	ImageIcon imgg = new ImageIcon("V-117819-9CE31F83.jpg");
	JButton bot;
	JLabel lab1, lab2;
	// 設定共用的變數與類別
	java.util.Random rg;
	int setx1, sety1, setx2, sety2, setx3, sety3, mode, ms;// mt時間,ms分數
	int swit = -1, imgnum = 0;
	double mt;
	javax.swing.Timer t;
	JFrame jf;

	public tt12() // 建構元，名稱改一改
	{

		super("SpiderShot");
		jf = this;
		// 初始化共用變數
		mode = 0;
		rg = new Random();
		c = getContentPane();// 取得ContentPane
		// 設定版面設定
		c.setLayout(new FlowLayout());
		// 初始化UI元件
		bot = new JButton("開始");
		JLabel lab = new JLabel(imgg);
		// lab.setBounds(0, 0, 2000, 10);
		lab1 = new JLabel("剩下:10秒");
		lab2 = new JLabel("成績:0");
		// 將UI元件加入ContentPanec.add(lab);

		this.getLayeredPane().add(lab);
		// 將背景標籤新增到jfram的LayeredPane面板裡。
		lab.setBounds(0, 0, imgg.getIconWidth(), imgg.getIconHeight());
		// 設定背景標籤的位置
		((JPanel) c).setOpaque(false);
		// 將內容面板設為透明。將LayeredPane面板中的背景顯示出來。

		c.add(lab1);
		c.add(bot);
		c.add(lab2);
		/* */c.add(lab);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage("img/picwish.png");
		Cursor cu = tk.createCustomCursor(image, new Point(20,10), "Test");
		setCursor(cu);
		c.setBounds(100, 100, 100, 100);
		c.setVisible(true);
		// 設定UI元件與滑鼠的事件觸發傾聽者
		bot.addActionListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		setResizable(false);
		t = new javax.swing.Timer(1000, this);
		setBounds(250, 100, 1280, 780);
		setVisible(true);

	}

	public void paint(Graphics g) {
		super.paint(g);// 畫出元件
		rg = new Random();
		rg.setSeed(new Date().getTime());
		int num1 = rg.nextInt(19);
		int num2 = rg.nextInt(19);
		int num3 = rg.nextInt(19);
		ImageIcon img1 = new ImageIcon("img/ha" + num1 + ".jpg");
		ImageIcon img2 = new ImageIcon("img/ha" + num2 + ".jpg");
		ImageIcon img3 = new ImageIcon("img/ha" + num3 + ".jpg");
		if (swit == 0) {
			if (imgnum == 0) {
				// JLabel showimg=new JLabel();
				// showimg.setIcon(img);
				setx1 = (int) (Math.random() * 1230) + 1;
				sety1 = (int) (Math.random() * 630) + 100;
				setx2 = (int) (Math.random() * 1230) + 1;
				sety2 = (int) (Math.random() * 630) + 100;
				setx3 = (int) (Math.random() * 1230) + 1;
				sety3 = (int) (Math.random() * 630) + 100;
			} else if (imgnum == 1) {
				num1 = rg.nextInt(13);
				img1 = new ImageIcon("img/ha" + num1 + ".jpg");
				setx1 = (int) (Math.random() * 1230) + 1;
				sety1 = (int) (Math.random() * 630) + 100;

			} else if (imgnum == 2) {
				num2 = rg.nextInt(13);
				img2 = new ImageIcon("img/ha" + num2 + ".jpg");
				setx2 = (int) (Math.random() * 1230) + 1;
				sety2 = (int) (Math.random() * 630) + 100;

			} else if (imgnum == 3) {
				num3 = rg.nextInt(13);
				img3 = new ImageIcon("img/ha" + num3 + ".jpg");
				setx3 = (int) (Math.random() * 1230) + 1;
				sety3 = (int) (Math.random() * 630) + 100;

			}
			img1.setImage(img1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			img2.setImage(img2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			img3.setImage(img3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			img1.paintIcon(this, g, setx1, sety1);
			img2.paintIcon(this, g, setx2, sety2);
			img3.paintIcon(this, g, setx3, sety3);
			// 額外的畫圖程式寫在這裡
		}
	}

	public void mouseDragged(MouseEvent xxx) {
	};

	public void mouseMoved(MouseEvent e) {
	};

	// UI元件事件處理類別寫在這裡
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bot) {
			mt = 10;
			ms = 0;
			t.start();
			lab1.setText("剩下:" + mt + "秒");
			lab2.setText("成績:" + ms);
			swit = 0;
			repaint();
		} else if (e.getSource() == t) {
			mt = mt - 1;
			lab1.setText("剩下:" + mt + "秒");
			if (mt == 0) {
				int mType = JOptionPane.QUESTION_MESSAGE;
				int oType = JOptionPane.YES_NO_CANCEL_OPTION;
				rg = new Random();
				rg.setSeed(new Date().getTime());
				int num = rg.nextInt(19);
				ImageIcon ha = new ImageIcon("img/ha" + num + ".jpg");
				ha.setImage(ha.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
				String[] options = { "重新開始", "離開" };
				int opt = JOptionPane.showOptionDialog(c, "成績:" + ms,
						"結算", oType, mType, ha, options, "離開");
				if (opt == JOptionPane.NO_OPTION) {
					jf.dispose();
				} else {
					t.stop();
					swit = -1;
					repaint();
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	};

	public void mouseExited(MouseEvent e) {
	};

	public void mousePressed(MouseEvent e) {
		int mx, my;
		mx = e.getX();
		my = e.getY();
		if ((setx1 + 25 - mx) * (setx1 + 25 - mx) + (sety1 + 25 - my) * (sety1 + 25 - my) < 250) // (mx>=setx &&
																									// mx<setx+50
																									// &&my>=sety &&
																									// my<sety+50)
		{
			ms = ms + 2;
			lab2.setText("成績:" + ms);
			imgnum = 1;
			repaint();
		} else if ((setx1 + 25 - mx) * (setx1 + 25 - mx) + (sety1 + 25 - my) * (sety1 + 25 - my) < 625 &&
				(setx1 + 25 - mx) * (setx1 + 25 - mx) + (sety1 + 25 - my) * (sety1 + 25 - my) >= 250) // (mx>=setx &&
																										// mx<setx+50
																										// &&my>=sety &&
																										// my<sety+50)
		{
			ms = ms + 1;
			lab2.setText("成績:" + ms);
			imgnum = 1;
			repaint();
		} else if ((setx2 + 25 - mx) * (setx2 + 25 - mx) + (sety2 + 25 - my) * (sety2 + 25 - my) < 250) // (mx>=setx &&
																										// mx<setx+50
																										// &&my>=sety &&
																										// my<sety+50)
		{
			ms = ms + 2;
			lab2.setText("成績:" + ms);
			imgnum = 2;
			repaint();
		} else if ((setx2 + 25 - mx) * (setx2 + 25 - mx) + (sety2 + 25 - my) * (sety2 + 25 - my) < 625 &&
				(setx2 + 25 - mx) * (setx2 + 25 - mx) + (sety2 + 25 - my) * (sety2 + 25 - my) >= 250) // (mx>=setx &&
																										// mx<setx+50
																										// &&my>=sety &&
																										// my<sety+50)
		{
			ms = ms + 1;
			lab2.setText("成績:" + ms);
			imgnum = 2;
			repaint();
		} else if ((setx3 + 25 - mx) * (setx3 + 25 - mx) + (sety3 + 25 - my) * (sety3 + 25 - my) < 250) // (mx>=setx &&
																										// mx<setx+50
																										// &&my>=sety &&
																										// my<sety+50)
		{
			ms = ms + 2;
			lab2.setText("成績:" + ms);
			imgnum = 3;
			repaint();
		} else if ((setx3 + 25 - mx) * (setx3 + 25 - mx) + (sety3 + 25 - my) * (sety3 + 25 - my) < 625 &&
				(setx3 + 25 - mx) * (setx3 + 25 - mx) + (sety3 + 25 - my) * (sety3 + 25 - my) >= 250) // (mx>=setx &&
																										// mx<setx+50
																										// &&my>=sety &&
																										// my<sety+50)
		{
			ms = ms + 1;
			lab2.setText("成績:" + ms);
			imgnum = 3;
			repaint();
		}

	}

	public void mouseReleased(MouseEvent e) {
	};

	public void mouseClicked(MouseEvent e) {
	};

	// 滑鼠事件處理類別寫在這裡
	/*** 主程式 ***/
	public static void main(String args[]) // 程式起點
	{
		tt12 app = new tt12(); // 名稱改一改，啟動UI元件
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // 處理視窗關閉要求
	}
}