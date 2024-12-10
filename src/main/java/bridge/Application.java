package bridge;

import bridge.config.BridgeConfig;
import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = BridgeConfig.createBridgeController();
        bridgeController.run();
    }
}
