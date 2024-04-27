package com.example.foodpark;

public class menuDetails {
    String recipeName,recipeProtein,recipeCarb,recipeFat,recipePrice,recipeIds;
    int image;

    public menuDetails(String recipeName, String recipeProtein, String recipeCarb,
                       String recipeFat, String recipePrice,String recipeIds
                      ) {
        this.recipeName = recipeName;
        this.recipeProtein = recipeProtein;
        this.recipeCarb = recipeCarb;
        this.recipeFat = recipeFat;
        this.recipePrice = recipePrice;
        this.recipeIds = recipeIds;
       // this.recipeRating = recipeRating;
        //this.image = image;
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

    public String getRecipeIds() {return recipeIds;}

    //    public String getRecipeRating() {
//        return recipeRating;
//    }

//    public int getImage() {
//        return image;
//    }
}
