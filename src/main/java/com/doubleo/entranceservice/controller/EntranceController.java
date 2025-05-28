package com.doubleo.entranceservice.controller;

import com.doubleo.entranceservice.dto.request.EnterVerificationInfoRequest;
import com.doubleo.entranceservice.service.EntranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrances")
@RequiredArgsConstructor
public class EntranceController {
    private final EntranceService entranceService;

    @PostMapping("/verify")
    public boolean verify(@RequestBody EnterVerificationInfoRequest request) {
        return entranceService.verifyEntrance(request);
    }
}
