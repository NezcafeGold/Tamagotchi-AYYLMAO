package ru.nz.tamagotchi.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import ru.nz.tamagotchi.pet.Pet;

public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnEat, btnSleep, btnHappy, btnOK, btnNewGame;
	JProgressBar pbFood, pbEnergy, pbHealth, pbHappy;
	JLabel lFood, lEnergy, lHealth, lHappy, lName;
	JTextField tfName;

	
	KeyListener listen = new KeyListener();
	
	Pet pet;
	public MyPanel() {
		setLayout(null);
		
		btnEat = new JButton("Eat");
		btnEat.setBounds(480, 11, 89, 30);
		btnEat.addActionListener(listen);
		add(btnEat);

		btnSleep = new JButton("Sleep");
		btnSleep.setBounds(480, 52, 89, 30);
		btnSleep.addActionListener(listen);
		add(btnSleep);

		btnHappy = new JButton("Play");
		btnHappy.setBounds(480, 93, 89, 30);
		btnHappy.addActionListener(listen);
		add(btnHappy);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(300, 175, 89, 30);
		btnOK.addActionListener(listen);
		add(btnOK);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(480, 690, 89, 30);
		btnNewGame.addActionListener(listen);
		add(btnNewGame);
		
		pbFood = new JProgressBar();
		pbFood.setBounds(70, 11, 146, 14);
		pbFood.setMinimum(0);
		pbFood.setMaximum(100);
		pbFood.setValue(Main.pet.getHunger());
		pbFood.setStringPainted(true);
		add(pbFood);
		
		pbEnergy = new JProgressBar();
		pbEnergy.setBounds(70, 52, 146, 14);
		pbEnergy.setMinimum(0);
		pbEnergy.setMaximum(100);
		pbEnergy.setValue(Main.pet.getEnergy());
		pbEnergy.setStringPainted(true);
		add(pbEnergy);
		
		pbHealth = new JProgressBar();
		pbHealth.setBounds(70, 93, 146, 14);
		pbHealth.setMinimum(0);
		pbHealth.setMaximum(100);
		pbHealth.setValue(Main.pet.getHealth());
		pbHealth.setStringPainted(true);
		add(pbHealth);
		
		pbHappy = new JProgressBar();
		pbHappy.setBounds(70, 134, 146, 14);
		pbHappy.setMinimum(0);
		pbHappy.setMaximum(100);
		pbHappy.setValue(Main.pet.getHappy());
		pbHappy.setStringPainted(true);
		add(pbHappy);
		
		tfName = new JTextField();
		tfName.setBounds(70, 175, 146, 20);
		tfName.setVisible(true);
		add(tfName);
				
		lFood = new JLabel();
		lFood.setText("�����");
		lFood.setBounds(15, 11, 146, 14);
		add(lFood);
		
		lEnergy = new JLabel();
		lEnergy.setText("�������");
		lEnergy.setBounds(15, 52, 146, 14);
		add(lEnergy);
		
		lHealth = new JLabel();
		lHealth.setText("��������");
		lHealth.setBounds(15, 93, 146, 14);
        add(lHealth);
        
        lHappy = new JLabel();
        lHappy.setText("�������");
        lHappy.setBounds(15, 134, 146, 14);
        add(lHappy);
        
        lName = new JLabel();
        lName.setText(Main.pet.getName());
        lName.setVisible(true);
        lName.setBounds(300, 50, 250, 50);
        lName.setFont(new Font("Ariel", 2, 24));
        add(lName);
        
	}

	public void unvisibleName(){
		if (Main.pet.getName() != null) {
			btnOK.setVisible(false);
			tfName. setVisible(false);
		}
	}
	
	public void updatePB(){
		pbFood.setValue(Main.pet.getHunger());
		pbEnergy.setValue(Main.pet.getEnergy());
		pbHealth.setValue(Main.pet.getHealth());
		pbHappy.setValue(Main.pet.getHappy());
		lName.setText(Main.pet.getName());
	}
	


	class KeyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == (btnEat)) {
				Main.pet.feed();
				pbFood.setValue(Main.pet.getHunger());

			}

			if (e.getSource() == (btnSleep)) {
				Main.pet.sleep();
				pbEnergy.setValue(Main.pet.getEnergy());

			}
			if (e.getSource() == (btnHappy)) {
				Main.pet.happy();
			}
			
			if (e.getSource() == (btnOK)) {
				Main.pet.setName(tfName.getText());
				tfName.setVisible(false);
				btnOK.setVisible(false);
				lName.setText(tfName.getText());
				System.out.println(Main.pet.getName());
			}
			
			if (e.getSource() == (btnNewGame)) {
					Main.pet.newGame();
					tfName.setVisible(true);
					tfName.setText(null);
					btnOK.setVisible(true);
					updatePB();
			}

		}

	}
	
}
