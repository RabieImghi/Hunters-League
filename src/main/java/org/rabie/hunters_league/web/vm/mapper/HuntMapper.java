package org.rabie.hunters_league.web.vm.mapper;

import org.mapstruct.Mapper;
import org.rabie.hunters_league.domain.Hunt;
import org.rabie.hunters_league.web.vm.request.HuntRequestVm;
import org.rabie.hunters_league.web.vm.response.HuntResponseVm;

@Mapper(componentModel = "spring")
public interface HuntMapper {
    Hunt toHunt(HuntRequestVm huntRequestVm);
    HuntResponseVm toHuntResponseVm(Hunt hunt);

}
