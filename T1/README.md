# Entrega 01 - Sockets

Primeiro trabalho da disciplina **DCC042 - Redes de Computadores**.

## Requisitos

* Java 21 instalado e configurado

## Compilação

Para compilar o projeto:

```bash
javac ClientHandler.java EchoServer.java EchoClient.java
```

## Execução

### Servidor

Para iniciar o servidor:

```bash
java EchoServer
```

### Cliente

Para iniciar um cliente:

```bash
java EchoClient
```

## Comandos disponíveis

O sistema possui os seguintes comandos:

* `echo <mensagem>` — o servidor responde com um eco da mensagem enviada pelo cliente.
* `quit` — encerra a conexão do cliente com o servidor.
