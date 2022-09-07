/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfime;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author hp
 */
public class Accueil extends javax.swing.JFrame {
Connection conn;
PreparedStatement ps;
Statement st;
ResultSet rs;
DefaultTableModel dtm;
public static String t3;
String nom;


    
    
//    public void calculnombreadherant(){
//        try {
//       java.util.Date actuelle = new java.util.Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String date = dateFormat.format(actuelle);
//        String dc = date; 
//       String requetet ="select count(*) from  fidele where '" + dc +"'  " ;
//        ps = mycon.prepareStatement(requetet);
//        rs = ps.executeQuery();
//       if (rs.next()) {
//      int nbreadherant   = rs.getInt("count(fidele)");
//       String resultat = String.valueOf(nbreadherant);
//        nbfidele.setText(resultat);
//       }
//       
//        } catch (Exception e) {
//          JOptionPane.showMessageDialog(null, "deja existant");    
//        }
//     }
    
    

    /**
     * Creates new form Accueil
     */
  public Accueil() {
        initComponents();
        
        //modifier le titre du formulaire
        this.setTitle("Accueil");
        //centrer le formulaire
        this.setLocationRelativeTo(null);
        //ne pas permettre le redimensionnement du formulaire
        this.setResizable(false);
 
        dtm = new DefaultTableModel();
        dtm.addColumn("Matricule");
        dtm.addColumn("Code dîme");
        dtm.addColumn("Nom");
        dtm.addColumn("Prénoms");
        dtm.addColumn("Contact");
        dtm.addColumn("Fonction");
        dtm.addColumn("Profession");
        tabfideledime.setModel(dtm);
        
        datecourante() ;
        this.setIconImage(new ImageIcon(getClass().getResource("pentecote.png")).getImage());
        conn = ConexionBD.Conexion();

        // Calculer le nombre total de fidele de l'assemblée
        
        String requete="select count(*) from fidele";
        try {
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            while(rs.next()){
            fideletotal.setText(rs.getString(1)); 
             }        
        } catch (SQLException ex){
        // JOptionPane.showMessageDialog(this, "Problème de dénombrement des fidèles!");
        }
        
         // Calculer le nombre total de la dime de l'assemblée
        
        String requetet ="select sum(montantHebdo) from dime";
        try {
            ps = conn.prepareStatement(requetet);
            rs = ps.executeQuery();
            while(rs.next()){
            totaldime.setText(rs.getString(1)); 
             }        
        } catch (SQLException ex){
      // JOptionPane.showMessageDialog(this, "Problème de connexion avec la base de données");
        }
        
    }

    
    public void datecourante() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar Cal = new GregorianCalendar();

                    int sconde = Cal.get(Calendar.SECOND);
                    int minute = Cal.get(Calendar.MINUTE);
                    int heure = Cal.get(Calendar.HOUR);
                    int AM_PM = Cal.get(Calendar.AM_PM);  
                    String pa;
                    if(AM_PM==0){
                        pa="AM";
                    }else{
                        pa="PM";
                    }
                         
                    labheure.setText( + heure + ":" + (minute) + ":" + sconde +" "+pa  );
                    
                    int mois = Cal.get(Calendar.MONTH);
                    int annee = Cal.get(Calendar.YEAR);
                    int jour = Cal.get(Calendar.DAY_OF_MONTH);

                    labdate.setText( + jour + "/" + (mois+1) + "/" + annee);                    
                    
                    try {
                        sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        };
        
clock.start();  
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fidele = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        labheure = new javax.swing.JLabel();
        labdate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        contribution = new javax.swing.JButton();
        btnfidele = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rechvalacc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabfideledime = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fideletotal = new javax.swing.JLabel();
        totaldime = new javax.swing.JLabel();
        recherche = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        afficher = new javax.swing.JButton();

        fidele.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fidele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/multiple-users-silhouette.png"))); // NOI18N
        fidele.setText("Fidèles");
        fidele.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(153, 153, 0)));
        fidele.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fidele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fideleMouseReleased(evt);
            }
        });
        fidele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fideleActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 20, 64));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        labheure.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        labheure.setForeground(new java.awt.Color(255, 255, 255));
        labheure.setText("  09:00:00 PM");

        labdate.setFont(new java.awt.Font("Meiryo", 1, 18)); // NOI18N
        labdate.setForeground(new java.awt.Color(255, 255, 255));
        labdate.setText(" 01/01/2017");

        jLabel8.setBackground(java.awt.Color.blue);
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Accueil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296)
                .addComponent(labheure, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(labdate)
                .addGap(106, 106, 106))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labheure, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labdate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setDoubleBuffered(false);

        contribution.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        contribution.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/argent2nv.jpg"))); // NOI18N
        contribution.setText("Contribution");
        contribution.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(204, 153, 0)));
        contribution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contributionActionPerformed(evt);
            }
        });

        btnfidele.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnfidele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fidel.png"))); // NOI18N
        btnfidele.setText("Membre");
        btnfidele.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(0, 0, 204)));
        btnfidele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfideleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contribution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnfidele, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnfidele, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(contribution, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jLabel1.setText(" ");

        rechvalacc.setBackground(new java.awt.Color(204, 255, 204));
        rechvalacc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rechvalacc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rechvalacc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rechvalaccKeyPressed(evt);
            }
        });

        tabfideledime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabfideledime);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel9.setText("Total membre");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel10.setText("Total contribution");

        fideletotal.setText("              00");

        totaldime.setText("              00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fideletotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totaldime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fideletotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totaldime))
                .addContainerGap())
        );

        recherche.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        recherche.setText("Rechercher par nom");
        recherche.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.blue);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pentecote.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setText("QUE LA GLOIRE REVIENNE A NOTRE SEIGNEUR ET SAUVEUR JESUS-CHRIST");

        afficher.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        afficher.setForeground(java.awt.Color.blue);
        afficher.setText("Afficher le montant total par membre");
        afficher.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(recherche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(afficher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(63, 63, 63)
                                .addComponent(rechvalacc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rechvalacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(recherche))
                                .addGap(18, 18, 18)
                                .addComponent(afficher))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fideleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fideleActionPerformed

    }//GEN-LAST:event_fideleActionPerformed

    private void fideleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fideleMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fideleMouseReleased

    private void rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheActionPerformed
        // TODO add your handling code here:
       if (rechvalacc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Renseignez le champ de recherche !");
        }  
        else {    
          if(!rechvalacc.getText().equals("")){
              String reqrech = "select distinct fidele.numeroFidele,matricule as 'Matricule',codeDime as 'Code dîme',"
                             + "nom as 'Nom',prenoms as 'Prénoms',contact as 'Contact',fonction as 'Fonction',profession as 'Profession'"
                             + "from fidele inner join dime on fidele.numeroFidele = dime.numeroFidele "
                             + "where nom like? ";           
              try { 
                   ps = conn.prepareStatement(reqrech);
                   ps.setString(1, rechvalacc.getText());
                   rs= ps.executeQuery();
                   tabfideledime.setModel(DbUtils.resultSetToTableModel(rs));
                   rechvalacc.setText("");
              } catch (SQLException ex) {
//                  Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex); group by nom  +"%"
                  JOptionPane.showMessageDialog(null, "Cette donnée n'existe pas dans la base de données!");
              } 
            }
        }  
    }//GEN-LAST:event_rechercheActionPerformed

    private void contributionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contributionActionPerformed
        // TODO add your handling code here:
        Contribution ctbt = new Contribution();
        ctbt.setVisible(true);
    }//GEN-LAST:event_contributionActionPerformed

    private void btnfideleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfideleActionPerformed
        // TODO add your handling code here:
        Membre mbre = new Membre();
        mbre.setVisible(true);
    }//GEN-LAST:event_btnfideleActionPerformed

    private void afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherActionPerformed
        // TODO add your handling code here:

        try {
            String requete = "select fidele.numeroFidele as 'numeroFidele',matricule as 'Matricule',codeDime as 'Code dîme',"
            + "nom as 'Nom',prenoms as 'Prénoms',contact as 'contact',sum(montantHebdo) as 'Montant Hebdo' "
            + "from fidele inner join dime "
            + "on fidele.numeroFidele = dime.numeroFidele group by codeDime";
            //                           + "on fidele.matricule = enregistrerdime.matricule group by nom";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            tabfideledime.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_afficherActionPerformed

    private void rechvalaccKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechvalaccKeyPressed

      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           if (rechvalacc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Renseignez le champ de recherche !");
        }  
        else {    
          if(!rechvalacc.getText().equals("")){
              String reqrech = "select distinct fidele.numeroFidele,matricule as 'Matricule',codeDime as 'Code dîme',"
                             + "nom as 'Nom',prenoms as 'Prénoms',contact as 'Contact',fonction as 'Fonction',profession as 'Profession'"
                             + "from fidele inner join dime on fidele.numeroFidele = dime.numeroFidele "
                             + "where nom like? ";           
              try { 
                   ps = conn.prepareStatement(reqrech);
                   ps.setString(1, rechvalacc.getText());
                   rs= ps.executeQuery();
                   tabfideledime.setModel(DbUtils.resultSetToTableModel(rs));
                   rechvalacc.setText("");
              } catch (SQLException ex) {
//                  Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex); group by nom  +"%"
                  JOptionPane.showMessageDialog(null, "Cette donnée n'existe pas dans la base de données!");
              } 
            }
        }  
      }
       
    }//GEN-LAST:event_rechvalaccKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afficher;
    private javax.swing.JButton btnfidele;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton contribution;
    private javax.swing.JButton fidele;
    private javax.swing.JLabel fideletotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labdate;
    private javax.swing.JLabel labheure;
    private javax.swing.JButton recherche;
    private javax.swing.JTextField rechvalacc;
    private javax.swing.JTable tabfideledime;
    private javax.swing.JLabel totaldime;
    // End of variables declaration//GEN-END:variables
}
