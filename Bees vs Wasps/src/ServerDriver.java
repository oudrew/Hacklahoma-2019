import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerDriver
{

    public static void main(String[] args) throws IOException {
        
        //The main server and sockets
        ServerSocket server = new ServerSocket (80);
        Socket player1Socket = server.accept();
        Socket player2Socket = server.accept();
        
        //Appropriate input and output streams accepted from the sockets
        OutputStream toPlayer1 = player1Socket.getOutputStream();
        InputStream fromPlayer1 = player1Socket.getInputStream();
        OutputStream toPlayer2  = player2Socket.getOutputStream();
        InputStream fromPlayer2 = player2Socket.getInputStream();
        
        //We will use scanners to convert the Streams to Strings
        Scanner player1;
        Scanner player2;
        
        //variables to track the players health, cards etc
        int p1Health = 30;
        int p2Health = 30;
        ArrayList<Integer> player1Cards = new ArrayList<Integer>();
        ArrayList<Integer> player2Cards = new ArrayList<Integer>();
        
        //whether or not the player is done with their deck building/turn
        boolean p1Done = false;
        boolean p2Done = false;
        
        //the ONLY thing this while loop does is check whether each player is done building their deck or not
        while (!p1Done && !p2Done) {
            player1 = new Scanner(fromPlayer1.toString());
            player2 = new Scanner(fromPlayer2.toString());
            if (player1.hasNext() || player2.hasNext()) {
                if (player1.hasNext()) {
                    p1Done = true;
                }
                if (player2.hasNext()) {
                    p2Done = true;
                }
            }
            player1.close();
            player2.close();
        }
        
        //receives each deck input for each player and adds it to each players cardlist
       while (player1Cards.size() < 10) {
            player1 = new Scanner(fromPlayer1.toString());
            player1Cards.add(player1.nextInt());
            player1.close();
        }

        while (player2Cards.size() < 10) {
            player2 = new Scanner(fromPlayer2.toString());
            player2Cards.add(player2.nextInt());
            player2.close();
        }
        
        player1Socket.close();
        player2Socket.close();
        server.close();
    }
}
