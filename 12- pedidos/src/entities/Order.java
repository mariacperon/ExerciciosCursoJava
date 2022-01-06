package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private Client client;
    List<OrderItem> itens = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");
        sb.append("Order moment: "+ sdf.format(moment) +".\n");
        sb.append("Order status: "+ status +".\n");
        sb.append("Client: "+ client.getName());
        sb.append(" ("+ sdf2.format(client.getBirthDate()) +") - ");
        sb.append(client.getEmail() +"\n");
        sb.append("Order items:\n");
        for (OrderItem item : itens){
            sb.append(item.getProduto().getNome());
            sb.append(", R$"+ item.getPrice());
            sb.append(", Qtd: "+ item.getQuantity());
            sb.append(", Subtotal: R$"+ item.subTotal() +"\n");
        }
        sb.append("Total: R$"+ total());

        return sb.toString();
    }

    public Order(){
    }

    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void addItens(OrderItem item){
        itens.add(item);
    }

    public void removeItens(OrderItem item){
        itens.remove(item);
    }

    public Double total(){
        double total = 0;

        for (OrderItem i : itens) {
            total += i.subTotal();
        }

        return total;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return itens;
    }
}
