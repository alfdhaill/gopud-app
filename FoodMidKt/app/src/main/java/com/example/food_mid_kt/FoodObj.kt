package com.example.food_mid_kt

object FoodObj {

    fun getFoodList() : ArrayList<Food> {

        return arrayListOf(
            Food("Chicken Noodles", "Combination between sweet and spicy noodles with a taste of chicken", 15000, R.drawable.baseline_fastfood_24),
            Food("Jakarta Fried Rice", "Sweet taste of fried rice", 15000, R.drawable.baseline_fastfood_24),
            Food("Gado Gado", "An Indonesian salad of raw, slightly boiled, blanched or steamed vegetables served with a peanut sauce dressing", 12000, R.drawable.baseline_fastfood_24),
            Food("Wagyu Steak", "300gr of wagyu stea", 49000, R.drawable.baseline_fastfood_24),
            Food("Korean Chicken Wing", "Spicy and sweet sauce with tasty chicken wing",32000, R.drawable.baseline_fastfood_24),
            Food("Sweet Ice Tea", "Ya sweet ice tea", 5000, R.drawable.baseline_emoji_food_beverage_24),
            Food("Pop Ice Kudapan", "Rare pop ice that made at Kudapan BNI Universitas Hasanuddin", 5000, R.drawable.baseline_emoji_food_beverage_24),
            Food("Milo", "Just an ordinary cold milo but served with heart", 7000, R.drawable.baseline_emoji_food_beverage_24),
            Food("Avocado Juice", "Rich and silky chilled beverage made of fresh avocado", 10000, R.drawable.baseline_emoji_food_beverage_24),
            Food("Cold Water", "A cold bottle of Le Minerale that has sweetness", 3000, R.drawable.baseline_emoji_food_beverage_24),
        )

    }

}