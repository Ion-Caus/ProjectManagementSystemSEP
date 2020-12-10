package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.PMSModel;

public class ViewHandler {
    private Scene currentScene;
    private Stage primaryStage;
    private PMSModel model;

    private ProjectListViewController projectListViewController;
    private ProjectViewController projectViewController;
    private RequirementListViewController requirementListViewController;
    private RequirementViewController requirementViewController;
    private TaskListViewController taskListViewController;
    private TaskViewController taskViewController;
    private CreateTeamViewController createTeamViewController;

    public ViewHandler(PMSModel model) {
        this.model = model;
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView("ProjectListView");
    }

    public void openView(String id) {
        Region root = null;
        switch (id) {
            case "ProjectListView":
                root = loadGUI("ProjectListView.fxml",projectListViewController);
                break;
            case "ProjectView":
                root = loadGUI("ProjectView.fxml",projectViewController);
                break;
            case  "RequirementListView":
                root = loadGUI("RequirementListView.fxml",requirementListViewController);
                break;
            case "RequirementView":
                root = loadGUI("RequirementView.fxml",requirementViewController);
                break;
            case  "TaskListView":
                root = loadGUI("TaskListView.fxml",taskViewController);
                break;
            case "TaskView":
                root = loadGUI("TaskView.fxml",taskViewController);
                break;
            case "CreateTeamView":
                root = loadGUI("CreateTeamView.fxml",createTeamViewController);
                break;
        }
        currentScene.setRoot(root);

        String title = "";
        assert root != null;
        if (root.getUserData() != null) {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.setOnCloseRequest(windowEvent -> model.saveIntoFile());
        primaryStage.show();
    }

    public void closeView() {
        primaryStage.close();
    }

    public Region loadGUI(String fxmlFile, Controller controller){
        if (controller == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                controller = loader.getController();
                controller.init(this, model, root);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            controller.reset();
        }
        return controller.getRoot();
    }

}
