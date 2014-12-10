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

public class VoteManager {
	//list of all votes.
	private static volatile ArrayList<Vote> votes = new ArrayList<Vote>();

	/**
	 * Returns vote with the given ID. If no existing vote exists with the ID creates one and returns that.
	 * 
	 * @param id of vote requested.
	 * @return Vote with corresponding ID.
	 */
	public static Vote getVoteByID(String id){
		for(Vote vote: votes){
			if(vote.getID().equalsIgnoreCase(id)){
				return vote;
			}
		}
		//if we get here there was no vote. Create vote and return that.
		Vote newVote = createVote(id);
		votes.add(newVote);
		return newVote;
	}
	
	/**
	 * Creates vote with given ID.
	 * 
	 * @param id of vote to be created.
	 * @return Vote with given ID.
	 */
	public static Vote createVote(String id){
		return new Vote(id);
	}
	
	/**
	 * Deletes the vote with the given ID.
	 * @param id of vote to be deleted.
	 */
	public static void deleteVote(String id){
		for(Vote vote: votes){
			if(vote.getID().equalsIgnoreCase(id)){
				votes.remove(vote);
			}
		}
	}
}
