package bednarhalaj.model.requests.job.state;

public class InterviewedJobRequestState extends JobRequestState {

    private static InterviewedJobRequestState instance = null;

    private InterviewedJobRequestState() {
        descriptor = 4;
    }

    public static synchronized InterviewedJobRequestState getInstance() {
        if (instance == null)
            instance = new InterviewedJobRequestState();

        return instance;
    }

    @Override
    public JobRequestState next() {
        return AcceptedJobRequestState.getInstance();
    }
}
