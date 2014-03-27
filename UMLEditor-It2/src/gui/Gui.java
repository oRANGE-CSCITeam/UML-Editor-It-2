package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

public class Gui extends JPanel
				implements MouseListener, ActionListener{
	private JFrame frame;
	private Manager manager;
	EditorView view;
	
	
	public Gui(Manager manager) {
		this.manager = manager;
		
		JFrame frame = new JFrame("UML Editor (Iteration 2)");
		JMenuBar darkGrayMenuBar = new JMenuBar();
		JMenu fileMenu = new JMenu ("File");
		JMenuItem New = new JMenuItem("New", KeyEvent.VK_T);
		JMenuItem Open = new JMenuItem("Open", KeyEvent.VK_T);
		JMenuItem Save = new JMenuItem("Save", KeyEvent.VK_T);
		JMenuItem Quit = new JMenuItem("Quit", KeyEvent.VK_T);
		JMenu editMenu = new JMenu ("Edit");
		JMenuItem Undo = new JMenuItem("Undo", KeyEvent.VK_T);
		JMenuItem Redo = new JMenuItem("Redo", KeyEvent.VK_T);
		JMenuItem Copy = new JMenuItem("Copy", KeyEvent.VK_T);
		JMenuItem Paste = new JMenuItem("Paste", KeyEvent.VK_T);
		JMenuItem Clear = new JMenuItem("Clear", KeyEvent.VK_T);
		JMenuItem Delete = new JMenuItem("Delete", KeyEvent.VK_T);
		JPanel leftSidePanel = new JPanel();
	        final JToggleButton classButton = new JToggleButton("Create Class");
		final JToggleButton RelationshipButton = new JToggleButton("Create Relationship");
		JButton organizeButton = new JButton("Organize");
		view = new EditorView(manager);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		//frame.setSize(1000, 500);
		frame.setVisible(true);
		frame.setExtendedState(frame.getExtendedState() | Frame.MAXIMIZED_BOTH);
		frame.add(BorderLayout.CENTER, view);
		
		
		//--set initial window positions-------------
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setLocation((dim.width-frame.getWidth()), (dim.height-frame.getHeight()));
		//frame.setSize(dim.width, dim.height);
		frame.setExtendedState(frame.getExtendedState() | Frame.MAXIMIZED_BOTH);
		
		//creates the Menu Bar
		//JMenuBar darkGrayMenuBar = new JMenuBar();
		frame.add(BorderLayout.NORTH, darkGrayMenuBar);
		darkGrayMenuBar.setOpaque(true);
		darkGrayMenuBar.setBackground(Color.lightGray);
		darkGrayMenuBar.setPreferredSize(new Dimension(1000,20));
		
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
        Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
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
		
        //re-do
		//JMenuItem Redo = new JMenuItem("Redo", KeyEvent.VK_T);
        Redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		editMenu.add(Redo);
		
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
		
		//end  adding MenuItems to Edit~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		
		//Left Side Panel
		//JPanel leftSidePanel = new JPanel();
		frame.add(BorderLayout.WEST, leftSidePanel);
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
	

}
