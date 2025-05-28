package com.doubleo.entranceservice.service;

import com.doubleo.entranceservice.dto.request.EnterVerificationInfoRequest;

public interface EntranceService {
    boolean verifyEntrance(EnterVerificationInfoRequest request);
}
