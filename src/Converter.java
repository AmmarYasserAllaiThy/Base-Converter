
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Ammar Yasser
 */
public class Converter extends JFrame {

    public Converter() {
        initComponents();
        setLocationRelativeTo(null);
        makePlaceholder();
        saveBtn.setEnabled(false);
    }

    static String text,
            temp,
            code,
            Nums_Letters[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    static long DecimalResult;
    static Color normalColor = Color.WHITE,
            errorColor = Color.red;
    static File file = new File("Saved Values.txt");
    static boolean firstRun = true;
    static PrintWriter toFile;
    static int resNum = 1;

    void makePlaceholder() {
        new Placeholder(binField, "Enter Binary Value (0, 1)");
        new Placeholder(octField, "Enter Octal Value (0 : 7)");
        new Placeholder(decField, "Enter Decimal Value (0 : 9)");
        new Placeholder(hexField, "Enter Hexadecimal Value (0 : F)");
    }

    void convert_and_print(String value, int base) {
        DecimalResult = toDecimal(value, base);
        switch (base) {
            case 2:
                octField.setText(fromDecimal(DecimalResult, 8));
                decField.setText(DecimalResult + "");
                hexField.setText(fromDecimal(DecimalResult, 16));
                break;
            case 8:
                binField.setText(fromDecimal(DecimalResult, 2));
                decField.setText(DecimalResult + "");
                hexField.setText(fromDecimal(DecimalResult, 16));
                break;
            case 10:
                binField.setText(fromDecimal(DecimalResult, 2));
                octField.setText(fromDecimal(DecimalResult, 8));
                hexField.setText(fromDecimal(DecimalResult, 16));
                break;
            case 16:
                binField.setText(fromDecimal(DecimalResult, 2));
                octField.setText(fromDecimal(DecimalResult, 8));
                decField.setText(DecimalResult + "");
                break;
        }
    }

    long toDecimal(String value, int base) {
        try {
            return Long.parseLong(value, base);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(rootPane, "input: " + value + "\nexceeded the allowed range", nfe.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    String fromDecimal(long decimal, int base) {
        temp = code = "";
        while (decimal != 0) {
            temp += Nums_Letters[(int) (decimal % base)];
            decimal /= base;
        }
        for (int i = temp.length() - 1; i >= 0; i--) {
            code += temp.charAt(i);
        }
        return code;
    }

    void doAtFirst() {
        binField.setBackground(normalColor);
        octField.setBackground(normalColor);
        decField.setBackground(normalColor);
        hexField.setBackground(normalColor);

        binField.setForeground(Color.BLACK);
        octField.setForeground(Color.BLACK);
        decField.setForeground(Color.BLACK);
        hexField.setForeground(Color.BLACK);

        saveBtn.setText("Save Values");
    }

    void updateProgressBar() {
        if (binField.getText().equals("Enter Binary Value (0, 1)")) {
            progBar.setValue(0);
        } else {
            progBar.setValue(binField.getText().length());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        binField = new javax.swing.JTextField();
        octField = new javax.swing.JTextField();
        decField = new javax.swing.JTextField();
        hexField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        progBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Numerical Base Converter");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        binField.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        binField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                binFieldKeyReleased(evt);
            }
        });

        octField.setFont(binField.getFont());
        octField.setText(" ");
        octField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                octFieldKeyReleased(evt);
            }
        });

        decField.setFont(binField.getFont());
        decField.setText(" ");
        decField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                decFieldKeyReleased(evt);
            }
        });

        hexField.setFont(binField.getFont());
        hexField.setText(" ");
        hexField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hexFieldKeyReleased(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Comfortaa Light", 0, 18)); // NOI18N
        saveBtn.setText("Save Values");
        saveBtn.setFocusable(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        progBar.setMaximum(63);
        progBar.setString("");
        progBar.setStringPainted(true);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(saveBtn)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(progBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, binField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, octField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, decField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, hexField))
                .add(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(binField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(octField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(decField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(hexField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(progBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(saveBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 25, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {binField, decField, hexField, octField}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        JOptionPane.showMessageDialog(this, "Name : Ammar Yasser AllaiThy"
                + "\nEmail : AllaiThy10@Gmail.com"
                + "\n\nDon't hesitate to Send me Ur Feedback", "Developer Info", ICONIFIED);
    }//GEN-LAST:event_formMouseReleased

    private void binFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_binFieldKeyReleased
        doAtFirst();
        text = binField.getText();
        if (text.matches("[0,1]+")) {
            convert_and_print(text, 2);
            binField.setBackground(normalColor);
            saveBtn.setEnabled(true);
        } else {
            binField.setBackground(errorColor);
            saveBtn.setEnabled(false);
        }
        updateProgressBar();
    }//GEN-LAST:event_binFieldKeyReleased

    private void octFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_octFieldKeyReleased
        doAtFirst();
        text = octField.getText();
        if (text.matches("[0-7]+")) {
            convert_and_print(text, 8);
            octField.setBackground(normalColor);
            saveBtn.setEnabled(true);
        } else {
            octField.setBackground(errorColor);
            saveBtn.setEnabled(false);
        }
        updateProgressBar();
    }//GEN-LAST:event_octFieldKeyReleased

    private void decFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_decFieldKeyReleased
        doAtFirst();
        text = decField.getText();
        if (text.matches("[\\d]+")) {
            convert_and_print(text, 10);
            decField.setBackground(normalColor);
            saveBtn.setEnabled(true);
        } else {
            decField.setBackground(errorColor);
            saveBtn.setEnabled(false);
        }
        updateProgressBar();
    }//GEN-LAST:event_decFieldKeyReleased

    private void hexFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hexFieldKeyReleased
        doAtFirst();
        text = hexField.getText().toLowerCase();
        if (text.matches("[[\\da-f]]+")) {
            convert_and_print(text, 16);
            hexField.setBackground(normalColor);
            saveBtn.setEnabled(true);
        } else {
            hexField.setBackground(errorColor);
            saveBtn.setEnabled(false);
        }
        updateProgressBar();
    }//GEN-LAST:event_hexFieldKeyReleased

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            if (!saveBtn.getText().equals("Saved")) {
                if (!file.exists()) {
                    file.createNewFile();
                }

                if (firstRun) {
                    toFile = new PrintWriter(new FileWriter(file, true));
                    toFile.format("%n%s%n", new Date());
                }

                toFile.format("  Result %d%n"
                        + "    bin: %s%n"
                        + "    oct: %s%n"
                        + "    dec: %s%n"
                        + "    hex: %s%n",
                        resNum++, binField.getText(), octField.getText(), decField.getText(), hexField.getText());
                toFile.flush();

                if (firstRun) {
                    JOptionPane.showMessageDialog(rootPane, "All Values saved to\n" + file.getAbsolutePath(), "Values File Path", ICONIFIED);
                    firstRun = false;
                }

                saveBtn.setText("Saved");
            }
        } catch (IOException iox) {
            JOptionPane.showMessageDialog(rootPane, iox.getMessage(), "Error", ERROR);
            saveBtn.setText("Error");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) && OS-based Dynamic UI ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (UI().equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Converter.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Converter().setVisible(true);
        });
    }

    static String UI() {
        if (System.getProperty("os.name").equals("Linux")) {
            return "GTK+";
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            return "Windows";
        } else {
            return "Nimbus";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField binField;
    private javax.swing.JTextField decField;
    private javax.swing.JTextField hexField;
    private javax.swing.JTextField octField;
    private javax.swing.JProgressBar progBar;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
