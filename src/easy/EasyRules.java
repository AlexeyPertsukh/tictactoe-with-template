package easy;

public class EasyRules {

    private EasyRules() {
    }

    private static final int[] WIN_TEMPLATES = new int[]{
            0b000_000_000_111,
            0b000_000_111_000,
            0b000_111_000_000,

            0b000_001_001_001,
            0b000_010_010_010,
            0b000_100_100_100,

            0b000_100_010_001,
            0b000_001_010_100,
    };

     public static boolean isWin(int binaryPlayerMoves) {
        return winLine(binaryPlayerMoves) != 0;
    }

    public static int winLine(int binaryPlayerMoves) {
        for (int template : WIN_TEMPLATES) {
            int check = binaryPlayerMoves & template;
            if (check == template) {
                return template;
            }
        }

        return 0;
    }

    public static boolean isDraw(int binaryFreeMoves) {
        return (binaryFreeMoves & 0b111_111_111) == 0;
    }

}
