package view;

import controller.KillController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KillController controller = new KillController();
        Scanner leia = new Scanner(System.in);
        int escolha, pidProcesso;
        String nomeProcesso;

        do {
            System.out.println("\n+============================+");
            System.out.println("|            MENU            |");
            System.out.println("+============================+");
            System.out.println("| 1) Listar processos        |");
            System.out.println("| 2) Matar processo por PID  |");
            System.out.println("| 3) Matar processo por nome |");
            System.out.println("| 0) Sair                    |");
            System.out.println("+============================+");
            System.out.print("Digite a opção: ");
            escolha = leia.nextInt();

            switch (escolha) {
                case 1:
                    controller.listaProcessos();
                    break;
                case 2:
                    System.out.print("Digite o PID do processo desejado: ");
                    pidProcesso = leia.nextInt();

                    controller.mataPid(pidProcesso);
                    break;
                case 3:
                    System.out.print("Digite o nome do processo desejado: ");
                    nomeProcesso = leia.next();

                    controller.mataNome(nomeProcesso);
                    break;
                case 0:
                    System.out.println("FINALIZADO");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        } while (escolha != 0);
    }
}
