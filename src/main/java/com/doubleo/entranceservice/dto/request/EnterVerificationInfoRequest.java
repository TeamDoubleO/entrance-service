package com.doubleo.entranceservice.dto.request;

import com.doubleo.entranceservice.enums.DeviceLocationType;
import com.doubleo.entranceservice.enums.Direction;
import java.time.LocalDateTime;
import java.util.List;

public record EnterVerificationInfoRequest(
        Long passId,
        Long memberId,
        String memberName,
        Long hospitalId,
        List<String> accessAreaCodes,
        String visitCategory,
        LocalDateTime startedAt,
        LocalDateTime expiredAt,
        DeviceLocationType deviceLocationType,
        Direction direction,
        String deviceAreaCode) {}
