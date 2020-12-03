package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.PMSModel;
import model.Project;

import java.util.Optional;

public class ProjectListViewController {
    // projects tab
    @FXML private TableView<ProjectViewModel> projectListTable;
    @FXML private TableColumn<ProjectViewModel, String> idProjectColumn;
    @FXML private TableColumn<ProjectViewModel, String> nameProjectColumn;
    @FXML private TableColumn<ProjectViewModel, String> statusProjectColumn;
    @FXML private TableColumn<ProjectViewModel, String> deadlineProjectColumn;
    @FXML private Label errorLabel;

    //employees tab
    //@FXML private TableView<

    private ViewHandler viewHandler;
    private PMSModel model;
    private Region root;
    private ProjectListViewModel viewModel;

    public ProjectListViewController() {
        // called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, PMSModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

        this.viewModel = new ProjectListViewModel(model);

        idProjectColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        nameProjectColumn.setCellValueFactory(cellDate -> cellDate.getValue().getNameProperty());
        statusProjectColumn.setCellValueFactory(cellDate -> cellDate.getValue().getStatusProperty());
        deadlineProjectColumn.setCellValueFactory(cellDate -> cellDate.getValue().getDeadlineProperty());

        projectListTable.setItems(viewModel.getProjectList());

        errorLabel.setText("");
    }

    public void reset() {
        errorLabel.setText("");
        viewModel.update();
    }

    public Region getRoot() {
        return root;
    }

    @FXML
    private void createProjectButton() {
        model.setAdding(true);
        viewHandler.openView("ProjectView");
    }

    @FXML
    private void viewProjectButton() {
        try {
            ProjectViewModel selectItem = projectListTable.getSelectionModel().getSelectedItem();

            //Setting the focusProject by getting the project by its ID
            model.setFocusProject(model.getProject(selectItem.getIdProperty().get()));
            model.setAdding(false);
            viewHandler.openView("ProjectView");
        }
        catch (Exception e) {
            errorLabel.setText("Please select an item");
        }
    }

    @FXML
    private void removeProjectButton() {
        try {
            ProjectViewModel selectItem = projectListTable.getSelectionModel().getSelectedItem();

            if (confirmation()) {
                Project project = model.getProject(selectItem.getIdProperty().get());
                model.removeProject(project);
                viewModel.removeProject(project);
                projectListTable.getSelectionModel().clearSelection();
            }
        } catch (Exception e) {
            errorLabel.setText("Please select an item");
        }
    }

    public boolean confirmation() {
        ProjectViewModel selectedItem = projectListTable.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(
                "Removing the project \"" +
                        selectedItem.getNameProperty().get() + "\"\n" +
                        "with the id: " + selectedItem.getIdProperty().get()
        );

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    @FXML
    private void openRequirementList(){
        try {
            ProjectViewModel selectItem = projectListTable.getSelectionModel().getSelectedItem();

            //Setting the focusProject by getting the project by its ID
            model.setFocusProject(model.getProject(selectItem.getIdProperty().get()));
            model.setAdding(false);
            viewHandler.openView("RequirementListView");
        }
        catch (Exception e) {
            errorLabel.setText("Please select an item");
        }
    }

    // TODO add methods for employeeList

    @FXML
    private void addMemberButton() {

    }

    @FXML
    private void removeMemberButton() {

    }
}
