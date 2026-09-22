package roomescape.reservation.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import roomescape.time.dto.AvailableTime;
import roomescape.time.repository.TimeRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationAvailabilityServiceTest {

    @Mock
    private TimeRepository timeRepository;

    @InjectMocks
    private ReservationAvailabilityService reservationAvailabilityService;

    @Test
    void marks_reserved_times_as_booked() {
        LocalDate date = LocalDate.of(2024, 3, 2);
        Long themeId = 1L;
        List<AvailableTime> availableTimes = List.of(
                new AvailableTime(1L, LocalTime.of(10, 0), true),
                new AvailableTime(2L, LocalTime.of(12, 0), false)
        );

        when(timeRepository.findAvailableTimes(date, themeId)).thenReturn(availableTimes);

        List<AvailableTime> result = reservationAvailabilityService.findAvailableTimes(date, themeId);

        assertThat(result).containsExactlyElementsOf(availableTimes);
    }
}
