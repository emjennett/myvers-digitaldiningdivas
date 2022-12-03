package APP_Business_Rules.DishMenu;

import Entities.Dish;
import Interface_and_Adapters.DishMenuScreens.DishPresenter;

public class DishInteractor implements DishInputBoundary{

    final DishPresenter dishPresenter;
    final DishFactory dishFactory;
    final DishDataAccess gateway;

    public DishInteractor(DishDataAccess gateway, DishPresenter dishPresenter, DishFactory dishFactory
    ){

        this.dishPresenter = dishPresenter;
        this.dishFactory = dishFactory;
        this.gateway = gateway;
    }
    @Override
    public DishResponseModel create(DishRequestModel requestModel) {
        Dish dish = dishFactory.create(requestModel.getDishName(), requestModel.getDishCategory(),
                requestModel.getRestaurant(), requestModel.getDescription(), requestModel.getPrice());
        DishResponseModel dishResponseModel = new DishResponseModel(dish.getName());
        return dishPresenter.prepareSuccessView(dishResponseModel);
    }
}
