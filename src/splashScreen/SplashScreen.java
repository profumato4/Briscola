
package splashScreen;

import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * A custom splash screen dialog that displays a loading animation, progress bar, and status label.
 *
 * This dialog is used to indicate the progress of tasks being performed during application startup.
 *
 */

public class SplashScreen extends javax.swing.JDialog {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CurvesPanel curvesPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbStatus;
    private ProgressBarCustom pro;
    private ImageLoading il;

    /**
     * Creates a new instance of SplashScreen.
     *
     * @param parent The parent frame.
     * @param modal  Indicates whether the dialog should be modal.
     * @throws UnsupportedLookAndFeelException If the look and feel is not supported.
     * @throws ClassNotFoundException        If the class of a serialized object cannot be found.
     * @throws InstantiationException        If an application tries to create an instance of a class using the newInstance method in class Class, but the specified class object cannot be instantiated.
     * @throws IllegalAccessException        If the currently executing method does not have access to the definition of the specified class, field, method, or constructor.
     */

    public SplashScreen(java.awt.Frame parent, boolean modal) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super(parent, modal);
        
        FlatLightLaf.setup();
        
        initComponents();
        getContentPane().setBackground(new Color(221, 221, 221));
        //  To disable key Alt+F4 to close dialog
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        UIManager.setLookAndFeel(new FlatLightLaf());
        try {
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the components of the splash screen dialog.
     */
    
    private void initComponents() {

        curvesPanel1 = new CurvesPanel();
        jLabel1 = new javax.swing.JLabel();
        il = new ImageLoading();
        pro = new ProgressBarCustom();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        il.loadImage(jLabel1);

        lbStatus.setForeground(new java.awt.Color(200, 200, 200));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatus.setText("Status");

        javax.swing.GroupLayout curvesPanel1Layout = new javax.swing.GroupLayout(curvesPanel1);
        curvesPanel1.setLayout(curvesPanel1Layout);
        curvesPanel1Layout.setHorizontalGroup(
                curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(curvesPanel1Layout.createSequentialGroup()
                                .addContainerGap(277, Short.MAX_VALUE)
                                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(278, Short.MAX_VALUE))
        );
        curvesPanel1Layout.setVerticalGroup(
                curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(curvesPanel1Layout.createSequentialGroup()
                                .addContainerGap(93, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbStatus)
                                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(curvesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(curvesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Executed when the window is opened. Initiates the loading tasks.
     *
     * @param evt The window event.
     */

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(() -> {
            try {
                doTask("Connect To Database ...", 10);
                doTask("Task 1 ...", 20);
                doTask("Task 2 ...", 30);
                doTask("Task 3 ...", 40);
                doTask("Task 4 ...", 50);
                doTask("Task 5 ...", 60);
                doTask("Task 6 ...", 70);
                doTask("Task 7 ...", 80);
                doTask("Task 8 ...", 90);
                doTask("Task 9 ...", 100);
                doTask("Done ...", 100);
                dispose();
                curvesPanel1.stop();    //  To Stop animation
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Simulates a task with the given name and progress value.
     *
     * @param taskName The name of the task.
     * @param progress The progress value of the task.
     * @throws Exception If an error occurs during the task execution.
     */

    private void doTask(String taskName, int progress) throws Exception {
        lbStatus.setText(taskName);
        Thread.sleep(1000);
        pro.setValue(progress);
    }




}
