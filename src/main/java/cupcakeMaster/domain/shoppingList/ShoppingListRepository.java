package cupcakeMaster.domain.shoppingList;

public interface ShoppingListRepository {
    Iterable<ShoppingList> findAll();
    ShoppingList find(int id) throws NoShoppingListExist;
    ShoppingList create(String name);


}
