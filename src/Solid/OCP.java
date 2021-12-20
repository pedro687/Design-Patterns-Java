//OCP + SPECIFICATION -> specification not is a design pattern of Gang of Four, is a design pattern of software engineering
package Solid;

import java.util.List;
import java.util.stream.Stream;

enum Color {
    GREEN, BLUE, RED
}

enum Size {
    SMALL, MEDIUM, LARGE
}

interface Specification<T> {
   boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filterProducts(List<T> items, Specification<T> specification);
}

public class OCP {
    public static void main(String[] args) {
        ProductFilter productFilter = new ProductFilter();
        Product apple = new Product("Iphone", Color.GREEN, Size.SMALL);
        Product shirt = new Product("Shirt", Color.GREEN, Size.MEDIUM);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        var products = List.of(apple, shirt, house);

        Specification<Product> specification = new AndSpecification(new SizeSpecification(Size.SMALL), new ColorSpecification(Color.GREEN));
        BetterFilter betterFilter = new BetterFilter();
        betterFilter.filterProducts(products, specification)
                .forEach(System.out::println);
    }
}

class AndSpecification implements Specification<Product> {

    private Specification<Product> spec1, spec2;

    public AndSpecification(Specification<Product> spec1, Specification<Product> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return spec1.isSatisfied(item) && spec2.isSatisfied(item);
    }
}

class BetterFilter implements Filter<Product> {
    @Override
    public Stream<Product> filterProducts(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(p -> specification.isSatisfied(p));
    }
}

class ColorSpecification implements Specification<Product> {

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return  item.getColor() == color;
    }
}

class SizeSpecification implements Specification<Product> {

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return  item.getSize() == size;
    }
}

// This approach is not great cuz you need to create a method for each combination
class ProductFilter {
    public Stream<Product> fiterProductsByColor(List<Product> products, Color color) {
        return products.stream().filter(product -> product.getColor() == color);
    }

    public Stream<Product> filterProductsBySize(List<Product> products, Size size) {
        return products.stream().filter(product -> product.getSize() == size);
    }

    public Stream<Product> filterProductsBySizeAndColor(List<Product> products, Color color, Size size) {
        return products.stream().filter(product -> product.getColor() == color && product.getSize() == size);
    }

}

class Product {
    private String name;
    private Color color;
    private Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", size=" + size +
                '}';
    }
}