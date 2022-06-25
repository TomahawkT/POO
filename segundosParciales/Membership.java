package segundosParciales;

public enum Membership {
    BEGINNER {
        @Override
        public boolean canVisit(int currentVisits) {
            return currentVisits < 4;
        }
    },
    ADVANCED{
        @Override
        public boolean canVisit(int currentVisits){
            return currentVisits < 8;
        }
    },
    PRO{
        @Override
        public boolean canVisit(int currentVisits){
            return true;
        }
    };

    public abstract boolean canVisit(int currentVisits);
}
