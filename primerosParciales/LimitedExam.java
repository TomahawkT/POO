package primerosParciales;

import java.util.Arrays;

public class LimitedExam extends UniqueExam{

    private int cupo;
    private String[] pending = new String[INITIAL_DIM];
    private static final int INITIAL_DIM = 5;
    private int dimPending;
    public LimitedExam(String name, int cupo) {
        super(name);
        this.cupo = cupo;
    }

    @Override
    public void enroll(String student){
        if (getEnrolledCount() == cupo){
            enrollPending(student);
        }
        super.enroll(student);
    }
    private void enrollPending(String student){
        if (dimPending == pending.length){
            resize();
        }
        pending[dimPending++]=student;

    }
    private void resize(){
        pending = Arrays.copyOf(pending, pending.length + INITIAL_DIM);
    }

    @Override
    public void unenroll(String student){
        int auxDim = getEnrolledCount();
        super.unenroll(student);
        if (auxDim > getEnrolledCount() && hasPending()){
            String pendingToEnroll = pending[0];
            enroll(pendingToEnroll);
            removeFromPending(pendingToEnroll);
        }
    }

    private boolean removeFromPending(String pendingToEnroll) {
        for (int i = 0; i < dimPending; i++) {
            if (pending[i].equals(pendingToEnroll)) {
                System.arraycopy(pending, i + 1, pending, i, dimPending - 1 - i);
                dimPending--;
                return true;
            }
        }
        return false;
    }

    private boolean hasPending(){
        return dimPending > 0;
    }

}
