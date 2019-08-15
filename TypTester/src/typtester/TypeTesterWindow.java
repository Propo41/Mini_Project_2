package typtester;

import java.awt.Color;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.CHAR_UNDEFINED;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/*
 output text means the 1st window, which is used to display text from file.
 input text means the 2nd window, where user inputs

 */
public class TypeTesterWindow extends javax.swing.JFrame {

    private boolean timerControl;
    private String timerDisplay;
    private Color defaultColor;
    private String temp[], outputText;
    //i is used to traverse through the output text
    private int correct, incorrect, i, score;
    String inputText;
    long displayMinutes;
    long secondspassed;
    int wordCount;
    boolean start_program;

    public TypeTesterWindow(){
        initComponents();
        initVariables();

    }

    private void initVariables() {
        defaultColor = new Color(240, 240, 240);
        outputText = new String();
        temp = new String[1000];
        timerDisplay = "";
        timerControl = true;
        correct = 0;
        incorrect = 0;
        score = 0;
        inputText = "";
        i = 0;
        wordCount = 0;
        start_program = false;

        try {
            readFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. Check directory");

        } catch (IOException ex) {
            System.out.println("File input problems found. Check directory");

        }

        //locking all fields so that user cant type anything on them while the program is running
        outputWindow.setEditable(false);
        inputWindow.setEditable(false); // input window is true only when start is pressed.
        correctShow.setEditable(false);
        incorrectShow.setEditable(false);
        scoreShow.setEditable(false);
        timeShow.setEditable(false);
        wpm.setEditable(false);

    }

    /*
    the following function takes a string message and changes the attributes of it.
    tweak the values to change it accordingly
    */
    private void appendToPane(JTextPane tp, String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        // tp.replaceSelection(msg); //sets the edited text to the pane.
    }

    //----------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        timeShow = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        correctShow = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        incorrectShow = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        scoreShow = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputWindow = new javax.swing.JTextArea();
        start = new javax.swing.JButton();
        end = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputWindow = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        wpm = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Time Elapsed: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Correct: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Incorrect: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Score: ");

        outputWindow.setColumns(20);
        outputWindow.setRows(5);
        jScrollPane1.setViewportView(outputWindow);

        start.setText("Start");
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        end.setText("End");
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        inputWindow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputWindowKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(inputWindow);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("WPM:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(correctShow, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(incorrectShow, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeShow, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scoreShow, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(wpm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(correctShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(incorrectShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(timeShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(scoreShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wpm)
                    .addComponent(jLabel5))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   //----------------------------------------------------------------------------

    //extracts the text from a file
    private void readFile() throws FileNotFoundException, IOException {

        int c, j = 0, n = 90;
        String t;
        FileReader fr = new FileReader(new File("C:\\Users\\Swapnil\\Documents\\NetBeansProjects\\TypTester\\input.txt"));
        for (int i = 0; i < 100; i++) {
            temp[i] = "";
        }

        while ((c = fr.read()) != -1) {
            t = String.valueOf((char) c);
            outputText += t;
            temp[j] += t;
            if (temp[j].length() >= n) {
                j++;
                n += 90;

            }

        }

        for (int i = 0; i <= j; i++) {
            outputWindow.append(temp[i]);
            outputWindow.append("\n");

        }

    }

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed

        inputWindow.setEditable(true);
        start_program = true;
        timerDisplay = "";
        timerControl = true;
        wpm.setText("");
        end.setBackground(defaultColor);
        start.setBackground(Color.CYAN);
        //start the timer
        Thread timerThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    timer();
                } catch (InterruptedException e) {
                    System.out.println("exception in timer method");
                }
            }
        });

        timerThread.start();

    }//GEN-LAST:event_startActionPerformed

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
    }//GEN-LAST:event_startMouseClicked

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed

        start_program = false;
        JFrame f = new JFrame();

        start.setBackground(defaultColor);
        timerControl = false;
        end.setBackground(Color.red);
        //pop a new window indicating if user really wants to exit the program, if yes, then system.exit(1)

        int ans = JOptionPane.showConfirmDialog(null, "Are you so afraid to escape?");
        if (ans == 0) {
            System.exit(0);
        } else {
        }


    }//GEN-LAST:event_endActionPerformed

    /*
    Logic used: On every key press, the program checks with the characters on the file file and if it matches, then the appendToPane()
    converts the character to desired attributes and outputs it. Also correct is incremented. 
    WPM is calculated by dividing number of words by the time elapsed
    */
    private void inputWindowKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputWindowKeyPressed
        // TODO add your handling code here:

        if (start_program) {

            char keyCode = evt.getKeyChar();
            // System.out.println(outputText);

            if (i >= outputText.length()) {
                // program ends. Window pops up.
                start.setBackground(defaultColor);
                end.setBackground(defaultColor);
                timerControl = false;
                JOptionPane.showMessageDialog(null, "Good job, my young padawan");
            } else {
                if (keyCode != CHAR_UNDEFINED) {

                    if (keyCode == outputText.charAt(i)) {

                        appendToPane(inputWindow, String.valueOf(keyCode), Color.CYAN);
                        correct++;
                        score++;
                        i++;

                    } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        score--;
                        i--;
                        if (i < 0) {
                            i = 0;
                        }

                    } else {

                        appendToPane(inputWindow, String.valueOf(keyCode), Color.RED);

                        incorrect++;
                        i++;
                        score -= 2;

                    }
                    if (score < 0) {
                        score = 0;
                    }

                    if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                        wordCount++;
                        double t = (double) secondspassed / 60.0;
                        double ans = ((wordCount * 1.0) / (t + displayMinutes));
                        String rate = String.format("%.2f", ans);
                        wpm.setText(rate);

                    }

                    scoreShow.setText(score + "");
                    correctShow.setText(correct + "");
                    incorrectShow.setText(incorrect + "");

                }
            }
        }
    }//GEN-LAST:event_inputWindowKeyPressed

    /*
    A simple timer implementation
    */
    private void timer() throws InterruptedException {

        displayMinutes = 0;
        long starttime = System.currentTimeMillis();
        // System.out.println("Timer:");
        while (timerControl) {
            TimeUnit.SECONDS.sleep(1);
            Thread.sleep(0);
            long timepassed = System.currentTimeMillis() - starttime;
            secondspassed = timepassed / 1000;
            if (secondspassed == 60) {
                secondspassed = 0;
                starttime = System.currentTimeMillis();
            }
            if ((secondspassed % 60) == 0) {
                displayMinutes++;
            }

            timerDisplay = (displayMinutes + ":" + secondspassed);
            timeShow.setText(timerDisplay);

        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TypeTesterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TypeTesterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TypeTesterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TypeTesterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new TypeTesterWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correctShow;
    private javax.swing.JButton end;
    private javax.swing.JTextField incorrectShow;
    private javax.swing.JTextPane inputWindow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea outputWindow;
    private javax.swing.JTextField scoreShow;
    private javax.swing.JButton start;
    private javax.swing.JTextField timeShow;
    private javax.swing.JTextField wpm;
    // End of variables declaration//GEN-END:variables
}
