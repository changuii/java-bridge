package bridge.component;

import bridge.domain.BridgeGame;
import bridge.dto.GameResultDto;
import bridge.dto.MapDto;

public class DtoConverter {

    public GameResultDto convertGameResultDto(final BridgeGame bridgeGame) {
        return new GameResultDto(bridgeGame.isClear(), bridgeGame.getRetryCount());
    }

    public MapDto convertMapDto(final BridgeGame bridgeGame) {
        return new MapDto(bridgeGame.getBridge(), bridgeGame.getPassedRoad());
    }
}
