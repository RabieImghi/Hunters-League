package org.rabie.hunters_league.web.vm.mapper;

import org.mapstruct.Mapper;
import org.rabie.hunters_league.domain.User;

import org.rabie.hunters_league.web.vm.request.LoginVM;
import org.rabie.hunters_league.web.vm.request.UserUpdateVm;
import org.rabie.hunters_league.web.vm.request.UserVm;
import org.rabie.hunters_league.web.vm.response.ListUserVm;
import org.rabie.hunters_league.web.vm.response.UserResponseVm;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserVm userVm);
    User toUserFromLoginVm(LoginVM loginVM);
    UserVm toUserVm(User user);
    UserResponseVm toUserResponseVm(User user);
    ListUserVm toListUserVm(User user);
    User toUserFromUpdateVm(UserUpdateVm userUpdateVm);

}
