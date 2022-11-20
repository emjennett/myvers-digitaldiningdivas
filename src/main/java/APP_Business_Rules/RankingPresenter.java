package APP_Business_Rules;

import Entities.Account;

public interface RankingPresenter {
    Account[] returnUsersSorted(Account[] list);
}
