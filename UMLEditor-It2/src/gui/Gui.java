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
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

public class Gui extends JFrame implements MouseListener, ActionListener {
	private Manager manager;
	private EditorView view;
	private AddRelationship addRelationshipDialog;
	private EditRelationship editRelationshipDialog;
	private AddClass addClassDialog;
	private AddAttribute addAttributeDialog;
	private AddOperation addOperationDialog;
	private JPopupMenu popUpMenu;
	private JToggleButton classButton;
	private JToggleButton selectButton;
	JToggleButton relationshipButton;
	private JMenuItem Undo;
	private JMenuItem Redo;
	private JScrollPane scrollContainer;

	public Gui(Manager manager1) {

		this.setDefaultLookAndFeelDecorated(true);

		this.manager = manager1;

		this.setName("UML Editor (Iteration 2)");
		this.setLayout(new BorderLayout());
		JMenuBar darkGrayMenuBar = new JMenuBar();
		JPanel toolPanel = new JPanel();
		toolPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		toolPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMI = new JMenuItem("New", KeyEvent.VK_T);
		JMenuItem open = new JMenuItem("Open", KeyEvent.VK_T);
		JMenuItem save = new JMenuItem("Save", KeyEvent.VK_T);
		JMenuItem quit = new JMenuItem("Quit", KeyEvent.VK_T);
		JMenu editMenu = new JMenu("Edit");
		Undo = new JMenuItem("Undo", KeyEvent.VK_T);
		Redo = new JMenuItem("Redo", KeyEvent.VK_T);
		JMenuItem copy = new JMenuItem("Copy", KeyEvent.VK_T);
		JMenuItem paste = new JMenuItem("Paste", KeyEvent.VK_T);
		JMenuItem clear = new JMenuItem("Clear", KeyEvent.VK_T);
		JMenuItem delete = new JMenuItem("Delete", KeyEvent.VK_T);
		JPanel leftSidePanel = new JPanel();
		view = new EditorView(manager);
		scrollContainer = new JScrollPane(view);
		view.setAutoscrolls(true);
		JTabbedPane viewTab = new JTabbedPane();
		viewTab.addTab("Untitled", scrollContainer);

		view.setPreferredSize(scrollContainer.getSize());
		popUpMenu = new JPopupMenu();
		selectButton = new JToggleButton("Select");
		JButton undoButton = new JButton();
		undoButton.setIcon(new ImageIcon("src/resources/old_edit_undo.png"));
		JButton redoButton = new JButton();
		redoButton.setIcon(new ImageIcon("src/resources/old_edit_redo.png"));
		JButton test = new JButton("Test");

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());

		classButton = new JToggleButton("Create Class");
		relationshipButton = new JToggleButton("Create Relationship");
		JButton organizeButton = new JButton("Organize");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane();
		// frame.setSize(1000, 500);
		this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
		this.add(viewTab, BorderLayout.CENTER);

		// --set initial window positions-------------
		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// frame.setLocation((dim.width-frame.getWidth()),
		// (dim.height-frame.getHeight()));
		// frame.setSize(dim.width, dim.height);
		this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);

		// creates the Menu Bar
		// JMenuBar darkGrayMenuBar = new JMenuBar();
		// this.add(darkGrayMenuBar, BorderLayout.NORTH);

		// Adds Menu bar and toolbar to north
		this.add(BorderLayout.NORTH, northPanel);
		this.setJMenuBar(darkGrayMenuBar);
		northPanel.add(BorderLayout.NORTH, toolPanel);

		// darkGrayMenuBar.setOpaque(true);
		// darkGrayMenuBar.setBackground(Color.lightGray);
		// darkGrayMenuBar.setPreferredSize(new Dimension(1000,20));

		// Creates the tools bar
		// this.add(BorderLayout.EAST,toolPanel);

		// toolPanel.setPreferredSize(new Dimension(30,30));
		toolPanel.setVisible(true);

		// Add buttons to tool bar
		// toolPanel.add(Box.createRigidArea(new Dimension(0,1)));

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

		// creates File Menu
		// JMenu fileMenu = new JMenu ("File");
		fileMenu.setMnemonic(KeyEvent.VK_A);
		fileMenu.getAccessibleContext()
				.setAccessibleDescription("File Options");
		darkGrayMenuBar.add(fileMenu);
		fileMenu.setVisible(true);

		// add menuItems to
		// File------------------------------------------------------------------------------------------------------------------------------

		// new
		// JMenuItem New = new JMenuItem("New", KeyEvent.VK_T);
		newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		fileMenu.add(newMI);

		// open
		// JMenuItem Open = new JMenuItem("Open", KeyEvent.VK_T);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.ALT_MASK));
		fileMenu.add(open);

		// save
		// JMenuItem Save = new JMenuItem("Save", KeyEvent.VK_T);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.ALT_MASK));
		fileMenu.add(save);

		// quit
		// JMenuItem Quit = new JMenuItem("Quit", KeyEvent.VK_T);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.ALT_MASK));
		fileMenu.add(quit);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});

		// end adding menuItems to
		// File-------------------------------------------------------------------------------------------------------------------------

		// creates Edit Menu
		// JMenu editMenu = new JMenu ("Edit");
		editMenu.setMnemonic(KeyEvent.VK_N);
		editMenu.getAccessibleContext()
				.setAccessibleDescription("Edit Options");
		darkGrayMenuBar.add(editMenu);

		// add menuItems to
		// Edit~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// undo
		// JMenuItem Undo = new JMenuItem("Undo", KeyEvent.VK_T);
		Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				ActionEvent.CTRL_MASK));
		editMenu.add(Undo);

		Undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.getUndoRedoManager().undo();
			}
		});

		// re-do
		// JMenuItem Redo = new JMenuItem("Redo", KeyEvent.VK_T);
		Redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				ActionEvent.CTRL_MASK));
		editMenu.add(Redo);

		Redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.getUndoRedoManager().redo();
			}
		});

		// copy
		// JMenuItem Copy = new JMenuItem("Copy", KeyEvent.VK_T);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		editMenu.add(copy);

		// paste
		// JMenuItem Paste = new JMenuItem("Paste", KeyEvent.VK_T);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.CTRL_MASK));
		editMenu.add(paste);

		// clear
		// JMenuItem Clear = new JMenuItem("Clear", KeyEvent.VK_T);
		clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		editMenu.add(clear);

		// delete (grays out when nothing selected)
		// JMenuItem Delete = new JMenuItem("Delete", KeyEvent.VK_T);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				ActionEvent.CTRL_MASK));
		editMenu.add(delete);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.deleteClass();
			}
		});

		// end adding MenuItems to
		// Edit~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// Add menu items to popUpMenu
		popUpMenu.add(copy);
		popUpMenu.add(paste);
		popUpMenu.add(delete);

		// Left Side Panel
		// JPanel leftSidePanel = new JPanel();
		this.add(leftSidePanel, BorderLayout.WEST);
		leftSidePanel.setBackground(Color.gray);
		leftSidePanel.setPreferredSize(new Dimension(200, 100));
		leftSidePanel.setLayout(new BoxLayout(leftSidePanel, BoxLayout.Y_AXIS));

		// Create Select Toggle Button
		leftSidePanel.add(selectButton);
		selectButton.setPreferredSize(new Dimension(200, 25)); // tries but
																// doesn't set
																// correct size
																// (over-ruled)
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (selectButton.isSelected()) {
					relationshipButton.setSelected(false);
					classButton.setSelected(false);
					manager.setCanAddClass(false);
					manager.setTryRelationship(false);
				}
			}
		});

		// Create Class Toggle Button
		// JToggleButton classButton = new JToggleButton("Create Class");
		leftSidePanel.add(classButton);
		classButton.setPreferredSize(new Dimension(200, 25)); // tries but
																// doesn't set
																// correct size
																// (over-ruled)
		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (classButton.isSelected()) {
					relationshipButton.setSelected(false);
					selectButton.setSelected(false);
					manager.setTryRelationship(false);
				}
				if (manager.isCanAddClass()) {
					manager.setCanAddClass(false);
				} else {
					manager.setCanAddClass(true);
				}
			}
		});

		// Create Relationship Toggle Button
		// JToggleButton RelationshipButton = new
		// JToggleButton("Create Relationship");
		leftSidePanel.add(relationshipButton);
		relationshipButton.setPreferredSize(new Dimension(200, 25)); // tries
																		// but
																		// doesn't
																		// set
																		// correct
																		// size
																		// (over-ruled)
		relationshipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (relationshipButton.isSelected()) {
					classButton.setSelected(false);
					selectButton.setSelected(false);
					manager.setCanAddClass(false);
					manager.setTryRelationship(true);
				}
			}
		});

		// JButton organizeButton = new JButton("Organize");
		leftSidePanel.add(organizeButton);
		organizeButton.setPreferredSize(new Dimension(200, 25));

		// Create new instance of dialogs
		addRelationshipDialog = new AddRelationship(manager);
		editRelationshipDialog = new EditRelationship(manager);
		addClassDialog = new AddClass(manager);
		addAttributeDialog = new AddAttribute(manager);
		addOperationDialog = new AddOperation(manager);

		// Set the frame visible at the end when everything is added
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

	public AddOperation getAddOperationDialog() {
		return addOperationDialog;
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

	public JPopupMenu getPopUpMenu() {
		return popUpMenu;
	}

	public JToggleButton getSelectButton() {
		return selectButton;
	}

	public JScrollPane getScrollContainer() {
		return scrollContainer;
	}

	public JToggleButton getRelationshipButton() {
		return relationshipButton;
	}

}