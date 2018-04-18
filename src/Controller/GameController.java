package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Exceptions.ConditionsUnfullfiled;
import Exceptions.NegativeAmountOfCoins;
import GUI.GameView;
import GameModel.BuildingTypes;
import GameModel.GameModel;
import GameModel.Memento;

public class GameController implements ActionListener
{
	
	private GameView view;
	private GameModel model;

	public GameController(GameView view, GameModel gameModel)
	{
		this.model = gameModel;
		this.view = view;
		this.view.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Memento memento = model.saveStateToMemento();
		
		try {
			model.getBuildingManager().build(BuildingTypes.valueOf(e.getActionCommand()));
		} catch (NegativeAmountOfCoins e1) {
			model.setStateFromMemento(memento);
			JOptionPane.showMessageDialog(null, "Ma³o gelda","Unfal", JOptionPane.PLAIN_MESSAGE);
		} catch (ConditionsUnfullfiled e1)
		{
			JOptionPane.showMessageDialog(null, "Mosz mieæ cha³pe i kamieniolom coby postawiæ","Unfal", JOptionPane.PLAIN_MESSAGE);
			model.setStateFromMemento(memento);
		}
		memento = null;
		
	}
}
