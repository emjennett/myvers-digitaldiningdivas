package APP_Business_Rules.RestaurantUseCase;

public class RestaurantGatewayModel {
        private final String resName;
        private final String resCategory;
        private final String resLocation;
        private final int stars;
        private int likes;

        public RestaurantGatewayModel(String resName, String resCategory, String resLocation, int stars, int likes){
            this.resName = resName;
            this.resCategory = resCategory;
            this.resLocation = resLocation;
            this.stars = stars;
            this.likes = likes;
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


        public int getLikes() {
            return likes;
        }
}
