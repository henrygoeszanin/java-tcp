import java.io.*; // Importa classes para entrada e saída de dados
import java.net.*; // Importa classes para comunicação em rede
import java.text.SimpleDateFormat; // Importa classe para formatação de data e hora
import java.util.Date; // Importa classe para manipulação de datas

public class TcpServidor {
    public static void main(String[] args) {
        int porta = 12345; // Porta para o servidor ouvir conexões
        try (ServerSocket servidor = new ServerSocket(porta)) { // Cria um ServerSocket na porta especificada
            System.out.println("Servidor iniciado. Aguardando conexão..."); // Mensagem de inicialização do servidor

            while (true) { // Loop infinito para aceitar conexões de clientes
                try (Socket cliente = servidor.accept(); // Aguarda e aceita uma conexão de cliente
                     PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true)) { // Cria um PrintWriter para enviar dados ao cliente

                    System.out.println("Cliente conectado: " + cliente.getInetAddress()); // Exibe o endereço do cliente conectado

                    long inicio = System.currentTimeMillis(); // Marca o tempo de início do processamento
                    double somaCPU = 0; // Inicializa a soma do uso da CPU

                    for (int i = 1; i <= 10; i++) { // Loop para coletar dados de uso da CPU 10 vezes
                        double usoCPU = getUsoCPU(); // Obtém o uso da CPU (simulado)
                        somaCPU += usoCPU; // Adiciona o uso da CPU à soma

                        String dataHora = new SimpleDateFormat("dd/MM/yyyy | HH:mm:ss").format(new Date()); // Formata a data e hora atual
                        saida.println(i + ") " + dataHora + " | " + String.format("%.3f", usoCPU) + "%"); // Envia os dados ao cliente

                        Thread.sleep(1000); // Aguarda 1 segundo entre coletas
                    }

                    long fim = System.currentTimeMillis(); // Marca o tempo de fim do processamento
                    double mediaCPU = somaCPU / 10; // Calcula a média do uso da CPU
                    saida.println("\nVALOR MÉDIO DO USO DA CPU DO SERVIDOR: " + String.format("%.3f", mediaCPU) + "%"); // Envia a média ao cliente
                    saida.println("TEMPO DE PROCESSAMENTO: " + (fim - inicio) / 1000 + " segundos"); // Envia o tempo de processamento ao cliente
                    saida.println("<><><><CONEXÃO FECHOU><><><>"); // Informa que a conexão foi fechada

                    System.out.println("Conexão encerrada com o cliente."); // Mensagem de encerramento da conexão com o cliente
                } catch (Exception e) { // Captura exceções durante o processamento do cliente
                    System.err.println("Erro ao processar cliente: " + e.getMessage()); // Exibe mensagem de erro
                }
            }
        } catch (IOException e) { // Captura exceções ao iniciar o servidor
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage()); // Exibe mensagem de erro
        }
    }

    private static double getUsoCPU() {
        return Math.random() * 100; // Simulação de uso da CPU
    }
}