package bednarhalaj.model.requests.job;

import bednarhalaj.model.requests.job.state.*;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JobRequestStateConverter implements AttributeConverter<JobRequestState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(JobRequestState jobRequestState) {
        return jobRequestState.getDescriptor();
    }

    @Override
    public JobRequestState convertToEntityAttribute(Integer integer) {
        switch (integer) {
            case 0 -> {
                return DeclinedJobRequestState.getInstance();
            }
            case 1 -> {
                return SubmittedJobRequestState.getInstance();
            }
            case 2 -> {
                return ReviewedJobRequestState.getInstance();
            }
            case 3 -> {
                return InvitedToInterviewJobRequestState.getInstance();
            }
            case 4 -> {
                return InterviewedJobRequestState.getInstance();
            }
            case 5 -> {
                return AcceptedJobRequestState.getInstance();
            }
        }
        throw new IllegalArgumentException("Such JobRequestState does not exist!");
    }
}
