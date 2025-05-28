package com.doubleo.entranceservice.service;

import com.doubleo.entranceservice.dto.request.EnterVerificationInfoRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EntranceServiceImpl implements EntranceService {

    @Override
    public boolean verifyEntrance(EnterVerificationInfoRequest request) {
        String deviceAreaCode = request.deviceAreaCode();
        List<String> allowedAreas = request.allowedAreas();

        if (allowedAreas == null || allowedAreas.isEmpty()) return false;

        return allowedAreas.stream()
                .anyMatch(
                        allowed ->
                                allowed.equals(deviceAreaCode)
                                        || allowed.startsWith(deviceAreaCode + "_"));
    }
}
