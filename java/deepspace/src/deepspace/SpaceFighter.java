package deepspace;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blanca
 */
public interface SpaceFighter {
    public float fire();
    public float protection();
    public ShotResult receiveShot( float shot); 
}
