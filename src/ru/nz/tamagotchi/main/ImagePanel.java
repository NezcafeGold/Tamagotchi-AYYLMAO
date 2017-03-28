package ru.nz.tamagotchi.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ImagePanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer timer = new Timer(5000, this);
	Timer timerpaint = new Timer(1, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			
		}
	} );
	Thread t1 = new Thread(new MyThread());

	private Image image;
	Image petpic;
	static int x = 150, y = 300;

	public ImagePanel() {
		(new SaveAndLoad()).load();
		timer.start();
		timerpaint.start();
		t1.start();
		try {
			petpic = ImageIO.read(new File("pics/alien3.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (image != null) {
			g.drawImage(image, 0, 100, 1000, 600, null);

		}
		if (petpic != null) {
			g.drawImage(petpic, x, 430, 160, 240, null);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Main.pet.noFood();
		Main.pet.noSleep();
		Main.panel.updatePB();
		(new SaveAndLoad()).save();
	
		repaint();

	}
}