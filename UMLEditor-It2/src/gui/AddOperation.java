//This code was auto generated by NetBeans IDE 8.0
package gui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

class AddOperation extends JDialog {

	/**
	 * Creates new form AddOperation
	 */
	public AddOperation(Manager manager) {
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

		jLabel1 = new javax.swing.JLabel();
		operationTypeComboBox = new javax.swing.JComboBox();
		addButton = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		operationNameTextField = new javax.swing.JTextField();
		
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Add Operation");

		jLabel1.setText("Operation Type");

		operationTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Public", "Private", "Protected", "Package" }));

		addButton.setText("Add");
		// Call addOperation method in the manager
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manager.addOperation();
			}
		});

		jLabel2.setText("Operation Name");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		addButton))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(42, 42,
																		42)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel1))
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						operationTypeComboBox,
																						0,
																						91,
																						Short.MAX_VALUE)
																				.addComponent(
																						operationNameTextField))
																.addGap(0,
																		51,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(25, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jLabel2,
														javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														operationNameTextField,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														operationTypeComboBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(addButton).addContainerGap()));

		pack();
	}// </editor-fold>

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
			java.util.logging.Logger.getLogger(AddOperation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AddOperation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AddOperation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AddOperation.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton addButton;
	private javax.swing.JComboBox operationTypeComboBox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField operationNameTextField;
	private Manager manager;

	// End of variables declaration
	public javax.swing.JComboBox getOperationTypeComboBox() {
		return operationTypeComboBox;
	}

	public void setOperationTypeComboBox(
			javax.swing.JComboBox operationTypeComboBox) {
		this.operationTypeComboBox = operationTypeComboBox;
	}

	public javax.swing.JTextField getOperationNameTextField() {
		return operationNameTextField;
	}

	public void setOperationNameTextField(
			javax.swing.JTextField operationNameTextField) {
		this.operationNameTextField = operationNameTextField;
	}

}
