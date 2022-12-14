/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfime;;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author hp
 */
public class Membre extends javax.swing.JFrame {
Connection conn;
PreparedStatement ps;
Statement st;
ResultSet rs;
static String test;

    /**
     * Creates new form Fidele
     */
    
    
    public Membre(){
        initComponents();
        
        //modifier le titre du formulaire
        this.setTitle("Membre");
        //centrer le formulaire
        this.setLocationRelativeTo(null);
        //ne pas permettre le redimensionnement du formulaire
        this.setResizable(false);   
        this.setIconImage(new ImageIcon(getClass().getResource("pentecote.png")).getImage());
        conn = ConexionBD.Conexion();
    }
     
    public void cleardonnee() {    
        mat.setText("");
        nommembre.setText("");
        prenommembre.setText("");
        combosexe.setSelectedIndex(-1);
        datenaiss.setDate(null);
        combomariage.setSelectedIndex(-1);
        contactmembre.setText("");
        quartiermembre.setText("");
    }

    public void afficherMembre(){
        try {
              String requete = "select numMembre,matricule,nomMembre,prenomMembre,sexe,dateNaissance,"
                             + "situationMaritale,contact,quartier from membre";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            tablemembre.setModel(DbUtils.resultSetToTableModel(rs));
          }  catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "erreur BD");
        }
    }

    /** combomariage.setSelectedIndex(-1);
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ajouterMembre = new javax.swing.JButton();
        prenommembre = new javax.swing.JTextField();
        mat = new javax.swing.JTextField();
        nommembre = new javax.swing.JTextField();
        contactmembre = new javax.swing.JTextField();
        quartiermembre = new javax.swing.JTextField();
        modifier = new javax.swing.JButton();
        searchMembre = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combosexe = new javax.swing.JComboBox();
        actualiser = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        combomariage = new javax.swing.JComboBox();
        accueil = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablemembre = new javax.swing.JTable();
        afficherMembre = new javax.swing.JButton();
        imprimfideledime = new javax.swing.JButton();
        matrech = new javax.swing.JTextField();
        datenaiss = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enregistrement des fid??les", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), java.awt.Color.blue)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Matricule");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Nom");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Pr??noms");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("Quartier");

        ajouterMembre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ajouterMembre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Add-icon.png"))); // NOI18N
        ajouterMembre.setText("Ajouter");
        ajouterMembre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ajouterMembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterMembreActionPerformed(evt);
            }
        });

        prenommembre.setBackground(new java.awt.Color(204, 255, 204));
        prenommembre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        prenommembre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        mat.setBackground(new java.awt.Color(204, 255, 204));
        mat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        nommembre.setBackground(new java.awt.Color(204, 255, 204));
        nommembre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nommembre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        contactmembre.setBackground(new java.awt.Color(204, 255, 204));
        contactmembre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        contactmembre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        quartiermembre.setBackground(new java.awt.Color(204, 255, 204));
        quartiermembre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quartiermembre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        modifier.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update icon.png"))); // NOI18N
        modifier.setText("Modifier");
        modifier.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        searchMembre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        searchMembre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        searchMembre.setText("Recherche par le matricule");
        searchMembre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchMembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMembreActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Sexe");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("Contact");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Date de naissance");

        combosexe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        combosexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculin", "Feminin" }));
        combosexe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        actualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/actualiser.jpg"))); // NOI18N
        actualiser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualiserActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Situation maritale");

        combomariage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        combomariage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mari??(e)", "C??libataire" }));
        combomariage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        accueil.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        accueil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/accueil1.png"))); // NOI18N
        accueil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        accueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accueilActionPerformed(evt);
            }
        });

        tablemembre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 185, 244)));
        tablemembre.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tablemembre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N?? membre", "Matricule", "Nom", "Pr??noms", "Sexe", "DateNaissance", "Situation maritale", "Contact", "Quartier"
            }
        ));
        tablemembre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablemembreMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablemembre);

        afficherMembre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        afficherMembre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icone affichage1.jpg"))); // NOI18N
        afficherMembre.setText("Afficher");
        afficherMembre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        afficherMembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficherMembreActionPerformed(evt);
            }
        });

        imprimfideledime.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        imprimfideledime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        imprimfideledime.setText("Rapport");
        imprimfideledime.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imprimfideledime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimfideledimeActionPerformed(evt);
            }
        });

        matrech.setBackground(new java.awt.Color(204, 255, 204));
        matrech.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        matrech.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        datenaiss.setBackground(new java.awt.Color(204, 255, 204));
        datenaiss.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        datenaiss.setForeground(new java.awt.Color(204, 255, 204));
        datenaiss.setDateFormatString("yyyy-MM-dd");
        datenaiss.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        datenaiss.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                datenaissComponentAdded(evt);
            }
        });
        datenaiss.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                datenaissAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        datenaiss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                datenaissMouseReleased(evt);
            }
        });
        datenaiss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datenaissKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(ajouterMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(afficherMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(imprimfideledime, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(accueil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(searchMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(matrech, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(prenommembre)
                                    .addComponent(nommembre)
                                    .addComponent(combosexe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(88, 88, 88)
                                .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(168, 168, 168)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(combomariage, 0, 150, Short.MAX_VALUE)
                                .addComponent(contactmembre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(quartiermembre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addComponent(datenaiss, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accueil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(matrech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(datenaiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nommembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(combomariage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(prenommembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactmembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combosexe, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addComponent(quartiermembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel12)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(afficherMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimfideledime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void ajouterMembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterMembreActionPerformed
    
        String reqins = "insert into membre (matricule,nomMembre,prenomMembre,sexe,dateNaissance,"
                      + "situationMaritale,contact,quartier) values(?,?,?,?,?,?,?,?)";
        try{  
            ps = conn.prepareStatement(reqins);
            ps.setString(1, mat.getText());
            ps.setString(2, nommembre.getText());
            ps.setString(3, prenommembre.getText());
            ps.setString(4, (String) combosexe.getSelectedItem());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(datenaiss.getDate());
            ps.setString(5, date);
            ps.setString(6, (String) combomariage.getSelectedItem());
            ps.setString(7, contactmembre.getText());
            ps.setString(8, quartiermembre.getText());
            ps.executeUpdate();
//          JOptionPane.showMessageDialog(this,"Insertion r??ussie!!!");
            mat.setText("");
            nommembre.setText("");
            prenommembre.setText("");
            combosexe.setSelectedIndex(-1);
            datenaiss.setDate(null);
            combomariage.setSelectedIndex(-1);
            contactmembre.setText("");
            quartiermembre.setText("");
            afficherMembre();
            } catch (SQLException ex) {
            Logger.getLogger(Membre.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showInputDialog(null, "Cet matricule existe dej??, Veuillez changer de matricule!"+ex.getMessage());
        } 
    }//GEN-LAST:event_ajouterMembreActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        
        DefaultTableModel d1 = (DefaultTableModel)tablemembre.getModel();
        int selectIndex = tablemembre.getSelectedRow();

        int numMembre = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        String matricule = mat.getText();
        String nomMembre  = nommembre.getText();
        String prenomMembre = prenommembre.getText();
        String sexe = (String) combosexe.getSelectedItem();
        String dateNaissance = ((JTextField) datenaiss.getDateEditor().getUiComponent()).getText();
        String situationMaritale = (String) combomariage.getSelectedItem(); 
        String contact = contactmembre.getText();
        String quartier = quartiermembre.getText();
        
        try {    
        ps = conn.prepareStatement("update membre set matricule=?,nomMembre=?,prenomMembre=?,sexe=?,dateNaissance=?,"
                     + "situationMaritale=?,contact=?,quartier=? where numMembre=?");
        ps.setString(1, matricule);
        ps.setString(2, nomMembre);
        ps.setString(3, prenomMembre);
        ps.setString(4, sexe);
        ps.setString(5, dateNaissance);
        ps.setString(6, situationMaritale);
        ps.setString(7,contact);
        ps.setString(8,quartier); 
        ps.setInt(9, numMembre);
        ps.executeUpdate();
//      JOptionPane.showMessageDialog(null,"Mise ?? jour effectu??e!");
            afficherMembre();
            
            mat.setText("");
            nommembre.setText("");
            prenommembre.setText("");
            combosexe.setSelectedIndex(-1);
            datenaiss.setDate(null);
            combomariage.setSelectedIndex(-1);
            contactmembre.setText("");
            quartiermembre.setText("");
         
            mat.requestFocus();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Membre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_modifierActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  
    }//GEN-LAST:event_formWindowOpened

    private void searchMembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMembreActionPerformed

        DefaultTableModel model = (DefaultTableModel) tablemembre.getModel();
                 model.setRowCount(0); // vider le tableau
                try{
                        st= (Statement) conn.createStatement();
//                        String req="select * from membre where matricule='"+matrech.getText()+"'";
                        String req = "select numMembre,matricule,nomMembre,prenomMembre,sexe,dateNaissance,"
                                   + "situationMaritale,contact,quartier from membre where matricule='"+matrech.getText()+"'";
                        rs=st.executeQuery(req);
            //          while(rs.next()){
                           if (rs.next()) {
                             Object [] fide={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                             rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
                                  model.addRow(fide);
                              }else{
                                JOptionPane.showMessageDialog(null, "V??rifier votre saisie !");
                            }
                          tablemembre.setModel(model); 
                           matrech.setText("");
                        }
                    catch(SQLException se){
                            JOptionPane.showMessageDialog(this, se.getMessage());
                        }
  
    }//GEN-LAST:event_searchMembreActionPerformed

    private void actualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualiserActionPerformed
        // TODO add your handling code here:
        Membre fidele = new Membre();
        fidele.setVisible(true);
        dispose();
    }//GEN-LAST:event_actualiserActionPerformed

    private void accueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accueilActionPerformed
        // TODO add your handling code here:
        Accueil acc = new Accueil();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_accueilActionPerformed

    private void tablemembreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablemembreMouseClicked
         
         try{
            int row = tablemembre.getSelectedRow();
            this.test = (tablemembre.getModel().getValueAt(row, 0).toString());
            String req = " select * from  membre where numMembre = '" + test + "' ";
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
           if (rs.next()) {
            mat.setText(rs.getString("matricule"));
            nommembre.setText(rs.getString("nomMembre"));
            prenommembre.setText(rs.getString("prenomMembre"));
            combosexe.setSelectedItem(rs.getString("sexe"));
            datenaiss.setDate(rs.getDate("dateNaissance"));
            combomariage.setSelectedItem(rs.getString("situationMaritale"));
            contactmembre.setText(rs.getString("contact"));
            quartiermembre.setText(rs.getString("quartier"));
            }  
        } catch(SQLException ex){
            
       }
            
    }//GEN-LAST:event_tablemembreMouseClicked

    private void afficherMembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherMembreActionPerformed
        // TODO add your handling code here:
      afficherMembre();
    }//GEN-LAST:event_afficherMembreActionPerformed

    private void imprimfideledimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimfideledimeActionPerformed
        try {
            // TODO add your handling code here:
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Kluce\\Documents\\NetBeansProjects\\fimeco\\src\\report\\ListeMembre.jrxml");
            String query = "select matricule,nomMembre,prenomMembre,sexe,dateNaissance,situationMaritale,contact,quartier from membre";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jdesign.setQuery(updateQuery);

            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport,null, conn);

            JasperViewer.viewReport(jprint);

        } catch (JRException ex) {
            Logger.getLogger(Membre.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_imprimfideledimeActionPerformed

    private void datenaissComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_datenaissComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_datenaissComponentAdded

    private void datenaissAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_datenaissAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_datenaissAncestorAdded

    private void datenaissMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datenaissMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_datenaissMouseReleased

    private void datenaissKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datenaissKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_datenaissKeyReleased

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
            java.util.logging.Logger.getLogger(Membre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Membre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Membre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Membre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Membre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accueil;
    private javax.swing.JButton actualiser;
    private javax.swing.JButton afficherMembre;
    private javax.swing.JButton ajouterMembre;
    private javax.swing.JComboBox combomariage;
    private javax.swing.JComboBox combosexe;
    private javax.swing.JTextField contactmembre;
    private com.toedter.calendar.JDateChooser datenaiss;
    private javax.swing.JButton imprimfideledime;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mat;
    private javax.swing.JTextField matrech;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField nommembre;
    private javax.swing.JTextField prenommembre;
    private javax.swing.JTextField quartiermembre;
    private javax.swing.JButton searchMembre;
    private javax.swing.JTable tablemembre;
    // End of variables declaration//GEN-END:variables
}
