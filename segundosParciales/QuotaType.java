package segundosParciales;

public enum QuotaType {
    UNLIMITED {
        @Override
        public boolean canRead(int currentDayReads) {
            return true;
        }
        @Override
        public boolean canWrite(int currentDayWrites) {
            return true;
        }
    },
    LIMITED {
        @Override
        public boolean canRead(int currentDayReads) {
            return currentDayReads < 2;
        }
        @Override
        public boolean canWrite(int currentDayWrites) {
            return currentDayWrites < 1;
        }
    };

    public abstract boolean canRead(int currentDayReads);

    public abstract boolean canWrite(int currentDayWrites);

}
