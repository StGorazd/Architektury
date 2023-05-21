package bednarhalaj.model.requests.job.state;

public class ReviewedJobRequestState extends JobRequestState {

    private static ReviewedJobRequestState instance = null;

    private ReviewedJobRequestState() {
        descriptor = 2;
    }

    public static synchronized ReviewedJobRequestState getInstance() {
        if (instance == null)
            instance = new ReviewedJobRequestState();

        return instance;
    }

    @Override
    public JobRequestState next() {
        return InvitedToInterviewJobRequestState.getInstance();
    }
}
