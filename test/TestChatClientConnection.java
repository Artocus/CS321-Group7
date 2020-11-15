package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.jupiter.api.Test;

import connection.ChatClientConnection;

class TestChatClientConnection {

	@Test
	void test() {
		try {
			ServerSocket hostSocket = new ServerSocket(5000);
			Socket clientSocket = new Socket("localhost", 5000);
			Socket socket = hostSocket.accept();
			
			ChatClientConnection client1 = new ChatClientConnection(clientSocket, 3);
			ChatClientConnection client2 = new ChatClientConnection(socket, 3);
			
			String message = ":)";
			assertTrue(client1.sendMessage(message));
			assertEquals(client2.receiveMessage(), message);
			
			client1.close();
			client2.close();
			
			clientSocket.close();
			socket.close();
			hostSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
