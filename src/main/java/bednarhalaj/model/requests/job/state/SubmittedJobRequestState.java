package bednarhalaj.model.requests.job.state;

public class SubmittedJobRequestState extends JobRequestState {

    private static SubmittedJobRequestState instance = null;

    private SubmittedJobRequestState() {
        descriptor = 1;
    }

    public static synchronized SubmittedJobRequestState getInstance() {
        if (instance == null)
            instance = new SubmittedJobRequestState();

        return instance;
    }

    @Override
    public JobRequestState next() {
        return ReviewedJobRequestState.getInstance();
    }
}
