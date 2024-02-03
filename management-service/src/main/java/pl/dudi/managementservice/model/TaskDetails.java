package pl.dudi.managementservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.OffsetDateTime;

@With
@Value
@Builder
public class TaskDetails {

    OffsetDateTime toStart;
    OffsetDateTime deadline;
    OffsetDateTime actuallyStarted;
    Long piecesAlreadyMade;
    Long piecesToMake;
    Manager manager;
}
