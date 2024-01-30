package APP_Business_Rules.RestaurantUseCase;

import java.util.List;

public class RestaurantResponseModel {
    RestaurantGatewayModel model;
    private List<String> likeList;

    private String newLike;

    public RestaurantResponseModel(RestaurantGatewayModel model) {
        this.model = model;
        this.likeList = likeList;
        this.newLike = newLike;
    }

    public String getRestaurantName() {
        return this.model.getResName();
    }

    public String getCategory() {
        return this.model.getResCategory();
    }

    public String getLocation() {
        return this.model.getResLocation();
    }

    public int getStars() {
        return this.model.getStars();
    }


    public String getNewLike(){
        return this.model.getNewLike();
    }
    public void setNewLike(String newnewLike){
        this.newLike = newnewLike;
    }

    public List<String> getLikeList() {return this.model.getLikeList();
    }
    public void setLikeList(List<String> list) {
        if(getNewLike()!=null) {
            list.add(getNewLike());
            this.likeList = list;
        }
    }

    public void removeFav(List<String> likeList) {
        likeList.remove(getNewLike());
        this.likeList = likeList;

    }
}
