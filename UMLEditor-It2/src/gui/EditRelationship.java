//This code was auto generated by NetBeans IDE 8.0
package gui;

import javax.swing.JFrame;

class EditRelationship extends JFrame {

	/**
	 * Creates new form EditRelationship
	 */
	public EditRelationship(Manager manager) {
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
		classesScrollPane = new javax.swing.JScrollPane();
		classesList = new javax.swing.JList();
		jLabel2 = new javax.swing.JLabel();
		relationshipsScrollPane = new javax.swing.JScrollPane();
		relationshipsList = new javax.swing.JList();
		editButton = new javax.swing.JButton();
		removeButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		okButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Classes");

		classesList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4",
					"Item 5" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		classesScrollPane.setViewportView(classesList);

		jLabel2.setText("Relationships");

		relationshipsList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4",
					"Item 5" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		relationshipsScrollPane.setViewportView(relationshipsList);

		editButton.setText("Edit");

		removeButton.setText("Remove");

		cancelButton.setText("Cancel");

		okButton.setText("Ok");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(64, 64,
																		64)
																.addComponent(
																		jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		classesScrollPane,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		155,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						cancelButton)
																				.addComponent(
																						relationshipsScrollPane,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						155,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														removeButton)
																												.addComponent(
																														editButton,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														71,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addGap(0,
																										0,
																										Short.MAX_VALUE))
																				.addComponent(
																						okButton,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addContainerGap())
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		jLabel2)
																.addGap(131,
																		131,
																		131)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(53, 53, 53)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(jLabel2))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
																.addComponent(
																		classesScrollPane,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		69,
																		Short.MAX_VALUE)
																.addComponent(
																		relationshipsScrollPane,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		0,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(12, 12,
																		12)
																.addComponent(
																		editButton)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		removeButton)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										42, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(cancelButton)
												.addComponent(
														okButton,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap()));

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
			java.util.logging.Logger
					.getLogger(EditRelationship.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger
					.getLogger(EditRelationship.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger
					.getLogger(EditRelationship.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger
					.getLogger(EditRelationship.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton editButton;
	private javax.swing.JButton removeButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton okButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JList classesList;
	private javax.swing.JList relationshipsList;
	private javax.swing.JScrollPane classesScrollPane;
	private javax.swing.JScrollPane relationshipsScrollPane;
	private Manager manager;
	// End of variables declaration
}