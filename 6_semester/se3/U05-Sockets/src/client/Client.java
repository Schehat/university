package client;

import java.io.*;
import java.net.Socket;

public class Client {

    private String hostname;
    private int port;
    Socket server;
    BufferedReader in;
    PrintWriter out;
    private int remainingTokens;

    private void connectTo(String hostname, int port) {
        try {
            print("Attempting to connect to " + hostname + ":" + port + "...");
            server = new Socket(hostname, port);
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            out = new PrintWriter(server.getOutputStream(), true);
            print("Connected to " + server.getRemoteSocketAddress() + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void requestRemainingTokens() throws IOException {
        remainingTokens = Integer.parseInt(in.readLine());
        print("There are " + remainingTokens + " remaining tokens.");
    }

    private void playGame() {
        print("Game started.");
        do {
            try {
                Thread.sleep(2000);
                requestRemainingTokens();
                if (remainingTokens == 0) {
                    print("No tokens left.");
                    break;
                }
                makeGameMove();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (isRemainingTokens());
        print("Game ended");
    }

    private boolean isRemainingTokens() {
        return remainingTokens > 0;
    }

    private void makeGameMove() throws IOException {
        int amountOfTokens;
        do {
            amountOfTokens = (int) ((Math.random()*3)+1);
        } while (amountOfTokens > remainingTokens);
        print("I take " + amountOfTokens + " token(s).");
        remainingTokens = remainingTokens - amountOfTokens;
        print("There are " + remainingTokens + " remaining tokens.");
        out.println(amountOfTokens);
    }

    private void requestWinner() {
        String winner = "";
        try {
            winner = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("client".equals(winner)) {
            print("I am the winner.");
        } else if ("server".equals(winner)){
            print("Server is the winner.");
        } else {
            print("Error");
        }
    }

    private void print(String toPrint) {
        System.out.println("Client: " + toPrint);
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connectTo("localhost", 12345);
        client.playGame();
        client.requestWinner();
    }

}
