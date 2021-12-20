package Creational.Builder;

public class BuilderExample {
    public static void main(String[] args) {
        NutrictionFacts nutrictionFacts = new NutrictionFacts.Builder(1, 2)
                .setCarbohydrate(10)
                .setCalories(1)
                .setSodium(0)
                .build();

        System.out.println(nutrictionFacts.toString());
    }
}

class NutrictionFacts {
    private int servings;
    private int servingSize;

    //optionals
    private int calories;
    private int fat;
    private int carbohydrate;
    private int sodium;

    public NutrictionFacts(Builder builder) {
        servings = builder.servings;
        servingSize = builder.servingSize;
        calories = builder.calories;
        fat = builder.fat;
        carbohydrate = builder.carbohydrate;
        sodium = builder.sodium;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    @Override
    public String toString() {
        return "NutrictionFacts{" +
                "servings=" + servings +
                ", servingSize=" + servingSize +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                ", sodium=" + sodium +
                '}';
    }

    static class Builder {
        private int servings;
        private int servingSize;

        //optionals
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servings, int servingSize) {
            this.servings = servings;
            this.servingSize = servingSize;
        }

        public Builder setServings(int servings) {
            this.servings = servings;
            return this;
        }

        public Builder setServingSize(int servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public Builder setSodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public NutrictionFacts build() {
            return new NutrictionFacts(this);
        }
    }
}
