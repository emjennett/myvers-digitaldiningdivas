package Interface_and_Adapters;

import APP_Business_Rules.Ranking;
import APP_Business_Rules.RankingPresenter;

public class RankingController implements RankingInputBoundary{

    final RankingDSGateway rankingDSGateway;
    final RankingPresenter rankingPresenter;

    public RankingController(RankingDSGateway rankingDSGateway, RankingPresenter rankingPresenter) {
        this.rankingDSGateway = rankingDSGateway;
        this.rankingPresenter = rankingPresenter;
    }

    public void globalRanking(){
        rankingPresenter.returnUsersSorted(Ranking.rankGlobal());
    }

    public void communityRanking(){
        rankingPresenter.returnUsersSorted(Ranking.rankCommunity());
    }
}
