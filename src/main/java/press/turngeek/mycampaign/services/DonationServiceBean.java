package press.turngeek.mycampaign.services;

import press.turngeek.mycampaign.model.Campaign;
import press.turngeek.mycampaign.model.Donation;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class DonationServiceBean implements DonationService {
  @Inject
  private EntityManager entityManager;

  @RolesAllowed("Organizer")
  @Override
  public List<Donation> getDonationList(Long campaignId) {
    Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
    List<Donation> donations = managedCampaign.getDonations();
    donations.size();
    return donations;
  }

  @PermitAll
  @Override
  public void addDonation(Long campaignId, Donation donation) {
    Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
    donation.setCampaign(managedCampaign);
    entityManager.persist(donation);
  }
}

