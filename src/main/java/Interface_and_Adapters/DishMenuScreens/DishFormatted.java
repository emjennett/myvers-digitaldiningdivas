package Interface_and_Adapters.DishMenuScreens;

import APP_Business_Rules.DishMenu.DishResponseModel;

public class DishFormatted implements DishPresenter{

    @Override
    public DishResponseModel prepareSuccessView(DishResponseModel response) {
        return response;
    }
}
