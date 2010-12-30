package ch.hszt.mdp.pim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ch.hszt.mdp.pim.view.GuiMain;

/**
 * @author Marcel Nemeth Achtung! Model ist noch nicht implementiert. Habe das
 *         Model deswegen auskommentiert.
 * 
 */
public class GuiController implements ActionListener {

	// GUIModel model; // TODO Model implementieren
	GuiMain view;

	public GuiController(GuiMain view)// ,GridGUIModel model)
	{
		// this.model=model;
		this.view = view;
		view.ActionListeners(this);
	}

	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		if (action == "Exit") {
			System.exit(0);
		}
		if (action == "Save") {
			view.setButtonsOnSave();
			// model.writetodatabase(view.getTextFields());
			// model.writetodatabase(view.getAddressFields());
		}
		if (action == "Cancel") {
			view.setButtonsOnCancel();
			// view.setTextFields(model.readfromdatabase());
			// view.setAddressFields(model.readfromdatabase());
		}
		if (action == "Edit") {
			view.setButtonsOnEdit();
		}
		if (action == "New Contact") {
			view.setButtonsOnNew();
		}
		if (action == "About PIM") {
			view.showInfo();
		}
		if (action == "Select Data Source") {
			// dataSource muss dem Panel übergeben werden
			// DataSoureSelectionGui ds = new DataSoureSelectionGui(dataSource);
		}
		if (action == "About") {
		}
	}

	// Only for test purposes
	public static void main(String[] args) {
		// GridGUIModel model=new GridGUIModel();
		GuiMain view = new GuiMain();
		GuiController controller = new GuiController(view);
	}
}
