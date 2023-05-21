package bednarhalaj.model.requests.job.state;

public class AcceptedJobRequestState extends JobRequestState {

    private static AcceptedJobRequestState instance = null;

    private AcceptedJobRequestState() {
        descriptor = 5;
    }

    public static synchronized AcceptedJobRequestState getInstance() {
        if (instance == null)
            instance = new AcceptedJobRequestState();

        return instance;
    }

    @Override
    public JobRequestState next() {
        return getInstance();
    }

    @Override
    public JobRequestState decline() {
        throw new UnsupportedOperationException("Job request was already accepted");
    }
}
