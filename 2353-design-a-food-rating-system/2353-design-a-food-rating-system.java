class FoodRatings {
    
    class Food{
        String food;
        String cuisine;
        int rating;
        
        public Food(String food, String c , int r){
            this.food = food;
            this.cuisine = c;
            this.rating = r;
        }
    }
    
    
    Map<String,Food> foodMap;
    Map<String,PriorityQueue<Food>> cuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        
        for(int i=0;i<n;i++){
            Food food = new Food(foods[i],cuisines[i],ratings[i]);
            foodMap.put(food.food , food);
            if(cuisineMap.containsKey(food.cuisine)){
                PriorityQueue<Food> q = cuisineMap.get(food.cuisine);
                q.offer(food);
                cuisineMap.put(food.cuisine,q);
            }
            else{
                PriorityQueue<Food> q =  new PriorityQueue<>((a,b)-> (a.rating==b.rating) ?
            a.food.compareTo(b.food):
            b.rating-a.rating);
                q.offer(food);
                cuisineMap.put(food.cuisine,q);
            }
        }
    }
    
    public void changeRating(String f, int newRating) {
        Food food = foodMap.get(f);
        if(food !=null){
            food.rating = newRating;
            foodMap.put(f,food);
            PriorityQueue<Food> q = cuisineMap.get(food.cuisine);
            q.remove(food);
            q.offer(food);
        }
        
    }
    
    public String highestRated(String c) {
        return cuisineMap.get(c).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */