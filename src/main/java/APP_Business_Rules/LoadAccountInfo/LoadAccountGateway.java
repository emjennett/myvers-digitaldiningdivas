package APP_Business_Rules.LoadAccountInfo;

import APP_Business_Rules.LoadAccountInfo.UserAccountInfoModel;

;

public interface LoadAccountGateway {

    boolean findAccountUser(String username);

    void save(UserAccountInfoModel model);

    UserAccountInfoModel load(String username);

    void change(String Username, String newbio);

}

