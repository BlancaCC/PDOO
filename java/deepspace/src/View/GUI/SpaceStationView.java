/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import deepspace.SpaceStationToUI;
import deepspace.WeaponToUI;
import deepspace.ShieldToUI;
import java.util.ArrayList;
import controller.Controller;
import java.awt.Component;

/**
 *
 * @author blanca
 */
public class SpaceStationView extends javax.swing.JPanel {

    
    private DamageView damageView;
    private HangarView hangarView;
    
    /**
     * Creates new form SpaceStationView
     */
    public SpaceStationView() {
        initComponents();
        
        damageView = new DamageView();
        jpDamage.add(damageView);
        jpDamage2.add(damageView);
        
        hangarView = new HangarView();
        jpHangar.add(hangarView);
        
     
        
        repaint();
        revalidate();
    }

    void setSpaceStation( SpaceStationToUI s) {
        jpHangar.removeAll();
        ammoPower.setText(Float.toString(s.getAmmoPower()));
        fuelsUnits.setText(Float.toString(s.getFuelUnits()));
        medals.setText(Integer.toString(s.getnMedals()));
        name.setText(s.getName());
        shieldsPower.setText(Float.toString(s.getShieldPower()));
        
        ArrayList<WeaponToUI> wl = s.getWeapons();
        ArrayList<ShieldToUI> sl = s.getShieldBoosters();
        
        WeaponView weaponView;
        ShieldBoosterView shieldView;
        
        jPWeapons.removeAll();
        for(WeaponToUI w: wl){
            
            weaponView = new WeaponView();
            weaponView.setWeapon(w);
            jPWeapons.add(weaponView);
        }
        
        for(ShieldToUI sh : sl) {
            shieldView = new ShieldBoosterView();
            shieldView.setShieldBooster(sh);
            jpShields.add(shieldView);
        }
        
        if(s.getPendingDamage()!=null){
            damageView.setDamage(s.getPendingDamage());
        }
        jpHangar.removeAll();
        if(s.getHangar()!=null)
        {
            hangarView.setHangar(s.getHangar());
            jpHangar.add(hangarView);
            jpHangar.setVisible(true);
           
        }
        else{
            medals.setText("s");
        }
 
        jpDamage.setVisible(true);
        
        jpDamage2.add(damageView);
        jpDamage2.setVisible(true);

        
        //falta mostrar el hangar, escudos, armas...
        repaint();
        revalidate();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        medals = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ammoPower = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fuelsUnits = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        shieldsPower = new javax.swing.JLabel();
        jpDamage = new javax.swing.JPanel();
        jpDamage2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSWeapons = new javax.swing.JScrollPane();
        jPWeapons = new javax.swing.JPanel();
        jsHangar = new javax.swing.JScrollPane();
        jpHangar = new javax.swing.JPanel();
        jbMontar = new javax.swing.JButton();
        jsShields = new javax.swing.JScrollPane();
        jpShields = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("SpaceStation");

        jLabel2.setText("Name: ");

        name.setText("jLabel3");

        jLabel4.setText("Medals: ");

        medals.setText("jLabel5");

        jLabel6.setText("ammoPower: ");

        ammoPower.setText("jLabel7");

        jLabel8.setText("fuels units: ");

        fuelsUnits.setText("jLabel9");

        jLabel10.setText("shields power: ");

        shieldsPower.setText("jLabel11");

        jButton1.setText("Descartar hángar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSWeapons.setViewportView(jPWeapons);

        jsHangar.setViewportView(jpHangar);

        jbMontar.setText("Montar");
        jbMontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMontarActionPerformed(evt);
            }
        });

        jsShields.setViewportView(jpShields);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpDamage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jbMontar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jpDamage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel2))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fuelsUnits)
                                    .addComponent(name)
                                    .addComponent(medals)
                                    .addComponent(ammoPower)
                                    .addComponent(shieldsPower, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSWeapons))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jsHangar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jsShields)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(medals))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ammoPower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fuelsUnits))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(shieldsPower))
                .addComponent(jpDamage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSWeapons, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsShields, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsHangar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDamage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jbMontar)))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Controller.getInstance().discardHangar();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //ESTOS NO SON LOS DEL HANGAR
    ArrayList<Integer> getSelectedWeapons(){
        ArrayList<Integer> sw = new ArrayList();
        int i = 0;
        for(Component c : jPWeapons.getComponents()){
            if(((WeaponView)c).isSelected()){
                sw.add(i);
            }
            i++;
        }
        return sw;
    }
    
    ArrayList<Integer> getSelectedShields(){
        ArrayList<Integer> ss = new ArrayList();
        int i = 0;
        for(Component c : jpShields.getComponents()){
            if(((ShieldBoosterView)c).isSelected()){
                ss.add(i);
            }
            i++;
        }
        return ss;
}
    
    private void jbMontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMontarActionPerformed
        
        //hay que pasarle array con posiciones de la arma o escudo a montar
        Controller.getInstance().mount(getSelectedWeapons(),getSelectedShields());
    }//GEN-LAST:event_jbMontarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ammoPower;
    private javax.swing.JLabel fuelsUnits;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPWeapons;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSWeapons;
    private javax.swing.JButton jbMontar;
    private javax.swing.JPanel jpDamage;
    private javax.swing.JPanel jpDamage2;
    private javax.swing.JPanel jpHangar;
    private javax.swing.JPanel jpShields;
    private javax.swing.JScrollPane jsHangar;
    private javax.swing.JScrollPane jsShields;
    private javax.swing.JLabel medals;
    private javax.swing.JLabel name;
    private javax.swing.JLabel shieldsPower;
    // End of variables declaration//GEN-END:variables
}
