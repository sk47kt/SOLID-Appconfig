package practice.sk47kt.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
