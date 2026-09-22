package roomescape.reservation.service;

import org.springframework.stereotype.Service;
import roomescape.time.dto.AvailableTime;
import roomescape.time.repository.TimeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationAvailabilityService {
    private final TimeRepository timeRepository;

    public ReservationAvailabilityService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public List<AvailableTime> findAvailableTimes(LocalDate date, Long themeId) {
        return timeRepository.findAvailableTimes(date, themeId);
    }
}
