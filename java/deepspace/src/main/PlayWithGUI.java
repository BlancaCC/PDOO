/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import View.DeepSpaceView;
import View.GUI.MainWindow;
import deepspace.GameUniverse;
/**
 *
 * @author blanca
 */
public class PlayWithGUI {
   public static void main(String[] args) {
       
       MainWindow ui;
        GameUniverse  game = new GameUniverse();
        ui = MainWindow.getInstance();
        
//        View view = MainWindow_v2.getInstance();
        Controller controller = Controller.getInstance();
        controller.setModelView (game,ui);
        controller.start();
    }
    
}
