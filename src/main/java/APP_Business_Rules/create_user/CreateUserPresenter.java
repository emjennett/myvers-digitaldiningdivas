package APP_Business_Rules.create_user;

public interface CreateUserPresenter {

    CreateUserResponseModel userCreated(CreateUserResponseModel model);

    CreateUserResponseModel userCreatedFail(String fail);
}
