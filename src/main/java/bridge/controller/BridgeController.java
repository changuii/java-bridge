package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

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
        outputView.printLineBreak();
        BridgeGame bridgeGame = makeBridgeGame();
    }

    private BridgeGame makeBridgeGame() {
        outputView.printBridgeDistanceInput();
        int bridgeDistance = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeDistance);
        return BridgeGame.from(bridge);
    }

}
