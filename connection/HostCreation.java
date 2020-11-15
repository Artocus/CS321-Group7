package connection;

import java.io.IOException;
import java.io.UTFDataFormatException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class HostCreation implements RoomConnection{

	private ServerSocket serverSocket;
	private List<ChatClientConnection> clientConnections;
	private int retryAmount;
	
	public HostCreation(int port, int retryAmount) throws IOException {
		this.retryAmount = retryAmount;
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			throw e;
		}
		
		clientConnections = new ArrayList<ChatClientConnection>();
	}
	
	public void acceptNewConnection() throws IOException {
		try {
			clientConnections.add(new ChatClientConnection(serverSocket.accept(), retryAmount));
		} catch (IOException e) {
			throw e;
		}
	}
	
	public boolean sendMessage(String message) throws UTFDataFormatException {
		
		for(ChatClientConnection connection : clientConnections) {
			try {
				connection.sendMessage(message);
			} catch (UTFDataFormatException e) {
				throw e;
			}
		}
		return true;
	}
	
	public List<String> receiveMessage() throws IOException {
		List<String> messages = new ArrayList<String>();
		for(ChatClientConnection connection : clientConnections) {
			try {
				messages.addAll(connection.receiveMessage());
			} catch (IOException e) {
				throw e;
			}
		}
		return messages;
	}
	
	public void close() throws IOException{
		for(ChatClientConnection connection : clientConnections) {
			connection.close();
		}
		serverSocket.close();
	}
}
