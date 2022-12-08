package APP_Business_Rules.MenuUseCase;

import java.util.List;

public class MenuResponseModel {
    private List<List<String>> dishList;

    public MenuResponseModel(List<List<String>> dishList) {
        this.dishList = dishList;
    }

    public List<List<String>> getDishList() {
        return dishList;
    }
}
