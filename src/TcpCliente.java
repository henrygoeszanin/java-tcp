import java.io.*; // Importa classes para entrada e saída de dados
import java.net.*; // Importa classes para comunicação em rede

public class TcpCliente {
    public static void main(String[] args) {
        if (args.length < 2) { // Verifica se os argumentos são suficientes
            exibirAjuda(); // Exibe a ajuda se os argumentos forem insuficientes
            return; // Encerra o programa
        }

        String comando = args[0]; // Obtém o comando do primeiro argumento
        String endereco = args[1]; // Obtém o endereço do segundo argumento

        if (!comando.equalsIgnoreCase("CPU") && !comando.equalsIgnoreCase("-help")) { // Verifica se o comando é válido
            System.out.println("ERRO1:\n***PARÂMETRO INCORRETO***\nUTILIZE\n<CPU> ou <cpu> para ler os dados do servidor\n<-help> para ajuda.\nEx.: java TcpCliente -help localhost\n<><><><CONEXÃO FECHOU><><><>"); // Mensagem de erro para comando inválido
            return; // Encerra o programa
        }

        if (comando.equalsIgnoreCase("-help")) { // Verifica se o comando é para exibir ajuda
            exibirAjuda(); // Exibe a ajuda
            return; // Encerra o programa
        }

        try (Socket socket = new Socket(endereco, 12345); // Cria um socket para se conectar ao servidor
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) { // Cria um BufferedReader para ler dados do servidor

            String linha;
            while ((linha = entrada.readLine()) != null) { // Lê linhas de dados do servidor
                System.out.println(linha); // Exibe os dados recebidos
            }

            System.out.println("<><><><CONEXÃO FECHOU><><><>"); // Informa que a conexão foi fechada
        } catch (IOException e) { // Captura exceções ao conectar ao servidor
            System.err.println("Erro ao conectar ao servidor: " + e.getMessage()); // Exibe mensagem de erro
        }
    }

    private static void exibirAjuda() {
        System.out.println("AJUDA:\n<><><><PARÂMETROS><><><>\nCPU -> apresenta os dados de utilização da CPU DO SERVIDOR\n<><><><CONEXÃO FECHOU><><><>"); // Mensagem de ajuda
    }
}
