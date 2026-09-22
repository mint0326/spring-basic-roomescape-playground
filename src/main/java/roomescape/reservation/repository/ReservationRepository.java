package roomescape.reservation.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import roomescape.reservation.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByDateAndThemeIdAndTimeId(LocalDate date, Long themeId, Long timeId);

    @Override
    @EntityGraph(attributePaths = {"theme", "time"})
    List<Reservation> findAll();

    @EntityGraph(attributePaths = {"theme", "time"})
    List<Reservation> findByMember_IdOrderByIdAsc(Long memberId);

    boolean existsByMember_IdAndDateAndTheme_IdAndTime_Id(
            Long memberId,
            LocalDate date,
            Long themeId,
            Long timeId
    );
}
