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
        String s1;
        String s2;
        int escolha;

        System.out.print("#CATEGORIA#\n\n1-Inserir\n2-Apagar\n\n3-Atualizar\n\nEscolha uma opcao: ");
        Scanner novo = new Scanner(System.in);
        escolha = novo.nextInt();

        switch (escolha) {
            case 1:
                System.out.print("Digite a nova Categoria: ");
                s1 = novo.next();
                inserirCategoria(s1);
                break;
            case 2:
                System.out.print("Digite o nome da Categoria: ");
                s1 = novo.next();
                apagarCategoria(s1);
                break;
            case 3:
                Scanner velho = new Scanner(System.in);
                System.out.print("Digite o nome da Categoria que deseja alterar: ");
                s2 = velho.next(); 
                System.out.print("Digite o novo nome da Categoria: ");
                s1 = novo.next();
                atualizarCategoria(s2, s1);
                break;
        }
    }

    private static String apagarCategoria(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.apagarCategoria(cat);
    }

    private static String inserirCategoria(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirCategoria(cat);
    }

    private static String atualizarCategoria(java.lang.String cat, java.lang.String arg1) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.atualizarCategoria(cat, arg1);
    }

  
}
