package menu;

import java.util.Scanner;

public class Mov_menu {

    /**
     * @param args the command line arguments
     */
    public void movimento_menu (String[] args) {
        String s1;
        String s2;
       // String s3;
        int escolha_movimento;

        System.out.print("\n #Movimento# \n ");
        System.out.print("\n 1-Inserir");
        System.out.print("\n 2-Apagar ");
        System.out.print("\n 2-Atualizar ");
        System.out.print("\n Escolha uma opcao: ");
        
        Scanner novo = new Scanner(System.in);
        escolha_movimento = novo.nextInt();

        switch (escolha_movimento) {
            case 1:
                System.out.print("Inserir um titulo: ");
                
                System.out.print("Inserir uma descrição: ");
                System.out.print("Inserir o vencimento: ");
                System.out.print("Inserir o valor: ");
                //System.out.print("Inserir um tipo: ");
                //System.out.print("Inserir uma categoria: ");
                s1 = novo.next();
                inserirMovimento(s1);
                break;
            case 2:
                System.out.print("Apagar um Movimento: ");
                s2 = novo.next();
                apagarMovimento(s2);
                break;
        }
    }

    private static String inserirMovimento(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirCategoria(cat);
    }

    private static String apagarMovimento(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.apagarCategoria(cat);
    }
    
    
    

}

