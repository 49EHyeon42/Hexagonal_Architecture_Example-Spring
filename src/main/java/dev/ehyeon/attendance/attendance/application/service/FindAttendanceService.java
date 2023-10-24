package dev.ehyeon.attendance.attendance.application.service;

import dev.ehyeon.attendance.attendance.application.port.in.FindAttendanceByUserIdAndDateBetweenRequest;
import dev.ehyeon.attendance.attendance.application.port.in.FindAttendanceUseCase;
import dev.ehyeon.attendance.attendance.application.port.out.FindAttendancePort;
import dev.ehyeon.attendance.attendance.domain.Attendance;
import dev.ehyeon.attendance.user.application.port.out.FindUserPort;
import dev.ehyeon.attendance.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAttendanceService implements FindAttendanceUseCase {

    private final FindUserPort findUserPort;
    private final FindAttendancePort findAttendancePort;

    @Override
    public List<LocalDate> findAttendanceByUserIdAndDateBetween(FindAttendanceByUserIdAndDateBetweenRequest findAttendanceByUserIdAndDateBetweenRequest) {
        User user = findUserPort.findUserById(findAttendanceByUserIdAndDateBetweenRequest.getUserId());

        List<Attendance> attendances = findAttendancePort
                .findAllAttendanceByUserAndDateBetween(user,
                        findAttendanceByUserIdAndDateBetweenRequest.getFrom(),
                        findAttendanceByUserIdAndDateBetweenRequest.getTo());

        return attendances.stream()
                .map(Attendance::getDate)
                .collect(Collectors.toList());
    }
}
