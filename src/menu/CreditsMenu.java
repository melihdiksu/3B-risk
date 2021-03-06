package menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URISyntaxException;

public class CreditsMenu implements MenuState{

    private Label title;
    private ImageView logo;
    private Label members;
    private Button back;
    private Scene scene;
    private final int width, height;


    public CreditsMenu(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {

    }

    @Override
    public Scene createScene(GameMenuManager mgr) {
        init(mgr.getMaximized());
        back.setOnAction(mgr);
        return scene;
    }

    public void init(boolean maximized){
        String backStyle = maximized ? "menu_button_back_max" : "menu_button_back_min";
        String titleStyle = maximized ? "title_max" : "title_min";
        String labelStyle = maximized ? "label_max" : "label_min";

        title = new Label("Team Members");
        title.getStyleClass().add(titleStyle);
        members = new Label("Aleyna Sütbaş\n" +
                            "Berk Takıt\n" +
                            "Ramazan Melih Diksu\n" +
                            "Baykam Say\n" +
                            "Yiğit Erkal");
        members.getStyleClass().add(labelStyle);
        Image img = null;
        try {
            img = new Image(Launcher.class.getResource("/img/bilkent_logo.png").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        logo = new ImageView(img);
        back = new Button("Back");
        back.getStyleClass().add(backStyle);

        HBox top = new HBox(back);
        top.setAlignment(Pos.CENTER_LEFT);
        top.setPadding(new Insets(5));

        VBox root = new VBox();
        root.setId("menu_bg");
        VBox bottom = new VBox(title, members, logo);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(20);
        root.getChildren().addAll(top,bottom);
        root.setSpacing(20);

        scene = new Scene(root,width,height);
    }
}
