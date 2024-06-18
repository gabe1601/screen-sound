package com.example.alura.screensounds.model;

public enum Category {

    SOLO ("solo"),
    DUPLA ("dupla"),
    BANDA ("banda");

    private String artistCategory;

    Category(String artistCategory){
        this.artistCategory = artistCategory;
    }

    public static Category stringConvert (String text){
        for(Category category:Category.values()){
            if(category.artistCategory.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
