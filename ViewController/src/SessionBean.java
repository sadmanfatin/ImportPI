import java.io.Serializable;

import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;

public class SessionBean implements Serializable {
    private RichShowDetailItem allPiTab;
    private RichShowDetailItem outstandingPiTab;
    private RichPanelTabbed mainPanelTab;

    public SessionBean() {
    }

    public void setAllPiTab(RichShowDetailItem allPiTab) {
        this.allPiTab = allPiTab;
    }

    public RichShowDetailItem getAllPiTab() {
        return allPiTab;
    }

    public void setOutstandingPiTab(RichShowDetailItem outstandingPiTab) {
        this.outstandingPiTab = outstandingPiTab;
    }

    public RichShowDetailItem getOutstandingPiTab() {
        return outstandingPiTab;
    }

    public void setMainPanelTab(RichPanelTabbed mainPanelTab) {
        this.mainPanelTab = mainPanelTab;
    }

    public RichPanelTabbed getMainPanelTab() {
        return mainPanelTab;
    }
}
