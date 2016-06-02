package menu;

import java.util.Scanner;

public class Freq_menu {
    /**
     * @param args the command line arguments
     */
    public void frequente_menu (String[] args) {
        String s1;
        String s2;
        int escolha_frequente;

        System.out.print("\n #FREQUENTE# \n ");
        System.out.print("\n 1-Inserir");
        System.out.print("\n 2-Apagar ");
        System.out.print("\n Escolha uma opcao:");
        
        Scanner novo = new Scanner(System.in);
        escolha_frequente = novo.nextInt();

        switch (escolha_frequente) {
            case 1:
                System.out.print("\n Inserir um Lançamento: ");
                System.out.print("\n Inserir uma Periodo: ");
                System.out.print("\n Inserir uma Categoria: ");
                s1 = novo.next();
                inserirFrequente(s1);
                break;
            case 2:
                System.out.print("Apagra um Lancamento pelo nome: ");
                s2 = novo.next();
                apagarFrequente(s2);
                break;
            case 3:
                Scanner velho = new Scanner(System.in);
                System.out.print("Digite ... alterar: ");
                s2 = velho.next(); 
                System.out.print("Digite ... Categoria: ");
                s1 = novo.next();
                atualizarFrequente(s2, s1);
                break;    
        }
    }

    private static String inserirFrequente(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirCategoria(cat);
    }

    private static String apagarFrequente(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.apagarCategoria(cat);
    }
    
    private static String atualizarFrequente(java.lang.String cat, java.lang.String arg1) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.atualizarCategoria(cat, arg1);
    }

}

