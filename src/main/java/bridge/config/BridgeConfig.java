package bridge.config;

import bridge.component.BridgeRandomNumberGenerator;
import bridge.controller.BridgeController;
import bridge.domain.BridgeMaker;
import bridge.handler.RetryHandler;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.input.InputParser;
import bridge.view.input.InputValidator;

public abstract class BridgeConfig {

    public static BridgeController createBridgeController() {
        return new BridgeController(createInputView(), new OutputView(), createBridgeMaker(), new RetryHandler());
    }

    private static InputView createInputView() {
        return new InputView(new InputValidator(), new InputParser());
    }

    private static BridgeMaker createBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }

}
