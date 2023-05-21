package bednarhalaj.model.requests.job.state;

public class InvitedToInterviewJobRequestState extends JobRequestState{

    private static InvitedToInterviewJobRequestState instance = null;

    private InvitedToInterviewJobRequestState() {
        descriptor = 3;
    }

    public static synchronized InvitedToInterviewJobRequestState getInstance() {
        if (instance == null)
            instance = new InvitedToInterviewJobRequestState();

        return instance;
    }
    @Override
    public JobRequestState next() {
        return InterviewedJobRequestState.getInstance();
    }
}
