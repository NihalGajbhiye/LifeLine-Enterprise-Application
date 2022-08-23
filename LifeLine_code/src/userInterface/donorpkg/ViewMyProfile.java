/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.donorpkg;

import business.common.ValidateDateOfBirth;
import business.common.ValidateEmailTextField;
import business.common.ValidateNumbers;
import business.common.ValidatePhoneNumber;
import business.common.ValidateStrings;
import business.common.Validation;
import business.personpkg.Person;
import business.userAccountpkg.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tejageetla
 */
public class ViewMyProfile extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Person person;
    
    /**
     * Creates new form ViewMyProfile
     */
    public ViewMyProfile(JPanel userProcessContainer, UserAccount account) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        person = userAccount.getPerson();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        donorNameField.setText(person.getName());
      if(person.getDob()!=null && person.getAddress1()!=null && person.getTown()!=null 
                && person.getZipCode()!=null && person.getOccupation()!=null &&
                person.getEmailId()!=null && person.getPhoneNumber()!=null
                )
       {
        donorDobField.setText(dateFormat.format(person.getDob()));
        addressField.setText(person.getAddress1());
        townField.setText(person.getTown());
        zipCodeField.setText(person.getZipCode());
        occupationField.setText(person.getOccupation());
        emailIDField.setText(person.getEmailId());
        phoneNumberField.setText(person.getPhoneNumber());
        }
        addInputVerifiers();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        donorName = new javax.swing.JLabel();
        donorNameField = new javax.swing.JTextField();
        zipCodeField = new javax.swing.JTextField();
        dateOfBirth = new javax.swing.JLabel();
        occupation = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        occupationField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        emailID = new javax.swing.JLabel();
        town = new javax.swing.JLabel();
        emailIDField = new javax.swing.JTextField();
        townField = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JLabel();
        zipCode = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        donorDobField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        donorName.setText("Full Name:");

        donorNameField.setEditable(false);
        donorNameField.setEnabled(false);

        zipCodeField.setEditable(false);
        zipCodeField.setEnabled(false);

        dateOfBirth.setText("Date Of Birth (MM/DD/YYYY):");

        occupation.setText("Occupation:");

        address.setText("Address: ");

        occupationField.setEditable(false);
        occupationField.setEnabled(false);

        addressField.setEditable(false);
        addressField.setEnabled(false);

        emailID.setText("Email Address:");

        town.setText("Town/City: ");

        emailIDField.setEditable(false);
        emailIDField.setEnabled(false);

        townField.setEditable(false);
        townField.setEnabled(false);

        phoneNumber.setText("Phone Number:");

        zipCode.setText("Zip Code:");

        phoneNumberField.setEditable(false);
        phoneNumberField.setEnabled(false);

        donorDobField.setEditable(false);
        donorDobField.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        jLabel6.setText("View / Update Profile");

        backJButton.setText("<< back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        saveJButton.setText("Save");
        saveJButton.setEnabled(false);
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });

        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Satish\\Desktop\\NEU\\NEU Assignemts\\INFO5100\\My_Project\\5%_scaled.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(donorNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(town))
                                    .addComponent(occupation)
                                    .addComponent(emailID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(donorName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(zipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneNumberField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(donorDobField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(zipCodeField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(townField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(occupationField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(emailIDField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addressField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(245, 245, 245)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton)
                                .addGap(240, 240, 240)
                                .addComponent(updateJButton)
                                .addGap(33, 33, 33)
                                .addComponent(saveJButton)))))
                .addContainerGap(436, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(donorName)
                    .addComponent(donorNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfBirth)
                    .addComponent(donorDobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(town)
                    .addComponent(townField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(occupation))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(occupationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailID)
                    .addComponent(emailIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipCode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(updateJButton)
                    .addComponent(saveJButton))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
       userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed
       
    private void addInputVerifiers() {
          
        InputVerifier stringValidation = new ValidateStrings();
        donorNameField.setInputVerifier(stringValidation);
        addressField.setInputVerifier(stringValidation);
        townField.setInputVerifier(stringValidation);
        occupationField.setInputVerifier(stringValidation);
       
        InputVerifier dobValidtion = new ValidateDateOfBirth();
        donorDobField.setInputVerifier(dobValidtion);
        
        InputVerifier numberValidation = new ValidateNumbers();
        zipCodeField.setInputVerifier(numberValidation);
        
           InputVerifier emailValidtion = new ValidateEmailTextField();
           emailIDField.setInputVerifier(emailValidtion);
     
        
       InputVerifier phnumberValidation = new ValidatePhoneNumber();
        phoneNumberField.setInputVerifier(phnumberValidation);
        
    }
    
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed

        if(donorNameField.getText()!= null && !donorNameField.getText().isEmpty() &&
            addressField.getText()!=null && !addressField.getText().isEmpty() &&
            townField.getText()!=null && !townField.getText().isEmpty() &&
            occupationField.getText()!=null && !occupationField.getText().isEmpty() &&
            emailIDField.getText()!=null && !emailIDField.getText().isEmpty() &&
            phoneNumberField.getText()!=null && !phoneNumberField.getText().isEmpty() && 
            donorDobField.getText()!=null && !donorDobField.getText().trim().isEmpty() &&
            zipCodeField.getText()!=null && !zipCodeField.getText().trim().isEmpty() )
        {
            try
            {
              DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
              Date dateOfBirthVal  = dateFormat.parse(donorDobField.getText()) ;
                int age = Validation.calculateAge(dateOfBirthVal);
                if(age<=0 )
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid age!","warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if((phoneNumberField.getText()).length()<10)
                {  
                    JOptionPane.showMessageDialog(null, "Please Enter valid phone number!","warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                person.setFirstName(donorNameField.getText());
                person.setAddress1(addressField.getText());
                person.setTown(townField.getText());
                person.setZipCode(zipCodeField.getText());
                person.setOccupation(occupationField.getText());
                person.setDob(dateOfBirthVal);
                person.setPhoneNumber(phoneNumberField.getText());
                person.setEmailId(emailIDField.getText());
                userAccount.setPerson(person);
            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(this, "Please Enter valid details", "warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            catch(ParseException pe)
            {
                JOptionPane.showMessageDialog(this, "Please Enter valid date of birth", "warning",JOptionPane.WARNING_MESSAGE);
                 return;
            }

            
                JOptionPane.showMessageDialog(null, "Your Profile has been updated successfully", "success", JOptionPane.PLAIN_MESSAGE);
                updateJButton.setEnabled(true);
                saveJButton.setEnabled(false);
                donorNameField.setEnabled(false);
                donorDobField.setEnabled(false);
                addressField.setEnabled(false);
                townField.setEnabled(false);
                zipCodeField.setEnabled(false);
                occupationField.setEnabled(false);
                emailIDField.setEnabled(false);
                phoneNumberField.setEnabled(false);
         }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enter data in all the fields");
        }
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed

        donorNameField.setEnabled(true);
        donorDobField.setEnabled(true);
        addressField.setEnabled(true);
        townField.setEnabled(true);
        zipCodeField.setEnabled(true);
        occupationField.setEnabled(true);
        phoneNumberField.setEnabled(true);
        emailIDField.setEnabled(true);
        saveJButton.setEnabled(true);
        updateJButton.setEnabled(false);
        donorNameField.setEditable(true);
        donorDobField.setEditable(true);
        addressField.setEditable(true);
        townField.setEditable(true);
        zipCodeField.setEditable(true);
        occupationField.setEditable(true);
        phoneNumberField.setEditable(true);
        emailIDField.setEditable(true);
    }//GEN-LAST:event_updateJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel dateOfBirth;
    private javax.swing.JFormattedTextField donorDobField;
    private javax.swing.JLabel donorName;
    private javax.swing.JTextField donorNameField;
    private javax.swing.JLabel emailID;
    private javax.swing.JTextField emailIDField;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel occupation;
    private javax.swing.JTextField occupationField;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JButton saveJButton;
    private javax.swing.JLabel town;
    private javax.swing.JTextField townField;
    private javax.swing.JButton updateJButton;
    private javax.swing.JLabel zipCode;
    private javax.swing.JTextField zipCodeField;
    // End of variables declaration//GEN-END:variables
}
