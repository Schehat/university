package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port;
    private int remainingTokens;
    private int gameRound;
    private String gameWinner;
    ServerSocket serverSocket;
    Socket client;
    BufferedReader in;
    PrintWriter out;

    private void startServerOn(int port) {
        try {
            serverSocket = new ServerSocket(port);
            print("Server started.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitForClient() {
        try {
            print("Waiting for client...");
            client = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
            print("Client " + client.getRemoteSocketAddress() + " connected.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeGame(int amountOfTokens) {
        remainingTokens = amountOfTokens;
        gameRound = 1;
    }

    private void playGame() {
        print("Game started.");
        while (isRemainingTokens()) {
            print("Game round: " + gameRound);
            print("Remaining tokens: " + remainingTokens);
            try {
                Thread.sleep(2000);
                makeGameMove();
                publishRemainingTokens();
                if (remainingTokens == 0) {
                    gameWinner = "server";
                    print("No tokens left.");
                    break;
                }
                waitForClientGameMove();
                if (remainingTokens == 0) {
                    gameWinner = "client";
                    print("No tokens left.");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            gameRound++;
        }
        print("Game ended");
    }

    private void publishWinner() {
        if ("client".equals(gameWinner)) {
            print("Client is the winner.");
            out.println("client");
        } else {
            print("I am the winner.");
            out.println("server");
        }
    }

    private void waitForClientGameMove() throws IOException {
        print("Waiting for client game move...");
        int amountOfClientTokens = Integer.parseInt(in.readLine());
        reduceRemainingTokensBy(amountOfClientTokens);
        print("Client took " + amountOfClientTokens + " token(s).");
    }

    private boolean isRemainingTokens() {
        return remainingTokens > 0;
    }

    public void publishRemainingTokens() throws IOException {
        print("There are " + remainingTokens + " remaining tokens.");
        out.println(remainingTokens);
    }

    private void makeGameMove() throws IOException {
        int amountOfTokens;
        do {
            amountOfTokens = (int) ((Math.random()*3)+1);
        } while (amountOfTokens > remainingTokens);
        print("I take " + amountOfTokens + " token(s).");
        reduceRemainingTokensBy(amountOfTokens);
    }

    private void reduceRemainingTokensBy(int amountOfTokens) {
        remainingTokens = remainingTokens - amountOfTokens;
    }

    private void print(String toPrint) {
        System.out.println("Server: " + toPrint);
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServerOn(12345);
        server.waitForClient();
        server.initializeGame(26);
        server.playGame();
        server.publishWinner();
    }

}
