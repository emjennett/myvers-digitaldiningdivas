package APP_Business_Rules.LoadAccountInfo;

import APP_Business_Rules.login_user.AccountUserGateway;
import APP_Business_Rules.login_user.LoginUserGatewayModel;
import APP_Business_Rules.login_user.LoginUserPresenter;
import APP_Business_Rules.login_user.LoginUserResponseModel;

public class PullAcountInteractor implements  PullAccountInputBoundary {

    private LoginUserPresenter presenter;
    private LoginUserResponseModel responseModel;
    private AccountUserGateway gateway;

    public PullAcountInteractor(LoginUserResponseModel responseModel, LoginUserPresenter presenter, AccountUserGateway gateway){
        this.presenter = presenter;
        this.responseModel = responseModel;
        this.gateway = gateway;


    }

    /**
     * UpdateBio:
     * methold that accesses the UserAccountInfomodel in the csv file. and updates the bio of the UserAccountInfomodel
     * and saves it into the csv file
     *
     *
     */


    @Override
    public LoginUserResponseModel UpdateBio(UpdateRequestModel model){
        LoginUserGatewayModel gatewayModel = new LoginUserGatewayModel(model.getUsername(), "user", model.getDate());
        gatewayModel.setBio(model.getBio());
        gatewayModel.setPic(model.getPic());
        LoginUserResponseModel LoggedInUser = new LoginUserResponseModel(gateway.updateBio(gatewayModel));
        LoggedInUser.setBio(model.getBio());
        LoggedInUser.setPic(model.getPic());

        return presenter.updateBio(LoggedInUser);
    }



}
