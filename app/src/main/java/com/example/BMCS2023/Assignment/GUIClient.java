/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.awt.Point;

import javax.swing.JFrame;

/**
 *
 * @author zhenyu
 */
public class GUIClient {
    
    public GUIClient(){
        
    }
    
public static void switchPage(JFrame currentFrame, JFrame nextFrame) {
    nextFrame.setSize(800, 600);
    Point pos = currentFrame.getLocation(); 
    nextFrame.setResizable(false);       
    nextFrame.setLocation(pos); 
    nextFrame.setVisible(true);          
    currentFrame.dispose();              
}

}
