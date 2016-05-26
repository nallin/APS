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
        int escolha;

        System.out.print("#CATEGORIA#\n\n1-Inserir\n2-Apagar\n\nEscolha uma opcao: ");
        Scanner novo = new Scanner(System.in);
        escolha = novo.nextInt();

        switch (escolha) {
            case 1:
                System.out.print("Digite a nova Categoria: ");
                s = novo.next();
                inserirCategoria(s);
                break;
            case 2:
                System.out.print("Digite o nome da Categoria: ");
                s = novo.next();
                apagarCategoria(s);
                break;
        }
    }

    private static String inserirCategoria(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirCategoria(cat);
    }

    private static String apagarCategoria(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.apagarCategoria(cat);
    }

}
