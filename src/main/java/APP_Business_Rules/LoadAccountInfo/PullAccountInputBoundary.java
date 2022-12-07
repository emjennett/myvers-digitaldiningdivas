package APP_Business_Rules.LoadAccountInfo;

public interface PullAccountInputBoundary {

    String PullAccount(String username);

    void UpdateBio(String username, String newbio);
}

