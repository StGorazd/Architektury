package bednarhalaj.model.requests.job.state;

public class DeclinedJobRequestState extends JobRequestState {
        private static DeclinedJobRequestState instance = null;

    private DeclinedJobRequestState() {
        descriptor = 0;
    }

    public static synchronized DeclinedJobRequestState getInstance() {
        if (instance == null)
            instance = new DeclinedJobRequestState();

        return instance;
    }
    @Override
    public JobRequestState next() {
        return getInstance();
    }
}
