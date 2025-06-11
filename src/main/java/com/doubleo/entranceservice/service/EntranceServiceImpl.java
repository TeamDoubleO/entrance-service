package com.doubleo.entranceservice.service;

import com.doubleo.entranceservice.dto.request.EnterVerificationInfoRequest;
import com.doubleo.entranceservice.dto.response.EnterVerificationInfoResponse;
import com.doubleo.entranceservice.enums.DeviceLocationType;
import com.doubleo.entranceservice.global.exception.CommonException;
import com.doubleo.entranceservice.global.exception.errorcode.EntranceErrorCode;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EntranceServiceImpl implements EntranceService {

    @Override
    public EnterVerificationInfoResponse verifyEntrance(EnterVerificationInfoRequest request) {

        if (request.deviceLocationType() == DeviceLocationType.BUILDING
                && request.direction() == null) {
            throw new CommonException(EntranceErrorCode.MISSING_DIRECTION_WHEN_BUILDING);
        }

        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(request.startedAt()) || now.isAfter(request.expiredAt())) {
            return new EnterVerificationInfoResponse(false, "출입 유효 시간이 아닙니다.");
        }

        boolean isAllowed = verifyAreaCode(request.deviceAreaCode(), request.accessAreaCodes());
        if (!isAllowed) {
            return new EnterVerificationInfoResponse(false, "해당 구역에는 출입 권한이 없습니다.");
        }

        return new EnterVerificationInfoResponse(true, "출입이 허용되었습니다.");
    }

    private boolean verifyAreaCode(String deviceAreaCode, List<String> allowedAreas) {
        if (allowedAreas == null || allowedAreas.isEmpty()) return false;

        return allowedAreas.stream()
                .anyMatch(
                        allowed ->
                                allowed.equals(deviceAreaCode)
                                        || allowed.startsWith(deviceAreaCode + "_"));
    }
}
