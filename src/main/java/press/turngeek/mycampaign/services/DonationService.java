package press.turngeek.mycampaign.services;

import press.turngeek.mycampaign.model.Donation;

import java.util.List;

public interface DonationService {
    List<Donation> getDonationList(Long campaignId);
    void addDonation(Long campaignId, Donation donation);
}

