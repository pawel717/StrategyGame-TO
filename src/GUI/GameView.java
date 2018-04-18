package GUI;

import javax.swing.JPanel;

import Controller.GameController;
import GameModel.GameModel;
import Interfaces.IObserver;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class GameView extends JPanel implements IObserver
{
	private List <JButton> buttons;
	private GameModel model;
	private JLabel label;

	/**
	 * Create the panel.
	 * 
	 */
	public GameView(GameModel model) 
	{
		this.model = model;
		buttons = new ArrayList <JButton>();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCoins = new JLabel("Gelt:");
		GridBagConstraints gbc_lblCoins = new GridBagConstraints();
		gbc_lblCoins.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoins.gridx = 0;
		gbc_lblCoins.gridy = 0;
		add(lblCoins, gbc_lblCoins);
		
		
		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		label.setText(String.valueOf(model.getCoinManager().getCoins()));
		add(label, gbc_label);
		
		JButton btnQuarry = new JButton("Kamienio³om");
		btnQuarry.setActionCommand("Quarry");
		GridBagConstraints gbc_btnQuarry = new GridBagConstraints();
		gbc_btnQuarry.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuarry.gridx = 0;
		gbc_btnQuarry.gridy = 1;
		add(btnQuarry, gbc_btnQuarry);
		buttons.add(btnQuarry);
		
		JButton btnBuilding_1 = new JButton("Cha³pa drwala");
		btnBuilding_1.setActionCommand("LumbermansCabin");
		GridBagConstraints gbc_btnBuilding_1 = new GridBagConstraints();
		gbc_btnBuilding_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuilding_1.gridx = 1;
		gbc_btnBuilding_1.gridy = 1;
		add(btnBuilding_1, gbc_btnBuilding_1);
		buttons.add(btnBuilding_1);
		
		JButton btnBuilding = new JButton("Tartak");
		btnBuilding.setActionCommand("Sawmill");
		GridBagConstraints gbc_btnBuilding = new GridBagConstraints();
		gbc_btnBuilding.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuilding.gridx = 2;
		gbc_btnBuilding.gridy = 1;
		add(btnBuilding, gbc_btnBuilding);
		buttons.add(btnBuilding);
		
		JButton btnGoldmine = new JButton("Zuoto gruba");
		btnGoldmine.setActionCommand("GoldMine");
		GridBagConstraints gbc_btnGoldmine = new GridBagConstraints();
		gbc_btnGoldmine.insets = new Insets(0, 0, 5, 5);
		gbc_btnGoldmine.gridx = 3;
		gbc_btnGoldmine.gridy = 1;
		add(btnGoldmine, gbc_btnGoldmine);
		buttons.add(btnGoldmine);
		
		JButton btnMint = new JButton("Mennica");
		btnMint.setActionCommand("Mint");
		GridBagConstraints gbc_btnMint = new GridBagConstraints();
		gbc_btnMint.insets = new Insets(0, 0, 5, 0);
		gbc_btnMint.gridx = 4;
		gbc_btnMint.gridy = 1;
		add(btnMint, gbc_btnMint);
		buttons.add(btnMint);
		
	}

	public void addActionListener(GameController gameController)
	{
		for(JButton button : buttons)
			button.addActionListener(gameController);
	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		label.setText(String.valueOf(model.getCoinManager().getCoins()));
		super.paintComponent(graphics);
	}
	
	@Override
	public void update()
	{
		repaint();
	}

}
