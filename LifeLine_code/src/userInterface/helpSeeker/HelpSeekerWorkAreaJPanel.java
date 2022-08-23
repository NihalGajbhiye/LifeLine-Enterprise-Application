/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.helpSeeker;

import business.EcoSystem;
import business.enterprisepkg.Enterprise;
import business.personpkg.HelpSeeker;
import business.sensor.VitalSign;
import business.userAccountpkg.UserAccount;
import business.workQueuepkg.NeedSensorDeviceWorkRequest;
import business.workQueuepkg.SendDataToDoctorWorkRequest;
import business.workQueuepkg.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import userInterface.sensorPckg.ManageHelpSeekerProfileJPanel;

/**
 *
 * @author tejageetla
 */
public class HelpSeekerWorkAreaJPanel extends javax.swing.JPanel {

     private JPanel userProcessContainer;
    private Enterprise enterprise;
      private UserAccount userAccount;  
      private EcoSystem ecoSystem;
      private HelpSeeker person;
    private static int count = 0;
     private static boolean patientCond = false;
    /**
     * Creates new form HelpSeekerWorkAreaJPanel
     */
    public HelpSeekerWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise , UserAccount userAccount, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise; 
        this.userAccount = userAccount;
        this.ecoSystem = ecoSystem;
        setBackground(new Color(255,204,204));
       
       
        person  = (HelpSeeker)userAccount.getPerson();
        alertsPanel.setVisible(false);
      
         populateAlerts();
         alertsPanel.revalidate();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        
        Color c1 = new Color(255,175,175);
        Color c2 = Color.white;
     
        GradientPaint gp = new GradientPaint(w/4, 0, c2, w/4, h, c1);
        setOpaque( false );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        setOpaque( true );
    }

    public void populateAlerts()
    {
       int count = 0;
       if(person.isShareVitalInfo() && person.isHasSensorDevice()) 
       {
    //    System.out.println("person.getVitalSignList()"+person.getVitalSignList().toString());
        if(!(person.getVitalSignList().isEmpty()))
        {
        for(VitalSign vitalSign : person.getVitalSignList())
        {
        String patientCondition = person.patientCondition(person.getAge(), vitalSign);
        if(patientCondition.equals("ABNORMAL"))
        {
            count++;
        }
        }
         if(count>2)
        {
            JOptionPane.showMessageDialog(null, "You have an alert ! ", "Alerts", JOptionPane.PLAIN_MESSAGE);
            patientCond = true;
            count = 0;
        }
        }
       }
       
        displayAlerts();
    }
    
   
    public void displayAlerts()
    {
      alertsPanel.removeAll();
      alertsPanel.revalidate();
       alertsPanel.setLayout(new GridLayout(10, 1,10,10));
       JTextArea textArea;
       JTextField txtField;
       StringBuilder sb ;
       int count = 0;
       int pos = 0;
         boolean flag = false;
            if(patientCond)
            {
            txtField = new JTextField("Alert Message From Life Line!");   
            txtField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            txtField.setVisible(true);
            txtField.setEditable(false);
            textArea = new JTextArea("Vital Signs tracked last two time show that you are not feeling well, Do you need some help!");
            textArea.setVisible(true);
            textArea.setEditable(false);
            alertsPanel.add(txtField,pos);
            alertsPanel.add(textArea,++pos);
            ++pos;
            flag = true;
            patientCond = false;
            }
       
       if(!(userAccount.getWorkQueue().getWorkRequestList().isEmpty()))
       {
       for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
            if(request.getMessage().equalsIgnoreCase("Vital Sign Data") && request.getStatus().equalsIgnoreCase("Completed"))
            {
            if(count<5)
            {
            SendDataToDoctorWorkRequest dataToDoctorWorkRequest = (SendDataToDoctorWorkRequest)request;
            txtField = new JTextField(" Message From Doctor: "+dataToDoctorWorkRequest.getReceiver().getPerson().getName());
            txtField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            txtField.setVisible(true);
            txtField.setEditable(false);
            
            textArea = new JTextArea(dataToDoctorWorkRequest.getNewMedication());
            textArea.setVisible(true);
            textArea.setEditable(false);
            count++;
             
           
            txtField.setEditable(false);
            textArea.setEditable(false);
            alertsPanel.add(txtField,pos);
            alertsPanel.add(textArea,++pos);
            ++pos;
            flag = true;
            }

            }
            if(request.getMessage().equalsIgnoreCase("Need Sensor Device") && request.getStatus().equalsIgnoreCase("Completed"))
            {
            if(count<5)
            {
             NeedSensorDeviceWorkRequest needSensorDeviceWorkRequest = (NeedSensorDeviceWorkRequest)request;
             sb= new StringBuilder();
             sb.append("RequestResult: ");
             sb.append(needSensorDeviceWorkRequest.getdonationRequestResult());
             sb.append(System.lineSeparator());
             sb.append("Comments From Donor: ");
             sb.append(needSensorDeviceWorkRequest.getComments());
            txtField = new JTextField(" Message From Donor: "+needSensorDeviceWorkRequest.getReceiver().getPerson().getName());
            txtField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            txtField.setVisible(true);
            txtField.setEditable(false);
            textArea = new JTextArea(sb.toString());
            textArea.setVisible(true);
            textArea.setEditable(false);
            count++;
             
           
            txtField.setEditable(false);
            textArea.setEditable(false);
            alertsPanel.add(txtField,pos);
            alertsPanel.add(textArea,++pos);
            ++pos;
            flag = true;
            }

            }
        }
       }

        if(flag)
        {
        alertsPanel.revalidate();
        alertsPanel.setVisible(true);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageHelpSeekerProfile = new javax.swing.JButton();
        writeTestimonialForVolBtn = new javax.swing.JButton();
        manageEnt = new javax.swing.JLabel();
        alertsPanel = new javax.swing.JPanel();
        manageHelpFromVolunteer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        manageHelpSeekerProfile.setText("Manage Profile and Vital Signs");
        manageHelpSeekerProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageHelpSeekerProfileActionPerformed(evt);
            }
        });

        writeTestimonialForVolBtn.setText("Write Testimonial for Volunteer");
        writeTestimonialForVolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeTestimonialForVolBtnActionPerformed(evt);
            }
        });

        manageEnt.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt.setText("Welcome To LifeLine");

        alertsPanel.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout alertsPanelLayout = new javax.swing.GroupLayout(alertsPanel);
        alertsPanel.setLayout(alertsPanelLayout);
        alertsPanelLayout.setHorizontalGroup(
            alertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        alertsPanelLayout.setVerticalGroup(
            alertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        manageHelpFromVolunteer.setText("Manage Help From Volunteer");
        manageHelpFromVolunteer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageHelpFromVolunteerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("we are here for you");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Satish\\Desktop\\NEU\\NEU Assignemts\\INFO5100\\My_Project\\LifeLineLogo_10%_scaled.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(writeTestimonialForVolBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageHelpSeekerProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageHelpFromVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(manageEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jLabel1)
                            .addGap(51, 51, 51))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(alertsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(manageEnt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addGap(106, 106, 106)
                        .addComponent(manageHelpFromVolunteer)
                        .addGap(18, 18, 18)
                        .addComponent(manageHelpSeekerProfile)
                        .addGap(18, 18, 18)
                        .addComponent(writeTestimonialForVolBtn))
                    .addComponent(alertsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageHelpSeekerProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageHelpSeekerProfileActionPerformed
        ManageHelpSeekerProfileJPanel manageHelpSeekerProfileJPanel = new ManageHelpSeekerProfileJPanel(userProcessContainer, userAccount, enterprise, ecoSystem);
         CardLayout layout = (CardLayout) userProcessContainer.getLayout();
         userProcessContainer.add("ManageHelpSeekerProfileJPanel", manageHelpSeekerProfileJPanel);
         layout.next(userProcessContainer);
    }//GEN-LAST:event_manageHelpSeekerProfileActionPerformed

    private void writeTestimonialForVolBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeTestimonialForVolBtnActionPerformed

        WriteTestimonialForVolJPanel writeTestimonialForVolJPanel = new WriteTestimonialForVolJPanel(userProcessContainer, userAccount);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("WriteTestimonialForVolJPanel", writeTestimonialForVolJPanel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_writeTestimonialForVolBtnActionPerformed

    private void manageHelpFromVolunteerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageHelpFromVolunteerActionPerformed
        ManageHelpFromVolunteer manageHelpFromVolunteer = new ManageHelpFromVolunteer(userProcessContainer, userAccount, ecoSystem, enterprise);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ManageHelpFromVolunteer", manageHelpFromVolunteer);
        layout.next(userProcessContainer);       
    }//GEN-LAST:event_manageHelpFromVolunteerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alertsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel manageEnt;
    private javax.swing.JButton manageHelpFromVolunteer;
    private javax.swing.JButton manageHelpSeekerProfile;
    private javax.swing.JButton writeTestimonialForVolBtn;
    // End of variables declaration//GEN-END:variables


}
