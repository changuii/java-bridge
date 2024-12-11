package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.handler.RetryHandler;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final RetryHandler retryHandler;

    public BridgeController(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker,
                            final RetryHandler retryHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.retryHandler = retryHandler;
    }

    public void run() {
        outputView.printIntroduce();
        BridgeGame bridgeGame = makeBridgeGame();
        retryHandler.retryUntilSuspendOrClear(this::playGame, bridgeGame::isSuspend, bridgeGame::isClear, bridgeGame);
    }

    private void playGame(final BridgeGame bridgeGame) {
        retryHandler.retryUntilSuspendOrClear(this::move, bridgeGame::isSuspend, bridgeGame::isClear, bridgeGame);
        retry(bridgeGame);
    }

    private void move(final BridgeGame bridgeGame) {
        outputView.printMoveInput();
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPassedRoad());
    }

    private void retry(final BridgeGame bridgeGame) {
        outputView.printRetryInput();
        boolean retryCommand = inputView.readGameCommand();
        if(retryCommand){
            bridgeGame.retry();
        }
    }

    private BridgeGame makeBridgeGame() {
        outputView.printBridgeDistanceInput();
        int bridgeDistance = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeDistance);
        return BridgeGame.from(bridge);
    }

}
