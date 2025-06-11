package com.doubleo.entranceservice.service;

import com.doubleo.entranceservice.dto.request.EnterVerificationInfoRequest;
import com.doubleo.entranceservice.dto.response.EnterVerificationInfoResponse;

public interface EntranceService {
    EnterVerificationInfoResponse verifyEntrance(EnterVerificationInfoRequest request);
}
