package com.bjardon.contextfreegrammar.application.controllers.initialconfig;

import com.bjardon.contextfreegrammar.Main;
import com.bjardon.contextfreegrammar.application.controllers.AppController;
import com.bjardon.contextfreegrammar.data.models.State;
import com.bjardon.contextfreegrammar.data.models.Terminal;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by bruno on 29/03/17.
 */
public class StatesInitialConfigController extends AppController {

    @FXML
    private TextField txtName;
    @FXML
    private CheckBox chkFinal;
    @FXML
    private VBox vbxTransitions;
    @FXML
    private HBox hbxTransitionsForm;
    @FXML
    private TableView<State> tbvStates;
    @FXML
    private TableColumn<State, String> tbcStateName;
    @FXML
    private TableColumn<State, String> tbcType;
    @FXML
    private ListView<String> lsvTransitions;

    @FXML
    public void addState(ActionEvent event) {

        String name = this.txtName.getText().trim();
        boolean isFinal = chkFinal.isSelected();

        this.txtName.clear();
        this.chkFinal.setSelected(false);

        if(name.length() > 0)
            Main.getStates().add(new State(name, isFinal));

        if(Main.getStates().size() == 1)
            Main.setInitialState(Main.getStates().get(0));

    }

    @FXML
    public void saveTransitions(ActionEvent event) {

        this.hbxTransitionsForm.getChildren().forEach(node -> {
            if(((ComboBox<State>)node).getSelectionModel().getSelectedItem() != null)
                tbvStates.getSelectionModel().getSelectedItem().addTransition(new Terminal(node.getId().charAt(0)), ((ComboBox<State>)node).getSelectionModel().getSelectedItem());
            ((ComboBox)node).getSelectionModel().clearSelection();
        });

    }

    @FXML
    public void initialize() {

        tbcStateName.setCellValueFactory(state -> state.getValue().getNameProperty());
        tbcType.setCellValueFactory(state -> {
            SimpleStringProperty type = new SimpleStringProperty();
            if (state.getValue().isFinal() && state.getValue() == Main.getInitialState()) {
                type.setValue("Inicial / Aceptación");
            } else if (state.getValue().isFinal()) {
                type.setValue("Aceptación");
            } else if (state.getValue() == Main.getInitialState()) {
                type.setValue("Inicial");
            }


            return type;
        });

        Main.getAlphabet().forEach(symbol -> {

            ComboBox<State> ct = new ComboBox<>();

            ct.setItems(Main.getStates());
            ct.setId(symbol + "_transition");
            ct.setPromptText(symbol.toString());

            hbxTransitionsForm.getChildren().add(ct);
            vbxTransitions.getChildren().forEach(children -> children.setDisable(true));

        });

        tbvStates.setItems(Main.getStates());

        tbvStates.getSelectionModel().getSelectedCells().addListener(new ListChangeListener<TablePosition>() {
            @Override
            public void onChanged(Change<? extends TablePosition> c) {
                if(tbvStates.getSelectionModel().getSelectedItem() != null) {
                    vbxTransitions.getChildren().forEach(children -> children.setDisable(false));

                    lsvTransitions.getItems().clear();
                    tbvStates.getSelectionModel().getSelectedItem().getTransitions().forEach((symbol, state) -> lsvTransitions.getItems().add("delta(" + symbol.getCharacter() + ") = " + state.getName()));
                }
            }
        });

    }

}
