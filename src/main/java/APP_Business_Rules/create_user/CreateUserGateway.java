package APP_Business_Rules.create_user;

public interface CreateUserGateway {

    boolean findAccountUser(String username);

    void save(CreateUserGatewayModel model);
}
