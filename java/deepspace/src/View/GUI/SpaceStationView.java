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
        jpDamage2.add(damageView);
        
        hangarView = new HangarView();
        jpHangar.add(hangarView);
        
     
        
        repaint();
        revalidate();
    }

    void setSpaceStation( SpaceStationToUI s) {
        jpHangar.removeAll();
        jPWeapons.removeAll();
        jpShields.removeAll();
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
            jpShields.setVisible(true);
        }
        
        if(s.getPendingDamage()!=null){
            damageView.setDamage(s.getPendingDamage());
            jpDamage2.add(damageView);
            jpDamage2.setVisible(true);
        }
        else {
            jpDamage2.setVisible(false);
        }
        jpHangar.removeAll();
        if(s.getHangar()!=null)
        {
            hangarView.setHangar(s.getHangar());
            jpHangar.add(hangarView);
            jpHangar.setVisible(true);
           
        }
        else{
            //medals.setText("s");
        }
   
        //falta mostrar el hangar, escudos, armas...
        repaint();
        revalidate();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpDamage2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPWeapons = new javax.swing.JPanel();
        jbEscudos = new javax.swing.JButton();
        shieldsPower = new javax.swing.JLabel();
        jbArmas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jpShields = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jbDescartarDelHangar = new javax.swing.JButton();
        jbMontar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpHangar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        medals = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ammoPower = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbHangar = new javax.swing.JButton();
        fuelsUnits = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jpDamage = new javax.swing.JPanel();
        jLSpaceStation = new javax.swing.JLabel();

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

        jLabel10.setText("shields power: ");

        jScrollPane1.setViewportView(jPWeapons);

        jbEscudos.setText("D. escudos");
        jbEscudos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEscudosActionPerformed(evt);
            }
        });

        shieldsPower.setText("jLabel3");

        jbArmas.setText("D.armas");
        jbArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbArmasActionPerformed(evt);
            }
        });

        jLabel2.setText("Name: ");

        jScrollPane2.setViewportView(jpShields);

        name.setText("jLabel3");

        jbDescartarDelHangar.setText("D. del Hangar");
        jbDescartarDelHangar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDescartarDelHangarActionPerformed(evt);
            }
        });

        jbMontar.setText("Montar");
        jbMontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMontarActionPerformed(evt);
            }
        });

        jLabel4.setText("Medals: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jpHangar.add(jPanel2);

        jScrollPane3.setViewportView(jpHangar);

        medals.setText("jLabel5");

        jLabel6.setText("ammoPower: ");

        ammoPower.setText("jLabel7");

        jLabel8.setText("fuels units: ");

        jbHangar.setText("D. Hangar");
        jbHangar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHangarActionPerformed(evt);
            }
        });

        fuelsUnits.setText("jLabel9");

        jScrollPane4.setViewportView(jpDamage);

        jLSpaceStation.setText("SpaceStation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 494, Short.MAX_VALUE)
                        .addComponent(jpDamage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSpaceStation)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jbHangar)
                                                    .addComponent(jbMontar))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jbEscudos)
                                                    .addComponent(jbArmas)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jbDescartarDelHangar)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel8))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fuelsUnits)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(shieldsPower)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLabel6)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(ammoPower))))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(60, 60, 60)
                                                    .addComponent(name)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(medals))
                                                .addComponent(jScrollPane1)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLSpaceStation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name)
                    .addComponent(jLabel4)
                    .addComponent(medals))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(shieldsPower)
                    .addComponent(jLabel6)
                    .addComponent(ammoPower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fuelsUnits))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jpDamage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbHangar)
                            .addComponent(jbEscudos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbArmas)
                            .addComponent(jbMontar))
                        .addGap(18, 18, 18)
                        .addComponent(jbDescartarDelHangar))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEscudosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEscudosActionPerformed
        Controller.getInstance().discard(Controller.SHIELD, new ArrayList<Integer>(), getSelectedShields() );
        setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());

        revalidate();
        repaint();
    }//GEN-LAST:event_jbEscudosActionPerformed

    private void jbArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbArmasActionPerformed
        Controller.getInstance().discard(Controller.WEAPON, getSelectedWeapons(), new ArrayList<Integer>());
        setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());

        revalidate();
        repaint();
    }//GEN-LAST:event_jbArmasActionPerformed

    private void jbDescartarDelHangarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDescartarDelHangarActionPerformed
        Controller.getInstance().discard(Controller.HANGAR, hangarView.getSelectedWeapons(), hangarView.getSelectedShields());
        setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());

        revalidate();
        repaint();
    }//GEN-LAST:event_jbDescartarDelHangarActionPerformed

    private void jbHangarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHangarActionPerformed
        Controller.getInstance().discardHangar();
        setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());

        revalidate();
        repaint();
    }//GEN-LAST:event_jbHangarActionPerformed

    private void jbMontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMontarActionPerformed
          
        //hay que pasarle array con posiciones de la arma o escudo a montar
        Controller.getInstance().mount(hangarView.getSelectedWeapons(),hangarView.getSelectedShields());
        setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());
        revalidate();
    repaint();
    }//GEN-LAST:event_jbMontarActionPerformed

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
            System.out.println("Un objeto leído es"+c);
            if(((ShieldBoosterView)c).isSelected())
                System.out.println("está seleccionado");
            else
                System.out.println("no está seleccionado");
            if(((ShieldBoosterView)c).isSelected()){
                ss.add(i);
                System.out.println("Se ha dado ha descartar el el escudo " +i);
            }
            i++;
        }
        return ss;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ammoPower;
    private javax.swing.JLabel fuelsUnits;
    private javax.swing.JLabel jLSpaceStation;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPWeapons;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbArmas;
    private javax.swing.JButton jbDescartarDelHangar;
    private javax.swing.JButton jbEscudos;
    private javax.swing.JButton jbHangar;
    private javax.swing.JButton jbMontar;
    private javax.swing.JPanel jpDamage;
    private javax.swing.JPanel jpDamage2;
    private javax.swing.JPanel jpHangar;
    private javax.swing.JPanel jpShields;
    private javax.swing.JLabel medals;
    private javax.swing.JLabel name;
    private javax.swing.JLabel shieldsPower;
    // End of variables declaration//GEN-END:variables
}
