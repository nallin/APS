package menu;

import java.util.Scanner;

public class Menu {
    
    public static void main (String[] args) {
        int escolha_menu;

        System.out.print("\n #MENU#\n ");
        System.out.print("\n 1- Categoria");
        System.out.print("\n 2- Frequente");
        System.out.print("\n 3- Movimento");
        System.out.print("\n Escolha uma opcao:");

        Scanner novo = new Scanner(System.in);
        escolha_menu = novo.nextInt();

        switch (escolha_menu) {
            case 1:
                Cate_menu cate = new Cate_menu();
                cate.categoria_menu(args);
            break;
            case 2:
                Freq_menu freq = new Freq_menu();
                freq.frequente_menu(args);
            break;
            case 3:
                Mov_menu movi = new Mov_menu();
                movi.movimento_menu(args);
             break;   
        }
    }
}

