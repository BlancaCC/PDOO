/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blanca
 */

package View.GUI;

import javax.swing.JFrame; 
import View.DeepSpaceView;
import controller.Controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;

        
public class MainWindow extends JFrame implements DeepSpaceView {

    private static MainWindow instance=null;
    
    private String appName;
    
    public static MainWindow getInstance () {
      if (instance == null) {
        instance = new MainWindow();
      }
      return instance;
    }
    
    //divisines de la pantalla 
    private SpaceStationView spaceStationView;
    private EnemyView enemyView;
    
    /**
     * Creates new form MainWindow
     */
    private MainWindow() {
        initComponents();
        appName="Deepspace 1.0 <3";
        
        spaceStationView=new SpaceStationView();
        enemyView = new EnemyView();
        enemyView.setVisible(false);
        //falta añadirle la estación
        jpSpaceStationView.add(spaceStationView);
        jpEnemyView.add(enemyView);
        jPruebas.add(enemyView);

        
        //cosas por defecto pa que no se cierre, pinte...
        setTitle(appName);
        revalidate();
        repaint();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Controller.getInstance().finish(0);
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jpSpaceStationView = new javax.swing.JPanel();
        jPruebas = new javax.swing.JPanel();
        jpEnemyView = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jbCombat = new javax.swing.JButton();
        jbSiguienteTurno = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" deepspace");
        setBackground(java.awt.Color.lightGray);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jpSpaceStationView.setPreferredSize(new java.awt.Dimension(246, 180));

        jbCombat.setText("Combat !!!");
        jbCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCombatActionPerformed(evt);
            }
        });

        jbSiguienteTurno.setText("Siguiente Turno");
        jbSiguienteTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpSpaceStationView, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(671, 671, 671)
                        .addComponent(jPruebas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpEnemyView, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jbSiguienteTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCombat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPruebas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jpEnemyView, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSiguienteTurno)
                    .addComponent(jbCombat)
                    .addComponent(jbSalir))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpSpaceStationView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botón de combate
    private void jbCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCombatActionPerformed
        // TODO add your handling code here:
        Controller.getInstance().combat();
        enemyView.setEnemy(Controller.getInstance().getUIversion().getCurrentEnemy()); 
        enemyView.setVisible(true);
        revalidate();
        repaint();
    }//GEN-LAST:event_jbCombatActionPerformed

    private void jbSiguienteTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteTurnoActionPerformed
        Controller.getInstance().nextTurn();
        enemyView.setVisible(false);
        //spaceStationView.setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());
        revalidate();
        repaint();  
    }//GEN-LAST:event_jbSiguienteTurnoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        Controller.getInstance().finish(0);
    }//GEN-LAST:event_jbSalirActionPerformed

   
    //___IMPLEMENTACIONES DE DEPPsPACEVIEW___
    
    @Override 
    public void updateView() {
        System.out.println(Controller.getInstance().getUIversion().getCurrentEnemy().toString());
        spaceStationView.setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());
        enemyView.setEnemy(Controller.getInstance().getUIversion().getCurrentEnemy());
    }
        @Override
    public void showView() {
        setVisible(true);
    }
  // Inputs
    @Override
  public ArrayList<String> readNamePlayers() {
      PlayersNames playersName= new PlayersNames(this);
      return playersName.getNames();
      
  }
  // Outputs
    @Override
  public boolean confirmExitMessage() {
      return (JOptionPane.showConfirmDialog(this, "¿Estás segur@ que deseas salir?", "Deepspace", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
  }

  //¿esto se haría así?
  //no puedes avanzar de turno, no has cumplido tu castigo
    @Override
    public void nextTurnNotAllowedMessage() {
        (new NextTurnNotAllowed(this)).showMessage();
    }
    
    @Override
  public void lostCombatMessage() {
      (new LostCombat(this)).showMessage();
  }
    @Override
  public void escapeMessage() {
      (new MensajeGenerico(this,"Has logrado escapar. \nEres una Gallina Espacial.")).showMessage();
  }
    @Override
  public void wonCombatMessage() {
      String ms="Has GANADO el combate. \nDisfruta de tu botín.";
      (new MensajeGenerico(this,ms)).showMessage();
  }
    @Override
  public void wonGameMessage() {
      String ms = "\n\tHAS GANADO LA PARTIDA";
  (new MensajeGenerico(this,ms)).showMessage();
  }

    @Override
  public void conversionMessage() {
      String ms ="Has GANADO el combate. \nAdemás te has CONVERTIDO. \nDisfruta de tu botín";
      (new MensajeGenerico(this,ms)).showMessage();
  }
    @Override
  public void noCombatMessage() {
      String ms = "No puedes combatir en este momento";
      (new MensajeGenerico(this,ms)).showMessage();
  }
    
    
    
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPruebas;
    private javax.swing.JButton jbCombat;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbSiguienteTurno;
    private javax.swing.JPanel jpEnemyView;
    private javax.swing.JPanel jpSpaceStationView;
    // End of variables declaration//GEN-END:variables
}
