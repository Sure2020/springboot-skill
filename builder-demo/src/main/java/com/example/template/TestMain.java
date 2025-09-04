package com.example.template;

import com.example.template.entity.NutritionFacts;

/**
 * @Description: 来自《Effective Java》第2章
 * @Author: wangfengshuo
 * @Date: 2025/9/4
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        NutritionFacts test = new NutritionFacts.Builder(240, 8).calories(1234).build();
        System.out.println(test.getCalories());
    }
}
