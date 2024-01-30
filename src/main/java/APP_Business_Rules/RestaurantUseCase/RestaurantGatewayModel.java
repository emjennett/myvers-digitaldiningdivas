package APP_Business_Rules.RestaurantUseCase;

import java.io.Serializable;
import java.util.List;

public class RestaurantGatewayModel implements Serializable {
        private final String resName;
        private final String resCategory;
        private final String resLocation;
        private final int stars;
        private List<String> likeList;
        private String newLike;
        private static final long serialVersionUID = 62567323539602193L;

    public RestaurantGatewayModel(String resName, String resCategory, String resLocation, int stars, List<String> likeList, String newLike){
            this.resName = resName;
            this.resCategory = resCategory;
            this.resLocation = resLocation;
            this.stars = stars;
            this.likeList = likeList;
            this.newLike = newLike;
        }

        public String getResCategory(){
            return resCategory;
        }

        public String getResName(){
            return resName;
        }

        public String getResLocation() {
            return resLocation;
        }

        public int getStars() {
            return stars;
        }




    public List<String> getLikeList() { return this.likeList;
    }
    public void setLikeList(List<String> list) {
        list.add(getNewLike());
        this.likeList = list;
    }

    public String getNewLike() {
            return this.newLike;
    }
    public void setNewLike(String newnewLike) { this.newLike = newnewLike;
    }
}
