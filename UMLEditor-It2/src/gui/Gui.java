package gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;

import models.ClassObject;

public class Gui extends JFrame implements MouseListener, ActionListener {
	private Manager manager;
	private EditorView view;
	private AddRelationship addRelationshipDialog;
	private EditRelationship editRelationshipDialog;
	private AddClass addClassDialog;
	private EditClass editClassDialog;
	private AddAttribute addAttributeDialog;
	private AddOperation addOperationDialog;
	private JPopupMenu popUpMenu;
	private JToggleButton classButton;
	private JToggleButton selectButton;
	private JToggleButton relationshipButton;
	private JButton organizeButton;
	private JMenuItem Undo;
	private JMenuItem Redo;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem edit;
	private JMenuItem delete;
	private JScrollPane scrollContainer;
	private JMenuItem export;
	private ProjectDialog projectDialog;
	private JTabbedPane viewTab;
	
	JFileChooser exportFile;

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
		export = new JMenuItem("Export");
		JMenu editMenu = new JMenu("Edit");
		Undo = new JMenuItem("Undo", KeyEvent.VK_T);
		Redo = new JMenuItem("Redo", KeyEvent.VK_T);
		copy = new JMenuItem("Copy", KeyEvent.VK_T);
		paste = new JMenuItem("Paste", KeyEvent.VK_T);
		JMenuItem clear = new JMenuItem("Clear", KeyEvent.VK_T);
		edit = new JMenuItem("Edit", KeyEvent.VK_T);
		delete = new JMenuItem("Delete", KeyEvent.VK_T);
		JPanel leftSidePanel = new JPanel();
		view = new EditorView(manager);
		
		view.setBackground(Color.white);
		view.setPreferredSize(new Dimension(manager.getCanvasWidth(), manager.getCanvasHeight()));
		
		
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		outerPanel.add(view);
		scrollContainer = new JScrollPane(outerPanel);
		
		viewTab = new JTabbedPane();
		viewTab.addTab(manager.getProjectName(), scrollContainer);
		
		exportFile = new JFileChooser();
		exportFile.setFileFilter(new FileNameExtensionFilter("JPEG File", "jpg"));

		popUpMenu = new JPopupMenu();
		selectButton = new JToggleButton();
		selectButton.setToolTipText("Select");
		try {
		selectButton.setIcon(new ImageIcon(getClass().getResource("selectButton-01.png")));
		} catch(NullPointerException e) {
		}
		
		JButton undoButton = new JButton();
		try {
		undoButton.setIcon(new ImageIcon(getClass().getResource("old_edit_undo.png")));
		} catch(NullPointerException e) {
		}
		JButton redoButton = new JButton();
		try {
		redoButton.setIcon(new ImageIcon(getClass().getResource("old_edit_redo.png")));
		} catch(NullPointerException e) {
		}
		JButton test = new JButton("Test");
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());

		classButton = new JToggleButton();
		classButton.setToolTipText("Add a Class");
		try {
			classButton.setIcon(new ImageIcon(getClass().getResource("addObjectButton-01.png")));
			} catch(NullPointerException e) {
			}
		relationshipButton = new JToggleButton();
		relationshipButton.setToolTipText("Create Relationship");
		try {
			relationshipButton.setIcon(new ImageIcon(getClass().getResource("addRelationButton-01.png")));
			} catch(NullPointerException e) {
			}
		organizeButton = new JButton();
		organizeButton.setToolTipText("Organize");
		try {
			organizeButton.setIcon(new ImageIcon(getClass().getResource("organizeButton-01.png")));
			} catch(NullPointerException e) {
			}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane();
		// frame.setSize(1000, 500);
		//this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
		this.add(viewTab, BorderLayout.CENTER);
		this.setLocation(300, 200);
		this.setSize(800,600);
		
		// --set initial window positions-------------
		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// frame.setLocation((dim.width-frame.getWidth()),
		// (dim.height-frame.getHeight()));
		// frame.setSize(dim.width, dim.height);
		//this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);

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
		
		//Adds Export to the fileMenu
		fileMenu.add(export);
		export.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt) {
			
				BufferedImage bi= new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);;
				view.printAll(bi.getGraphics());
				
				/**
				try {
					bi = new Robot().createScreenCapture(new Rectangle(view.getLocationOnScreen().x, view.getLocationOnScreen().y, view.getWidth(), view.getHeight()));
				} catch (AWTException e1) {
					
					e1.printStackTrace();
				}
				*/
				int returnVal = exportFile.showSaveDialog(Gui.this);
				
				
				File imageFile;
				imageFile = new File(exportFile.getSelectedFile() + ".jpg");
				try {
					ImageIO.write(bi,"jpg",imageFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{ 
					  
					
					exportFile.setVisible(false);
					
						/**
						try {
							ImageIO.write(bi,"jpg",imageFile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/
					
				}
				
			}
				//exportFile.showSaveDialog(Gui.this);
			
		});
		
		

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
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.copyClass();
			}
		});

		// paste
		// JMenuItem Paste = new JMenuItem("Paste", KeyEvent.VK_T);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.CTRL_MASK));
		editMenu.add(paste);
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.pasteClass();
			}
		});

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
		
		//Edit menu item for editig class objects
		edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				ClassObject tempClass = manager.getClassObjectList().get(manager.getObjController().getSelectedClassObject()).copy();
				editClassDialog.getClassNameTextField().setText(tempClass.getName());
				editClassDialog.getClassTypeList().setSelectedIndex(tempClass.getType());
				
				//This is to make the list in edit class to appear with the classes attributes
				String[] tempAttributeList = new String[tempClass.getAttributes().size()];
				for(int i = 0; i < tempAttributeList.length; i++) {
					switch (tempClass.getAttributes().get(i).getVisibility()) {
					case 0:
						tempAttributeList[i] = "+ "
								+ tempClass.getAttributes().get(i).getAttributeName();
						break;
					case 1:
						tempAttributeList[i] = "- "
								+ tempClass.getAttributes().get(i).getAttributeName();
						break;
					case 2:
						tempAttributeList[i] = "# "
								+ tempClass.getAttributes().get(i).getAttributeName();
						break;
					case 3:
						tempAttributeList[i] = "~ "
								+ tempClass.getAttributes().get(i).getAttributeName();
						break;
					}
				}
				editClassDialog.getAttributesList().setListData(tempAttributeList);
				
				//This is to make the list in edit class to appear with the classes operations
				String[] tempOperationList = new String[tempClass.getOperations().size()];
				for(int i = 0; i < tempOperationList.length; i++) {
					switch (tempClass.getOperations().get(i).getVisibility()) {
					case 0:
						tempOperationList[i] = "+ "
								+ tempClass.getOperations().get(i).getOperationName();
						break;
					case 1:
						tempOperationList[i] = "- "
								+ tempClass.getOperations().get(i).getOperationName();
						break;
					case 2:
						tempOperationList[i] = "# "
								+ tempClass.getOperations().get(i).getOperationName();
						break;
					case 3:
						tempOperationList[i] = "~ "
								+ tempClass.getOperations().get(i).getOperationName();
						break;
					}
				}
				editClassDialog.getOperationsList().setListData(tempOperationList);
				manager.setEditingClass(true);
				manager.setAddAttributeList(tempClass.getAttributes());
				manager.setAddOperationList(tempClass.getOperations());
				editClassDialog.setLocation(300, 200);
				editClassDialog.setVisible(true);
			}
		});

		// end adding MenuItems to
		// Edit~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// Add menu items to popUpMenu
		popUpMenu.add(copy);
		popUpMenu.add(paste);
		popUpMenu.add(edit);
		popUpMenu.add(delete);

		// Left Side Panel
		// JPanel leftSidePanel = new JPanel();
		this.add(leftSidePanel, BorderLayout.WEST);
		leftSidePanel.setBackground(Color.gray);
		leftSidePanel.setPreferredSize(new Dimension(50, 50));
		//GridLayout grid = ()
		leftSidePanel.setLayout(new FlowLayout());

		// Create Select Toggle Button
		leftSidePanel.add(selectButton);
		
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
		
		organizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(manager.isOrganize()) {
					manager.setOrganize(false);
					view.repaint();
				} else {
					manager.setOrganize(true);
					view.repaint();
				}
			}
		});

		// JButton organizeButton = new JButton("Organize");
		leftSidePanel.add(organizeButton);

		// Create new instance of dialogs
		projectDialog = new ProjectDialog(manager);
		addRelationshipDialog = new AddRelationship(manager);
		editRelationshipDialog = new EditRelationship(manager);
		addClassDialog = new AddClass(manager);
		addClassDialog.getClassTypeList().setSelectedIndex(0);
		editClassDialog = new EditClass(manager);
		addAttributeDialog = new AddAttribute(manager);
		addOperationDialog = new AddOperation(manager);
		

		// Set the frame visible at the end when everything is added
		this.setVisible(true);
		projectDialog.setVisible(true);
		
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

	public JMenuItem getCopy() {
		return copy;
	}

	public JMenuItem getPaste() {
		return paste;
	}

	public JMenuItem getDelete() {
		return delete;
	}

	public EditClass getEditClassDialog() {
		return editClassDialog;
	}

	public JMenuItem getEdit() {
		return edit;
	}

	public JTabbedPane getViewTab() {
		return viewTab;
	}

	public void setViewTab(JTabbedPane viewTab) {
		this.viewTab = viewTab;
	}

	public void setView(EditorView view) {
		this.view = view;
	}
	
	
}
