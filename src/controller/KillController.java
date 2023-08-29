package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
    //O primeiro, chamado os, que identifica e retorna o nome do Sistema Operacional (Fazê-lo privado)
    private String os() {
        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            return "Windows";
        } else {
            return "Linux";
        }
    }

    //O segundo, chamado listaProcessos, que verifica o SO e, de acordo com SO, selecione o comando para listar os processos ativos.
    //O método deve receber todas as linhas de saída do processo de listagem e exibi-las em console
    public void listaProcessos() {
        String os = this.os();
        StringBuilder process = new StringBuilder();

        //Comando no terminal dependendo SO
        if (os.equals("Windows")) {
            process.append("tasklist /fo table");
        } else {
            process.append("ps -ef");
        }

        try {
            //Copia o resultado do comando no buffer
            Process p = Runtime.getRuntime().exec(process.toString());
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);

            //Printa apenas o IPv4 no buffer
            String linha;
            while ((linha = buffer.readLine()) != null) {
                if (os.equals("Windows")) {
                    System.out.println(linha);
                } else {
                    System.out.println("a");
                }
            }

            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //O terceiro, chamado mataPid, que recebe um PID como parâmetro de entrada, verifica o SO e, de acordo com SO, selecione o comando para matar o processo e o finalize
    public void mataPid(int pid) {
        String os = this.os();
        StringBuilder process = new StringBuilder();

        //Comando no terminal dependendo SO
        if (os.equals("Windows")) {
            process.append("taskkill /pid ");
        } else {
            process.append("kill -9 ");
        }
        process.append(pid);

        try {
            //Executa o comando no terminal
            Runtime.getRuntime().exec(process.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //O quarto, chamado mataNome, que recebe um nome de processo como parâmetro de entrada, verifica o SO e, de acordo com SO, selecione o comando para matar o processo e o finalize
    public void mataNome(String nomeProcesso) {
        String os = this.os();
        StringBuilder process = new StringBuilder();

        //Comando no terminal dependendo SO
        if (os.equals("Windows")) {
            process.append("taskkill /im ");
        } else {
            process.append("pkill -f ");
        }
        process.append(nomeProcesso);

        try {
            //Executa o comando no terminal
            Runtime.getRuntime().exec(process.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
