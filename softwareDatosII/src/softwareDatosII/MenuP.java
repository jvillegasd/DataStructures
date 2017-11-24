package softwareDatosII;

import javax.swing.JOptionPane;

public class MenuP extends javax.swing.JFrame {

    ArbolBST arbolBST = null;
    Ordenamientos ordenamientos;
    private boolean buscarArbol = false, modoArbol = true, modoOrd = false, BFS = false;
    int[] vector = new int[10000];
    int tam = 0;

    public MenuP() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Software Estructura de Datos II");
        creadorJD.setResizable(false);
        creadorJD.setLocation(this.getWidth() + 150, this.getHeight()/2 + 50);
        creadorJD.setSize(220, 150);
        initOpOrd();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        creadorJD = new javax.swing.JDialog();
        tituloLb = new javax.swing.JLabel();
        titulo2Lb = new javax.swing.JLabel();
        nombreCreadorLb = new javax.swing.JLabel();
        gitLb = new javax.swing.JLabel();
        panelDibujo = new javax.swing.JPanel();
        agregarLb = new javax.swing.JLabel();
        datoTF = new javax.swing.JTextField();
        agregarBt = new javax.swing.JButton();
        buscarRB = new javax.swing.JRadioButton();
        BFSRB = new javax.swing.JRadioButton();
        resetBt = new javax.swing.JButton();
        insertSRB = new javax.swing.JRadioButton();
        selectSRB = new javax.swing.JRadioButton();
        barraMenu = new javax.swing.JMenuBar();
        opBarraMenu = new javax.swing.JMenu();
        ordMenuItem = new javax.swing.JMenuItem();
        arbolMenuItem = new javax.swing.JMenuItem();
        creadorMenu = new javax.swing.JMenu();

        creadorJD.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                creadorJDWindowClosed(evt);
            }
        });

        tituloLb.setText("Software Estructura de Datos II");

        titulo2Lb.setText("Creado por:");

        nombreCreadorLb.setText("Johnny Villegas Garcia");

        gitLb.setText("GitHub: C9-LinkRs");

        javax.swing.GroupLayout creadorJDLayout = new javax.swing.GroupLayout(creadorJD.getContentPane());
        creadorJD.getContentPane().setLayout(creadorJDLayout);
        creadorJDLayout.setHorizontalGroup(
            creadorJDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creadorJDLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(creadorJDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creadorJDLayout.createSequentialGroup()
                        .addComponent(tituloLb)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creadorJDLayout.createSequentialGroup()
                        .addComponent(titulo2Lb)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creadorJDLayout.createSequentialGroup()
                        .addGroup(creadorJDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreCreadorLb)
                            .addGroup(creadorJDLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(gitLb)))
                        .addGap(45, 45, 45))))
        );
        creadorJDLayout.setVerticalGroup(
            creadorJDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creadorJDLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tituloLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo2Lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreCreadorLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gitLb)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelDibujoLayout = new javax.swing.GroupLayout(panelDibujo);
        panelDibujo.setLayout(panelDibujoLayout);
        panelDibujoLayout.setHorizontalGroup(
            panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        panelDibujoLayout.setVerticalGroup(
            panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        agregarLb.setText("Agregar nodo:");

        agregarBt.setText("Agregar");
        agregarBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarBtMouseClicked(evt);
            }
        });

        buttonGroup.add(buscarRB);
        buscarRB.setText("Buscar nodo");
        buscarRB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarRBMouseClicked(evt);
            }
        });

        buttonGroup.add(BFSRB);
        BFSRB.setText("BFS");
        BFSRB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BFSRBMouseClicked(evt);
            }
        });

        resetBt.setText("Reset");
        resetBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetBtMouseClicked(evt);
            }
        });

        buttonGroup.add(insertSRB);
        insertSRB.setText("insertSort");
        insertSRB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertSRBMouseClicked(evt);
            }
        });

        buttonGroup.add(selectSRB);
        selectSRB.setText("selectSort");
        selectSRB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectSRBMouseClicked(evt);
            }
        });

        opBarraMenu.setText("Opciones");

        ordMenuItem.setText("Ordenamientos");
        ordMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ordMenuItemMouseReleased(evt);
            }
        });
        opBarraMenu.add(ordMenuItem);

        arbolMenuItem.setText("Arbol BST");
        arbolMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                arbolMenuItemMouseReleased(evt);
            }
        });
        opBarraMenu.add(arbolMenuItem);

        barraMenu.add(opBarraMenu);

        creadorMenu.setText("Leer mas");
        creadorMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creadorMenuMouseClicked(evt);
            }
        });
        barraMenu.add(creadorMenu);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(agregarLb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(datoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buscarRB)
                                        .addGap(8, 8, 8)
                                        .addComponent(BFSRB)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(agregarBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resetBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertSRB)
                                .addGap(18, 18, 18)
                                .addComponent(selectSRB)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarLb)
                    .addComponent(datoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarBt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarRB)
                    .addComponent(BFSRB)
                    .addComponent(resetBt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertSRB)
                    .addComponent(selectSRB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initOpOrd() {
        ordenamientos = new Ordenamientos(panelDibujo);
        insertSRB.setVisible(false);
        selectSRB.setVisible(false);
    }

    private void ocultarOpArbol() {
        modoOrd = true;
        modoArbol = false;
        agregarLb.setText("Agregar numero:");
        BFSRB.setText("shellSort");
        buscarRB.setText("quickSort");
        insertSRB.setVisible(true);
        selectSRB.setVisible(true);
        buscarRB.setSelected(false);
        BFSRB.setSelected(false);
        panelDibujo.getGraphics().clearRect(0, 0, panelDibujo.getWidth(), panelDibujo.getHeight());
        tam = 0;
    }

    private void desocultarOpArbol() {
        modoOrd = false;
        modoArbol = true;
        agregarLb.setText("Agregar nodo:");
        BFSRB.setText("BFS");
        buscarRB.setText("Buscar nodo");
        insertSRB.setVisible(false);
        selectSRB.setVisible(false);
        panelDibujo.getGraphics().clearRect(0, 0, panelDibujo.getWidth(), panelDibujo.getHeight());
        tam = 0;
        buscarRB.setSelected(false);
        BFSRB.setSelected(false);
        insertSRB.setSelected(false);
        selectSRB.setSelected(false);
    }

    private void agregarBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarBtMouseClicked
        int dato;
        boolean exc = false;
        try {
            dato = Integer.parseInt(datoTF.getText());
        } catch (Exception e) {
            dato = 0;
            exc = true;
        }
        if (!buscarArbol && modoArbol && !exc && !BFS) {
            if (arbolBST == null) {
                arbolBST = new ArbolBST(dato, panelDibujo);
            } else {
                arbolBST.insertarNodo(dato);
            }
        } else if (buscarArbol && modoArbol && !BFS) {
            if (arbolBST == null) {
                JOptionPane.showMessageDialog(null, "Arbol vacio!");
            } else {
                arbolBST.repintarArbol(arbolBST.getRaiz());
                if (arbolBST.buscarDato(arbolBST.getRaiz(), dato, true)) {
                    JOptionPane.showMessageDialog(null, "Dato encontrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "El dato no se encuentra en el arbol");
                }
            }
        }
        if(modoArbol && BFS && !exc){
            NodoBST nodo = arbolBST.getNodo(arbolBST.getRaiz(), dato);
            arbolBST.BFS(nodo);
        }
        if (modoOrd && !exc) {
            vector[tam] = dato;
            tam++;
        }
        datoTF.setText("");
    }//GEN-LAST:event_agregarBtMouseClicked

    private void buscarRBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarRBMouseClicked
        if (modoArbol) {
            buscarArbol = true;
            agregarLb.setText("Nodo a buscar:");
            agregarBt.setText("Buscar");
            BFS = false;
        }else{
            vector = ordenamientos.quickSort(vector, 0, tam-1, tam);
        }
    }//GEN-LAST:event_buscarRBMouseClicked

    private void resetBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtMouseClicked
        if (modoArbol) {
            buscarArbol = false;
            agregarLb.setText("Agregar nodo:");
            agregarBt.setText("Agregar");
            BFS = false;
            if (arbolBST != null) {
                arbolBST.repintarArbol(arbolBST.getRaiz());
            }
        }else if(modoOrd) tam = 0;
    }//GEN-LAST:event_resetBtMouseClicked

    private void BFSRBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BFSRBMouseClicked
        if (modoArbol) {
            agregarLb.setText("Nodo inicial:");
            agregarBt.setText("Empezar");
            BFS = true;
            buscarArbol = false;
        }else{
            vector = ordenamientos.shellSort(vector, tam);
        }
    }//GEN-LAST:event_BFSRBMouseClicked

    private void ordMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordMenuItemMouseReleased
        ocultarOpArbol();
    }//GEN-LAST:event_ordMenuItemMouseReleased

    private void arbolMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolMenuItemMouseReleased
        desocultarOpArbol();
    }//GEN-LAST:event_arbolMenuItemMouseReleased

    private void insertSRBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertSRBMouseClicked
        if(modoOrd){
            vector = ordenamientos.insertSort(vector, tam);
        }
    }//GEN-LAST:event_insertSRBMouseClicked

    private void selectSRBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectSRBMouseClicked
        if(modoOrd){
            vector = ordenamientos.selectSort(vector, tam);
        }
    }//GEN-LAST:event_selectSRBMouseClicked

    private void creadorMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creadorMenuMouseClicked
        creadorJD.setVisible(true);
    }//GEN-LAST:event_creadorMenuMouseClicked

    private void creadorJDWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_creadorJDWindowClosed
        creadorJD.dispose();
    }//GEN-LAST:event_creadorJDWindowClosed

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
            java.util.logging.Logger.getLogger(MenuP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BFSRB;
    private javax.swing.JButton agregarBt;
    private javax.swing.JLabel agregarLb;
    private javax.swing.JMenuItem arbolMenuItem;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JRadioButton buscarRB;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JDialog creadorJD;
    private javax.swing.JMenu creadorMenu;
    private javax.swing.JTextField datoTF;
    private javax.swing.JLabel gitLb;
    private javax.swing.JRadioButton insertSRB;
    private javax.swing.JLabel nombreCreadorLb;
    private javax.swing.JMenu opBarraMenu;
    private javax.swing.JMenuItem ordMenuItem;
    private javax.swing.JPanel panelDibujo;
    private javax.swing.JButton resetBt;
    private javax.swing.JRadioButton selectSRB;
    private javax.swing.JLabel titulo2Lb;
    private javax.swing.JLabel tituloLb;
    // End of variables declaration//GEN-END:variables
}
