package ppe2022_pharmacie;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AfficherTousLesStock extends javax.swing.JFrame {
    
    MedicamentDAO passerelleMedicament = new MedicamentDAO();
    
    ArrayList<Medicament> unStock = new ArrayList<Medicament>();
    Scanner sc = new Scanner(System.in);
    private Utilisateur unUser;

    public AfficherTousLesStock(Utilisateur unUtilisateur) {
        
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        unUser = unUtilisateur;
        initComponents();
        passerelleMedicament.Connection();

        DefaultListModel listModel = new DefaultListModel();
        for (Medicament pdt : passerelleMedicament.findAll()) {
            listModel.addElement(pdt);
        }
        lstAfficherTous.setModel(listModel);

        ArrayList<String> ArrayCategorie = passerelleMedicament.donnerCategorie();
        for (String c : ArrayCategorie) {
            cbxCategorie.addItem(c);
        }
        
        lblUser1.setText(unUtilisateur.getLogin()+": "+unUtilisateur.getService());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        lblTitre1 = new javax.swing.JLabel();
        lblAfficherTous1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnActualiser1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAfficherTous1 = new javax.swing.JList<>();
        btnActualiser2 = new javax.swing.JButton();
        btnActualiser3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblTitre = new javax.swing.JLabel();
        lblAfficherTous = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnActualiser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAfficherTous = new javax.swing.JList<>();
        btnSeuil = new javax.swing.JButton();
        cbxCategorie = new javax.swing.JComboBox<>();
        btnCategorie = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        btnDeconnexion = new javax.swing.JButton();
        btnDemandes = new javax.swing.JButton();
        lblUser1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitre1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitre1.setForeground(new java.awt.Color(255, 51, 51));
        lblTitre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitre1.setText("Gestion Stock");

        lblAfficherTous1.setText("Afficher tous les produits");

        jButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Fermer");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnActualiser1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnActualiser1.setForeground(new java.awt.Color(255, 51, 51));
        btnActualiser1.setText("Actualiser");
        btnActualiser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualiser1MouseClicked(evt);
            }
        });
        btnActualiser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiser1ActionPerformed(evt);
            }
        });

        lstAfficherTous1.setToolTipText("");
        lstAfficherTous1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAfficherTous1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstAfficherTous1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblAfficherTous1))
                            .addComponent(lblTitre1))
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                        .addComponent(btnActualiser1)
                        .addGap(168, 168, 168)
                        .addComponent(jButton2)
                        .addContainerGap())))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAfficherTous1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualiser1)
                    .addComponent(jButton2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnActualiser2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnActualiser2.setForeground(new java.awt.Color(255, 51, 51));
        btnActualiser2.setText("Actualiser");
        btnActualiser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualiser2MouseClicked(evt);
            }
        });
        btnActualiser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiser2ActionPerformed(evt);
            }
        });

        btnActualiser3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnActualiser3.setForeground(new java.awt.Color(255, 51, 51));
        btnActualiser3.setText("Actualiser");
        btnActualiser3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualiser3MouseClicked(evt);
            }
        });
        btnActualiser3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiser3ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitre.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitre.setForeground(new java.awt.Color(255, 51, 51));
        lblTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitre.setText("Gestion Stock Medicament");

        lblAfficherTous.setText("Afficher tous les produits");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Fermer");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnActualiser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnActualiser.setForeground(new java.awt.Color(255, 51, 51));
        btnActualiser.setText("Actualiser");
        btnActualiser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualiserMouseClicked(evt);
            }
        });
        btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiserActionPerformed(evt);
            }
        });

        lstAfficherTous.setToolTipText("");
        lstAfficherTous.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAfficherTousMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstAfficherTous);

        btnSeuil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSeuil.setForeground(new java.awt.Color(255, 51, 51));
        btnSeuil.setText("Seuil");
        btnSeuil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeuilMouseClicked(evt);
            }
        });
        btnSeuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeuilActionPerformed(evt);
            }
        });

        cbxCategorie.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbxCategorie.setForeground(new java.awt.Color(255, 51, 51));
        cbxCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategorieActionPerformed(evt);
            }
        });

        btnCategorie.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCategorie.setForeground(new java.awt.Color(255, 51, 51));
        btnCategorie.setText("Lister par catégorie");
        btnCategorie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategorieMouseClicked(evt);
            }
        });
        btnCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategorieActionPerformed(evt);
            }
        });

        btnDeconnexion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnDeconnexion.setForeground(new java.awt.Color(255, 51, 51));
        btnDeconnexion.setText("Déconnexion");
        btnDeconnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeconnexionMouseClicked(evt);
            }
        });
        btnDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeconnexionActionPerformed(evt);
            }
        });

        btnDemandes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnDemandes.setForeground(new java.awt.Color(255, 51, 51));
        btnDemandes.setText("Afficher les demandes");
        btnDemandes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDemandesMouseClicked(evt);
            }
        });
        btnDemandes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemandesActionPerformed(evt);
            }
        });

        lblUser1.setText(".");

        jButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("Afficher Commandes");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 51));
        jButton4.setText("Ajouter Médicament");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cliquer sur  \"Lister par catégorie\" pour actualiser la liste selon la catégorie.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDemandes)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnActualiser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSeuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(132, 132, 132))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(cbxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(130, 130, 130))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88)))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 3, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitre)
                        .addGap(316, 316, 316))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAfficherTous)
                .addGap(403, 403, 403))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAfficherTous)
                .addGap(18, 18, 18)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualiser)
                        .addGap(19, 19, 19)
                        .addComponent(btnSeuil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDemandes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualiserActionPerformed

    private void btnActualiserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualiserMouseClicked

        unStock = passerelleMedicament.findAll();

        DefaultListModel listModel = new DefaultListModel();
        for (Medicament pdt : passerelleMedicament.findAll()) {
            listModel.addElement(pdt);
        }
        lstAfficherTous.setModel(listModel);
        String tous = "Tous";
        cbxCategorie.setSelectedItem(tous);
    }//GEN-LAST:event_btnActualiserMouseClicked

    private void lstAfficherTousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAfficherTousMouseClicked
        int choix = lstAfficherTous.getSelectedIndex();
        Object val = lstAfficherTous.getModel().getElementAt(choix);
        Medicament unPdt = (Medicament) val;
        
        PasserCommande g= new PasserCommande(unPdt);g.setVisible(true);
    }//GEN-LAST:event_lstAfficherTousMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnActualiser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualiser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualiser1MouseClicked

    private void btnActualiser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualiser1ActionPerformed

    private void lstAfficherTous1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAfficherTous1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lstAfficherTous1MouseClicked

    private void btnActualiser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualiser2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualiser2MouseClicked

    private void btnActualiser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiser2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualiser2ActionPerformed

    private void btnActualiser3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualiser3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualiser3MouseClicked

    private void btnActualiser3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiser3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualiser3ActionPerformed

    private void btnSeuilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeuilMouseClicked
        unStock = MedicamentDAO.donnerStockSeuil();

        DefaultListModel listModel = new DefaultListModel();
        for (Medicament pdt : MedicamentDAO.donnerStockSeuil()) {
            listModel.addElement(pdt);
        }
        lstAfficherTous.setModel(listModel);
        String tous = "Tous";
        cbxCategorie.setSelectedItem(tous);
    }//GEN-LAST:event_btnSeuilMouseClicked

    private void btnSeuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeuilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeuilActionPerformed

    private void cbxCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategorieActionPerformed

    private void btnCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategorieActionPerformed

    private void btnCategorieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategorieMouseClicked
        // TODO add your handling code here:
        String Tous = "Tous";
        if (cbxCategorie.getSelectedItem() == Tous) {
            DefaultListModel listModel = new DefaultListModel();
            for (Medicament pdt : passerelleMedicament.findAll()) {
                listModel.addElement(pdt);
            }
            lstAfficherTous.setModel(listModel);
        } else {
            DefaultListModel listModel = new DefaultListModel();
            for (Medicament pdt : MedicamentDAO.AfficheEnFonctionCategorie(cbxCategorie.getSelectedItem().toString())) {
                listModel.addElement(pdt);
            }
            lstAfficherTous.setModel(listModel);
        }


    }//GEN-LAST:event_btnCategorieMouseClicked

    private void btnDeconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeconnexionMouseClicked
        new Authentification().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeconnexionMouseClicked

    private void btnDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeconnexionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeconnexionActionPerformed

    private void btnDemandesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDemandesMouseClicked
        String tous = "Tous";
        cbxCategorie.setSelectedItem(tous);
        new AfficherDemandes(true, unUser).setVisible(true);
    }//GEN-LAST:event_btnDemandesMouseClicked

    private void btnDemandesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemandesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDemandesActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        String tous = "Tous";
        cbxCategorie.setSelectedItem(tous);
        new AfficherCommande().setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        String tous = "Tous";
        cbxCategorie.setSelectedItem(tous);
        new AjouterMedicament().setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(AfficherTousLesStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfficherTousLesStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfficherTousLesStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfficherTousLesStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnActualiser1;
    private javax.swing.JButton btnActualiser2;
    private javax.swing.JButton btnActualiser3;
    private javax.swing.JButton btnCategorie;
    private javax.swing.JButton btnDeconnexion;
    private javax.swing.JButton btnDemandes;
    private javax.swing.JButton btnSeuil;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxCategorie;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAfficherTous;
    private javax.swing.JLabel lblAfficherTous1;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JLabel lblTitre1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JList<String> lstAfficherTous;
    private javax.swing.JList<String> lstAfficherTous1;
    // End of variables declaration//GEN-END:variables
}
