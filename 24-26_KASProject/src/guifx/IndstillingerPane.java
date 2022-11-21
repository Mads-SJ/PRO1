package guifx;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

public class IndstillingerPane extends GridPane {
    TabPane tabPane;
    Tab tabHoteller, tabOversigter;
    CheckBox checkBoxAdmin;

    public IndstillingerPane(TabPane tabPane) {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.tabPane = tabPane;

        ObservableList<Tab> tabs = tabPane.getTabs();
        this.tabHoteller = tabs.get(1);
        this.tabOversigter = tabs.get(2);

        checkBoxAdmin = new CheckBox("Admin");
        this.add(checkBoxAdmin,0,0);
        checkBoxAdmin.selectedProperty().addListener((ov, old, n) -> adminChange());
        removeAdminTabs();
    }

    private void adminChange() {
        boolean admin = checkBoxAdmin.isSelected();

        if (admin) {
            addAdminTabs();
        } else {
            removeAdminTabs();
        }
    }

    private void addAdminTabs() {
        tabPane.getTabs().add(1, tabHoteller);
        tabPane.getTabs().add(2, tabOversigter);
    }

    private void removeAdminTabs() {
        tabPane.getTabs().remove(tabHoteller);
        tabPane.getTabs().remove(tabOversigter);
    }
}
