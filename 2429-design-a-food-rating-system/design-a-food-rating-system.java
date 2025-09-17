class FoodRatings {

    
    private Map<String, TreeSet<Food>> cuisineToFoods;
    
    private Map<String, Integer> foodToRating;
    
    private Map<String, String> foodToCuisine;

    
    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineToFoods = new HashMap<>();
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);

            
            cuisineToFoods.computeIfAbsent(cuisine, c -> new TreeSet<>(new Comparator<Food>() {
                @Override
                public int compare(Food f1, Food f2) {
                    if (f1.rating != f2.rating) {
                       
                        return Integer.compare(f2.rating, f1.rating);
                    }
                    
                    return f1.name.compareTo(f2.name);
                }
            }));

            cuisineToFoods.get(cuisine).add(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        TreeSet<Food> set = cuisineToFoods.get(cuisine);
        
        set.remove(new Food(food, oldRating));
       
        set.add(new Food(food, newRating));

        
        foodToRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        TreeSet<Food> set = cuisineToFoods.get(cuisine);
        
        return set.first().name;
    }
}

