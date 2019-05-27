/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;
import  deepspace.LootToUI;
/**
 *
 * @author blanca
 */
public class LootView extends javax.swing.JPanel {

    /**
     * Creates new form LootView
     */
    public LootView() {
        initComponents();
        
        revalidate();
        repaint();
    }
    
    public void setLoot( LootToUI l) {
        armas.setText(Integer.toString(l.getnWeapons()));
        jLEscudos.setText(Integer.toString(l.getnShields()));
        jLTamHangar.setText(Integer.toString(l.getnHangars()));
        jLcombustible.setText(Integer.toString(l.getnSupplies()));
        jLMedallas.setText(Integer.toString(l.getnMedals()));
        
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
        armas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLEscudos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLTamHangar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLcombustible = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLMedallas = new javax.swing.JLabel();

        jLabel1.setText("Armas: ");

        armas.setText("jLabel2");

        jLabel2.setText("Escudos: ");

        jLEscudos.setText("jLabel3");

        jLabel3.setText("Tamaño Hangar: ");

        jLTamHangar.setText("jLabel4");

        jLabel4.setText("Combustible: ");

        jLcombustible.setText("jLabel5");

        jLabel5.setText("Medallas: ");

        jLMedallas.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLTamHangar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(armas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLEscudos)))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLMedallas)
                            .addComponent(jLcombustible))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(armas)
                    .addComponent(jLabel4)
                    .addComponent(jLcombustible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLEscudos)
                    .addComponent(jLabel5)
                    .addComponent(jLMedallas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLTamHangar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel armas;
    private javax.swing.JLabel jLEscudos;
    private javax.swing.JLabel jLMedallas;
    private javax.swing.JLabel jLTamHangar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLcombustible;
    // End of variables declaration//GEN-END:variables
}
