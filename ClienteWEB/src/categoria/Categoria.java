/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

import java.util.Scanner;

/**
 *
 * @author guilhermemn
 */
public class Categoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        
        System.out.print("Digite a nova Categoria: ");
        Scanner novo = new Scanner(System.in);
        s = novo.next();
        inscat(s);
        
    }

    private static String inscat(java.lang.String cat) {
        com.categoria.db.NovoWebService_Service service = new com.categoria.db.NovoWebService_Service();
        com.categoria.db.NovoWebService port = service.getNovoWebServicePort();
        return port.inscat(cat);
    }
    
}
