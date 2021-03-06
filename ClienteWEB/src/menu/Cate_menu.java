package menu;

import java.util.Scanner;
import service.ParseException_Exception;

public class Cate_menu {

    public void categoria_menu (String[] args) throws ParseException_Exception{
        String s1;
        String s2;
        String s3;
        int escolha;

        System.out.print("\n #Categoria#\n ");
        System.out.print("\n 1-Inserir");
        System.out.print("\n 2-Apagar ");
        System.out.print("\n 3-Atualizar ");
        System.out.print("\n 4-Listar ");
        System.out.print("\n Escolha uma opcao: ");
        
        Scanner novo = new Scanner(System.in);
        escolha = novo.nextInt();       
        switch (escolha) {
            case 1:
                System.out.print("\n Inserir uma Categoria: ");
                s1 = novo.next();
                inserirCategoria(s1);
                break;
            case 2:
                System.out.print("\n Apagar uma Categoria pelo nome: ");
                s1 = novo.next();
                String result = apagarCategoria(s1);
                System.err.println(result); 
                break;
            case 3:
                Scanner velho = new Scanner(System.in);
                String lista2  = listarCategoria();
                System.out.println(lista2);
                System.out.print("Digite o nome da Categoria que deseja alterar: ");
                s2 = velho.next(); 
                System.out.print("Digite o novo nome da Categoria: ");
                s1 = novo.next();
                atualizarCategoria(s2, s1);
                String lista3  = listarCategoria();
                System.out.println(lista3);
                break;
            case 4:
                String lista  = listarCategoria();
                System.out.println(lista);
                break;
        }
        Menu menu = new Menu();
        menu.main (args);
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

    private static String listarCategoria() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarCategoria();
        
    }   

    private static String apagarCategoria(java.lang.String cat) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.apagarCategoria(cat);
    }
}
