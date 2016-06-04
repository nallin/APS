package menu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ParseException_Exception;

public class Mov_menu {

    public void movimento_menu(String[] args) throws ParseException_Exception {
        String s1;
        String s2;
        String dat, periodo;
        int escolha_movimento, val, tip, cat;
        System.out.print("\n #Movimento Eventual / Frequente# \n ");
        System.out.print("\n 1-Inserir");
        System.out.print("\n 2-Apagar ");
        System.out.print("\n 3-Atualizar ");
        System.out.print("\n 4-Listar ");
        //System.out.print("\n 5-Saldo ");
        System.out.print("\n Escolha uma opcao: ");
        Scanner novo = new Scanner(System.in);
        escolha_movimento = novo.nextInt();
        switch (escolha_movimento) {
            case 1:
                System.out.print("Inserir um titulo: ");
                s1 = novo.next();
                System.out.print("Inserir uma descrição: ");
                s2 = novo.next();
                System.out.print("Inserir o vencimento: ");
                dat = novo.next();
                System.out.print("Inserir o valor: ");
                val = novo.nextInt();
                System.out.print("Inserir um tipo (0-Despesa/1-Receita): ");
                tip = novo.nextInt();
                System.out.print("Inserir um tipo (0-Eventual/1-Frequente): ");
                int tipo2 = novo.nextInt();
                if(tipo2 == 0){
                    periodo = "NULL";
                }else{
                    System.out.print("Inserir um periodo:");
                    periodo = novo.next();
                }
                String lista1 = listarCategoria();
                System.out.println(lista1);
                System.out.print("Inserir uma categoria: ");
                cat = novo.nextInt();
                inserirMovimento(s1, s2, dat, val, tip, cat, periodo);
                break;
            case 2:
                System.out.print("Apagar um Movimento: ");
                s1 = novo.next();
                apagarMovimento(s1);
                break;
            case 3:
                Scanner velho = new Scanner(System.in);
                System.out.print("Digite o nome do Titulo que deseja alterar: ");
                s2 = velho.next();
                System.out.print("Digite o novo nome do Titulo: ");
                s1 = novo.next();
                atualizarMovimento(s2, s1);
                break;
            case 4:
                String lista = listarMovimento();
                
                System.out.println(lista);
                
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

    private static String atualizarMovimento(java.lang.String mov, java.lang.String arg1) {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.atualizarMovimento(mov, arg1);
    }

    private static String listarMovimento() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarMovimento();
    }

    private static String inserirMovimento(java.lang.String mov, java.lang.String arg1, java.lang.String arg2, float arg3, int arg4, int arg5, java.lang.String arg6) throws ParseException_Exception {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirMovimento(mov, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    
}
