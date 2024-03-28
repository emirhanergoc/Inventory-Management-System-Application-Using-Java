
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import javax.swing.JOptionPane;
import dao.InvertoryUtils;
import java.io.File;

/**
 *
 * @author Emirhan
 */
public class OpenPdf {
   public static void OpenById(String id)
   {
       try {
           if((new File(InvertoryUtils.billPath+id+".pdf")).exists()){
           Process p=Runtime
                    .getRuntime()
                   .exec("rundll32 url.dll,FileProtocolHandler " +InvertoryUtils.billPath+"" +id +".pdf");
       }
           else
           {
               JOptionPane.showMessageDialog(null, "Dosya yok");
           }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
   }
    
}
