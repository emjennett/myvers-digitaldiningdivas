package APP_Business_Rules;

import Entities.AccountUser;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchUserUseCase {
    private OutputBoundary searchPresenter;
    private DataAccessStorageInterface dataAccess;

    public SearchUserUseCase(OutputBoundary searchPresenter, DataAccessStorageInterface dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public ArrayList<HashMap<String, Object>> Search(String search, String type, HashMap<String, Object> filter){
        ArrayList<AccountUser> data = (ArrayList<AccountUser>) this.dataAccess.accessData(type + ".txt"); //Might need to change the return type of accessData() to Arraylist<Object>
        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        for (AccountUser a: data){
        if(a.getUserName().contains(search)){

        }
        }

        return null;
    }
}
