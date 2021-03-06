/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asu.mwdb.phase3.task6;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author paddy
 */
public class RelevanceFeedbackUI extends javax.swing.JFrame {

	public String queryGesturePath;
	private FilePickerForm filePicker;
	RelevanceBasedDecisionTreeImplUI relevanceBasedDecisionTreeImplUI;
	private DefaultTableModel tableModel;
	private Object[] columnIdentifiers = new String[] { "Gesture", "Score", "Relevant", "Irrelevant" }; 
	private Object[][] data;
	/**
	 * Creates new form RelevanceFeedbackUI
	 * @param relevanceBasedDecisionTreeImplUI 
	 */
	public RelevanceFeedbackUI(RelevanceBasedDecisionTreeImplUI relevanceBasedDecisionTreeImplUI) {
		initComponents();
		this.relevanceBasedDecisionTreeImplUI=relevanceBasedDecisionTreeImplUI;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setTitle("Relevance Based Search ");
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Enter k");

		jLabel2.setText("Enter query gesture");

		
		tableModel = new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, true ,true},
						{ null, null, true ,true},
						{ null, null, true ,true},
						{ null, null, true ,true}},
				columnIdentifiers);
		
		jTable1 = new JTable(tableModel){
			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				switch (column) {
				case 0:return String.class;
				case 1: return String.class;
				case 2: return Boolean.class;
				case 3: return Boolean.class;
				default: return Boolean.class;
				}
			}
		};
		
		jScrollPane1.setViewportView(jTable1);

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jButton1.setText("Browse");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Search");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														567, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						167,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel2))
																.addGap(97, 97,
																		97)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jTextField1)
																				.addComponent(
																						jTextField2,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						196,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jButton1,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jButton2,
																						javax.swing.GroupLayout.Alignment.TRAILING))))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2)
												.addComponent(jButton1))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														29,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton2))
								.addGap(30, 30, 30)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										332,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(14, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:

		if (filePicker != null && filePicker.getjFileChooser1() != null)
			queryGesturePath = filePicker.getjFileChooser1().getSelectedFile()
					.getAbsolutePath();
		else
		queryGesturePath = jTextField1.getText();

		if (queryGesturePath == null || queryGesturePath.length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please enter valid gesture directory ");
		} else {
			File file = new File(queryGesturePath);
			if (!file.isDirectory()) {
				JOptionPane.showMessageDialog(this,
						"Please enter valid gesture directory ");
				jTextField1.setText("");
			}
		}

		Integer k = null;
		try {
			k = Integer.parseInt(jTextField2.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Please enter valid value of k ");
			jTextField2.setText("");
			return;
		}
		//everything fine, 
		
		relevanceBasedDecisionTreeImplUI.setK(k);
		relevanceBasedDecisionTreeImplUI.setGestureInputDirectory(queryGesturePath);
		
		
		if(relevanceBasedDecisionTreeImplUI.results==null){ //running for first
			trainingIndexes=relevanceBasedDecisionTreeImplUI.initData();
			data=relevanceBasedDecisionTreeImplUI.results;
			tableModel.setDataVector(data, columnIdentifiers);
			jTable1.setModel(tableModel);
			tableModel.fireTableDataChanged();
			return ;
		}
		
		//check feedback given on this data
		if(checkFeedBackIsGiven(relevanceBasedDecisionTreeImplUI.labels,data)){
			trainingIndexes=relevanceBasedDecisionTreeImplUI.relvanceFeedbackDecisionTree(trainingIndexes);
			data=relevanceBasedDecisionTreeImplUI.results;			
			tableModel.setDataVector(data, columnIdentifiers);
			jTable1.setModel(tableModel);
			tableModel.fireTableDataChanged();
		}
		else{
			JOptionPane.showMessageDialog(this, "Please give feedback on results ");
		}
		
	}
	List<Integer> trainingIndexes = null;

	private boolean checkFeedBackIsGiven(HashMap<Integer, String> labels, Object[][] data) {
		// TODO Future
		//check all atleast some labels are ticked - update the labels
		Integer[] documentIndex = new Integer[data.length];
		for (int i = 0; i < data.length; i++) {
			documentIndex[i]=(Integer) data[i][4]; //get document index at 4
		}
		
		DefaultTableModel tmodel = (DefaultTableModel) jTable1.getModel();
		Vector<Vector> vector = tmodel.getDataVector();
		for (int i = 0; i < documentIndex.length; i++) {
			Vector innerVector=vector.get(i);
			boolean relevant =false;
			if(innerVector.get(2)!=null)
				relevant = (Boolean) innerVector.get(2);
			else
				relevant = false;
			
			if(relevant)
				labels.put(documentIndex[i], "y");
			else
				labels.put(documentIndex[i], "n");
		}	
		return true;
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		filePicker = new FilePickerForm(jTextField1);
	}// GEN-LAST:event_jButton1ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(
					RelevanceFeedbackUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(
					RelevanceFeedbackUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(
					RelevanceFeedbackUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(
					RelevanceFeedbackUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */

		new RelevanceFeedbackUI(null).setVisible(true);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables
}
