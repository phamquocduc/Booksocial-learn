package com.devteria.profile.Services;

import com.devteria.profile.dto.request.UserProfileCreationRequest;
import com.devteria.profile.dto.respone.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@Service
public class UserProfileServices {
    UserProfileMapper userProfileMapper;
    UserProfileRepository userProfileRepository;

    public UserProfileResponse createUserProfile(UserProfileCreationRequest request){

        UserProfile user = userProfileMapper.toUserProfile(request);

        return userProfileMapper.toUserProfileResponse(userProfileRepository.save(user));
    }

    public UserProfileResponse getProfile(String id){
        UserProfile user = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Userprofile not found"));

        return userProfileMapper.toUserProfileResponse(user);
    }
}
