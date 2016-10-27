package press.turngeek.mycampaign.services;

import press.turngeek.mycampaign.model.Campaign;
import java.util.List;

public interface CampaignService {
    List<Campaign> getAllCampaigns();

    void addCampaign(Campaign campaign);

    void deleteCampaign(Campaign campaign);

    void updateCampaign(Campaign campaign);
}
