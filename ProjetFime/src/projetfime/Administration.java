/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfime;



import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;


/**
 *
 * @author hp
 */
public class Administration extends javax.swing.JFrame {
Connection conn=null;
PreparedStatement ps;
Statement st;
ResultSet rs;
DefaultTableModel dtm;
static String test1;
static String te1;




   
    /**
     * Creates new form Te
     */
    public Administration() {
        initComponents();
        
        //modifier le titre du formulaire
        this.setTitle("Administration");
        //centrer le formulaire
        this.setLocationRelativeTo(null);
        //ne pas permettre le redimensionnement du formulaire
        this.setResizable(false);
    
        dtm = new DefaultTableModel();
        dtm.addColumn("Mot de passe");
        dtm.addColumn("Compte");
        dtm.addColumn("Nom");
        dtm.addColumn("Prénoms");
        tabutilisateur.setModel(dtm);
        
        this.setIconImage(new ImageIcon(getClass().getResource("pentecote.png")).getImage()); 
        conn = ConexionBD.Conexion();
        contributiontotalhebdomadaire();
        
        // Calculer le nombre total de fidele de l'assemblée
        
        String requete="select count(*) from fidele";
        try {
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            while(rs.next()){
            totalmembre.setText(rs.getString(1)); 
             }        
        } catch (SQLException ex){
//          JOptionPane.showMessageDialog(this, "Problème de dénombrement des fidèles!");
        }
        
        
         // Calculer le nombre total de fideles hommes de l'assemblée.
//        String req="select count(*) from membre where sexe = 'masculin' and age >19";
        String req="select count(*) from membre where sexe = 'masculin'";
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while(rs.next()){
            totalhomme.setText(rs.getString(1)); 
             }        
        } catch (SQLException ex){
//          JOptionPane.showMessageDialog(this, "Problème de dénombrement des fidèles!");
        }
        
         // Calculer le nombre total de fideles femmes de l'assemblée.
        
        String reqf="select count(*) from membre where sexe = 'feminin' ";
        try {
            ps = conn.prepareStatement(reqf);
            rs = ps.executeQuery();
            while(rs.next()){
            totalfemme.setText(rs.getString(1)); 
             }        
        } catch (SQLException ex){
//          JOptionPane.showMessageDialog(this, "Problème de dénombrement des fidèles!");
        }
        
         // Calculer le nombre total de la dime de l'assemblée
        
        String requetet ="select sum(montantVerse) from contribution";
        try {
            ps = conn.prepareStatement(requetet);
            rs = ps.executeQuery();
            while(rs.next()){
            totalmontantgle.setText(rs.getString(1)); 
             }        
        } catch (SQLException ex){
      // JOptionPane.showMessageDialog(this, "Problème de connexion avec la base de données");
        }
        
    }
   
   // Calculer le montant total de la dîme hebdomadaire au jour de culte de l'assemblée 
   public void contributiontotalhebdomadaire(){
        try {
        java.util.Date actuelle = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateVersement = dateFormat.format(actuelle);
        String dc = dateVersement;     
        String reqdime ="select sum(montantVerse) from enregistrercontribution where dateVersement = '" + dc +"' ";
        ps = conn.prepareStatement(reqdime);
        rs = ps.executeQuery();
        while(rs.next()){
        totalmontantactuel.setText(rs.getString(1)); 
        }
       } catch (SQLException ex){
      // JOptionPane.showMessageDialog(this, "Problème de connexion avec la base de données");
        }
        
       }
    
    


    
    
    public void rechercherpress(){
        if(rechvalutil.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Renseignez le champ de recherche !");         
        }  
        else {    
          if(!rechvalutil.getText().equals("")){
        String req = "select motpasse,compte,qualite,nom,prenoms from utilisateur where nom like '"+rechvalutil.getText()+"%'";
            try { 
                   ps = conn.prepareStatement(req);
                   ps.setString(1, "%"+rechvalutil.getText()+"%");
                   rs= ps.executeQuery();
                   tabutilisateur.setModel(DbUtils.resultSetToTableModel(rs));
                   rechvalutil.setText("");
            }
        catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Cette donnée n'existe pas dans la base de données!");
          }
        }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rechercherut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        gestioncontribution = new javax.swing.JButton();
        utilisateur = new javax.swing.JButton();
        Accueil = new javax.swing.JButton();
        gestmembre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabutilisateur = new javax.swing.JTable();
        rechvalutil = new javax.swing.JTextField();
        imprimutil = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalhomme = new javax.swing.JLabel();
        totalfemme = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalmembre = new javax.swing.JLabel();
        totalmontantgle = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalmontantactuel = new javax.swing.JLabel();
        miseazeroutil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 20, 64));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel8.setBackground(java.awt.Color.blue);
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Aministration");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel1.setText("Eglise Pentecote Internationale de Côte d'Ivoire ");

        rechercherut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rechercherut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        rechercherut.setText("Rechercher par nom");
        rechercherut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rechercherut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherutActionPerformed(evt);
            }
        });
        rechercherut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rechercherutKeyPressed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setDoubleBuffered(false);

        gestioncontribution.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gestioncontribution.setText("Contribution");
        gestioncontribution.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(51, 0, 204)));
        gestioncontribution.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gestioncontributionMouseReleased(evt);
            }
        });
        gestioncontribution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestioncontributionActionPerformed(evt);
            }
        });

        utilisateur.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        utilisateur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        utilisateur.setText("Utilisateurs");
        utilisateur.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(0, 0, 0)));
        utilisateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                utilisateurMouseReleased(evt);
            }
        });
        utilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilisateurActionPerformed(evt);
            }
        });

        Accueil.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Accueil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/accueil1.png"))); // NOI18N
        Accueil.setText("Accueil");
        Accueil.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(0, 255, 204)));
        Accueil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Accueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AccueilMouseReleased(evt);
            }
        });
        Accueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccueilActionPerformed(evt);
            }
        });

        gestmembre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gestmembre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/multiple-users-silhouette.png"))); // NOI18N
        gestmembre.setText("Membre");
        gestmembre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(0, 204, 0)));
        gestmembre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gestmembre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gestmembreMouseReleased(evt);
            }
        });
        gestmembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestmembreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Accueil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(gestioncontribution, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(utilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gestmembre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Accueil, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(gestmembre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(gestioncontribution, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(utilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tabutilisateur.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabutilisateur.setModel(new javax.swing.table.DefaultTableModel(
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
        tabutilisateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabutilisateurMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabutilisateur);

        rechvalutil.setBackground(new java.awt.Color(204, 255, 204));
        rechvalutil.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rechvalutil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rechvalutil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rechvalutilKeyPressed(evt);
            }
        });

        imprimutil.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        imprimutil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        imprimutil.setText("Imprimer");
        imprimutil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imprimutil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimutilActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 5, 1, new java.awt.Color(0, 102, 255)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Hommes");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Femmes");

        totalhomme.setText("              00");

        totalfemme.setText("              00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(totalhomme, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addGap(102, 102, 102)
                .addComponent(totalfemme, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalfemme)
                    .addComponent(jLabel4)
                    .addComponent(totalhomme)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 1, new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Total membre");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Montant total");

        totalmembre.setText("                    00");

        totalmontantgle.setText("                   00");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Montant actuel");

        totalmontantactuel.setText("                    00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalmontantactuel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalmontantgle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalmembre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(totalmembre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(totalmontantactuel))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(totalmontantgle))
                .addContainerGap())
        );

        miseazeroutil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/actualiser.jpg"))); // NOI18N
        miseazeroutil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        miseazeroutil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miseazeroutilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imprimutil, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(miseazeroutil, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rechercherut)
                        .addGap(18, 18, 18)
                        .addComponent(rechvalutil, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rechercherut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rechvalutil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(miseazeroutil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imprimutil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rechercherutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherutActionPerformed

        if(rechvalutil.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Renseignez le champ de recherche !");
        }  
        else {    
          if(!rechvalutil.getText().equals("")){
          String req = "select motpasse,compte,qualite,nom,prenoms from utilisateur where nom like?";   
              try { 
                   ps = conn.prepareStatement(req);
                   ps.setString(1, "%"+rechvalutil.getText()+"%");
                   rs= ps.executeQuery();
                   tabutilisateur.setModel(DbUtils.resultSetToTableModel(rs));
                   rechvalutil.setText("");
              } catch (SQLException ex) {
//                  Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Cette donnée n'existe pas dans la base de données!");
              } 
            }
        }  
       
    }//GEN-LAST:event_rechercherutActionPerformed

    private void gestioncontributionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestioncontributionMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_gestioncontributionMouseReleased

    private void gestioncontributionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestioncontributionActionPerformed
        Contribution ctb = new Contribution();
                     ctb.setVisible(true);
        //               this.dispose();
    }//GEN-LAST:event_gestioncontributionActionPerformed

    private void utilisateurMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_utilisateurMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_utilisateurMouseReleased

    private void utilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utilisateurActionPerformed
        Utilisateur ut = new Utilisateur();
                    ut.setVisible(true);
//                    this.dispose();
    }//GEN-LAST:event_utilisateurActionPerformed

    private void AccueilMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccueilMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_AccueilMouseReleased

    private void AccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccueilActionPerformed
        // TODO add your handling code here:
        Accueil acc = new Accueil ();
                acc.setVisible(true);
//                   this.dispose();
    }//GEN-LAST:event_AccueilActionPerformed

    private void tabutilisateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabutilisateurMouseClicked

    }//GEN-LAST:event_tabutilisateurMouseClicked

    private void rechercherutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercherutKeyPressed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_rechercherutKeyPressed

    private void gestmembreMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestmembreMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_gestmembreMouseReleased

    private void gestmembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestmembreActionPerformed
        // TODO add your handling code here:
        Membre mbre = new Membre();
        mbre.setVisible(true);
    }//GEN-LAST:event_gestmembreActionPerformed

    private void imprimutilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimutilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imprimutilActionPerformed

    private void rechvalutilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechvalutilKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
          if(rechvalutil.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Renseignez le champ de recherche !");
        }  
        else {    
          if(!rechvalutil.getText().equals("")){
          String req = "select motpasse,compte,qualite,nom,prenoms from utilisateur where nom like?";   
              try { 
                   ps = conn.prepareStatement(req);
                   ps.setString(1, "%"+rechvalutil.getText()+"%");
                   rs= ps.executeQuery();
                   tabutilisateur.setModel(DbUtils.resultSetToTableModel(rs));
                   rechvalutil.setText("");
              } catch (SQLException ex) {
//                  Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Cette donnée n'existe pas dans la base de données!");
              } 
            }
        }    
        }
    }//GEN-LAST:event_rechvalutilKeyPressed

    private void miseazeroutilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miseazeroutilActionPerformed
        Administration admin = new Administration();
        admin.setVisible(true);
        dispose();
    }//GEN-LAST:event_miseazeroutilActionPerformed

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
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accueil;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton gestioncontribution;
    private javax.swing.JButton gestmembre;
    private javax.swing.JButton imprimutil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton miseazeroutil;
    private javax.swing.JButton rechercherut;
    private javax.swing.JTextField rechvalutil;
    private javax.swing.JTable tabutilisateur;
    private javax.swing.JLabel totalfemme;
    private javax.swing.JLabel totalhomme;
    private javax.swing.JLabel totalmembre;
    private javax.swing.JLabel totalmontantactuel;
    private javax.swing.JLabel totalmontantgle;
    private javax.swing.JButton utilisateur;
    // End of variables declaration//GEN-END:variables
}
