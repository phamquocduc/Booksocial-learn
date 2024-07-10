package com.devteria.profile.controller.internalApi;

import com.devteria.profile.Services.UserProfileServices;
import com.devteria.profile.dto.request.UserProfileCreationRequest;
import com.devteria.profile.dto.respone.UserProfileResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileServices userProfileServices;

    @PostMapping("/internal/users")
    public UserProfileResponse createUserProfile(@RequestBody UserProfileCreationRequest request){

        return userProfileServices.createUserProfile(request);
    }
}
