package com.metishonora.todaychicken.domain;

import java.util.List;

public class Menu {
    private Integer id;
    private String name;
    private String category;
    private Integer price;
    private List<Review> reviews;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Review getReviews(Integer index) {
        return reviews.get(index);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}
