package bridge.controller;

import bridge.component.DtoConverter;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.handler.RetryHandler;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final RetryHandler retryHandler;
    private final DtoConverter dtoConverter;

    public BridgeController(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker,
                            final RetryHandler retryHandler, final DtoConverter dtoConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.retryHandler = retryHandler;
        this.dtoConverter = dtoConverter;
    }

    public void run() {
        outputView.printIntroduce();
        BridgeGame bridgeGame = makeBridgeGame();
        retryHandler.retryUntilSuspendOrClear(this::playGame, bridgeGame::isSuspend, bridgeGame::isClear, bridgeGame);
        outputView.printResult(dtoConverter.convertMapDto(bridgeGame), dtoConverter.convertGameResultDto(bridgeGame));
    }

    private void playGame(final BridgeGame bridgeGame) {
        retryHandler.retryUntilSuspendOrClear(this::move, bridgeGame::isSuspend, bridgeGame::isClear, bridgeGame);
        if (bridgeGame.isSuspend()) {
            retry(bridgeGame);
        }
    }

    private void move(final BridgeGame bridgeGame) {
        outputView.printMoveInput();
        String moving = handleInputException(inputView::readMoving);
        bridgeGame.move(moving);
        outputView.printMap(dtoConverter.convertMapDto(bridgeGame));
    }

    private void retry(final BridgeGame bridgeGame) {
        outputView.printRetryInput();
        boolean retryCommand = handleInputException(inputView::readGameCommand);
        if (retryCommand) {
            bridgeGame.retry();
        }
    }

    private BridgeGame makeBridgeGame() {
        outputView.printBridgeDistanceInput();
        int bridgeDistance = handleInputException(inputView::readBridgeSize);
        List<String> bridge = bridgeMaker.makeBridge(bridgeDistance);
        return BridgeGame.from(bridge);
    }

    private <T> T handleInputException(final Supplier<T> input) {
        return retryHandler.retryUntilNotException(input, outputView::printErrorMessage);
    }

}
