package ch.hszt.mdp.pim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.hszt.mdp.pim.view.GuiMain;

public class GuiController implements ActionListener {

	// the controller listens for actions and reacts
	// GUIModel model; // TODO Model implementieren
	GuiMain view;

	public GuiController(GuiMain view)// ,GridGUIModel model)
	{
		// create the model and the GUI view
		// this.model=model;
		this.view = view;
		// Add action listener from this class to view buttons
		view.buttonActionListeners(this);
	}

	// Provide interactions for actions performed in the view
	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();

		if (action == "Exit") {
			System.exit(0);
		}
		if (action == "Save") {
			view.setButtonsOnSave();
			// saveData(editPerson, listIndex);
		}
		if (action == "Cancel") {
			view.setButtonsOnCancel();
			// view.changeData();
		}
		if (action == "Edit") {
			view.setButtonsOnEdit();
			// if (editPerson.getFirstName() != null) {
			// view.disableTextFields();
			// view.setData(editPerson);
			// }
		}
		if (action == "New Contact") {
			view.setButtonsOnNew();
			// view.changeData();
		}
		if (action == "About PIM") {
			view.showInfo();
		}
	}

	// Only for test purposes
	public static void main(String[] args) {
		// GridGUIModel model=new GridGUIModel();
		GuiMain view = new GuiMain();
		// GuiController controller = new GuiController(view);

	}
}
