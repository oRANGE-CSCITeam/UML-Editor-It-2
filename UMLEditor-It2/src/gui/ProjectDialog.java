package gui;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectDialog extends JDialog {
	private Manager manager;
	private JButton  doneButton;
	private JTextField nameTextField;
	private JTextField widthTextField;
	private JTextField heightTextField;
	private JLabel nameLabel;
	private JLabel widthLabel;
	private JLabel heightLabel;
	
	public ProjectDialog(Manager manager) {
		this.manager = manager;
		initComponents();
	}
	
	public void initComponents() {
		
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.setResizable(false);
		this.setSize(new Dimension(200, 250));
		this.setLayout(new FlowLayout());
		
		doneButton = new JButton("Done");
		nameTextField = new JTextField(10);
		widthTextField = new JTextField(10);
		heightTextField = new JTextField(10);
		nameLabel = new JLabel("Project Name");
		widthLabel = new JLabel("Canvas Width");
		heightLabel = new JLabel("Canvas Height");
		
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(widthLabel);
		this.add(widthTextField);
		this.add(heightLabel);
		this.add(heightTextField);
		this.add(doneButton);
		final CanvasNotification notify = new CanvasNotification(this, true);
		
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(isInteger(widthTextField.getText()) && isInteger(heightTextField.getText())) {
					manager.setProjectName(nameTextField.getText());
					manager.getGui().getViewTab().removeAll();
					manager.getGui().getViewTab().add(manager.getProjectName(), manager.getGui().getScrollContainer());
					manager.setCanvasWidth(Integer.parseInt(widthTextField.getText()));
					manager.setCanvasHeight(Integer.parseInt(heightTextField.getText()));
					manager.getGui().getView().setPreferredSize(new Dimension(manager.getCanvasWidth(), manager.getCanvasHeight()));
					dispose();
					manager.getGui().repaint();
				} else {
					notify.setVisible(true);
				}
			}
		});
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public JButton getDoneButton() {
		return doneButton;
	}

	public void setDoneButton(JButton doneButton) {
		this.doneButton = doneButton;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JTextField getWidthTextField() {
		return widthTextField;
	}

	public void setWidthTextField(JTextField widthTextField) {
		this.widthTextField = widthTextField;
	}

	public JTextField getHeightTextField() {
		return heightTextField;
	}

	public void setHeightTextField(JTextField heightTextField) {
		this.heightTextField = heightTextField;
	}
	
	
}
