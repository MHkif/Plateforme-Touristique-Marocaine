package mhkif.yc.regionsservice.services;

import mhkif.yc.regionsservice.dto.requests.RegionReq;
import mhkif.yc.regionsservice.dto.responses.RegionRes;
import mhkif.yc.regionsservice.entities.Region;

import java.util.UUID;

public interface RegionService extends Service<Region, UUID, RegionReq, RegionRes> {

    RegionRes update(Region user);
    boolean delete(Integer id);
}
