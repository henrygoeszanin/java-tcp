# Projeto: Monitoramento de Uso da CPU via Socket TCP

## Descrição
Este projeto implementa um servidor e cliente TCP para monitoramento de uso da CPU. O servidor coleta dados simulados do uso da CPU, enquanto o cliente exibe as informações recebidas.

## Estrutura do Projeto
```
Projeto/
├── src/
│   ├── TcpServidor.java
│   └── TcpCliente.java
├── build/
└── README.md
```

## Como Compilar
Navegue até o diretório raiz e execute:
```bash
javac -d build src/TcpServidor.java src/TcpCliente.java
```

## Como Executar
1. **Iniciar o Servidor**
   ```bash
   java -cp build TcpServidor
   ```

2. **Executar o Cliente**
   ```bash
   java -cp build TcpCliente CPU 127.0.0.1
   ```

## Mensagens de Erro e Ajuda
- Comando incorreto:
  ```
  ERRO1:
  ***PARÂMETRO INCORRETO***
  UTILIZE
  <CPU> ou <cpu> para ler os dados do servidor
  <-help> para ajuda.
  ```
- Ajuda:
  ```
  AJUDA:
  <><><><PARÂMETROS><><><>
  CPU -> apresenta os dados de utilização da CPU DO SERVIDOR
  <><><><CONEXÃO FECHOU><><><>
  ```