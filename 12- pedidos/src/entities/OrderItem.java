package entities;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private Product produto;

    public OrderItem(){
    }

    public OrderItem(Integer quantity, double price, Product product){
        this.quantity = quantity;
        this.price = price;
        this.produto = product;
    }

    public Double subTotal(){
        return quantity * price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }
}
