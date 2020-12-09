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
	private List<String> messageLog;
	private List<Game> games;
	
	public Room(String ip, int port, RoomConnection roomConnection) {
		this.ip = ip;
		this.port = port;
		users = new ArrayList<User>();
		messageLog = new ArrayList<String>();
		games = new ArrayList<Game>();
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
		users.add(u);
	}
	
	public void removeUser(String name) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getName().equals(name)) {
				users.remove(i);
				break;
			}
		}
	}
	
	public User[] getUsers(){
		User[] u = new User[users.size()];
		return users.toArray(u);
	}
	
	public void addMessage(String message) {
		messageLog.add(message);
	}
	
	public String[] getMessageLog() {
		String[] m = new String[messageLog.size()];
		return messageLog.toArray(m);
	}
}
