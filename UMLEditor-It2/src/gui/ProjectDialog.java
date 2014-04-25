package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectDialog extends JFrame {
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
		
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.setProjectName(nameTextField.getText());
				manager.getGui().getViewTab().removeAll();
				manager.getGui().getViewTab().add(manager.getProjectName(), manager.getGui().getScrollContainer());
				manager.setCanvasWidth(Integer.parseInt(widthTextField.getText()));
				manager.setCanvasHeight(Integer.parseInt(heightTextField.getText()));
				manager.getGui().getView().setPreferredSize(new Dimension(manager.getCanvasWidth(), manager.getCanvasHeight()));
				dispose();
				manager.getGui().repaint();
			}
		});
	}
}
