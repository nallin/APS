package menu;

import java.util.Scanner;
import service.ParseException_Exception;

public class Freq_menu {
    
    public void frequente_menu (String[] args) throws ParseException_Exception {
        String s1;
        String s2;
        int escolha_frequente;
        String dat;
        int val, tip, cat;
        System.out.print("\n #FREQUENTE# \n ");
        System.out.print("\n 1-Inserir");
        System.out.print("\n 2-Apagar ");
        System.out.print("\n Escolha uma opcao:");
        
        Scanner novo = new Scanner(System.in);
        escolha_frequente = novo.nextInt();

        switch (escolha_frequente) {
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
                String lista1 = listarCategoria();
                System.out.println(lista1);
                System.out.print("Inserir uma categoria: ");
                cat = novo.nextInt();
               // inserirMovimento(s1, s2, dat, val, tip, cat);
                System.out.print("\n Inserir um período (dia): ");
                String periodo = novo.next();
                //inserirFrequente(periodo);
                break;
            case 2:
                System.out.print("Apagar um Lancamento pelo nome: ");
                s2 = novo.next();
                //apagarFrequente(s2);
                break;
            case 3:
                Scanner velho = new Scanner(System.in);
                System.out.print("Digite ... alterar: ");
                s2 = velho.next(); 
                System.out.print("Digite ... Categoria: ");
                s1 = novo.next();
                //atualizarFrequente(s2, s1);
                break;    
        }
    }

    private static String listarCategoria() {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.listarCategoria();
    }

   /* private static String inserirMovimento(java.lang.String mov, java.lang.String arg1, java.lang.String arg2, float arg3, int arg4, int arg5) throws ParseException_Exception {
       service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirMovimento(mov, arg1, arg2, arg3, arg4, arg5);
    }

    private static String inserirFrequente(java.lang.String freq) throws ParseException_Exception {
        service.Finance_Service service = new service.Finance_Service();
        service.Finance port = service.getFinancePort();
        return port.inserirFrequente(freq);
    }*/



}

