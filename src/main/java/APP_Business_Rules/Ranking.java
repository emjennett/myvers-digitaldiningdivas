package APP_Business_Rules;

import Entities.Account;
import java.util.Arrays;

public class Ranking implements RankingPresenter {

    /**
     *Get all users
     */
    public static Account[] getAllUsers(){
        return null;
    }

    /**
     *Get the friends of the User
     */
    public static Account[] getFriends(){
        return null;
    }

    /**
     *Ranks the scores of the friends within the users friend list, including the user themselves.
     */
    public static Account[] rankCommunity(){
        Account[] rankedFriends = getFriends();
        Arrays.sort(rankedFriends);
        return rankedFriends;
    }


    /**
     *Ranks the scores of all users.
     */
    public static Account[] rankGlobal(){
        Account[] rankedUsers = getAllUsers();
        Arrays.sort(rankedUsers);
        return rankedUsers;
    }

    public Account[] returnUsersSorted(Account[] list) {
        return list;
    }
}
