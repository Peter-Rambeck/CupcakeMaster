package cupcakeMaster.domain.order;

import cupcakeMaster.domain.shoppingList.ShoppingList;

public interface OrderListRepository {

    Iterable<OrderList> findAll();
    ShoppingList find(int id) throws NoOrderListExist;

}
