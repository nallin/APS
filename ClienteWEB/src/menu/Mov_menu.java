package menu;

import java.util.Scanner;
import service.ParseException_Exception;
/*import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;*/

public class Mov_menu {
    
    
        

    public void movimento_menu(String[] args) throws ParseException_Exception {
        String titu, des, dat, periodo,apag_mov, atu_ti2, atu_ti1, atu_des2, atu_des1;
        int atu_val2, atu_val1;
        int escolha_movimento, val, tip, cat;
        
        
        
        
        
        
        System.out.print("\n #Movimento Eventual / Frequente# \n ");
        System.out.print("\n 1-Inserir");
        System.out.print("\n 2-Apagar ");
        System.out.print("\n 3-Atualizar ");
        System.out.print("\n 4-Listar ");
        System.out.print("\n 5-Saldo ");
        System.out.print("\n Escolha uma opcao: ");
        
       Scanner novo = new Scanner(System.in);
       escolha_movimento = novo.nextInt();
    
        switch (escolha_movimento) {
            case 1:
                
                System.out.print("Inserir um titulo: ");
                titu = novo.next();
                System.out.print("Inserir uma descrição: ");
                des = novo.next();
                System.out.print("Inserir o vencimento: ");
                dat = novo.next();
                System.out.print("Inserir o valor: ");
                val = novo.nextInt();
                System.out.print("Inserir um tipo (0-Receita/1-Despesa): ");
                tip = novo.nextInt();
                System.out.print("Inserir um tipo (0-Eventual/1-Frequente): ");
                int tipo = novo.nextInt();
                if(tipo == 0){
                    periodo = "NULL";
                }else{
                    System.out.print("Inserir um periodo:");
                    periodo = novo.next();
                 
                }
                String lista1 = listarCategoria();
                System.out.println(lista1);
                System.out.print("Inserir uma categoria: ");
                cat = novo.nextInt();
                inserirMovimento(titu, des, dat, val, tip, cat, periodo);
                break;
            case 2:
                System.out.print("Apagar um Movimento: ");
                apag_mov = novo.next();
                apagarMovimento(apag_mov);
                break;
            case 3:
                System.out.print("\n 1 - Atualizar titulo ");
                System.out.print("\n 2 - Atualizar descrição ");
                System.out.print("\n 3 - Atualizar valor ");
                System.out.print("\n Escolha uma opcao: ");
                int atual = novo.nextInt();
                if(atual == 1){
                    Scanner velho_tit = new Scanner(System.in);
                    System.out.print("\n Lista de titulo: ");
                    String lista_tit = listarTituloMovimento();
                    System.out.println(lista_tit);
                    System.out.print("\n Digite o nome do titulo que deseja alterar: ");
                    atu_ti2 = velho_tit.next();
                    System.out.print("\n Digite o novo nome do titulo: ");
                    atu_ti1 = novo.next();
                    atualizarTituloMovimento(atu_ti2, atu_ti1);
                    System.out.print("\n Lista de titulo atualizado: ");
                    String lista_tit1 = listarTituloMovimento();
                    System.out.println(lista_tit1);
                }else{
                    if(atual == 2){
                        Scanner velho_des = new Scanner(System.in);
                        System.out.print("\n Lista de descrição atualizada: ");
                        String lista_des = listarDescricaoMovimento();
                        System.out.println(lista_des);
                        System.out.print("\n Digite o nome da descrição que deseja alterar: ");
                        atu_des2 = velho_des.next();
                        System.out.print("\n Digite o novo nome da descrição: ");
                        atu_des1 = novo.next();
                        atualizarDescriçãoMovimento(atu_des2, atu_des1);
                        System.out.print("\n Lista de descrição atualizada: ");
                        String lista_des1 = listarDescricaoMovimento();
                        System.out.println(lista_des1);
                    }else{
                        Scanner velho = new Scanner(System.in);
                        System.out.print("\n Lista de valor: ");
                        String lista_val = listarValorMovimento();
                        System.out.println(lista_val);
                        System.out.print("\n Digite o valor que deseja alterar: ");
                        atu_val2 = velho.nextInt();
                        System.out.print("\n Digite o novo valor: ");
                        atu_val1 = novo.nextInt();
                        atualizarValorMovimento(atu_val2, atu_val1);
                        System.out.print("\n Lista de valor atualizada: ");
                        String lista_val1 = listarValorMovimento();
                        System.out.println(lista_val1);
                    }
                }
                break;
            case 4:
                System.out.print("\n 1 - Listar titulo ");
                System.out.print("\n 2 - Listar descrição ");
                System.out.print("\n 3 - Listar vencimento ");
                System.out.print("\n 4 - Listar valor ");
                System.out.print("\n Escolha uma opcao: ");
                int list = novo.nextInt();
                if(list == 1){
                    System.out.print("\n Lista de titulo: ");
                    String lista_tit = listarTituloMovimento();
                    System.out.println(lista_tit);
                }else{
                    if(list == 2){
                        System.out.print("\n Lista de descrição: ");
                        String lista_des = listarDescricaoMovimento();
                        System.out.println(lista_des);
                    }else{
                        if(list == 3){
                            System.out.print("\n Lista de vencimento: ");
                            String lista_ven = listarVencimentoMovimento();
                            System.out.println(lista_ven);
                        }else {
                            System.out.print("\n Lista de valor: ");
                            String lista_val = listarValorMovimento();
                            System.out.println(lista_val);
                        }  
                    }
                }
                break;
            case 5:
                String total = saldo();
                System.out.println(total);
            break;
        }
    }

    private static String listarCategoria() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarCategoria();
    }

    private static String apagarMovimento(java.lang.String mov) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.apagarMovimento(mov);
    }

    private static String inserirMovimento(java.lang.String mov, java.lang.String arg1, java.lang.String arg2, float arg3, int arg4, int arg5, java.lang.String arg6) throws ParseException_Exception {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirMovimento(mov, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private static String listarTituloMovimento() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarTituloMovimento();
    }  

    private static String listarDescricaoMovimento() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarDescricaoMovimento();
    }

    private static String listarVencimentoMovimento() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarVencimentoMovimento();
    }

    private static String listarValorMovimento() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarValorMovimento();
    } 

    private static String saldo() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.saldo();
    }

    private static String atualizarTituloMovimento(java.lang.String mov, java.lang.String arg1) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.atualizarTituloMovimento(mov, arg1);
    }

    private static String atualizarDescriçãoMovimento(java.lang.String mov, java.lang.String arg1) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.atualizarDescriçãoMovimento(mov, arg1);
    }

  
    private static String atualizarValorMovimento(float mov, float arg1) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.atualizarValorMovimento(mov, arg1);
    }

    private static String saldoInicial(float mov) throws ParseException_Exception {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.saldoInicial(mov);
    }
    
}
