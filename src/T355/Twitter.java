package T355;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Twitter {

	private Map<Integer, ArrayList<Tweet>> feeds;
	private Map<Integer, Set<Integer>> followers;
	private Map<Integer, ArrayList<Tweet>> tweets;
	private int time;
	
	public Twitter() {
		// user_id --> list of tweets
		tweets = new HashMap<Integer, ArrayList<Tweet>>();
		feeds = new HashMap<Integer, ArrayList<Tweet>>();
		followers = new HashMap<Integer, Set<Integer>>();
		time = 0;
	}
	
	public void postTweet(int userId, int tweetId) {
		Tweet tweet = new Tweet(tweetId, time);
		if (!tweets.containsKey(userId)) tweets.put(userId,  new ArrayList<Tweet>());
		tweets.get(userId).add(tweet);
		
		if (!feeds.containsKey(userId)) feeds.put(userId, new ArrayList<Tweet>());
		feeds.get(userId).add(tweet);
		
		Set<Integer> followerSet = followers.get(userId);
		if (followerSet != null && followerSet.size() > 0)
			for (int follower: followerSet)
				if (follower != userId) feeds.get(follower).add(tweet);
		time ++;
	}
	
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new ArrayList<Integer>();
		List<Tweet> tweets = feeds.get(userId);
		if (tweets == null || tweets.size() == 0) return res;
		for (int i = tweets.size() - 1; i >= Math.max(tweets.size() - 10, 0); i --)
			res.add(tweets.get(i).tweetId);
		return res;
	}
	
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId) return;
		if (!followers.containsKey(followeeId)) followers.put(followeeId, new HashSet<Integer>());
		if (followers.get(followeeId).add(followerId)) { 
			if (!feeds.containsKey(followerId)) feeds.put(followerId, new ArrayList<Tweet>());
			feeds.put(followerId, addTweets(feeds.get(followerId), tweets.get(followeeId)));
		}
	}
	
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId) return;
		if (!followers.containsKey(followeeId)) followers.put(followeeId, new HashSet<Integer>());
		if (followers.get(followeeId).remove(followerId)) {
			if (!feeds.containsKey(followerId)) feeds.put(followerId, new ArrayList<Tweet>());
			if (tweets.containsKey(followeeId)) feeds.get(followerId).removeAll(tweets.get(followeeId));
		}
	}
	
	// here actually it can be done in place.
	private ArrayList<Tweet> addTweets(ArrayList<Tweet> tweets1, ArrayList<Tweet> tweets2) {
		if (tweets2 == null || tweets2.size() == 0) return tweets1;
		int len1 = tweets1.size(), len2 = tweets2.size();
		int i = 0, j = 0;
		ArrayList<Tweet> res = new ArrayList<Tweet>();
		while (i < len1 || j < len2) {
			if (i == len1 || (i < len1 && j < len2 && tweets1.get(i).time > tweets2.get(j).time))
				res.add(tweets2.get(j ++));
			else
				res.add(tweets1.get(i ++));
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Twitter twitter = new Twitter();
		twitter.postTweet(2,5);
		twitter.postTweet(1,3);
		twitter.postTweet(1,101);
		twitter.postTweet(2,13);
		twitter.postTweet(1,10);
		twitter.postTweet(1,2);
		twitter.postTweet(2,94);
		twitter.postTweet(2,505);
		twitter.postTweet(1,333);
		twitter.postTweet(1,22);
		List<Integer> feed1 = twitter.getNewsFeed(2);
		for (int i = 0; i < feed1.size(); i ++) System.out.print(feed1.get(i) + ", ");
		System.out.println();
		
		twitter.follow(2, 1);
		
		List<Integer> feed2 = twitter.getNewsFeed(2);
		for (int i = 0; i < feed2.size(); i ++) System.out.print(feed2.get(i) + ", ");
		System.out.println();
		
	}

}
