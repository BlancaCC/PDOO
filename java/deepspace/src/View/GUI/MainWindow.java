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
    
    //diviones de la pantalla 
    private SpaceStationView spaceStationView;
    
    /**
     * Creates new form MainWindow
     */
    private MainWindow() {
        initComponents();
        
        spaceStationView=new SpaceStationView();
        jpSpaceStationView.add(spaceStationView);
        
        //cosas por defecto pa que no se cierre, pinte...
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jpSpaceStationView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" deepspace");
        setBackground(java.awt.Color.lightGray);

        jButton1.setBackground(new java.awt.Color(91, 72, 199));
        jButton1.setText("Combat !!!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Siguiente Turno");

        jButton3.setText("Salir");

        javax.swing.GroupLayout jpSpaceStationViewLayout = new javax.swing.GroupLayout(jpSpaceStationView);
        jpSpaceStationView.setLayout(jpSpaceStationViewLayout);
        jpSpaceStationViewLayout.setHorizontalGroup(
            jpSpaceStationViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        jpSpaceStationViewLayout.setVerticalGroup(
            jpSpaceStationViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpSpaceStationView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 422, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpSpaceStationView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botón de combate
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

   
    //___IMPLEMENTACIONES DE DEPPsPACEVIEW___
    
    @Override 
    public void updateView() {
        spaceStationView.setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());
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
      (new MensajeGenerico(this,"Has logrado escapar. \tEres una Gallina Espacial.")).showMessage();
  }
    @Override
  public void wonCombatMessage() {
      String ms="Has GANADO el combate. \tDisfruta de tu botín.";
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jpSpaceStationView;
    // End of variables declaration//GEN-END:variables
}
