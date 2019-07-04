package us.circle.pineapple.admin.job;

import alpha.pineapple.ai.api.model.OFCGameState;
import us.circle.pineapple.admin.api.Game;

public class JobUtil {
    public static boolean isUselessGame(Game game) {
        String str0Dump = game.getStreet0();
        int stateCardNum = 0;
        if (str0Dump != null) {
            OFCGameState str0State = OFCGameState.fromDump(str0Dump);
            stateCardNum = str0State.cardSet().size();
        }

        if (stateCardNum == 0 && game.getStreet1() == null && game.getStreet2() == null && game.getStreet3() == null && game.getStreet4() == null) {
            return true;
        }
        return false;
    }
}
