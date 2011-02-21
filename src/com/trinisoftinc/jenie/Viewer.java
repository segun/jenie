/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Viewer.java
 *
 * Created on Nov 11, 2010, 9:11:59 AM
 */
package com.trinisoftinc.jenie;

import com.trinisoft.libraries.Centralizer;
import com.trinisoftinc.jenie.helper.Helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author trinisoftinc
 */
public class Viewer extends javax.swing.JFrame {

    InputStream is;
    boolean isURL = false;
    File f;
    String original, formatted;

    /** Creates new form Viewer */
    public Viewer() {
        initComponents();
    }

    private void parse(InputStream in) throws FileNotFoundException, JSONException, Exception {
        boolean isMap = false;
        //Decoder decoder = new Decoder(new InputStreamReader(in, "UTF-8"));
        //decoder.parse();
        String contents = Helper.getInputStreamContents(is);
        JSONObject object = null;
        JSONArray array = null;

        try {
            object = new JSONObject(contents);
        } catch (JSONException e) {
            try {
                array = new JSONArray(contents);
            } catch (JSONException je) {
            }
        } finally {
            if (object == null && array == null) {
                JOptionPane.showMessageDialog(this, "The Source specified does not contain a valid JSON String", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        String output = "<html><body><hr />";
        if (array == null) {
            isMap = true;
            HashMap<String, Object> fm = Helper.getMapFromJSONObject(object);
            output += Helper.parseMap(fm);
        } else {
            isMap = false;
            ArrayList fl = Helper.getListFromJSONArray(array);
            output += Helper.parseArray(fl);
        }
        output += "<hr />";
        output += "</body></html>";
        txtParsed.setText(output);
        original = output;
        format();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnSelectFile = new javax.swing.JButton();
        lblFileName = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnGO = new javax.swing.JButton();
        outputPanel = new javax.swing.JPanel();
        outputScrollPane = new javax.swing.JScrollPane();
        txtParsed = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        txtKCC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVCC = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();
        viewHTML = new javax.swing.JRadioButton();
        viewJSON = new javax.swing.JRadioButton();
        viewHTMLCode = new javax.swing.JRadioButton();
        viewTree = new javax.swing.JRadioButton();
        chkFormat = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Select a file or type a url"));

        btnSelectFile.setText("Select File");
        btnSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFileActionPerformed(evt);
            }
        });

        lblFileName.setText("No file selected....");

        jLabel2.setText("Enter URL");

        btnGO.setText("GO");
        btnGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelectFile)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFileName)
                    .addComponent(txtURL, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGO, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelectFile)
                    .addComponent(lblFileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGO))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Outputs"));

        txtParsed.setContentType("text/html");
        txtParsed.setText("");
        outputScrollPane.setViewportView(txtParsed);

        jLabel3.setText("Keys Color Code");

        txtKCC.setText("#ffeedd");
        txtKCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKCCActionPerformed(evt);
            }
        });

        jLabel4.setText("Values Color Code");

        txtVCC.setText("#dadfaf");

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addComponent(outputScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(txtKCC, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVCC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApply)
                        .addGap(245, 245, 245))))
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtVCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnApply)
                    .addComponent(txtKCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonGroup1.add(viewHTML);
        viewHTML.setSelected(true);
        viewHTML.setText("View HTML");
        viewHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHTMLActionPerformed(evt);
            }
        });

        buttonGroup1.add(viewJSON);
        viewJSON.setText("View JSON");
        viewJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJSONActionPerformed(evt);
            }
        });

        buttonGroup1.add(viewHTMLCode);
        viewHTMLCode.setText("View HTML Code");
        viewHTMLCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHTMLCodeActionPerformed(evt);
            }
        });

        buttonGroup1.add(viewTree);
        viewTree.setText("View Tree");
        viewTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTreeActionPerformed(evt);
            }
        });

        chkFormat.setText("Apply Formatting");
        chkFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFormatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkFormat)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(viewHTML)
                                    .addComponent(viewJSON))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(viewTree)
                                    .addComponent(viewHTMLCode)))))
                    .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewHTML)
                            .addComponent(viewHTMLCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewTree)
                            .addComponent(viewJSON))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkFormat))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFileActionPerformed
        isURL = false;
        try {
            // TODO add your handling code here:
            JFileChooser fileChooser = new JFileChooser(new File("."));
            fileChooser.showOpenDialog(rootPane);
            f = fileChooser.getSelectedFile();
            lblFileName.setText(f.getAbsolutePath());
            is = new FileInputStream(f);
            if (viewJSON.isSelected()) {
                txtParsed.setContentType("text/json");
                txtParsed.setText(Helper.getInputStreamContents(is));
                original = txtParsed.getText();
                format();
            } else if (viewHTML.isSelected()) {
                txtParsed.setContentType("text/html");
                parse(is);
            } else {
                txtParsed.setContentType("text/plain");
                parse(is);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Parsing JSON. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Unknown IO Exception Occurred. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Unknown Exception Occurred. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSelectFileActionPerformed

    private void viewHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHTMLActionPerformed
        outputScrollPane.setViewportView(txtParsed);
        try {
            txtParsed.setContentType("text/html");
            if (isURL) {
                URL url = new URL(txtURL.getText());
                URLConnection urlConnection = url.openConnection();
                is = urlConnection.getInputStream();
                parse(urlConnection.getInputStream());
            } else {
                is = new FileInputStream(f);
                parse(is);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "File Not Found " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Parsing JSON. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Unknown Exception Occurred. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewHTMLActionPerformed

    private void viewJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJSONActionPerformed
        outputScrollPane.setViewportView(txtParsed);
        try {
            txtParsed.setContentType("text/json");
            if (isURL) {
                URL url = new URL(txtURL.getText());
                URLConnection urlConnection = url.openConnection();
                is = urlConnection.getInputStream();
                txtParsed.setText(Helper.getInputStreamContents(is));
            } else {
                is = new FileInputStream(f);
                txtParsed.setText(Helper.getInputStreamContents(is));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Unknown IO Exception Occurred. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        original = txtParsed.getText();
        format();
    }//GEN-LAST:event_viewJSONActionPerformed

    private void viewHTMLCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHTMLCodeActionPerformed
        outputScrollPane.setViewportView(txtParsed);
        try {
            txtParsed.setContentType("text/plain");
            if (isURL) {
                URL url = new URL(txtURL.getText());
                URLConnection urlConnection = url.openConnection();
                is = urlConnection.getInputStream();
                parse(urlConnection.getInputStream());
            } else {
                is = new FileInputStream(f);
                parse(is);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "File Not Found. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Parsing JSON. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Unknown Exception Occurred. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewHTMLCodeActionPerformed

    private void btnGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGOActionPerformed
        isURL = true;
        try {
            // TODO add your handling code here:
            URL url = new URL(txtURL.getText());
            URLConnection urlConnection = url.openConnection();
            is = urlConnection.getInputStream();
            if (viewJSON.isSelected()) {
                txtParsed.setContentType("text/json");
                txtParsed.setText(Helper.getInputStreamContents(is));
                original = txtParsed.getText();
                format();
            } else if (viewHTML.isSelected()) {
                txtParsed.setContentType("text/html");
                parse(is);
            } else if (viewHTMLCode.isSelected()) {
                txtParsed.setContentType("text/plain");
                parse(is);
            } else if (viewTree.isSelected()) {
                viewTreeActionPerformed(evt);
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(rootPane, "URL Not well formed");
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Unknown IO Exception Occurred. " + ex.getMessage());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Parsing JSON. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Unknown Exception Occurred. " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnGOActionPerformed

    private void viewTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTreeActionPerformed
        // TODO add your handling code here:
        TreeView tv = new TreeView();
        try {
            if (isURL) {
                URL url = new URL(txtURL.getText());
                URLConnection urlConnection = url.openConnection();
                is = urlConnection.getInputStream();
            } else {
                is = new FileInputStream(f);
            }
            JTree treePane = tv.getTreeView(is);
            outputScrollPane.setViewportView(treePane);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "File Not Found. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Unknown Exception Occurred. " + ex.getMessage());
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewTreeActionPerformed

    private void chkFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFormatActionPerformed
        // TODO add your handling code here:       
        format();
    }//GEN-LAST:event_chkFormatActionPerformed

    private void txtKCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKCCActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:        
        viewHTMLActionPerformed(evt);
    }//GEN-LAST:event_btnApplyActionPerformed

    private void format() {
        String ct;
        if (viewJSON.isSelected()) {
            ct = "text/json";
        } else if (viewHTML.isSelected()) {
            ct = "text/html";
        } else {
            ct = "text/plain";
        }
        if (chkFormat.isSelected()) {
            formatted = Helper.format(original, ct);
            txtParsed.setText(formatted);
        } else {
            txtParsed.setText(original);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Viewer adb = new Viewer();
                Centralizer.centralize(adb);
                adb.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnGO;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkFormat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFileName;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JScrollPane outputScrollPane;
    public static javax.swing.JTextField txtKCC;
    private javax.swing.JTextPane txtParsed;
    private javax.swing.JTextField txtURL;
    public static javax.swing.JTextField txtVCC;
    private javax.swing.JRadioButton viewHTML;
    private javax.swing.JRadioButton viewHTMLCode;
    private javax.swing.JRadioButton viewJSON;
    private javax.swing.JRadioButton viewTree;
    // End of variables declaration//GEN-END:variables
}
