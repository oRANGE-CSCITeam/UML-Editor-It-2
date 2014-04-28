package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JColorChooser;
import javax.swing.JDialog;

class EditClass extends JDialog {
	private Manager manager;

	/**
	 * Creates new form AddClass
	 */
	public EditClass(Manager manager) {
		this.manager = manager;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jFrame1 = new JDialog();
		jFrame1.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		
		classNameTextField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		colorButton = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		attributesScrollPane = new javax.swing.JScrollPane();
		attributesList = new javax.swing.JList();
		addAttributeButton = new javax.swing.JButton();
		removeAttributeButton = new javax.swing.JButton();
		editAttributeButton = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		operationsScrollPane = new javax.swing.JScrollPane();
		operationsList = new javax.swing.JList();
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		addOperationButton = new javax.swing.JButton();
		removeOperationButton = new javax.swing.JButton();
		editOperationButton = new javax.swing.JButton();
		jSeparator3 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		classTypeScrollPane = new javax.swing.JScrollPane();
		classTypeList = new javax.swing.JList();
		doneButton = new javax.swing.JButton();

		this.setAlwaysOnTop(true);
		this.setResizable(false);
		// Control what to do depending on the state of the frame
		this.addWindowListener(new WindowListener() {
			public void windowClosed(WindowEvent evt) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				close();

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(
				jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		// setDefaultCloseOperation();
		setTitle("Edit Class");

		jLabel1.setText("Class name");

		colorButton.setText("Color");
		colorButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				Color selectedColor = JColorChooser.showDialog(manager.getGui().getEditClassDialog(), "Pick a Color", Color.orange);
				if(selectedColor != null) {
					manager.setClassColor(selectedColor);
					manager.setEditedColor(true);
				}
			}
		});

		jLabel2.setText("Attributes");

		attributesScrollPane.setViewportView(attributesList);

		addAttributeButton.setText("Add");
		// show the add attribute dialog
		addAttributeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.showAddAttribute();
			}
		});

		removeAttributeButton.setText("Remove");
		// Call the removeAttribute method in manager
		removeAttributeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.removeAttribute();
			}
		});

		editAttributeButton.setText("Edit");
		// Call the editAttribute method in manager
		editAttributeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.showEditAttribute();
			}
		});

		jLabel3.setText("Operations");

		operationsScrollPane.setViewportView(operationsList);

		addOperationButton.setText("Add");
		// show the add operation dialog
		addOperationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.showAddOperation();
			}
		});

		removeOperationButton.setText("Remove");
		// Call the removeOperation method in manager
		removeOperationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.removeOperation();
			}
		});

		editOperationButton.setText("Edit");
		// Call the editOperation method in manager
		editOperationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.showEditOperation();
			}
		});

		jLabel4.setText("Class Type");

		classTypeList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Object", "Interface", "Abstract"};

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		classTypeScrollPane.setViewportView(classTypeList);

		final GiveClassNameNotification notify = new GiveClassNameNotification(this, true);
		
		doneButton.setText("Done");
		// Call the addClass method in Manager
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(classNameTextField.getText() != null) {
					manager.editClass();
				} else {
					notify.setVisible(true);
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator1,
						javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(jSeparator2)
				.addComponent(jSeparator3,
						javax.swing.GroupLayout.Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										classNameTextField))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		jLabel3)
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																.addComponent(
																																		operationsScrollPane,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		159,
																																		javax.swing.GroupLayout.PREFERRED_SIZE))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		jLabel2)
																																.addGap(16,
																																		16,
																																		16)
																																.addComponent(
																																		attributesScrollPane,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		158,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)))
																								.addGap(0,
																										0,
																										Short.MAX_VALUE)))
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																												.addComponent(
																														addAttributeButton,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														removeAttributeButton,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														colorButton,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										editAttributeButton))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																												.addComponent(
																														addOperationButton,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														removeOperationButton,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										editOperationButton))))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel4)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		classTypeScrollPane,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		159,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0,
																		0,
																		Short.MAX_VALUE)))
								.addGap(34, 34, 34))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(doneButton).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(13, 13, 13)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														classNameTextField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(colorButton))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(35, 35,
																		35)
																.addComponent(
																		jLabel2))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jSeparator1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		10,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(2, 2, 2)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						attributesScrollPane,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						50,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														addAttributeButton)
																												.addComponent(
																														editAttributeButton))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										removeAttributeButton)))))
								.addGap(16, 16, 16)
								.addComponent(jSeparator2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(26, 26,
																		26)
																.addComponent(
																		jLabel3))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(8, 8, 8)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														addOperationButton)
																												.addComponent(
																														editOperationButton))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										removeOperationButton))
																				.addComponent(
																						operationsScrollPane,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						50,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jSeparator3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										6,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(32, 32,
																		32)
																.addComponent(
																		jLabel4))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		classTypeScrollPane,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		65,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										37, Short.MAX_VALUE)
								.addComponent(doneButton).addContainerGap()));

		pack();
	}

	public void close() {
		manager.setCanAddClass(false);
		manager.getGui().getClassButton().setSelected(false);
		manager.getGui().getSelectButton().setSelected(true);
		manager.setCanAddClass(false);
		classNameTextField.setText("");
		attributesList.setListData(new String[0]);
		operationsList.setListData(new String[0]);
		dispose();
		manager.getGui().getView().repaint();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AddClass.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AddClass.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AddClass.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AddClass.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

	}

	// Variables declaration - do not modify
	private javax.swing.JButton colorButton;
	private javax.swing.JButton addAttributeButton;
	private javax.swing.JButton removeAttributeButton;
	private javax.swing.JButton editAttributeButton;
	private javax.swing.JButton addOperationButton;
	private javax.swing.JButton removeOperationButton;
	private javax.swing.JButton editOperationButton;
	private javax.swing.JButton doneButton;
	private JDialog jFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JList attributesList;
	private javax.swing.JList operationsList;
	private javax.swing.JList classTypeList;
	private javax.swing.JScrollPane attributesScrollPane;
	private javax.swing.JScrollPane operationsScrollPane;
	private javax.swing.JScrollPane classTypeScrollPane;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JTextField classNameTextField;

	// End of variables declaration

	public javax.swing.JList getAttributesList() {
		return attributesList;
	}

	public javax.swing.JList getOperationsList() {
		return operationsList;
	}

	public javax.swing.JList getClassTypeList() {
		return classTypeList;
	}

	public javax.swing.JScrollPane getAttributesScrollPane() {
		return attributesScrollPane;
	}

	public javax.swing.JScrollPane getOperationsScrollPane() {
		return operationsScrollPane;
	}

	public javax.swing.JScrollPane getClassTypeScrollPane() {
		return classTypeScrollPane;
	}

	public javax.swing.JTextField getClassNameTextField() {
		return classNameTextField;
	}

}
