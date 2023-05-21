package bednarhalaj.model.requests.job.state;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public abstract class JobRequestState implements Serializable {
    @Column(name = "state_id")
    protected int descriptor;

    public JobRequestState decline() {
        return DeclinedJobRequestState.getInstance();
    }

    public abstract JobRequestState next();

    public int getDescriptor() {
        return descriptor;
    }

}
