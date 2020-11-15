package client;
import java.util.ArrayList;
import java.util.List;

import client.User;
import connection.RoomConnection;

public class Room {

	private List<User> users;
	private String ip;
	private int port;
	private RoomConnection roomConnection;
	private List<String> chatLog;
	// private Game[] games;
	
	public Room(String ip, int port, RoomConnection roomConnection) {
		this.ip = ip;
		this.port = port;
		users = new ArrayList<User>();
		chatLog = new ArrayList<String>();
		this.roomConnection = roomConnection;
	}
	
	public String getIP() {
		return ip;
	}
	
	public int getPort() {
		return port;
	}
	
	public RoomConnection getRoomConnection() {
		return roomConnection;
	}
	
	public void addUser(User u) {
		//TODO: Make to so duplicate users cant be added
		users.add(u);
	}
	
	public User[] getUsers(){
		User[] u = new User[users.size()];
		return users.toArray(u);
	}
	
	public void addChatMessage(String chatMessage) {
		chatLog.add(chatMessage);
	}
	
	public String[] getChatLog() {
		String[] m = new String[chatLog.size()];
		return chatLog.toArray(m);
	}
}
