package APP_Business_Rules.RestaurantUseCase;

public class RestaurantGatewayModel {
        private final String resName;
        private final String resCategory;
        private final String resLocation;
        private final int stars;

        public RestaurantGatewayModel(String resName, String resCategory, String resLocation, int stars){
            this.resName = resName;
            this.resCategory = resCategory;
            this.resLocation = resLocation;
            this.stars = stars;
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


}
