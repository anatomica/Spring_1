package Homework1.market2;

public class Product {
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Product() {
    }

    public Product(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = '%s']", id, title);
    }
}
