package com.example.foodpark;

public class menuDetails {
    String recipeName,recipeProtein,recipeCarb,recipeFat,recipePrice,recipeRating;
    int image;

    public menuDetails(String recipeName, String recipeProtein, String recipeCarb,
                       String recipeFat, String recipePrice, String recipeRating,
                       int image) {
        this.recipeName = recipeName;
        this.recipeProtein = recipeProtein;
        this.recipeCarb = recipeCarb;
        this.recipeFat = recipeFat;
        this.recipePrice = recipePrice;
        this.recipeRating = recipeRating;
        this.image = image;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeProtein() {
        return recipeProtein;
    }

    public String getRecipeCarb() {
        return recipeCarb;
    }

    public String getRecipeFat() {
        return recipeFat;
    }

    public String getRecipePrice() {
        return recipePrice;
    }

    public String getRecipeRating() {
        return recipeRating;
    }

    public int getImage() {
        return image;
    }
}
