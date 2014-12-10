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
import java.util.TreeMap;

public class Vote {
	//Map of <value, count> for votes
	private TreeMap<Integer, Integer> votes = new TreeMap<Integer, Integer>();
	//unique identifier for the vote
	private String voteID;
	
	public Vote(String name){
		voteID = name;
	}
	
	/**
	 * add a vote to the current count.
	 * @param int value of the vote cast
	 */
	public void addVote(int vote){
		if(votes.containsKey(vote)){
			votes.put(vote, votes.get(vote)+1);
		} else {
			votes.put(vote, 1);
		}
	}
	
	/**
	 * Change an existing vote to a new value
	 * @param int previous value
	 * @param int new value
	 */
	public void changeVote(int oldValue, int newValue){
		removeVote(oldValue);
		addVote(newValue);
	}
	
	/**
	 * Remove a vote value from the current vote
	 * @param int value to remove
	 */
	public void removeVote(int valueToRemove){
		if(votes.containsKey(valueToRemove)){
			votes.put(valueToRemove, votes.get(valueToRemove)-1);
			if(votes.get(valueToRemove)<=0){
				votes.remove(valueToRemove);
			}
		}
	}
	
	/**
	 * Return the treemap of all votes cast
	 * @return TreeMap of all votes of <value, count> where the value is the 
	 * vote and the count is how many people cast that value.
	 */
	public TreeMap<Integer, Integer> getVotes(){
		return votes;
	}
	
	/**
	 * Returns the ID of the vote
	 * @return String unique ID for the vote.
	 */
	public String getID(){
		return voteID;
	}
	
	/**
	 * Gets mode average vote (most common vote value). If draw or no votes returns -999.
	 * @return int of either the mode value in this vote or -999 if there is a draw or no votes. 
	 */
	public int getMode(){
		int mostFrequentKey = 0;
		int mostFrequentKeyCount = -999;
		boolean draw = false;
		for(int key:votes.keySet()){
			//if key <0 then it is a pass/don't know/cancelled vote so ignore.
			if(key>=0){
				if(votes.get(key)==mostFrequentKeyCount){
					draw = true;
				}
				if(votes.get(key)>mostFrequentKeyCount){
					mostFrequentKey = key;
					mostFrequentKeyCount = votes.get(key);
					draw = false;
				}
			}
		}
		if(draw){
			return -999;//ERROR CASE AS NO MODE POSSIBLE DUE TO A DRAW
		}
		return mostFrequentKey; 
	}
	
	/**
	 * Gets mean value of all votes cast.
	 * @return float mean vote
	 */
	public float getMean(){
		int numberOfVotes = 0;
		int totalAccumulatedSize = 0;
		for(int key:votes.keySet()){
			//if key <0 then it is a pass/don't know/cancelled vote so ignore.
			if(key>=0){
				numberOfVotes +=votes.get(key);
				totalAccumulatedSize+=(key*votes.get(key));
			}
		}
		if(numberOfVotes==0){
			return 0;
		}
		
		return totalAccumulatedSize/numberOfVotes;
	}
	
	/**
	 * Looks at the median value. Returns a string description of what the median value is, 
	 *	or what values it is split between if even number of votes.
	 *
	 * @return String sentence describing vote median
	 */
	public String getMedian(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String returnMessage = "";
		for(int key:votes.keySet()){
			//if key <0 then it is a pass/don't know/cancelled vote so ignore.
			if(key>=0){
				for(int i=0; i<votes.get(key); i++){
					list.add(key);
				}
			}
			
		}
		Collections.sort(list);
		if(list.size()>=1 && (list.size()%2 == 0)){
			//we have even number of entries so compare if 2 entries are same/different
			int leftValue = list.get((list.size()/2)-1);
			int rightValue = list.get((list.size()/2));
			if(leftValue == rightValue){
				//if values match median value is their value.
				returnMessage = "The median value is "+leftValue;
			}
			//values did not match - no median possible so return both values and message to that effect.
			returnMessage = "There are an even number of votes, so the median value is between "+leftValue+" and "+rightValue;
		} else if(list.size()>=1) {
			//we have odd number of entries so give middle value
			returnMessage = "The median value is "+list.get(list.size()/2);
		} else {
			returnMessage = "There are no votes in the current vote. Averages cannot be calculated.";
		}
		return returnMessage;
	}
}