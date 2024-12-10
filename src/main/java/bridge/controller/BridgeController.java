package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;
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
        BridgeGame bridgeGame = makeBridgeGame();
        User user = User.create();
    }

    public void playGame(final BridgeGame bridgeGame, final User user){
        moveUser(bridgeGame, user);
    }

    private void moveUser(final BridgeGame bridgeGame, final User user){
        outputView.printMoveInput();
        String moving = inputView.readMoving();
        bridgeGame.move(user, moving);
    }

    private BridgeGame makeBridgeGame() {
        outputView.printBridgeDistanceInput();
        int bridgeDistance = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeDistance);
        return BridgeGame.from(bridge);
    }

}
