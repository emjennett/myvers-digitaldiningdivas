package Frameworks_and_Drivers;

import APP_Business_Rules.UseCaseInteractor;
import Interface_and_Adapters.RankingPresenter;

public class HTMLView {

    public void ranking(){
        UseCaseInteractor.rankingInteractor();
        RankingPresenter.present();

    }


}
