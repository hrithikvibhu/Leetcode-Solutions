class Twitter {
    private static int timestamp = 0;
    Map<Integer,User> map;
    private class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id){
            this.id = id;
            time = timestamp++;
            next = null;
        }
    }
    
    public class User{
        int id;
        Set<Integer> followed;
        Tweet head;
        public User(int _id){
            this.id = _id;
            followed = new HashSet<>();
            follow(_id);
            head = null;
        }
        
        public void follow(int _id){
            followed.add(_id);
        }
        
        public void unfollow(int _id){
            followed.remove(_id);
        }
        
        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = head;
            head = t;
        }
    }
    
    
    public Twitter() {
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
            User u = new User(userId);
            map.put(userId , u);
        }
        map.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!map.containsKey(userId)) return res;
        
        Queue<Tweet> q = new PriorityQueue<>((a,b)->b.time-a.time);
        for(Integer user : map.get(userId).followed){
            Tweet t = map.get(user).head;
            if(t!=null)
                q.offer(t);
        }
        int i=0;
        while(i<10 && !q.isEmpty()){
            i++;
            Tweet t = q.poll();
            res.add(t.id);
            if(t.next!=null)
                q.offer(t.next);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            User u = new User(followerId);
            map.put(followerId,u);
        }
        if(!map.containsKey(followeeId)){
            User u = new User(followeeId);
            map.put(followeeId,u);
        }
        map.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId) || followerId==followeeId)
			return;
		map.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */