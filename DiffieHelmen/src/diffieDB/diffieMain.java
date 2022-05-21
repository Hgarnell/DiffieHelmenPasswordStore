/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

/**
 *
 * @author hanna
 */
public class diffieMain{
       public static void main(String[] args) {
        diffieView view = new diffieView();
        diffieModel model = new diffieModel();
        diffieController controller = new diffieController(view,model);
        model.addObserver(view);
    }

}
