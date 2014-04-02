package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

public class Gui extends JFrame
				implements MouseListener, ActionListener{
	private Manager manager;
	private EditorView view;
	private AddRelationship addRelationshipDialog;
	private EditRelationship editRelationshipDialog;
	private AddClass addClassDialog;
	private AddAttribute addAttributeDialog;
	private AddOperation addoperationDialog;
	
	JToggleButton classButton;
	JMenuItem Undo;
	JMenuItem Redo;
	
	public Gui(Manager manager1) {
		
		this.setDefaultLookAndFeelDecorated(true);
		
		this.manager = manager1;
		
		this.setName("UML Editor (Iteration 2)");
		this.setLayout(new BorderLayout());
		JMenuBar darkGrayMenuBar = new JMenuBar();
		JPanel toolPanel = new JPanel();
		toolPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		toolPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JMenu fileMenu = new JMenu ("File");
		JMenuItem New = new JMenuItem("New", KeyEvent.VK_T);
		JMenuItem Open = new JMenuItem("Open", KeyEvent.VK_T);
		JMenuItem Save = new JMenuItem("Save", KeyEvent.VK_T);
		JMenuItem Quit = new JMenuItem("Quit", KeyEvent.VK_T);
		JMenu editMenu = new JMenu ("Edit");
		Undo = new JMenuItem("Undo", KeyEvent.VK_T);
		Redo = new JMenuItem("Redo", KeyEvent.VK_T);
		JMenuItem Copy = new JMenuItem("Copy", KeyEvent.VK_T);
		JMenuItem Paste = new JMenuItem("Paste", KeyEvent.VK_T);
		JMenuItem Clear = new JMenuItem("Clear", KeyEvent.VK_T);
		JMenuItem Delete = new JMenuItem("Delete", KeyEvent.VK_T);
		JPanel leftSidePanel = new JPanel();
		
		
		JButton undoButton = new JButton();
		undoButton.setIcon(new ImageIcon("src/resources/old_edit_undo.png"));
		JButton redoButton = new JButton();
		redoButton.setIcon(new ImageIcon("src/resources/old_edit_redo.png"));
		JButton test = new JButton("Test");
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		
	    
		classButton = new JToggleButton("Create Class");
		final JToggleButton RelationshipButton = new JToggleButton("Create Relationship");
		JButton organizeButton = new JButton("Organize");
		
		view = new EditorView(manager);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane();
		//frame.setSize(1000, 500);
		this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
		this.add(view, BorderLayout.CENTER);
		
		
		//--set initial window positions-------------
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setLocation((dim.width-frame.getWidth()), (dim.height-frame.getHeight()));
		//frame.setSize(dim.width, dim.height);
		this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
		
		//creates the Menu Bar
		//JMenuBar darkGrayMenuBar = new JMenuBar();
		//this.add(darkGrayMenuBar, BorderLayout.NORTH);
		
		//Adds Menu bar and toolbar to north
		this.add(BorderLayout.NORTH,northPanel);
		this.setJMenuBar(darkGrayMenuBar);
		northPanel.add(BorderLayout.NORTH, toolPanel);
			
		
		//darkGrayMenuBar.setOpaque(true);
		//darkGrayMenuBar.setBackground(Color.lightGray);
		//darkGrayMenuBar.setPreferredSize(new Dimension(1000,20));
		
		//Creates the tools bar
		//this.add(BorderLayout.EAST,toolPanel);
		
		//toolPanel.setPreferredSize(new Dimension(30,30));
		toolPanel.setVisible(true);
		
		//Add buttons to tool bar
		//toolPanel.add(Box.createRigidArea(new Dimension(0,1)));
		
		toolPanel.add(undoButton);
		toolPanel.add(redoButton);
		toolPanel.add(test);
		
		
		
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.getUndoRedoManager().undo();
			}
		});
		
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.getUndoRedoManager().redo();
			}
		});
		
		//creates File Menu
		//JMenu fileMenu = new JMenu ("File");
		fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription("File Options");
        darkGrayMenuBar.add(fileMenu);
        fileMenu.setVisible(true);  
		
		//add menuItems to File------------------------------------------------------------------------------------------------------------------------------
        
        //new
        //JMenuItem New = new JMenuItem("New", KeyEvent.VK_T);
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		fileMenu.add(New);
        
        //open
        //JMenuItem Open = new JMenuItem("Open", KeyEvent.VK_T);
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		fileMenu.add(Open);
		
		//save
		//JMenuItem Save = new JMenuItem("Save", KeyEvent.VK_T);
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		fileMenu.add(Save);
		
		//quit
		//JMenuItem Quit = new JMenuItem("Quit", KeyEvent.VK_T);
        Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		fileMenu.add(Quit);
		Quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		
		
		//end adding menuItems to File-------------------------------------------------------------------------------------------------------------------------
		
		//creates Edit Menu
		//JMenu editMenu = new JMenu ("Edit");
		editMenu.setMnemonic(KeyEvent.VK_N);
        editMenu.getAccessibleContext().setAccessibleDescription("Edit Options");
        darkGrayMenuBar.add(editMenu);
        
        //add menuItems to Edit~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //undo
        //JMenuItem Undo = new JMenuItem("Undo", KeyEvent.VK_T);
        Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		editMenu.add(Undo);
		
		Undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.getUndoRedoManager().undo();
			}
		});
		
        //re-do
		//JMenuItem Redo = new JMenuItem("Redo", KeyEvent.VK_T);
        Redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		editMenu.add(Redo);
		
		Redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				manager.getUndoRedoManager().redo();
			}
		});
		
        //copy
		//JMenuItem Copy = new JMenuItem("Copy", KeyEvent.VK_T);
        Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		editMenu.add(Copy);
		
        //paste
		//JMenuItem Paste = new JMenuItem("Paste", KeyEvent.VK_T);
        Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
		editMenu.add(Paste);
		
        //clear
		//JMenuItem Clear = new JMenuItem("Clear", KeyEvent.VK_T);
        Clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.CTRL_MASK));
		editMenu.add(Clear);
		
        //delete  (grays out when nothing selected) 
		//JMenuItem Delete = new JMenuItem("Delete", KeyEvent.VK_T);
        Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.CTRL_MASK));
		editMenu.add(Delete);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.deleteClass();
			}
		});
		
		//end  adding MenuItems to Edit~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		
		
		//Left Side Panel
		//JPanel leftSidePanel = new JPanel();
		this.add(leftSidePanel, BorderLayout.WEST);
		leftSidePanel.setBackground(Color.gray);
		leftSidePanel.setPreferredSize(new Dimension(200,100));
		leftSidePanel.setLayout(new BoxLayout(leftSidePanel, BoxLayout.Y_AXIS));
		
		//Create Class Toggle Button
		//JToggleButton classButton = new JToggleButton("Create Class");
		leftSidePanel.add(classButton);
		classButton.setPreferredSize(new Dimension(200, 25)); //tries but doesn't set correct size (over-ruled)
		classButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				if (classButton.isSelected()){
					RelationshipButton.setSelected(false);
					manager.setCanAddClass(true);
				}
			}
		});
		
		//Create Relationship Toggle Button
		//JToggleButton RelationshipButton = new JToggleButton("Create Relationship");
		leftSidePanel.add(RelationshipButton);
		RelationshipButton.setPreferredSize(new Dimension(200, 25)); //tries but doesn't set correct size (over-ruled)
		RelationshipButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				if (RelationshipButton.isSelected()){
					classButton.setSelected(false);
				}
			}
		});
		
		//JButton organizeButton = new JButton("Organize");
		leftSidePanel.add(organizeButton);
		organizeButton.setPreferredSize(new Dimension(200, 25));
		

		//Create new instance of dialogs
		addRelationshipDialog = new AddRelationship();
		editRelationshipDialog = new EditRelationship();
		addClassDialog = new AddClass(manager);
		addAttributeDialog = new AddAttribute();
		addoperationDialog = new AddOperation();
		
		//Set the frame visible at the end when everything is added
		this.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public EditorView getView() {
		return view;
	}

	public AddRelationship getAddRelationshipDialog() {
		return addRelationshipDialog;
	}

	public EditRelationship getEditRelationshipDialog() {
		return editRelationshipDialog;
	}

	public AddClass getAddClassDialog() {
		return addClassDialog;
	}

	public AddAttribute getAddAttributeDialog() {
		return addAttributeDialog;
	}

	public AddOperation getAddoperationDialog() {
		return addoperationDialog;
	}

	public JToggleButton getClassButton() {
		return classButton;
	}

	public JMenuItem getUndo() {
		return Undo;
	}

	public JMenuItem getRedo() {
		return Redo;
	}
		
}