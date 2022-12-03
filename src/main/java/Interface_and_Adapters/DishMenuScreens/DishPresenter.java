package Interface_and_Adapters.DishMenuScreens;

import APP_Business_Rules.DishMenu.DishResponseModel;

public interface DishPresenter {
    public DishResponseModel prepareSuccessView(DishResponseModel responseModel);
}
