package client;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.util.ArrayList;
import java.util.List;

import client.Room;
import connection.ChatClientConnection;
import connection.HostCreation;

public class RoomManager {

	private List<Room> rooms;
	
	public RoomManager() {
		rooms = new ArrayList<Room>();
	}
	
	public void hostRoom(int port) {
		HostCreation hostCreation = null;
		try {
			hostCreation = new HostCreation(port, 3);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Room room = new Room("localhost", port, hostCreation);
		room.addUser(new User("localhost", "name"));
		
		rooms.add(new Room("localhost", port, hostCreation));
	}
	
	public void joinRoom(String ip, int port) {
		ChatClientConnection chatClientConnection = null;
		try {
			chatClientConnection = new ChatClientConnection(ip, port, 3);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Room room = new Room(ip, port, chatClientConnection);
		
		
		rooms.add(room);
	}
	
	public void sendMessage(String message, int roomNumber) {
		try {
			rooms.get(roomNumber).getRoomConnection().sendMessage(message);
		} catch (UTFDataFormatException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> receiveMessage(int roomNumber) {
		Room room = rooms.get(roomNumber);
		List<String> messages = null;
		boolean isHost = false;
		User[] users = room.getUsers();
		if(users.length > 0 && users[0].getIP() == "localhost") {
			isHost = true;
		}
		try {
			messages = room.getRoomConnection().receiveMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return messages;
		}
		for(String message : messages) {
			room.addChatMessage(message);
			if(isHost) {
				sendMessage(message, roomNumber);
			}
		}
		return messages;
	}
	
	public void requestUserList(int roomNumber) {
		//TODO: Format for requesting user list from host
	}
}
