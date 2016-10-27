package press.turngeek.mycampaign.controller;

import press.turngeek.mycampaign.data.CampaignProducer;
import press.turngeek.mycampaign.model.Campaign;
import press.turngeek.mycampaign.util.Events.Added;
import press.turngeek.mycampaign.util.Events.Updated;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class EditCampaignController implements Serializable {
    private static final long serialVersionUID = 2815796004558360299L;

    @Inject
    private CampaignProducer  campaignProducer;
    @Inject
    @Added
    private Event<Campaign>   campaignAddEvent;
    @Inject
    @Updated
    private Event<Campaign>   campaignUpdateEvent;


    public String doSave() {
        if (campaignProducer.isAddMode()) {
            campaignAddEvent.fire(campaignProducer.getSelectedCampaign());
        } else {
            campaignUpdateEvent.fire(campaignProducer.getSelectedCampaign());
        }
        return Pages.LIST_CAMPAIGNS;
    }

    public String doCancel() {
        return Pages.LIST_CAMPAIGNS;
    }
}
