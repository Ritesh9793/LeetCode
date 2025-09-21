class MovieRentingSystem {

    private Map<Integer, TreeSet<ShopEntry>> available;
    // Map (shop, movie) -> price
    private Map<Pair, Integer> priceMap;
    // TreeSet of rented copies, ordered by price, then shop, then movie
    private TreeSet<RentedEntry> rented;

    // Helper class for available entries
    private static class ShopEntry {
        int price;
        int shop;
        // movie is known via the map key, so not stored here

        ShopEntry(int price, int shop) {
            this.price = price;
            this.shop = shop;
        }
    }

    // Helper class for rented entries
    private static class RentedEntry {
        int price;
        int shop;
        int movie;

        RentedEntry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
    }

    // Pair class for (shop, movie)
    private static class Pair {
        int shop;
        int movie;
        Pair(int shop, int movie) {
            this.shop = shop;
            this.movie = movie;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair other = (Pair) o;
            return this.shop == other.shop && this.movie == other.movie;
        }
        @Override
        public int hashCode() {
            return Objects.hash(shop, movie);
        }
    }

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        priceMap = new HashMap<>();
        // Comparator for available copies: first price, then shop id
        Comparator<ShopEntry> cmpAvailable = (a, b) -> {
            if (a.price != b.price) return Integer.compare(a.price, b.price);
            return Integer.compare(a.shop, b.shop);
        };
        // Comparator for rented copies: price, then shop, then movie
        Comparator<RentedEntry> cmpRented = (a, b) -> {
            if (a.price != b.price) return Integer.compare(a.price, b.price);
            if (a.shop != b.shop) return Integer.compare(a.shop, b.shop);
            return Integer.compare(a.movie, b.movie);
        };
        rented = new TreeSet<>(cmpRented);

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(new Pair(shop, movie), price);

            available.putIfAbsent(movie, new TreeSet<>(cmpAvailable));
            available.get(movie).add(new ShopEntry(price, shop));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        TreeSet<ShopEntry> set = available.get(movie);
        if (set == null) return result;
        // Iterate first 5
        int count = 0;
        for (ShopEntry se : set) {
            result.add(se.shop);
            count++;
            if (count == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        Pair key = new Pair(shop, movie);
        Integer price = priceMap.get(key);
        if (price == null) return;  // or throw error

        // Remove from available
        TreeSet<ShopEntry> set = available.get(movie);
        set.remove(new ShopEntry(price, shop));

        // Add to rented
        rented.add(new RentedEntry(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        Pair key = new Pair(shop, movie);
        Integer price = priceMap.get(key);
        if (price == null) return;

        // Remove from rented
        rented.remove(new RentedEntry(price, shop, movie));

        // Add back to available
        available.get(movie).add(new ShopEntry(price, shop));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (RentedEntry re : rented) {
            result.add(Arrays.asList(re.shop, re.movie));
            count++;
            if (count == 5) break;
        }
        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */