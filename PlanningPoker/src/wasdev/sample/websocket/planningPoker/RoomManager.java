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
import java.util.Collections;
import java.util.List;

public class RoomManager {
	private static List<Room> rooms = Collections.synchronizedList(new ArrayList<Room>());

	/**
	 * Finds and returns the room with the given name. If no room exists with that name creates and returns room.
	 * @param name of room requested
	 * @return Room with given name (either an existing room or a new room if it did not exist before request).
	 */
	public static Room getRoomByName(String name){
		synchronized (rooms) {
			for(Room room: rooms){
				if(room.getName().equalsIgnoreCase(name)){
					return room;
				}
			}
			//if we get here there was no pre-existing room with given name. Create room and return that.
			Room newRoom = createRoom(name);
			rooms.add(newRoom);
			return newRoom;
		}
	}

	/**
	 * Creates a Room with the provided name.
	 * @param name of room to be created.
	 * @return Room with requested name.
	 */
	public static Room createRoom(String name){
		return new Room(name);
	}

	/**
	 * Removes the room with the given name.
	 * @param name of room to be deleted.
	 */
	public static void deleteRoom(String name){
		synchronized (rooms) {
			for(Room room: rooms){
				if(room.getName().equalsIgnoreCase(name)){
					rooms.remove(room);
					return;
				}
			}
		}
	}	
}