package APP_Business_Rules.create_user;


import Entities.User;
import Entities.UserFactory;

public class CreateUserInteractor implements CreateUserInputBoundary {

    final CreateUserGateway gateway;

    final UserFactory factory;

    final CreateUserPresenter presenter;

    /**
     * The Use case interactor called when a user wants to create a new account.
     * @param gateway interface needed to save a new user.
     * @param factory interface needed to create a new user.
     * @param presenter interface needed to send creation results to the user.
     */
    public CreateUserInteractor(CreateUserGateway gateway, UserFactory factory, CreateUserPresenter presenter){

        this.gateway = gateway;
        this.factory = factory;
        this.presenter= presenter;
    }

    /**
     * The method that will test if the user can be created and stored if successful.
     * returns the response model for optional viewing via presenter to a screen.
     * @param model The information stored about the new users input.
     */
    @Override
    public CreateUserResponseModel create(CreateUserRequestModel model) {
        if (gateway.findAccountUser(model.getUsername())){
            return presenter.userCreatedFail("Username " + model.getUsername() + " is not available.");
        } else if (!model.getPassword().equals(model.getDup_password())) {
            return presenter.userCreatedFail("The passwords do not match.");
        } else if (!model.validPassword()) {
            return presenter.userCreatedFail("Your password must be at least 6 characters long.");
        } else if (model.getUsername().length() == 0 || model.getUsername().contains(" ")){
            return presenter.userCreatedFail("A Username must not contain the space character.");
        }
        User newUser = factory.createUser(model.getUsername(), model.getPassword(), model.getType());
        CreateUserGatewayModel userDataModel = new CreateUserGatewayModel(newUser.getUserName(), newUser.getPassword(), newUser.getType());
        gateway.save(userDataModel);
        CreateUserResponseModel createdUserModel = new CreateUserResponseModel(newUser.getUserName());
        return presenter.userCreated(createdUserModel);
    }
}
