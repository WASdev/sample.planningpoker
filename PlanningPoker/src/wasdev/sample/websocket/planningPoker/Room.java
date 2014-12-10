/*
 * COPYRIGHT LICENSE: This information contains sample code provided in source code form.
 * You may copy, modify, and distribute these sample programs in any form without payment
 * to IBM for the purposes of developing, using, marketing or distributing application
 * programs conforming to the application programming interface for the operating platform
 * for which the sample code is written.
 * 
 * Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE ON 
 * AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, INCLUDING,
 * BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY,
 * SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE, AND ANY WARRANTY OR
 * CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF
 * THE SAMPLE SOURCE CODE. IBM HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT,
 * UPDATES, ENHANCEMENTS OR MODIFICATIONS TO THE SAMPLE SOURCE CODE.
 * 
 * (C) Copyright IBM Corp. 2014.
 * All Rights Reserved. Licensed Materials - Property of IBM.
 */

package wasdev.sample.websocket.planningPoker;

import java.util.ArrayList;
import java.util.UUID;

public class Room {
	private String name = "";
	private ArrayList<String> messageHistory = new ArrayList<String>();
	private String voteId;
	
	public Room(String roomName){
		name = roomName;
	}
	
	/**
	 * Sets the name for the room.
	 * @param newName new name for the room.
	 */
	public void setName(String newName){
		name = newName;
	}
	
	/**
	 * Returns the name of the room.
	 * @return String name of the room.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Removes all message history from this room.
	 */
	public void clearMessages(){
		messageHistory.clear();
	}
	
	/**
	 * Adds a message to the room message history.
	 * @param message to add to history.
	 */
	public void addMessage(String message){
		messageHistory.add(message);
	}
	
	/**
	 * Gets all messages from this room's history.
	 * @return ArrayList<String> of all messages for this room.
	 */
	public ArrayList<String> getMessageHistory(){
		return messageHistory;
	}
	
	/**
	 * Finds the UUID for the vote currently associated with this room. If none exists it creates one and returns it.
	 * @return String UUID for the voteID in this room.
	 */
	public String getVoteId(){
		if(voteId==null){
			voteId = UUID.randomUUID().toString();
		}
		return voteId;
	}
	
	/**
	 * Removes the current vote UUID from this room. 
	 */
	public void clearVoteId(){
		voteId = null;
	}
}