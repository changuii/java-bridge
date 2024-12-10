package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        outputView.printIntroduce();
    }

}
