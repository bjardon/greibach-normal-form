package com.bjardon.contextfreegrammar.resources;

import com.bjardon.contextfreegrammar.application.framework.Container;
import com.bjardon.contextfreegrammar.application.framework.View;
import com.bjardon.contextfreegrammar.application.framework.Window;

/**
 * Created by bruno on 23/03/17.
 */
public class ResourceLibrary {

    public final Window APP_WINDOW;
    public final Container APP_CONTAINER;

    public final View IC_ALPHABET;
    public final View IC_STATES;

    public ResourceLibrary() {
        APP_CONTAINER = new Container("/com/bjardon/contextfreegrammar/application/views/AppContainer.fxml", "Autómata");
        APP_WINDOW = new Window(APP_CONTAINER);

        IC_ALPHABET = new View("/com/bjardon/contextfreegrammar/application/views/initialconfig/AlphabetInitialConfigView.fxml", "Configuración inicial: Alfabeto");
        IC_STATES = new View("/com/bjardon/contextfreegrammar/application/views/initialconfig/StatesInitialConfigView.fxml", "Configuración inicial: Estados");
    }

}
